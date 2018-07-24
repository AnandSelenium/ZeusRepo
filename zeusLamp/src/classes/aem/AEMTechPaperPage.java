package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class AEMTechPaperPage {
	ArsinSeleniumAPI oASelFW;

	public AEMTechPaperPage(){

	}
	public AEMTechPaperPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}

	public void verifyLocalizedSearchPage(String search) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+search+"']")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='"+search+"']"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
		}
	}

	public void LocalizedspecificValidSearch(String search, String item){
		try{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+search+"']")));
			oASelFW.effecta("verifyElementPresent","//h2[text()='"+search+"']","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//span[text()='Filter By']","Search Box");	
			oASelFW.effecta("type","//input[@name='q']",item,"Entering Values in Search Box");
			WebElement we=oASelFW.driver.findElement(By.xpath("//input[@name='q']"));
			Thread.sleep(2000);
			we.sendKeys(Keys.ENTER);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void verifyLocalizedCategoryTypeSubSection(String search,String selectItem)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+search+"']")));
			oASelFW.effecta("verifyElementPresent","//h2[text()='"+search+"']","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//span[text()='Filter By']","Search Box");	
			Thread.sleep(6000);
			// Verifying below under Product section
			//Verifying Vsphere5
			oASelFW.effecta("verifyElementPresent","//h4[text()='Product']/following::label[contains(.,'vsphere 5')]/input","Vsphere 5 option in Product section");
			//Verifying Vsphere4
			oASelFW.effecta("verifyElementPresent","//h4[text()='Product']/following::label[contains(.,'vsphere 4')]/input","Vsphere 4 option in Product section");
			//Verifying esx 4
			oASelFW.effecta("verifyElementPresent","//h4[text()='Product']/following::label[contains(.,'esx 4')]/input","esx 4  option in Product section");

			// Verifying below under Publisher section
			//Verifying vmware
			oASelFW.effecta("verifyElementPresent","//h4[text()='Publisher']/following::label[contains(.,'vmware')]/input","vmware option in Publisher section");
			//Verifying cisco
			oASelFW.effecta("verifyElementPresent","//h4[text()='Publisher']/following::label[contains(.,'cisco')]/input","cisco option in Publisher section");

			//Click on vsphere 5 in Product click on Apply Filers to verify results
			//click Vsphere 5
			JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
			jse.executeScript("window.scrollBy(0,200)", "");
			oASelFW.effecta("clickAndWait","//h4[text()='Product']/following::label[contains(.,'vsphere 5')]/label","Web option in Type section");
			Thread.sleep(3000);

			//Click on Apply Filter
			oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
			Thread.sleep(20000);
			System.out.println("Clicked");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'1-10')]")));
			String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//p/span[contains(text(),'vsphere')]")));
			System.out.println(text);

			if(text.contains(selectItem))
			{
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found "+text,"Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//**********************************FOR TEST15 INSTANCE****************************************************//
	
	public void verifyLocalizedSearchPage_test15(String search) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='"+search+"']")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h1[text()='"+search+"']"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
		}
	}
	
	public void LocalizedspecificValidSearch_test15(String search, String item){
		try{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='"+search+"']")));
			oASelFW.effecta("verifyElementPresent","//h1[text()='"+search+"']","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//span[text()='Filter By']","Search Box");	
			oASelFW.effecta("type","//span[text()='Filter By']/../span/following::div/input",item,"Entering Values in Search Box");
			WebElement we=oASelFW.driver.findElement(By.xpath("//span[text()='Filter By']/../span/following::div/input"));
			Thread.sleep(2000);
			we.sendKeys(Keys.ENTER);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void verifyLocalizedCategoryTypeSubSection_test15(String search,String selectItem)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='"+search+"']")));
			oASelFW.effecta("verifyElementPresent","//h1[text()='"+search+"']","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//span[text()='Filter By']","Search Box");	
			Thread.sleep(6000);
			// Verifying below under Product section
			//Verifying Vsphere5
			oASelFW.effecta("verifyElementPresent","//h4[text()='Product']/following::label[contains(.,'vsphere 5')]/input","Vsphere 5 option in Product section");
			//Verifying Vsphere4
			oASelFW.effecta("verifyElementPresent","//h4[text()='Product']/following::label[contains(.,'vsphere 4')]/input","Vsphere 4 option in Product section");
			//Verifying esx 4
			oASelFW.effecta("verifyElementPresent","//h4[text()='Product']/following::label[contains(.,'esx 4')]/input","esx 4  option in Product section");

			// Verifying below under Publisher section
			//Verifying vmware
			oASelFW.effecta("verifyElementPresent","//h4[text()='Publisher']/following::label[contains(.,'vmware')]/input","vmware option in Publisher section");
			//Verifying cisco
			oASelFW.effecta("verifyElementPresent","//h4[text()='Publisher']/following::label[contains(.,'cisco')]/input","cisco option in Publisher section");

			//Click on vsphere 5 in Product click on Apply Filers to verify results
			//click Vsphere 5
			JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
			jse.executeScript("window.scrollBy(0,200)", "");
			oASelFW.effecta("clickAndWait","//h4[text()='Product']/following::label[contains(.,'vsphere 5')]/label","Web option in Type section");
			Thread.sleep(3000);

			//Click on Apply Filter
			oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
			Thread.sleep(20000);
			System.out.println("Clicked");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'1-10')]")));
			String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//p/span[contains(text(),'vsphere')]")));
			System.out.println(text);

			if(text.contains(selectItem))
			{
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found "+text,"Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void click_Submit(String heading)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+heading+"')]")));	
		oASelFW.effecta("click","//input[@id='submitBtn']","Submit clicked");
	}
	
	public void click_Submit_locale() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='submitBtn']")));	
		Thread.sleep(5000);
		// oASelFW.effecta("click","//input[@id='submitBtn']","Submit clicked");
		oASelFW.driver.findElement(By.xpath("//input[@id='submitBtn']")).click();
		oASelFW.effecta("sendReport","Click on Submit Button","Clicked on Submit Button","Pass");
		// JavascriptExecutor jse=(JavascriptExecutor)oASelFW.driver;
		 // jse.executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//input[@id='submitBtn']")));
		
	}
	
	
	public void click_Submit_locale_JP() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@valign='top'])[1]/following::input[@type='submit']")));	
		Thread.sleep(5000);
		// oASelFW.effecta("click","//input[@id='submitBtn']","Submit clicked");
		oASelFW.driver.findElement(By.xpath("(//td[@valign='top'])[1]/following::input[@type='submit']")).click();
		oASelFW.effecta("sendReport","Click on Submit Button","Clicked on Submit Button","Pass");
		// JavascriptExecutor jse=(JavascriptExecutor)oASelFW.driver;
		 // jse.executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//input[@id='submitBtn']")));
		
	}
	
	public void verify_MainHeading(String heading)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
		System.out.println("Entered into Verify Main Heading..........");
		/*JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
		je.executeScript("window.scrollBy(0,-250)", "");*/
		
		//(//span[contains(text(),'Company')]//following::h2)[1]
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1)[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//h1)[1]","MainHeading Verified "+heading);
	}
	
	public void verify_MainHeading_locale(String heading)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//h2)[1]","MainHeading Verified "+heading);
	}
	
	public void verify_SubHeading(String SubHeading)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1)[1]")));
		//(//span[contains(text(),'Company')]//following::h2)[2]
		
		if (oASelFW.driver.findElements(By.xpath("(//h2)[2]")).size()>0)
		{
		oASelFW.effecta("verifyElementPresent","xpath=(//h2)[2]","SubHeading Verified "+SubHeading);
		}
		else
		{
		oASelFW.effecta("verifyElementPresent","xpath=(//h3)[1]","SubHeading Verified "+SubHeading);
			
		}
	}
	
	public void verify_Description(String description)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		//(//span[contains(text(),'Company')]//following::p)[1]
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p)[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//p)[1]","Description Verified "+description);
	}
	
	public void verify_Tags(String tags)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+tags+"')]")));
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+tags+"')]","Tags Verified"+tags);
	}
	
	public void errorValidation(String[] error)
	{
		for(int i=0;i<error.length;i++)
		{
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@id,'"+error[i]+"')]")))
		{
			oASelFW.effecta("sendReport","Checking Error Messaging Apperaring Or not"+error[i],"Successfully verified error message are coming"+error[i],"Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Checking Error Messaging Apperaring Or not","Unable to verify error messages"+error[i],"Fail");
		}
		
		}
	}
	
	public void form_filling(String heading,String header, String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+heading+"')]")));
		oASelFW.effecta("type","//label[text()='"+header+"']/../following::div/input",text,"Heading "+header);
	}
	
	public void form_filling_locale(String position,String header, String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//div[contains(@class,'table-col-left')]/label)[2]/following::input)[1]")));
		oASelFW.effecta("type","xpath=((//div[contains(@class,'table-col-left')]/label)[2]/following::input)["+position+"]",text,"Heading "+header);
	}
	
	
	public void form_filling_locale_JP(String position,String header, String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@valign='top'])[1]/following::input[1]")));
		oASelFW.effecta("type","xpath=(//td[@valign='top'])[1]/following::input["+position+"]",text,"Heading "+header);
	}
	public void form_dropdown(String heading,String header)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+heading+"')]")));
		oASelFW.effecta("click","//label[text()='"+header+"']/../following::div/div/descendant::div/a","Clicked"+header);
	}
	

	public void form_dropdown_locale(String toggle,String field, String value) 
	{
		try{
		Thread.sleep(10000);
		System.out.println("In select ");
		JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
		 
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = null;
		if(oASelFW.driver.findElements(By.xpath("(//a[@class='sbToggle'])["+toggle+"]")).size()>0)
			element= oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"));
		else
			element=oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']"));
		 
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		je.executeScript("window.scrollBy(0,-250)", "");
		je.executeScript("window.scrollBy(0,-250)", "");
		//je.executeScript("scroll(0, -250);");
		//je.executeScript("scroll(0, -250);");
		//je.executeScript("arguments[0].scrollIntoView(true);",element);
		
	
		
		Thread.sleep(3000);
		if(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")).getCssValue("display").contains("none")) 
		{
			Actions ac = new Actions(oASelFW.driver);
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@rel='"+value+"'])[1]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			//oASelFW.driver.findElement(By.xpath("(//a[@rel='Afghanistan'])[1]")).click();
			//((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].setAttribute('display','block')", oASelFW.driver.findElement(By.xpath("//select[@field='country']")));
			
		}
		else
		{
			Select s = new Select(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")));
			s.selectByValue(""+value+"");
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
		}
		System.out.println("After select ");
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		/*
		Thread.sleep(30000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]")));
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]","Clicked" +header);
		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]")));
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]","Clicked" +header);
	
		*/
	}
	
	public void form_dropdown_locale_second(String toggle,String field, String value) throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println("In select ");
		JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
		 
		 
		 
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = null;
		if(oASelFW.driver.findElements(By.xpath("(//a[@class='sbToggle'])["+toggle+"]")).size()>0)
			element= oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"));
		else
			element=oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']"));
		 
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		// je.executeScript("scroll(0, -250);");
		// je.executeScript("scroll(0, -250);");
		// je.executeScript("scroll(0, -250);");
		//je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
		
		Thread.sleep(3000);
		if(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")).getCssValue("display").contains("none")) 
		{
			Actions ac = new Actions(oASelFW.driver);
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@rel='"+value+"'])[1]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
			//oASelFW.driver.findElement(By.xpath("(//a[@rel='Afghanistan'])[1]")).click();
			//((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].setAttribute('display','block')", oASelFW.driver.findElement(By.xpath("//select[@field='country']")));
			
		}
		else
		{
			Select s = new Select(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")));
			if(oASelFW.driver.findElements(By.xpath("//select[@field='"+field+"']/option[@value='"+value+"']")).size()==0)
				value= value+" ";
			s.selectByValue(value);
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
		}
		System.out.println("After select ");
		Thread.sleep(10000);
		/*
		Thread.sleep(30000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]")));
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]","Clicked" +header);
		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]")));
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]","Clicked" +header);
	
		*/
	}
	
	
	public void form_dropdown_locale_second_JP(String position,String field, String value) throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println("In select ");
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[@valign='top'])[1]/following::select[1]")));
		//oASelFW.effecta("select","(//td[@valign='top'])[1]/following::select["+position+"]","field "+field,value);
		
		Select dropdown = new Select(oASelFW.driver.findElement(By.xpath("(//td[@valign='top'])[1]/following::select["+position+"]")));
		dropdown.selectByIndex(1);
		oASelFW.effecta("sendReport","Select "+value+" from "+field+" drop down list","Successfully selected "+value+" from "+field+" drop down list","Pass"); 
		
		/*JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
		 
		 
		 
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = null;
		if(oASelFW.driver.findElements(By.xpath("(//a[@class='sbToggle'])["+toggle+"]")).size()>0)
			element= oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"));
		else
			element=oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']"));
		 
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		// je.executeScript("scroll(0, -250);");
		// je.executeScript("scroll(0, -250);");
		// je.executeScript("scroll(0, -250);");
		//je.executeScript("arguments[0].scrollIntoView(true);",element);
		 */
		
		/*Thread.sleep(3000);
		if(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")).getCssValue("display").contains("none")) 
		{
			Actions ac = new Actions(oASelFW.driver);
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@rel='"+value+"'])[1]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
			//oASelFW.driver.findElement(By.xpath("(//a[@rel='Afghanistan'])[1]")).click();
			//((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].setAttribute('display','block')", oASelFW.driver.findElement(By.xpath("//select[@field='country']")));
			
		}
		else
		{
			Select s = new Select(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")));
			if(oASelFW.driver.findElements(By.xpath("//select[@field='"+field+"']/option[@value='"+value+"']")).size()==0)
				value= value+" ";
			s.selectByValue(value);
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
		}
		System.out.println("After select ");
		Thread.sleep(10000);
		
		Thread.sleep(30000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]")));
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]","Clicked" +header);
		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]")));
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]","Clicked" +header);
	
		*/
		
		
		
	}
	
	public void form_dropdown_locale_three(String toggle,String field, String value) throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println("In select ");
		JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
		// je.executeScript("scroll(0, 250);");
		je.executeScript("window.scrollBy(0,200)", "");
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = null;
		if(oASelFW.driver.findElements(By.xpath("(//a[@class='sbToggle'])["+toggle+"]")).size()>0)
			element= oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"));
		else
			element=oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']"));
		 
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		// je.executeScript("scroll(0, -250);");
		// je.executeScript("scroll(0, -250);");
		// je.executeScript("scroll(0, -250);");
		//je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
		
		Thread.sleep(3000);
		if(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")).getCssValue("display").contains("none")) 
		{
			Actions ac = new Actions(oASelFW.driver);
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@class='sbToggle'])["+toggle+"]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("(//a[@rel='"+value+"'])[1]"))).build().perform();
			Thread.sleep(3000);
			ac.click().build().perform();
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
			//oASelFW.driver.findElement(By.xpath("(//a[@rel='Afghanistan'])[1]")).click();
			//((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].setAttribute('display','block')", oASelFW.driver.findElement(By.xpath("//select[@field='country']")));
			
		}
		else
		{
			Select s = new Select(oASelFW.driver.findElement(By.xpath("//select[@field='"+field+"']")));
			s.selectByValue(""+value+"");
			oASelFW.effecta("sendReport","Select "+value+" from drop down list","Successfully selected "+value+" from drop down list","Pass"); 
			
		}
		System.out.println("After select ");
		Thread.sleep(10000);
		/*
		Thread.sleep(30000);
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]")));
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]","Clicked" +header);
		Thread.sleep(5000);
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]")));
		Thread.sleep(2000);
		oASelFW.effecta("click","xpath=(//div[contains(@class,'table-col-left')]/label)["+labelCount+"]/following::a[1]/following::ul[1]/li["+header+")]","Clicked" +header);
	
		*/
	}
	
	
	
	public void click_result(String label,String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']")));
		oASelFW.effecta("click","//a[text()='"+text+"']","Heading"+label);
	}
	public void click_result_locale(String label,String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a[text()='India']")));
		oASelFW.effecta("click","//ul/li/a[text()='India']","Heading"+label);
	}
	
	public void form_desc(String label,String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']")));
		oASelFW.effecta("type","//label[text()='Additional Information']/../following::div/textarea",text,"Heading"+label);	
	}
	
	public void form_desc_locale(String text)
	{
		oASelFW.effecta("type","//textarea[@id='respondents_comments']",text,"Additional Information");	
	}
	
	public void checkbox(String label)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']")));
		oASelFW.effecta("click","//input[@type='checkbox']","Checkbox clicked");	
	}
	
	public void checkbox_locale()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='checkbox']")));
		oASelFW.effecta("click","//input[@class='checkbox']","Checkbox clicked");	
	}
	
	public void get_URL()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1)[1]")));
		
		String text=oASelFW.driver.getCurrentUrl();
		System.out.println(text);
		oASelFW.effecta("sendReport","Getting Currrent Page URL","Current URL is : "+text,"Pass");
		
		
	}
	
	
}



