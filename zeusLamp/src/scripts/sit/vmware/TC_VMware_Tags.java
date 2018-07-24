package scripts.sit.vmware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMCategory;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTaggingPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_VMware_Tags{

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
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSiteObj                  = new AEMSitesPage(oASelFW);
			AEMCategory aemSizeObj                   = new AEMCategory(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMTaggingPage aemTagObj                 = new AEMTaggingPage(oASelFW);

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//Navigating To Tagging
			aemSiteObj.clickOnRequiredSiteTitle("Tools");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Operations");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Tagging");	
			
			//Click On Technical Paper Category
			aemSizeObj.click_namespace("Techpaper Category");
			Thread.sleep(2000);
			
			//Create Tag
			String tagCreated = aemTagObj.enter_tagDetails("Title", "tagtitle");
			System.out.println("Tag Created:-"+tagCreated);
			aemTagObj.click_Create();
			Thread.sleep(5000);
			oASelFW.effecta("waitForPageToLoad");
			
			//Verify Created Tag
			aemTagObj.verifyTagCreated(tagCreated);
			
			//Editing Created Tag
			aemTagObj.click_operations("Edit");
			String editTag = aemTagObj.edit_tagDetails("Title", "tagtitle");
			System.out.println("Tag Created:-"+editTag);			
			aemTagObj.click_Save();			
			aemTagObj.click_OK();
			
			//Verifying Tag Edited
			aemTagObj.click_namespace("Techpaper Category");
			Thread.sleep(5000);
			aemTagObj.verifyTagCreated(editTag);
			
			//Deleting Edited Tag
			aemTagObj.delete_Tag1(editTag);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(2000);
			
			//Verifying Deleted Tag
			aemTagObj.click_namespace("Techpaper Category");
			Thread.sleep(5000);
			aemTagObj.verifydeletedTag(editTag);
		
			//Logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}

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
