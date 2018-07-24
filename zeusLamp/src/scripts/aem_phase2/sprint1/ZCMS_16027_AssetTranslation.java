package scripts.aem_phase2.sprint1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import classes.aem.WorldServer;
import classes.utilities.OpenURLs;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16027_AssetTranslation{

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

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on required site name
			aemHomeObj.clickAssets();
			aemSitesObj.clickOnRequiredSite("Digital Marketing");
			aemSitesObj.clickOnRequiredSite("VMWare");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("Videos");
			aemSitesObj.mouseHoverOnLinkAndOpenPropertyPage("Credit Card Statement");
			String[] tags=worldObj.getTags();
			System.out.println(Arrays.toString(tags));
			aemstranlationObj.ClickBack();
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("Credit Card Statement");
			aemstranlationObj.assetLanguageCopy();
			aemstranlationObj.clickCreate_Translate();
			aemstranlationObj.translationdetails_Dropdown("Translation Workflow","DAM Create and Translate Language Copy");
			aemstranlationObj.translationdetails_Dropdown("Translation Config","translationintegrationwithwslinguisticreview");
			aemstranlationObj.translationdetails_Dropdown("Credential Config","VMWareStagingTest");
			Thread.sleep(30000);
			aemstranlationObj.selectValue("Target Languages","de");
			aemstranlationObj.translationdetails_Dropdown("Project","Create a new translation project");
			String projectName = aemstranlationObj.translationdetails_text("Project Title");
			aemstranlationObj.translation_Workflow("Project Title",projectName);
			aemstranlationObj.translation_button();

			//click projects
			aemHomeObj.clickProjects();

			//verify projects page
			aemProjectsObj.verifyProjectsPage("Projects");
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on required translation page
			aemProjectsObj.ClickRequiredPage(projectName);

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

			worldObj.clickProject(projectName);
			worldObj.translate("CreditCardStatement");

			//navigating to translating window
			String windows1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",windows1[1]);
			worldObj.edit_translate_pdf(oASelFW.sAutomationPath+"bill.pdf");

			//navigating to home window
			oASelFW.driver.close(); 
			oASelFW.effecta("selectWindow",windows1[0]);
			
		
			worldObj.click_translationButton("Complete...");
			String wins2[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("window index"+wins2.length);
			oASelFW.effecta("selectWindow",wins2[1]);
			worldObj.click_submit();
			oASelFW.effecta("selectWindow",wins2[0]);
			Thread.sleep(5000);
			
			worldObj.translatedJob("CreditCardStatement");
			worldObj.click_translationButton("Complete...");
			String wins3[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("window index"+wins3.length);
			oASelFW.effecta("selectWindow",wins3[1]);
			aemstranlationObj.completeTask("FastTrack to VMware Review (no DTP)");
			oASelFW.effecta("selectWindow",wins3[0]);
			Thread.sleep(15000);
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			oASelFW.driver.navigate().refresh();
			
			worldObj.translatedJob("CreditCardStatement");
			worldObj.click_translationButton("Complete...");
			String wins4[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("window index"+wins4.length);
			oASelFW.effecta("selectWindow",wins4[1]);
			aemstranlationObj.completeTaskButton();
			oASelFW.effecta("selectWindow",wins4[0]);
			Thread.sleep(15000);
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			oASelFW.driver.navigate().refresh();
		
			worldObj.translatedJob("CreditCardStatement");
			worldObj.click_translationButton("Complete...");
			String wins5[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("window index"+wins5.length);
			oASelFW.effecta("selectWindow",wins5[1]);
			aemstranlationObj.completeTask("Complete Task(s)");
			oASelFW.effecta("selectWindow",wins5[0]);
			Thread.sleep(15000);
			
			worldObj.translatedJob("temp");
			worldObj.click_translationButton("Complete...");
			String wins6[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("window index"+wins6.length);
			oASelFW.effecta("selectWindow",wins6[1]);
			worldObj.click_submit();
			oASelFW.effecta("selectWindow",wins6[0]);
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/mnt/overlay/dam/gui/content/assets/metadataeditor.html/content/dam/digitalmarketing/vmware/en/videos/CreditCardStatement.pdf");
			Thread.sleep(10000);
			String url=aemSitesObj.getPageurl("de");
			oASelFW.driver.get(url);
			Thread.sleep(10000);
			worldObj.compareTags(tags);

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


	@AfterClass()
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
