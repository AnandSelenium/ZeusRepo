package scripts.sit2.vmworld;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;










import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_Vmworld_US_Interior_Splash {

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
	public void TC_Vmworld_US_Interior_Splash() throws Exception{
		
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj          = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj  = new AEMPageCreation(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			AEMAssetsPage aasp                = new AEMAssetsPage(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			String notificatioDevUrl = utility.getValuesFromPropertiesFile("constant", "Notifications_DevUrl");
			
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
			
			//Click on US
			aemSitesObj.clickOnRequiredSite("US");
			
			
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");

			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page");

			//click next after selecting template
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(6000);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Navigating To New Window
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			samp.click_Edit();
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnToggleSidePanel();
			
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(15000);
			
			aemComponentsObj.enterTextInput("VMWorld Splash Component", "Components");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("VMWorld Splash Component", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			
			aemComponentsObj.ClickOnComponent("vmsplash");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);
			
			//Thread.sleep(5000);


			//Click on Carousel link
			aemComponentsObj.Click_requiredLink("Carousel");

			//Click on Add field
			aemComponentsObj.ClickAddField();

			//Enter Alt Text
			aemComponentsObj.EnterTextField("Alt Text","Spalsh_AltText");

			//Save
			aemComponentsObj.ClickSaveIcon();

			Thread.sleep(8000);

			//Click on Preview button
			aemHomeObj.PreviewButton();
			
			Thread.sleep(10000);
			String pageUrl=oASelFW.driver.getCurrentUrl();
			System.out.println("Page Url--"+pageUrl);
		
			//Click on Page Information
			aemComponentsObj.ClickPageInformation();
			Thread.sleep(5000);
			
			//Click on Start Workflow
			aemComponentsObj.ClickPublishPage("Start Workflow");
			Thread.sleep(3000);
			
			//Select Work flow option
			aemComponentsObj.SelectWorkflowModelOption("VMWorld Pre Prod Deployment Workflow");
			Thread.sleep(3000);
			
			//Click on Start Workflow button
			aemComponentsObj.ClickStartWorkflowButton();
			
			//Verify Workflow Started Message
			aemComponentsObj.VerifyWorkflowStartedMessageDisplayed();
			Thread.sleep(3000);
			
			//Navigate to notifications url
			aemComponentsObj.modifyUrlWithNotifications();
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
			//Verify Notification  window
			aemComponentsObj.VerifyNotificationWindow();
			
			//Click required workflow check box
			aemComponentsObj.ClickRequiredNotificationsCheckbox(pageName,"VMWorld Pre Prod Deployment Workflow");
			Thread.sleep(10000);
			
			//Click on Complete
			aemComponentsObj.ClickNotificationComplete();
			Thread.sleep(10000);
			
			//Select  Workflow User
			aemComponentsObj.SelectWorkflowUser("VMworld test");
			Thread.sleep(5000);
			//Click on Complete
			aemComponentsObj.ClickWorkflowNotificationComplete();
			Thread.sleep(5000);
			oASelFW.driver.get(notificatioDevUrl);
			Thread.sleep(5000);
			String devUrl=oASelFW.driver.getCurrentUrl();
			System.out.println("Dev Url---"+devUrl);
			System.out.println("Page Url--"+pageUrl);
			
			//Navigate to Workflow Url--dev-doc3
			aemComponentsObj.modifyUrlWithNotifications(pageUrl, devUrl);
			Thread.sleep(10000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
			//Verify Author Banner Image Alt Text in Preview mode
			aemComponentsObj.verifyAuthorBannerImageAltText_PublishMode("Spalsh_AltText");

			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			
			
			/*aasp.SelectAndDeleteFolder(pageName);
			//oASelFW.driver.navigate().refresh();
*/			Thread.sleep(2000);
			//Logout
			aemHomeObj.AEMLogout();


			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}
		}
		catch (Exception e) {
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			if(tabs.size()>1)
			{
				Thread.sleep(5000);
				oASelFW.driver.close();
				/*AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
				aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();*/
				
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
