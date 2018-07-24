package scripts.aem.sprint7;

import java.io.IOException;
import java.util.ArrayList;

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

public class ZCMS_3622_GoldLevel {
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

			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("US");
			
			aemSitesObj.clickOnRequiredSite("test");
			Thread.sleep(3000);
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
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(50000);
			
			//Navigating To New Window
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(80000);
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Sponsors (Automated approach)");
			
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextComponent("Zeus");		

			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("sponsors");
			oASelFW.effecta("waitForPageToLoad");
			
			//Sponsor Header Text Title
			cfp.enterComponentDetails("Sponsor Container Heading","Sponsor Container Heading");
			cfp.enterComponentDetails("Sponsor Level Heading","Sponsor Level Heading");
			cfp.selectWindow("Show sponsors content for","US Region");
			cfp.clickOnDone();
			
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
			
			//Verify Sponsor Container Heading
			cfp.VerifySponsorHeaderTitle("Sponsor Container Heading");
			
			//Verify Sponsor Level Heading
			cfp.VerifySponsorLevelHeading("Sponsor Level Heading");
			
			//Click sponsor level heading
			cfp.clicklevelHeading("Gold","CDW","https://published-prd.lanyonevents.com/published/vmworld2015/files/2879/CDW_Box_red.jpg");
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
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
