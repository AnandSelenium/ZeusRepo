package classes.aem;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;
//import com.sun.corba.se.spi.activation._ActivatorImplBase;

public class AEMCustStoryPage {
	ArsinSeleniumAPI oASelFW;

	public AEMCustStoryPage(){

	}
	public AEMCustStoryPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void verifyCreateCustomerStoryPage()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Create Customer Stories']")));
		oASelFW.effecta("verifyElementPresent","//h1[text()='Create Customer Stories']","Create Customer Stories");
		oASelFW.driver.switchTo().defaultContent();
		
	}

	public String createCustomerStory(String customerName) throws Exception
	{

		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//iframe[@id='cq-cf-frame']")))
		{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title')]/following::input[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following::input[1]",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		
		/*****************************LOCALE**********************************/
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[text()='en']","Clicked Locale");
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");
		/******************************************************************************/
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		
		oASelFW.effecta("click","//span[contains(text(),'Active')]","ClickedActive");
		
		WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();
		
		
		return name;
	}
	
	
	public String createVMMark(String customerName) throws Exception
	{

		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		String constName="VMMark";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"VMMark Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		
		/*****************************Category**********************************/
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Category')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'Performance Only')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Category')]/following::input[2]/following-sibling::img","Clicked Locale");
	/*	WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Category')]/following::input[2]"));
		el1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		/*****************************Submitter**********************************/
		WebElement element3 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Select Submitter')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element3);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'IBM')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Select Submitter')]/following::input[2]/following-sibling::img","Clicked Locale");
	/*	WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Select Submitter')]/following::input[2]"));
		el2.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		/*****************************Total Scores**********************************/
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Total Cores')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element4);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'144')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Total Cores')]/following::input[2]/following-sibling::img","Clicked Locale");
		/*WebElement el3=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Total Cores')]/following::input[2]"));
		el3.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		/*****************************Version**********************************/
		WebElement element5 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Version')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element5);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'2.5.2')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Version')]/following::input[2]/following-sibling::img","Clicked Locale");
	/*	WebElement el4=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Version')]/following::input[2]"));
		el4.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		//oASelFW.driver.switchTo().defaultContent();
		return name;
	}
	
	
	
	public String createVmMark_record(String customerName) throws Exception
	{

		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Create']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		String constName="VMMark";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"VMMark Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		
		/*****************************Category**********************************/
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Category')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'Performance Only')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Category')]/following::input[2]/following-sibling::img","Clicked Locale");
	/*	WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Category')]/following::input[2]"));
		el1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		/*****************************Submitter**********************************/
		WebElement element3 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Select Submitter')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element3);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'IBM')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Select Submitter')]/following::input[2]/following-sibling::img","Clicked Locale");
	/*	WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Select Submitter')]/following::input[2]"));
		el2.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		/*****************************Total Scores**********************************/
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Total Cores')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element4);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'144')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Total Cores')]/following::input[2]/following-sibling::img","Clicked Locale");
		/*WebElement el3=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Total Cores')]/following::input[2]"));
		el3.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		/*****************************Version**********************************/
		WebElement element5 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Version')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element5);
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[contains(text(),'2.5.2')]","Clicked Locale");
		oASelFW.effecta("click","//label[contains(text(),'Version')]/following::input[2]/following-sibling::img","Clicked Locale");
	/*	WebElement el4=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Version')]/following::input[2]"));
		el4.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");*/
		/******************************************************************************/
		
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		//oASelFW.driver.switchTo().defaultContent();
		return name;
	}
	
	
	public String createVmMark_record_Title(String customerName) throws Exception
	{

		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		//button[text()='Create']
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Create']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		String constName="VMMark";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"VMMark Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		
		
		return name;
	}
	
	
	public void createVmMark_record_EnterText(String fieldname,String value) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldname+"']/../div/input")));
		oASelFW.effecta("type","//label[text()='"+fieldname+"']/../div/input",value,fieldname);
		
	}
	

	public void createVmMark_record_PublishDate(String date) throws Exception
	{

		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/input[contains(@name,'./jcr:content/par/text/date')]")));

		//Publish Date
		oASelFW.effecta("type","//div/input[contains(@name,'./jcr:content/par/text/date')]",date,"Publish Date");
		Thread.sleep(2000);
		System.out.println("After wait");
		
	}
	
	

	public void createVmMark_record_AEMToggle() throws Exception
	{	JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		WebElement element2 = oASelFW.driver.findElement(By.xpath("	//div[@class='x-tool x-tool-toggle']"));
		executor1.executeScript("arguments[0].click();", element2);
		
		Thread.sleep(2000);
	}
	
	public void createVmMark_record_selectProperties(String fieldname,String option) throws Exception
	{	JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+fieldname+"')]/following::input[2]/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(4000);
		oASelFW.effecta("click","//div[contains(text(),'"+option+"')]",option);
		Thread.sleep(2000);
		/*oASelFW.effecta("click","//label[contains(text(),'"+fieldname+"')]/following::input[2]/following-sibling::img",fieldname);
		Thread.sleep(2000);*/
	}
	
	public void createVmMark_record_CreateButton_Click() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Create']")));
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
	}
	
	public String createCustomerStory_Uat(String customerName) throws Exception
	{

		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title')]/following::input[1]")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following::input[1]",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		
		/*****************************LOCALE**********************************/
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[text()='en']","Clicked Locale");
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");
		/******************************************************************************/
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		
		oASelFW.effecta("click","//span[contains(text(),'Active')]","ClickedActive");
		
		WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();
		return name;
	}
	
	
	
	public void click_websitesImgae()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='cq-gen36']")));
		oASelFW.effecta("clickAndWait","//button[@id='cq-gen36']","Website");
	/*	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='cq-gen34']")));
		oASelFW.effecta("clickAndWait","//button[@id='cq-gen34']","Website");*/
	}
	
	public void Search(String customerStory) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Search')]")));
		String attr=oASelFW.driver.findElement(By.xpath("//ul[@id='cq-gen71']//li[2]")).getAttribute("class");
		System.out.println("Attribute value:"+attr);
		if(attr.trim().contains("active"))
		{
			System.out.println("Already search tab is opened");
		}else
		{
			oASelFW.effecta("click","//span[contains(text(),'Search')]","Search");
		}
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Fulltext']/..//div//input",customerStory,"Customer Name:"+customerStory);
		WebElement we=oASelFW.driver.findElement(By.xpath("//label[text()='Fulltext']/..//div//input"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ENTER);
		
}
	
	public void editCustStory(String customerName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		Thread.sleep(5000);
		System.out.println("After wait");
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].setAttribute('class','x-grid3-row  x-grid3-row-first x-grid3-row-last x-grid3-row-selected')", oASelFW.driver.findElement(By.xpath("//div[@class='x-grid3-row  x-grid3-row-first x-grid3-row-last']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerName+"']"))).perform();
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[text()='Yes']","Sure");
	}
	
	public void verifyCreatedcustomerStory(String customerstoryName) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		Thread.sleep(5000);
		customerstoryName=customerstoryName.toLowerCase();
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+customerstoryName+"')]"))){
			oASelFW.effecta("sendReport","Verifying Whether Customer Story is created are not","Successfully verified.Customer Story is createrd with Name:"+customerstoryName,"Pass");
		}else{
			oASelFW.effecta("sendReportWithOutExit","Verifying Whether Customer Story is created are not","Unable to verify.Customer Story is not createrd","Fail");
		}
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void verifyCreatedcustomerStoryFrame(String customerstoryName) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		Thread.sleep(5000);
		customerstoryName=customerstoryName.toLowerCase();
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+customerstoryName+"')]"))){
			oASelFW.effecta("sendReport","Verifying Whether Customer Story is created are not","Successfully verified.Customer Story is createrd with Name:"+customerstoryName,"Pass");
		}else{
			oASelFW.effecta("sendReportWithOutExit","Verifying Whether Customer Story is created are not","Unable to verify.Customer Story is not createrd","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void clickCreatedcustomerStory(String customerstoryName) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		Thread.sleep(5000);
		customerstoryName=customerstoryName.toLowerCase();
		oASelFW.effecta("click","//a[contains(text(),'"+customerstoryName+"')]","Created Customer Clicked:-"+customerstoryName);
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void verifySearchResults_CustomerStory(String customerstoryName) throws Exception
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+customerstoryName+"')]")));
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(text(),'"+customerstoryName+"')]")))
		{
			oASelFW.effecta("sendReport","validating whether Created Customer "+customerstoryName+" is avavilable in AEM or not","Successfully verified.Customer is available with name: "+customerstoryName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether Created Customer "+customerstoryName+" is avavilable in AEM or not","Unable to verify the Customer with name: "+customerstoryName,"Fail");
		}	
	}
	
	
	public void verifySearchResults_CustomerStoryAfterRollout(String customerstoryName) throws Exception
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'"+customerstoryName+"')]")));
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h5[contains(text(),'"+customerstoryName+"')]")))
		{
			oASelFW.effecta("sendReport","validating whether Created Customer "+customerstoryName+" is avavilable in AEM or not","Successfully verified.Customer is available with name: "+customerstoryName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether Created Customer "+customerstoryName+" is avavilable in AEM or not","Unable to verify the Customer with name: "+customerstoryName,"Fail");
		}	
	}
	
	
	public void verifySearchResults_CustomerStory_H4(String customerstoryName) throws Exception
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+customerstoryName+"')]")));
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[contains(text(),'"+customerstoryName+"')]")))
		{
			oASelFW.effecta("sendReport","validating whether Created Customer "+customerstoryName+" is avavilable in AEM or not","Successfully verified.Customer is available with name: "+customerstoryName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether Created Customer "+customerstoryName+" is avavilable in AEM or not","Unable to verify the Customer with name: "+customerstoryName,"Fail");
		}	
	}
	
	
	public void vmMark_Click_UpdateListView() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Card View')]")));
		oASelFW.effecta("click","//span[contains(text(),'Card View')]","Card View");
		Thread.sleep(2000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'List View')]")))
		{
			oASelFW.effecta("sendReport","validating whether List View is displaying in AEM or not","Successfully verified Customer is List View available","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether List View is displaying in AEM or not","Successfully verified Customer is not List View available","Fail");
		}	
	}
	
	public void vmMark_Click_ListView() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Card View']/following::i[contains(@class,'viewCard')]")));
		oASelFW.effecta("click","//button[@title='Card View']/following::i[contains(@class,'viewCard')]","Card View");
		Thread.sleep(2000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[@title='Card View']/following::i[contains(@class,'viewList')]")))
		{
			oASelFW.effecta("sendReport","validating whether List View is displaying in AEM or not","Successfully verified Customer is List View available","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether List View is displaying in AEM or not","Successfully verified Customer is not List View available","Fail");
		}	
	}
	
	
	public void vmMark_select_ListViewConfigureColumns(String fieldname) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='"+fieldname+"']")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//input[@value='"+fieldname+"']"));
	
		String value=element.getAttribute("checked");
		System.out.println("checkbox..."+value);
		if(element.isSelected())
		{
			System.out.println("Checkbox checked");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked by default","Pass");
		}
		else
		{
			
			System.out.println("Checkbox is not checked");
			oASelFW.effecta("click","//input[@value='"+fieldname+"']",fieldname+" checkbox");
			System.out.println("Checkbox is checked now");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked now","Pass");
		}
		
		
	}
	
	
	public void vmMark_Click_ListViewConfigureColumns_icon() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Configure Columns']")));
		oASelFW.effecta("click","//a[@title='Configure Columns']","Configure Columns");
		Thread.sleep(2000);
		
	}
	
	
	
	

	public void vmMark_Click_ListViewConfigureColumns_Updatebutton() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Update')]")));
		oASelFW.effecta("click","//button[contains(text(),'Update')]","Update");
		Thread.sleep(2000);
		
	}
	
	public void VerifyListViewColumnvalues(String listviewcol,String listviewvlaue) throws Exception
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-title='"+listviewcol+"']/following::span[contains(text(),'"+listviewvlaue+"')]")));
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@data-title='"+listviewcol+"']/following::span[contains(text(),'"+listviewvlaue+"')]")))
		{
			oASelFW.effecta("sendReport","Verify List view VMmark record values are displaying or not","List view VMmark record value is displayed succesfully "+listviewvlaue,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify List view VMmark record values are displaying or not","List view VMmark record value is not displayed succesfully "+listviewvlaue,"Fail");
		}	
	}
	
	
	
	
	public String edit_customerStory(String customerstoryName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+customerstoryName+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerstoryName+"']"))).perform();
		Thread.sleep(2000);
		oASelFW.driver.findElement(By.xpath("//span[text()='Properties...']")).click();
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'Page Properties of')]")))
		{
			oASelFW.effecta("sendReport","clicking on Properties for Customer:"+customerstoryName,"Successfully Clciked on Properties","Pass");
		}
		else
		{
			act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerstoryName+"']"))).perform();
			Thread.sleep(2000);
			oASelFW.driver.findElement(By.xpath("//span[text()='Properties...']")).click();
		}	
		long n=(long) (Math.random()*100000);
		String custName="QACustomerStory"+n;
		oASelFW.effecta("verifyElementPresent","//label[text()='Title']/..//div/input","Title");
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::div/input",custName,"Title");
		Thread.sleep(5000);
		oASelFW.effecta("click","//button[contains(text(),'OK')]","Clicked OK");
		return custName;
	}
	
	public void delete_CustomerStory(String customerstoryName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+customerstoryName+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerstoryName+"']"))).perform();
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[text()='Yes']","Sure");
	}
	
	public void navigation()
	{
		List<WebElement> pagination =oASelFW.driver.findElements(By.xpath("//button[@id='cq-gen183']")); 
		
		// checkif pagination link exists 
		if(pagination.size()>0)
		{ 
			System.out.println("pagination exists"); 

		// click on pagination link 
		for(int i=0; i<pagination.size(); i++)
		{ 
		pagination.get(i).click(); 
		} 
		} else 
		{ 
			System.out.println("pagination not exists"); 
		} 
	}
	
	
	public void selectStoryType(String storyType)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));
		
	}
	
	public void clickOnNewItem()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));
		
	}
	
	public void clickOnAEMHeader() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(@class,'x-tab-strip-text cq-sidekick-tab cq-sidekick-tab-icon-page')]")))
		{
			System.out.println("Do nothing");
			Thread.sleep(5000);
		}else
		{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'x-window-header x-window-header-noborder x-unselectable x-window-draggable')]")));
		Actions act=new Actions(oASelFW.driver);
		act.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(@class,'x-window-header x-window-header-noborder x-unselectable x-window-draggable')]"))).doubleClick().build().perform();
		Thread.sleep(8000);
		}
		
		
	}
	
	public void clickOnPageProperties()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'x-tab-strip-text cq-sidekick-tab cq-sidekick-tab-icon-page')]")));
		oASelFW.effecta("click","//span[contains(@class,'x-tab-strip-text cq-sidekick-tab cq-sidekick-tab-icon-page')]","clicking on page properties");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Page Properties...')]")));
		oASelFW.effecta("click","//button[contains(text(),'Page Properties...')]","clicking on page properties");
	}
	
	
	public void clickOnPageProImage(String tag1,String tag2) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Target Path')]/following::img")));
		oASelFW.effecta("click","//label[contains(text(),'Target Path')]/following::img","clicking on page properties");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Target Path')]/following::img")));
		oASelFW.effecta("click","//label[contains(text(),'Target Path')]/following::img","clicking on page properties");
		clickOnTags(tag1);
		clickOnTags(tag2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'x-window-footer x-panel-btns')]/following::button")));
		oASelFW.effecta("click","//div[contains(@class,'x-window-footer x-panel-btns')]/following::button","clicking ok button");
		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Target Path')]/following::button[contains(text(),'OK')]")));
		oASelFW.effecta("click","//label[contains(text(),'Target Path')]/following::button[contains(text(),'OK')]","clicking ok button");
		Thread.sleep(6000);
		
		oASelFW.driver.switchTo().defaultContent();
		
	
		
	}
	
	public String createCustomerStory_Modified(String tagname) throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		String constName1="OVERVIEW";
		String overview=constName1+random;
		String constName2="QUOTE";
		String quote=constName2+random;
		String constName3="LINK_TITLE";
		String lTitle=constName3+random;
		
		
		
	
		/***********************TITLE**************************/
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		
		oASelFW.effecta("click","//span[contains(text(),'Active')]","Clicked"+tagname);
		
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		System.out.println("bgsdjbbhsdhf");
		System.out.println("Escape clicked");
		oASelFW.effecta("type","//label[text()='Overview']/../div/textarea",overview,"OVERVIEW");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Quote']/../div/textarea",quote,"OVERVIEW");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/***********************Collateral ADD Item**************************/
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		//JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		//JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(5000);
		/*****************STORY TYPE*************************/
		oASelFW.effecta("click","//span[contains(text(),'"+tagname+"')]","Clicked"+tagname);
		el1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/**************************LINK TITLE****************/
		oASelFW.effecta("type","//label[text()='Link Title']/../div/input",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		
	/*	*//***********************LINK URL*********************//*
		String linkUrl="/content/dam/digitalmarketing/vmware/en/pdf/Example.PDF";
		oASelFW.effecta("type","//label[text()='Link Url']/../div/div/input",linkUrl,"LINK URL");
		//we1.sendKeys(Keys.ESCAPE);
		Thread.sleep(5000);*/
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Link Url')]/following::img")));
		oASelFW.effecta("click","//label[contains(text(),'Link Url')]/following::img","clicking on img");
		
		String tags[]={"Websites","Assets","Digital Marketing","VMWare","English","PDF","Example.PDF"};
		
		for(int i=0;i<6;i++)
		{
			
			clickOnTags(tags[i]);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		oASelFW.effecta("click","//button[contains(text(),'OK')]","clicking ok button");
	
		
		oASelFW.driver.switchTo().defaultContent();
		return name;
	}
	
	
	
	public void clickOnTags(String tag) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+tag+"')]")));
		//oASelFW.effecta("click","//span[contains(text(),'"+tag+"')]","clicking on "+ tag);
		WebElement element = oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+tag+"')]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
	}
	
	
	public void clickOnTags12(String lang)
	{
		
		if(lang.equals("Chinese Simplified"))
		{
			WebElement element = oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+lang+"')]/following::span[contains(text(),'PDF')]"));
			JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
			executor1.executeScript("arguments[0].click();", element);
		}
		else
		{
		WebElement element = oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+lang+"')]/following::span[2]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		}
		
		
	}
	
	public void clickOnTags1()
	{
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//span[contains(text(),'English')]/following::span[2]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		
	}
	
	
	
	
	
	public void click_Create() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		//oASelFW.driver.switchTo().defaultContent();
	}

	public void multipleCollateral(String tagname) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		
		String constName3="LINK_TITLE";
		int random=(int) (Math.random()*100000);
		String lTitle=constName3+random;
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		WebElement element2 = oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/div/input/following-sibling::img)[2]"));
		//JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(5000);
		/*****************STORY TYPE*************************/
		WebElement element3 = oASelFW.driver.findElement(By.xpath("//div[contains(text(),'"+tagname+"')]"));
		executor1.executeScript("arguments[0].click();", element3);
	//	oASelFW.effecta("click","//span[contains(text(),'"+tagname+"')]","Clicked"+tagname);
		//element2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		/**************************LINK TITLE****************/
		oASelFW.effecta("type","xpath=(//label[text()='Link Title']/../div/input)[2]",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		/***********************LINK URL*********************/
		String linkUrl="/content/dam/digitalmarketing/vmware/en/pdf/Example.PDF";
		oASelFW.effecta("type","xpath=(//label[text()='Link Url']/../div/div/input)[2]",linkUrl,"LINK URL");
		element2.sendKeys(Keys.ESCAPE);
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();	
		oASelFW.effecta("sendReport","check whether multiple collateral are added","Successfully Multiple collateral Are Added","Pass");
	}
	
	
	public void clickScaffolding() throws Exception
	{
		System.out.println("Entered into clickScaffolding method");
		//oASelFW.effecta("click","//div[@id='cq-gen167']","Toggle Button Clicked ");
		//Thread.sleep(3000);
		oASelFW.effecta("click","//button[contains(@class,'scaffolding')]","Scaffolding Button Clicked");
		Thread.sleep(3000);
	}
	
	public String editCollateral() throws InterruptedException
	{
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		String constName3="LINK_TITLE";
		int random=(int) (Math.random()*100000);
		String lTitle=constName3+random;
		oASelFW.effecta("type","//label[text()='Link Title']/../div/input",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		oASelFW.driver.switchTo().defaultContent();
		return lTitle;
	}
	
	public void click_update() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Update']")));
		oASelFW.effecta("clickAndWait","//button[text()='Update']","Update");
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();
		oASelFW.effecta("sendReport","Clicking on Update Button","Successfully Clicked on Update Button","Pass");
	}
	
	public void verifyEditedCollateral(String collateral) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		Thread.sleep(5000);
		collateral=collateral.toUpperCase();
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//td[text()='Collaterals']/following-sibling::td/ul[contains(text(),'"+collateral+"')]")))
		{
			oASelFW.effecta("sendReport","Verifying Whether Collateral is Edited or not","Successfully verified Collateral createrd with Name:"+collateral,"Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Verifying Whether Collateral is Edited or not","Unable to verify Edited Collateral","Fail");
		}
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void deleteCollateral() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'remove')]")));
		oASelFW.effecta("clickAndWait","//button[contains(@class,'remove')]","Collateral Deleted");
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();
		oASelFW.effecta("sendReport","Clicking on Delete CollateralButton","Successfully Clicked on Delete Collateral Button","Pass");
	}
	
	
	/**--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * @author avinash_ankireddy
	 * @throws InterruptedException
	 */
	
	public void clickOnAddItem() throws InterruptedException
	{

		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		oASelFW.driver.switchTo().defaultContent();	
	}
	
	public void clickOnImageButton() throws InterruptedException
	{
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/div/input/following-sibling::img"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void verifyTagNamePresent(String tagname) throws InterruptedException
	{
		
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'"+tagname+"')]")))
		{
			oASelFW.effecta("sendReport","Verified whether tag is present or not","Successfully verified that tag is present with name: "+tagname,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Verified whether tag is present or not","verified that tag is not present with name ","Fail" );
		}	

		oASelFW.driver.switchTo().defaultContent();
	}


	public void clickOnProperitiesOfCustStory(String customerstoryName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+customerstoryName+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerstoryName+"']"))).perform();
		Thread.sleep(2000);
		oASelFW.driver.findElement(By.xpath("//span[text()='Properties...']")).click();
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'Page Properties of')]")))
		{
			oASelFW.effecta("sendReport","clicking on Properties for Customer:"+customerstoryName,"Successfully Clciked on Properties","Pass");
		}
		else
		{
			act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerstoryName+"']"))).perform();
			Thread.sleep(2000);
			oASelFW.driver.findElement(By.xpath("//span[text()='Properties...']")).click();
		}	
	}
	
	public void clickOnPagePropTab(String tabname)
	{
		
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+tabname+"')]")));
		oASelFW.effecta("click","//span[contains(text(),'"+tabname+"')]","clicking on "+ tabname);
		
	}
	
	public void verifyCustomerStoryValues(String storyType)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Story')]/following::div[contains(text(),'"+storyType+"')][1]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'Story')]/following::div[contains(text(),'"+storyType+"')][1]")))
		{
			oASelFW.effecta("sendReport","verifying story type","Successfully verified story type as "+storyType,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","verifying story type","verified that story type is not present ","Fail");
		}	
		
		
	}
	
	public void verifyCustomerLinkValues(String link, String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+link+"')]/following::input[1]")));
		
		String inputValue=	oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+link+"')]/following::input[1]")).getAttribute("value");
		
		System.out.println("***************"+ inputValue);
		System.out.println("***************"+ value);
		
		if(inputValue.equals(value))
		{
			oASelFW.effecta("sendReport","verifying link values","Successfully verified link value as "+inputValue,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","verifying link values","verified that link values are not present ","Fail");
		}	
		
		
	}
	
	public String[] createCustomerStory_Modified_Ver1(String tagname) throws Exception
	{
		
		String values[]=new String[3];
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		String constName1="OVERVIEW";
		String overview=constName1+random;
		String constName2="QUOTE";
		String quote=constName2+random;
		String constName3="LINK_TITLE";
		String lTitle=constName3+random;
		
		/***********************TITLE**************************/
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[contains(text(),'Active')]","Clicked"+tagname);
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/***********************Locale**************************/
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element4);
		Thread.sleep(5000);
		oASelFW.effecta("click","//span[contains(text(),'Customerstories Locale')]/following::span[contains(text(),'en')]","Clicked"+tagname);
		WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		WebElement we1=oASelFW.driver.findElement(By.xpath("//label[text()='Title']/../div/input"));
		Thread.sleep(2000);
		we1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");
		oASelFW.effecta("type","//label[text()='Overview']/../div/textarea",overview,"OVERVIEW");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Quote']/../div/textarea",quote,"OVERVIEW");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/***********************Collateral ADD Item**************************/
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/div/input/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(5000);
		/*****************STORY TYPE*************************/
		oASelFW.effecta("click","//div[contains(text(),'"+tagname+"')]","Clicked"+tagname);
		we1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/**************************LINK TITLE****************/
		oASelFW.effecta("type","//label[text()='Link Title']/../div/input",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		
		/***********************LINK URL*********************/
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Link Url')]/following::img[1]")));
		oASelFW.effecta("click","//label[contains(text(),'Link Url')]/following::img[1]","clicking on img");
		
		String tags[]={"Websites","Assets","Digital Marketing","VMWare","English","PDF","Example.PDF"};
		
		for(int i=0;i<7;i++)
		{
			if(i==5)
			{
				clickOnTags1();
			}else
			{
			clickOnTags(tags[i]);
			}
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		oASelFW.effecta("click","//button[contains(text(),'OK')]","clicking ok button");
		Thread.sleep(5000);
		
		values[0]=name;
		values[1]=lTitle;
		values[2]="/content/dam/digitalmarketing/vmware/en/pdf/Example.PDF";
		
		System.out.println("**********************" +values[0]);
		System.out.println("**********************" +values[1]);
		System.out.println("**********************" +values[2]);
		
		return values;
		
	}
	
	
	public String[] createCustomerStory_Modified_Ver2(String tagname) throws Exception
	{
		tagname="PDF";
		
		System.out.println("tagname : "+ tagname);
		String values[]=new String[3];
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		
		
		/*clickOnAEMHeader();
		clickOnPageProperties();
		clickOnPageProImage("lamp","customer-story-test");*/
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		String constName1="OVERVIEW";
		String overview=constName1+random;
		String constName2="QUOTE";
		String quote=constName2+random;
		String constName3="LINK_TITLE";
		String lTitle=constName3+random;
		
	
		/***********************TITLE**************************/
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		
		oASelFW.effecta("click","//span[contains(text(),'Active')]","Clicked"+tagname);
		
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		
		/***********************Locale**************************/
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		JavascriptExecutor executor4 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element4);
	
		Thread.sleep(5000);

		oASelFW.effecta("click","//span[contains(text(),'Customerstories Locale')]/following::span[contains(text(),'en')]","Clicked"+tagname);
		WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		
		
		WebElement we1=oASelFW.driver.findElement(By.xpath("//label[text()='Title']/../div/input"));
		Thread.sleep(2000);
		we1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");
		oASelFW.effecta("type","//label[text()='Overview']/../div/textarea",overview,"OVERVIEW");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Quote']/../div/textarea",quote,"OVERVIEW");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/***********************Collateral ADD Item**************************/
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		//JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/div/input/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(5000);
		/*****************STORY TYPE*************************/
		oASelFW.effecta("click","//div[contains(text(),'"+tagname+"')]","Clicked"+tagname);
		we1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/**************************LINK TITLE****************/
		oASelFW.effecta("type","//label[text()='Link Title']/../div/input",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		
		/***********************LINK URL*********************/
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Link Url')]/following::img[1]")));
		oASelFW.effecta("click","//label[contains(text(),'Link Url')]/following::img[1]","clicking on img");
		
		String tags[]={"Websites","Assets","Digital Marketing","VMWare","English","PDF","Example.PDF"};
		
		for(int i=0;i<7;i++)
		{
			
			if(i==5)
			{
				clickOnTags1();
			}else
			{
			clickOnTags(tags[i]);
			}
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		oASelFW.effecta("click","//button[contains(text(),'OK')]","clicking ok button");
		Thread.sleep(5000);
		
		//
		
		values[0]=name;
		values[1]=lTitle;
		values[2]="/content/dam/digitalmarketing/vmware/en/pdf/Example.PDF";
		
		System.out.println("**********************" +values[0]);
		System.out.println("**********************" +values[1]);
		System.out.println("**********************" +values[2]);
		
		return values;
		
	}
	
	


	public void clickOnModified() throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@class,'x-grid3-sort-icon')]/parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-modified')]")));
		oASelFW.effecta("click","//img[contains(@class,'x-grid3-sort-icon')]/parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-modified')]","Clicking on modified");
		oASelFW.effecta("click","//img[contains(@class,'x-grid3-sort-icon')]/parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-modified')]","Clicking on modified");
		oASelFW.effecta("click","//img[contains(@class,'x-grid3-sort-icon')]/parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-modified')]","Clicking on modified");
		Thread.sleep(5000);
		
	}

	
	public void verifyDownloadFile(String FilePath,String FileName,String Exn) throws InterruptedException {
		File dir = new File(FilePath);
		FileFilter fileFilter = new WildcardFileFilter("*"+FileName+"*."+Exn+"");
		File[] files = dir.listFiles(fileFilter);
		try{
			for (int i = 0; i < files.length; i++) {
				System.out.println("before Deleting files"+files[i]);
				File file = new File(String.valueOf(files[i]));
				if(file.delete()){
					System.out.println(file.getName() + " is deleted!");
				}else{
					System.out.println("Delete operation is failed.");
				}
			}
		}catch(NullPointerException ext){
			ext.printStackTrace();
		}

		Thread.sleep(3000);
		System.out.println("Delete Existing download files from Drive");
	}
	
	
	public String[] createCustomerStory_ChineseLocale(String tagname) throws Exception
	{
		
		String values[]=new String[3];
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		String constName1="OVERVIEW";
		String overview=constName1+random;
		String constName2="QUOTE";
		String quote=constName2+random;
		String constName3="LINK_TITLE";
		String lTitle=constName3+random;
		
		/***********************TITLE**************************/
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[contains(text(),'Active')]","Clicked"+tagname);
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/***********************Locale**************************/
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element4);
		Thread.sleep(5000);
		oASelFW.effecta("click","//span[contains(text(),'Customerstories Locale')]/following::span[contains(text(),'zh_cn')]","Clicked"+tagname);
		WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		WebElement we1=oASelFW.driver.findElement(By.xpath("//label[text()='Title']/../div/input"));
		Thread.sleep(2000);
		we1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");
		oASelFW.effecta("type","//label[text()='Overview']/../div/textarea",overview,"OVERVIEW");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Quote']/../div/textarea",quote,"OVERVIEW");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/***********************Collateral ADD Item**************************//*
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/div/input/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(5000);
		*//*****************STORY TYPE*************************//*
		oASelFW.effecta("click","//div[contains(text(),'"+tagname+"')]","Clicked"+tagname);
		we1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		*//**************************LINK TITLE****************//*
		oASelFW.effecta("type","//label[text()='Link Title']/../div/input",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		
		*//***********************LINK URL*********************//*
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Link Url')]/following::img[1]")));
		oASelFW.effecta("click","//label[contains(text(),'Link Url')]/following::img[1]","clicking on img");
		
		String tags[]={"Websites","Assets","Digital Marketing","VMWare","English","PDF","Example.PDF"};
		
		for(int i=0;i<7;i++)
		{
			if(i==5)
			{
				clickOnTags1();
			}else
			{
			clickOnTags(tags[i]);
			}
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		oASelFW.effecta("click","//button[contains(text(),'OK')]","clicking ok button");
		Thread.sleep(5000);
		
		values[0]=name;
		values[1]=lTitle;
		values[2]="/content/dam/digitalmarketing/vmware/en/pdf/Example.PDF";
		
		System.out.println("**********************" +values[0]);
		System.out.println("**********************" +values[1]);
		System.out.println("**********************" +values[2]);*/
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(4000);
		return values;
		
	}
	
	
	public String[] CustomerStory_Sit(String locale,String tagname,String lang,String value) throws Exception
	{
		
		String values[]=new String[3];
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		
		String constName="QACustomerStory";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		String constName1="OVERVIEW";
		String overview=constName1+random;
		String constName2="QUOTE";
		String quote=constName2+random;
		String constName3="LINK_TITLE";
		String lTitle=constName3+random;
		
		/***********************TITLE**************************/
		oASelFW.effecta("type","//label[text()='Title']/../div/input",name,"Customer Story Name");
		Thread.sleep(10000);
		System.out.println("After wait");
		/***********************STATUS**************************/
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[contains(text(),'Active')]","Clicked"+tagname);
		WebElement el1=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Status')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/***********************Locale**************************/
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element4);
		Thread.sleep(5000);
		oASelFW.effecta("click","//span[contains(text(),'Customerstories Locale')]/following::span[contains(text(),'"+locale+"')]","Clicked"+tagname);
		WebElement el2=oASelFW.driver.findElement(By.xpath("//label[contains(.,'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el2.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		WebElement we1=oASelFW.driver.findElement(By.xpath("//label[text()='Title']/../div/input"));
		Thread.sleep(2000);
		we1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");
		oASelFW.effecta("type","//label[text()='Overview']/../div/textarea",overview,"OVERVIEW");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Quote']/../div/textarea",quote,"OVERVIEW");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/***********************Collateral ADD Item**************************/
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Collateral')]/following::span[contains(text(),'Add Item')]"));
		executor1.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Story Type')]/following-sibling::div/div/div/div/div/div/div/input/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element2);
		Thread.sleep(5000);
		/*****************STORY TYPE*************************/
		oASelFW.effecta("click","//div[contains(text(),'"+tagname+"')]","Clicked"+tagname);
		we1.sendKeys(Keys.ESCAPE);
		Thread.sleep(3000);
		
		/**************************LINK TITLE****************/
		oASelFW.effecta("type","//label[text()='Link Title']/../div/input",lTitle,"LINK TITLE");
		Thread.sleep(3000);
		
		/***********************LINK URL*********************/
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Link Url')]/following::img[1]")));
		oASelFW.effecta("click","//label[contains(text(),'Link Url')]/following::img[1]","clicking on img");
		
		String tags[]={"Websites","Assets","Digital Marketing","VMWare",lang,tagname,value};
		
		for(int i=0;i<7;i++)
		{
			if(i==5)
			{
				clickOnTags12(lang);
			}else
			{
			clickOnTags(tags[i]);
			}
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		oASelFW.effecta("click","//button[contains(text(),'OK')]","clicking ok button");
		Thread.sleep(5000);
		
		values[0]=name;
		values[1]=lTitle;
		//values[2]="/content/dam/digitalmarketing/vmware/en/pdf/Example.PDF";
		
		System.out.println("**********************" +values[0]);
		System.out.println("**********************" +values[1]);
	//	System.out.println("**********************" +values[2]);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		
		return values;
		
	}
	

	
	public void clickOn_VMmark_ColumnsFilter()
	{	
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='colm-filter']")));
		oASelFW.effecta("click","//div[@class='colm-filter']","Columns");
	}
	
	public void clickOn_VMmark_ColumnsFilter_ApplyButton()
	{
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='applyColmFilter']")));
		oASelFW.effecta("click","//input[@id='applyColmFilter']","Apply");
	}
	
	public void clickOn_VMmark_ColumnsFilter_value(String fieldname)
	{
		
		oASelFW.effecta("waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='"+fieldname+"']")));
		
		WebElement element=oASelFW.driver.findElement(By.xpath("//input[@id='"+fieldname+"']"));
		String value=element.getAttribute("checked");
		if(value.contains("checked"))
		{
			System.out.println("Checkbox checked");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked by default","Pass");
		}
		else
		{
			
			System.out.println("Checkbox is not checked");
			oASelFW.effecta("click","//input[@id='"+fieldname+"']",fieldname+" checkbox");
			System.out.println("Checkbox is checked now");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked now","Pass");
		}
		
	
	}
	




}

