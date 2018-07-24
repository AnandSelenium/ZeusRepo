package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMClassicUIPage {

	ArsinSeleniumAPI oASelFW;

	public AEMClassicUIPage(){

	}

	public AEMClassicUIPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void click_website()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Websites']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Websites']")));
		oASelFW.effecta("clickAndWait","//div[text()='Websites']","Clicked On Website");
	}
	
	public void click_mainFolder(String requiredFolder) throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+requiredFolder+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+requiredFolder+"']")));
		oASelFW.effecta("clickAndWait","//span[text()='"+requiredFolder+"']",requiredFolder);
	}
	
	//span[contains(text(),'VMForms')]/../following::a/span[text()='VMware']
	public void clickFollowingFolder(String header, String page) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+header+"')]/../following::a/span[text()='"+page+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+header+"')]/../following::a/span[text()='"+page+"']")));
		oASelFW.effecta("clickAndWait","//span[contains(text(),'"+header+"')]/../following::a/span[text()='"+page+"']",page);
	}
	
	
	
	
	public void DoubleClick_subFolder(String requiredFolder) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+requiredFolder+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+requiredFolder+"']")));
		Thread.sleep(5000);
		System.out.println("Before wait... Double click");
		
		WebElement we=oASelFW.driver.findElement(By.xpath("//span[text()='"+requiredFolder+"']"));
		Actions act=new Actions(oASelFW.driver);
		act.doubleClick(we).perform();
		System.out.println("double click done");
		
		Thread.sleep(10000);
		System.out.println("After wait for new window");
		String windows[]=oASelFW.effectaArray("getAllWindowNames");
		oASelFW.effecta("selectWindow",windows[2]);
		
	}
	
	public void LampOpenPage(String requiredFolder) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+requiredFolder+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+requiredFolder+"']")));
		Thread.sleep(5000);
		System.out.println("Before wait... Double click");
		WebElement we=oASelFW.driver.findElement(By.xpath("//span[text()='"+requiredFolder+"']"));
		Actions act=new Actions(oASelFW.driver);
		act.doubleClick(we).perform();
		System.out.println("double click done");
		Thread.sleep(10000);
	}

	public void click_Tools(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td//button[@id='cq-gen168']")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td//button[@id='cq-gen168']")));
		//oASelFW.effecta("clickAndWait","//td//button[@id='cq-gen166']","Tools");
		oASelFW.effecta("clickAndWait","//td//button[@id='cq-gen168']","Tools");
	}
	
	public void click_WebSite_Tools(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td//button[@id='cq-gen34']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td//button[@id='cq-gen34']")));
		
		oASelFW.effecta("clickAndWait","//td//button[@id='cq-gen34']","WebSite");
	}
	
	
	
	
	public void clickCustomer()
	{
		Actions act = new Actions(oASelFW.driver);
		act.moveToElement(oASelFW.driver.findElement(By.xpath("//span[text()='Create Customer']"))).doubleClick().build().perform();
	}

	public void createCustomer()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("resultsFrame")));
		oASelFW.effecta("selectFrame","resultsFrame");
		System.out.println("Entered into frame");
	}
	
	public void verifytemplate(String template)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+template+"']")));
		int count= Integer.parseInt(oASelFW.effecta("getXpathCount","//div[text()='"+template+"']"));
		System.out.println("Count is "+count);
		for(int i=1;i<=count;i++)
		{
			oASelFW.effecta("verifyElementPresent","xpath=(//div[text()='"+template+"'])["+i+"]","Template present as "+ template );
		}
		
	}
	
	public void LampOpsButton(String button) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'"+button+"')]")));
		oASelFW.effecta("click","//button[contains(text(),'"+button+"')]","Clicked"+button);
		Thread.sleep(2000);
	}
	
	public String createPage_Lamp(String page) throws Exception
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
}
