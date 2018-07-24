package scripts.baseline.vmware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMNewsAndEventsPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class Vmware_VerifingTargetingOption {

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		TimeUnit.SECONDS.sleep(10);

		oASelFW.startSelenium(oASelFW.getURL("AEM_URL",oASelFW.instanceName));	
	}
	@Test
	public void test() throws Exception{
		try
		{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(340, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			UtilityMethods utility					 = new UtilityMethods(oASelFW);
			AEMNewsAndEventsPage aem                 = new AEMNewsAndEventsPage(oASelFW);
			AEMTranslation aemstranlationObj         = new AEMTranslation(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

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
			Thread.sleep(10000);
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			Thread.sleep(10000);
			aemSitesObj.clickOnRequiredSite("English");
			Thread.sleep(10000);
			aemSitesObj.clickOnRequiredSite("My VMware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

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
			Thread.sleep(30000);
			
			//Click Preview
			aemPageCreateObj.click_Preview();
			
			aem.validatingTargettingButton();
			
			///navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			//logout
			aemHomeObj.AEMLogout();
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}
	}
	
	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
