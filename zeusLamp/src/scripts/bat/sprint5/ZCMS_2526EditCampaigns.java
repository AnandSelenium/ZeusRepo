package scripts.bat.sprint5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMCategory;
import classes.aem.AEMClassicUIPage;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class ZCMS_2526EditCampaigns{

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
	public void LAMPTest()
	{
		try{	

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSiteObj                = new AEMSitesPage(oASelFW);
			AEMCategory aemSizeObj                 = new AEMCategory(oASelFW);
			AEMClassicUIPage aemClassicObj         = new AEMClassicUIPage(oASelFW);
			AEMCreateCustomerPage aemCreateCustObj = new AEMCreateCustomerPage(oASelFW);
			AEMCustStoryPage aemCustStoryObj       = new AEMCustStoryPage(oASelFW);
			WebDriverBackedSelenium selenium       = new WebDriverBackedSelenium(oASelFW.driver, oASelFW.getURL("AEM_URL",oASelFW.instanceName));
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
		
			String userName=utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password=utility.getValuesFromPropertiesFile("constant", "Password");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			aemSiteObj.clickOnRequiredSiteTitle("Tools");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Operations");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Tagging");	
			aemSizeObj.click_namespace("Customerstories Campaign");
			String campaignsCreated = aemSizeObj.createCampaigns();
			Thread.sleep(2000);
			
			
			
			aemSizeObj.click_back();
			Thread.sleep(2000);
			aemSizeObj.click_back();
			Thread.sleep(2000);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			//Navigating To Customer Page
			aemHomeObj.classicUI();
			
			//Click On Website
			aemClassicObj.click_website();
			
			//Click On Lamp
			aemClassicObj.click_mainFolder("lamp");
			
			//Click On Customers
			 aemClassicObj.click_mainFolder("customer-stories");
			
            aemClassicObj.click_Tools();
            aemClassicObj.click_mainFolder("Default Page Scaffolding");
            Thread.sleep(4000);

            aemClassicObj.click_mainFolder("Create Customer Stories");
			aemClassicObj.DoubleClick_subFolder("Create Customer Stories");
			  Thread.sleep(4000);
			  aemCustStoryObj.verifyCreateCustomerStoryPage();
			aemSizeObj.verify_size("Campaign",campaignsCreated, selenium);
			
			oASelFW.driver.close();
			Thread.sleep(2000);
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win[1]);
			
			
			//Navigating To Home Window
			oASelFW.driver.switchTo().defaultContent();
			
			//Logout
			aemHomeObj.AEMLogout();
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}

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
