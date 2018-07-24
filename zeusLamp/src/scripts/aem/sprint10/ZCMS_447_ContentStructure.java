package scripts.aem.sprint10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPersonalization;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_447_ContentStructure{

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
			AEMPersonalization aemPerObj           = new AEMPersonalization(oASelFW);
			
			String username = oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password = oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			//LOGIN
			
			aemLoginObj.login(username, password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			//Navigating to different URL
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/mcmadmin#/content/dashboard");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			//click Campaign
			aemPerObj.ClickedHeading("Campaigns");
			
			//
			aemPerObj.clickNew("Campaigns");
			
			//Create Brand
			String pageBrand = aemPerObj.createPage("Brand");
			oASelFW.driver.navigate().refresh();
			Thread.sleep(000);
			
			//
			aemPerObj.ClickedHeading(pageBrand);
			
			//
			aemPerObj.clickNew("Campaigns");
			
			//Create Campaign
			String pageCampaign = aemPerObj.createPage("Campaign");
			System.out.println("Page Campaign"+pageCampaign);
			
			oASelFW.getURL("Personalization_URL",oASelFW.instanceName);
			
			
			
			
			
			
			
			
			
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
