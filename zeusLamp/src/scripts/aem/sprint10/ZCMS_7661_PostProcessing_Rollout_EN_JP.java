package scripts.aem.sprint10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.aem.LanguageMappers;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_7661_PostProcessing_Rollout_EN_JP {

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
	public void ZCMS_7661_PostProcessing_Rollout_EN_JP() throws Exception{
		try{	

			AEMLoginPage aemLoginObj                = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                  = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj        = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                  = new UtilityMethods(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			AEMProjectsPage aemProjectsObj          = new AEMProjectsPage(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			LanguageMappers langMapp = new LanguageMappers(oASelFW);
			AEMTranslation aemstranlationObj = new AEMTranslation(oASelFW);
		
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			String LanguageMapper_ur=utility.getValuesFromPropertiesFile("constant", "LanguageMapper_ur");
			

			//LOGIN
			aemLoginObj.login(userName,password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//Thread.sleep(8000);
			//click on Sites
			aemHomeObj.clickSites();
			
			//Thread.sleep(8000);
			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			//Thread.sleep(8000);
			
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			//Thread.sleep(8000);
			
			aemSitesObj.clickOnRequiredSite("English");
			
			aemSitesObj.clickOnRequiredSite("My VMware");
	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(15000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//Click on Oprn Page
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			

			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(8000);
			
			aemComponentsObj.enterTextInput("Full Width Content Card", "Components");
			
			aemComponentsObj.dragAndDropComponents("Full Width Content Card", "Components","");
			
			aahp.clickTextComponent("Full Width Content Card");
			
			aahp.clickOnTool("CONFIGURE");
			
			Thread.sleep(8000);
			
			//Fill the required Image Properties
			aemComponentsObj.ImageProperties_Horizontal("Title","AutoQA_Image_Title");//Title
			Thread.sleep(5000);
			
			aemComponentsObj.ImageProperties_Horizontal("CTA Label","CTA Title");//CTA Label
			Thread.sleep(5000);
			
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); //CTA Link
			
			
			
			
			//Click on Toggle Side Panel
			//aemComponentsObj.ClickToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Assets");
	
			
			aemComponentsObj.enterTextInput("bottom-banner.jpg", "Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			
			//Drage and drop Image to Image Asset
			//aemComponentsObj.dragAndDrop_Image_To_RequiredImageAsset("bottom-banner.jpg");
			Thread.sleep(5000);
			
			//Select Icon
			aemComponentsObj.SelectRequiredOption("Select Icon","Bar Chart");
			
			aemComponentsObj.ImageProperties_Horizontal("Brightcove Video ID","3973449953001");//Brightcove Video ID
			Thread.sleep(5000);
			
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(8000);
			
			
			String authURL=aemPageCreateObj.getAuthURL();
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
			//click on Reference
			
			aemstranlationObj.clickReferences();

			//selecting page
			aemstranlationObj.selectPage(pageName);
			
			Thread.sleep(8000);

			//selecting language
			aemstranlationObj.clickLanguageCopy();

			//creating project
			aemstranlationObj.clickCreateAndTranslate();
			Thread.sleep(5000);
			String translatedPage=aemstranlationObj.fillFieldsInCreateAndTranslate("Japanese", "Create a new translation project");
			
			Thread.sleep(10000);
			
			//aemLoginObj.openURL("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA/QAAutoTest86035.html")
			//aemLoginObj.openURL("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA")
			
			
			aemstranlationObj.clickDeselect();
			aemstranlationObj.clickReferences();
			Thread.sleep(5000);
			
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
			Thread.sleep(10000);
			
			
			
			aemLoginObj.openURL("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA");
			Thread.sleep(5000);
			
			//Verify Page is available in Translated Language folder
			//aemSitesObj.verifyPageTitle_In_TranslatedLanguage(pageName,"Japanese");QAAutoTest86035
			
			//################ Langauage Mappers###################################
			aemComponentsObj.OpenNewTab_RobotKeys();
			
			
			
		
			Thread.sleep(10000);
			
			ArrayList<String> tabs2 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			
			System.out.println(tabs2.size());
			oASelFW.driver.switchTo().window(tabs2.get(1));
		
			Thread.sleep(10000);
			
			oASelFW.driver.get(LanguageMapper_ur);
			Thread.sleep(8000);
			
			
			//Verify Language Mappers page 
			langMapp.VerifyTranslationReplacePage();
			
			//Select Translation Language
			langMapp.SelectTranslationLocale("Japan");
			
			Thread.sleep(10000);
			
			langMapp.ClickAdd();
			
			langMapp.EnterEnglishID("123");
			
			langMapp.EnterTargetLanguageID("459");
			
			langMapp.ClickAdd_LanguageReplace();
			
			
			Thread.sleep(5000);
			
			langMapp.ClickAdd();
			
			langMapp.EnterEnglishID("CTA Title");
			
			langMapp.EnterTargetLanguageID("CTA Title_JP");
			
			langMapp.ClickAdd_LanguageReplace();
			
			
			Thread.sleep(5000);
			
			langMapp.ClickAdd();
			
			langMapp.EnterEnglishID("https://www.vmware.com");
			
			langMapp.EnterTargetLanguageID("https://www.vmware.jp.com");
			
			langMapp.ClickAdd_LanguageReplace();
			
			

			Thread.sleep(5000);
			
			langMapp.ClickAdd();
			
			langMapp.EnterEnglishID("3973449953001");
			
			langMapp.EnterTargetLanguageID("3973449954321");
			
			langMapp.ClickAdd_LanguageReplace();
			
			Thread.sleep(10000);
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			//ArrayList<String> tabs2 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			
			System.out.println(tabs2.size());
			oASelFW.driver.switchTo().window(tabs2.get(0));
			aemLoginObj.openURL("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/ja");
			Thread.sleep(10000);
			
			aemstranlationObj.clickReferences();

			//selecting page
			aemstranlationObj.selectPage("My_VMware");
			
			Thread.sleep(8000);

			//Live copy
			aemstranlationObj.clickLiveCopy();
			
			//Click Page path
			aemstranlationObj.clickLiveCopyShortPath("/ja/my-vmware");
			
			//Click Synchronize button
			aemstranlationObj.clickLiveCopySynchronize();
			
			//Click Rollout
			aemstranlationObj.clickLiveCopyRollout();
			
			Thread.sleep(15000);
			
			//aemstranlationObj.clickReferences();
			aemstranlationObj.clickDeselect();
			//Thread.sleep(5000);
			
			//oASelFW.driver.navigate().refresh();
			Thread.sleep(10000);
			
			//click on Sites
			aemHomeObj.clickSites();
			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			
			aemSitesObj.clickOnRequiredSite("VMware Published Sites");
			
			//Click on Search
			aemSitesObj.ClickonSearch();
			
			//Enter Path--/content/vmware/vmware-published-sites/jp/my-vmware/onlyAutoQA
			aemSitesObj.SelectSearchDirectory("/content/vmware/vmware-published-sites/jp/my-vmware/onlyAutoQA");
			
		
			
		/*	//Enter Search keyword
			aemSitesObj.EnterKeywordAndSearchValue("Japan");
			
			Thread.sleep(10000);
			
			aemSitesObj.clickOnRequiredSite("Japan");  //Live Copy
			
			
			aemSitesObj.clickOnRequiredSite("My_VMware");
			
			
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");*/
			
			Thread.sleep(10000);
			
			aemSitesObj.mouseHoverOnLinkAndOpenPage(pageName);
			
			
			Thread.sleep(5000);
			
			
			ArrayList<String> tabs3 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			
			System.out.println(tabs3.size());
			oASelFW.driver.switchTo().window(tabs3.get(1));
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Replace Editor.html with content
			aemComponentsObj.modifyUrl();
			Thread.sleep(10000);
			
			
			/*oASelFW.driver.navigate().refresh();
			Thread.sleep(10000);*/
			
		
			
		
			aemstranlationObj.verifyRolloutPagedata("CTA Title_JP");
			Thread.sleep(5000);
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
			
			
			/*//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();*/
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
