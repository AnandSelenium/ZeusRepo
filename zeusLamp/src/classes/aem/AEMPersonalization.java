package classes.aem;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMPersonalization {
	ArsinSeleniumAPI oASelFW;

	public AEMPersonalization(){

	}
	public AEMPersonalization(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void ClickedHeading(String header) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+header+"']")));
		oASelFW.effecta("click","//span[text()='"+header+"']","Clicked"+header);
		Thread.sleep(2000);
	}
	
	public String createPage(String page) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Create Page']")));
		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following::div/input",name,"Page Name"+name);
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[contains(text(),'Create Page')]/following::div[text()='"+page+"']","Page selected"+page);
		oASelFW.effecta("click","//span[text()='Create Page']/following::button[text()='Create']","Click Submit");
		Thread.sleep(3000);
		return name;
	}
	
	public void clickNew(String header) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+header+"']")));
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//button[contains(text(),'New')]"));
		int count = list.size();
		System.out.println("list size is:"+list.size());
		for(int i=0;i<count;i++)
		{
		if(list.get(i).isDisplayed())
		{
			list.get(i).click();
			System.out.println("clicked success..");
			break;
		}
	}
	}
	
	
	
	
	
}
