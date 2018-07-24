package scripts.uat.sprintregression.sprint8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_5746_VerifyHomePagePromoComponent_InPublish {

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
	public void ZCMS_5746_VerifyHomePagePromoComponent_InPublish() throws Exception{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMProjectsPage aemProjectsObj          = new AEMProjectsPage(oASelFW);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			AEMTranslation aemstranlationObj         = new AEMTranslation(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			
			UtilityMethods utility=new UtilityMethods(oASelFW);
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			String destinationLocator=oASelFW.getConstValFrmPropertyFile("destinationLocator");
			
			String sourceImage="slideHero-3.jpg";
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on Sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("HomePage Template");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("PAGE NAME:-"+pageName);
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);


			//Click on Drag Components here
			aemComponentsObj.ClickDragComponents();
			
			//Drag and Drop Component
			//aemComponentsObj.dragAndDropComponents("Home Page Hero Carousel","Components","");
			Thread.sleep(5000);

			//Verify Insert New Component dropdown
			aemComponentsObj.verifyInsertNewComponent();

			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("VMWare Home Page Promo");
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("homepagepromo");
			
			//Click on Left Column
			aemComponentObj.Click_requiredLink("Left Column");
			
			//Select Backround color
			aemComponentObj.SelectRequiredOption_Left_RightBackgroundColor("Background Color","Blue","Left");
			
			//Enter Title
			aemComponentObj.EnterTextField_Left_Right("Title","HomePage_LeftColumn","left");
			
			//Enter Body
			aemComponentObj.EnterTextArea_Left_Right("Body","Vmware Home Page Window","left");
			
			//Enter Link Title
			aemComponentObj.EnterTextField_Left_Right("CTA Label","Vmware Link Page Title","left");
			
			//Enter Link
			aemComponentObj.EnterTextField_Browse_Left_Right("CTA URL","https://www.vmware.com","left");
			
			//Select Click behaviour window
			aemComponentObj.SelectRequiredOption_Left_Right("Click Behaviour","New Window","left");
			
			
			//Click on Toggle Side Panel
			aemComponentsObj.ClickToggleSidePanel();
			Thread.sleep(5000);
			
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			Thread.sleep(8000);
			
			aemComponentsObj.enterTextInput("slideHero-3.jpg", "Assets");
			
			
			aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");
		
			
			
			
			//Click on Right Column
			aemComponentObj.Click_requiredLink("Right Column");
			
			//Select Backround color
			aemComponentObj.SelectRequiredOption_Left_RightBackgroundColor("Background Color","Green","Right");
			
			//Enter Title
			aemComponentObj.EnterTextField_Left_Right("Title","HomePage_RightCloumn","right");
			
			//Enter Body
			aemComponentObj.EnterTextArea_Left_Right("Body","Vmworld Home Page Window","right");
			
			//Enter Link Title
			aemComponentObj.EnterTextField_Left_Right("CTA Label","Vmworld Link Page Title","right");
			
			//Enter Link
			aemComponentObj.EnterTextField_Browse_Left_Right("CTA URL","/content/vmware/language-master-sites/en","right");
			
			//Select Click behaviour window
			aemComponentObj.SelectRequiredOption_Left_Right("Click Behaviour","Same Window","right");
			
			
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			
			
			//Verify Home Page Title for the left column
			//aemComponentObj.VerifyHomePagePromo_Title("HomePage_RightCloumn");
			
			//Verify Home Page Body for the left column
		//	aemComponentObj.VerifyHomePagePromo_Body("Vmware Home Page Window");
			
			//Verify Home Page Promo Link Title
			aemComponentObj.VerifyHomePagePromo_Link("Vmware Link Page Title");
			
			aemComponentObj.ClickHomePagePromo_Link("Vmware Link Page Title");
			
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(2));
			
			//Verify the External Link Behaviour for Left Column
			aemComponentObj.VerifyHomePagePromo_Link_ExternalBehaviour("https://www.vmware.com");
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			
			//Verify Home Page Title for the Right column
			//aemComponentObj.VerifyHomePagePromo_Title("HomePage_LeftColumn");
			
			//Verify Home Page Body for the Right column
			//aemComponentObj.VerifyHomePagePromo_Body("Vmworld Home Page Window");
			
			//Verify Home Page Promo Right Title
			aemComponentObj.VerifyHomePagePromo_Link("Vmworld Link Page Title");
			
			aemComponentObj.ClickHomePagePromo_Link("Vmworld Link Page Title");
			
			Thread.sleep(5000);
			
			
			//Verify the Internal  Link Behaviour for Right Column
			aemComponentObj.VerifyHomePagePromo_Link_InternalBehaviour("/content/vmware/language-master-sites/en/my-vmware/QAAutomationTest/TestHeroCarousel_1");
			
			Thread.sleep(5000);
			
			//oASelFW.driver.navigate().back();
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
				
			
			//Tranlslate the component Image into another language
			
			oASelFW.driver.navigate().refresh();
			
			//click on Reference
			aemstranlationObj.clickReferences();
			
			Thread.sleep(5000);

			//selecting page
			aemstranlationObj.selectPage(pageName);
			
			
			Thread.sleep(15000);

			//selecting language
			aemstranlationObj.clickLanguageCopy();

			//creating project
			aemstranlationObj.clickCreateAndTranslate();
			Thread.sleep(5000);
			String translatedPage=aemstranlationObj.fillFieldsInCreateAndTranslate("Japanese", "Create a new translation project");
			
			//Click on Projects in Home Page
			aemHomeObj.clickProjects();
			
			//verify projects page
			aemProjectsObj.verifyProjectsPage("Projects");
			oASelFW.driver.navigate().refresh();			
			
			//Click on Required page in Projects page
			aemProjectsObj.ClickRequiredPage(translatedPage);
			
			//Click on required Title Translation
			aemProjectsObj. ClickRequiredTitle_Translation(translatedPage);
			Thread.sleep(5000);
			
			//Click on Edit Button
			aemProjectsObj.ClickRequiredTitle_EditButton();
			
			//Click on Translation
			aemProjectsObj.ClickTranslation();
			
			//Select Translation Method
			aemProjectsObj.SelectTranslationMethod("Human Translation");
	
			//Select Translation Provider
			aemProjectsObj.SelectTranslationProvider("WorldServer");
			
			
			//Click on Done button to Submit
			aemProjectsObj.ClickDone();
			Thread.sleep(5000);
			
			//Click Back beside Translation
			aemProjectsObj.ClickBackIcon();
			
		
			//Click on Translation Job
			aemProjectsObj.Click_TranslationJob();
			Thread.sleep(5000);
			
			//selecting job
			aemProjectsObj.selectJob();
			
			//Click Back beside Translation
			aemProjectsObj.ClickBackIcon();
			
			//Click on Translation Job drop down
			aemProjectsObj.ClickTranslationJob_dropdown();
			
			//Select Start
			aemProjectsObj.ClickTranslationJob_dropdown_ClickStart();
			Thread.sleep(20000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(30000);
			
			aemLoginObj.openURL("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/ja/my-vmware/onlyAutoQA");
			
			
			
			
			//Verify Page is available in Translated Language folder
		//	aemSitesObj.verifyPageTitle_In_TranslatedLanguage(pageName,"Japanese");
			
			
			//Click Deselect button
			aemComponentObj.clickOnDeselect();
			
			
			
			aemComponentObj.clickSelectAndOpenPage(pageName);
			
			
			//aemSitesObj.clickOnRequiredPage_Open(pageName);
			
			
			Thread.sleep(5000);
			ArrayList<String> tabs1 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			
			oASelFW.driver.switchTo().window(tabs1.get(1));
			
			
			Thread.sleep(8000);
			
			
			aemComponentObj.modifyUrl();
			Thread.sleep(8000);
			
			
			//Verify Home Page Promo Link Title
			aemComponentObj.VerifyHomePagePromo_Link("Vmware Link Page Title");
			
			aemComponentObj.ClickHomePagePromo_Link("Vmware Link Page Title");
			
			Thread.sleep(8000);
			ArrayList<String> tabs2 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs2.get(2));
			
			Thread.sleep(5000);
			
			//Verify the External Link Behaviour for Left Column
			aemComponentObj.VerifyHomePagePromo_Link_ExternalBehaviour("https://www.vmware.com");
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tabs2.get(1));
			
			
			//Verify Home Page Title for the Right column
			//aemComponentObj.VerifyHomePagePromo_Title("HomePage_LeftColumn");
			
			//Verify Home Page Body for the Right column
			//aemComponentObj.VerifyHomePagePromo_Body("Vmworld Home Page Window");
			
			//Verify Home Page Promo Right Title
			aemComponentObj.VerifyHomePagePromo_Link("Vmworld Link Page Title");
			
			aemComponentObj.ClickHomePagePromo_Link("Vmworld Link Page Title");
			
			Thread.sleep(5000);
			
			
			//Verify the Internal  Link Behaviour for Right Column
			aemComponentObj.VerifyHomePagePromo_Link_InternalBehaviour("/content/vmware/language-master-sites/en");
			
			Thread.sleep(5000);
			
			//oASelFW.driver.navigate().back();
			
			oASelFW.driver.close();
			
			Thread.sleep(5000);
			 
			
			
			//Click on Page Information
			aemComponentsObj.ClickPageInformation();
			Thread.sleep(5000);
			
			//Click on Publish Page
			aemComponentsObj.ClickPublishPage("Publish Page");
			
			//Deselect Checkbox to publish
			//aemComponentsObj.Click_Publish_DefaultDesign_Checkbox();

			//Click on Publish button
			//aemComponentsObj.ClickPublishPage("Publish");
			Thread.sleep(3000);
			
			//Verify Page has been successfully published
			aemComponentsObj.VerifyPublishPage_MessageDisplayed();
			
			
			String authURL=aemPageCreateObj.getAuthURL();
			String publishedURL=aemPageCreateObj.formPublishedURL(authURL);
			System.out.println("publishedURL:"+publishedURL);
			oASelFW.driver.get(publishedURL);
			Thread.sleep(5000);

			System.out.println("Published Url---"+publishedURL);
		
			oASelFW.driver.close();
			
			// oASelFW.driver.switchTo().window(tabs2.get(0));
			 Thread.sleep(3000);
			//delete folder
				aasp.SelectAndDeleteFolder(pageName);
				Thread.sleep(5000);
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
