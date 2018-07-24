package classes.lampdatamigration;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.util.StringTokenizer;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;


/**
 * @author Swathi Namburi
 * @Page Lamp Events
 */


public class LampEvents {


	ArsinSeleniumAPI oASelFW;


	public LampEvents(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}


	public void VerifyEventsPage(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'"+text+"')]",text);

	}


	public void VerifyCreatedEventsPage(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Events')]")));
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+text+"')]",text);
		//oASelFW.driver.switchTo().defaultContent();
	}

	public void Events_SelectEventType(String option) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Event Type')]/following::div/input[@value='"+option+"']")));
		oASelFW.effecta("click","//label[contains(text(),'Event Type')]/following::div/input[@value='"+option+"']",option);

	}

	public void Events_EnterEventName(String label,String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following::div/input")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following::div/input",value);
	}



	public String createEvent(String EventName,String option) throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Events')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));

		//-----------------------Clicking_On_Event_Type_Radio_Button---------------------------//
		/*oASelFW.effecta("click","//label[contains(text(),'Event Type')]/following::div/input[@value='"+option+"']","Event Type");
		Thread.sleep(5000);*/
		//*************************************************************************************//

		//-----------------------------Entering_Event_Name-------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Name')]/following::div/input",EventName,"Event Name");
		Thread.sleep(5000);
		System.out.println("After wait");
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		//*************************************************************************************//

		//------------------------------------------Region-------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Region')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]","Europe","Typing Europe");
		Thread.sleep(6000);
		Actions action = new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(text(),'Event Regions : ')][2]"))).build().perform();
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'Event Regions : ')][2]","clicking on europe");
		Thread.sleep(5000);
		//**************************************************************************************

		//-------------------------------------------Country------------------------------------
		oASelFW.effecta("type","//label[contains(text(),'Country')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]","Netherland","Typing Europe");
		Thread.sleep(6000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(text(),'Event Regions : Europe / the ')][1]"))).build().perform();
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'Event Regions : Europe / the ')][1]","clicking on europe");
		//***************************************************************************************

		//---------------------------Entering_Location-----------------------------------------
		oASelFW.effecta("type","//label[contains(text(),'Location')]/following::div/input","europe","Location");
		Thread.sleep(3000);
		//**************************************************************************************//

		//--------------------------Locale--Language---------------------------------------//
		WebElement element4 = oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img"));
		executor1.executeScript("arguments[0].click();", element4);
		Thread.sleep(5000);
		oASelFW.effecta("click","//span[contains(text(),'Japan')]","Clicked Japanese");
		Thread.sleep(8000);
		WebElement el4=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		el4.sendKeys(Keys.ESCAPE);
		Thread.sleep(5000);
		//************************************************************************************//

		//---------------------Enter_Event_Listing_Start_Date----------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Listing start date')]/following::table//div/input","2016-04-25","Event Listing start date");
		Thread.sleep(3000);
		//**************************************************************************************//

		//------------------------Event_Listing_Time-------------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Listing start date')]/following::table//tr/descendant::td[2]/div/input","4:30 PM","Event Listing Time");
		Thread.sleep(3000);
		//**************************************************************************************//

		//---------------------------------Enter_Event_Start_Date-----------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Start date')]/following::div/input","2016-04-26","Event Start date");			
		Thread.sleep(3000);
		//****************************************************************************************//

		//------------------------------CLICK BUTTON------------------------------------------//
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		//*******************************************************************************************//

		return EventName;
	}



	public void VerifyEventsPageDetails(String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//div[contains(text(),'"+value+"')]")));
		oASelFW.effecta("verifyElementPresent","//table//div[contains(text(),'"+value+"')]",value);
		oASelFW.driver.switchTo().defaultContent();
	}






	public String createEvent_sit(String EventName,String region,String country) throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Events')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));



		//-----------------------------Entering_Event_Name-------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Name')]/following::div/input",EventName,"Event Name");
		Thread.sleep(5000);
		System.out.println("After wait");
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		//*************************************************************************************//

		//------------------------------------------Region-------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Region')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]",region,"Typing Europe");
		Thread.sleep(6000);
		Actions action = new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//b[contains(text(),'"+region+"')]"))).build().perform();
		Thread.sleep(6000);
		oASelFW.effecta("click","//b[contains(text(),'"+region+"')]","clicking on europe");
		Thread.sleep(5000);
		//**************************************************************************************

		//-------------------------------------------Country------------------------------------
		oASelFW.effecta("type","//label[contains(text(),'Country')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]",country,"Typing Europe");
		Thread.sleep(6000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//b[contains(text(),'"+country+"')]"))).build().perform();
		Thread.sleep(6000);
		oASelFW.effecta("click","//b[contains(text(),'"+country+"')]","clicking on europe");
		//***************************************************************************************

		//---------------------------Entering_Location-----------------------------------------
		oASelFW.effecta("type","//label[contains(text(),'Location')]/following::div/input",country,"Location");
		Thread.sleep(3000);
		//**************************************************************************************//

		//--------------------------Locale--Language---------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Locale')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]",country,"Typing Europe");
		Thread.sleep(6000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//b[contains(text(),'"+country+"')]"))).build().perform();
		Thread.sleep(6000);
		oASelFW.effecta("click","xpath=(//b[contains(text(),'"+country+"')])[2]","clicking on europe");
		Thread.sleep(5000);
		//************************************************************************************//

		//---------------------Enter_Event_Listing_Start_Date----------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Listing start date')]/following::table//div/input","2016-04-25","Event Listing start date");
		Thread.sleep(3000);
		//**************************************************************************************//
		
		
		//---------------------Enter_Event_Listing_End_Date----------------------------------//
		oASelFW.effecta("type","xpath=(//label[text()='Event Listing end date']/following::table//div/input)[1]","2016-06-01","Event Listing end date");
		Thread.sleep(3000);
		//**************************************************************************************//

		//------------------------Event_Listing_Time_Start-------------------------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Listing start date')]/following::table//tr/descendant::td[2]/div/input","4:30 PM","Event Listing Time");
		Thread.sleep(3000);
		//**************************************************************************************//
		
		//------------------------Event_Listing_Time_End-------------------------------------------//
		oASelFW.effecta("type","xpath=(//label[text()='Event Listing end date']/following::table//div/input)[2]","5:30 PM","Event Listing Time");
		Thread.sleep(3000);
		//**************************************************************************************//


		//---------------------------------Enter_Event_Start_Date-----------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event Start date')]/following::div/input","2016-04-26","Event Start date");			
		Thread.sleep(3000);
		//****************************************************************************************//
		
		//---------------------------------Enter_Event_Start_Date-----------------------------//
		oASelFW.effecta("type","//label[contains(text(),'Event End date')]/following::div/input","2016-06-01","Event End date");			
		Thread.sleep(3000);
		//****************************************************************************************//


		//--------------------------------Event_Type------------------------------------------------//
		oASelFW.effecta("click","//label[contains(text(),'Event Type(s)')]/following-sibling::div/div/div/div/div/div/following-sibling::img","Event Type Clicked");
		Thread.sleep(6000);
		oASelFW.effecta("click","//span[contains(text(),'vForum')]","clicking on Vforum");
		WebElement ele=oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Event Type(s)')]/following-sibling::div/div/div/div/div/div/following-sibling::img/preceding::input[1]"));
		ele.sendKeys(Keys.ESCAPE);
		//------------------------------------------------------------------------------------------//

		//---------------------------------Event_Sub_Type-------------------------------------------//
		oASelFW.effecta("click","//label[contains(text(),'Event Sub-Type')]/following::div/input[@value='In Person']","Event Sub Type");
		Thread.sleep(5000);
		//----------------------------------------------------------------------------------------------//


		//------------------------------CLICK BUTTON------------------------------------------//
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		Thread.sleep(5000);
		//*******************************************************************************************//

		return EventName;
	}

}




