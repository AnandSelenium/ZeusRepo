package scripts.sit.translations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_Translation_L4Enterprise_AssetFrench{

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
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);

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
			aemSitesObj.clickOnRequiredSite("My VMware");
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
			Thread.sleep(8000);

			aemComponentObj.enterTextInput("Brief Text Card", "Components");
			aemComponentObj.dragAndDropComponents("Brief Text Card", "Components","");
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickTextComponent("Brief Text Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//fill fields in Brief Text Card
			aemstranlationObj.fillFieldsInBreifTextCard("New Window");
			Thread.sleep(10000);
		
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();

			//Translation
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickLanguageCopy();
			aemstranlationObj.clickCreateAndTranslate();
			String translatedPage=aemstranlationObj.fillFieldsInCreateAndTranslate("French", "Create a new translation project");

			//click project
			aemHomeObj.clickProjects();

			//verify projects page
		    aemProjectsObj.verifyProjectsPage("Projects");
			oASelFW.driver.navigate().refresh();

			//click on required translation page
			aemProjectsObj.ClickRequiredPage(translatedPage);
			
			//click translation job
			aemProjectsObj.Click_TranslationJob();

			//Adding Path
			aemstranlationObj.clickAdd_TranslationJob();
			Thread.sleep(3000);
			
			//Selecting Path
			aemstranlationObj.click_SelectPath_PopUP("Assets");
			aemstranlationObj.click_SelectPath("Digital Marketing");
			aemstranlationObj.click_SelectPath("VMWare");
			aemstranlationObj.click_SelectPath("French");
			aemstranlationObj.click_SelectPath("PDF");
			aemstranlationObj.click_SelectPath("management");
			aemstranlationObj.click_confirm();
			Thread.sleep(10000);
		
			//Selecting Path Data
			aemstranlationObj.selectAssets("VMware-IT-Business-Management-Suite-Datasheet.pdf");
			aemstranlationObj.selectAssets("vmware-it-benchmarking.pdf");
			aemstranlationObj.selectAssets("Assets Metadata");
			aemstranlationObj.selectAssets("Tags");

			//Deleting Path
			aemstranlationObj.click_delete();
			Thread.sleep(5000);
			
			//Verifying Deleted Path
			aemstranlationObj.verify_PathDeleted();
			
			//Navigating To Translation Loacale
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/fr/");
			
			
			aemstranlationObj.selectPage("My_VMware");
			aemComponentObj.clickLiveCopy();
			aemComponentObj.rolloutOps_modified("/fr/my-vmware");
			
			//navigating to vmware publish instance
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/fr/my-vmware/onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs1 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs1.get(1));
			System.out.println("window switched");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			
			//navigating to test 15 url
			oASelFW.driver.get("http://www-test15.vmware.com/fr/my-vmware/onlyAutoQA/"+pageName+".html");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			//LOGOUT
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
