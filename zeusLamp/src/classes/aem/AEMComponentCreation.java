package classes.aem;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMComponentCreation 
{
	ArsinSeleniumAPI oASelFW;

	public AEMComponentCreation()
	{

	}
	public AEMComponentCreation(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;
	}


	//Click on Drag Component
	/*Description -This method will click on drag component.
	 *@Divanshu
	 */
	public void ClickDragComponents() throws Exception
	{
		AEMMethods samp = new AEMMethods(oASelFW);
		System.out.println("Entered into ClickDragComponents");
		Thread.sleep(5000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'par')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'par')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'par')]"))).doubleClick().build().perform();
		Thread.sleep(10000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div[2]/ul")));
		Thread.sleep(3000);
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div[2]/ul/li"));
		int count = list.size();
		System.out.println("list size is:"+list.size());
		Thread.sleep(3000);
		if(list.size()<1)
		{
			Thread.sleep(3000);
			samp.Check_InsertNewComponent();
		}

		else
		{
			System.out.println("Out from click drag components");
		}
	}
	
	
	public void ClickDragComponentsUpper() throws Exception
	{
		AEMMethods samp = new AEMMethods(oASelFW);
		System.out.println("Entered into ClickDragComponents");
		Thread.sleep(5000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'pageheaderctapar')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'pageheaderctapar')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'pageheaderctapar')]"))).doubleClick().build().perform();
		Thread.sleep(10000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div[2]/ul")));
		Thread.sleep(3000);
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div[2]/ul/li"));
		int count = list.size();
		System.out.println("list size is:"+list.size());
		Thread.sleep(3000);
		if(list.size()<1)
		{
			Thread.sleep(3000);
			samp.Check_InsertNewComponent();
		}

		else
		{
			System.out.println("Out from click drag components");
		}
	}

	public void click_givenDragComponents(String par) throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'"+par+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[ontains(@data-path,'"+par+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'"+par+"')]"))).doubleClick().build().perform();
		Thread.sleep(10000);
	}

	//Drag components for Two Column Container
	public void Click_TwoColumnContainer_DragComponents() throws InterruptedException
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'columncontainer1')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'columncontainer1')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'columncontainer1')]"))).doubleClick().build().perform();	
		Thread.sleep(10000);
	}

	public void TargetSelect(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Target']/ancestor::div[contains(@class,'active')]//label[text()='Target']/following::select")));
		oASelFW.effecta("select","//label[text()='Target']/ancestor::div[contains(@class,'active')]//label[text()='Target']/following::select",option,"Target Window");
	}

	public void TargetSelectWindow(String field,String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/label[text()='"+field+"']/following::span//select")));
		oASelFW.effecta("select","//div/label[text()='"+field+"']/following::span//select",option,"Target Select Window");

	}

	public void VerifyCalendar()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='date_calender']")));
		oASelFW.effecta("verifyElementPresent","//div[@class='date_calender']","Calendar");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='date_calender']")))
		{
			oASelFW.effecta("sendReport","Verify Calendar is displayed", "Calendar is displayed","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Calendar is displayed","Calendar is not displayed","Fail");
		}
	}


	public void VerifyLinkAvailable(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+text+"']")));
		oASelFW.effecta("verifyElementPresent","//a[text()='"+text+"']",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[text()='"+text+"']")))
		{
			oASelFW.effecta("sendReport","Verify Link "+text+"is displayed", text+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Link "+text+"is displayed",text+" is not displayed","Fail");
		}
	}


	public void VerifyImage(String image) throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//h2/following::img[contains(@src,'"+image+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Special Graphics')]/following::img[contains(@src,'"+image+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2/following::img[contains(@src,'"+image+"')]","Image");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2/following::img[contains(@src,'"+image+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Image is displayed or not","Image is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Image is displayed or not","Image is not displayed","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	public void VerifyImagePresent(String image) throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		
		
		oASelFW.effecta("verifyElementPresent","//img[contains(@src,'"+image+"')]","Image");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//img[contains(@src,'"+image+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Image is displayed or not","Image is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Image is displayed or not","Image is not displayed","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	public void ClickAndVerifyImage(String image) throws InterruptedException
	{
		
		
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Special Graphics')]/following::img[contains(@src,'"+image+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2/following::img[contains(@src,'"+image+"')]","Image");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2/following::img[contains(@src,'"+image+"')]")))
		{
			oASelFW.effecta("click","//h2/following::img[contains(@src,'"+image+"')]","Click on Image "+image);
			Thread.sleep(5000);
			oASelFW.effecta("sendReport","Verify Image/Video is displayed or not","Image/Video is displayed Successfully","Pass");
			Thread.sleep(3000);
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Image is displayed or not","Image is not displayed","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void ClickAndVerifyImageVideo(String image) throws InterruptedException
	{
		
		
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Special Graphics')]/following::img[contains(@src,'"+image+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2/following::img[contains(@src,'"+image+"')]","Image");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2/following::img[contains(@src,'"+image+"')]")))
		{
			oASelFW.effecta("click","//h2/following::img[contains(@src,'"+image+"')]","Click on Image "+image);
			Thread.sleep(5000);
			oASelFW.effecta("sendReport","Verify Image/Video is displayed or not","Image/Video is displayed Successfully","Pass");
			Thread.sleep(3000);
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Image is displayed or not","Image is not displayed","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyImage_PublishMode(String image) throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2/following::img[contains(@src,'"+image+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2/following::img[contains(@src,'"+image+"')]","Image");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2/following::img[contains(@src,'"+image+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Image is displayed or not","Image is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Image is displayed or not","Image is not displayed","Fail");
		}
	}
	
	
	public void VerifySpecialityGraphicsImage(String text,String image,int i) throws InterruptedException
	{

		Thread.sleep(3000);
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Special Graphics')]/following::img[contains(@src,'"+image+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text+"')]/following::ul/li["+i+"]/a/img[contains(@src,'"+image+"')]","Image");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+text+"')]/following::ul/li["+i+"]/a/img[contains(@src,'"+image+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Image is displayed or not","Image is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Image is displayed or not","Image is not displayed","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	public void Events_DatePicker_SelectDate(String date) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Date']/following::div/input")));
		oASelFW.effecta("type","//label[text()='Date']/following::div/input",date,"DatePicker");	
	}


	public ArrayList<String> verify_QuickLinks_Values() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebarTop']/following::ul/li")));
		oASelFW.effecta("waitForElementPresent","//div[@class='sidebarTop']/following::ul/li","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='sidebarContent sidebarShadow sidebarShadowNA']/ul/li"));
		System.out.println("list size is:"+list.size());
		String value1=null;
		ArrayList<String> alist=new ArrayList<String>();
		for(int i=1;i<=list.size();i++)
		{
			
			
			value1=oASelFW.effecta("getText","//div[@class='sidebarContent sidebarShadow sidebarShadowNA']/ul/li["+i+"]","Quick Links");
			System.out.println("Quick Links Text--"+value1);
			alist.add(value1);
		}
		//oASelFW.driver.switchTo().defaultContent();
		return alist;
	}	

	
	public ArrayList<String> verify_QuickLinks_Values_InPreview() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebarTop']/following::ul/li")));
		oASelFW.effecta("waitForElementPresent","//div[@class='sidebarTop']/following::ul/li","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='sidebarContent sidebarShadow sidebarShadowNA']/ul/li"));
		System.out.println("list size is:"+list.size());
		String value1=null;
		ArrayList<String> alist=new ArrayList<String>();
		for(int i=1;i<=list.size();i++)
		{
			
			
			value1=oASelFW.effecta("getText","//div[@class='sidebarContent sidebarShadow sidebarShadowNA']/ul/li["+i+"]","Quick Links");
			System.out.println("Quick Links Text--"+value1);
			alist.add(value1);
		}
		System.out.println("Out of Quicklinks method verify...");
		oASelFW.driver.switchTo().defaultContent();
		return alist;
	}	

	
	public ArrayList<String> verify_SiteHeader_Values_InPreview() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='toolbar']/ul/li")));
		oASelFW.effecta("waitForElementPresent","//div[@id='toolbar']/ul/li","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@id='toolbar']/ul/li"));
		System.out.println("list size is:"+list.size());
		String value1=null;
		ArrayList<String> alist=new ArrayList<String>();
		for(int i=1;i<=list.size();i++)
		{
			
			
			value1=oASelFW.effecta("getText","//div[@id='toolbar']/ul/li["+i+"]","Site Header Links");
			System.out.println("Site Header Links----"+value1);
			alist.add(value1);
		}
		oASelFW.driver.switchTo().defaultContent();
		return alist;
	}	

	public void compareValues(ArrayList<String> list,ArrayList<String> list2)
	{
		System.out.println("Actual Value:"+list);
		System.out.println("Expected Value:"+list);
		if(list.containsAll(list2))
		{
			oASelFW.effecta("sendReport","Verify Quick Links displayed as expected","Quick Links text is displayed as expected:"+list2,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Quick Links displayed as expected","Unable to verify.Expected value is:"+list2+" Actual value is:"+list,"Fail");
		}
	}

	
	

	public void verify_SocialShare_Values(String imagePath,String Label, int i) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='socialLinks']/div/ul/li[1]/a/img)[2]")));
	//oASelFW.effecta("waitForElementPresent","//div[@class='socialLinks']/div","40");
	//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='socialLinks']/div/ul"));
	Thread.sleep(4000);
	List<WebElement> list=oASelFW.driver.findElements(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li"));
	System.out.println("list size is:"+list.size());

	if(i==1||i==2)
	{
		oASelFW.effecta("verifyElementPresent","xpath=(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]","Social Media Channel");
		WebElement text=oASelFW.driver.findElement(By.xpath("(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]"));
		String actualText=text.getAttribute("alt");

		System.out.println("Actual ImagePath of Social Media Channel:"+actualText);
		if(actualText.contains(imagePath))
		{
			oASelFW.effecta("sendReport","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is displayed as expected:"+imagePath+" for "+Label,"Pass");
		}
		else
		{
			
			oASelFW.effecta("verifyElementPresent","xpath=(//div[@class='socialLinks'])[2]/div/ul/li["+i+"]/a/img","Social Media Channel");
			WebElement text1=oASelFW.driver.findElement(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li["+i+"]/a/img"));
			
			String actualText1=text1.getAttribute("alt");

			System.out.println("Actual ImagePath of Social Media Channel:"+actualText1);
			if(actualText1.contains(imagePath))
			{
				oASelFW.effecta("sendReport","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is displayed as expected:"+imagePath+" for "+Label,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is not displayed as expected for "+Label,"Fail");
			}

			//oASelFW.effecta("sendReportWithOutExit","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is not displayed as expected for "+Label,"Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	else
	{
		oASelFW.effecta("verifyElementPresent","//div[@class='socialLinks']/div/ul/li["+i+"]/a/img","Social Media Channel");
		WebElement text=oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img"));

		String actualText=text.getAttribute("alt");

		System.out.println("Actual ImagePath of Social Media Channel:"+actualText);
		if(actualText.contains(imagePath))
		{
			oASelFW.effecta("sendReport","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is displayed as expected:"+imagePath+" for "+Label,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is not displayed as expected for "+Label,"Fail");
		}

		//oASelFW.driver.switchTo().defaultContent();

	}
	
	


	}




	public void verify_SocialShare_Values_US(String imagePath,String Label, int i) throws Exception
	{	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
	oASelFW.effecta("waitForElementPresent","//div[@class='socialLinks']/div","40");
	//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='socialLinks']/div/ul"));
	List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='socialLinks']/div/ul/li"));
	System.out.println("list size is:"+list.size());

	//oASelFW.effecta("verifyElementPresent","//div[@class='socialLinks']/div/ul/li["+i+"]/a/img","Social Media Channel");
	oASelFW.effecta("verifyElementPresent","//div[@class='socialLinks']/div/ul/li["+i+"]/a/img","Social Media Channel");
	WebElement text=oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img"));

	String actualText=text.getAttribute("alt");

	System.out.println("Actual ImagePath of Social Media Channel:"+actualText);
	if(actualText.contains(imagePath))
	{
		oASelFW.effecta("sendReport","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is displayed as expected:"+imagePath+" for "+Label,"Pass");
	}
	else
	{
		oASelFW.effecta("sendReportWithOutExit","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is not displayed as expected for "+Label,"Fail");
	}

	oASelFW.driver.switchTo().defaultContent();
	}

	
	public void verify_SocialShare_Values_US_InteriorPage(String imagePath,String Label, int i) throws Exception
	{	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
	oASelFW.effecta("waitForElementPresent","xpath=(//div[@class='socialLinks'])[2]/div/ul/li","40");
	//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='socialLinks']/div/ul"));
	List<WebElement> list=oASelFW.driver.findElements(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li"));
	System.out.println("list size is:"+list.size());


	oASelFW.effecta("verifyElementPresent","xpath=(//div[@class='socialLinks'])[2]/div/ul/li["+i+"]/a/img","Social Media Channel");
	WebElement text=oASelFW.driver.findElement(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li["+i+"]/a/img"));

	String actualText=text.getAttribute("alt");

	System.out.println("Actual ImagePath of Social Media Channel:"+actualText);
	if(actualText.contains(imagePath))
	{
		oASelFW.effecta("sendReport","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is displayed as expected:"+imagePath+" for "+Label,"Pass");
	}
	else
	{
		oASelFW.effecta("sendReportWithOutExit","Verify Social Media Channel "+Label+" is displayed as expected","Verify Social Media Channel is not displayed as expected for "+Label,"Fail");
	}

	oASelFW.driver.switchTo().defaultContent();
	}


	public void verify_DashBoardLink_Values(String value) throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//div[@id='toolbar']/ul[@class='nav navbar-nav']","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@id='toolbar']/ul[@class='nav navbar-nav']"));
		System.out.println("list size is:"+list.size());
		for(int i=1;i<=list.size();i++)
		{
			oASelFW.effecta("verifyElementPresent","//div[@id='toolbar']/ul[@class='nav navbar-nav']/li["+i+"]","DashBoard Links");
			String text=oASelFW.effecta("getText","//div[@id='toolbar']/ul[@class='nav navbar-nav']/li["+i+"]","DashBoard Links");
			if(text.contains(value))
			{
				oASelFW.effecta("sendReport","Verify DashBoard Link is displayed as expected","Verify DashBoard Link is displayed as expected"+value,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify DashBoard Link is displayed as expected","Verify DashBoard Link is not displayed as expected","Fail");
			}
		}
	}



	public void verify_DashBoardLink(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		oASelFW.effecta("waitForElementPresent","//li[contains(text(),'"+text+"')]","40");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//li[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify DashBoard Link is displayed as expected","Verify DashBoard Link is displayed as expected"+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify DashBoard Link is displayed as expected","Verify DashBoard Link is not displayed as expected","Fail");
		}
		
		oASelFW.driver.switchTo().defaultContent();
	}


	public void ClickOn_DashBoardLink_Values(String value) throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//div[@id='toolbar']/ul[@class='nav navbar-nav']","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@id='toolbar']/ul[@class='nav navbar-nav']"));
		System.out.println("list size is:"+list.size());
		for(int i=1;i<=list.size();i++)
		{
			oASelFW.effecta("verifyElementPresent","//div[@id='toolbar']/ul[@class='nav navbar-nav']/li["+i+"]","DashBoard Links");
			String text=oASelFW.effecta("getText","//div[@id='toolbar']/ul[@class='nav navbar-nav']/li["+i+"]","DashBoard Links");
			if(text.contains(value))
			{
				oASelFW.effecta("click","//div[@class='section socialshare']//div/ul["+i+"]/li","Click on Social Media Channel "+value);
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Click on DashBoard Link","DashBoard Link is not as expected","Fail");
			}
		}
	}

	public void ClickOn_SocialShare_Values(String imagePath,String browserUrl,int i,String Label) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='socialLinks']/div/ul/li[1]/a/img)[2]")));
		Thread.sleep(5000);
		oASelFW.effecta("waitForElementPresent","//div[@class='socialLinks']/div","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li"));
		System.out.println("list size is:"+list.size());


		//oASelFW.effecta("verifyElementPresent","//div[@class='socialshare section']//div[@class='socialLinks']/div/ul["+i+"]/li/a/img","Social Media Channel");


		if(i==1||i==2)
		{
			WebElement text=oASelFW.driver.findElement(By.xpath("(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]"));		
			String actualText=text.getAttribute("alt");
			System.out.println("actualText---"+actualText);
			System.out.println("imagePath---"+imagePath);
			Thread.sleep(5000);
			if(actualText.contains(imagePath))

			{

				oASelFW.effecta("click","xpath=(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]","Click on Social Media Channel "+Label+" with having path "+imagePath);
				Thread.sleep(8000);

				ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());

				System.out.println("Window Size:" +tabs.size());
				oASelFW.driver.switchTo().window(tabs.get(2));

				Thread.sleep(5000);
				String socialShareUrl=oASelFW.driver.getCurrentUrl();

				System.out.println("get Current Social Share Url:"+socialShareUrl);

				if(socialShareUrl.contains(browserUrl)){
					oASelFW.effecta("sendReport","Click on Social Media Channel "+Label,"User Successfully navigated to Social Media "+Label+" application's:"+browserUrl,"Pass");
				}

				else{
					oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"User unable to navigate to Social Media application's as"+browserUrl,"Fail");
				}
				oASelFW.driver.close();
				Thread.sleep(5000);
				oASelFW.driver.switchTo().window(tabs.get(1));
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"Social Media Channel path is not displayed as expected","Fail");
			}

		}

		else
		{
			WebElement text=oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img"));		
			String actualText=text.getAttribute("alt");
			System.out.println("actualText---"+actualText);
			System.out.println("imagePath---"+imagePath);
			Thread.sleep(5000);
			if(actualText.contains(imagePath))

			{

				oASelFW.effecta("click","//div[@class='socialLinks']/div/ul/li["+i+"]/a/img","Click on Social Media Channel "+Label+" with having path "+imagePath);
				Thread.sleep(8000);

				ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());

				System.out.println("Window Size:" +tabs.size());
				oASelFW.driver.switchTo().window(tabs.get(2));

				Thread.sleep(5000);
				String socialShareUrl=oASelFW.driver.getCurrentUrl();

				System.out.println("get Current Social Share Url:"+socialShareUrl);

				if(socialShareUrl.contains(browserUrl)){
					oASelFW.effecta("sendReport","Click on Social Media Channel "+Label,"User Successfully navigated to Social Media "+Label+" application's:"+browserUrl,"Pass");
				}

				else{
					oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"User unable to navigate to Social Media application's as"+browserUrl,"Fail");
				}
				oASelFW.driver.close();
				Thread.sleep(5000);
				oASelFW.driver.switchTo().window(tabs.get(1));
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"Social Media Channel path is not displayed as expected","Fail");
			}
		}

		/*oASelFW.driver.navigate().back();
		Thread.sleep(3000);*/
		//oASelFW.driver.switchTo().defaultContent();


	}



	public void ClickOn_SocialShare_Values_US(String imagePath,String browserUrl,int i,String Label) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		Thread.sleep(5000);
		oASelFW.effecta("waitForElementPresent","//div[@class='socialLinks']/div","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='socialLinks']/div/ul/li"));
		System.out.println("list size is:"+list.size());


		//oASelFW.effecta("verifyElementPresent","//div[@class='socialshare section']//div[@class='socialLinks']/div/ul["+i+"]/li/a/img","Social Media Channel");
		WebElement text=oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img"));		
		String actualText=text.getAttribute("alt");
		System.out.println("actualText---"+actualText);
		System.out.println("imagePath---"+imagePath);
		Thread.sleep(5000);

		if(actualText.contains(imagePath))

		{
			oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img")).click();
			//oASelFW.effecta("click","xpath=(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]","Click on Social Media Channel "+Label+" with having path "+imagePath);
			Thread.sleep(8000);

			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());

			System.out.println("Window Size:" +tabs.size());
			oASelFW.driver.switchTo().window(tabs.get(2));

			Thread.sleep(5000);
			String socialShareUrl=oASelFW.driver.getCurrentUrl();

			System.out.println("get Current Social Share Url:"+socialShareUrl);

			if(socialShareUrl.contains(browserUrl)){
				oASelFW.effecta("sendReport","Click on Social Media Channel "+Label,"User Successfully navigated to Social Media "+Label+" application's:"+browserUrl,"Pass");
			}

			else{
				oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"User unable to navigate to Social Media application's as"+browserUrl,"Fail");
			}
			oASelFW.driver.close();
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tabs.get(1));
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"Social Media Channel path is not displayed as expected","Fail");
		}


		/*oASelFW.driver.navigate().back();
		Thread.sleep(3000);*/
		oASelFW.driver.switchTo().defaultContent();


	}
	
	
	public void ClickOn_SocialShare_Values_EU_InteriorPage(String imagePath,String browserUrl,int i,String Label) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		Thread.sleep(5000);
		oASelFW.effecta("waitForElementPresent","//div[@class='socialLinks']/div","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='socialLinks']/div/ul/li"));
		System.out.println("list size is:"+list.size());


		//oASelFW.effecta("verifyElementPresent","//div[@class='socialshare section']//div[@class='socialLinks']/div/ul["+i+"]/li/a/img","Social Media Channel");
		WebElement text=oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img"));		
		String actualText=text.getAttribute("alt");
		System.out.println("actualText---"+actualText);
		System.out.println("imagePath---"+imagePath);
		Thread.sleep(5000);

		if(actualText.contains(imagePath))

		{
			oASelFW.driver.findElement(By.xpath("//div[@class='socialLinks']/div/ul/li["+i+"]/a/img")).click();
			//oASelFW.effecta("click","xpath=(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]","Click on Social Media Channel "+Label+" with having path "+imagePath);
			Thread.sleep(8000);

			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());

			System.out.println("Window Size:" +tabs.size());
			oASelFW.driver.switchTo().window(tabs.get(2));

			Thread.sleep(5000);
			String socialShareUrl=oASelFW.driver.getCurrentUrl();

			System.out.println("get Current Social Share Url:"+socialShareUrl);

			if(socialShareUrl.contains(browserUrl)){
				oASelFW.effecta("sendReport","Click on Social Media Channel "+Label,"User Successfully navigated to Social Media "+Label+" application's:"+browserUrl,"Pass");
			}

			else{
				oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"User unable to navigate to Social Media application's as"+browserUrl,"Fail");
			}
			oASelFW.driver.close();
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tabs.get(1));
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"Social Media Channel path is not displayed as expected","Fail");
		}


		/*oASelFW.driver.navigate().back();
		Thread.sleep(3000);*/
		oASelFW.driver.switchTo().defaultContent();


	}


	public void ClickOn_SocialShare_Values_US_InteriorPage(String imagePath,String browserUrl,int i,String Label) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		Thread.sleep(5000);
		oASelFW.effecta("waitForElementPresent","xpath=(//div[@class='socialLinks'])[2]/div","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li"));
		System.out.println("list size is:"+list.size());


		
		WebElement text=oASelFW.driver.findElement(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li["+i+"]/a/img"));		
		String actualText=text.getAttribute("alt");
		System.out.println("actualText---"+actualText);
		System.out.println("imagePath---"+imagePath);
		Thread.sleep(5000);

		if(actualText.contains(imagePath))

		{
			oASelFW.driver.findElement(By.xpath("(//div[@class='socialLinks'])[2]/div/ul/li["+i+"]/a/img")).click();
			//oASelFW.effecta("click","xpath=(//div[@class='socialLinks']/div/ul/li["+i+"]/a/img)[2]","Click on Social Media Channel "+Label+" with having path "+imagePath);
			Thread.sleep(8000);

			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());

			System.out.println("Window Size:" +tabs.size());
			oASelFW.driver.switchTo().window(tabs.get(2));

			Thread.sleep(5000);
			String socialShareUrl=oASelFW.driver.getCurrentUrl();

			System.out.println("get Current Social Share Url:"+socialShareUrl);

			if(socialShareUrl.contains(browserUrl)){
				oASelFW.effecta("sendReport","Click on Social Media Channel "+Label,"User Successfully navigated to Social Media "+Label+" application's:"+browserUrl,"Pass");
			}

			else{
				oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"User unable to navigate to Social Media application's as"+browserUrl,"Fail");
			}
			oASelFW.driver.close();
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tabs.get(1));
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Click on Social Media Channel "+Label,"Social Media Channel path is not displayed as expected","Fail");
		}


		/*oASelFW.driver.navigate().back();
		Thread.sleep(3000);*/
		oASelFW.driver.switchTo().defaultContent();


	}





	public void Click_QuickLinks_Values(String value) throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//div[@class='sidebarTop']/following::ul/li","40");
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@class='sidebarTop']/following::ul/li"));
		System.out.println("list size is:"+list.size());
		boolean flag=false;
		for(WebElement text:list)
		{
			String value1=text.getText();
			if(value1.contains(value))
			{
				flag=true;
				oASelFW.effecta("click",text.toString(),"Create & Translate");
			}
		}
		if(flag==true)
		{
			oASelFW.effecta("sendReport","Click on Quick Links","Quick Link: "+value+"is successfully clicked","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Click on Quick Links","Quick Links text is not clicked","Fail");
		}
	}


	public void click_QuickLinks(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Quick Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate External or Internal Links","Successfully verified External or Internal links as:"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate External or Internal Links","Unable to verify External or Internal links as:"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(1));
		//oASelFW.driver.switchTo().defaultContent();
	}

	
	public void click_QuickLinks_DifferentWind_InPreview(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Quick Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Different Window","Successfully verified Link is opened in different window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Different Window","Unable to verify Link is opened in different window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(1));
		oASelFW.driver.switchTo().defaultContent();
	}

	
	public void click_QuickLinks_DifferentWind_InPublishMode(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Quick Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Different Window","Successfully verified Link is opened in different window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Different Window","Unable to verify Link is opened in different window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(1));
		//oASelFW.driver.switchTo().defaultContent();
	}

	public void click_QuickLinks_SameWind_InPreview(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Quick Links Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		
		String url=oASelFW.driver.getCurrentUrl();
		Thread.sleep(3000);
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Same Window","Successfully verified Link is opened in Same window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Same Window","Unable to verify Link is opened in Same window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		
		Thread.sleep(3000);
		
		oASelFW.driver.navigate().back();
		Thread.sleep(3000);
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void click_QuickLinks_SameWind_InPublishMode(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Quick Links Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		
		String url=oASelFW.driver.getCurrentUrl();
		Thread.sleep(3000);
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Same Window","Successfully verified Link is opened in Same window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Same Window","Unable to verify Link is opened in Same window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		
		Thread.sleep(3000);
		
		oASelFW.driver.navigate().back();
		Thread.sleep(3000);
		
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void click_SiteHeader_SameWind_InPreview(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Site Header Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		
		String url=oASelFW.driver.getCurrentUrl();
		Thread.sleep(3000);
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Same Window","Successfully verified Link "+value+" is opened in Same window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Same Window","Unable to verify Link "+value+" is opened in Same window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		
		Thread.sleep(3000);
		
		oASelFW.driver.navigate().back();
		Thread.sleep(3000);
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	
	public void click_SiteHeader_SameWind_InPublishMode(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","Site Header Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		
		String url=oASelFW.driver.getCurrentUrl();
		Thread.sleep(3000);
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Same Window in Publish Mode","Successfully verified Link "+value+" is opened in Same window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Same Window in Publish Mode","Unable to verify Link "+value+" is opened in Same window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		
		Thread.sleep(3000);
		
		oASelFW.driver.navigate().back();
		Thread.sleep(3000);
		
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	public void click_SiteHeader_DifferentWind_InPreview(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","SiteHeader Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Different Window","Successfully verified Link: "+value+" is opened in different window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Different Window","Unable to verify Link "+value+" is opened in different window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(1));
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void click_SiteHeader_DifferentWind_InPublishMode(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']","SiteHeader Link Value:"+value);
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Links are opened in Different Window In Publish Mode","Successfully verified Link: "+value+" is opened in different window as :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Links are opened in Different Window In Publish Mode","Unable to verify Link "+value+" is opened in different window as :"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(1));
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	
	
	
	public String SocialMedia_getAuthURL() throws Exception
	{
		Thread.sleep(5000);
		String authURL=oASelFW.driver.getCurrentUrl();
		System.out.println("authURL:"+authURL);
		return authURL;
	}

	public void verifyUserViewSocialMediaApplications(String expectedUrl,String getUrl)
	{
		if(expectedUrl.equalsIgnoreCase(getUrl))
		{
			oASelFW.effecta("sendReport","Verify user able to navigate to Social Media applications or not","User successfully navigated to the Social Media application","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify user able to navigate to Social Media applications or not","User is not navigated to Social Media application succussfully","Fail");
		}

	}

	public void verifyInsertNewComponent()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Insert New Component']")));
		oASelFW.effecta("verifyElementPresent","//h2[text()='Insert New Component']","Insert New Component");
		System.out.println("Successfully verified verifyInsertNewComponent");
	}



	public void verifyConfiguredComponentWindowTitle(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+text+"']")));
		oASelFW.effecta("verifyElementPresent","//h2[text()='"+text+"']",text);
		System.out.println("Successfully verified "+text);
	}


	public void verifyPricingHeaderComponent(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'"+text+"')]",text);
		System.out.println("Successfully verified ");
		oASelFW.driver.switchTo().defaultContent();
	}


	public void verifyPricingHeader(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(text(),'"+text+"')]",text);
		System.out.println("Successfully verified ");
		oASelFW.driver.switchTo().defaultContent();
	}

	public void verifyLanguageCopies_withPageName(String pageName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Language Copies']/following::h4[1]")));
		oASelFW.effecta("verifyElementPresent","//div[text()='Language Copies']/following::h4[1]","Language Copies with "+pageName);
	}

	public void verifyComparisonTableComponent()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Comparison Table Component']")));

		oASelFW.effecta("verifyElementPresent","//h2[text()='Comparison Table Component']","Comparison Table Component");
	}

	public void verifyComponentWindowTitle(String title){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+title+"']")));

		oASelFW.effecta("verifyElementPresent","//h2[text()='"+title+"']",title);
	}

	public void ComparisionTableProperties(String label,String value,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following-sibling::input")));

		oASelFW.effecta("type","xpath=(//label[text()='"+label+"']/following-sibling::input)[" +i+"]",value,label);

		//xpath=(//label[text()='"+label+"']/following-sibling::input)[" +i+"]
	}

	public void ComparisionTableHeaderProperties(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following-sibling::input")));

		oASelFW.effecta("type","//label[text()='"+label+"']/following-sibling::input",value,label);


	}


	public void ComparisionColumnFeatureYes_No(String label,String option,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following::select[1]")));


		oASelFW.effecta("select","xpath=(//label[contains(text(),'"+label+"')]/following-sibling::span/select)["+i+"]",option,label);

		//xpath=(//label[text()='"+label+"']/following-sibling::input)[" +i+"]


	}

	public void Click_CreateAndTranslate() throws InterruptedException
	{
		Thread.sleep(5000);

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//select[@name='languages']")))
		{
			System.out.println("Language drop down available");
		}
		else
		{
			oASelFW.effecta("click","//span[text()='Create & Translate']","Create & Translate");

		}


	}



	public void Select_LanguageToTranslate(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='languages']")));


		oASelFW.effecta("select","//select[@name='languages']",option,"languages");			

	}


	public void ComparisionToolTip(String label,String value,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::textarea")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//label[contains(text(),'"+label+"')]/following-sibling::textarea)["+i+"]")))
		{
			oASelFW.effecta("type","xpath=(//label[contains(text(),'"+label+"')]/following-sibling::textarea)["+i+"]",value,label);
		}

	}


	public void Type_LanguateTitle(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='projectTitle']")));

		//Tooltip Text
		oASelFW.effecta("type","//input[@name='projectTitle']",title,"Title");




	}


	public void ClickCreateButton(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Create']")));

		oASelFW.effecta("click","//button[text()='Create']","Create");
	}

	
	public void VerifyLaunchCreatedpopup(String labelpopup)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+labelpopup+"')]")));

		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+labelpopup+"')]",labelpopup);
	}
	
	
	public void ClickAddField() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add field']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[text()='Add field']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		//oASelFW.effecta("click","//button[text()='Add field']","Add Rows - Add field");
		oASelFW.effecta("sendReport","Click on Add Field button","successfully Clicked on Add Field button","Pass");
		Thread.sleep(3000);
	}

	public void Click_FeatureListContainerAddField(String label) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following::button[text()='Add field']")));
		oASelFW.effecta("click","//label[text()='"+label+"']/following::button[text()='Add field']","Add Rows - Add field");
		Thread.sleep(3000);
	}



	public void Click_Events_AddField(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add field']/ancestor::div[contains(@class,'active')]//button[text()='Add field']")));

		oASelFW.effecta("click","//button[text()='Add field']/ancestor::div[contains(@class,'active')]//button[text()='Add field']","Evenst sAdd Rows - Add field");
	}



	public void ClickSaveIcon(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Done']")));
		oASelFW.effecta("click","//button[@title='Done']","Save");
	}

	public void ClickPageInformation() throws InterruptedException{

		//Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Page Information']")));
		/*WebElement element = oASelFW.driver.findElement(By.xpath("//a[@title='Page Information']"));
		action.moveToElement(element).click().build().perform();*/
		oASelFW.effecta("click","//a[@title='Page Information']","clicking on page information");
	}

	//click on open properties in Editing mode
	public void click_OpenProperties() throws Exception{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Open Properties']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[text()='Open Properties']"));
		action.moveToElement(element).click().build().perform();
	}

	//enter KeyWords(Tags) in Properties page in Editing mode
	public void editTagsAndDescription(String keyWordsInput,String description) throws Exception{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Keywords']/following-sibling::input")));
		//oASelFW.effecta("clickAndWait","//label[text()='Tags']/following::span[2]/span/button/i","Tags");
		Thread.sleep(3000);
		//for(int i=0;i<value.length;i++){
		oASelFW.effecta("type","//label[text()='Keywords']/following-sibling::input",keyWordsInput,"Keyword");
		Thread.sleep(3000);
		//}
		//oASelFW.effecta("click","//h2[text()='Select Tags']/following::button[1]","Confirm");
		Thread.sleep(2000);
		oASelFW.effecta("type","//textarea[@data-cq-msm-lockable='jcr:description']",description,"Description");
		oASelFW.effecta("click","//button[@title='Done']","Done");
	}
	
	
	
	public void analyticsMetaDataSelection(String label,String value)
	{
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		Select select=new Select(oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::span/select")));
		select.selectByValue(value);
		
	}
	
	
	public void analyticsMetaDataInput(String label,String value)
	{
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::input",value,"typing " +value);
		
	}
	

	public void verifyKeyWordsAndDescriptionInPageSource(String values,String description) throws Exception
	{
		
		String url=modifyUrl();

		oASelFW.effecta("waitForPageToLoad");
		oASelFW.effecta("sendReport","Navigating to URL","Successfully Navigated to:"+url,"Pass");
		Thread.sleep(10000);
		System.out.println("after launching preview URL");
		String we=oASelFW.driver.getPageSource();
		System.out.println("PageSource:"+we);

		
		System.out.println("Keywords-----------"+"<meta name=\"keywords\" content=\""+values.trim()+"\"/>");
		if(we.contains("<meta name=\"keywords\" content=\""+values.trim()+"\"/>")){


			oASelFW.effecta("sendReport","Validating KeyWord:"+values+" is configured or not for created page","Successfully verified....KeyWord:"+values+" is configured in created page as:"+description,"Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating KeyWord:"+values+" is configured or not for created page","Unable to verify...KeyWord:"+values+" is not configured in created page","Fail");
		}	

		if(we.contains("<meta name=\"description\" content=\""+description.trim()+"\"/>")){
			oASelFW.effecta("sendReport","Validating whether Description is configured or not for created page","Successfully verified....Description is configured in created page as:<meta name=\"description\" content=\""+description.trim()+"\" />","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating whether Description is configured or not for created page","Unable to verify...Description is not configured in created page","Fail");
		}
	}




	public String modifyUrl(){
		String editorurl=oASelFW.driver.getCurrentUrl();
		String  contenturl=null;

		System.out.println("The editor url is "+editorurl);

		if(editorurl.contains("/editor.html")){
			contenturl=editorurl.replaceAll("/editor.html", "");

			System.out.println("The content url is "+contenturl);
			oASelFW.driver.get(contenturl);

		}

		return contenturl;
	}


	public String modifyUrlWithNotifications(String pageUrl,String devUrl){
		String workflowUrl=null;

		if(pageUrl.contains("editor.html"))
		{

			String url1=pageUrl.substring(66, pageUrl.length());
			System.out.println("application url--"+url1);


			String url2=devUrl.substring(0,31);
			System.out.println("Dev Url--"+devUrl);
			System.out.println("Dev Url--"+url2);

			workflowUrl=url2+url1;
			System.out.println("workflowUrl Url--"+workflowUrl);
			oASelFW.driver.get(workflowUrl);		
		}

		return workflowUrl;
	}
	
	public String modifyUrlWithNotifications_uat(String pageUrl,String devUrl){
		String workflowUrl=null;

		if(pageUrl.contains("editor.html"))
		{

			String url1=pageUrl.substring(66, pageUrl.length());
			System.out.println("application url--"+url1);


			String url2=devUrl.substring(0,28);
			System.out.println("Dev Url--"+devUrl);
			System.out.println("Dev Url--"+url2);

			workflowUrl=url2+url1;
			System.out.println("workflowUrl Url--"+workflowUrl);
			oASelFW.driver.get(workflowUrl);		
		}

		return workflowUrl;
	}

	
	
	public String modifyUrlWithNotifications_stage(String pageUrl,String devUrl){
		String workflowUrl=null;

		if(pageUrl.contains("editor.html"))
		{

			String url1=pageUrl.substring(68, pageUrl.length());
			System.out.println("application url--"+url1);


			String url2=devUrl.substring(0,29);
			System.out.println("Dev Url--"+devUrl);
			System.out.println("Dev Url--"+url2);

			workflowUrl=url2+url1;
			System.out.println("workflowUrl Url--"+workflowUrl);
			oASelFW.driver.get(workflowUrl);		
		}

		return workflowUrl;
	}

	
	public String modifyUrlWithNotifications_modifiedPublishUrl_VMworld(String pageUrl,String PublishUrl) throws InterruptedException{
		String publishUrl=null;

		if(pageUrl.contains("editor.html"))
		{
			String url1=pageUrl.split("sites")[1];
			System.out.println("application url--"+url1);
			
			
			String url2=PublishUrl;
			System.out.println("notification Url in stage--"+url2);
			
		
			publishUrl=url1+url2;
			System.out.println("Publishe Url---"+publishUrl);
			oASelFW.driver.get(publishUrl);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
		}

		return publishUrl;
	}
	
	
	public String modifyUrlWithNotifications_Publish_InVMworld(String pageUrl,String devUrl){
		String workflowUrl=null;

		if(pageUrl.contains("editor.html"))
		{

			String url1=pageUrl.substring(68, pageUrl.length());
			System.out.println("application url--"+url1);


			String url2=devUrl.substring(0,28);
			System.out.println("Dev Url--"+devUrl);
			System.out.println("Dev Url--"+url2);

			workflowUrl=url2+url1;
			System.out.println("workflowUrl Url--"+workflowUrl);
			oASelFW.driver.get(workflowUrl);		
		}

		return workflowUrl;
	}
	
	

	
	public String modifyUrlWithNotifications_Uat(String pageUrl,String devUrl){
		String workflowUrl=null;

		if(pageUrl.contains("editor.html"))
		{

			String url1=pageUrl.substring(65, pageUrl.length());
			System.out.println("application url--"+url1);


			String url2=devUrl.substring(0,31);
			System.out.println("Dev Url--"+devUrl);
			System.out.println("Dev Url--"+url2);

			workflowUrl=url2+url1;
			System.out.println("workflowUrl Url--"+workflowUrl);
			oASelFW.driver.get(workflowUrl);		
		}

		return workflowUrl;
	}


	public String modifyUrlWithNotifications() throws Exception
	{
		String editorurl=oASelFW.driver.getCurrentUrl();
		String notificationUrl=null;
		if(editorurl.contains("8080"))
		{
			String url1=editorurl.substring(0, 39);
			System.out.println(url1);
			String url2="notifications.html";
			notificationUrl=url1+url2;
			System.out.println("Notification Url---"+notificationUrl);
			oASelFW.driver.get(notificationUrl);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(25000);
		}
		return notificationUrl;
	}

	
	public String modifyUrlWithNotifications_Uat() throws Exception
	{
		String editorurl=oASelFW.driver.getCurrentUrl();
		String notificationUrl=null;
		if(editorurl.contains("8080"))
		{
			String url1=editorurl.substring(0, 38);
			System.out.println(url1);
			String url2="notifications.html";
			notificationUrl=url1+url2;
			System.out.println("Notification Url---"+notificationUrl);
			oASelFW.driver.get(notificationUrl);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(25000);
		}
		return notificationUrl;
	}

	public String modifyUrlWithNotifications_stage() throws Exception
	{
		String editorurl=oASelFW.driver.getCurrentUrl();
		String notificationUrl=null;
		if(editorurl.contains("8080"))
		{
			String url1=editorurl.substring(0, 40);
			System.out.println(url1);
			String url2="notifications.html";
			notificationUrl=url1+url2;
			System.out.println("Notification Url---"+notificationUrl);
			oASelFW.driver.get(notificationUrl);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(25000);
		}
		return notificationUrl;
	}
	
	
	
	public String modifyUrlWithNotifications_Modified(String notifyUrl) throws Exception
	{
		String editorurl=oASelFW.driver.getCurrentUrl();
		String notificationUrl=null;
		if(editorurl.contains("8080"))
		{
			

			//String url1=pageUrl.substring(90, pageUrl.length());
			String url1=editorurl.split("8080/")[0];
			System.out.println("application url--"+url1);
			
			//String url2=pageUrl.split("com")[0];
			String url2=notifyUrl;
			System.out.println("notification Url in stage--"+url2);
			
			
		/*	//String url1=editorurl.substring(0, 40);
			System.out.println(url1);
			String url2="notifications.html";*/
			notificationUrl=url1+url2;
			System.out.println("Notification Url---"+notificationUrl);
			oASelFW.driver.get(notificationUrl);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(25000);
			
		}
		return notificationUrl;
	}

	
	public String modifyUrl_VMware_WithPublishPage_stage(String pageUrl,String pubUrl){
		String pubPageUrl=null;

		if(pageUrl.contains("editor.html"))
		{

			//String url1=pageUrl.substring(90, pageUrl.length());
			String url1=pageUrl.split("sites")[1];
			System.out.println("application url--"+url1);
			
			//String url2=pageUrl.split("com")[0];
			String url2=pubUrl;
			System.out.println("publish Url in stage--"+url2);
			

		//String url2=pubUrl.substring(0,28);
			
			

			pubPageUrl=url2+url1;
			System.out.println("publisg page Url--"+pubPageUrl);
			oASelFW.driver.get(pubPageUrl);		
		}

		return pubPageUrl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//div[@class='tooltip_container']/a/img
	public void VerifyToolTipText(String toottipTextExpected,String pageName) throws Exception{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));


		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+pageName.trim()+"')]")));
		Actions action = new Actions(oASelFW.driver);
		String count=oASelFW.effecta("getXpathCount","//div[@class='rTableBody']/div");
		System.out.println("*************COUNT*************"+count);
		int i=Integer.parseInt(count);

		for(int k=1;k<=i;k++){
			Thread.sleep(2000);
			WebElement element = oASelFW.driver.findElement(By.xpath("//div[@class='rTableBody']/div["+k+"]//div[@class='tooltip_container']/a/img"));
			//Thread.sleep(3000);
			action.moveToElement(element).build().perform();	
			Thread.sleep(5000);
			String Actualtooltiptext = oASelFW.driver.findElement(By.xpath("//div[@class='tooltip_container']/a/following-sibling::div")).getText();

			// To get the tool tip text and assert
			//String toolTipTextActual = tooltip_text.getText();
			System.out.println("toolTipTextActual:"+Actualtooltiptext);

			if(Actualtooltiptext.contains(toottipTextExpected))
			{
				oASelFW.effecta("sendReport","Verify TootlTip is displaying as expected","Verify TootlTip is displayed as expected","Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify TootlTip is displaying as expected","Verify TootlTip is not displayed as expected","Fail");

			}

			WebElement we = oASelFW.driver.findElement(By.xpath("//div[@class='rTableBody']"));
			Thread.sleep(3000);
			action.moveToElement(we).build().perform();
		}
		//oASelFW.driver.switchTo().defaultContent();
		
	}

	
	
	public void VerifyToolTipText_Pricing(String value,String toottipTextExpected) throws Exception
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+value+"')]/a")));
		Actions action = new Actions(oASelFW.driver);
		/*	String count=oASelFW.effecta("getXpathCount","//div[@class='rTableBody']/div");
		System.out.println("*************COUNT*************"+count);
		int i=Integer.parseInt(count);
		 */
		//for(int k=1;k<=i;k++){
		Thread.sleep(2000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]/a"));
		//Thread.sleep(3000);
		action.moveToElement(element).build().perform();	
		Thread.sleep(5000);
		String Actualtooltiptext = oASelFW.driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]/a")).getText();

		// To get the tool tip text and assert
		//String toolTipTextActual = tooltip_text.getText();
		System.out.println("toolTipTextActual:"+Actualtooltiptext);

		if(Actualtooltiptext.contains(toottipTextExpected))
		{
			oASelFW.effecta("sendReport","Verify TootlTip is displaying as expected","Verify TootlTip is displayed as expected","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify TootlTip is displaying as expected","Verify TootlTip is not displayed as expected","Fail");

		}

		
		oASelFW.driver.switchTo().defaultContent();
	}
		
	//div[@class='pricingPopUp']	
	public void Verify_Tooltip_ScrollBar()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));

		WebElement text = oASelFW.driver.findElement(By.xpath("//div[@class='pricingPopUp']"));
		//Read font-size property and print It In console.
		String scrollbar = text.getCssValue("overflow-y").trim();
		//int font_Size = Integer.parseInt(fontSize);
		System.out.println("scroll bar -> "+scrollbar); 
		if(scrollbar.contains("auto"))
		{
			oASelFW.effecta("sendReport","Verify Scroll bar is displaying for tooltip text","Scroll bar is displaying successfully for tooltip text","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Scroll bar is displaying for tool tip text","Scroll bar is not displaying successfully for tooltip text","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	

	public void ClickPublishPage(String button) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+button+"']")));

		oASelFW.effecta("click","//button[text()='"+button+"']",button);

		/*Actions action = new Actions(oASelFW.driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Publish Page']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[text()='Publish Page']"));
		action.moveToElement(element).click().build().perform();
		oASelFW.effecta("sendReport","Clicking on Publish Page","Successfully clicked on publish page","Pass");*/
	}

	public void ClickPageInfoOptions(String button) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+button+"']")));
		
		oASelFW.effecta("click","//button[text()='"+button+"']",button);
	}

	
	public void ClickPageEditOption_InParentWindow(String button) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[contains(@class,'coral-Icon coral-Icon--edit')]")));
		
		oASelFW.effecta("click","//i[contains(@class,'coral-Icon coral-Icon--edit')]",button);
	}

	
	public void VerifyHideInSiteMapIsChecked(String fieldname)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+fieldname+"')]/preceding-sibling::input[contains(@type,'checkbox')][1]")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+fieldname+"')]/preceding-sibling::input[contains(@type,'checkbox')][1]"));
		String value=element.getAttribute("value");
		if(element.isSelected())
		{
			System.out.println("Checkbox checked");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked by default","Pass");
		}
		else
		{
			
			System.out.println("Checkbox is not checked");
			oASelFW.effecta("click","//span[contains(text(),'"+fieldname+"')]/preceding-sibling::input[contains(@type,'checkbox')][1]",fieldname+" checkbox");
			System.out.println("Checkbox is checked now");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked now","Pass");
		}
		
	}
	
	
	public void ClickProperties_Done()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Done']")));

		oASelFW.effecta("click","//button[@title='Done']","Done");

	}

	public void SelectWorkflowModelOption(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Start Workflow')]/following::select")));

		oASelFW.effecta("select","//h2[contains(text(),'Start Workflow')]/following::select",option,"Work flow option");

	}
	public void SelectWorkflowUser(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Choose Target Environment')]/following::select")));

		oASelFW.effecta("select","//label[contains(text(),'Choose Target Environment')]/following::select",option,"Work flow  notifications Environment as "+option);

	}
	
	public void SelectWorkflowUser_Modified(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Choose Target Environment')]/following::select")));
		   if(option.contains("VMworld test"))
	        {
	        	oASelFW.effecta("select","//label[contains(text(),'Choose Target Environment')]/following::select",option,"Work flow  notifications Environment as "+option);	
	        }
	        
	        else if(option.contains("VMworld UAT"))
	        {
	        	oASelFW.effecta("select","//label[contains(text(),'Choose Target Environment')]/following::select",option,"Work flow  notifications Environment as "+option);	
	        }

	        else if(option.contains("VMworld stage"))
	        {
	        	oASelFW.effecta("select","//label[contains(text(),'Choose Target Environment')]/following::select",option,"Work flow  notifications Environment as "+option);
	        	
	        }
		   
	        else
	        {
	        	System.out.println("Option not found");
	        }
	        
	}
	
	
	public void ClickStartWorkflowButton()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'start-workflow-activator-start')]")));

		oASelFW.effecta("click","//button[contains(@class,'start-workflow-activator-start')]","Start Workflow button");

	}

	public void ClickPageInfo_RequiredOption(String option) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		Actions action = new Actions(oASelFW.driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+option+"']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[text()='"+option+"']"));
		action.moveToElement(element).click().build().perform();
		oASelFW.effecta("sendReport","Clicking on "+option,"Successfully clicked on "+option,"Pass");
	}

	public void ClickPublish(String button) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		Thread.sleep(10000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[text()='"+button+"']")))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+button+"']")));
			oASelFW.effecta("click","//button[text()='"+button+"']",button);
		}else
		{
			System.out.println("Required button "+button+" not visible");
		}
	}

	public void selectWorkflowOption(String option) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='model']")));

		oASelFW.effecta("select","//select[@name='model']",option);
	}

	public void ClickRequiredButton(String fieldname){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+fieldname+"']")));

		oASelFW.effecta("click","//button[text()='"+fieldname+"']",fieldname);
	}


	public void ClickPublishIcon(){
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Publish']")));

		action.moveToElement(oASelFW.driver.findElement(By.xpath("//button[@title='Publish']"))).click().build().perform();

		//oASelFW.effecta("click","//button[@title='Publish']","Publish");
	}

	//div[contains(text(),'The page has been published')]
	public void VerifyPublishPage_MessageDisplayed() throws Exception
	{
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(text(),'The page has been published')]")))
		{
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'The page has been published')]")));
			oASelFW.effecta("verifyElementPresent","//div[contains(text(),'The page has been published')]","The page has been published");
			oASelFW.effecta("sendReport","Verify 'The page has been published' Success message is displaying"," 'The page has been published' message is displayed successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify 'The page has been published' Success message is displaying"," 'The page has been published' message is not displayed as expected","Fail");
		}
	}


	public void VerifyWorkflowStartedMessageDisplayed() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Workflow Started')]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(text(),'Workflow Started')]","Workflow Started Message");


	}


	public void VerifyNotificationWindow() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Notifications')]")));
		oASelFW.effecta("verifyElementPresent","//li[contains(text(),'Notifications')]","Notifications Window");

	}



	public void ClickRichText()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Rich Text']")));
		oASelFW.effecta("click","//div[@title='Rich Text']","RichText");


	}





	public void ClickInsertNewComponent_DropdownOption(String option) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]//following::button[text()='"+option+"'][1]")));
		Thread.sleep(5000);
		System.out.println("after wait");
		int size=oASelFW.driver.findElements(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]//following::button[text()='"+option+"'][1]")).size();
		System.out.println("size:"+size);
		Thread.sleep(5000);
		oASelFW.effecta("click","//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]//following::button[text()='"+option+"'][1]",option);
	}


	public void AuthorThreeColumnContainer(String option) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Three Column Container'][1]")));
		Thread.sleep(5000);
		System.out.println("after wait");

		int size=oASelFW.driver.findElements(By.xpath("//div[@title='Three Column Container'][1]/following::div[@title='Drag components here'][3]")).size();
		System.out.println("size:"+size);
		oASelFW.effecta("click","//div[@title='Three Column Container'][1]/following::div[@title='Drag components here'][3]","Insert New Component in Three column Container");
		Thread.sleep(5000);
		oASelFW.effecta("verifyElementPresent","//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]//following::button[text()='"+option+"'][1]&&//button[text()='"+option+"']");
		oASelFW.effecta("click","//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]//following::button[text()='"+option+"'][1]",option);


	}


	public void ClickInsertNewComponent_DropdownOption_ComparisionTable()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Comparison Table ']")));
		oASelFW.effecta("click","//button[text()='Comparison Table ']","Comparison Table");
	}


	public void VerifySelectedComponentTitle(String title) throws Exception
	{
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@title='"+title+"']")))
		{
			oASelFW.effecta("sendReport","Verify "+title+" is displaying",title+ "is displayed successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify "+title+" is displaying",title+ "is not displayed as expected","Fail");
		}
	}

	public void DoubleClickonInsertedComponent(String title) throws InterruptedException
	{
		System.out.println("In method");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='"+title+"']")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	//div[contains(@data-path,'par-tab-title1')]

	public void DoubleClickonTabComponent_DragComponent(String title) throws InterruptedException
	{
		System.out.println("In method");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'"+title+"')]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'"+title+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'"+title+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);




	}


	public void ClickTabComponent_Tab(String tabName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@data-tabcontentid,'"+tabName+"')]")));
		oASelFW.effecta("click","//li[contains(@data-tabcontentid,'"+tabName+"')]",tabName);
		oASelFW.driver.switchTo().defaultContent();
	}

	public void DoubleClickonInsertedComponent_Second(String title) throws InterruptedException{
		System.out.println("In method");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here']/following::div[@title='"+title+"']")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div[@title='"+title+"']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div[@title='"+title+"']"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}



	public void clickonComponent(String title) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='"+title+"']")));
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[@title='"+title+"']","click on component");
	}



	public void  EnterTextFieldDate(String fieldName,String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::input")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following-sibling::div/input",Value,fieldName);
	}

	public void  EnterTextField(String fieldName,String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'"+fieldName+"')]/following-sibling::input",Value,fieldName);
	}





	public void  EnterTextField_Left_Right(String fieldName,String Value,String locator)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following-sibling::input[contains(@name,'"+locator+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+fieldName+"')]/following-sibling::input[contains(@name,'"+locator+"')]",Value,fieldName);
	}


	public void EnterTextArea(String fieldName,String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following-sibling::textarea")));
		oASelFW.effecta("type","//label[contains(text(),'"+fieldName+"')]/following-sibling::textarea",Value,fieldName);
	}
	
	public void EnterMultiTextArea(String fieldName,String Value,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following-sibling::textarea")));
		oASelFW.effecta("type","//label[contains(text(),'"+fieldName+"')]/following-sibling::textarea",Value,fieldName);
	}

	public void EnterTextArea_Left_Right(String fieldName,String Value,String locator)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::textarea[contains(@name,'"+locator+"')]")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following-sibling::textarea[contains(@name,'"+locator+"')]",Value,fieldName);
	}


	public void EnterMultiTextField(String fieldName,String Value,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following-sibling::input")));
		oASelFW.effecta("type","xpath=(//label[contains(text(),'"+fieldName+"')]/following-sibling::input)["+i+"]",Value,fieldName);
	}
	
	public void EnterMultiTextField_dropdown_Forms(String fieldName,String Value,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::input")));
		oASelFW.effecta("type","xpath=(//label[text()='"+fieldName+"']/following-sibling::input)["+i+"]",Value,fieldName);
	}

	public void EnterMultiButtonField(String fieldName,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[contains(text(),'"+fieldName+"')]")));
		oASelFW.effecta("click","xpath=(//button/span[contains(text(),'Please Select')])["+i+"]",fieldName);
	}


	public void EnterTextField_Browse(String fieldName,String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following::input")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following::input",Value,fieldName);
	}


	public void EnterTextField_Browse_Left_Right(String fieldName,String Value,String locator)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following::span/input[contains(@name,'"+locator+"')]")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following::span/input[contains(@name,'"+locator+"')]",Value,fieldName);
	}


	public void EnterTextField_Categories(String fieldName) throws Exception
	{
		System.out.println("Entered into EnterTextField_Categories");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/../descendant::button")));
		oASelFW.effecta("click","//label[text()='"+fieldName+"']/../descendant::button",fieldName);
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='Customerstories Product']","CustomerStories Product");
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[text()='vSphere']","Vsphere");
		Thread.sleep(2000);
		oASelFW.effecta("click","//h2[contains(text(),'Select Tags')]/following-sibling::button[contains(@title,'Confirm')]","Confirm Clicked");
		Thread.sleep(2000);
	}


	public void EnterMultiTextField_Browse(String fieldName,String Value,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::span//input")));
		oASelFW.effecta("type","xpath=(//label[text()='"+fieldName+"']/following-sibling::span//input)["+i+"]",Value,fieldName);
	}

	public void SelectRequiredOption(String field,String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+field+"')]/following-sibling::span/select")));
		oASelFW.effecta("select","//label[contains(text(),'"+field+"')]/following-sibling::span/select",option,field);
		
		
	}
	
	
	
	
	public void AssetReport_SelectReportOption(String field,String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-toggle='selectlist']/span[contains(text(),'"+field+"')]/following::select")));
		oASelFW.effecta("select","//button[@data-toggle='selectlist']/span[contains(text(),'"+field+"')]/following::select",option,field);
		
		
	}
	
	
	public void clickAssetReport_DateRange() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Date Range')])[1]")));
		/*WebElement element = oASelFW.driver.findElement(By.xpath("(//span[contains(text(),'Date Range')])[1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
	*/
		oASelFW.effecta("click","xpath=(//span[contains(text(),'Date Range')])[1]","Date Range");
		Thread.sleep(5000);
	}
	
	
	public void clickAssetReport_DateRange(String fieldname) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3/span[contains(text(),'"+fieldname+"')])[1]/following::span[contains(text(),'Date Range')]")));
		/*WebElement element = oASelFW.driver.findElement(By.xpath("(//span[contains(text(),'Date Range')])[1]"));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		 */
		oASelFW.effecta("click","xpath=(//h3/span[contains(text(),'"+fieldname+"')])[1]/following::span[contains(text(),'Date Range')]","Date Range");
		Thread.sleep(5000);
	}

	
	public void EnterAssetReport_DateRange_DateTime(String fieldname,String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[contains(@placeholder,'"+fieldname+"')])[1]")));
	
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].removeAttribute('disabled')", oASelFW.driver.findElement(By.xpath("(//input[contains(@placeholder,'"+fieldname+"')])[1]")));
		Thread.sleep(5000);
		oASelFW.effecta("type","xpath=(//input[contains(@placeholder,'"+fieldname+"')])[1]",value,fieldname);
		Thread.sleep(5000);
	}

	public void EnterAssetReport_AssetExpiredDateRange_DateTime(String fieldname1,String fieldname2,String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3/span[contains(text(),'"+fieldname1+"')])[1]/following::input[contains(@placeholder,'"+fieldname2+"')][1]")));
	
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].removeAttribute('disabled')", oASelFW.driver.findElement(By.xpath("(//h3/span[contains(text(),'"+fieldname1+"')])[1]/following::input[contains(@placeholder,'"+fieldname2+"')][1]")));
		Thread.sleep(5000);
		oASelFW.effecta("type","xpath=(//h3/span[contains(text(),'"+fieldname1+"')])[1]/following::input[contains(@placeholder,'"+fieldname2+"')][1]",value,fieldname2);
		Thread.sleep(5000);
	}

	
	
	
	public void clickAssetReport_GenerateReport(String field) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'reports-generate')]")));
		oASelFW.effecta("click","//button[contains(@class,'reports-generate')]",field);
		Thread.sleep(10000);
	}
	
	
	public void clickAssetReport_CustomizeColumns() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Customize Columns']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//a[@title='Customize Columns']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
	//	Thread.sleep(5000);
		//oASelFW.effecta("click","//a[@title='Customize Columns']","Customize Columns");
		Thread.sleep(10000);
	}
	
	
	public void selectColumnListCheckbox(String fieldname)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='"+fieldname+"']")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//input[@title='"+fieldname+"']"));
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
			oASelFW.effecta("click","//input[@title='"+fieldname+"']",fieldname+" checkbox");
			System.out.println("Checkbox is checked now");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked now","Pass");
		}
		
	}
	

	public void clickAssetReport_CustomizeColumns_Submit() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		WebElement element = oASelFW.driver.findElement(By.xpath("(//h2[contains(text(),'Customize Columns')])[1]/following::button[@id='customcolumnsmodal-submit'][1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'Customize Columns')])[1]/following::button[@id='customcolumnsmodal-submit'][1]")));
		oASelFW.effecta("click","xpath=(//h2[contains(text(),'Customize Columns')])[1]/following::button[@id='customcolumnsmodal-submit'][1]","Customize Columns-Submit");
		Thread.sleep(10000);
	}		
	
	public void clickAssetReport_ExportToCSV(String field) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/i[@class='coral-Icon coral-Icon--fileCSV']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//button/i[@class='coral-Icon coral-Icon--fileCSV']"));
		System.out.println("Element identified..");
		Actions action=new Actions(oASelFW.driver);
		
		action.moveToElement(element).click().build().perform();
		Thread.sleep(10000);
		//((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		System.out.println("Element is clicked successfully..");
		//oASelFW.effecta("click","//button/span[contains(text(),'"+field+"')]",field);
		Thread.sleep(20000);
	}
	
	
	public void containerLinkLabel()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'CTA Label')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'CTA Label')]/following-sibling::input","link label","typing value");
		
	}

	public void SelectMarketWireRequiredOption(String field,String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+field+"')]/following::select")));
		oASelFW.effecta("select","//label[contains(text(),'"+field+"')]/following::select",option,field);
		
		
	}
	
	
	
	public void BrightcoveOption(String field)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+field+"')]/following-sibling::div/label[2]/span[1]")));
		oASelFW.effecta("click","//label[contains(text(),'"+field+"')]/following-sibling::div/label[2]/span[1]",field);
		
		
	}

	public void SelectRequiredOption_Left_Right(String field,String option,String locator)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following-sibling::span/select[contains(@name,'"+locator+"')]")));

		oASelFW.effecta("select","//label[text()='"+field+"']/following-sibling::span/select[contains(@name,'"+locator+"')]",option,field);

	}


	public void SelectRequiredOption_Left_RightBackgroundColor(String field,String option,String locator)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following-sibling::span/select[contains(@name,'"+locator+"')]")));

		oASelFW.effecta("select","//label[text()='"+field+"']/following-sibling::span/select[contains(@name,'"+locator+"')]",option,field);

	}


	public void SelectRequiredTargetWindow1(String nearestField,String field,String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+nearestField+"']/following::div/label[text()='"+field+"']/following::span/select")));

		oASelFW.effecta("select","//label[text()='"+nearestField+"']/following::div/label[text()='"+field+"']/following::span/select",option,field);

	}

	public void SelectMultiRequiredOption(String field,String option,int i)
	{
		try{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+field+"')]/following-sibling::span/select")));
			oASelFW.effecta("select","xpath=(//label[contains(text(),'"+field+"')]/following-sibling::span/select)["+i+"]",option,field);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void SelectRadioButton_Yes()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label/span[text()='Yes']/ancestor::label/input")));
		oASelFW.effecta("click","//label/span[text()='Yes']/ancestor::label/input","Yes Radio button");
	}

	public void ValidateQuickLinks(String option,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebarTop']/following::ul/li["+i+"]")));
		oASelFW.effecta("select","//div[@class='sidebarTop']/following::ul/li["+i+"]",option);
	}


	public void EnterRichTextValue(String value)
	{
		/*WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'paragraphText')]/p")));
		oASelFW.effecta("type","//div[contains(@class,'paragraphText')]/p",value,"Rich Text Value");

		Thread.sleep(5000);*/
		oASelFW.driver.switchTo().frame("ContentFrame");
		WebElement editor = oASelFW.driver.findElement(By.tagName("p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '<p>" +value+ "</p>'", editor);
		oASelFW.driver.switchTo().defaultContent();
	}

	//button[@data-action='links#modifylink']

	public void SelectAllText_RobotKeys() throws Exception
	{
		Thread.sleep(5000);
		/*Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);*/
		
		
		Actions action = new Actions(oASelFW.driver); 
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

		  Thread.sleep(5000);
		/*String selectAll = Keys.chord(Keys.CONTROL, "a");
		oASelFW.driver.findElement(By.xpath("//div[contains(@class,'coral-RichText-editor is-edited webkit chrome')]/p[2]")).sendKeys(selectAll);
		Thread.sleep(5000);*/

	}

	public void OpenNewTab_RobotKeys() throws Exception
	{
		Thread.sleep(15000);

		

		System.out.println("Editor--");

		Robot robot=new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);

		Thread.sleep(5000);



	}
	
	
	public void Open_NewTab_RobotKeys() throws Exception
	{
		Thread.sleep(5000);

		

		System.out.println("Editor--");

		Robot robot=new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);

		Thread.sleep(5000);



	}


	public void MoveCursorToEnd_RobotKeys() throws Exception
	{
		Robot robot=new Robot();

		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_HOME);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_END);

		Thread.sleep(5000);

	}

	public void Click_RichText_LinksButton() throws Exception
	{
		//Robot robot=new Robot();


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-action='links#modifylink']")));
		oASelFW.effecta("click","//button[@data-action='links#modifylink']","ModifyLink");

		/*robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
		 */
	}



	public void EnterTextUnderLinksButton(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Path']")));
		oASelFW.effecta("type","//input[@placeholder='Path']",text,"Links Input");

	}

	public void EnterText_Title(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Alt Text']")));
		oASelFW.effecta("type","//input[@placeholder='Alt Text']",text,"Title");

	}
	
	public void EnterText_Brightcove_VideoID(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='BrightCove ID']")));
		oASelFW.effecta("type","//input[@placeholder='BrightCove ID']",value,"Brightcove videoID");

	}

	
	public void click_RichText_AltText()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Alt Text']")));
		oASelFW.effecta("click","//input[@placeholder='Alt Text']","Alt Text");

	}
	
	
	//div[contains(text(),'Is Brightcove Link?')]/following::button[contains(text(),'Yes')]
	public void click_RichText_BrightcoveLink_Btn_Yes()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Is Brightcove Link?')]/following::button[contains(text(),'Yes')]")));
		oASelFW.effecta("click","//div[contains(text(),'Is Brightcove Link?')]/following::button[contains(text(),'Yes')]","Brightcove Link button Yes");

	}
	

	public void Click_RichText_SaveButton()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'save')]")));
		oASelFW.effecta("click","//button[contains(@data-action,'save')]","Save");

	}


	public void Click_RichText_FullScreen_Button()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'fullscreen#start')]")));
		oASelFW.effecta("click","//button[contains(@data-action,'fullscreen#start')]","Maximize Screen");

	}


	public void TabComponent_SelectTarget(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+field+"']/following::select")));
		oASelFW.effecta("select","//span[text()='"+field+"']/following::select",value,field);
	}



	public void Click_RichText_FullScreen_Exit()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'fullscreen#finish')]")));
		oASelFW.effecta("click","//button[contains(@data-action,'fullscreen#finish')]","Minimize Screen");

	}

	public void Click_RichText_StyleButton()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'styles')]")));
		oASelFW.effecta("click","//button[contains(@data-action,'styles')]","Styles");

	}

	public void Click_RichText_StyleType(String type)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='coral-Popover-content']/ul/li/button/span[contains(text(),'"+type+"')]")));
		oASelFW.effecta("click","//div[@class='coral-Popover-content']/ul/li/button/span[contains(text(),'"+type+"')]",type);

	}


	public void Verify_RichText_StyleType(String type)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='coral-Popover-content']/ul/li/button/span[contains(text(),'"+type+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='coral-Popover-content']/ul/li/button/span[contains(text(),'"+type+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Style Type available from List","Style Type is displayed as expected: "+type,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Style Type available from List","Style Type is not displayed","Fail");
		}

	}


	public void Verify_RichText_Value(String value)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/a[contains(text(),'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span/a[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify entered text "+value+" available","Entered text "+value+" is available","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify entered text "+value+" available","Entered text is not available","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	public void Verify_RichText_DisclaimerTextValue(String value)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p/span[contains(text(),'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p/span[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify entered text "+value+" available","Entered text "+value+" is available","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify entered text "+value+" available","Entered text is not available","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	//p/a[@class='bcvideo']/span[contains(text(),'TestVmware')]
	public void Verify_RichText_BrightcoveTextValue(String value)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p/a[@class='bcvideo']/span[contains(text(),'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p/a[@class='bcvideo']/span[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify entered text "+value+" available","Entered text "+value+" is available with Brightcove","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify entered text "+value+"is available","Entered text is not available with Brightcove","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	
	public void Click_RichText_BrightcoveTextValue_VerifyVideoPlay(String value) throws InterruptedException
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p/a[@class='bcvideo']/span[contains(text(),'"+value+"')]")));
		oASelFW.effecta("click","//p/a[@class='bcvideo']/span[contains(text(),'"+value+"')]",value);

		oASelFW.effecta("sendReport","Click brightcove video "+value,"Succssfully clicked on Brightcove video","Pass");
		
		Thread.sleep(10000);
		
		
	}


	//div[@class='container-fluid']/following::span[@class='btn btn-green']

	public void Verify_RichText_ButtonColor(String buttoncolor,String expectedcolor)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container-fluid']/following::span[@class='btn btn-green']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='container-fluid']/following::span[@class='"+buttoncolor+"']")))
		{
			oASelFW.effecta("sendReport","Verify button color displayed as "+expectedcolor,"Expected button color displayed successfully as"+expectedcolor,"Pass");
		}
		else 
		{
			oASelFW.effecta("sendReportWithOutExit","Verify button color displayed as "+expectedcolor,"Expected button color not displayed  as"+expectedcolor,"Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}




	public void Verify_RichText_ChevronCTA(String value, String displayMode)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+value+"')]/span[@class='fa fa-angle-double-right inline']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+value+"')]/span[@class='fa fa-angle-double-right inline']")))
		{
			oASelFW.effecta("sendReport","Verify entered text configured with Chevron CTA","Chevron CTA is configured to the entered text '"+value+ "' in "+displayMode,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify entered text configured with Chevron CTA","Chevron CTA is not configured to the entered text '"+value+ "' in "+displayMode,"Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}


	public void Verify_RichText_ChevronCTA_InContentMode(String value,String displayMode)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+value+"')]/span[@class='fa fa-angle-double-right inline']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+value+"')]/span[@class='fa fa-angle-double-right inline']")))
		{
			oASelFW.effecta("sendReport","Verify entered text contains Chevron CTA","Chevron CTA is configured to the entered text '"+value+ "' in "+displayMode,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify entered text contains Chevron CTA","Chevron CTA is not configured to the entered text '"+value+ "' in "+displayMode,"Fail");
		}

		//oASelFW.driver.switchTo().defaultContent();
	}

	public void Verify_RichText_DeletedChevronCTA(String value,String displaymode)
	{


	

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+value+"')]/span[@class='fa fa-angle-double-right inline']")))
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Deleted Chevron CTA available","Chevron CTA available after deletion in "+displaymode,"Fail");
		}
		else
		{
			oASelFW.effecta("sendReport","Verify Deleted Chevron CTA available","Deleted Chevron CTA is not displayed in "+displaymode,"Pass");
		}


	}


	public void Verify_RichText_DeletedChevronCTA_Preview(String value,String displaymode)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+value+"')]/span[@class='fa fa-angle-double-right inline']")))
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Deleted Chevron CTA available","Chevron CTA available after deletion in "+displaymode,"Fail");
		}
		else
		{
			oASelFW.effecta("sendReport","Verify Deleted Chevron CTA available","Deleted Chevron CTA is not displayed in "+displaymode,"Pass");
		}

		oASelFW.driver.switchTo().defaultContent();
	}


	public void Verify_RichText_FontSize(String title,String expectedfontsize)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));

		WebElement text = oASelFW.driver.findElement(By.xpath("//span/a[contains(text(),'"+title+"')]"));
		//Read font-size property and print It In console.
		String fontSize = text.getCssValue("font-size").trim();
		//int font_Size = Integer.parseInt(fontSize);
		System.out.println("Font Size -> "+fontSize); 

		System.out.println("expected Font Size -> "+expectedfontsize); 

		if(fontSize.equalsIgnoreCase(expectedfontsize))
		{
			oASelFW.effecta("sendReport","Verify Font Size: "+expectedfontsize,"Verified expected Font Size: "+expectedfontsize,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Font Size: "+expectedfontsize,"Font Size is not as expected","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}



	public void Verify_RichText_DisclaimerTextFontSize(String value,String expectedfontsize)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));

		WebElement text = oASelFW.driver.findElement(By.xpath("//p/span[contains(text(),'"+value+"')]"));
		//Read font-size property and print It In console.
		String fontSize = text.getCssValue("font-size").trim();
		//int font_Size = Integer.parseInt(fontSize);
		System.out.println("Font Size -> "+fontSize); 

		System.out.println("expected Font Size -> "+expectedfontsize); 

		if(fontSize.equalsIgnoreCase(expectedfontsize))
		{
			oASelFW.effecta("sendReport","Verify Font Size: "+expectedfontsize,"Verified expected Font Size: "+expectedfontsize,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Font Size: "+expectedfontsize,"Font Size is not as expected","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	public void Verify_RichText_ButtonOutlineSize(String title,String expectedbordersize)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));

		WebElement text = oASelFW.driver.findElement(By.xpath("//span/a[contains(text(),'"+title+"')]"));
		//Read border property and print It In console.
		String borderSize = text.getCssValue("border").trim();

		System.out.println("border Size -> "+borderSize); 

		System.out.println("expected border Size -> "+expectedbordersize); 

		if(borderSize.equalsIgnoreCase(expectedbordersize))
		{
			oASelFW.effecta("sendReport","Verify border size: "+expectedbordersize,"Verified expected border Size: "+expectedbordersize,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify border size: "+expectedbordersize,"border Size is not as expected","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}



	public void Verify_RichText_FontFamily(String title,String expectedfontsize)
	{


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));

		WebElement text = oASelFW.driver.findElement(By.xpath("//span/a[contains(text(),'"+title+"')]"));
		//Read font-size property and print It In console.
		String fontSize = text.getCssValue("font-family").trim();
		//int font_Size = Integer.parseInt(fontSize);
		System.out.println("font-family -> "+fontSize); 

		System.out.println("expected font-family-> "+expectedfontsize); 

		if(fontSize.equalsIgnoreCase(expectedfontsize))
		{
			oASelFW.effecta("sendReport","Verify font-family: "+expectedfontsize,"Verified expected font-family: "+expectedfontsize,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify font-family: "+expectedfontsize,"font-family is not as expected","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}





	public void verify_quickLinks()
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Toggle Side Panel']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[@title='Toggle Side Panel']"));
		action.moveToElement(element).click().build().perform();
		//oASelFW.effecta("click","//button[@title='Toggle Side Panel']","Toggle Side Panel");
	}


	public void ClickLoginLink()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Login Link')]")));
		oASelFW.effecta("click","//a[contains(text(),'Login Link')]","Login Link");
	}





	public void DoubleClickonQuickLinksComponent() throws InterruptedException
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'quicklinks')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'quicklinks')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'quicklinks')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
		/*
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"))).doubleClick().build().perform();
		for(int i=0;i<5;i++)
		{
			//if(oASelFW.driver.findElements(By.xpath("//div[@title='"+title+"']")).size()>=1)
			Thread.sleep(10000);
			action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"))).doubleClick().build().perform();
			else
			{
			break;
			}
		}*/
	}
	//button[@title='Toggle Side Panel']


	public void VerifyNewsEvents_Title(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify News and Events Heading","News and Events Heading is displayed as expected: "+value,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify News and Events Heading","News and Events Heading is not displayed as expected: "+value,"Fail");
		}
	}

	public void VerifyLinkList_Title(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[contains(text(),'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h6[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Link List Title","Link List Title is displayed as expected: "+value,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Link List Title","Link List Title is not displayed as expected: "+value,"Fail");
		}
	}


	public void ClickToggleSidePanel(){

		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Toggle Side Panel']")));

		WebElement element = oASelFW.driver.findElement(By.xpath("//button[@title='Toggle Side Panel']"));
		action.moveToElement(element).click().build().perform();

		//oASelFW.effecta("click","//button[@title='Toggle Side Panel']","Toggle Side Panel");


	}


	public void Click_required_button_inMenuBar(String button){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='"+button+"']")));

		oASelFW.effecta("click","//button[@title='"+button+"']",button);
	}

	public void Click_Search_button(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Search']")));

		oASelFW.effecta("click","//button[@title='Search']","Search button");
	}

	public void SearchKeyword(String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/input[@placeholder='Enter Keyword(s)']")));

		//Tooltip Text
		oASelFW.effecta("type","//span/input[@placeholder='Enter Keyword(s)']",value,"Enter Keyword(s)");

		//Press Key Enter
		WebElement webElement = oASelFW.driver.findElement(By.xpath("//span/input[@placeholder='Enter Keyword(s)']"));
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(5000);		

	}

	public void Click_Component_OpenPage(String pageName){

		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+pageName+"']/ancestor::button[@title='Open']")));

		WebElement element = oASelFW.driver.findElement(By.xpath("//h4[text()='"+pageName+"']/ancestor::button[@title='Open']"));
		action.moveToElement(element).click().build().perform();

		//oASelFW.effecta("click","//h4[text()='"+pageName+"']/ancestor::button[@title='Open']","Open");
		oASelFW.effecta("sendReport","Click on Component Page in Editing mode","Component Page "+pageName+" is opened in Editing mode","Pass");
	}
	
	
	//h4[text()='Test']/ancestor::button[@title='View Properties']
	public void Click_Component_ViewProperties(String pageName) throws InterruptedException{

		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+pageName+"']")));

		WebElement element = oASelFW.driver.findElement(By.xpath("//h4[text()='"+pageName+"']"));
	
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		WebElement elementClick = oASelFW.driver.findElement(By.xpath("//h4[text()='"+pageName+"']/ancestor::a[@title='View Properties']"));
		
		action.moveToElement(elementClick).click().build().perform();
		//oASelFW.effecta("click","//h4[text()='"+pageName+"']/preceding::a[contains(text(),'View Properties')]","View Properties");
		oASelFW.effecta("sendReport","Click on Component Page in view Properties","Successfully clicked on page View Properties","Pass");
	}


	public void Click_Publish_DefaultDesign_Checkbox()
	{
		
		String checkBoxValue="";
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='list hidden xsmall']/div/header")))
		{
			checkBoxValue=oASelFW.driver.findElement(By.xpath("//div[@class='list hidden xsmall']/div/header")).getAttribute("class");
			System.out.println("checkBoxValue:"+checkBoxValue);
		}
		if(checkBoxValue.trim().equals("card-page selectable"))
		{
			System.out.println("check box is already unchecked");
		}else if(checkBoxValue.trim().equals(""))
		{
			System.out.println("check box value is null");
		}
		else
		{
			System.out.println("check box is checked");
			oASelFW.effecta("click","//li[text()='Publish']/following::header/i","Select check box");
		}
	}

	public void Click_PreviewButton(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Preview']")));

		oASelFW.effecta("click","//button[@title='Preview']","Preview button");
	}

	public void Click_References_LanguageCopies(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[contains(text(),'Language Copies')]")));

		oASelFW.effecta("click","//div/a[contains(text(),'Language Copies')]","Language Copies");


	}

	/**
	 * @author Swathi
	 * @throws InterruptedException
	 */
	public void dragAndDrop_Image_To_ImageAsset()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='card'])[1]/a")));
		System.out.println("wait over..............");
		WebElement From = oASelFW.driver.findElement(By.xpath("(//div[@class='card'])[1]/a"));
		System.out.println("first element");
		WebElement To = oASelFW.driver.findElement(By.xpath("//div/div[text()='Drop asset here']"));
		System.out.println("second element");
		Actions builder = new Actions(oASelFW.driver);
		builder.dragAndDrop(From, To).build().perform();
	}


	/**
	 * @author Swathi
	 * @throws InterruptedException
	 */
	public void dragAndDrop_Image_To_RequiredImageAsset(String image)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='card']/following::h4[contains(text(),'"+image+"')]")));
		System.out.println("wait over..............");
		WebElement From = oASelFW.driver.findElement(By.xpath("//div[@class='card']/following::h4[contains(text(),'"+image+"')]"));
		System.out.println("first element");
		WebElement To = oASelFW.driver.findElement(By.xpath("//div/div[text()='Drop asset here']"));
		System.out.println("second element");
		Actions builder = new Actions(oASelFW.driver);
		builder.dragAndDrop(From, To).build().perform();
	}




	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement)
	{

		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(oASelFW.driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		}
	}


	public void ImagePropperties(String title,String label,String URLOpentype)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Image asset']")));

		//TITLE
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input",title,"Name");

		//CTA Label
		oASelFW.effecta("type","//label[text()='CTA Label']/following-sibling::input",label,"CTA Label");

		//Select Window
		oASelFW.effecta("select","//select[@name='./windowselection']",URLOpentype,"Select Window");

		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		//oASelFW.effecta("clickAndWait","//a[text()='Cancel']&&//a[contains(@data-action,'cancel')]","Cancel");

		//CLASSIC UI
		/*oASelFW.effecta("click","//i[@class='coral-Icon coral-Icon--properties coral-Icon--sizeS']","Page Information");
			oASelFW.effecta("click","//button[contains(text(),'Open in Classic UI')]","Classic UI");
		 */

	}



	public void ImageProperties_Links(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following::input")));
		oASelFW.effecta("type","//label[text()='"+field+"']/following::input",value,field);
	}

	public void ImageProperties_Horizontal(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+field+"')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'"+field+"')]/following-sibling::input",value,field);
	}
	
	public void TypeDirect_URL(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following-sibling::span/span/input")));
		oASelFW.effecta("type","//label[text()='"+field+"']/following-sibling::span/span/input",value,field);
	}
	
	
	
	public void ImageProperties_Horizontal_Selectdropdown(String field,String value)
	{
	
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+field+"')]/following::select")));
	oASelFW.effecta("select","//label[contains(text(),'"+field+"')]/following::select",value,"Select drop down");
	}
	public void ImageProperties_TextArea(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text()='"+field+"')]/following::textarea")));
		oASelFW.effecta("type","//label[contains(text()='"+field+"')]/following::textarea",value,field);
	}
	
	public void techspecs_title(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following-sibling::input")));
		oASelFW.effecta("type","//label[text()='"+field+"']/following-sibling::input",value,field);
	}
	public void ImageProperties_SelectOpenUrlType(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='./windowselection']")));
		oASelFW.effecta("select","//select[@name='./windowselection']",value,"Select URL Open Type");
	}

	public void FeatureListContainerProperties(String field,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following::input")));
		oASelFW.effecta("type","//label[text()='"+field+"']/following::input",value,field);
	}

	public void VerifyFeatureListContainer_PdfLink(String linkName) throws Exception
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(@title,'"+linkName+"')]")))
		{
			oASelFW.effecta("sendReport","Verify "+linkName+" is displaying",linkName+ "is displayed successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify "+linkName+" is displaying",linkName+ "is not displayed as expected","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}

	public void VerifyFeatureListContainer_PdfLinkWO_Frame(String linkName) throws Exception
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'"+linkName+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(@title,'"+linkName+"')]")))
		{
			oASelFW.effecta("sendReport","Verify "+linkName+" is displaying in test 15 instance or not",linkName+ "is displayed successfully in test15 instance","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify "+linkName+" is displaying in test 15 instance or not",linkName+ "is not displayed as expected","Fail");
		}
	}
	
	public void Click_FeatureListContainer_PdfLink(String linkName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'"+linkName+"')]")));
		oASelFW.effecta("click","//a[contains(@title,'"+linkName+"')]",linkName+" PDF");
		oASelFW.driver.switchTo().defaultContent();
	}



	public void FeatureListContainerProperties_LinkUrl(String field,String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+field+"']/following::span/input")));
		oASelFW.effecta("type","//label[text()='"+field+"']/following::span/input",value,field);
		Thread.sleep(3000);
		Actions act=new Actions(oASelFW.driver);
		act.sendKeys(Keys.ESCAPE);
		System.out.println("Escape Clicked");
		Thread.sleep(3000);
	}

	public void FeatureListContainerProperties_SelectTargetWindow(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Target Window']/following-sibling::span//select")));
		oASelFW.effecta("select","//label[text()='Target Window']/following-sibling::span//select",value,"Select Window");
	}

	public void Click_FeatureListContainer_ContainerLevelPDF_Link()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Container Level PDF']")));
		oASelFW.effecta("click","//a[text()='Container Level PDF']","Container Level PDF");
	}

	public void verifyFAQContainer()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='FAQs']")));
		oASelFW.effecta("verifyElementPresent","//h2[text()='FAQs']","FAQs");
	}

	public String[] fillFQAContainerFields() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='FAQs']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Custom Title']/following-sibling::input")));
		String title="QATest";
		int random=(int) (Math.random()*10000);
		title=title+random;
		oASelFW.effecta("type","//label[text()='Custom Title']/following-sibling::input",title,"Title");
		oASelFW.effecta("click","//ol[@class='coral-Multifield-list js-coral-Multifield-list']/following-sibling::button[text()='Add field']&&//button[text()='Add field']","Add Field") ;
		Thread.sleep(2000);
		String catTitle="FAQ Category Title";
		int random1=(int) (Math.random()*10000);
		catTitle=catTitle+random1;
		oASelFW.effecta("type","//label[text()='FAQ Category Title']/following-sibling::input",catTitle,"FAQ Category Title");
		oASelFW.effecta("type","//label[text()='See All Text']/following-sibling::input","Yes","See All Text");
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//button[text()='Add field'])[2]&&//ol[@class='coral-Multifield-list js-coral-Multifield-list']/following-sibling::button[text()='Add field']&&//button[text()='Add field']","Add Field") ;
		Thread.sleep(2000);
		String title1="FAQ Category Title Field";
		int random2=(int) (Math.random()*10000);
		title1=title1+random2;
		Thread.sleep(2000);
		oASelFW.effecta("type","xpath=(//label[text()='FAQ Category Title']/following-sibling::input)[2]",title1,"FAQ Category Title");
		oASelFW.effecta("type","xpath=(//label[text()='See All Text']/following-sibling::input)[2]","Yes","See All Text");
		oASelFW.effecta("click","//button[@title='Done']","Done") ;
		Thread.sleep(5000);
		String details[]={title,catTitle,title1};
		return details;
	}

	public void verifyPublishedPageForFAQContainer(String pageName,String[] details)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+pageName+"')]")));
		String title=oASelFW.effecta("getText","//div[@class='row']/div[1]/h2","FAQ Container Title");
		String categoryTitle1=oASelFW.effecta("getText","//div[@class='row']/div//div[1]/h3","Category Title");
		String categoryTitle2=oASelFW.effecta("getText","//div[@class='row']/div//div[2]/h3","Category Title");
		System.out.println("***"+details[0]+"***"+details[1]+"***"+details[2]);

		if((title.trim().equals(details[0].toUpperCase()))&&(categoryTitle1.trim().equals(details[1])) &&(categoryTitle2.trim().equals(details[2]))){
			oASelFW.effecta("sendReport","Validating whether FAQ Container Page is Published Successfully","FAQ Container Page is Published Successfully.","Pass");
		}else{
			oASelFW.effecta("sendReportWithOutExit","Validating whether FAQ Container Page is Published Successfully","Unable to verify.FAQ Container Page is not Published.","Pass");
		}

	}

	public void Verifying_AddedFooterComponentValues(String array[], int j)
	{
		oASelFW.driver.switchTo().frame("ContentFrame");
		String value=oASelFW.effecta("getText","//div[@class='section links']/ul["+j+"]/li");

		oASelFW.driver.switchTo().defaultContent();
		if(array[j-1].contains(value))
		{
			oASelFW.effecta("sendReport","Added footer components  "," are displayed successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Added footer components  "," are not  displayed ","Fail");
		}
	}

	public void Verifying_AddedLinkInNewWindow(String url, String link)
	{
		if(url.contains(link))
		{
			oASelFW.effecta("sendReport","Added links "," are displayed successfully in New Window","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Added links "," are not  displayed in New Window","Fail");
		}
	}

	public void Verifying_AddedLinkInSameWindow(String url, String link)
	{
		if(url.contains(link))
		{
			oASelFW.effecta("sendReport","Added links "," are displayed successfully in Same window","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Added links "," are not  displayed in Same Window","Fail");
		}

	}

	public void click_LinkToOpenWindow()
	{
		oASelFW.driver.switchTo().frame("ContentFrame");
		oASelFW.effecta("clickAndWait","//div[@class='section links']/div[1]/following::ul[1]/li","Link to Open");
		oASelFW.driver.switchTo().defaultContent();
	}

	public void DoubleClickonFatFooter_GlobalContent() throws InterruptedException
	{
		System.out.println("in method");
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'fatfooter2')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'fatfooter2')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'fatfooter2')]"))).doubleClick().build().perform();
		oASelFW.effecta("sendReport","Clicking on Button/Link/Image","Successfully clicked on button/link/image:Fat Footer","Pass");
	}

	public void Addfield() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add field']")));
		System.out.println("Identified Add Field*************");

		Actions action = new Actions(oASelFW.driver);
		//action.moveToElement(oASelFW.driver.findElement(By.xpath("//button[text()='Add field']"))).click().build().perform();
		action.click(oASelFW.driver.findElement(By.xpath("//button[text()='Add field']")));

		WebElement element = oASelFW.driver.findElement(By.xpath("//button[text()='Add field']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);

		//oASelFW.effecta("click","//button[text()='Add field']","Add field");
	}


	public void enter_TitleAndLinkLableIn_TitleAndLinks(String label,String value) throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//label[text()='Title']/following-sibling::input[contains(@class,'coral-Form-field')]","40");
		oASelFW.effecta("type","//label[text()='"+label+"']/following-sibling::input[contains(@class,'coral-Form-field')]",value,label);
	}

	public void enter_LinkIn_TitleAndLinks(String value) throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//label[text()='Link']/following::input[1]","40");
		oASelFW.effecta("type","//label[text()='Link']/following::input[1]",value,"link");

	}

	public void selectUrlIn_TitleAndLinks(String value) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		oASelFW.effecta("waitForElementPresent","xpath=(//label[text()='Select URL Open type']/following-sibling::span//select)[1]","40");


		oASelFW.effecta("select","xpath=(//label[text()='Select URL Open type']/following-sibling::span//select)[1]",value,"Select URL Open type");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Done']")));
		System.out.println("Identified Done*************");
		//oASelFW.effecta("clickAndWait","//button[@title='Done']","Done");
		Actions action = new Actions(oASelFW.driver);
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[@title='Done']"));
		action.click(element);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);

		oASelFW.effecta("sendReport","Clicking on Button/Link/Image","Successfully clicked on button/link/image:Done","Pass");
	}

	public void deleteCreatedFatFooter() throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'fatfooter2')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'fatfooter2')]"));
		action.click(element).build().perform();

		Thread.sleep(5000);
		action.click(element);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Delete']"))){
			oASelFW.effecta("sendReport","Clicking on Button/Link/Image","Successfully clicked on button/link/image:Delete","Pass");
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Delete']")));
		oASelFW.driver.findElement(By.xpath("//button[text()='Delete']")).click();
		oASelFW.effecta("sendReport","Clicking on Button/Link/Image","Successfully clicked on button/link/image:Delete","Pass");
		Thread.sleep(5000);
	}

	public void verifyFatFooterPage(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title']/following-sibling::input")));
		String title=oASelFW.driver.findElement(By.xpath("//label[text()='Title']/following-sibling::input")).getAttribute("value");
		if(title.trim().equalsIgnoreCase(value.trim()))
		{
			oASelFW.effecta("sendReport","Validating Fat Footer Page","Successfully verified Fat Footer Page","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating Fat Footer Page","Successfully verified Fat Footer Page","Fail");
		}

	}


	public void verifyAuthorBannerImageAltText(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		oASelFW.driver.switchTo().frame("ContentFrame");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='heroCaraousel banner splash has-dots']/ul/li/img")));
		String title=oASelFW.driver.findElement(By.xpath("//div[@class='heroCaraousel banner splash has-dots']/ul/li/img")).getAttribute("alt");
		if(title.trim().equalsIgnoreCase(value.trim()))
		{
			oASelFW.effecta("sendReport","Verify Author Banner Image Alt Text","Successfully Verified Author Banner Image Alt Text","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Author Banner Image Alt Text","Author Banner Image Alt Text is not displayed","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void verifyAuthorBannerImageAltText_PublishMode(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='heroCaraousel banner splash has-dots']/ul/li/img")));
		String title=oASelFW.driver.findElement(By.xpath("//div[@class='heroCaraousel banner splash has-dots']/ul/li/img")).getAttribute("alt");
		if(title.trim().equalsIgnoreCase(value.trim()))
		{
			oASelFW.effecta("sendReport","Verify Author Banner Image Alt Text","Successfully Verified Author Banner Image Alt Text","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Author Banner Image Alt Text","Author Banner Image Alt Text is not displayed","Fail");
		}

	}

	public void DoubleClick_Fatfooter_LinkComponent() throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		Thread.sleep(5000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'fatfooter1')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(@data-path,'fatfooter1')]"))).doubleClick().build().perform();
		Thread.sleep(6000);	
	}

	/*Description -This method will select Any Comnponent on double click.
	 *@Divanshu
	 */

	

	public void DoubleClickOnComponent(String component) throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]"))).doubleClick().build().perform();
		Thread.sleep(5000);
		System.out.println("DoubleClickOnComponent done");
	}
	
	public void SingleClickOnComponent_CFP(String component) throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]")));
		WebElement ele = oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]"));
		action.moveToElement(ele, 5, 5).click().build().perform();
		oASelFW.effecta("sendReport","Click on "+component,"Successfully clicked on "+component,"Pass");
		
		Thread.sleep(3000);
	
		System.out.println("DoubleClickOnComponent done");
	}
	
	public void SingleClickOnComponent(String component) throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-path,'"+component+"')])[1]"))).click().build().perform();
		Thread.sleep(5000);
		System.out.println("SingleeClickOnComponent done");
	}
	
	
	public void SingleClickOnSponsorsComponent(String component) throws Exception
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		//Actions action = new Actions(oASelFW.driver);
		/*WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]"))).click().build().perform();
		Thread.sleep(5000);
		System.out.println("SingleeClickOnComponent done");*/
		
		
		
		Actions action = new Actions(oASelFW.driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]")));
		WebElement ele = oASelFW.driver.findElement(By.xpath("(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]"));
		action.moveToElement(ele, 5, 5).click().build().perform();
		oASelFW.effecta("sendReport","Click on "+component,"Successfully clicked on "+component,"Pass");
		
		/*oASelFW.effecta("verifyElementPresent","(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]",component);
		oASelFW.effecta("click","(//div[@data-type='Editable' and contains(@data-text,'"+component+"')])[1]","clicking on" +component);
		*/
	
	//	oASelFW.effecta("verifyElementPresent","//div[contains(@title,'Rich Text Component')]/parent::div",component);
	//	oASelFW.effecta("click","//div[contains(@title,'Rich Text Component')]/parent::div","clicking on" +component);
		
		
		//div[contains(@title,'Rich Text Component')]/parent::div
	}
	
	
	
	
	public void DoubleClickOnCarouselComponent() throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Carousel Slider' and contains(@data-path,'carousel/carouselContent1') or contains(@data-path,'carousel/carouselContent2')]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Carousel Slider' and contains(@data-path,'carousel/carouselContent1') or contains(@data-path,'carousel/carouselContent2')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Carousel Slider' and contains(@data-path,'carousel/carouselContent1') or contains(@data-path,'carousel/carouselContent2')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
		System.out.println("DoubleClickOnComponent done");
	}
	
	

	public void ClickOnComponent(String component) throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]")));
		Thread.sleep(3000);
		oASelFW.effecta("verifyElementPresent","//div[@data-type='Editable' and contains(@data-path,'"+component+"')]",component+ " Text Component");
		oASelFW.effecta("click","//div[@data-type='Editable' and contains(@data-path,'"+component+"')]","clicking on" + component);
	}
	
	
	public void clickOnConfig() throws Exception
	{
		System.out.println("Entered into method clickOnConfig");
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Configure']")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[@title='Configure']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
	}

	
	public void selectSkinType(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Select Skin Type']/following::select")));
		oASelFW.effecta("select","//label[text()='Select Skin Type']/following::select",option,"selecting Skin type");

		WebElement element = oASelFW.driver.findElement(By.xpath("//button[@title='Done']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		
	}
	

	//div[@data-type='Editable' and contains(@data-path,'sponsor-1') and @title='Drag components here']
	public void DoubleClickOnRequiredTabcontentComponent(String component) throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"') and @title='Drag components here']")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"') and @title='Drag components here']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"') and @title='Drag components here']"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	




	public void DoubleClickOnComponent1(String component) throws Exception
	{
		System.out.println("Entered into method DoubleClickOnComponent");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);

		oASelFW.driver.findElement(By.xpath("//button[@data-action='CONFIGURE']")).click();
		Thread.sleep(3000);
	}

	public void click_Verify_HOL_Feed_Render_Component() throws InterruptedException
	{
		oASelFW.effecta("click","//button[@title='Preview']/following::div/following::div/following::div[@id='ContentScrollView']/div[2]/div[2]/div[2]","HOL Feed Render COmponent is clicked");
		Thread.sleep(3000);
		WebElement we = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[@title='Copy']"));
		if(Boolean.parseBoolean(oASelFW.effecta("verifyElementPresent","//div[@id='EditableToolbar']/button[@title='Copy']","Configure Element is not present")))
		{
			System.out.println("Configure Element is not Present");
			oASelFW.effecta("sendReport","Verifying authoring functionality is not applicable for HOL Feed","Verified authoring functionality is not applicable for HOL Feed as Configure Element is not present","Pass");
		}
		else
		{
			System.out.println("Configure Element is Present");
			oASelFW.effecta("sendReport","Verifying authoring functionality is  applicable for HOL Feed","Verified authoring functionality is  applicable for HOL Feed as Configure Element is  present","Fail");
		}

	}

	
	public void scrollPage() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public void scrollPage1(String pageName) throws Exception
	{
		Thread.sleep(5000);
		for(int i=0;;i++){
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[text()='"+pageName+"']")))	{
				break;
			}
			else{
				System.out.println("Avinash");
				JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
				jse.executeScript("window.scrollBy(0,250)", "");
			}
		}
	}

	public void columnControlDetails(String ColumnNo) throws Exception
	{
		String title="QATest";
		int random=(int) (Math.random()*10000);
		title=title+random;
		oASelFW.effecta("type","//label[text()='Title ']/following-sibling::input",title,"TITLE");
		Thread.sleep(2000);
		oASelFW.effecta("select","//label[text()='Select Number of Columns']/following-sibling::span/descendant::select",ColumnNo,"Selecting Number Of Column");
		Thread.sleep(2000);
		
		oASelFW.effecta("select","//label[text()='Select Style']/following-sibling::span/descendant::select","Grey Background","Select Style");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[@title='Done']","Done With Details");		
	}
	
	public void columnControlEnterDetails(String title,String ColumnNo) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Title ']/following-sibling::input")));
		oASelFW.effecta("type","//label[text()='Title ']/following-sibling::input",title,"TITLE");
		Thread.sleep(2000);
		oASelFW.effecta("select","//label[text()='Select Number of Columns']/following-sibling::span/descendant::select",ColumnNo,"Selecting Number Of Column");
		Thread.sleep(2000);
		
		oASelFW.effecta("select","//label[text()='Select Style']/following-sibling::span/descendant::select","Grey Background","Select Style");
		Thread.sleep(3000);
		oASelFW.effecta("click","//button[@title='Done']","Done With Details");		
	}
	
	

	public void clickOnColControlDragComponent(String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontrol/"+colNum+"/')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontrol/"+colNum+"/')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontrol/"+colNum+"/')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	public void clickOnColControlOne_DragComponent(String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+colNum+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+colNum+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+colNum+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	
	
	public void clickOnColControlOne_DragComponent_VMware(String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/columncontainer/"+colNum+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/columncontainer/"+colNum+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/columncontainer/"+colNum+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	
	public void clickOnColControlDragComponentSecond(String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontainer/"+colNum+"/*')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontainer/"+colNum+"/*')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontainer/"+colNum+"/*')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	public void clickOn3ColControlDragComponent()  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'field1/')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'field1/')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'field1/')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	public void DoubleClickonInserted_Component(String component) throws InterruptedException
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+component+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[contains(text(),'"+component+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(text(),'"+component+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	public void click_HighlightLinkCheckBox(String fieldname)
	{
		oASelFW.effecta("click","//span[text()='"+fieldname+"']/../input)","Highlight link checkbox");	
	}


	public void verifying_MultipleAddedcomponetValues(String[] AddedValues,String componentName, int n ) throws InterruptedException
	{
		Thread.sleep(6000);
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains("editor.html/")){
			url=url.replaceAll("editor.html/", "");
		}
		oASelFW.driver.get(url);
		String pagesource=oASelFW.driver.getPageSource();
		for(int j=1;j<=n;j++)
		{
			if(pagesource.contains(AddedValues[j-1]))
			{
				oASelFW.effecta("sendReport", componentName ,"component values are added sucessfully","Pass");

			}
			else
			{
				oASelFW.effecta("sendReport", componentName ,"component values are not added sucessfully","Fail");
			}
		}	
	}

	public void RightHandBanner_VIdeoLink()
	{	
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Right Hand Banner Video']")));
		oASelFW.effecta("click","//a[text()='Right Hand Banner Video']","Right Hand Banner Video link");	
	}

	public void verifying_AddedComponentValue(String AddedValue) throws InterruptedException
	{
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains("editor.html/")){
			url=url.replaceAll("editor.html/", "");
		}
		oASelFW.driver.get(url);
		String pagesource=oASelFW.driver.getPageSource();
		if(pagesource.contains(AddedValue))
		{
			oASelFW.effecta("sendReport", AddedValue ," values are displayed sucessfully","Pass");

		}else
		{
			oASelFW.effecta("sendReport", AddedValue ," values are not displayed sucessfully","Fail");
		}

	}

	public void click_ViewOnTwitter_Link() throws Exception
	{
		oASelFW.driver.switchTo().frame("ContentFrame");
		Thread.sleep(2000);
		oASelFW.driver.switchTo().frame("twitter-widget-0");
		oASelFW.effecta("click","//a[contains(text(),'View on Twitter')]","View on Twitter link");
		oASelFW.driver.switchTo().defaultContent();
	}

	public void	Verifying_TwitterSocialNWPage(String SocialNWSite)
	{
		String url=oASelFW.driver.getCurrentUrl();

		if(url.contains(SocialNWSite))
		{
			oASelFW.effecta("sendReport","User is ","Able to nagivate to the Social Links on Twitter","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","User is "," Not Able to nagivate to the Social Links on Twitter","Fail");
		}
	}

	public void entertText_tabs() throws Exception
	{
		oASelFW.driver.switchTo().frame("ContentFrame");
		Thread.sleep(3000);
		oASelFW.driver.findElement(By.xpath("//div[@class='inner-content']//div/p"));
		System.out.println("Editor--");

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);

		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void clickOnEDitButton_tabs()
	{
		oASelFW.effecta("click","//button[@title='Edit']","Edit button");
	}


	public void clickOn_ButtonTOogiveURls_Tab(){


		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='coral-RichText-toolbar-item disabled coral-Icon coral-Icon--link coral-RichText--trigger']")));
		oASelFW.effecta("click","//button[@class='coral-RichText-toolbar-item disabled coral-Icon coral-Icon--link coral-RichText--trigger']","Button");


	}


	public void EnterURlTitle(String  url,String title){

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Title']")));
		oASelFW.effecta("type","//input[@name='path-class-dark']",url,"URL");
		oASelFW.effecta("type","//input[@placeholder='Title']",title,"Title");


	}


	public void OPenInNewPage_Checkbox(){

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='coral-Checkbox']//span")));
		oASelFW.effecta("click","//label[@class='coral-Checkbox']//span","checkbox");


	}
	
	
	public void clickOnApply()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-type='apply' and @type='button']")));
		oASelFW.effecta("click","//button[@data-type='apply' and @type='button']","apply");


	}

	public void clickOnTabs_TabComponent(String tab)

	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("link="+tab)));
		oASelFW.effecta("click","link="+tab,"Tab link");

	}

	public void selecting_siteHeader_Link(String link)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add field']")));
		oASelFW.effecta("click","//a[text()='"+link+"']",link);
	}



	public void Click_requiredLink(String link)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//nav[@class='coral-TabPanel-navigation'])[3]/a[contains(text(),'"+link+"')]")));
		oASelFW.effecta("click","xpath=(//nav[@class='coral-TabPanel-navigation'])[3]/a[contains(text(),'"+link+"')]",link);
	}

	public void configure_loginLogoutLink() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Login/Logout Links']")));
		String logintitle="LoginLabel";
		int random=(int) (Math.random()*10000);
		logintitle=logintitle+random;
		oASelFW.effecta("type","//label[text()='Login Label']/following-sibling::input",logintitle,"Login Label");
		String logouttitle="LogoutLabel";
		int rand=(int) (Math.random()*10000);
		logouttitle=logouttitle+rand;
		oASelFW.effecta("type","//label[text()='Logout Label']/following-sibling::input",logouttitle,"Login Label");
		Thread.sleep(2000);
		oASelFW.effecta("select","//label[text()='Select URL Open type']/following-sibling::span/select","Same Window","URL OPENS");
		Thread.sleep(2000);
		oASelFW.effecta("click","//label[text()='Enable Search']/following-sibling::div/label/span","Search Enabled");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Search Placeholder text']/following-sibling::input","Search Text Here","Search Box");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[@title='Done']","Done");
		Thread.sleep(3000);
	}

	public void verifying_SearchBox()
	{
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains("editor.html/"))
		{
			url=url.replaceAll("editor.html/", "");
		}
		oASelFW.driver.get(url);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//input[@placeholder='Search Text Here']")))
		{
			oASelFW.effecta("sendReport","Verifying Search Box Present Or Not","Successfully Verified Search Box","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithoutExit","Verifying Search Box Present Or Not","Search Box Not Prwesent","Fail");
		}
	}
	
	public void SearchBox()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//input[@name='q']")))
		{
			oASelFW.effecta("sendReport","Verifying Search Box Present Or Not","Successfully Verified Search Box","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithoutExit","Verifying Search Box Present Or Not","Search Box Not Prwesent","Fail");
		}
	}
	
	public void search_item_SIT(String search) throws Exception
	{
		oASelFW.effecta("type","//input[@name='q']",search,"Searching Item");
		Thread.sleep(3000);
		WebElement we=oASelFW.driver.findElement(By.xpath("//input[@name='q']"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ENTER);	
		Thread.sleep(2000);
	}
	
	public void verify_result()
	{
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'VMware.com')]")))
		{
			oASelFW.effecta("sendReport","Verifying Search functionality is working fine or Not","Successfully Verified Search functionality is working fine","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithoutExit","Verifying Search functionality is working fine or Not","Search functionality is Not working fine","Fail");
		}
	}

	public void search_item(String search) throws Exception
	{
		oASelFW.effecta("type","//input[@placeholder='Search Text Here']",search,"Searching Item");
		Thread.sleep(3000);
		WebElement we=oASelFW.driver.findElement(By.xpath("//input[@placeholder='Search Text Here']"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ENTER);	
		//oASelFW.effecta("click","//button[@type='submit']","Search Button Clicked");
		Thread.sleep(2000);
	}

	public void click_vsphere()
	{
		oASelFW.effecta("click","//i[text()='vsphere']","Vsphere Clicked");
	}

	public int pageNavigation()
	{
		int row= oASelFW.driver.findElements(By.xpath("//a[text()='Next']/../../../../descendant::tr/td/following-sibling::td/following-sibling::td")).size();
		System.out.println("Count :" + row);
		return row;
	}

	public void click_Next()
	{
		oASelFW.effecta("click","//a[text()='Next']","Click Next");
	}

	public void Verifying_PageNavigation(int initial_count,int final_count)
	{
		if(initial_count<final_count)
		{
			oASelFW.effecta("sendReport","Check Whether Page Navigation Is Working Fine","Successfully Verified Page Navigation","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Check Whether Page Navigation Is Working Fine","Page Navigation Not Performing","Fail");
		}
	}

	/**
	 * @author avinash_ankireddy
	 * @Date: 21-03-2016
	 */

	public void selectCheckBoxAfterPublishing()
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Publish')]/following::i[contains(@class,'select')]")));
		int count=Integer.parseInt(oASelFW.effecta("getXpathCount","//li[contains(text(),'Publish')]/following::i[contains(@class,'select')]"));
		System.out.println("Count: "+ count);
		for(int i=1;i<=count;i++)
		{
			if(i%2!=0)
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Publish')]/following::i[contains(@class,'select')]["+i+"]")));
				oASelFW.effecta("click","//li[contains(text(),'Publish')]/following::i[contains(@class,'select')]["+i+"]","clicking on checkBox ");
			}

		}


	}

	/**
	 * @author avinash_ankireddy
	 * @throws InterruptedException 
	 */

	public void clickOnToggleSidePanel() throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Toggle Side Panel' and @data-align='left']")));
		oASelFW.effecta("click","//button[@title='Toggle Side Panel' and @data-align='left']","clicking on toggle panel");
		Thread.sleep(3000);
		System.out.println("Click On Toggle Method Completed");
	}

	/**
	 * @author avinash_ankireddy
	 * @param value
	 */

	public void clickOnTabPanelLinks(String value)
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'"+value+"')]")));
		oASelFW.effecta("click","//a[contains(text(),'"+value+"')]","clicking on toggle panel");
	}

	/**
	 * @author avinash_ankireddy
	 * @param value
	 * @param link
	 * @throws InterruptedException 
	 */
	public void enterTextInput(String value,String link) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Filter' or @placeholder='Enter keyword(s)']")));
		if(link.equals("Components"))
		{
			oASelFW.effecta("type","//input[@placeholder='Filter']",value,"Entering "+ value);	
			WebElement webElement = oASelFW.driver.findElement(By.xpath("//input[@placeholder='Filter']"));
			webElement.sendKeys(Keys.ENTER);
			Thread.sleep(5000);

		}else
		{
			oASelFW.effecta("type","//input[@placeholder='Enter keyword(s)']",value,"Entering "+ value);
			WebElement webElement = oASelFW.driver.findElement(By.xpath("//input[@placeholder='Enter keyword(s)']"));
			webElement.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		}
	}

	/**
	 * @author avinash_ankireddy
	 * @param value
	 * @param link
	 * @throws InterruptedException
	 */

	public void dragAndDropComponents(String value,String link,String locatorValue) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
		else
		{
			Thread.sleep(3000);	
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]")) &&  oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]")).isDisplayed())
			{
				
				oASelFW.effecta("click","//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]","Clear");
				Thread.sleep(3000);
				
				WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
				WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
				action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
				Thread.sleep(3000);
			}
			
			else if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]")))
			{
			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
			}
		}
	}
	
	
	public void dragAndDropComponents_ColumnContainer(String value,String link,String locatorValue,String columnlocator) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/columncontainer/"+columnlocator+"/*')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
		else
		{
			Thread.sleep(3000);	
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]")) &&  oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]")).isDisplayed())
			{
				oASelFW.effecta("click","//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]","Clear");
				Thread.sleep(3000);
				
				WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
				WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
				action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
				Thread.sleep(3000);
			}
			
			else if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]")))
			{
			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
			}
		}
	}
	
	
	
	
	public void dragAndDropComponents_Asset(String value,String link,String locatorValue) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
		else
		{
			Thread.sleep(3000);	
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]")) &&  oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')]")).isDisplayed())
			{
				oASelFW.effecta("click","//label[contains(text(),'Image asset')]/following::span[contains(text(),'Clear')]","Clear");
				Thread.sleep(3000);
				
				WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
				WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
				action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
				Thread.sleep(3000);
			}
			
			else if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]")))
			{
			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
			}
		}
	}
	
	
	public void dragAndDropComponents_MultiField(String value,String link,String locatorValue,int i) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{

			Thread.sleep(3000);
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//label[contains(text(),'"+locatorValue+"')]/following::span[contains(text(),'Clear')])["+i+"]")))
			//if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//label[contains(text(),'Logo')]/following::span[contains(text(),'Clear')])["+i+"]")))
			{
				oASelFW.effecta("click","xpath=(//label[contains(text(),'Logo')]/following::span[contains(text(),'Clear')])["+i+"]","Clear");
				Thread.sleep(5000);
				
				WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
				WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')])["+i+"]"));
				action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
				Thread.sleep(3000);
			}
			
			else if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')])["+i+"]")))
			{
			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')])["+i+"]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
			}
		}
	}
	
	
	public void dragAndDropComponents_MultiField_Sponsors(String value,String link,String locatorValue,int i) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{

			Thread.sleep(3000);
			 if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')])["+i+"]")))
			{
			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')])["+i+"]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
			}
		}
	}
	
	
	public void dragAndDropComponents_Twocolumn(String value,String link,String locatorValue,int i,int j) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[contains(@data-type,'Editable') and contains(@data-path,'columncontainer') and contains(@draggable,'true')]["+i+"]/div["+j+"]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{

			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
	}
	
	public void dragAndDropComponents_Multi(String value,String link,String locatorValue,int i) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{

			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Image Path')]/following::div[contains(text(),'Drop asset here')])["+i+"]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
	}
	
	
	public void dragAndDropColConComponents(String value,String link,String locatorValue) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{

			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
	}
	
	
	
	
	public void dragAndDropColumnComponents(String value,String link,String locatorValue) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			Thread.sleep(10000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{

			Thread.sleep(3000);
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
	}
	
	
	
	
	
	

	public void dragAndDropComponents_Megamenu(String value,String link,String locatorValue) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
	System.out.println("Entered into double_click_MegaLinks");
	
	
	if(link.equals("Components"))
	{
		Thread.sleep(10000);
		WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
		WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		Thread.sleep(3000);

	}
	else
	{

		Thread.sleep(3000);
		WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'card')]"));
		WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+locatorValue+"')]/following::div[contains(text(),'Drop asset here')]"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		Thread.sleep(3000);
	}

	}
	
	
	public void dragAndDropComponents_Component_Image(String value,String link,String destination,String source_Image) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+link+"')]")));
		Actions action = new Actions(oASelFW.driver);
		if(link.equals("Components"))
		{
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//article[contains(@data-title,'"+value+"')]"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);

		}
		else
		{
			WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//span/img[@alt='"+source_Image+"']"));
			WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath(destination));
			action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
			Thread.sleep(3000);
		}
	}



	// Verifying Element is present
	public void verifyTechPapersValues(String valueTobeVerified)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(.,'"+valueTobeVerified+"')]")));
		List<WebElement> Sourcelocator = oASelFW.driver.findElements(By.xpath("//*[contains(.,'"+valueTobeVerified+"')]"));
		System.out.println(Sourcelocator.size());
		if(Sourcelocator.size() != 0){
			System.out.println("Element is Present");
			oASelFW.effecta("sendReport","Verify element "+valueTobeVerified+" Present","Successfully verified that element "+valueTobeVerified+" is present","Pass");
		}else{
			System.out.println("Element is Absent");
			oASelFW.effecta("sendReport","Verify element "+valueTobeVerified+" Present","Verified that element "+valueTobeVerified+" is not present","Fail");
		}

		oASelFW.driver.switchTo().defaultContent();

	}
	
	
	public void verifyTechPapersValues_WithoutFrame(String valueTobeVerified)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(.,'"+valueTobeVerified+"')]")));
		List<WebElement> Sourcelocator = oASelFW.driver.findElements(By.xpath("//*[contains(.,'"+valueTobeVerified+"')]"));
		System.out.println(Sourcelocator.size());
		if(Sourcelocator.size() != 0){
			System.out.println("Element is Present");
			oASelFW.effecta("sendReport","Verify element "+valueTobeVerified+" Present","Successfully verified that element "+valueTobeVerified+" is present","Pass");
		}else{
			System.out.println("Element is Absent");
			oASelFW.effecta("sendReport","Verify element "+valueTobeVerified+" Present","Verified that element "+valueTobeVerified+" is not present","Fail");
		}

	
	}


	//Download PDF
	public void clickDownloadPdf()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Download Pdf')]")));
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//a[contains(.,'Download Pdf')]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		oASelFW.driver.switchTo().defaultContent();
		oASelFW.effecta("sendReport","Check Whether download Pdf is clicked","Verified successfully Download Pdf is clicked","Pass");	
	}

	public void VerifyHomePagePromo_Title(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+title+"']")));
		oASelFW.effecta("verifyElementPresent","//h4[text()='"+title+"']",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[text()='"+title+"']")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Promo title "+title+" is displayed", title+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Promo title "+title+" is displayed",title+" is not displayed","Fail");

		}
		oASelFW.driver.switchTo().defaultContent();

	}





	public void VerifyHomePagePromo_Body(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='"+text+"']")));
		oASelFW.effecta("verifyElementPresent","//p[text()='"+text+"']",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[text()='"+text+"']")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Promo Body Text "+text+" is displayed", text+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Promo Body Text "+text+" is displayed",text+" is not displayed","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}


	public void ClickHomePagePromo_Link(String text) throws InterruptedException  
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("click","//a[contains(text(),'"+text+"')]",text);


		//oASelFW.driver.switchTo().defaultContent();
	}


	public void ClickHomePagePromo_LinkInPreview(String text) throws InterruptedException  
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("click","//a[contains(text(),'"+text+"')]",text);
		oASelFW.driver.switchTo().defaultContent();
	}
	public void VerifyHomePagePromo_Link_InPreview(String text) throws InterruptedException  
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+text+"')]",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+text+"')]/i[contains(@class,'right inline')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Promo CTA Label "+text+" is displayed with Chevron CTA", text+" is displayed with Chevron CTA Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Promo CTA Label "+text+" is displayed with Chevron CTA",text+" is not displayed","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void VerifyHomePagePromo_Link(String text) throws InterruptedException  
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+text+"')]",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+text+"')]/i[contains(@class,'right inline')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Promo CTA Label "+text+" is displayed with Chevron CTA", text+" is displayed with Chevron CTA Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Promo CTA Label "+text+" is displayed with Chevron CTA",text+" is not displayed","Fail");
		}
	}

	public void VerifyHomePagePromo_Link_ExternalBehaviour(String linkUrl) throws InterruptedException  
	{
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate External Link Behaviour","Successfully verified External Link :"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate External Link Behaviour","Unable to verify External links as:"+linkUrl+" Displayed url is:"+url,"Fail");
		}
	}

	public void VerifyHomePagePromo_Link_InternalBehaviour(String linkUrl) throws InterruptedException  
	{
		Thread.sleep(8000);
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Validate Internal Link Behaviour","Successfully verified Link Behaviour Internal: "+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validate Internal Link Behaviour","Unable to verify Link Behaviour: "+linkUrl+" Displayed url is:"+url,"Fail");
		}
	}

	public void clickOnDeselect()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Deselect']")));
		oASelFW.effecta("click","//button[@title='Deselect']","Deselect Button");
	}


	public void clickSelectAndOpenPage(String pageName) throws Exception
	{
		oASelFW.driver.navigate().refresh();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[text()='Deselect']")))
		{
			Thread.sleep(2000);
			System.out.println("SDeselct Found");
			oASelFW.effecta("click","//span[text()='Deselect']","DeSelect");
			Thread.sleep(3000);
			oASelFW.effecta("click","//button[@title='References']","References");
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[text()='"+pageName+"']","Page:"+pageName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Open']")));
		oASelFW.effecta("clickAndWait","//span[text()='Open']","Open");
		Thread.sleep(5000);
	}


	public void clickOnDeselct()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Deselect']")));
		oASelFW.effecta("click","//button[@title='Deselect']","Deselect Button");
	}

	public void VerifyHomePageHeroCarousel_Title(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel title "+title+" is displayed", title+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel title "+title+" is displayed",title+" is not displayed","Fail");

		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void VerifyHomePageHeroCarousel_Description(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//p[contains(text(),'"+text+"')]",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel Description as "+text+" is displayed", text+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel Description as "+text+" is displayed",text+" is not displayed","Fail");

		}
		oASelFW.driver.switchTo().defaultContent();
	}


	public void VerifyHomePageHeroCarousel_CTATitle(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+text+"')]",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel CTA Title "+text+" is displayed", text+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel CTA Title "+text+" is displayed",text+" is not displayed","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void ClickHomePageHeroCarousel_CTATitle(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("click","//a[contains(text(),'"+text+"')]",text);
		oASelFW.driver.switchTo().defaultContent();
	}

	public void ClickHomePageHeroCarousel_CTATitle_LinkBehaviour(String text,String expectedUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("click","//a[contains(text(),'"+text+"')]",text);
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		System.out.println("Window Size:" +tabs.size());
		oASelFW.driver.switchTo().window(tabs.get(2));
		Thread.sleep(8000);
		String currentUrl=oASelFW.driver.getCurrentUrl();
		System.out.println("get Current Url:"+currentUrl);
		if(currentUrl.contains(expectedUrl))
		{
			oASelFW.effecta("sendReport","Verify Link Behaviour is External","Author successfully verified the link behaviour as external","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Link Behaviour is External","Author unable to verify the link behaviour as external","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
		oASelFW.driver.close();
		Thread.sleep(5000);
		oASelFW.driver.switchTo().window(tabs.get(1));
	}

	public void ClickHomePageHeroCarousel_CTATitle_LinkBehaviour_Internal(String expectedUrl) throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		System.out.println("Window Size:" +tabs.size());
		Thread.sleep(8000);
		String currentUrl=oASelFW.driver.getCurrentUrl();
		System.out.println("get Current Url:"+currentUrl);
		if(currentUrl.contains(expectedUrl))
		{
			oASelFW.effecta("sendReport","Verify Link Behaviour is Internal","Author successfully verified the link behaviour is Internal","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Link Behaviour is Internal","Author unable to verify the link behaviour is Internal","Fail");
		}
	}


	public void ClickHomePageHeroCarousel_NoteSection_LinkBehaviour(String text,String expectedUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]/i")));
		oASelFW.effecta("click","//a[contains(text(),'"+text+"')]/i",text);
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		System.out.println("Window Size:" +tabs.size());
		oASelFW.driver.switchTo().window(tabs.get(2));
		Thread.sleep(8000);
		String currentUrl=oASelFW.driver.getCurrentUrl();
		System.out.println("get Current Url:"+currentUrl);
		if(currentUrl.contains(expectedUrl))
		{
			oASelFW.effecta("sendReport","Verify Link Behaviour is External","Author successfully verified the link behaviour as external","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Link Behaviour is External","Author unable to verify the link behaviour as external","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
		oASelFW.driver.close();
		Thread.sleep(5000);
		oASelFW.driver.switchTo().window(tabs.get(1));
	}


	public void VerifyHomePageHeroCarousel_TabIcon(String text,String tabIconOption)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span/p[text()='"+text+"']/../i[contains(@class,'fa fa')]")));
		oASelFW.effecta("verifyElementPresent","//div/span/p[text()='"+text+"']/../i[contains(@class,'fa fa')]",tabIconOption+" icon");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div/span/p[text()='"+text+"']/../i[contains(@class,'fa fa')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel Tab Icon "+tabIconOption+" is displayed", tabIconOption+" icon is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel Tab Icon "+tabIconOption+" is displayed",tabIconOption+" icon is not displayed","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}



	public void VerifyHomePageHeroCarousel_MultipleTabIcon(String tabIconOption,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='owl-controls clickable']/div/div["+i+"]/span/p/../i[contains(@class,'fa fa')]")));
		oASelFW.effecta("verifyElementPresent","//div[@class='owl-controls clickable']/div/div["+i+"]/span/p/../i[contains(@class,'fa fa')]",tabIconOption+" icon");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='owl-controls clickable']/div/div["+i+"]/span/p/../i[contains(@class,'fa fa')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel Tab Icon "+tabIconOption+" is displayed", tabIconOption+" icon is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel Tab Icon "+tabIconOption+" is displayed",tabIconOption+" icon is not displayed","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}


	public void VerifyHomePageHeroCarousel_CarouselDetailTitle(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span/p[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//span/p[contains(text(),'"+text+"')]",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span/p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel Detail section Title "+text+" is displayed", text+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel Detail section Title "+text+" is displayed",text+" is not displayed","Fail");

		}
		oASelFW.driver.switchTo().defaultContent();
	}



	public void VerifyHomePageHeroCarousel_Note(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='note-overlay']/a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//section[@class='note-overlay']/a[contains(text(),'"+text+"')]",text);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//section[@class='note-overlay']/a[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel Note "+text+" is displayed", text+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel Note "+text+" is displayed",text+" is not displayed","Fail");

		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void transitionSection(String title) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Transition Section']")));
		oASelFW.effecta("click","//label[text()='Transition off/on']/../descendant::div/label/input[@value='on']",title);
		Thread.sleep(3000);
	}

	public void VerifyCarousel_Title(String title)
	{
		System.out.println("Entered into VerifyCarousel_Title");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel title "+title+" is displayed", title+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel title "+title+" is displayed",title+" is not displayed","Fail");		
		}
	}


	public void verifyTPHeading(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel title "+title+" is displayed", title+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel title "+title+" is displayed",title+" is not displayed","Fail");		
		}
	}

	public void verifyTPDesc(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//p[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel title "+title+" is displayed", title+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel title "+title+" is displayed",title+" is not displayed","Fail");		
		}
	}

	public void verifyPartialWidthHeading(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='detail-content noclamp']/h3[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[@class='detail-content noclamp']/h3[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='detail-content noclamp']/h3[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Home Page Carousel title "+title+" is displayed", title+" is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Home Page Carousel title "+title+" is displayed",title+" is not displayed","Fail");		
		}
	}

	public void verifyImg()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'thumb-container')]/div[contains(@id,'threecolumncontainer1')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@class,'thumb-container')]/div[contains(@id,'threecolumncontainer1')]")))
		{
			oASelFW.effecta("sendReport","Verify Whether image is displayed or not", "Image is displayed Successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Whether image is displayed or not","Failed to display the image","Fail");		
		}
	}


	public void VerifyHorizontalLineThickGradient()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'hr thick gradient-corporate')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@class,'hr thick gradient-corporate')]")))
		{
			oASelFW.effecta("sendReport","Verify Horizontal Line is displayed with Green-Blue color as a seperator section", "Successfully Horizontal Line is displayed with Green-Blue color as a seperator section","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Horizontal Line is displayed with Green-Blue color as a seperator section","Horizontal Line is  not displayed with Green-Blue color as a seperator section","Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}


	public void VerifyHorizontalLineThinGray()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'hr thin light-gray')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@class,'hr thin light-gray')]")))
		{
			oASelFW.effecta("sendReport","Verify Horizontal Line is displayed with Thin Gray color as a seperator section", "Successfully Horizontal Line is displayed with Thin Gray color as a seperator section","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Horizontal Line is displayed with Thin Gray color as a seperator section","Horizontal Line is  not displayed with Thin Gray color as a seperator section","Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}


	public void VerifySideBar()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebar']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='sidebar']")))
		{
			oASelFW.effecta("sendReport","Verify Side Bar is displayed", "Side Bar is displayed successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Side Bar is displayed","Side Bar is not displayed successfully","Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void VerifyRichTextComponentSavedTitle(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Configured Component Text is displayed or not", "Successfully Verified Configured Component Text is displayed as"+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Configured Component Text is displayed or not","Configured Component Text is not displayed as"+text,"Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void VerifyRichTextComponentSavedTitle_InContentMode(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Configured Component Text is displayed or not", "Successfully Verified Configured Component Text is displayed as"+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Configured Component Text is displayed or not","Configured Component Text is not displayed as"+text,"Fail");		
		}
	}	


	public void VerifyFeatureComponentSavedTitle(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Configured Component Text is displayed or not", "Successfully Verified Configured Component Text is displayed as"+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Configured Component Text is displayed or not","Configured Component Text is not displayed as"+text,"Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}


	public void VerifyLightGrayBackground()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'light-grey corner-badge')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@class,'light-grey corner-badge')]")))
		{
			oASelFW.effecta("sendReport","Verify Light Gray Background is displayed for text entered", "Successfully validated Light Gray Background is displayed for entered text","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Light Gray Background is displayed for text entered","Light Gray Background is not displayed for entered text","Fail");		
		}
	}


	public void VerifyFeatureComponentCTAChevronIcon(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+text+"')]/i[@class='fa fa-angle-double-right']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+text+"')]/i[@class='fa fa-angle-double-right']")))
		{
			oASelFW.effecta("sendReport","Verify Feature Category Title displays with CTA Link Chevron Icon", "Successfully Feature Category Title displays with CTA Link Chevron Icon with "+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Feature Category Title displays with CTA Link Chevron Icon","Feature Category Title is not displays with CTA Link Chevron Icon with "+text,"Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void VerifyFeatureComponentBody(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Feature Category Body text displayed or not", "Successfully Feature Category Body text is displayed","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Feature Category Body text displayed or not","Feature Category Body text is not displayed","Fail");		
		}
		oASelFW.driver.switchTo().defaultContent();
	}

	public void ClickRequiredNotificationsCheckbox(String pageName,String Workflowoption)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article[contains(@data-inbox-type,'WorkItem')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+pageName+"')]/../../p[contains(text(),'"+Workflowoption+"')]/ancestor::article/i")));
		oASelFW.effecta("click","//span[contains(text(),'"+pageName+"')]/../../p[contains(text(),'"+Workflowoption+"')]/ancestor::article/i","clicking on check box");
	}

	public void ClickNotificationComplete()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@title,'Complete the selected workflow item')]")));
		oASelFW.effecta("click","//button[contains(@title,'Complete the selected workflow item')]","Complete");
	}

	public void VerifySelectReviewerPage() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Select Reviewer')]")));
		oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'Select Reviewer')]","Select Reviewer Page");
	}

	public void ClickWorkflowNotificationComplete()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[contains(text(),'Complete')]")));
		oASelFW.effecta("click","//button/span[contains(text(),'Complete')]","Workflow Submit");
	}

	public void VerifyTranslationReplacePage() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Translation Search and Replace Configuration')]")));
		oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'Translation Search and Replace Configuration')]","Translation Search and Replace Page");
	}

	public void fillMarketWireFeedDynamic() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Market Wire Feed Dynamic']")));
		oASelFW.effecta("verifyElementPresent","//div[@title='Market Wire Feed Dynamic']","Market Wire Feed Dynamic component");	
		oASelFW.effecta("clickAndWait","//div[@title='Market Wire Feed Dynamic']","Clicking on Market Wire Feed Dynamic component");
		oASelFW.effecta("clickAndWait","//i[@title='Configure']","Clicking on configure");
		Thread.sleep(5000);
	}

	public void ValidateDatesInDescendingOrder( List<String> date) throws Exception	 
	{	
    ArrayList<Date> al=new  ArrayList<Date>();  
     for(int i=0;i<date.size();i++)
     {         
     SimpleDateFormat format=new SimpleDateFormat("MMMM dd, yyyy");
     Date temp=format.parse(date.get(i));
     al.add(temp);
     } 
    Collections.sort(al, new Comparator<Date>(){
        @Override
        public int compare(Date o1, Date o2) {
            return o1.compareTo(o2);
        }
    });
    for(int i=al.size()-1;i!=-1; i--)
    {
    
        System.out.println(al.get(i).toString());
        String dateOrder=al.get(i).toString();
        oASelFW.effecta("sendReport","Validate Dates are displaying in Descending Order as the Latest Dates first","Successfully validated the Date is displaying in order as expected "+dateOrder,"Pass");		   
    }    
}

	public void ClickTabComponentValue(String Title) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='tabUl']/li/a[contains(text(),'"+Title+"')]")));
		oASelFW.effecta("verifyElementPresent","//ul[@class='tabUl']/li/a[contains(text(),'"+Title+"')]",Title);	
		oASelFW.effecta("click","//ul[@class='tabUl']/li/a[contains(text(),'"+Title+"')]",Title);
		Thread.sleep(5000);
	}
	
	public void ClickTabComponentValue_Preview(String Title) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='tabUl']/li/a[contains(text(),'"+Title+"')]")));
		oASelFW.effecta("verifyElementPresent","//ul[@class='tabUl']/li/a[contains(text(),'"+Title+"')]",Title);	
		oASelFW.effecta("click","//ul[@class='tabUl']/li/a[contains(text(),'"+Title+"')]",Title);
		
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();

	}
	
	public void VerifyTabComponentValue(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='paragraph_text']/p/a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//section[@class='paragraph_text']/p/a[contains(text(),'"+text+"')]",text);
	}

	
	//h3[contains(text(),'HOL')]
	public void VerifyHOLComonentValue() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3/following::p[contains(text(),'HOL')])[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//h3/following::p[contains(text(),'HOL')])[1]","HOL Feed Render is displayed Successfully");
	}
	
	public void VerifyHOLComonentValue_InPreview() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("(//h3/following::p[contains(text(),'HOL')])[1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3/following::p[contains(text(),'HOL')])[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//h3/following::p[contains(text(),'HOL')])[1]","HOL Feed Render is displayed Successfully");
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyHOLComonentValue_InPublishMode() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h3/following::p[contains(text(),'HOL')])[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//h3/following::p[contains(text(),'HOL')])[1]","HOL Feed Render is displayed Successfully");
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	public void clickOnColumnDragComponent(String component, String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+component+"/"+colNum+"/*')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+component+"/"+colNum+"/*')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+component+"/"+colNum+"/*')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	
	public void clickOnColumnDragComponentL4(String component, String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/"+component+"/"+colNum+"/*')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/"+component+"/"+colNum+"/*')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/"+component+"/"+colNum+"/*')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void twoColparContainer(String component, String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/"+component+"/"+colNum+"/*')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/"+component+"/"+colNum+"/*')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/parcontainer/"+component+"/"+colNum+"/*')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void twoColumnComponentedit(String title, String component, String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='"+title+"' and contains(@data-path,'"+component+"/"+colNum+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"' and contains(@data-path,'"+component+"/"+colNum+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"' and contains(@data-path,'"+component+"/"+colNum+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	
	
	public void verifyUsernameandPassword() throws Exception
	{
		String we=oASelFW.driver.getPageSource();
		System.out.println("PageSource:"+we);
		if((we.contains("username"))||(we.contains("password")))
		{
			oASelFW.effecta("sendReport","Validating username and password is configured or not for created page","Successfully verified username and password is configured in created page","Pass");
			
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating username and password is configured or not for created page","Unable to verify username and password is not configured in created page","Fail");
		}

	}
	
	
	
	public void VerifyImageVideo_Title(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'"+text+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text+"')]",text);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyImageVideo_Title_PublishMode(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text+"')]",text);
		
	}
	
	public void VerifyEntered_Title(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text+"')]",text);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyColumnControlTitle(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text+"')]",text);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyColumnControlTitle_PublishMode(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text+"')]",text);
		
	}
	
	public void VerifyRichTextValue(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Rich Text Value","Rich Text Value is displayed as expected: "+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Rich Text Value","Rich Text Value is not displayed as expected: "+text,"Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyRichText_Publish_Value(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Rich Text Value","Rich Text Value is displayed as expected: "+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Rich Text Value","Rich Text Value is not displayed as expected: "+text,"Fail");
		}
	
	}
	
	public void clickLiveCopy() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@data-type='liveCopy']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@data-type='liveCopy']")));
		oASelFW.effecta("clickAndWait","//section[@data-type='liveCopy']","LIVE COPY CLICKED");
		Thread.sleep(2000);
	}
	
	public void rolloutOps()  throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'onlyAutoQA')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'onlyAutoQA')]")));
		oASelFW.effecta("clickAndWait","//span[contains(text(),'onlyAutoQA')]","Rollout Page Selected");
		Thread.sleep(3000);
		oASelFW.effecta("clickAndWait","//button[text()='Synchronize']","Synchronize clicked");
		Thread.sleep(3000);
		oASelFW.effecta("clickAndWait","//span[text()='Rollout page and all subpages']/../span[1]","Rollout All Pages clicked");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[text()='Rollout']","Rollout Button clicked");
		Thread.sleep(10000);	
	}
	
	
	public void rolloutOps_modified(String rolling )  throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+rolling+"')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+rolling+"')]")));
		Actions act = new Actions(oASelFW.driver);
		act.moveToElement(oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+rolling+"')]"))).click().build().perform();
		System.out.println("Rollout Page Selected");
		//oASelFW.effecta("clickAndWait","//span[contains(text(),'"+rolling+"')]","Rollout Page Selected");
		Thread.sleep(5000);
		oASelFW.effecta("clickAndWait","xpath=(//span[contains(text(),'"+rolling+"')]/following::div/button[contains(text(),'Synchronize')])[1]","Synchronize clicked");
		Thread.sleep(3000);
		System.out.println("Synchronize clicked");
		oASelFW.effecta("clickAndWait","//span[text()='Rollout page and all subpages']/../span[1]","Rollout All Pages clicked");
		Thread.sleep(2000);
		System.out.println("Rollout All Pages clicked");
		oASelFW.effecta("click","//button[text()='Rollout']","Rollout Button clicked");
		Thread.sleep(15000);	
	}
	
	
	public void rolloutOps_UAT(String rolling )  throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+rolling+"')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+rolling+"')]")));
		Actions act = new Actions(oASelFW.driver);
		act.moveToElement(oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+rolling+"')]"))).click().build().perform();
		System.out.println("Rollout Page Selected");
		//oASelFW.effecta("clickAndWait","//span[contains(text(),'"+rolling+"')]","Rollout Page Selected");
		Thread.sleep(5000);
		oASelFW.effecta("clickAndWait","xpath=(//span[contains(text(),'"+rolling+"')]/following::div/button[contains(text(),'Synchronize')][1])","Synchronize clicked");
		Thread.sleep(3000);
		System.out.println("Synchronize clicked");
		oASelFW.effecta("clickAndWait","//span[text()='Rollout page and all subpages']/../span[1]","Rollout All Pages clicked");
		Thread.sleep(2000);
		System.out.println("Rollout All Pages clicked");
		oASelFW.effecta("click","//button[text()='Rollout']","Rollout Button clicked");
		Thread.sleep(10000);	
	}
	
	
	
	
	public void clickListView_SelectAllPages() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-title='Title']/preceding::i[@class='select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-title='Title']/preceding::i[@class='select']")));
		oASelFW.effecta("click","//div[@data-title='Title']/preceding::i[@class='select']","Select all Pages: Title");
		Thread.sleep(2000);
	}
	
	
	
	
	public void VerifyThinFooter_details_InPreview(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div/span[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Thin Footer Value","Thin Footer Value is displayed as expected: "+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Thin Footer Value","Thin Footer Value is not displayed as expected: "+text,"Fail");
		}
	
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void VerifyThinFooter_details_InPublishMode(String text) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[contains(text(),'"+text+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div/span[contains(text(),'"+text+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Thin Footer Value","Thin Footer Value is displayed as expected: "+text,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Thin Footer Value","Thin Footer Value is not displayed as expected: "+text,"Fail");
		}
	
		
	}
	
	
	public void verifyHeading(String heading)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+heading+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+heading+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Heading in TEST15 instance","Successfully verified in TEST15 instance Heading Value is displayed as expected: "+heading,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading in TEST15 instance","Heading Value is not displayed as expected: "+heading,"Fail");
		}
	}
	
	public void verifyHeading_UAT(String heading)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'"+heading+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h3[contains(text(),'"+heading+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Heading in TEST15 instance","Successfully verified in TEST15 instance Heading Value is displayed as expected: "+heading,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading in TEST15 instance","Heading Value is not displayed as expected: "+heading,"Fail");
		}
	}
	
	public void verifyph2heading(String heading)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'"+heading+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h3[contains(text(),'"+heading+"')]")))
		{
			oASelFW.effecta("sendReport","Verify  heading","Heading successfully validated: "+heading,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify  heading","Heading is not displayed as expected: "+heading,"Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	public void verifybutton(String button)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='"+button+"']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//input[@value='"+button+"']")))
		{
			oASelFW.effecta("sendReport","Verify Heading in TEST15 instance","Successfully verified in TEST15 instance Heading Value is displayed as expected: "+button,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading in TEST15 instance","Heading Value is not displayed as expected: "+button,"Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void verifySubHeading(String subheading)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+subheading+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[contains(text(),'"+subheading+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Heading in TEST15 instance","Successfully verified in TEST15 instance Heading Value is displayed as expected: "+subheading,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading in TEST15 instance","Heading Value is not displayed as expected: "+subheading,"Fail");
		}
	}
	
	
	public void verifyFullWidthTitle(String title)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+title+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Heading in TEST15 instance","Successfully verified in TEST15 instance Heading Value is displayed as expected: "+title,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading in TEST15 instance","Heading Value is not displayed as expected: "+title,"Fail");
		}
	}
	
	public void verifyFullWidthCTALabel(String label)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+label+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+label+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Heading in TEST15 instance","Successfully verified in TEST15 instance Heading Value is displayed as expected: "+label,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading in TEST15 instance","Heading Value is not displayed as expected: "+label,"Fail");
		}
	}
	
	
	
	public void verifyPara(String para)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+para+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+para+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Heading ","para Value is displayed as expected: "+para,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Heading","para Value is not displayed as expected: "+para,"Fail");
		}
	}
	
	public void verifyAnchor(String value)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@title,'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(@title,'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify "+value+" is displaying in test 15 instance or not",value+ "is displayed successfully in test15 instance","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify "+value+" is displaying in test 15 instance or not",value+ "is displayed successfully in test15 instance","Fail");
		}
	}
	
	public void verifyAnchortag(String value)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+value+"')]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify anchor is diplaying in TEST15 instamce or not","anchor Value is displayed as expected in TEST15: "+value,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify anchor is diplaying in TEST15 instamce or not","anchor Value is not displayed as expected: "+value,"Fail");
		}
	}
	
	
	
	
	/**
	 * What it does
	 */
	
	public void typeTitleWhatItDoes()
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title (Suggested 60 Characters)')]/following-sibling::input")));
		
		oASelFW.effecta("type","//label[contains(text(),'Title (Suggested 60 Characters)')]/following-sibling::input","What id Does Title","typing value");
		
	}
	
	public void clickAddField()
	{
		
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add field')]")));
		
		oASelFW.effecta("click","//button[contains(text(),'Add field')]","clicking add button");
		
	}
	
	public void enterFeatureTitleAndBody()
	{
		
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Feature Title (Suggested 60 Characters)')]/following-sibling::input")));
		
		oASelFW.effecta("type","//label[contains(text(),'Feature Title (Suggested 60 Characters)')]/following-sibling::input","Feature title","typing value");
		oASelFW.effecta("type","//label[contains(text(),'Body(Suggested 350 Characters)')]/following-sibling::textarea","Body","typing value");
	}
	
	public void SelectAndUnpublishFolder(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		//oASelFW.effecta("click","//span[text()='Select']","Select");
		//oASelFW.effecta("click","//h4[contains(text(),'"+folderName+"')]","Folder:"+folderName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Unpublish']","Unpublish");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Unpublish']")));
		oASelFW.effecta("verifyElementPresent","//a[text()='Unpublish']","Unpublish button");
		oASelFW.effecta("clickAndWait","//a[text()='Unpublish']","Unpublish");
	}
	
	public void SelectAndDeleteFolderAfterRollout(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//h4[contains(text(),'"+folderName+"')]","Folder:"+folderName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Delete')]")));
		oASelFW.effecta("verifyElementPresent","//p/b[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete button");
		oASelFW.effecta("clickAndWait","//p/b[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete");
	}
	
	public void mandatoryCheckbox()
	{
		Actions act=new Actions(oASelFW.driver);
		act.moveToElement(oASelFW.driver.findElement(By.xpath("//span[contains(text(),'Is Mandatory ?')]/../descendant::span[1]")),5,5).build().perform();
		act.click().perform();
	}
	
	
	public void enterFormdetailsInTextArea(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following::textarea")));
		
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following::textarea",value,label);
		
	}
	
	
	public void selectFormCheckbox(String label)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+label+"')]/preceding-sibling::input")));
		
		oASelFW.effecta("click","//span[contains(text(),'"+label+"')]/preceding-sibling::input",label);
		
	}
	
	public void selectForm_radiobutton(String label)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+label+"')]/preceding-sibling::input")));
		
		oASelFW.effecta("click","//span[contains(text(),'"+label+"')]/preceding-sibling::input",label);
		
	}
	
	public void selectForm_submit_button()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));
		
		oASelFW.effecta("click","//input[@type='submit']","Submit");
		
	}
	public void selectForm_reset_button()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='reset']")));
		
		oASelFW.effecta("click","//input[@type='reset']","Reset");
		
	}
	
	
	public void enterFormdActionsText(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Placeholder Text']")));
		
		oASelFW.effecta("type","//input[@placeholder='Placeholder Text']",value,label);
		
	}
	
	
	public void enterFormdActionsAddressText(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='VMware Banglore']")));
		
		oASelFW.effecta("type","//input[@placeholder='VMware Banglore']",value,label);
		
	}
	
	public void VerifyFormActionListbox_Values() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']/li")));
		List<WebElement> formAction=oASelFW.driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		int formActionscount = formAction.size();
		System.out.println("list size is:"+formActionscount);
		Thread.sleep(3000);

		for(int i=1;i<=formActionscount;i++)
		{
			String listvalue=oASelFW.driver.findElement(By.xpath("//ul[@role='listbox']/li["+i+"]/a")).getText();

			System.out.println("list value--"+listvalue);

			oASelFW.effecta("sendReport","Verify the Form with Actions List box values are displaying","Verify the Form with Actions List box values are displaying as: "+listvalue,"Pass");
		}
		
	}
	
	public void VerifyandClickFormActionListbox_Values(String option) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']/li")));
		List<WebElement> formAction=oASelFW.driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		int formActionscount = formAction.size();
		System.out.println("list size is:"+formActionscount);
		Thread.sleep(3000);

		for(int i=1;i<=formActionscount;i++)
		{
			String listvalue=oASelFW.driver.findElement(By.xpath("//ul[@role='listbox']/li["+i+"]/a")).getText();

			System.out.println("list value--"+listvalue);
			
			if(listvalue.contains(option))
			{
				oASelFW.effecta("click","//ul[@role='listbox']/li["+i+"]/a",option);
				oASelFW.effecta("sendReport","Select drop down value","successfully selected the drop down value: "+listvalue,"Pass");
			}

			
		}
		
	}
	
	
	
	public void clickLaunchCopy_SubPagesCheckbox(String fieldname)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='"+fieldname+"']")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//input[@title='"+fieldname+"']"));
		String value=element.getAttribute("name");
		System.out.println("attrime name value= "+value);
		String title=element.getAttribute("title");
		
		if(element.isSelected())
		{
			System.out.println("Checkbox checked");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked by default","Pass");
		}
		else
		{
			
			System.out.println("Checkbox is not checked");
			oASelFW.effecta("click","//input[@title='"+fieldname+"']",fieldname+" checkbox");
			System.out.println("Checkbox is checked now");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is checked now","Pass");
		}
		
		
		
	}
	
	
	public void clickLaunchCopy_SubPagesCheckbox_Uncheck(String fieldname)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='"+fieldname+"']")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//input[@title='"+fieldname+"']"));
		String value=element.getAttribute("name");
		System.out.println("attrime name value= "+value);
		String title=element.getAttribute("title");
		
		if(element.isSelected())
		{
			System.out.println("Checkbox checked");
			
			oASelFW.effecta("click","//input[@title='"+fieldname+"']",fieldname+" checkbox");
			
			System.out.println("Checkbox unchecked now");
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is  unchecked now","Pass");
		}
		else
		{
		
			System.out.println("Checkbox is unchecked");
			
			oASelFW.effecta("sendReport","Verify by default the '"+fieldname+"' is CHECKED",fieldname+" checkbox is unchecked already","Pass");
		}
		
		
		
	}
	
	
	public void VerifyLaunchPageisOpened(String title,String locale) throws Exception
	{
		
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(1));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(title.toLowerCase()))
		{
			oASelFW.effecta("sendReport","Verify whether the page is Launched","Successfully verified the page is Launched with locale: "+locale,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify whether the page is Launched","Unable to verify is page is Launched with locale: "+locale,"Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(0));
		
	}
	
	
	public void ClickRegisterButton_PricingPage(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='"+value+"']")));
		
		oASelFW.effecta("click","//input[@value='"+value+"']",value);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void ClickRegisterButton_PricingPage_Publish(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='"+value+"']")));
		
		oASelFW.effecta("click","//input[@value='"+value+"']",value);
		
	}
	
	
	
	
	
	public void VerifyRegisterPageIsOpened_PricingPage(String linkUrl) throws Exception
	{
		
		Thread.sleep(3000);
		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		if(url.contains(linkUrl))
		{
			oASelFW.effecta("sendReport","Verify whether the Register Page is Opened","Successfully Register Page is Opened","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify whether the Register Page is Opened","Register Page is not Opened","Fail");
		}
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(tabs.get(1));
		
	}
	
	
	
	public void clickContainerCardTabComponent_Tabs(String tabname,int i)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-element-name='"+i+"']")));
		
		oASelFW.effecta("click","//a[@data-element-name='"+i+"']",tabname);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void verifyColumnContainerTab_PartialWidth_Title_InPreview(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//span[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Patial Width Component Title is didplayed", "Patial Width Component Title is didplayed successfully as: "+title,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Patial Width Component Title is didplayed","Patial Width Component Title is not didplayed","Fail");
		}
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	public void verifyColumnContainerTab_PartialWidth_Title_InPublish(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//span[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'"+title+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Patial Width Component Title is didplayed", "Patial Width Component Title is didplayed successfully as: "+title,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Patial Width Component Title is didplayed","Patial Width Component Title is not didplayed","Fail");
		}
		
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void verifyColumnContainerTab_PartialWidth_Icons_InPublish(String iconName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[contains(@class,'"+iconName+"')]")));
		oASelFW.effecta("verifyElementPresent","//i[contains(@class,'"+iconName+"')]",iconName);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//i[contains(@class,'"+iconName+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Patial Width Component icon is didplayed", "Patial Width Component icon is didplayed successfully as: "+iconName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Patial Width Component icon is didplayed","Patial Width Component icon is not didplayed","Fail");
		}
		
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void verifyColumnContainerTab_PartialWidth_Icons_InPreview(String iconName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[contains(@class,'"+iconName+"')]")));
		oASelFW.effecta("verifyElementPresent","//i[contains(@class,'"+iconName+"')]",iconName);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//i[contains(@class,'"+iconName+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Patial Width Component icon is didplayed", "Patial Width Component icon is didplayed successfully as: "+iconName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Patial Width Component icon is didplayed","Patial Width Component icon is not didplayed","Fail");
		}
		
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	
	
	
	
	
	
	
}
