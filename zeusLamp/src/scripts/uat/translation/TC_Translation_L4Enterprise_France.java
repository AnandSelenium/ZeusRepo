package scripts.uat.translation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.aem.WorldServer;
import classes.utilities.OpenURLs;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_Translation_L4Enterprise_France{

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
	public void LAMPTest() throws Exception
	{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMProjectsPage aemProjectsObj         = new AEMProjectsPage(oASelFW);
			OpenURLs aemUrl                        = new OpenURLs(oASelFW);
			WorldServer worldObj                   = new WorldServer(oASelFW); 
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj = new AEMPartnerLoginPage(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);


			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on sites
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
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMWare L4 Enterprise Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			aemComponentObj.clickOnToggleSidePanel();
			aemComponentObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);
			aemComponentObj.enterTextInput("Brief Text Card", "Components");
			aemComponentObj.dragAndDropComponents("Brief Text Card", "Components","");
			Thread.sleep(5000);
			aahp.clickTextComponent("Brief Text Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//fill fields in Brief Text Card
			aemstranlationObj.fillFieldsInBreifTextCard_UAT("New Window");
	
			//Click on Preview button
			aemHomeObj.PreviewButton();			
			Thread.sleep(5000);
			
			//Replace Editor.html with content
			aemPartnerLoginObj.modifyUrl();
			Thread.sleep(5000);
			
			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();

			//translation
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickLanguageCopy();
			aemstranlationObj.clickCreateAndTranslate();
			String translatedPage=aemstranlationObj.fillFieldsInCreateAndTranslate("French", "Create a new translation project");

			//click projects
			aemHomeObj.clickProjects();

			//verify projects page
			aemProjectsObj.verifyProjectsPage("Projects");
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on required translation page
			aemProjectsObj.ClickRequiredPage(translatedPage);

			//click translation job
			aemProjectsObj.Click_TranslationJob();

			//selecting job
			aemProjectsObj.selectJob();

			//navigating to translation job page
			aemProjectsObj.ClickBackIcon();

			//clicking translation job drop down
			aemProjectsObj.ClickTranslationJob_dropdown();

			//click start on translation job drop down
			aemProjectsObj.ClickTranslationJob_dropdown_ClickStart();
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();

			//Navigating to World Server 
			aemUrl.openUrl("World_Server", oASelFW.instanceName);

			//Login
			worldObj.login_world("pmera", "password");

			worldObj.clickProject(translatedPage);
			worldObj.translate_UAT(pageName);

			//navigating to translating window
			String windows1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",windows1[1]);
			String newName=	worldObj.edit_translate();
			System.out.println("Edited Name"+newName);

			//navigating to home window
			oASelFW.driver.close(); 
			oASelFW.effecta("selectWindow",windows1[0]);
			Thread.sleep(5000);

			//Click on aem preview
			worldObj.click_Preview();

			//navigating to aem preview window
			String wins1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins1[1]);

			//selecting aem preview
			worldObj.aemPreview();
			oASelFW.effecta("selectWindow",windows1[0]);
			Thread.sleep(5000);

			worldObj.click_translationButton("Complete...");
			String wins2[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("window index"+wins2);
			oASelFW.effecta("selectWindow",wins2[1]);
			worldObj.click_submit();

			//navigating to home window
			oASelFW.effecta("selectWindow",wins1[0]);
			Thread.sleep(5000);

			//navigating to aem homepage
			aemUrl.openUrl("AEM_URL", oASelFW.instanceName);
			Thread.sleep(10000);
			
			//Navigating To Translation Loacale
			oASelFW.driver.get("http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/fr/training/uat_qa/onlyAutoQA");

			//Verifying The Created Page 
			aemSitesObj.Verify_CreatedPage(pageName, newName);
			
			//navigating to rollout locale
			oASelFW.driver.get("http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/fr/training/uat_qa");
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentObj.clickLiveCopy();
			aemComponentObj.rolloutOps_UAT("/fr/training/uat_qa/onlyAutoQA");
			url.VmwarePublishPage("fr");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			url.UatUrl("fr",pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//Validation
			aemComponentObj.verifyHeading_UAT("Fusion_Pro");
			
			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			if(tabs.size()>1)
			{
				AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);

				oASelFW.driver.close();
				Thread.sleep(5000);

				String wins[]=oASelFW.effectaArray("getAllWindowNames");
				oASelFW.effecta("selectWindow",wins[0]);

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
