package classes.vmware;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class VMwareTechPaperSearchPage {
	ArsinSeleniumAPI oASelFW;

	public VMwareTechPaperSearchPage(){

	}
	public VMwareTechPaperSearchPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}


	public void launchApplication(){


	}

	public void verifyVMwareTechSearchPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Technical Papers']")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Technical Papers']"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Tech paper Search Page or not","Successfully verifed User Navigated to Tech paper Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Tech paper Search Page or not","Unable to verify","Fail") ;
		}	
		
		//Browse TECHNICAL PAPERS
		oASelFW.effecta("verifyElementPresent","//span[contains(text(),'Technical Papers')]","Browse Technical Papers Page");
			
	
	}
	

	public void specificTechSearchSuggestions(String item, String selectItem){
		try{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Search']")));
			oASelFW.effecta("verifyElementPresent","//h2[text()='Search']","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//input[@name='q']","Search Box");	
			oASelFW.effecta("type","//input[@name='q']",item,"Search Item");
			Thread.sleep(6000);
			
			Actions ac = new Actions( oASelFW.driver);
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@class='angucomplete-dropdown ng-scope']//div[text()='"+selectItem+"']")), 5, 5).build().perform();
			ac.click().build().perform();
			
			Thread.sleep(5000);
			System.out.println("Enter to Search");
			oASelFW.effecta("clickAndWait","//span[@id='basic-addon1']","Search");
			System.out.println("Clicked");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
			String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
			System.out.println(text);
			
			if(text.contains(selectItem))
			{
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed"+selectItem+" found","Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReport","Verifying Search results",selectItem+"Not Found","Fail") ;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


		public void specificInvalidSearch(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Search']")));
				oASelFW.effecta("verifyElementPresent","//h2[text()='Search']","Search Box Name");
				oASelFW.effecta("verifyElementPresent","//input[@name='q']","Search Box");	
				oASelFW.effecta("type","//input[@name='q']",item,"Search Item");
				Thread.sleep(6000);
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(6000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Did you mean:')]")));
				
				oASelFW.effecta("verifyElementPresent","//span[contains(text(),'Did you mean:')]","Verifying 'Did you mean' message for invalid search item");
				
				oASelFW.effecta("verifyElementPresent","//span[text()='Did you mean:']/following-sibling::a","Verifying suggestion \"vmware\" message for invalid search item");
				
				String value = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerHTML;",  oASelFW.driver.findElement(By.xpath("//div[@ng-if='showNoResult']")));
				System.out.println(value);

				
				//verifying text message 1 on web page
				
				if(value.contains("your search"))
				{

					oASelFW.effecta("sendReport","Verifying \"your serach\" message","verified \"your search\" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \"your serach\" message","Not found \"your serach\" message","Fail");
				}	

				//verifying text message 2 on web page
				
				if(value.contains("did not match any documents")){

					oASelFW.effecta("sendReport","Verifying \"did not match any documents\" message","verified \"did not match any documents\" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \"did not match any documents\" message","Not found \"did not match any documents\" message","Fail");
				}
				
				
				//verifying text message 3 on web page
				
				if(value.contains("No pages were found containing")){

					oASelFW.effecta("sendReport","Verifying \" No pages were found containing \" message","verified \" No pages were found containing \" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \" No pages were found containing \" message","Not found \" No pages were found containing \" message","Fail");
				}
				
				
				//verifying text message 4 on web page
				
				if(value.contains("Suggestions")){

					oASelFW.effecta("sendReport","Verifying \"Suggestions\" message","verified \"Suggestions\" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \"Suggestions\" message","Not found \"Suggestions\" message","Fail");
				}
				
				//verifying text message 5 on web page
				
				if(value.contains("Make sure all words are spelled correctly")){

					oASelFW.effecta("sendReport","Verifying \" Make sure all words are spelled correctly \" message","verified \" Make sure all words are spelled correctly \" message","Pass");
				}
				
				else{

					oASelFW.effecta("sendReport","Verifying \" Make sure all words are spelled correctly \" message","Not found \" Make sure all words are spelled correctly \" message","Fail");
				}
				
				//verifying text message 6 on web page

				if(value.contains("Try different keywords")){

					oASelFW.effecta("sendReport","Verifying \" Try different keywords \" message","verified \" Try different keywords \" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \" Try different keywords \" message","Not found \" Try different keywords \" message","Fail");
				}
				
				//verifying text message 7 on web page
				
				if(value.contains("Try more general keywords")){

					oASelFW.effecta("sendReport","Verifying \" Try more general keywords \" message","verified \" Try more general keywords \" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \" Try more general keywords \" message","Not found \" Try more general keywords \" message","Fail");
				}
				
				//verifying text message 8 on web page
				
				if(value.contains("try broadening the search by unchecking the filter criteria")){

					oASelFW.effecta("sendReport","Verifying \" try broadening the search by unchecking the filter criteria \" message","verified \" try broadening the search by unchecking the filter criteria \" message","Pass");
				}
				else{

					oASelFW.effecta("sendReport","Verifying \" try broadening the search by unchecking the filter criteria \" message","Not found \" try broadening the search by unchecking the filter criteria \" message","Fail");
				}

				
				//Click on Suggested item by application
				
				oASelFW.effecta("clickAndWait","//span[text()='Did you mean:']/following-sibling::a","Clicking on Suggested word");
				
				Thread.sleep(10000);
				
				System.out.println("Clicked");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
				System.out.println(text);
				
				if(text.contains("vmware"))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed \"vmware\" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results","\"vmware\" Not Found","Fail") ;
				}
				
				
				//verifying the search item related results
				String bestValue = oASelFW.effecta("getText","//a[@ng-bind-html='searchresult.T | docTypeFilter: searchresult.U:searchresult.isVideo']","verifying the search item related results");
				
				if(bestValue.contains("VMware")){
					
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed \"vmware\" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results","\"vmware\" Not Found","Fail") ;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		
		public void specificValidTechSearch(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
				oASelFW.effecta("verifyElementPresent","//input[@name='q']","Search Box");	
				oASelFW.effecta("type","//input[@name='q']",item,"Search Item");
				Thread.sleep(6000);
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(15000);
				oASelFW.effecta("verifyElementPresent","//p[contains(.,'Results')]","Search Results");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		public void supportSearch(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Support']")));
				oASelFW.effecta("verifyElementPresent","//a[text()='Support']","support search");
				
				oASelFW.effecta("clickAndWait","//a[text()='Support']","Clicking to Support search icon");
				Thread.sleep(6000);
				
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(15000);	
				
				System.out.println("Clicked");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
				System.out.println(text);
				
				if(text.contains(item))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed"+item+" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",item+"Not Found","Fail") ;
				}	
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		
		public void siteSearch(){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Results Per Page:']")));
				oASelFW.effecta("verifyElementPresent","//span[text()='Results Per Page:']","Results Per Page");
				
				oASelFW.effecta("verifyElementPresent","//span[text()='20']","default values as 20");
				
				oASelFW.effecta("verifyElementPresent","//span[text()='1-20']","default values as 1-20");
				
				
				
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
				System.out.println(text);
				
	
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	
		public void specificInvalidSearchNoResults(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Search']")));
				oASelFW.effecta("verifyElementPresent","//h2[text()='Search']","Search Box Name");
				oASelFW.effecta("verifyElementPresent","//input[@name='q']","Search Box");	
				oASelFW.effecta("type","//input[@name='q']",item,"Search Item");
				Thread.sleep(6000);
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(6000);
				
				String value = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerHTML;",  oASelFW.driver.findElement(By.xpath("//div[@ng-if='showNoResult']")));
				System.out.println(value);

				//verifying text message 1 on web page
				
				if(value.contains("your search"))
				{
					oASelFW.effecta("sendReport","Verifying \"your serach\" message","verified \"your search\" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \"your serach\" message","Not found \"your serach\" message","Fail");
				}	

				//verifying text message 2 on web page
				
				if(value.contains("did not match any documents"))
				{
					oASelFW.effecta("sendReport","Verifying \"did not match any documents\" message","verified \"did not match any documents\" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \"did not match any documents\" message","Not found \"did not match any documents\" message","Fail");
				}
				
				
				//verifying text message 3 on web page
				
				if(value.contains("No pages were found containing"))
				{
					oASelFW.effecta("sendReport","Verifying \" No pages were found containing \" message","verified \" No pages were found containing \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" No pages were found containing \" message","Not found \" No pages were found containing \" message","Fail");
				}
				
				
				//verifying text message 4 on web page
				
				if(value.contains("Suggestions"))
				{
					oASelFW.effecta("sendReport","Verifying \"Suggestions\" message","verified \"Suggestions\" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \"Suggestions\" message","Not found \"Suggestions\" message","Fail");
				}
				
				//verifying text message 5 on web page
				
				if(value.contains("Make sure all words are spelled correctly"))
				{
					oASelFW.effecta("sendReport","Verifying \" Make sure all words are spelled correctly \" message","verified \" Make sure all words are spelled correctly \" message","Pass");
				}
				
				else
				{
					oASelFW.effecta("sendReport","Verifying \" Make sure all words are spelled correctly \" message","Not found \" Make sure all words are spelled correctly \" message","Fail");
				}
				
				//verifying text message 6 on web page

				if(value.contains("Try different keywords"))
				{
					oASelFW.effecta("sendReport","Verifying \" Try different keywords \" message","verified \" Try different keywords \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" Try different keywords \" message","Not found \" Try different keywords \" message","Fail");
				}
				
				//verifying text message 7 on web page
				
				if(value.contains("Try more general keywords"))
				{
					oASelFW.effecta("sendReport","Verifying \" Try more general keywords \" message","verified \" Try more general keywords \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" Try more general keywords \" message","Not found \" Try more general keywords \" message","Fail");
				}
				
				//verifying text message 8 on web page
				
				if(value.contains("try broadening the search by unchecking the filter criteria"))
				{
					oASelFW.effecta("sendReport","Verifying \" try broadening the search by unchecking the filter criteria \" message","verified \" try broadening the search by unchecking the filter criteria \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" try broadening the search by unchecking the filter criteria \" message","Not found \" try broadening the search by unchecking the filter criteria \" message","Fail");
				}
	
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		
		public void verifyTechCategoryTypeSubSection(String selectItem){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				Thread.sleep(10000);
				System.out.println("before Product Filters");
				
				//Click on Product, Publisher, Area
				 // oASelFW.effecta("clickAndWait","//span[contains(text(),'vsphere 5')]/../input/following-sibling::label","Product Filter");
				//  Thread.sleep(10000);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'vsphere 5')]/../input/following-sibling::label")));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//span[contains(text(),'vsphere 5')]/../input/following-sibling::label")));
				Thread.sleep(10000);
				
				oASelFW.effecta("sendReport","Verify Product Filter","Successfully Verified Product Filter","Pass");
				System.out.println("Product Filter");
		
				//Click on applyFilters
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Apply Filters']")));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//input[@value='Apply Filters']")));
				
				oASelFW.effecta("sendReport","Verify Apply Filters","Successfully Verified Apply Filters","Pass");
				
			//	oASelFW.effecta("click","//input[@value='Apply Filters']","applyFilters");
				Thread.sleep(10000);
				System.out.println("applyFilters");
				
				// Verifying Results after filtering 
				
				oASelFW.effecta("verifyElementPresent","//p[contains(.,'Results')]","Search Results");
				oASelFW.effecta("sendReport","Verify Search Results","Successfully Verified Search Results","Pass");
				
				System.out.println("Search Results");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='applyFilters']")));
				Thread.sleep(5000);
				
				//Click on Product, Publisher, Area
			//		oASelFW.effecta("clickAndWait","//span[text()='vmware']/../input/following-sibling::label","Publisher Filter");
				// 	Thread.sleep(10000);	
				
				oASelFW.effecta("sendReport","Verify Apply Filters","Successfully Verified Apply Filters","Pass");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='vmware']/../input/following-sibling::label")));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//span[text()='vmware']/../input/following-sibling::label")));
				Thread.sleep(10000);
				
				System.out.println("Publisher Filter");
				oASelFW.effecta("sendReport","Verify Publisher Filter","Successfully Verified Publisher Filter","Pass");
				
				//Click on applyFilters
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Apply Filters']")));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//input[@value='Apply Filters']")));
				Thread.sleep(10000);
				System.out.println("applyFilters");
				oASelFW.effecta("sendReport","Verify Apply Filters","Successfully Verified Apply Filters","Pass");
				
				
				oASelFW.effecta("verifyElementPresent","//p[contains(.,'Results')]","Search Results");
				System.out.println("Search Results");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='applyFilters']")));
				
				oASelFW.effecta("sendReport","Verify Search Results","Successfully Verified Search Results","Pass");
				
				//Click on Product, Publisher, Area
				//oASelFW.effecta("clickAndWait","//span[contains(text(),'performance')]/../input/following-sibling::label","Area Filter");
				//Thread.sleep(10000);	
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'performance')]/../input/following-sibling::label")));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//span[contains(text(),'performance')]/../input/following-sibling::label")));
				Thread.sleep(10000);
				
				oASelFW.effecta("sendReport","Verify Area Filter","Successfully Verified Area Filter","Pass");
		
				//Click on applyFilters
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Apply Filters']")));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", oASelFW.driver.findElement(By.xpath("//input[@value='Apply Filters']")));
				Thread.sleep(10000);
				System.out.println("applyFilters");
				oASelFW.effecta("sendReport","Verify Apply Filters","Successfully Verified Apply Filters","Pass");
				
				oASelFW.effecta("verifyElementPresent","//p[contains(.,'Results')]","Search Results");
				oASelFW.effecta("sendReport","Verify Search Results","Successfully Verified Search Results","Pass");
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
		
		
		public void verifyVMwareSearchInputValue(String text) throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-if,'showNoResult')]/p/span[contains(text(),'x6768')]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[text()='Search']"))){
				oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
			}
		}	
		
		
		
		
		public void clickpagination()
		{
			
			
			JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-md-12 search-pagination')]/nav-directive//ul/li")));
			
			int count=Integer.parseInt(oASelFW.effecta("getXpathCount","//div[contains(@class,'col-md-12 search-pagination')]/nav-directive//ul/li"));
			System.out.println("Count: "+ count);
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-md-12 search-pagination')]/nav-directive//ul/li")));
			oASelFW.effecta("verifyElementPresent","//div[contains(@class,'col-md-12 search-pagination')]/nav-directive//ul/li[3]","verifying pagination functionality");
			
			jse.executeScript("window.scrollBy(0,-250)", "");
		
		}
		
		
		public void verifyVMwareVspherePage() throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'vSphere with Operations Management')])[1]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//span[contains(text(),'vSphere with Operations Management')])[1]"))){
				oASelFW.effecta("sendReport","Verifying whether User Navigated to Vsphere page","Successfully verifed User Navigated to Vsphere Page","Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Vsphere page","Unable to verify","Fail") ;
			}	
			
			
		}
		
		
		
		
		public void verifyVMwareCustomerPage() throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='VMware Customers']")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='VMware Customers']"))){
				oASelFW.effecta("sendReport","Verifying whether User Navigated to Customers page","Successfully verifed User Navigated to Customers Page","Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Customers page","Unable to verify","Fail") ;
			}	
			
			
		}
		
		
		public void verifyVMwareCustomerPage_recordcount_totalrecords() throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='recordCount']")));
			String recordcnt=oASelFW.driver.findElement(By.xpath("//span[@id='recordCount']")).getText();
			System.out.println("records"+recordcnt);
			
			String totrecordcnt=oASelFW.driver.findElement(By.xpath("//span[@id='totalRecords']")).getText();
			System.out.println("tot records"+totrecordcnt);
			if(!recordcnt.isEmpty())
				
			{
				System.out.println("Successfully verifed records in page as: "+recordcnt+" of "+totrecordcnt);
				oASelFW.effecta("sendReport","Verify records displayed in page","Successfully verifed records in page as: "+recordcnt+" of "+totrecordcnt,"Pass") ;
			}
			else 
			{
				oASelFW.effecta("sendReportWithOutExit","Verify records displayed in page","Unable to verify records in page","Fail") ;
			}
			
		}
		
		
		
		public void verifyVMwareVspherePricingsectionHeading() throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'PRICING')]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'PRICING')]"))){
				oASelFW.effecta("sendReport","Verifying Pricing section is displaying or not","Pricing section is displaying successfully","Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying Pricing section is displaying or not","Verifying Pricing section is not displaying","Fail") ;
			}	
			
			
		}
		
		public void verifyVMwareVspheresectionHeading(String sectionheading) throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+sectionheading+"')]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'"+sectionheading+"')]"))){
				oASelFW.effecta("sendReport","Verifying Pricing section is displaying or not","Pricing section is displaying successfully","Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying Pricing section is displaying or not","Verifying Pricing section is not displaying","Fail") ;
			}	
			
			
		}
		
		
		
		//p[text()='VMware vSphere and vSphere with Operations Management Editions']/following::h5[text()='PRODUCT TITLE'][1]
		
		public void verifyVMwareVspherePricingsectionTableheader(String fieldname,String tablecolhead) throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='"+fieldname+"']/following::h5[text()='"+tablecolhead+"'][1]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//p[text()='"+fieldname+"']/following::h5[text()='"+tablecolhead+"'][1]"))){
				oASelFW.effecta("sendReport","Verifying  section is displaying with "+tablecolhead,"Successfully Verified "+tablecolhead,"Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying  section is displaying with "+tablecolhead,"Verifying section is not displaying","Fail") ;
			}	
			
			
		}
		
		
		
		
		
		
		public void verifyVMwareVsphereComparisionsectionTableheader(String fieldname) throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h5[contains(text(),'"+fieldname+"')]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div/h5[contains(text(),'"+fieldname+"')]"))){
				oASelFW.effecta("sendReport","Verifying  section is displaying with "+fieldname,"Successfully Verified "+fieldname,"Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying  section is displaying with "+fieldname,"Verifying section is not displaying","Fail") ;
			}	
			
			
		}
		
		
		public void verifyVMwareVsphereComparisionsectionTableheader(String fieldname,String colhead) throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h5[contains(text(),'"+fieldname+"')]/following::h5[text()='"+colhead+"'][1]")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div/h5[contains(text(),'"+fieldname+"')]/following::h5[text()='"+colhead+"'][1]"))){
				oASelFW.effecta("sendReport","Verifying  section is displaying with "+colhead,"Successfully Verified "+colhead,"Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying  section is displaying with "+colhead,"Verifying section is not displaying","Fail") ;
			}	
			
			
		}
		
		
		public void Verify_PricingComparisionBorders(String section,String fieldname,String colhead)
		{


			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
	

			WebElement text = oASelFW.driver.findElement(By.xpath("//div/h5[contains(text(),'"+fieldname+"')]/following::h5[text()='"+colhead+"'][1]/following::div[@class='rTableCell'][1]"));
			//Read font-size property and print It In console.
			String borderSize = text.getCssValue("border-right-width").trim();
			//int font_Size = Integer.parseInt(fontSize);
			System.out.println("border-right-width-> "+borderSize); 

			System.out.println("expected border Size -> "+borderSize); 

			if(borderSize.equalsIgnoreCase("2px"))
			{
				oASelFW.effecta("sendReport","Verify Borders available for "+section+" table: "+borderSize,"Verified Borders available for "+section+" table: "+borderSize,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Borders available for "+section+" table: "+borderSize,"Verify Borders for "+section+" table is not as avaliable","Fail");
			}

			
		}
		
		//span[contains(text(),'View Customer Stories')]
		
		
		public void clickViewCustdropdown(String fieldname) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='"+fieldname+"']")));
			oASelFW.effecta("verifyElementPresent","//button[@title='"+fieldname+"']",fieldname);	
			oASelFW.effecta("clickAndWait","//button[@title='"+fieldname+"']",fieldname);
			Thread.sleep(6000);


		}
		
		
		public void clickViewCustdropdown_value(String fieldname) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li/a/span[text()='"+fieldname+"']")));
			oASelFW.effecta("verifyElementPresent","//ul/li/a/span[text()='"+fieldname+"']",fieldname);	
			oASelFW.effecta("click","//ul/li/a/span[text()='"+fieldname+"']",fieldname);
			Thread.sleep(6000);


		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
