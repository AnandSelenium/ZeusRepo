package scripts.sit2.vmworld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMSponsorsPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_VMworld_US_NonInterior_SponsorsPage {
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
	public void TC_VMworld_US_NonInterior_SponsorsPage() throws Exception
	{
		try
		{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp                 = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                       = new AEMCallForPage(oASelFW);
			AEMSponsorsPage aemSponsorPage			 = new AEMSponsorsPage(oASelFW);
			AEMAssetsPage aasp 					   	 = new AEMAssetsPage(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			String notificatioDevUrl = utility.getValuesFromPropertiesFile("constant", "Notifications_DevUrl");
			
			ArrayList<String> values=new ArrayList<String>();

			ArrayList<String> urls=new ArrayList<String>();
			
			//LOGIN
			aemLoginObj.login(userName,password);

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
			
			aemComponentsObj.enterTextInput("Sponsors Header", "Components");
			Thread.sleep(10000);
			
			aemComponentsObj.dragAndDropComponents("Sponsors Header", "Components","");
			Thread.sleep(5000);
		
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextComponent("Zeus");		

			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("sponsorheader");
			oASelFW.effecta("waitForPageToLoad");
			
			//Sponsor Header Text Title
			cfp.enterComponentDetails("Sponsor Container Heading","SPONSORSHIP - VMWORLD US");
			cfp.enterComponentDetails("Sponsor Level Heading","Sponsor Levels");
			String tabHeader[]={"Exhibitor","GoldLevel"};
			
			cfp.clickOnAddfieldAndEnterComponentDetails("Sponsors Tabs", tabHeader,tabHeader.length);
			cfp.clickOnDone();
			
			Thread.sleep(3000);
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.DoubleClickOnRequiredTabcontentComponent("sponsor-1");
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();
			Thread.sleep(8000);
			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Sponsor Logos (Manual approach)");
			
			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("sponsor-1/sponsorlogos");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
		
			//Enter details on Sponsors Window
			for(int i=1;i<=2;i++)
			{
				String logo[]= {"vmware-partner-demand-center.jpg","vmware-partner-demand-center.jpg"};
				String logoUrl[]= {"https://www.vmware.com"};
				String LogoAltText[]= {"Alt_Text1","Alt_Text2"};
				
				values.add(logo[i-1]);
				
				urls.add(logoUrl[0]);
				
				System.out.println("Array index: "+logo[i-1]);
				System.out.println("Multi Browser Array index: "+logoUrl[0]);
			
				//Click on Add field
				aemComponentsObj.ClickAddField();
				
	
				
				aemComponentsObj.clickOnTabPanelLinks("Assets");
				Thread.sleep(5000);
				
				aemComponentsObj.enterTextInput(logo[i-1], "Assets");
				Thread.sleep(5000);
				
				aemComponentsObj.dragAndDropComponents_MultiField("", "Assets","Logo",i);
				
				Thread.sleep(5000);
				
				aemComponentsObj.EnterMultiTextField_Browse("Logo URL",logoUrl[0],i);  //Logo Url
				
				aemComponentsObj.EnterMultiTextField("Logo Alt Text",LogoAltText[i-1],i);  //Logo Alt Text
				
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open Type","New Window",i);  //Select URL Open type
			
			}
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(8000);
			
			aemComponentsObj.DoubleClickOnRequiredTabcontentComponent("sponsor-2");
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();
			Thread.sleep(8000);
			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Sponsor Logos (Manual approach)");
			
			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("sponsor-2/sponsorlogos");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			//Enter details on Sponsors Window
			for(int i=1;i<=2;i++)
			{
				String logo[]= {"vmware-partner-demand-center.jpg","vmware-partner-demand-center.jpg"};
				String logoUrl[]= {"https://www.vmware.com"};
				String LogoAltText[]= {"Alt_Text1","Alt_Text2"};
				
				values.add(logo[i-1]);
				
				urls.add(logoUrl[0]);
				
				System.out.println("Array index: "+logo[i-1]);
				System.out.println("Multi Browser Array index: "+logoUrl[0]);
			
				//Click on Add field
				aemComponentsObj.ClickAddField();
				
	
				
				aemComponentsObj.clickOnTabPanelLinks("Assets");
				Thread.sleep(5000);
				
				aemComponentsObj.enterTextInput(logo[i-1], "Assets");
				Thread.sleep(5000);
				
				aemComponentsObj.dragAndDropComponents_MultiField("", "Assets","Logo",i);
				
				Thread.sleep(5000);
				
				aemComponentsObj.EnterMultiTextField_Browse("Logo URL",logoUrl[0],i);  //Logo Url
				
				aemComponentsObj.EnterMultiTextField("Logo Alt Text",LogoAltText[i-1],i);  //Logo Alt Text
				
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open Type","New Window",i);  //Select URL Open type
			
			}
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			
			
			
			//click on preview
			aemPageCreateObj.click_Preview();
			
			Thread.sleep(5000);
			String pageUrl_Preview=oASelFW.driver.getCurrentUrl();
			System.out.println("Page Url--"+pageUrl_Preview);
		
			
			//Replace Editor.html with content
			aemComponentsObj.modifyUrl();
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
			String logo[]= {"vmware-partner-demand-center.jpg","vmware-partner-demand-center.jpg"};
			String logoUrl[]= {"https://www.vmware.com"};
			String LogoAltText[]= {"Alt_Text1","Alt_Text2"};
			
			//Verify Sponsor Container Heading
			aemSponsorPage.VerifySponsorHeaderTitle("SPONSORSHIP - VMWORLD US");
			
			//Verify Rich Text Content
			aemSponsorPage.VerifySponsorContent("Zeus");
			
			//Verify Sponsor Level Heading
			aemSponsorPage.VerifySponsorLevelHeading("Sponsor Levels");
			
			//Verify tabHeader headings
			aemSponsorPage.VerifySponsorTabHeading(tabHeader,tabHeader.length);
			
			//Verify TabTitle section heading
			aemSponsorPage.VerifySponsorTabSectionHeading(tabHeader,tabHeader.length);
			
			//Click on Exhibitor
			aemSponsorPage.ClickSponsorHeading_InPreviewMode("Exhibitor");
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[0],"Exhibitor",1); 
			aemSponsorPage.verify_Sponsors_ListImages(logo[1],"Exhibitor",2); 
			
			
			//Click on GoldLevel
			aemSponsorPage.ClickSponsorHeading_InPreviewMode("GoldLevel");
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[0],"GoldLevel",1); 
			aemSponsorPage.verify_Sponsors_ListImages(logo[1],"GoldLevel",2);
			
			oASelFW.driver.get(pageUrl_Preview);
			
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
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
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
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			//Verify Sponsor Container Heading
			aemSponsorPage.VerifySponsorHeaderTitle_InPublishMode("SPONSORSHIP - VMWORLD US");
			
			//Verify Rich Text Content
			aemSponsorPage.VerifySponsorContent_InPublishMode("Zeus");
			
			//Verify Sponsor Level Heading
			aemSponsorPage.VerifySponsorLevelHeading_InPublishMode("Sponsor Levels");
			
			//Verify tabHeader headings
			aemSponsorPage.VerifySponsorTabHeading_InPublishMode(tabHeader,tabHeader.length);
			
			//Verify TabTitle section heading
			aemSponsorPage.VerifySponsorTabSectionHeading_InPublishMode(tabHeader,tabHeader.length);
			
			
			//Click on Exhibitor
			aemSponsorPage.ClickSponsorHeading_InPublishMode("Exhibitor");
			
			aemSponsorPage.verify_Sponsors_ListImages_InpublishMode(logo[0],"Exhibitor",1); 
			aemSponsorPage.verify_Sponsors_ListImages_InpublishMode(logo[1],"Exhibitor",2); 
			
		
			//Click on GoldLevel
			aemSponsorPage.ClickSponsorHeading_InPublishMode("GoldLevel");
			
			aemSponsorPage.verify_Sponsors_ListImages_InpublishMode(logo[0],"GoldLevel",1); 
			aemSponsorPage.verify_Sponsors_ListImages_InpublishMode(logo[1],"GoldLevel",2);
			
			
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			//oASelFW.driver.navigate().refresh();
			Thread.sleep(2000);
			
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
