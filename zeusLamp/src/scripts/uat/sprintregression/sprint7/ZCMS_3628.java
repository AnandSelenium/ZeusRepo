package scripts.uat.sprintregression.sprint7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3628 {
	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_URL",oASelFW.instanceName));	
	}
	@Test
	public void TC_ZCMS_3798_SiteHeader_SiteLinks_USInteriorpageWithNo_CarouselTemplate() throws Exception
	{
		try
		{	
			
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp                 = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                       = new AEMCallForPage(oASelFW);
			AEMAssetsPage aasp 					   	 = new AEMAssetsPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			aemSitesObj.clickOnRequiredSite("US");
			
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSite("VMworld_2016");
			
			//aemSitesObj.clickOnRequiredSite("Automation");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			Thread.sleep(5000);
			

			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(5000);
			
			//Navigating To New Window
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
		
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Call For Papers");
			
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextComponent("Zeus");		

			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("callforpapers");
			oASelFW.effecta("waitForPageToLoad");
			
			//Call For Paper Component
			cfp.enterComponentDetails("Enter Header","CALL FOR PAPERS IS NOW CLOSED");
			cfp.enterComponentDetails("Call to action Link Text","Closed For 2015");
			cfp.enterComponentPath("Call to action link","https://www.vmware.com");
			cfp.selectWindow("Select Call to action URL Open type","New Window");
			String tabHeader[]={"CFP Tab Header 1","CFP Tab Header 2","CFP Tab Header 3","CFP Tab Header 4"};
			cfp.clickOnAddfieldAndEnterComponentDetails("CFP Tabs", tabHeader,tabHeader.length);
			cfp.clickOnDone();
			
			
			//Heading-1
			cfp.headerCfp("cfp-1");		
			cfp.enterComponentDetails("Title","CREATING EFFECTIVE TITLES FOR SUBMISSION");		
			cfp.selectWindow("Select Number of Columns","1 column(100%)");		
			cfp.clickOnDone();
			cfp.clickOnCFPDragComponent("cfp-1", "par2");
			Thread.sleep(10000);
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Call For Papers");
			Thread.sleep(5000);
			cfp.click_multipleRichTextComponent("cfp-1", "par2");
			aahp.clickOnEdit("Edit");
			cfp.click_screenSize("fullscreen#start");
			cfp.insertTextInRichTextComponentWhenMaxmized("Rich Text Component");
			cfp.click_screenSize("fullscreen#finish");
			cfp.click_screenSize("control#save");
			Thread.sleep(10000);
			
			//click on preview
			aemPageCreateObj.click_Preview();
			String authURL=cfp.getAuthURL();
			String publishedURL=cfp.formPublishedURL(authURL);
			System.out.println("publishedURL:"+publishedURL);

			oASelFW.driver.get(publishedURL);
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();		
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//Verify Heading
			cfp.VerifySponsorHeaderTitle("CALL FOR PAPERS IS NOW CLOSED");
			
			//Verifying Rich Text
			cfp.VerifySponsorContent("Zeus");
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			
			/*//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}
		}
		catch (Exception e)
		{
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			if(tabs.size()>1)
			{
				Thread.sleep(5000);
				oASelFW.driver.close();
			/*	AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
				aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();
				*/
				Thread.sleep(5000);
				String wins[]=oASelFW.effectaArray("getAllWindowNames");
				oASelFW.effecta("selectWindow",wins[0]);
				AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
				//logout
				aemHomeObj.AEMLogout();	
				
			}
			else
			{
				
				AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
				aemHomeObj.AEMLogout();
				
			}
			
			
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}
	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
