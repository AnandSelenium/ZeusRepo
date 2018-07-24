package scripts.bat.sprint5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




import classes.aem.AEMCategory;
import classes.aem.AEMClassicUIPage;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;

import com.arsin.ArsinSeleniumAPI;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class ZCMS_2537AddSize{

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
			AEMCreateCustomerPage aemCreateCustObj =new AEMCreateCustomerPage(oASelFW);
			WebDriverBackedSelenium selenium       =new WebDriverBackedSelenium(oASelFW.driver, oASelFW.getURL("AEM_URL",oASelFW.instanceName));

			//LOGIN
			aemLoginObj.login("vmachavarapu", "Orion1234%");

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//Navigating To Customer Stories
			aemSiteObj.clickOnRequiredSiteTitle("Tools");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Operations");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Tagging");	

			//Click On Customer Stories
			aemSizeObj.click_namespace("Customerstories Size");

			//Creating Tag
			String tagCreated = aemSizeObj.createTag();
			Thread.sleep(2000);

			//Navigating To Home Page
			aemSizeObj.click_back();
			Thread.sleep(2000);
			aemSizeObj.click_back();
			Thread.sleep(2000);

			//Verifying Home Page
			aemHomeObj.verifyHomePage();

			//Navigating To Customer Page
			aemHomeObj.classicUI();

			//Click On Website
			aemClassicObj.click_website();

			//Click On Lamp
			aemClassicObj.click_mainFolder("lamp");

			//Click On Customers
			aemClassicObj.click_mainFolder("customers");

			//Navigating To Create Customer Page
			aemClassicObj.click_Tools();
			aemClassicObj.click_mainFolder("Default Page Scaffolding");
			Thread.sleep(4000);
			aemClassicObj.click_mainFolder("Create Customer");
			aemClassicObj.DoubleClick_subFolder("Create Customer");
			Thread.sleep(4000);

			//Verifying Customer Page  
			aemCreateCustObj.verifyCustomerCreatePage();

			//Verifying Size
			aemSizeObj.verify_size("Size",tagCreated, selenium);

			//Navigating To Home Window
			oASelFW.driver.close();
			Thread.sleep(2000);
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win[1]);
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
