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
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_3618_2Col{

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
	public void LAMPTest()
	{
		try{	

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMEditCustomer aemEditObj             = new AEMEditCustomer(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);

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

			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);

			//drag components
			aemComponentsObj.ClickDragComponents();

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Column Control");

			//double click on component to add fields
			aemComponentsObj.DoubleClickOnComponent("columncontrol");

			//Entering Details
			aemComponentsObj.columnControlDetails("2 columns(50%, 50%)");

			//Click on column control Drag Component
			aemComponentsObj.clickOnColControlDragComponent("par5");

			Thread.sleep(5000);

			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Htmltext");

			aemComponentsObj.DoubleClickOnComponent("htmltext");

			//details
			aemEditObj.colControl_details();

			//edit mode
			aemEditObj.verifyColControlEditMode();

			//publish page
			aemEditObj.click_publishPage();
			Thread.sleep(3000);
			
			//publish
			aemEditObj.click_publish();

			/*//Verify Page has been successfully published
			aemComponentsObj.VerifyPublishPage_MessageDisplayed();
			String authURL=aemPageCreateObj.getAuthURL();
			String publishedURL=aemPageCreateObj.formPublishedURL(authURL);
			System.out.println("publishedURL:"+publishedURL);

			oASelFW.driver.get(publishedURL);
			Thread.sleep(5000);*/

			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();

			//Logout
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
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
