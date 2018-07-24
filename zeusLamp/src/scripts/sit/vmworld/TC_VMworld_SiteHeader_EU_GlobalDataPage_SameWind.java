package scripts.sit.vmworld;

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
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_VMworld_SiteHeader_EU_GlobalDataPage_SameWind {

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
	public void TC_VMworld_SiteHeader_EU_GlobalDataPage_SameWind() throws Exception{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMAssetsPage aemAssestObj=new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			String notificatioDevUrl = utility.getValuesFromPropertiesFile("constant", "Notifications_DevUrl");
			ArrayList<String> values=new ArrayList<String>();


			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on Sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on VMWorld
			aemSitesObj.clickOnRequiredSite("VMworld");

			aemSitesObj.clickOnRequiredSite("en");
			

            //CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("Europe");
			aemSitesObj.verifySitesPage("Europe");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("learning");
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");



			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			Thread.sleep(3000);

			//select page template
			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(6000);
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(6000);
			

			
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			samp.click_Edit();
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnToggleSidePanel();
			
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(15000);
			
			aemComponentsObj.enterTextInput("Site Header", "Components");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("Site Header", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			
			aemComponentsObj.ClickOnComponent("siteheader");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);

		

			
			aemComponentsObj.EnterTextField("Tools Label","DashBoard_Tool");  //Tools Label
			for(int i=1;i<=6;i++)
			{
				
				
				//Click on Add field
				aemComponentsObj.ClickAddField();
				String linkLabels[]={"Facebook","Twitter","LinkedIn","Youtube","VMware","VMworld"};
				String linkURls[]={"/content/vmworld/en"};
				
				aemComponentsObj.EnterMultiTextField("Link Label",linkLabels[i-1],i);
				aemComponentsObj.EnterMultiTextField_Browse("Link URL",linkURls[0],i);
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","Same Window",i);  //Select URL Open type
				aemComponentsObj.SelectMultiRequiredOption("Highlight link","Enable",i);  //Select URL Open type
			}
			
			//click on Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//click on Preview
			aemPageCreateObj.click_Preview();
			
			
			String linkURls1[]={"/content/vmworld/en"};
			//verifying added links
			String linkLabels1[]={"Facebook","Twitter","LinkedIn","Youtube","VMware","VMworld"};
			//aemComponentsObj.verifying_MultipleAddedcomponetValues(linkLabels1,"Site Header Links ",6);

			aemComponentsObj.click_SiteHeader_SameWind_InPreview(linkLabels1[0],linkURls1[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPreview(linkLabels1[1],linkURls1[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPreview(linkLabels1[2],linkURls1[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPreview(linkLabels1[3],linkURls1[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPreview(linkLabels1[4],linkURls1[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPreview(linkLabels1[5],linkURls1[0]);


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
			Thread.sleep(3000);

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
			Thread.sleep(5000);
			
			String linkURls1_PublishMode[]={"en"};
			
			aemComponentsObj.click_SiteHeader_SameWind_InPublishMode(linkLabels1[0],linkURls1_PublishMode[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPublishMode(linkLabels1[1],linkURls1_PublishMode[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPublishMode(linkLabels1[2],linkURls1_PublishMode[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPublishMode(linkLabels1[3],linkURls1_PublishMode[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPublishMode(linkLabels1[4],linkURls1_PublishMode[0]);
			aemComponentsObj.click_SiteHeader_SameWind_InPublishMode(linkLabels1[5],linkURls1_PublishMode[0]);
			
			
			
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			
			//delete folder
			aemAssestObj.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();

			Thread.sleep(3000);
			//logout
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
