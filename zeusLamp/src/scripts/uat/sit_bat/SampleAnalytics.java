package scripts.uat.sit_bat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMClassicUIPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class SampleAnalytics{

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
			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			AEMClassicUIPage aemClassicObj    = new AEMClassicUIPage(oASelFW);
			AEMCustStoryPage aemCustStoryObj  = new AEMCustStoryPage(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			
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

			//click on required site name//
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("My VMware");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			aemSitesObj.clickOnRequiredSite("QAAutoTest41751");
			aemSitesObj.clickOnRequiredSite("QAAutoTest123432");
			aemSitesObj.mouseHoverOnLinkAndOpenPage("QAAutoTest4546821");
			Thread.sleep(15000);
			
	
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			//Switch to tab
			Thread.sleep(15000);
			
			
			//Click on Page Information
			aemComponentsObj.ClickPageInformation();
			Thread.sleep(5000);
			
			//Click on Start Workflow
			aemComponentsObj.ClickPublishPage("Open Properties");
			Thread.sleep(3000);
			Thread.sleep(15000);
			Thread.sleep(15000);

			
			aemComponentsObj.analyticsMetaDataSelection("Page Content Type","form");
			aemComponentsObj.analyticsMetaDataSelection("Journey Stage","awareness");
			aemComponentsObj.analyticsMetaDataSelection("Internal Engagement Channel","eval");
			aemComponentsObj.analyticsMetaDataSelection("Score","3");
			aemComponentsObj.analyticsMetaDataSelection("Personas","application-developer");
			aemComponentsObj.analyticsMetaDataSelection("Entitlement Type","partner");
			aemComponentsObj.analyticsMetaDataSelection("Form Type","hols");
			
			aemComponentsObj.analyticsMetaDataInput("Page Category", "Page Category");
			aemComponentsObj.analyticsMetaDataInput("Page Sub Category", "Page Sub Category");
			aemComponentsObj.analyticsMetaDataInput("Page Sub Sub Category", "Page Sub Sub Category");
			aemComponentsObj.analyticsMetaDataInput("Page Title/AEM Pagename", "Page Title/AEM Pagename");
			aemComponentsObj.analyticsMetaDataInput("Page Detail", "Page Detail");
			aemComponentsObj.analyticsMetaDataInput("Page Sub Detail", "Page Sub Detail");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentObj.rolloutOps();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA/QAAutoTest41751/QAAutoTest123432");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			/*aemSitesObj.clickOnRequiredSite("QAAutoTest41751");
			aemSitesObj.clickOnRequiredSite("QAAutoTest123432");*/
			aemstranlationObj.selectPage("QAAutoTest4546821");
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(15000);
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
				
			
			aemComponentsObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			
			
			
			oASelFW.driver.get("http://www-test15.vmware.com/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA/QAAutoTest4546821.html");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
 