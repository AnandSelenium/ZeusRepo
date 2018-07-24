package scripts.uat.sprintregression.sprint5;

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

public class TC_ZCMS_3597_ReviewTranslatedContent_04 
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
	public void test() throws Exception
	{
		
		String pageName=null;
		try
		{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMProjectsPage aemProjectsObj         = new AEMProjectsPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
		
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//click on Sites
			aemHomeObj.clickSites();
			
			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();
			
			//fill required fields
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(15000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(10000);

			//Click on Oprn Page
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
		
			//Click on Drag Components here
			aemComponentsObj.ClickDragComponents();
			Thread.sleep(10000);
			
			//Verify Insert New Component drop-down
			aemComponentsObj.verifyInsertNewComponent();
			
			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Features");		
			Thread.sleep(10000);
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Features");
			Thread.sleep(10000);
			
			//Click on Container Level PDF in Feature List Container window
			aemComponentsObj.Click_FeatureListContainer_ContainerLevelPDF_Link();
			
			//Details
			aemComponentsObj.FeatureListContainerProperties("Link Label","Testqa");
			aemComponentsObj.FeatureListContainerProperties("Link Title","Testqa_Pdf");
			aemComponentsObj.FeatureListContainerProperties_LinkUrl("Link URL","/content/dam/digitalmarketing/vmware/en/pdf/analysis/socialcast/vmw-idc-marketscape-social-vendor-analysis.pdf");
			aemComponentsObj.FeatureListContainerProperties_SelectTargetWindow("New Window");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Click on Preview
			aemComponentsObj.Click_PreviewButton();
			
			//Verify Pdf title
			aemComponentsObj.VerifyFeatureListContainer_PdfLink("Testqa");
			
			//Click on Pdf link
			aemComponentsObj.Click_FeatureListContainer_PdfLink("Testqa");
			Thread.sleep(5000);
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			//Navigating to Editor Window
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win[1]);
			Thread.sleep(5000);
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			//Navigating to Home window
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			oASelFW.driver.navigate().refresh();
			
			//click on Reference
			aemstranlationObj.clickReferences();

			//selecting page
			aemstranlationObj.selectPage(pageName);

			//selecting language
			aemstranlationObj.clickLanguageCopy();

			//creating project
			aemstranlationObj.clickCreateAndTranslate();
			String translatedPage=aemstranlationObj.fillFieldsInCreateAndTranslate("French", "Create a new translation project");
			
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
			aemLoginObj.openURL("http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/fr/training/uat_qa/onlyAutoQA");
			
			//Verify Page is available in Translated Language folder
			aemSitesObj.verifyPageTitle_In_TranslatedLanguage(pageName,"French");
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
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
				AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
				aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();
				
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
