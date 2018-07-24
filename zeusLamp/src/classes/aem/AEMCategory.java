package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class AEMCategory {
	ArsinSeleniumAPI oASelFW;

	public AEMCategory(){

	}
	public AEMCategory(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void click_namespace(String namespace) throws Exception
	{ 
		System.out.println("entered into click_namespace method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+namespace+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.click(oASelFW.driver.findElement(By.xpath("//div[text()='"+namespace+"']"))).perform();
		oASelFW.effecta("clickAndWait","//a[@title='Create Tag']");	
		System.out.println("completed click_namespace method");
	}

	public String createTag()
	{
		System.out.println("entered into createTag method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Above";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createTag method");
		return name;
	}

	public String createIndustry()
	{
		System.out.println("entered into createIndustry method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Industry";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createIndustry method");
		return name;
	}

	public String createCountry()
	{
		System.out.println("entered into createCountry method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Country";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createCountry method");
		return name;
	}

	public String createProduct()
	{
		System.out.println("entered into createProduct method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Product";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createProduct method");
		return name;
	}

	public String createSolutions()
	{
		System.out.println("entered into createSolutions method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Solutions";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createSolutions method");
		return name;
	}

	public String createCampaigns()
	{
		System.out.println("entered into createCampaigns method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Campaigns";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createCampaigns method");
		return name;
	}

	public String createLanguage()
	{
		System.out.println("entered into createLanguage method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input[@id='tagtitle']")));
		String constName="Language";
		int random=(int) (Math.random()*1000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
		System.out.println("completed createLanguage method");
		return name;
	}

	public void click_back()
	{
		System.out.println("entered into click_back method");
		oASelFW.effecta("clickAndWait","//button[@title='Back']","Back");
		System.out.println("completed click_back method");
	}

	public String edit_tag() throws Exception
	{
		System.out.println("entered into edit_tag method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		String constName="Above";
		int random=(int) (Math.random()*100000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("click","//button[text()='Save']","Save");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		oASelFW.effecta("click","//button[text()='OK']","OK");
		Thread.sleep(4000);
		System.out.println("completed edit_tag method");
		return name;
	}

	public String editIndustry() throws Exception
	{
		System.out.println("entered into editIndustry method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		String constName="Industry";
		int random=(int) (Math.random()*10000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("click","//button[text()='Save']","Save");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		oASelFW.effecta("click","//button[text()='OK']","OK");
		Thread.sleep(4000);
		System.out.println("completed editIndustry method");
		return name;
	}

	public String editCountry() throws Exception
	{
		System.out.println("entered into editCountry method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		String constName="Country";
		int random=(int) (Math.random()*10000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("click","//button[text()='Save']","Save");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		oASelFW.effecta("click","//button[text()='OK']","OK");
		Thread.sleep(4000);
		System.out.println("completed editCountry method");
		return name;
	}

	public String editProduct() throws Exception
	{
		System.out.println("entered into editProduct method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		String constName="Product";
		int random=(int) (Math.random()*10000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("click","//button[text()='Save']","Save");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		oASelFW.effecta("click","//button[text()='OK']","OK");
		Thread.sleep(4000);
		System.out.println("completed editProduct method");
		return name;
	}

	public String editSolution() throws Exception
	{
		System.out.println("entered into editSolution method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		String constName="Solution";
		int random=(int) (Math.random()*10000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("click","//button[text()='Save']","Save");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		oASelFW.effecta("click","//button[text()='OK']","OK");
		Thread.sleep(4000);
		System.out.println("completed editSolution method");
		return name;
	}

	public String editLanguage() throws Exception
	{
		System.out.println("entered into editLanguage method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		String constName="Solution";
		int random=(int) (Math.random()*10000);
		String name=constName +random;
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input[@id='tagtitle']",name,"Title");
		oASelFW.effecta("click","//button[text()='Save']","Save");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		oASelFW.effecta("click","//button[text()='OK']","OK");
		Thread.sleep(4000);
		System.out.println("completed editLanguage method");
		return name;
	}

	public void deleteElement() throws Exception
	{
		System.out.println("entered into deleteElement method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Delete']")));
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[text()='Delete']","Element Deleted");
		Thread.sleep(3000);
		System.out.println("completed deleteElement method");

	}

	public void verify_size(String cat, String customerStory,WebDriverBackedSelenium selenium)
	{
		System.out.println("entered into verify_size method");
		try{
			oASelFW.effecta("waitForPageToLoad");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+cat+"')]/following-sibling::div//img[@class='arrow-trigger']")));
			System.out.println("before click");
			JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			selenium.clickAt("//label[contains(text(),'"+cat+"')]/following-sibling::div//img[@class='arrow-trigger']","0,0");
			System.out.println("AFter click");
			Thread.sleep(4000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span[contains(text(),'"+customerStory+"')]")));
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a/span[contains(text(),'"+customerStory.trim()+"')]")))
			{
				System.out.println("IN IF //a/span[contains(text(),'"+customerStory+"')]");

				oASelFW.effecta("sendReport","Check element present:-"+customerStory,"Element is present:-"+customerStory,"Pass");
			}
			else
			{
				System.out.println("IN ELSE //a/span[contains(text(),'"+customerStory+"')]");
				oASelFW.effecta("sendReportWithOutExit","Check element present:-"+customerStory,"Element is not present:-"+customerStory,"Fail");
			}
			System.out.println("verify_size method completed");
		}
		catch(Exception e)
		{

		}
	}

	public void verify_size_Negative(String cat, String customerStory,WebDriverBackedSelenium selenium)
	{
		System.out.println("entered into verify_size method");
		try{
			oASelFW.effecta("waitForPageToLoad");

			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+cat+"')]/following-sibling::div//img[@class='arrow-trigger']")));
			/*	System.out.println("before click");
			JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			selenium.clickAt("//label[contains(text(),'"+cat+"')]/following-sibling::div//img[@class='arrow-trigger']","0,0");
			System.out.println("AFter click");*/
			Thread.sleep(4000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span[contains(text(),'"+customerStory+"')]")));
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a/span[contains(text(),'"+customerStory.trim()+"')]")))
			{
				System.out.println("IN IF //a/span[contains(text(),'"+customerStory+"')]");

				oASelFW.effecta("sendReportWithOutExit","Check element present:-"+customerStory,"Element is present:-"+customerStory,"Fail");
			}
			else
			{
				System.out.println("IN ELSE //a/span[contains(text(),'"+customerStory+"')]");
				oASelFW.effecta("sendReport","Check element present:-"+customerStory,"Element is not present:-"+customerStory,"Pass");
			}
			System.out.println("verify_size method completed");
		}
		catch(Exception e)
		{

		}
	}
}
