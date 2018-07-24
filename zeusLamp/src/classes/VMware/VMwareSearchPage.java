package classes.vmware;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class VMwareSearchPage {
	ArsinSeleniumAPI oASelFW;

	public VMwareSearchPage(){

	}
	public VMwareSearchPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}


	public void launchApplication(){


	}

	public void verifyVMwareSearchPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'Search')]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
		}
	}

	public void verifyVMwareSearchSupportPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'Search')]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
		}
	}
	
	
	public void verifyVMwareSupportPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'SUPPORT')])[1]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//h2[contains(text(),'SUPPORT')])[1]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
		}
	}
	
	
	public void verifyVMwareSecurityPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[1]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//h2)[1]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Security Page or not","Successfully verifed.User Navigated to Security Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Security Page or not","Unable to verify","Fail") ;
		}
	}
	
	public void verifyopenstackPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[1]")));
		//a[@id='nav_sidebar_1']

		/*if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//img[@alt='vmware']/following::i[@urlval='/content/vmware/vmware-published-sites/tw/config-pages/mega-menu/products']"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated URL references of links on Migrated pages or not","Successfully verifed.User Navigated to Navigated URL references of links","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated URL references of links on Migrated pages or not","Unable to verify","Fail") ;
		}*/
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//a[@id='nav_sidebar_1']")))
		{
			oASelFW.effecta("sendReport","Verifying whether User Navigated URL references of links on Migrated pages or not","Successfully verifed.User Navigated to Navigated URL references of links","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated URL references of links on Migrated pages or not","Unable to verify","Fail") ;
		}
	}
	
	
	public void viewPageSource() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[1]")));
		

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//a[@id='nav_sidebar_1']"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated URL references of links on Migrated pages or not","Successfully verifed.User Navigated to Navigated URL references of links","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated URL references of links on Migrated pages or not","Unable to verify","Fail") ;
		}
		
		
		if(oASelFW.driver.getPageSource().contains("AEM 6.1")){
			oASelFW.effecta("sendReport","Verifying page is coming from AEM or Not","Successfully verifed, Page is coming form AEM Appliation","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying page is coming from AEM or Not","Unable to verify","Fail") ;
		}
		
	}
	public void verifyResultsPerPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Results Per Page')]")));

		
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//span[contains(text(),'Results Per Page')]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Results Per Page or not","Successfully verifed.User Navigated to Results Per Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Results Per Page or not","Unable to verify","Fail") ;
		}
		
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//span[contains(text(),'1-20')]"))){
			oASelFW.effecta("sendReport","Verifying whether Results Per Page showing 1-20 results by default","Successfully verifed Results Per Page showing 1-20 results by default","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether Results Per Page showing 1-20 results by default","Unable to verify","Fail") ;
		}
		
		oASelFW.effecta("clickAndWait","//span[text()='Results Per Page:']/following::span","Clicking resutls per page");
		
		oASelFW.effecta("clickAndWait","//a[text()='50']","Selecting 50 resutls per page");
		
		Thread.sleep(10000);
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//span[contains(text(),'1-50')]"))){
			oASelFW.effecta("sendReport","Verifying whether Results Per Page showing 1-50 results by default","Successfully verifed Results Per Page showing 1-50 results by default","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether Results Per Page showing 1-50 results by default","Unable to verify","Fail") ;
		}
		
		oASelFW.effecta("clickAndWait","//span[text()='Results Per Page:']/following::span","Clicking resutls per page");
		
		oASelFW.effecta("clickAndWait","//a[text()='100']","Selecting 100 resutls per page");
		
		Thread.sleep(10000);
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=//span[contains(text(),'1-100')]"))){
			oASelFW.effecta("sendReport","Verifying whether Results Per Page showing 1-100 results by default","Successfully verifed Results Per Page showing 1-100 results by default","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether Results Per Page showing 1-100 results by default","Unable to verify","Fail") ;
		}	
		
	}
	
	
	public void verifyVMware404Page() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2)[1]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//h2)[1]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to 404 Search Page or not","Successfully verifed.User Navigated to 404 Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to 404 Search Page or not","Unable to verify","Fail") ;
		}
	}
	
	public void verifyScrapperSupportPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'SUPPORT')])[1]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//h2[contains(text(),'SUPPORT')])[1]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Support page","Successfully verifed User Navigated to Support Search Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Support page","Unable to verify","Fail") ;
		}
	}
	
	
	public void verifyScrapperPage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='q'])[1]")));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//input[@name='q'])[1]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to scrapper app page","Successfully verifed User Navigated to scrapper app page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to scrapper app page","Unable to verify","Fail") ;
		}
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

	
	
	
	public void specificSearchSuggestions(String item, String selectItem){
		try{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//input[@ng-model='q']","Search Box");	
			//oASelFW.effecta("typeEmpty","//input[@name='q']",item,"Search Item");
			
			oASelFW.driver.findElement(By.xpath("//input[@ng-model='q']")).clear();
			oASelFW.effecta("type","//input[@ng-model='q']",item,"Search Item");
			Thread.sleep(5000);
			
/*
			WebElement we1 = oASelFW.driver.findElement(By.xpath("//div[@class='angucomplete-dropdown ng-scope']"));
			String text1 = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerHTML;", we1);
			System.out.println(text1);*/

			Actions ac = new Actions( oASelFW.driver);
			ac.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@class='angucomplete-dropdown ng-scope']//div[text()='"+selectItem+"']")), 5, 5).build().perform();
			ac.click().build().perform();
			
			//oASelFW.driver.findElement(By.xpath("//div[@class='angucomplete-dropdown ng-scope']//div[text()='vmware vmotion']")).click();
			System.out.println("Enter to Search");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='basic-addon1']")));
			oASelFW.effecta("clickAndWait","//span[@id='basic-addon1']","Search");
			System.out.println("Clicked");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
			String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
			System.out.println(text);
			
			if(text.contains(selectItem))
			{
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed"+selectItem+" found","Pass") ;
				oASelFW.effecta("sendReport","Verify that the Search field inside the page would provide Auto-suggestion","Successfully Verified that the Search field inside the page providing Auto-suggestion","Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReport","Verifying Search results",selectItem+"Not Found","Fail") ;
				oASelFW.effecta("sendReport","Verify that the Search field inside the page would provide Auto-suggestion","Successfully Verified that the Search field inside the page providing Auto-suggestion","Pass");
			}

			//System.out.println("Search Result frame");
			//oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+item+"')] | //a[@ng-bind-html='searchresult.T | docTypeFilter: searchresult.U:searchresult.isVideo']","validating search results");
			//System.out.println("validated search results");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


		public void specificInvalidSearch(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
				oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]","Search Box Name");
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

		
		public void specificValidSearch(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
				oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]","Search Box Name");
				//	oASelFW.effecta("verifyElementPresent","//input[@ng-model='q']","Search Box");
				//  //i[@class='fa fa-search'])[2]
				
				//oASelFW.effecta("verifyElementPresent","//input[@id='generic-search']","Search Box");
				
				//object get changed modified by bhargav while executing in UAT
				
				oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]/following::input[1]","Search Box");
			
				
				//oASelFW.effecta("type","//input[@id='generic-search']",item,"Search Item");
				
				oASelFW.effecta("type","//h2[contains(text(),'Search')]/following::input[@type='text']",item,"Search Item");
				
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='input-group-addon search-select-addon']")));
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				//Thread.sleep(15000);			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		public void LocalizedspecificValidSearch(String item,String search){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+search+"']")));
				oASelFW.effecta("verifyElementPresent","//h2[text()='"+search+"']","Search Box Name");
				oASelFW.effecta("verifyElementPresent","//span[@class='input-group-addon search-select-addon']/following-sibling::div/input","Search Box");	
				oASelFW.effecta("type","//span[@class='input-group-addon search-select-addon']/following-sibling::div/input",item,"Search Item");
				Thread.sleep(6000);
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(25000);			
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

		
		public void vmwareSearch(String item){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Support']")));
				oASelFW.effecta("verifyElementPresent","//a[text()='Support']","support search");
				
				Thread.sleep(5000);
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

		
		public void queryString(String item, String item1, String item2 ){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Support']")));
				oASelFW.effecta("verifyElementPresent","//a[text()='Support']","support search");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				String URL=oASelFW.effecta("getURL");
				System.out.println(URL);
				
				if(URL.contains(item))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed"+item+" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",item+"Not Found","Fail") ;
				}	
						
				if(URL.contains(item1))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed"+item1+" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",item1+"Not Found","Fail") ;
				}	
				
				
				oASelFW.effecta("clickAndWait","//a[text()='Support']","Clicking to Support search icon");
				Thread.sleep(6000);
				
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(10000);	
				
				System.out.println("Clicked");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				URL=oASelFW.effecta("getURL");
				System.out.println(URL);
				
				Thread.sleep(3000);	
				
				if(URL.contains(item2))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed"+item2+" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",item2+"Not Found","Fail") ;
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
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
				oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]","Search Box Name");
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

		
		
		
public void clickSupport(){
			
			try
			{
				
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
				
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Support']")));
			oASelFW.effecta("verifyElementPresent","//a[text()='Support']","support search");
			
			oASelFW.effecta("clickAndWait","//a[text()='Support']","Clicking to Support search icon");
			Thread.sleep(6000);
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			
		}
		
		
		public void searchComponent(String selectItem){
			
			try
			{
				
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
				
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]","Search Box Name");
			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]/following::input[@type='text']","Search Box Availability");	
			oASelFW.effecta("type","//h2[contains(text(),'Search')]/following::input[@type='text']",selectItem,"Search Item");
			System.out.println("Entered");
			Thread.sleep(10000);
			oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
			Thread.sleep(10000);
			System.out.println("Clicked");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
			String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
			System.out.println(text);
			
			if(text.contains(selectItem))
			{
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
			}
			
			Thread.sleep(3000);
			System.out.println("Searching Link");
			
			//Verifying Search Result title in Support Page
			// oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title verification in search results of first link ");
			if(oASelFW.driver.findElements(By.xpath("//span[contains(text(),'sort by')]/following::a[3]")).size()>0)
			{
				//pass
				
				oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results","Successfully verifed "+selectItem+" found","Pass") ;
			}
			else
			{
				//fail
				oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results",selectItem+" Not Found","Fail") ;
				
			}
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			
		}
		
		
		
public void supportSearchComponent(String selectItem){
			
			try
			{
				
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
				
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'SUPPORT')])[1]/following::input[@type='text']")));
			oASelFW.effecta("verifyElementPresent","xpath=(//h2[contains(text(),'SUPPORT')])[1]/following::input[@type='text']","Search Box Name");
			oASelFW.effecta("type","xpath=(//h2[contains(text(),'SUPPORT')])[1]/following::input[@type='text']",selectItem,"Search Item");
			System.out.println("Entered");
			Thread.sleep(10000);
			oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
			Thread.sleep(10000);
			System.out.println("Clicked");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
			String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
			System.out.println(text);
			
			if(text.contains(selectItem))
			{
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
			}
			
			Thread.sleep(3000);
			System.out.println("Searching Link");
			
			//Verifying Search Result title in Support Page
			// oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title verification in search results of first link ");
			if(oASelFW.driver.findElements(By.xpath("//span[contains(text(),'sort by')]/following::a[3]")).size()>0)
			{
				//pass
				
				oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results","Successfully verifed "+selectItem+" found","Pass") ;
			}
			else
			{
				//fail
				oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results",selectItem+" Not Found","Fail") ;
				
			}
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			
		}

public void SearchComponent404(String selectItem){
	
	try
	{
		
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'Page')])[1]/following::input[@type='text']")));
	oASelFW.effecta("verifyElementPresent","xpath=(//h2[contains(text(),'Page')])[1]/following::input[@type='text']","Search Box Name");
	oASelFW.effecta("type","xpath=(//h2[contains(text(),'Page')])[1]/following::input[@type='text']",selectItem,"Search Item");
	System.out.println("Entered");
	// Thread.sleep(10000);
	oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
	// Thread.sleep(10000);
	System.out.println("Clicked");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
	String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
	System.out.println(text);
	
	if(text.contains(selectItem))
	{
		oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
	}
	else
	{
		oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
	}
	
	// Thread.sleep(3000);
	System.out.println("Searching Link");
	
	//Verifying Search Result title in Support Page
	// oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title verification in search results of first link ");
	if(oASelFW.driver.findElements(By.xpath("//span[contains(text(),'sort by')]/following::a[3]")).size()>0)
	{
		//pass
		
		oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results","Successfully verifed "+selectItem+" found","Pass") ;
	}
	else
	{
		//fail
		oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results",selectItem+" Not Found","Fail") ;
		
	}
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}	
	
}
	
public void SearchSecurityComponent(String selectItem){
	
	try
	{
		
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'Secure')])[1]/following::input[@type='text']")));
	oASelFW.effecta("verifyElementPresent","xpath=(//h2[contains(text(),'Secure')])[1]/following::input[@type='text']","Search Box Name");
	oASelFW.effecta("type","xpath=(//h2[contains(text(),'Secure')])[1]/following::input[@type='text']",selectItem,"Search Item");
	System.out.println("Entered");
	// Thread.sleep(10000);
	oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
	// Thread.sleep(10000);
	System.out.println("Clicked");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
	String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
	System.out.println(text);
	
	if(text.contains(selectItem))
	{
		oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
	}
	else
	{
		oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
	}
	
	// Thread.sleep(3000);
	System.out.println("Searching Link");
	
	//Verifying Search Result title in Support Page
	// oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title verification in search results of first link ");
	if(oASelFW.driver.findElements(By.xpath("//span[contains(text(),'sort by')]/following::a[3]")).size()>0)
	{
		//pass
		
		oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results","Successfully verifed "+selectItem+" found","Pass") ;
	}
	else
	{
		//fail
		oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results",selectItem+" Not Found","Fail") ;
		
	}
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}	
	
}

		
public void scrapperSearchComponent(String selectItem){
	
	try
	{
		
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='q'])[1]")));
	oASelFW.effecta("verifyElementPresent","xpath=(//input[@name='q'])[1]","Scrapper Search Box");
	oASelFW.effecta("type","xpath=(//input[@name='q'])[1]",selectItem,"Search Item in search box");
	System.out.println("Entered");
	Thread.sleep(3000);
	oASelFW.effecta("clickAndWait","xpath=(//input[@class='btn-search'])[1]","Clicking to search icon");
	Thread.sleep(10000);
	System.out.println("Clicked");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
	String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
	System.out.println(text);
	
	if(text.contains(selectItem))
	{
		oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
	}
	else
	{
		oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
	}
	
	Thread.sleep(3000);
	System.out.println("Searching Link");
	
	//Verifying Search Result title in Support Page
	// oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title verification in search results of first link ");
	if(oASelFW.driver.findElements(By.xpath("//span[contains(text(),'sort by')]/following::a[3]")).size()>0)
	{
		//pass
		
		oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results","Successfully verifed "+selectItem+" found","Pass") ;
	}
	else
	{
		//fail
		oASelFW.effecta("sendReportWithOutExit","Verifying first title in Search results",selectItem+" Not Found","Fail") ;
		
	}
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}	
	
}


		
		public void selectCategoryTypeAndFilter(String selectItem, String selectItem1, String selectItem2 ){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
							
				//Click on in category and type and click on Apply Filers to verify results
				
				Thread.sleep(5000);
				
				boolean value = oASelFW.driver.findElement(By.xpath("//h4[text()='Category']/following::label[contains(.,'"+selectItem1+"')]/label")).isSelected();

				System.out.println(value);	
				if (value==false)
				
			     {
			    	
			    //click First selection in Category
				oASelFW.effecta("clickAndWait","//h4[text()='Category']/following::label[contains(.,'"+selectItem1+"')]/label","Select "+selectItem1+" option in Category section");
			    	 
			     }
				
				//click First selection in Category
				// oASelFW.effecta("clickAndWait","//h4[text()='Category']/following::label[contains(.,'"+selectItem1+"')]/label","Select "+selectItem1+" option in Category section");
				
				Thread.sleep(5000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Type']/following::label[contains(.,'"+selectItem2+"')]/label")));
				
				//click First selection in Type
				//oASelFW.effecta("clickAndWait","//h4[text()='Type']/following::label[contains(.,'"+selectItem2+"')]/label","Select "+selectItem2+" option in Type section");
				
				JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				oASelFW.driver.findElement(By.xpath("//h4[text()='Type']/following::label[contains(.,'"+selectItem2+"')]/label")).click();
				oASelFW.effecta("sendReportWithOutExit","Selecting from type","Successfully Selected "+selectItem2+" found","Selected "+selectItem2+" option in Type section") ;
				//Thread.sleep(5000);
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='applyFilters']")));
				
				//Click on Apply Filter
				oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
			//	oASelFW.driver.findElement(By.xpath("//input[@id='applyFilters']")).click();
				
				Thread.sleep(5000);
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				
				System.out.println("Clicked");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				Thread.sleep(5000);
			
				
				String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
				//String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//span[contains(text(),'vcenter')]")));
				System.out.println(text);
				
				
				if(text.contains(selectItem))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
				}
				
				
				//Verifying Search Result title in Result Page
				oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title format verification");
				
				String Data=oASelFW.effecta("getText","//span[contains(text(),'sort by')]/following::a[3]","title displyed after search");
				
				System.out.println(Data);
				
				Thread.sleep(5000);
				
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+Data+" found","Pass") ;
				
				
				//Verifying Search Result synopsis in Result Page
				oASelFW.effecta("verifyElementPresent","xpath=(//span[contains(text(),'sort by')]/following::p)[1]","synopsis verification");
				
				Data=oASelFW.effecta("getText","xpath=(//span[contains(text(),'sort by')]/following::p)[1]","synopsis displyed after search");
				
				System.out.println(Data);
				
				Thread.sleep(5000);
				
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+Data+" found","Pass") ;
				
				
				
				
				VMwareTechPaperSearchPage vmwtechsearch   = new VMwareTechPaperSearchPage(oASelFW);
				//Verifying pagination
				vmwtechsearch.clickpagination();
				
				
				
				oASelFW.effecta("clickAndWait","//span[contains(text(),'sort by')]/following::a[3]","Clicked on first link after search resutls found");	
				Thread.sleep(5000);
				
				oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+Data+" found","Pass") ;
				
				Thread.sleep(5000);
				oASelFW.effecta("getTitle");
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void selectCategoryTypeAndFilterNoResutls(String selectItem, String selectItem1, String selectItem2 ){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
							
				//Click on in category and type and click on Apply Filers to verify results
				
				//click Product Documentation
				
				Thread.sleep(5000);
				
				boolean value = oASelFW.driver.findElement(By.xpath("//h4[text()='Category']/following::label[contains(.,'"+selectItem1+"')]/label")).isSelected();

				System.out.println(value);	
				if (value==false)
				
			     {
			    	
			    //click First selection in Category
				oASelFW.effecta("clickAndWait","//h4[text()='Category']/following::label[contains(.,'"+selectItem1+"')]/label","Select "+selectItem1+" option in Category section");
			    	 
			     }
				
				//click Product Documentation
				// oASelFW.effecta("clickAndWait","//h4[text()='Category']/following::label[contains(.,'"+selectItem1+"')]/label","Select "+selectItem1+" option in Category section");
				
				Thread.sleep(5000);
				
				//Click PDF
				
				JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='Type']/following::label[contains(.,'"+selectItem2+"')]/label")));
				oASelFW.effecta("click","//h4[text()='Type']/following::label[contains(.,'"+selectItem2+"')]/label","Select "+selectItem2+" option in Type section");
				
				Thread.sleep(5000);
				
				//Click on Apply Filter
				// oASelFW.effecta("click","//input[@id='applyFilters']","Apply Filter");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='applyFilters']")));
				oASelFW.driver.findElement(By.xpath("//input[@id='applyFilters']")).click();
				
				Thread.sleep(20000);
				
				System.out.println("Clicked");
				
				
				jse.executeScript("window.scrollBy(0,-250)", "");
				
				Thread.sleep(2000);
				
				String value1 = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerHTML;",  oASelFW.driver.findElement(By.xpath("//div[@ng-if='showNoResult']")));
				System.out.println(value1);

				
				//verify VMware Recommended Search results of there are no results.
				
			//	oASelFW.effecta("verifyElementPresent","//span[text()='VMware Recommended']","Successfully Verified VMware Recommended Search");
				
				
				//verifying text message 1 on web page

				if(value1.contains("your search"))
				{
					oASelFW.effecta("sendReport","Verifying \"your serach\" message","verified \"your search\" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \"your serach\" message","Not found \"your serach\" message","Fail");
				}	

				//verifying text message 2 on web page
				
				if(value1.contains("did not match any documents"))
				{
					oASelFW.effecta("sendReport","Verifying \"did not match any documents\" message","verified \"did not match any documents\" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \"did not match any documents\" message","Not found \"did not match any documents\" message","Fail");
				}
				
				
				//verifying text message 3 on web page
				
				if(value1.contains("No pages were found containing"))
				{
					oASelFW.effecta("sendReport","Verifying \" No pages were found containing \" message","verified \" No pages were found containing \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" No pages were found containing \" message","Not found \" No pages were found containing \" message","Fail");
				}
				
				
				//verifying text message 4 on web page
				
				if(value1.contains("Suggestions"))
				{
					oASelFW.effecta("sendReport","Verifying \"Suggestions\" message","verified \"Suggestions\" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \"Suggestions\" message","Not found \"Suggestions\" message","Fail");
				}
				
				//verifying text message 5 on web page
				
				if(value1.contains("Make sure all words are spelled correctly"))
				{
					oASelFW.effecta("sendReport","Verifying \" Make sure all words are spelled correctly \" message","verified \" Make sure all words are spelled correctly \" message","Pass");
				}
				
				else
				{
					oASelFW.effecta("sendReport","Verifying \" Make sure all words are spelled correctly \" message","Not found \" Make sure all words are spelled correctly \" message","Fail");
				}
				
				//verifying text message 6 on web page

				if(value1.contains("Try different keywords"))
				{
					oASelFW.effecta("sendReport","Verifying \" Try different keywords \" message","verified \" Try different keywords \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" Try different keywords \" message","Not found \" Try different keywords \" message","Fail");
				}
				
				//verifying text message 7 on web page
				
				if(value1.contains("Try more general keywords"))
				{
					oASelFW.effecta("sendReport","Verifying \" Try more general keywords \" message","verified \" Try more general keywords \" message","Pass");
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying \" Try more general keywords \" message","Not found \" Try more general keywords \" message","Fail");
				}
				
				//verifying text message 8 on web page
				
				if(value1.contains("try broadening the search by unchecking the filter criteria"))
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
		
		public void verifyRecommendedSearchResutls()
		{
			
		//verify VMware Recommended Search results of there are no results.
			
		oASelFW.effecta("verifyElementPresent","//span[text()='VMware Recommended']","Successfully Verified VMware Recommended Search");	
			
		}
		
		public void verifyCategoryTypeSubSection(String selectItem){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Search')]")));
				oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Search')]","Search Box Name");
				oASelFW.effecta("verifyElementPresent","//input[@name='q']","Search Box");	
				Thread.sleep(6000);
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(15000);	
			
				
				// Verifying below Ten Sections under Category section
				
				//Verifying Products & Solutions
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Products & Solutions')]/input","Products & Solutions option in Category section");
				
				//Verifying Support and Downloads
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Support and Downloads')]/input","Support and Downloads option in Category section");
				
				//Verifying Knowledge Base
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Knowledge Base')]/input","Knowledge Base option in Category section");
				
				//Verifying Product Documentation
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Product Documentation')]/input","Product Documentation option in Category section");
				
				//Verifying Community
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Community')]/input","Community option in Category section");
				
				//Verifying Technical Publications
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Technical Publications')]/input","Technical Publications option in Category section");
				

				//Verifying Blogs
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Blogs')]/input","Blogs option in Category section");
				
				
				//Verifying Store
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Store')]/input","Store option in Category section");
				
				

				//Verifying Security
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Security')]/input","Security option in Category section");
				

				//Verifying Developer Center
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Developer Center')]/input","Developer Center option in Category section");
				
				
				// Verifying below Ten Sections under Type section
				
				//Verifying Web
				oASelFW.effecta("verifyElementPresent","//h4[text()='Type']/following::label[contains(.,'Web')]/input","Web option in Type section");
				
				//Verifying PDF
				oASelFW.effecta("verifyElementPresent","//h4[text()='Type']/following::label[contains(.,'PDF')]/input","PDF option in Type section");
				
				//Verifying Video
				oASelFW.effecta("verifyElementPresent","//h4[text()='Type']/following::label[contains(.,'Video')]/input","Video option in Type section");
				
				
				//Click on Products & Solutions in category and PDF in type and click on Apply Filers to verify results
				
				//click Product Documentation
				oASelFW.effecta("clickAndWait","//h4[text()='Category']/following::label[contains(.,'Product Documentation')]/label","Product Documentation option in Category section");
				
				Thread.sleep(3000);
				
				//Click PDF
				oASelFW.effecta("clickAndWait","//h4[text()='Type']/following::label[contains(.,'PDF')]/label","PDF option in Type section");
				
				
				
				Thread.sleep(10000);
				
				//Click on Apply Filter
				oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
				//oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
				
				Thread.sleep(20000);
				
				System.out.println("Clicked");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
				System.out.println(text);
				
				if(text.contains(selectItem))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found","Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
				}
				
				
				//Verifying Search Result title in Support Page
				oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title format verification");
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		public void verifyLocalizedCategoryTypeSubSection(String selectItem,String search){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+search+"']")));
				oASelFW.effecta("verifyElementPresent","//h2[text()='"+search+"']","Search Box Name");
				oASelFW.effecta("verifyElementPresent","//input[@name='q']","Search Box");	
				Thread.sleep(6000);
				oASelFW.effecta("clickAndWait","//span[@class='input-group-addon search-select-addon']","Clicking to search icon");
				Thread.sleep(15000);	
			
				
				// Verifying below Ten Sections under Category section
				
				//Verifying Products & Solutions
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Products & Solutions')]/input","Products & Solutions option in Category section");
				
				//Verifying Support and Downloads
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Support and Downloads')]/input","Support and Downloads option in Category section");
				
				//Verifying Knowledge Base
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Knowledge Base')]/input","Knowledge Base option in Category section");
				
				//Verifying Product Documentation
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Product Documentation')]/input","Product Documentation option in Category section");
				
				//Verifying Community
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Community')]/input","Community option in Category section");
				
				//Verifying Technical Publications
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Technical Publications')]/input","Technical Publications option in Category section");
				

				//Verifying Blogs
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Blogs')]/input","Blogs option in Category section");
				
				
				//Verifying Store
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Store')]/input","Store option in Category section");
				
				

				//Verifying Security
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Security')]/input","Security option in Category section");
				

				//Verifying Developer Center
				oASelFW.effecta("verifyElementPresent","//h4[text()='Category']/following::label[contains(.,'Developer Center')]/input","Developer Center option in Category section");
				
				
				// Verifying below Ten Sections under Type section
				
				//Verifying Web
				oASelFW.effecta("verifyElementPresent","//h4[text()='Type']/following::label[contains(.,'Web')]/input","Web option in Type section");
				
				//Verifying PDF
				oASelFW.effecta("verifyElementPresent","//h4[text()='Type']/following::label[contains(.,'PDF')]/input","PDF option in Type section");
				
				//Verifying Video
				oASelFW.effecta("verifyElementPresent","//h4[text()='Type']/following::label[contains(.,'Video')]/input","Video option in Type section");
				
				
				//Click on Products & Solutions in category and PDF in type and click on Apply Filers to verify results
				
				//click Product Documentation
				oASelFW.effecta("clickAndWait","//h4[text()='Type']/following::label[contains(.,'Web')]/label","Web option in Type section");
				
				Thread.sleep(3000);
				
				//Click PDF
				oASelFW.effecta("clickAndWait","//h4[text()='Type']/following::label[contains(.,'PDF')]/label","PDF option in Type section");
				
				
				Thread.sleep(5000);
				
				//Click on Apply Filter
				oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
				oASelFW.effecta("clickAndWait","//input[@id='applyFilters']","Apply Filter");
				
				Thread.sleep(20000);
				
				System.out.println("Clicked");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Results for']")));
				String text = (String) ((JavascriptExecutor) oASelFW.driver).executeScript("return arguments[0].innerText", oASelFW.driver.findElement(By.xpath("//div[@class='search-summary']")));
				System.out.println(text);
				
				if(text.contains(selectItem))
				{
					oASelFW.effecta("sendReport","Verifying Search results","Successfully verifed "+selectItem+" found "+text,"Pass") ;
				}
				else
				{
					oASelFW.effecta("sendReport","Verifying Search results",selectItem+" Not Found","Fail") ;
				}
				
				
				//Verifying Search Result title in Support Page
				oASelFW.effecta("verifyElementPresent","//span[contains(text(),'sort by')]/following::a[3]","title format verification");
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
		public void ClickResetFilters(){
			try{
				WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='resetFilters']")));
				oASelFW.effecta("verifyElementPresent","//input[@id='resetFilters']","Reset button");
	
				oASelFW.effecta("clickAndWait","//input[@id='resetFilters']","Clicking to Reset");
				Thread.sleep(15000);			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
		public void verifyVMwareSearchInputValue(String text) throws Exception{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-if,'showNoResult')]/p/span[contains(text(),'x6768')]	")));

			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[text()='Search']"))){
				oASelFW.effecta("sendReport","Verifying whether User Navigated to Search Page or not","Successfully verifed.User Navigated to Search Page","Pass") ;
			}
			else{
				oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Search Page or not","Unable to verify","Fail") ;
			}
		}	
		
		
		
		
	}
