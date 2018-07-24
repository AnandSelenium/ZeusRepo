package scripts.aem_phase2.dmr.sprint1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16932_Analyse_PageUnpublish_Copy{

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
	public void ZCMS_16932_Analyse_PageUnpublish() throws Exception
	{
		try{	
			
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp                = new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			AEMCustStoryPage aemCustStoryObj         = new AEMCustStoryPage(oASelFW);

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
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("My VMware");
			//aemSitesObj.clickOnRequiredSite("ZCMS16932");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("HomePage Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Done");

			//Switch to tab
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware");
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			Thread.sleep(25000);
			aemComponentsObj.clickLiveCopy();
			aemComponentObj.rolloutOps();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			aemCustStoryObj.vmMark_Click_ListView();
			Thread.sleep(5000);
			
			//aemComponentObj.clickListView_SelectAllPages();
			
			
			//Select List View
			//aemHomeObj.selectListView();
			//Thread.sleep(5000);
			
			aemSitesObj.selectAllPage();
			
			//Publish All Pages
			aemSitesObj.publishAll();
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemSitesObj.selectAllPage();
			
			aemSitesObj.selectPage_ClickMore();
			
			//Publish All Pages
			aemSitesObj.publishAll();
			
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			
			aemSitesObj.selectAllPage();
			
			
			aemSitesObj.selectPage_ClickMore();
			
			
			//Publish All Pages
			aemSitesObj.clickUnpublish();
			Thread.sleep(2000);
			aemSitesObj.AcceptingConfirmationWhileUnpublishPage();
			
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//Verify page details when Unpublished
			aemSitesObj.Verifypagedetails_Title("Page is a Live Copy");
			aemSitesObj.Verifypagedetails_modified();
			aemSitesObj.Verifypagedetails_PublishedStatus_WhenUnpublish("Not published");
			aemSitesObj.Verifypagedetails_PublishedStatus_WhenPreviewed("Not previewed");
				
			
			Thread.sleep(5000);
			
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
