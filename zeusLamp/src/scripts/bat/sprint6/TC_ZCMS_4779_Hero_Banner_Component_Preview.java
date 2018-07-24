package scripts.bat.sprint6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMComponentCreation;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_4779_Hero_Banner_Component_Preview
{

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
	public void TC_ZCMS_3601_TranslateAssetLinksFromEN_JP(){
		try{	

			AEMLoginPage aemLoginObj                = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                  = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj        = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                  = new UtilityMethods(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			AEMEditCustomer aemEditObj              = new AEMEditCustomer(oASelFW);

			
			String userName=utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password=utility.getValuesFromPropertiesFile("constant", "Password");
			
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
			aemSitesObj.clickOnRequiredSite("Splash Page");
			aemSitesObj.verifySitesPage("Splash Page");

			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("Europe");
			aemSitesObj.verifySitesPage("Europe");

			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to tab
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//drag components
			aemComponentsObj.ClickDragComponents();

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Hero Banner");

			//double click on component to add fields
			aemComponentsObj.DoubleClickOnComponent("herobanner");
			Thread.sleep(2000);

			//Enter banner details
			aemEditObj.enter_bannerDetails("US");

			//Enter Image Details of Banner
			samp.insert_Images_HeroBannerComponents();

			//Click ON Done 3
			aemPageCreateObj.click_PageHeader_tick();

			//Click Preview Button
			samp.click_preview();
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			//LOGOUT
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass()
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}
