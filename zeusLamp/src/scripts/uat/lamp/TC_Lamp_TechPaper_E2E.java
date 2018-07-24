package scripts.uat.lamp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_Lamp_TechPaper_E2E{

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

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMPageCreation aemPageObj             = new AEMPageCreation(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
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
			aemSitesObj.clickOnRequiredSite("VMware Published Sites");
			aemSitesObj.clickOnRequiredSite("US");
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("Tech Paper Page");

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
			
			//clicking on edit page
			aemPageObj.click_EditPage();
			
			//clicking on edit tech paper page
			aemPageObj.edit_TechPage();
			
			//Enter Tech Paper Values
			aemComponentsObj.EnterTextField("Enter Tech Paper title", "Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			aemComponentsObj.EnterTextField("Enter Publisher Value", "VMware");
			aemComponentsObj.EnterTextFieldDate("Revision Date", "March 24, 2016");
			aemComponentsObj.EnterTextField_Browse("Asset Path", "http://www.vmware.com/files/pdf/techpaper/vmware-horizon-6-view-unified-communications-real-time-audio-video.pdf");
			aemComponentsObj.EnterTextArea("Description Text", "Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			Thread.sleep(5000);
			aemComponentsObj.EnterTextField_Categories("Related Categories");
			
			//Click on Save Button
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//Verifying Details
			aemComponentsObj.verifyTechPapersValues("Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			aemComponentsObj.verifyTechPapersValues("VMware");
			aemComponentsObj.verifyTechPapersValues("March");
			aemComponentsObj.verifyTechPapersValues("Download Pdf");
			aemComponentsObj.verifyTechPapersValues("Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			
			//clicking on edit page
			aemPageObj.click_EditPage();
			
			//clicking on edit tech paper page
			aemPageObj.edit_TechPage();
			
			//Enter Publisher
			aemComponentsObj.EnterTextField("Enter Publisher Value", "Prolifics");
			
			//Click on Save Button
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//Edited Tech Paper Details
			aemComponentsObj.verifyTechPapersValues("Prolifics");
	       
			//Navigating to Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			String url_onlyAutoQA="http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/us/training/uat_qa";
			oASelFW.driver.get(url_onlyAutoQA);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentsObj.rolloutOps_UAT("/us/training/uat_qa/onlyAutoQA");
			
			String url_VmwarePubSites="http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/us/training/uat_qa/onlyAutoQA";
			oASelFW.driver.get(url_VmwarePubSites);
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
			
			aemComponentsObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			
			url.UatUrl("us",pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Prolifics");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("March");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Download Pdf");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
		
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//logout
			aemHomeObj.AEMLogout();
			
			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
