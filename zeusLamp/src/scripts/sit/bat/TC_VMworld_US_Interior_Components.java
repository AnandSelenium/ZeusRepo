package scripts.sit.bat;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_VMworld_US_Interior_Components{

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
	public void TC_VMworld_US_Interior_Components() throws Exception
	{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMEditCustomer aemEditObj             = new AEMEditCustomer(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			String notificatioDevUrl = utility.getValuesFromPropertiesFile("constant", "Notifications_DevUrl");
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			Thread.sleep(4000);
			/*oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/test1/onlyAutoQA/QAAutoTest86206.html");
			
			Thread.sleep(4000);*/
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
			
		
		
			//**********************************************  Column Control  Starts ****************************************************
			aemComponentsObj.enterTextInput("Column Control", "Components");
			
			aemComponentsObj.dragAndDropComponents("Column Control", "Components","");
			Thread.sleep(5000);
			
			aemComponentsObj.ClickOnComponent("columncontrol");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);
			
			//Entering Details
			aemComponentsObj.columnControlEnterDetails("3 Column","3 columns(33%, 33%, 33%)");
			
		
			Thread.sleep(5000);
			
			//Click on column control Drag Component
			aemComponentsObj.clickOnColControlDragComponent("field1");
			
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Image/Video");
			Thread.sleep(5000);
			
			aemComponentsObj.ClickOnComponent("video");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);
			
			aemComponentsObj.EnterTextField("Title","ImageVideoTitle");
			
			
			aemComponentsObj.EnterTextField("Video URL","https://www.vmware.com");
			
			aemComponentsObj.EnterTextField("Alt Text","Image Alt Text");
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.enterTextInput("slideHero-3.jpg", "Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("", "Assets","Image");
			
			Thread.sleep(5000);
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			
		
			
			
			
			//**********************************************  Column Control  Ends ****************************************************
			
			
			//***************************************** Rich Text Starts ****************************************************************
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(15000);
			aemComponentsObj.enterTextInput("Rich Text Component", "Components");
			
			aemComponentsObj.dragAndDropComponents("Rich Text Component", "Components","");
			Thread.sleep(5000);
			
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
	
			//Enter Text when maximized the screen 
			aahp.insertTextInRichTextComponentValue("Test");
			Thread.sleep(5000);
			
			//***************************************** Rich Text Ends ****************************************************************
			

			//***************************************** Hol Feed Render Component Starts ****************************************************************
			
			aemComponentsObj.enterTextInput("HOL Feed Render", "Components");
			
			aemComponentsObj.dragAndDropComponents("HOL Feed Render", "Components","");
			Thread.sleep(15000);
			
			
			
			//***************************************** Hol Feed Render Component Starts ****************************************************************

			//***************************************** Tab Component Starts ****************************************************************
			
			aemComponentsObj.enterTextInput("Tab Content Component", "Components");
			
			aemComponentsObj.dragAndDropComponents("Tab Content Component", "Components","");
			Thread.sleep(5000);
			
			
			aahp.clickOnRichTextComponent("Tab Content Component");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);
			
			
			Thread.sleep(10000);

			String Tabtitles[]={"Title1","Title2"};
			String Tabcontents[]={"Tab_Content1","Tab_Content2"};
			

			for(int i=1;i<=2;i++)
			{
				//Click on Add field
				aemComponentsObj.ClickAddField();


				aemComponentsObj.EnterMultiTextField("Tab Title",Tabtitles[i-1],i);

				//aemComponentsObj.EnterMultiTextField_Browse("",Tabcontents[i-1],i);
				aemComponentsObj.EnterMultiTextField("Tab Content Title",Tabcontents[i-1],i);
			}


			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			String[] url={"http://aem-test-auth-1.vmware.com:8080","www.google.com"};
			String[] title={"Internal","External"};


			
			
			//Double click on Tab1 - Drag Components
			aemComponentsObj.DoubleClickonTabComponent_DragComponent("par-tab-title1");
			
			Thread.sleep(5000);
			
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Rich Text Component");
			Thread.sleep(5000);
			
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(15000);
			
			samp.click_Edit();
			Thread.sleep(8000);
			
			//aahp.clickOnRichTextComponent("Rich Text Component");
			aahp.clickOnTab_RichTextComponent("par-tab-title1/richtext");
			
			Thread.sleep(5000);
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
			Thread.sleep(15000);
			
			aahp.insertTextInRichTextTabComponentValue("Test1");

			Thread.sleep(10000);
			
			
			//Click on Full Screen icon
			cfp.click_screenSize("fullscreen#start");
			Thread.sleep(10000);
			
			//Enter Text when maximized the screen 
			
          //  cfp.insertTextInRichTextComponentWhenMaxmized("Test1");
			//Enter Text when maximized the screen 
			
			
			//Thread.sleep(10000);
			
			//Select the Rich Text value and Click Style
			aemComponentsObj.SelectAllText_RobotKeys();
			
			Thread.sleep(5000);
			aemComponentsObj.SelectAllText_RobotKeys();
			
			Thread.sleep(5000);
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			Thread.sleep(5000);
			
			//Click Links Modify button
			cfp.click_RichTextButtons_ModifyLinksButton("links#modifylink");
			//cfp.click_RichTextButtons_LinksModify();
			
			
			
			//Enter Text in Input box
			aemComponentsObj.EnterTextUnderLinksButton("https://www.vmware.com");
			
			//Enter Title
			aemComponentsObj.EnterText_Title("https://www.vmware.com");
			
			
			
			//Click "Open in new page" checkbox
			//aemComponentsObj.OPenInNewPage_Checkbox();
			
			Thread.sleep(3000);
			
			//Click on Apply button
			aemComponentsObj.clickOnApply();
			
			Thread.sleep(5000);
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");
			
			
			Thread.sleep(5000);
			
			
			//click on preview
			aemPageCreateObj.click_Preview();
			Thread.sleep(3000);
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			
			aemComponentsObj.ClickTabComponent_Tab("tab-title2");
			
			Thread.sleep(5000);
			
			//aemPageCreateObj.click_EditPage();
			samp.click_Edit();
			Thread.sleep(8000);
			
			/*aemPageCreateObj.click_EditPage();
			Thread.sleep(8000);
			*/
		
			//Double click on Tab1 - Drag Components
			aemComponentsObj.DoubleClickonTabComponent_DragComponent("par-tab-title2");
			
			Thread.sleep(5000);
			
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Rich Text Component");
			Thread.sleep(5000);
			
			aahp.clickOnTab_RichTextComponent("par-tab-title2/richtext");
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
			
		
			Thread.sleep(5000);
			
			//Click on Full Screen icon
			cfp.click_screenSize("fullscreen#start");
			Thread.sleep(5000);
			
			//Enter Text when maximized the screen 
			cfp.insertTextInRichTextComponentWhenMaxmized("Test2");
			Thread.sleep(5000);
			//Select the Rich Text value and Click Style
			aemComponentsObj.SelectAllText_RobotKeys();
			
			Thread.sleep(5000);
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			Thread.sleep(8000);
				
			
			//Click Links Modify button
			cfp.click_RichTextButtons_ModifyLinksButton("links#modifylink");
			//cfp.click_RichTextButtons_LinksModify();
			
			
			
			//Enter Text in Input box
			aemComponentsObj.EnterTextUnderLinksButton("https://www.vmware.com");
			
			//Enter Title
			aemComponentsObj.EnterText_Title("https://www.vmware.com");
			
			
			
			//Click "Open in new page" checkbox
			aemComponentsObj.OPenInNewPage_Checkbox();
			
			Thread.sleep(3000);
			
			//Click on Apply button
			aemComponentsObj.clickOnApply();

			
			Thread.sleep(5000);
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");
			
			Thread.sleep(5000);
			
			
			
			//***************************************** Tab Component Ends ****************************************************************
			
			
			
			
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
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
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			//************************** Verify Column Control Image/Video Starts*****************************************
			
			//Verify Column Control title
			aemComponentsObj.VerifyColumnControlTitle_PublishMode("3 Column");
			
			aemComponentsObj.VerifyImageVideo_Title_PublishMode("ImageVideoTitle");
			
			//Verify Image
			aemComponentsObj.VerifyImage_PublishMode("slideHero-3.jpg");
			
			//************************** Verify Column Control Image/Video  Ends*****************************************
			
			//************************** Verify Rich Text Title Starts  ****************************************************
			//Verify Image
			aemComponentsObj.VerifyRichText_Publish_Value("Test");
			//************************** Verify Rich Text Title Ends****************************************************
			
			
			
			//************************** Verify Tab Component Details Starts****************************************************
			aemComponentsObj.ClickTabComponentValue("Title1");
			
			Thread.sleep(5000);
			
			//aemComponentsObj.VerifyTabComponentValue("Test1");
			
			aemComponentsObj.ClickTabComponentValue("Title2");
			
			Thread.sleep(5000);
			
			aemComponentsObj.VerifyTabComponentValue("Test2");
			
			//************************** Verify HOL Component Starts****************************************************
			Thread.sleep(5000);
			aemComponentsObj.VerifyHOLComonentValue();
			
			//************************** Verify HOL Component Ends****************************************************

			Thread.sleep(5000);
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			
			/*AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
			aasp.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();*/
			Thread.sleep(5000);
			//Logout
			aemHomeObj.AEMLogout();
			
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
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
