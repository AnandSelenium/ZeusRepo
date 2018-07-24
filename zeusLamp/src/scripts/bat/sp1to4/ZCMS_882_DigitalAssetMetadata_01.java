package scripts.bat.sp1to4;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_882_DigitalAssetMetadata_01 {
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
	public void LAMPTest() throws Exception{
		try{	

			AEMLoginPage aemLoginObj              = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj              = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj      = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentObj  = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                = new UtilityMethods(oASelFW);

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
			aemSitesObj.verifySitesPage("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.verifySitesPage("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.verifySitesPage("English");
			aemSitesObj.clickOnRequiredSite("My VMware");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");
			
			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name:"+pageName);
			
			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//Click on Open Page
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			System.out.println("Switched to second window");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			String authURL=aemPageCreateObj.getAuthURL();
			System.out.println("authURL"+authURL);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			
			//Click on Page Information
			aemComponentObj.ClickPageInformation();
			Thread.sleep(5000);
			System.out.println("After wait for Properties");
			aemComponentObj.click_OpenProperties();
			Thread.sleep(5000);
			aemPageCreateObj.edit_MetaDataProperties("Non Form");
			
			//Click on Page Information
			aemComponentObj.ClickPageInformation();
			Thread.sleep(5000);
			
			//Click on Publish Page
			aemComponentObj.ClickPublishPage("Publish Page");
		
			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(5000);
			
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
