package scripts.aem.sprint7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_5552_AuthoringKeyWordsAndDescription {
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
	public void TC_ZCMS_3601_TranslateAssetLinksFromEN_JP() throws Exception{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj          = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj  = new AEMPageCreation(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			AEMAssetsPage aasp                = new AEMAssetsPage(oASelFW);
			AEMComponentCreation aemComponentObj=new AEMComponentCreation(oASelFW);
		
			
			String userName= utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password= utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");


			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("US");
			
			aemSitesObj.clickOnRequiredSite("test");
			Thread.sleep(3000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");

			//SWITCH TO THE NEW WINDOW AFTER CLICK ON OPEN PAGE
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));

			//CLICK ON PREVIEW BUTTON
			Thread.sleep(10000);
			System.out.println("Switched to second window");
			aemHomeObj.PreviewButton();

			//CLICK ON PAGE INFORMATION
			aemComponentObj.ClickPageInformation();
			Thread.sleep(2000);
			System.out.println("After wait for Properties");
			aemComponentObj.click_OpenProperties();
			oASelFW.effecta("waitForPageToLoad");
		
			Thread.sleep(25000);
			
			//String[] keyWords={"Customerstories Size","Customerstories Status","VMmark Category","Customerstories Language"};
			String[] keyWords={"VMmark Category","Customerstories Size","Customer Status","Customerstories Language"};
			String keyWordsInput="VMmark Category,Customerstories Size,Customer Status,Customerstories Language";
			
			String description="VMworld is the global conference for virtualization and cloud computing.";
			
			//EDIT PROPERTIES AND GIVE TAGS AND DESCRIPTION
			aemComponentObj.editTagsAndDescription(keyWordsInput, description);
			Thread.sleep(3000);
			aemComponentObj.verifyKeyWordsAndDescriptionInPageSource(keyWordsInput, description);
			
			oASelFW.driver.close();
			Thread.sleep(2000);
			oASelFW.driver.switchTo().window(tabs.get(0));
			
			/*//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail")){
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
