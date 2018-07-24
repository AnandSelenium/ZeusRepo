package classes.aem;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMSitesPage {
	ArsinSeleniumAPI oASelFW;

	public AEMSitesPage(){

	}
	public AEMSitesPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void verifySitesPage(String pageName){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='endor-BlackBar-title']")));
		
		oASelFW.effecta("verifyElementPresent","//div[@class='endor-BlackBar-title']",pageName);
		System.out.println("Verified Sites Page");
	}
	
	
	
	public void Verify_CreatedPage(String title , String title2)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'endor-UserProfile-avatar')]")));
		if(oASelFW.driver.findElements(By.xpath("//h4[text()='"+title+"']")).size()>0)
		{	
			oASelFW.effecta("sendReport","Verify the page is Translated or not","The Page is successfully translated","Pass");
		}
		else if(oASelFW.driver.findElements(By.xpath("//h4[text()='"+title2+"']")).size()>0)
		{
			oASelFW.effecta("sendReport","Verify the page is Translated or not","The Page is successfully translated","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify the page is Translated or not","The Page is not translated","Fail");
		}
	}
	
	
	public void clickOnRequiredSite(String siteName) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+siteName+"']")));
		
		oASelFW.effecta("clickAndWait","//h4[text()='"+siteName+"']","Template Name:"+siteName);
		System.out.println("Clicked on required sites");
	}
	
	public void clickOnRequiredPage_Open(String pageName) throws InterruptedException{
		
		Actions action = new Actions(oASelFW.driver);
		
		WebElement we = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+pageName+"']"));
		action.moveToElement(we, 5, 6).build().perform();
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//li/button[@title='Open']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		System.out.println("Clicked on required Page");
	}
	
	
	public void clickOnRequiredSiteTitle(String siteTitle)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+siteTitle+"']")));
		oASelFW.effecta("clickAndWait","//div[text()='"+siteTitle+"']","Site Title:"+siteTitle);
	}
	
	
	public void clickOnVMmarkPageTitle(String siteTitle)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+siteTitle+"']")));
		oASelFW.effecta("clickAndWait","//h4[text()='"+siteTitle+"']","Title:"+siteTitle);
	}
	
	public void clickOnAssetReport_Report()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Report']")));
		oASelFW.effecta("clickAndWait","//button[@title='Report']","Report");
	}
	
	public void clickOnRequiredHeading(String siteTitle){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+siteTitle+"']")));
		
		oASelFW.effecta("clickAndWait","//a[text()='"+siteTitle+"']","Site Title:"+siteTitle);
	}
	
	public void verifyBreadCrumb(String breadCrumb){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+breadCrumb+"']")));
		
		oASelFW.effecta("verifyElementPresent","//a[text()='"+breadCrumb+"']",breadCrumb);
	}
	
	public void clickRequiredBreadCrumb(String breadCrumb){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+breadCrumb+"']")));
		
		oASelFW.effecta("verifyElementPresent","//a[text()='"+breadCrumb+"']",breadCrumb);
		oASelFW.effecta("clickAndWait","//a[text()='"+breadCrumb+"']",breadCrumb);
	}
	
	public void clickCreateAndClickOnRequiredLink(String linkName) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Create']")));
		
		oASelFW.effecta("click","//a[@title='Create']","Create");
		Thread.sleep(3000);
		oASelFW.effecta("click","//a[text()='"+linkName+"']",linkName);
	}
	

	public void clickCreateLink_LaunchCopy(String linkName) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='Create'])[2]")));
		
		oASelFW.effecta("click","xpath=(//a[@title='Create'])[2]","Create");
		Thread.sleep(3000);
		oASelFW.effecta("click","xpath=(//a[text()='"+linkName+"'])[2]",linkName);
	}
	
	
	public void selectPageTemplate(String template){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+template+"']")));
		
		oASelFW.effecta("clickAndWait","//h4[text()='"+template+"']","Template Name:"+template);
	}
	
	
	public void selectPageTitle(String title) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 100);
		
		WebElement element = oASelFW.driver.findElement(By.xpath("(//h4[text()='"+title+"'])[1]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h4[text()='"+title+"'])[1]")));
		
		System.out.println("Title "+title);

		oASelFW.effecta("clickAndWait","xpath=(//h4[text()='"+title+"'])[1]","Title Name:"+title);
	}		




	public void clickNext(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button//span[text()='Next']")));
		
		oASelFW.effecta("clickAndWait","//button//span[text()='Next']&&//button[@data-action='next']","Next");
	}
	
	public void verifyPageTitle_In_TranslatedLanguage(String title, String language)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+title+"']")));
		oASelFW.effecta("verifyElementPresent","//h4[text()='"+title+"']",title);
		
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[text()='"+title+"']")))
		{
			oASelFW.effecta("sendReport","Verify the page is Translated to "+language+" language","The Page is successfully translated to "+language,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify the page is Translated to "+language+" language","The Page is not translated to "+language,"Fail");

		}
		
	
	}
	
	public void RequiredSitePage(String page)
	{
		oASelFW.effecta("clickAndWait","//h4[text()='"+page+"']","page name:"+page);

	}
	
	public void clickOnlink(String link)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'"+link+"')]")));
		oASelFW.effecta("click","//a[contains(.,'"+link+"')]","clicking on "+ link);
	}
	
	
	/**
	 * @author avinash_ankireddy
	 * @param link
	 * @throws InterruptedException
	 * clicking on open icon
	 */
	
	
	public void mouseHoverOnLinkAndOpenPage(String link) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+link+"')]")));
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+link+"')]"))).build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/button[contains(@title,'Open')]/i")));
		oASelFW.effecta("click","//ul/li/button[contains(@title,'Open')]/i","clicking on open button");
		Thread.sleep(15000);
		
		
	}
	
	
	public void mouseHoverOnLinkAndOpenPropertyPage(String link) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+link+"')]")));
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+link+"')]"))).build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li/button[contains(@title,'View Properties')]/i")));
		oASelFW.effecta("click","//ul/li/button[contains(@title,'View Properties')]/i","clicking on open button");
		Thread.sleep(15000);	
		
	}
	
	public String getPageurl(String language)
	{
		String currentURL = oASelFW.driver.getCurrentUrl();
		StringBuffer sb = new StringBuffer(currentURL);
		currentURL=(sb.replace(130,132,language)).toString(); 
		System.out.println(currentURL);
		return currentURL;	
		
	}
	
	public void clickNew(String header) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+header+"']")));
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//button[contains(text(),'New')]"));
		int count = list.size();
		System.out.println("list size is:"+list.size());
		for(int i=0;i<count;i++)
		{
		if(list.get(i).isDisplayed())
		{
			list.get(i).click();
			System.out.println("clicked success..");
			break;
		}
	}
	}
	
	public String createPage() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Create Page']")));
		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following::div/input",name,"Page Name"+name);
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Create Page']/following::button[text()='Create']","Click Submit");
		Thread.sleep(3000);
		return name;
	}
	
	public void openPage_SiteAdmin(String customerstoryName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+customerstoryName+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerstoryName+"']"))).perform();
		Thread.sleep(2000);
		oASelFW.effecta("click","//span[text()='Open']","Open");
		Thread.sleep(2000);
	}
	
	
	public void navigateBack()
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@title,'Back')]")));
		oASelFW.effecta("click","//button[contains(@title,'Back')]","clicking on back button");
	}
	
	
	
	public void ClickonSearch()
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Search']")));
		oASelFW.effecta("click","//button[@title='Search']","clicking on Search button");
	}
	
	
	
	
	public void EnterKeywordAndSearchValue(String value) throws InterruptedException, AWTException
	{
		Robot robot=new Robot();
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Keyword(s)']")));
		oASelFW.effecta("type","//input[@placeholder='Enter Keyword(s)']",value,"Enter Keyword(s)");
		
		Thread.sleep(5000);
		
	
		System.out.println("Editor--");
		System.out.println("----------Press -Robot Key Enter");
		

		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
	}
	
	///content/vmware/vmware-published-sites/jp/my-vmware/onlyAutoQA
	public void SelectSearchDirectory(String value) throws InterruptedException, AWTException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Select Search Directory']")));
		oASelFW.effecta("type","//input[@placeholder='Select Search Directory']",value,"Search Directory");
		Thread.sleep(8000);
		System.out.println("Editor--");
		oASelFW.effecta("click","//ul/li[contains(text(),'onlyAutoQA')]","Click page");
		Thread.sleep(5000);
	}
	
	
	
	public void searchKeyword(String value) throws InterruptedException, AWTException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Keyword(s)']")));
		oASelFW.effecta("type","//input[@placeholder='Enter Keyword(s)']",value,"Search Directory");
		oASelFW.driver.findElement(By.xpath("//input[@placeholder='Enter Keyword(s)']")).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
	}
	
	public void workflowText(String heading,String text) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+heading+"']")));
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='"+heading+"']/following-sibling::input",text,"Select Artifacts Under"+heading);
		Thread.sleep(8000);
	}
	
	public void drop_downWorkflow(String heading,String value) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+heading+"']")));
		Select select=new Select(oASelFW.driver.findElement(By.xpath("//select[@name='contentType']")));
		select.selectByValue(value);
		Thread.sleep(3000);
	}
	
	public void drop_downWorkflow2(String heading,String option) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+heading+"']")));
		oASelFW.effecta("select","//label[text()='"+heading+"']/following-sibling::select",option,"Workflow heading"+heading);
		Thread.sleep(3000);
	}
	
	public void WorkflowButton(String button) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'"+button+"')]")));
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//button[contains(text(),'"+button+"')]"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(10000);
	}
	
	public void publishAll() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Publish']")));
		oASelFW.effecta("click","//span[text()='Publish']","Publish");
		Thread.sleep(3000);
		oASelFW.effecta("click","//a[text()='Publish']","Final Publish");
		Thread.sleep(3000);
		oASelFW.effecta("sendReport","Validate all the nodes are published or not","All the nodes are successfully published","Pass");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[text()='Publish']")))
		{
			oASelFW.effecta("click","//button[text()='Publish']","Publish Button Clicked");
			Thread.sleep(5000);	
		}
	}
	
	public void clickUnpublish() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Unpublish']")));
		oASelFW.effecta("click","//span[text()='Unpublish']","Unpublish");
		Thread.sleep(3000);
		oASelFW.effecta("click","//a[text()='Unpublish']","Final Publish");
		Thread.sleep(3000);
		oASelFW.effecta("sendReport","Validate the nodes are Unpublished or not","All the nodes are successfully Unpublished","Pass");
	}
	
	
	
	public void selectAllPage()
	{
		Actions act=new Actions(oASelFW.driver);
		act.moveToElement(oASelFW.driver.findElement(By.xpath("//div[text()='Title']/../preceding-sibling::i[2]")),5,5).build().perform();
		act.click().perform();
	}
	
	public void selectPage_ClickMore() throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);

	}
	
	
	
	
	public void AcceptingConfirmationWhileUnpublishPage()
	{
	
	 Alert alert = oASelFW.driver.switchTo().alert();

     //Print alert is present
     System.out.println("Alert is present");

     //get the message which is present on pop-up
     String message = alert.getText();

     //print the pop-up message
     System.out.println(message);

     if(message.contains("Note: Unpublish of page will unpublish all its child pages as well"))
     {
    	 //Click on OK button on pop-up
    	 alert.accept();

     }

	}
	
	
	
	public void Verifypagedetails_Title(String status) throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header/following::article/following::a/div")));
		List<WebElement> articles=oASelFW.driver.findElements(By.xpath("//header/following::article/following::a/div"));
		
		int articlecount = articles.size();
		System.out.println("list size is:"+articles.size());
		Thread.sleep(3000);
		
			List<WebElement> title=oASelFW.driver.findElements(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[1]"));
			int pagetitle = title.size();
			System.out.println("Page title count..."+pagetitle);
			for(int i=2;i<=pagetitle;i++)
			{
				String titleStatus=oASelFW.driver.findElement(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[1]")).getAttribute("title");
						
				System.out.println("Page Title Status--"+titleStatus);
				if(titleStatus.contains(status))
				{
					oASelFW.effecta("sendReport","Validate the page title status","Page Title Satus is displayed as expected: "+titleStatus,"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validate the page title status","Page Title Satus is not displayed as expected: "+titleStatus,"Fail");
				}
			}
		
		
	}
	
	public void Verifypagedetails_modified() throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header/following::article/following::a/div")));
		List<WebElement> articles=oASelFW.driver.findElements(By.xpath("//header/following::article/following::a/div"));
		
		int articlecount = articles.size();
		System.out.println("list size is:"+articles.size());
		Thread.sleep(3000);
		
			List<WebElement> modified=oASelFW.driver.findElements(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[2]"));
			int pagetitle = modified.size();
			System.out.println("Page modified count..."+pagetitle);
			for(int i=1;i<=pagetitle;i++)
			{
				String modifiedstatus=oASelFW.driver.findElement(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[2]/span")).getText();
						
				System.out.println("Page Title Status--"+modifiedstatus);
				if(!modifiedstatus.isEmpty())
				{
					oASelFW.effecta("sendReport","Validate the page modified status","Page modified Satus is displayed as expected: "+modifiedstatus,"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validate the page modified status","Page modified Satus is not displayed as expected: "+modifiedstatus,"Fail");
				}
			}
		
		
	}
	
	public void Verifypagedetails_PublishedStatus_WhenUnpublish(String status) throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header/following::article/following::a/div")));
		List<WebElement> articles=oASelFW.driver.findElements(By.xpath("//header/following::article/following::a/div"));
		
		int articlecount = articles.size();
		System.out.println("list size is:"+articles.size());
		Thread.sleep(3000);
		
			List<WebElement> modified=oASelFW.driver.findElements(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[3]"));
			int pagetitle = modified.size();
			System.out.println("Page title count..."+pagetitle);
			for(int i=1;i<=pagetitle;i++)
			{
				String publishedstatus=oASelFW.driver.findElement(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[3]")).getAttribute("title");
						
				System.out.println("Page Title Status--"+publishedstatus);
				if(publishedstatus.contains(status))
				{
					oASelFW.effecta("sendReport","Validate the page published column status when Unpublished","Page published column Satus is displayed as expected: "+publishedstatus,"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validate the page published column status when Unpublished","Page published column Satus is displayed as expected: "+publishedstatus,"Fail");
				}
			}
		
	}
	
	public void Verifypagedetails_PublishedStatus_WhenPublish(String status) throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header/following::article/following::a/div")));
		List<WebElement> articles=oASelFW.driver.findElements(By.xpath("//header/following::article/following::a/div"));
		
		int articlecount = articles.size();
		System.out.println("list size is:"+articles.size());
		Thread.sleep(3000);
		
			List<WebElement> modified=oASelFW.driver.findElements(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[3]"));
			int pagetitle = modified.size();
			System.out.println("Page title count..."+pagetitle);
			for(int i=1;i<=pagetitle;i++)
			{
				String publishedstatus=oASelFW.driver.findElement(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[3]")).getAttribute("title");
						
				System.out.println("Page Title Status--"+publishedstatus);
				if(publishedstatus.contains(status))
				{
					oASelFW.effecta("sendReport","Validate the page published column status when Publish","Page published column Satus is displayed as expected: "+publishedstatus,"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validate the page published column status when Publish","Page  published column Satus is not displayed as expected: "+publishedstatus,"Fail");
				}
			}
		
	}
	
	
	public void Verifypagedetails_PublishedStatus_WhenPreviewed(String status) throws InterruptedException
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header/following::article/following::a/div")));
		List<WebElement> articles=oASelFW.driver.findElements(By.xpath("//header/following::article/following::a/div"));
		
		int articlecount = articles.size();
		System.out.println("list size is:"+articles.size());
		Thread.sleep(3000);
		
			List<WebElement> modified=oASelFW.driver.findElements(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[4]"));
			int pagetitle = modified.size();
			System.out.println("Page title count..."+pagetitle);
			for(int i=1;i<=pagetitle;i++)
			{
				String previewstatus=oASelFW.driver.findElement(By.xpath("(//header/following::article/following::a/div/div)[1]/following::div/p[4]")).getAttribute("title");
						
				System.out.println("Page Title Status--"+previewstatus);
				if(previewstatus.contains(status))
				{
					oASelFW.effecta("sendReport","Validate the page previewed column status when preview","Page previewed column Satus is displayed as expected: "+previewstatus,"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validate the page previewed column status when preview","Page  previewed column Satus is not displayed as expected: "+previewstatus,"Fail");
				}
			}
		
	}
	
	
	
	
}
