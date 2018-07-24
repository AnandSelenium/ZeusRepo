package classes.aem;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMNewsAndEventsPage {
	ArsinSeleniumAPI oASelFW;

	public AEMNewsAndEventsPage(){

	}
	public AEMNewsAndEventsPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}


	public void NewsAndEventsEntry_NewsLink()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'News')]")));

		oASelFW.effecta("click","//a[contains(text(),'News')]","News Link");

	}


	public void NewsAndEventsEntry_NewsLinkBrowse(String label)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following::button[@title='Browse']")));

		oASelFW.effecta("click","//label[text()='"+label+"']/following::button[@title='Browse']",label+" Browse");

	}


	public void NewsAndEventsEntry_EventsLinkBrowse(String label)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following::button[@title='Browse']")));

		oASelFW.effecta("click","//label[text()='"+label+"']/following::button[@title='Browse']",label+" Browse");

	}

	//label[text()='Link']/ancestor::div[contains(@class,'active')]//label[text()='Link']/following-sibling::span
	public void NewsAndEventsEntry_EventsPageLinkBrowse()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Link']/ancestor::div[contains(@class,'active')]//label[text()='Link']/following-sibling::span")));

		oASelFW.effecta("click","//label[text()='Link']/ancestor::div[contains(@class,'active')]//label[text()='Link']/following-sibling::span"," Events Page Link Browse");

	}

	public void NewsAndEventsEntry_EventsLink()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Events')]")));

		oASelFW.effecta("click","//a[contains(text(),'Events')]","Events Link");

	}

	public void VerifyNewsAndEventsEntryWindowTitle() throws Exception{

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'News And Events Entry')]")))
		{
			oASelFW.effecta("sendReport","Verify News and Events Entry is displaying","News and Events Entry is displayed successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify News and Events Entry is displaying","News and Events Entry is not displayed successfully","Fail");

		}
	}

	//label[text()='Heading']/following::input
	public void NewsAndEventsEntry_NewsFields(String fieldName,String Value)
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::input")));

		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following-sibling::input",Value,fieldName);

	}


	public void VerifyNews_Events_Heading(String fieldName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+fieldName+"')]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h1[contains(text(),'"+fieldName+"')]")))
		{

			oASelFW.effecta("sendReport","Verify News and Events Heading","News and Events Heading is displayed as expected: "+fieldName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify News and Events Heading","News and Events Heading is not displayed as expected: "+fieldName,"Fail");

		}

	}




	public void VerifyNews_Events_Title(String fieldName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+fieldName+"')]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[contains(text(),'"+fieldName+"')]")))
		{

			oASelFW.effecta("sendReport","Verify News and Events Title","News and Events Title is displayed as expected: "+fieldName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify News and Events Title","News and Events Title is not displayed as expected: "+fieldName,"Fail");

		}

	}


	public void VerifyNews_Events_CalendarValidate()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='date_calender']")));

		String title=oASelFW.effecta("getText","//div[@class='date_calender']","Calendar Date");

		System.out.println("Calendar Date: "+title);


	}


	public void NewsAndEventsEntry_EventsFields(String label,String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/ancestor::div[contains(@class,'active')]//label[text()='"+label+"']/following-sibling::input")));

		oASelFW.effecta("type","//label[text()='"+label+"']/ancestor::div[contains(@class,'active')]//label[text()='"+label+"']/following-sibling::input",Value,label);

	}


	public void NewsAndEventsEntry_Events_LinksFields(String label,String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/ancestor::div[contains(@class,'active')]//label[text()='"+label+"']/following::input")));

		oASelFW.effecta("type","//label[text()='"+label+"']/ancestor::div[contains(@class,'active')]//label[text()='"+label+"']/following::input",Value,label);

	}


	public void NewsAndEventsEntry_ViewAllEventsLabel(String Value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='View All Events Label']/following::input")));

		oASelFW.effecta("type","//label[text()='View All Events Label']/following::input",Value,"Events View All Events Label");

	}

	public void ContentRoot_Assets()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-header1455794781093-message']/div[2]/div/nav/div/a/div[2]")));

		oASelFW.effecta("click","//div[@id='modal-header1455794781093-message']/div[2]/div/nav/div/a/div[2]","Assets");

	}
	//div[@id='modal-header1455794781093-message']/div[2]/div/nav[2]/div/a[7]/div[2]

	public void News_TargetSelect(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Target']/following-sibling::span/select")));

		oASelFW.effecta("select","//label[text()='Target']/following-sibling::span/select",option,"Target");

	}

	//label[text()='Target']/ancestor::div[contains(@class,'active')]//label[text()='Target']/following::select




	public void Events_TargetSelect(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Target']/ancestor::div[contains(@class,'active')]//label[text()='Target']/following::select")));

		oASelFW.effecta("select","//label[text()='Target']/ancestor::div[contains(@class,'active')]//label[text()='Target']/following::select",option,"Events Target");
		//label[text()='Heading']/ancestor::div[contains(@class,'active')]//label[text()='Heading']/following-sibling::input
	}


	public void Events_StyleSelect(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Style']/ancestor::div[contains(@class,'active')]//label[text()='Style']/following::select")));

		oASelFW.effecta("select","//label[text()='Style']/ancestor::div[contains(@class,'active')]//label[text()='Style']/following::select",option,"Events Style");

	}


	public void News_StyleSelect(String option)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Style']/following-sibling::span/select")));

		oASelFW.effecta("select","//label[text()='Style']/following-sibling::span/select",option,"Style");

	}



	public void News_Link_ContentRootPath() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'display: block') and @role='dialog']//a[@title='Assets']")));

		oASelFW.effecta("click","//div[contains(@style,'display: block') and @role='dialog']//a[@title='VMware']","VMware");

		Thread.sleep(3000);

		oASelFW.effecta("click","//div[contains(@style,'display: block') and @role='dialog']//a[@title='Language Master Sites']","Language Master Sites");

		Thread.sleep(3000);

		oASelFW.effecta("click","//div[contains(@style,'display: block') and @role='dialog']//a[@title='English']","English");

		Thread.sleep(3000);

		oASelFW.effecta("click","//div[contains(@style,'display: block') and @role='dialog']//a[@title='My_VMware']","My_VMware");

		Thread.sleep(3000);

		oASelFW.effecta("click","//div[contains(@style,'display: block') and @role='dialog']//a[@title='Sample']","Sample");



	}


	public void News_Links_Path(String title,String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+title+"']/following::input")));


		oASelFW.effecta("type","//label[text()='"+title+"']/following::input",value,title);



	}




	public void ContentRoot_ConfirmIcon()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Confirm']/i")));

		oASelFW.effecta("click","//button[@title='Confirm']/i","Confirm");

	}


	//label[text()='Date']/following::button[@title='Date Picker']
	public void Events_DatePicker_SelectDate(String date) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Date']/following::div/input")));

		oASelFW.effecta("type","//label[text()='Date']/following::div/input",date,"DatePicker");



	}

	public void verifyCalender(Date today) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='date_calender']/strong")));

		//oASelFW.effecta("type","//label[text()='Date']/following::div/input",date,"DatePicker");
		String month=oASelFW.effecta("getText","//div[@class='date_calender']/strong","Month");

		System.out.println("Calendar Month :"+month);

		//div[@class='date_calender']/strong

		String caldate=oASelFW.effecta("getText","//i[@class='fa fa-calendar-o']/small","date");

		System.out.println("Calendar date :"+caldate);


		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = cal.getTime();

		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");

		String reportDate = date.format(yesterday);

		String dateFortmat[]=reportDate.split(" ");

		String mondate[]=dateFortmat[0].split("-");

		String mon=mondate[1];
		String dd=mondate[2];

		Format formatter = new SimpleDateFormat("MMM");
		String sd1 = formatter.format(yesterday);
		System.out.println(sd1+" "+reportDate);


		// today date
		reportDate = date.format(today);

		String dateFortmat1[]=reportDate.split(" ");

		String mondate1[]=dateFortmat1[0].split("-");

		mon=mondate1[1];
		String dd1=mondate1[2];

		String sd2 = formatter.format(today);
		System.out.println(sd2+" "+reportDate);

		if((month.equalsIgnoreCase(sd1) || month.equalsIgnoreCase(sd2)) && (caldate.equalsIgnoreCase(dd) || caldate.equalsIgnoreCase(dd1)))
		{
			oASelFW.effecta("sendReport","Verify Calendar Month and Date is displayed as expected","Calendar Month: "+month+" and date: "+caldate+" is displayed as extected","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Calendar Month and Date is displayed as expected","Calendar Month and Date is not displayed as expected","Fail");

		}
	}


	public void clickOnCaret() throws InterruptedException
	{

		WebElement element = oASelFW.driver.findElement(By.xpath("(//button[contains(@type,'button')])[4]"));
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
	}


	public void mouseOverAndClickOnButton() throws InterruptedException
	{

		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//span[contains(text(),'Cloud')])[3]/.."))).build().perform();
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//span[contains(text(),'Cloud')])[3]/..","clicking on caret");
	}

	public void verifyRecordPresent() throws InterruptedException
	{

		Thread.sleep(6000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'Veera Event 7')]")))
		{
			oASelFW.effecta("sendReport","Validating record present","Successfully validate the record","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Validating record present","validate the record is not present","Fail");

		}
	}

	public void validatingTargettingButton() throws InterruptedException
	{
		oASelFW.effecta("click","//i[contains(@class,'coral-Icon coral-Icon--chevronDown coral-Icon--sizeXS')]","Drop Down Clicked");
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[text()='Targeting']")))
		{
			oASelFW.effecta("sendReport","validating Targetting Button","Successfully validating Targetting Button","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","validating Targetting Button","validating Targetting Button not present","Fail");

		}
	}




	public void clickOnAnotherField() throws InterruptedException
	{
		WebElement element = oASelFW.driver.findElement(By.xpath("(//span[contains(@class,'colm-arrow')])[1]"));
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);


	}
	
	public void clickOnColumn() throws InterruptedException
	{
		WebElement element = oASelFW.driver.findElement(By.xpath("//p[contains(text(),'Columns')]"));
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);


	}


	public void mouseOverAndClickOnButton1() throws InterruptedException
	{

		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//span[contains(text(),'Total Sockets')])[3]"))).build().perform();
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//span[contains(text(),'Total Sockets')])[3]","clicking on caret");
	}


	public void clickOnPublisherButton()
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Sort by:')]/following::button")));
		oASelFW.effecta("click","//span[contains(text(),'Sort by:')]/following::button","clicking on button");
	}


	public void clickOnApplyFilter2()
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'applyTopFilter')]")));
		oASelFW.effecta("click","//input[contains(@id,'applyTopFilter')]","clicking on button");
	}
	
	public void clickOnApply()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Apply']")));
		oASelFW.effecta("click","//input[@value='Apply']","clicking on Apply button");
	}


	public void mouseOverAndClickOnPublisherButton() throws InterruptedException
	{

		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//span[text()='Publisher (A-Z)']"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//span[text()='Publisher (A-Z)']"))).build().perform();
		oASelFW.effecta("click","//span[text()='Publisher (A-Z)']","clicking on publisher");
	}

	public void clickOnHp() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//input[contains(@id,'hp')]/following-sibling::label"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);



	}


	public void clickOnVmware() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//input[contains(@id,'vmware')]/following-sibling::label"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);



	}


	public void clickOnVsphere5() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//input[contains(@id,'vsphere 5')]/following-sibling::label"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);



	}



	public void clickOnApplyFilter() throws InterruptedException
	{

		WebElement element = oASelFW.driver.findElement(By.xpath("//input[contains(@id,'applyFilters')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		oASelFW.effecta("click","//input[contains(@id,'applyFilters')]","clicking on Apply");


	}



	public void validatingHeading() throws InterruptedException
	{

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'Total Sockets')]")))
		{

			oASelFW.effecta("sendReport","validating link","Successfully validating link","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","validating link","validating link not present","Fail");

		}
	}
	
	public void validatingCores() throws InterruptedException
	{

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//form[@id='colmFilterForm']/*[contains(.,'Total Cores')]/label")))
		{

			oASelFW.effecta("sendReport","validating link","Successfully validating link","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","validating link","validating link not present","Fail");

		}
	}



	public void validatingLinkText() throws InterruptedException
	{

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'Why the right architecture matters with vSphere')]")))
		{

			oASelFW.effecta("sendReport","validating link","Successfully validating link","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","validating link","validating link not present","Fail");

		}
	}

	public void validatingLinkText1() throws InterruptedException
	{

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'VMware vCenter Server 6.0 Performance and Best Practices')]")))
		{

			oASelFW.effecta("click","//a[contains(text(),'VMware vCenter Server 6.0 Performance and Best Practices')]/following::a[1]","clicking on download PDF");
			oASelFW.effecta("sendReport","validating link","Successfully validating link","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","validating link","validating link not present","Fail");

		}
	}
	
	public void clickonCores() throws InterruptedException
	{

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//form[@id='colmFilterForm']/*[contains(.,'Total Cores')]/label/label")))
		{

			oASelFW.effecta("click","//form[@id='colmFilterForm']/*[contains(.,'Total Cores')]/label/label","Selecting Total Cores");
			oASelFW.effecta("sendReport","Clicking on Total cores Checkbox","Successfully clicked on total cores checkbox","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Clicking on Total cores Checkbox"," link not present","Fail");

		}
	}
	



	public void clickOnCustomerButton() throws InterruptedException
	{

		WebElement element = oASelFW.driver.findElement(By.xpath("//button[contains(@class,'btn dropdown-toggle btn-default')]"));
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void clickOnCustomerButton1() throws InterruptedException
	{

		WebElement element = oASelFW.driver.findElement(By.xpath("(//button[contains(@class,'btn dropdown-toggle btn-default')])[2]"));
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}




	public void mouseOverAndClickOnLink2() throws InterruptedException
	{

		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//ul[contains(@class,'dropdown-menu inner')]/li[2]/a)[2]"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//ul[contains(@class,'dropdown-menu inner')]/li[2]/a)[2]"))).build().perform();
		oASelFW.effecta("click","xpath=(//ul[contains(@class,'dropdown-menu inner')]/li[2]/a)[2]","clicking on link");
		Thread.sleep(8000);
	}



	public void mouseOverAndClickOnCountry(String value) throws InterruptedException
	{

		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]/../../a"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]/../../a"))).build().perform();
		oASelFW.effecta("click","//span[contains(text(),'"+value+"')]/../../a","clicking on country");
		Thread.sleep(8000);
	}


	public void mouseOverAndClickOnlink() throws InterruptedException
	{

		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu inner')]/li[1]/a"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu inner')]/li[1]/a"))).build().perform();
		oASelFW.effecta("click","//ul[contains(@class,'dropdown-menu inner')]/li[1]/a","clicking on country");
		Thread.sleep(8000);
	}





	public void clickPDFToDownload() throws InterruptedException
	{

		WebElement element = oASelFW.driver.findElement(By.xpath("(//a[contains(text(),'PDF')])[1]"));
		Thread.sleep(5000);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	
	public void verifyPagenation() throws InterruptedException
	{
		Thread.sleep(8000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//ul[@id='pagination']")))
		{
			oASelFW.effecta("sendReport","Validating page nation","Validate successfully","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Validating page nation","Validate successfully","Fail");
		}
	}

	public String getPageurl()
	{
		String currentURL = oASelFW.driver.getCurrentUrl();
		return currentURL;	
		
	}


}