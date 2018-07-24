package scripts.bat.sprint6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import classes.aem.AEMAssetsPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_3614_Create_SplashPageTemplate {

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

			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj          = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj  = new AEMPageCreation(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			AEMAssetsPage aasp                = new AEMAssetsPage(oASelFW);
			
			String userName= utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password= utility.getValuesFromPropertiesFile("constant", "Password");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			aemSitesObj.clickOnRequiredSite("Splash Page");
			aemSitesObj.verifySitesPage("Splash Page");

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("PageName"+pageName);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			//aemPageCreateObj.mouseover_open_template(pageName);
			
			//Click on Open Page
			aemPageCreateObj.ClickOpenPage("Open page");

			//SWITCH TO NEW WINDOW AFTER CLICK ON OPEN PAGE
			aemPageCreateObj.switch_window_aftOpenPge(pageName); 

			//delete folder
			aasp. SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();

			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
