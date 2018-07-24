package scripts.bat.sprint6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_4782_HOL_Feed_Render_Component {

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

			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);

	
			
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
			aemSitesObj.clickOnRequiredSite("US");
			aemSitesObj.verifySitesPage("US");

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


			//SWITCH TO NEW WINDOW AFTER CLICK ON OPEN PAGE 
			String parentwind_name=samp.switch_window_aftOpenPge1(pageName);
			System.out.println("Parent Window"+parentwind_name);
			
			//drag components
			aemComponentsObj.ClickDragComponents();

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("HOL Feed Render");
			Thread.sleep(5000);
			
			//Click on Preview Page
			aemPageCreateObj.click_Preview();
			
			//oASelFW.driver.switchTo().frame("ContentFrame");
			
			//Verfiy HOL Feed Render Component(DOUBT)
			//aemPageCreateObj.verify_Hol_Feed_RenderComponent();
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			 
			//LOGOUT
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
