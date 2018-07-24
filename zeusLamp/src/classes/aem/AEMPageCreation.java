package classes.aem;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;
import com.sun.jna.platform.win32.OaIdl;
//import com.sun.org.apache.regexp.internal.recompile;

public class AEMPageCreation {
	ArsinSeleniumAPI oASelFW;
	
	public AEMPageCreation(){

	}
	public AEMPageCreation(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
		
	}

	public String page_Creation() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));

		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Name')]/following-sibling::input",name,"Name");
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input",name,"Title");

		//DESCRIPTION
		oASelFW.effecta("type","//label[contains(text(),'Page Title')]/following-sibling::input",name,"Page Title");

		/*//ANALYTICS METADATA
		oASelFW.effecta("select","//label[contains(text(),'Page Content Type')]/following-sibling::span/descendant::select","Home","Page Content Type");*/

		System.out.println("Entering------");
		Thread.sleep(4000);
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		Thread.sleep(4000);
		//oASelFW.effecta("clickAndWait","//a[text()='Cancel']&&//a[contains(@data-action,'cancel')]","Cancel");

		//CLASSIC UI
		/*oASelFW.effecta("click","//i[@class='coral-Icon coral-Icon--properties coral-Icon--sizeS']","Page Information");
		oASelFW.effecta("click","//button[contains(text(),'Open in Classic UI')]","Classic UI");
		 */

		System.out.println("The name of the page is "+name);
		return name;
	}
	
	public void clickCreateButton() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Create']")));
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		Thread.sleep(4000);
	
	}
	
	
	public String VMworld_page_Creation()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));

		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Name')]/following-sibling::input",name,"Name");
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input",name,"Title");

		//DESCRIPTION
		oASelFW.effecta("type","//label[text()='Page Title Test']/following-sibling::input",name,"Page Title");

		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		//oASelFW.effecta("clickAndWait","//a[text()='Cancel']&&//a[contains(@data-action,'cancel')]","Cancel");

		//CLASSIC UI
		/*oASelFW.effecta("click","//i[@class='coral-Icon coral-Icon--properties coral-Icon--sizeS']","Page Information");
		oASelFW.effecta("click","//button[contains(text(),'Open in Classic UI')]","Classic UI");
		 */

		System.out.println("The name of the page is "+name);
		return name;
	}


	public void verifyPageCreation(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Done']")));

		oASelFW.effecta("verifyElementPresent","//div[text()='Your page has been created.']","Your page has been created.");
		oASelFW.effecta("verifyElementPresent","//button[text()='Done']","Done");
		oASelFW.effecta("click","//button[text()='Done']","Done");

	}

	public void verifyPageCreated(String pageCreatedMessage){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+pageCreatedMessage+"')]")));

		oASelFW.effecta("verifyElementPresent","//button[text()='Open page']","Open page");
	}

	public void ClickPublishPage(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Publish Page']")));

		oASelFW.effecta("verifyElementPresent","//button[text()='Publish Page']","Publish Page");
	}

	public void ClickOpenPage(String fieldname) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+fieldname+"']")));

		oASelFW.effecta("clickAndWait","//button[text()='"+fieldname+"']","150",fieldname);
	
		
	}
	
	
	public void switchWindowClose() throws InterruptedException, AWTException
	{
		
		
		
	/*	Robot robot=new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
*/		
		
		
		oASelFW.driver.close();
		

		Thread.sleep(15000);
		
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(0));
		
		
		
	}
	
	
	
	
	
	
	

	public void clickViewPropertiesForPage(String pageName) throws Exception{

		Thread.sleep(5000);

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+pageName+"']")));

		/*if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[text()='Deselect']"))){
			Thread.sleep(2000);
			oASelFW.effecta("click","//span[text()='Deselect']","DeSelect");
		}*/

		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[text()='"+pageName+"']","Page:"+pageName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='View Properties']")));

		oASelFW.effecta("clickAndWait","//span[text()='View Properties']","View Properties");
		Thread.sleep(3000);

		/*Actions act=new Actions(oASelFW.driver);
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", we);
		act.moveToElement(we).build().perform();
		Thread.sleep(20000);
		System.out.println("After mouse Over");

		act.moveToElement(oASelFW.driver.findElement(By.xpath("//a[@title='View Properties']/i"))).click().build().perform();

		//oASelFW.effecta("click","//a[@title='View Properties']","View Properties");
		System.out.println("clicked view properties");*/
		Thread.sleep(3000);

	}

	public void edit_MetaDataProperties(String details) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Page Content Type']/..//span//select")));
		oASelFW.effecta("select","//label[text()='Page Content Type']/..//span//select",details,"Page Content Type");
		//oASelFW.effecta("select","//label[text()='Journey Stage']/..//span//select",details[1],"Journey Stage");
		//oASelFW.effecta("select","//label[text()='Internal Engagement Channel']/..//span//select",details[2],"Internal Engagement Channel");
		//oASelFW.effecta("select","//label[text()='Score']/..//span//select",details[3],"Score");
		//oASelFW.effecta("select","//label[text()='Personas']/..//span//select",details[4],"Personas");
	//	oASelFW.effecta("select","//label[text()='Entitlement Type']/..//span//select",details[5],"Entitlement Type");
		oASelFW.effecta("clickAndWait","//button[@title='Done']","Done");
		Thread.sleep(5000);
	}

	public void edit_MetaDataProperties_None(String details) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Internal Engagement Channel']/..//span//select")));
	//	oASelFW.effecta("select","//label[text()='Journey Stage']/..//span//select",details[0],"Journey Stage");
		oASelFW.effecta("select","//label[text()='Internal Engagement Channel']/..//span//select",details,"Internal Engagement Channel");
		//oASelFW.effecta("select","//label[text()='Personas']/..//span//select",details[2],"Personas");
		oASelFW.effecta("clickAndWait","//button[@title='Done']","Done");
		Thread.sleep(5000);

	}


	public void clickSelectAndPublishPage(String pageName) throws Exception{
		Thread.sleep(6000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[text()='Deselect']"))){
			oASelFW.effecta("click","//span[text()='Deselect']","DeSelect");
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[text()='"+pageName+"']","Page:"+pageName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));

		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Publish']","Publish");
		oASelFW.effecta("click","//a[text()='Publish']","Publish");

		Thread.sleep(5000);

	}


	public void clickSelectAndOpenPage(String pageName) throws Exception{

		oASelFW.driver.navigate().refresh();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[text()='Deselect']"))){
			Thread.sleep(2000);
			System.out.println("SDeselct Found");
			oASelFW.effecta("click","//span[text()='Deselect']","DeSelect");
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[text()='"+pageName+"']","Page:"+pageName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Open']")));

		oASelFW.effecta("clickAndWait","//span[text()='Open']","More");
		Thread.sleep(5000);

	}

	public String getAuthURL() throws Exception{
		Thread.sleep(5000);
		String win[]=oASelFW.effectaArray("getAllWindowNames");
		oASelFW.effecta("selectWindow",win[1]);

		String authURL=oASelFW.driver.getCurrentUrl();
		System.out.println("authURL:"+authURL);
		return authURL;

	}

	public String formPublishedURL(String authoringURL)
	{
		String publishedURL="";

		publishedURL=authoringURL.replaceAll("auth", "pub");

		if(publishedURL.contains("/editor.html")){
			publishedURL=publishedURL.replaceAll("/editor.html", "");
		}
		if(publishedURL.contains("8080")){
		publishedURL=publishedURL.replaceAll("8080", "8085");
		}
		if(publishedURL.contains("8081")){
		publishedURL=publishedURL.replaceAll("8081", "8086");
		}

		return publishedURL;
	}

	public String getPageSource(){

		//String pageSource=oASelFW.driver.findElement(By.tagName("head")).getText();
		String pageSource=oASelFW.driver.getPageSource();

		//System.out.println("Head Tag Data:"+pageSource);

		if(pageSource.contains("\"")) {
			pageSource = pageSource.replaceAll("\"", "");
		}

		//System.out.println("Head Tag Data After Replace:"+pageSource);

		/*if(pageSource.contains("")){

		}*/

		return pageSource;
	}

	public void verifyPageSource(String[] details,String pageSource,String metaTagNames[]){

		for(int i=0;i<details.length;i++){

			if(details[i].contains("Contact Sales Form")){
				details[i]=details[i].replaceAll("Contact Sales Form", "Contact Sales");
			}

			if(metaTagNames[i].contains(" ")){
				metaTagNames[i]=metaTagNames[i].replaceAll(" ", "");
			}

			if(details[i].contains(" ")){
				details[i]=details[i].replaceAll(" ", "-");
			}

			metaTagNames[i]=metaTagNames[i].toLowerCase();

			details[i]=details[i].toLowerCase();

			System.out.println("<meta name="+metaTagNames[i].trim()+" content="+details[i].trim()+" />");

			if(pageSource.contains("<meta name="+metaTagNames[i].trim()+" content="+details[i].trim()+" />")){

				oASelFW.effecta("sendReport","Validating page Source for meta tag:"+metaTagNames[i],"succesfuly verified content as:"+details[i].replaceAll("-", " "),"Pass");
			}else{
				oASelFW.effecta("sendReportWithOutExit","Validating page Source for meta tag:"+metaTagNames[i],"Unable to verify content as:"+details[i].replaceAll("-", " "),"Fail");
			}
		}
	}

	public void verifyPageSource_None(String[] details,String pageSource,String metaTagNames[]){

		for(int i=0;i<details.length;i++){

			if(metaTagNames[i].contains(" ")){
				metaTagNames[i]=metaTagNames[i].replaceAll(" ", "");
			}

			metaTagNames[i]=metaTagNames[i].toLowerCase();

			details[i]=details[i].toLowerCase();

			System.out.println("<meta name="+metaTagNames[i].trim()+" content="+details[i].trim()+" />");

			if(pageSource.contains("<meta name="+metaTagNames[i].trim()+" content="+details[i].trim()+" />")){

				oASelFW.effecta("sendReport","Validating page Source for meta tag:"+metaTagNames[i],"succesfuly verified content as:"+details[i],"Pass");
			}else{
				oASelFW.effecta("sendReportWithOutExit","Validating page Source for meta tag:"+metaTagNames[i],"Unable to verify content as:"+details[i],"Fail");
			}
		}
	}

	public void clickSelectAndPublishPage_FAQ(String pageName) throws Exception{
		Thread.sleep(6000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		AEMComponentCreation aemcomponent=new AEMComponentCreation(oASelFW);
		aemcomponent.scrollPage();
		oASelFW.effecta("click","//h4[text()='"+pageName+"']","Page:"+pageName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));

		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Publish']","Publish");
		oASelFW.effecta("click","//a[text()='Publish']","Publish");
		Thread.sleep(5000);

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[contains(@class,'coral-Wizard-nextButton')]"))){
			System.out.println("Publish Page is Opened");

			AEMComponentCreation aemComponentObj=new AEMComponentCreation(oASelFW);
			aemComponentObj.Click_Publish_DefaultDesign_Checkbox();

			oASelFW.effecta("clickAndWait","//button[contains(@class,'coral-Wizard-nextButton')]","Publish");
		}
		Thread.sleep(6000);
	}

	public void switch_window_aftOpenPge(String pageno) throws InterruptedException
	{
		Thread.sleep(10000);
		String parent_window = oASelFW.driver.getWindowHandle();
		System.out.println("The parent window is "+parent_window);
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		for(String winhandle:tabs)
			oASelFW.driver.switchTo().window(winhandle);
		
		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Preview')]")));
		Thread.sleep(6000);
		String URL = oASelFW.driver.getCurrentUrl();
		System.out.println("The URL of the page is ---------"+URL);
		//oASelFW.effecta("sendReport","User able to open the page",URL,"Pass");
	
		if(URL.contains(pageno))
			System.out.println("Page is visible to end user");
		oASelFW.effecta("sendReport","User able to open the page ","Successfully opened the created page: "+pageno,"Pass");
		System.out.println("Switched to new window ");
		Thread.sleep(6000);
		oASelFW.driver.close();
		Thread.sleep(3000);
		oASelFW.driver.switchTo().window(parent_window);
		Thread.sleep(6000);

	}

	public void mouseover_open_template(String pageno) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+pageno+"')]")));
		Actions action = new Actions(oASelFW.driver);
		WebElement we = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+pageno+"')]"));		
		action.moveToElement(we).build().perform();
		System.out.println("mouse over element");
		Thread.sleep(3000);
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul[contains(@class,'quickaction-bar')]/li"));
		System.out.println("list size is:"+list.size());
		oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'quickaction-bar')]/li[1]")).click();
		oASelFW.effecta("sendReport","Verified click on"+pageno,"Successfully click on element "+pageno,"Pass");
		Thread.sleep(2000);
	}

	public void clickSelect() throws Exception{
		//oASelFW.driver.navigate().refresh();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
	}

	public void clickDeSelect() throws Exception{
		//oASelFW.driver.navigate().refresh();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='DeSelect']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='DeSelect']")));
		oASelFW.effecta("click","//span[text()='DeSelect']","DeSelect");
	}

	public void openPage(String pageName) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='"+pageName+"']")));
		oASelFW.effecta("click","//h4[text()='"+pageName+"']","Page:"+pageName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Open']")));

		oASelFW.effecta("clickAndWait","//span[text()='Open']","Open");
		Thread.sleep(5000);
	}

	public void verifyUtag_jsFile(){

		String url=oASelFW.driver.getCurrentUrl();

		if(url.trim().contains("editor.html/")){
			url=url.replaceAll("editor.html/", "");
		}
		oASelFW.driver.get(url);

		String we=oASelFW.driver.getPageSource();

		if((we.contains("//tags.tiqcdn.com/utag/"))&&(we.contains("utag.sync.js"))&&(we.contains("utag_data.js"))){
			oASelFW.effecta("sendReport","Validating utag.sync.js is configured or not for created page","Successfully verified....utag.sync.js is configured in created page","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating utag.sync.js is configured or not for created page","Unable to verify...utag.sync.js is not configured in created page","Fail");
		}
	}

	public void verifyUtag_jsFile_NetworkData(){
		Object netData = ((JavascriptExecutor)oASelFW.driver).executeScript("return window.performance.getEntries();");

		System.out.println(netData);
		String value=netData.toString();
		if(value.contains("//tags.tiqcdn.com/utag/")&&value.contains("utag.sync.js")){
			System.out.println("Pass");
			oASelFW.effecta("sendReport","Validating utag.sync.js is configured or not for created page in Network tab","Successfully verified....utag.sync.js is configured in created page in Network tab","Pass");
		}else{
			System.out.println("Fail");
			oASelFW.effecta("sendReportWithOutExit","Validating utag.sync.js is configured or not for created page in Network tab","Unable to verify...utag.sync.js is not configured in created page in Network tab","Fail");
		}

	}
	
	public void verifyEloqua_JsFile(){
		Object netData = ((JavascriptExecutor)oASelFW.driver).executeScript("return window.performance.getEntries();");

		System.out.println(netData);
		String value=netData.toString();
		//if(value.contains("elqCfg.min.js")&&value.contains("svrGP?pps=3&siteid=279193683&ref2=http://aem-test-auth-1.vmware.com:8080/content/vmware/language-master-sites/en/QATestAutomation/utagVerification.html&tzo=-330&ms=69&optin=disabled")){
		if(value.contains("elqCfg.min.js")&&value.contains("svrGP?pps=3")&&value.contains("optin=disabled")){
			System.out.println("Pass");
			oASelFW.effecta("sendReport","Validating elqCfg.min.js and svrGP?pps=3 image are configured or not for created page","Successfully verified....elqCfg.min.js and svrGP?pps=3 are configured in created page","Pass");
		}else{
			System.out.println("Fail");
			oASelFW.effecta("sendReportWithOutExit","Validating elqCfg.min.js and svrGP?pps=3 image are configured or not for created page","Unable to verify...elqCfg.min.js and svrGP?pps=3 are not configured in created page","Fail");
		}

	}
	public void click_Preview() throws InterruptedException
	{
		oASelFW.effecta("click","//button[@title='Preview']","Preview Button is clicked");
		Thread.sleep(4000);
	     
	}
	
	public void clickPageNation()
	{
		oASelFW.driver.switchTo().frame("ContentFrame");
		WebElement element = oASelFW.driver.findElement(By.xpath("//li[contains(@id,'viewNext')]/preceding-sibling::li/a[contains(text(),'10')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	public void verify_Hol_Feed_RenderComponent()
	{
		//oASelFW.effecta("verifyElementPresent","//div[contains(text(),'HOL Feed Render Component')]","Verified HOL Feed Render Component is Present");
		oASelFW.effecta("isElementPresent","//h3[contains(text(),'HOL-SDC-1603')]","HOL Feed Render Component is Present");	
	}

	public void click_Edit() throws InterruptedException
	{
		System.out.println("Inside click_Edit");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button")));
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button","Edit button is clicked");
		Thread.sleep(3000);
	}
	
	
	public void click_EditPage() throws InterruptedException
	{
		System.out.println("click_Edit");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Preview')]/parent::button/preceding-sibling::button[contains(text(),'Edit')]")));
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[contains(text(),'Preview')]/parent::button/preceding-sibling::button[contains(text(),'Edit')]","Edit button is clicked");
		Thread.sleep(3000);
	}
	
	public void edit_TechPage() throws InterruptedException
	{
		System.out.println("Edit_techpage");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame')]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-type,'Editable')][2]")));
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[contains(@data-type,'Editable')][2]","clicked on pdf icon");
		Thread.sleep(3000);
		
		oASelFW.effecta("click","//button[@data-action='CONFIGURE']","clicked on configure");
		Thread.sleep(5000);
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Technical Paper Details')]","Technical Paper Details is present Verified");
		Thread.sleep(2000);
		
		oASelFW.driver.switchTo().defaultContent();
	}


	public void verify_HeroBannerComponents(String altText) throws InterruptedException
	{
		
		System.out.println("Edit_techpage");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='"+altText+"']")));
		System.out.println("Enter into verify_HeroBannerComponents");
		Thread.sleep(3000);
		/*String Eventdes = oASelFW.effecta("getText","//div[@class='herobanner section']/header/div/div/div");
		oASelFW.effecta("verifyElementPresent","//div[@class='herobanner section']/header/div/div/div/h2",Eventdes+"Event Description and  CTA Label  is present Verified");
		Thread.sleep(2000);*/
		
		oASelFW.effecta("verifyElementPresent","//img[@alt='"+altText+"']","Image Verified");
		
		/*String CTALabel =oASelFW.effecta("getText","//div[@class='herobanner section']/div/div/div/div/header/div/div/div/a");
		oASelFW.effecta("verifyElementPresent","//div[contains(text(),'Hero Banner Component')]/div/div/div/div/header/div/div/div",CTALabel+"Event Description and CTA Label is present Verified");
		
		String date_adress = oASelFW.effecta("getText","//div[@class='herobanner section']/header/div/div/div[2]/div");
		oASelFW.effecta("verifyElementPresent","//div[@class='herobanner section']/header/div/div/div[2]/div",date_adress+"Date and Address is present Verified");
		Thread.sleep(3000);*/
		//oASelFW.driver.switchTo().defaultContent();
	}

	
	
	
	public void insert_Images_HeroBannerComponents1(String img,String altText) throws InterruptedException
	{
		AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@role='tablist']/a[text()='Hero Carousel Images']")));
		Thread.sleep(3000);
		oASelFW.effecta("click","//nav[@role='tablist']/a[text()='Hero Carousel Images']","Images Tab is clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		Thread.sleep(3000);
		
		aemComponentsObj.clickOnTabPanelLinks("Assets");
		Thread.sleep(5000);
		
		aemComponentsObj.enterTextInput(img, "Assets");
		Thread.sleep(5000);
		
		aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");
		
		
		oASelFW.effecta("type","//label[contains(text(),'Image Alt Text')]/following::input",altText,"Alt Text");
		Thread.sleep(3000);
		//oASelFW.effecta("type","//label[contains(text(),'BrightCove Video ID')]/following::input","banner-hero-network-02.jpg","Image selected");
		
	}
	
	
	
	
	
	public void click_PageHeader_tick() throws InterruptedException
	{
		Thread.sleep(3000);
		oASelFW.effecta("click","//button[@title='Done']","Done Button is clicked");	
		
	}
	
	public void verify_VMwarelogo()
	
	{
		System.out.println("Enter into verify_VMwarelogo");
		oASelFW.effecta("verifyElementPresent","//div[@class='vmworldLogo']","Verified VMWare logo is present after preview the page");
		
	}
	
	
	public void drag_drop_megaMenu(String container) throws InterruptedException
	{
		System.out.println("Inside drag_drop_megaMenu");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+container+"')]/parent::div/parent::a/parent::article")));
		Actions action = new Actions(oASelFW.driver);
		WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+container+"')]/parent::div/parent::a/parent::article"));
		WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		Thread.sleep(4000);
      }
		
	
	public void clickOn_RightHandSideHeaderPublishedVideo() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//figure[@class='img-caption']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//figure[@class='img-caption']")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//figure[@class='img-caption']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
	
		Thread.sleep(5000);
		//oASelFW.effecta("click","//figure[@class='img-caption']","published video");
		oASelFW.driver.switchTo().defaultContent();
		
	}
	
	public void clickOn_RightHandSideHeaderPublishedVideo_PublishMode() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//figure[@class='img-caption']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//figure[@class='img-caption']")));
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//figure[@class='img-caption']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
	
		Thread.sleep(5000);
		
	}
	
	public void verifyRighHandBannerVideo_PublishMode(String videoID)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//object[contains(@data,'videoPlayer="+videoID+"')]")));
		oASelFW.effecta("verifyElementPresent","//object[contains(@data,'videoPlayer="+videoID+"')]","Verify Video ID");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//object[contains(@data,'videoPlayer="+videoID+"')]")))
		{
			oASelFW.effecta("sendReport","Validating Right Hand Banner Video Playing","Right Hand Banner Video successfully played","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating Right Hand Banner Video Playing","Right Hand Banner Video is not playing","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void verifyRighHandBannerVideo(String videoID)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//object[contains(@data,'videoPlayer="+videoID+"')]")));
		oASelFW.effecta("verifyElementPresent","//object[contains(@data,'videoPlayer="+videoID+"')]","Verify Video ID");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//object[contains(@data,'videoPlayer="+videoID+"')]")))
		{
			oASelFW.effecta("sendReport","Validating the Video is Playing","Video successfully played with video id: "+videoID,"Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating the Video is Playing","Video is not playing","Fail");
		}
		
	}
	
	
	public void verifyElementPresent()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Page Not Found')]")));
		oASelFW.effecta("verifyElementPresent","//p[contains(text(),'Page Not Found')]","Element Present");
		
	}
	
	
	public void verifyElementPresent_Stage(String element)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+element+"']")));
		oASelFW.effecta("verifyElementPresent","//h2[text()='"+element+"']","Element Present:-"+element);
	}
	
	
	public void verifyPricingTableComponent() throws Exception
	{
		String we=oASelFW.driver.getPageSource();
		Thread.sleep(5000);
		
		if((we.contains("pricingtable")))
		{
			oASelFW.effecta("sendReport","Validating pricing table is  configured or not for created page","Successfully verified pricing table is  configured for created page","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating pricing table is  configured or not for created page","Unable to verify pricing table for created page","Fail");
		}
	}
	
	
	public void verifyhomePAgeComponent() throws Exception
	{
		String we=oASelFW.driver.getPageSource();
		Thread.sleep(5000);
		
		if((we.contains("twocolumntabcontainer"))&&(we.contains("full-width"))&&(we.contains("homepagepromo"))&&(we.contains("herocarousel"))&&(we.contains("carouselContent1"))){
			oASelFW.effecta("sendReport","Validating home page component is  configured or not for created page","Successfully verified home page component is  configured for created page","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating home page component is  configured or not for created page","Unable to verify home page component is not configured for created page","Fail");
		}
	}
	
	public void click_ProductButton(String category)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='"+category+"']")));
		oASelFW.effecta("click","//input[@value='"+category+"']","Button Clicked:-"+category);
	}
	
	public void click_PricingButton(String button)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+button+"']")));
		oASelFW.effecta("click","//a[text()='"+button+"']","Button Clicked:-"+button);
	}
	
	
	
	public void click_Alphabet(String alphabet) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+alphabet+"']")));
		oASelFW.effecta("click","//a[text()='"+alphabet+"']","Button Clicked:-"+alphabet);
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","(//a[text()='vSphere'])[5]")))
		{
			oASelFW.effecta("sendReport","Validating vsphere is coming under given alphabet","Successfully validated ","Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating vsphere is coming under given alphabet","It is not coming under given alphabet","Fail");
		}
		
	}
	
	public void ValidateHeading(String heading) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+heading+"']")));
		oASelFW.effecta("isElementPresent","//h2[text()='"+heading+"']");
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","(//a[text()='Fusion'])[6]")))
		{
			oASelFW.effecta("sendReport","Validating fusion is coming under given heading","Successfully validated ","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Validating fusion is coming under given heading","It is not coming under given alphabet","Fail");
		}	
	}
	
	
	
	
	}





