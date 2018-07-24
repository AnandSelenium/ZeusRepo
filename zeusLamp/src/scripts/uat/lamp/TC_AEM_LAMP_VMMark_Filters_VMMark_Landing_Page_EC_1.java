package scripts.uat.lamp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.lampdatamigration.LampEvents;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_AEM_LAMP_VMMark_Filters_VMMark_Landing_Page_EC_1{

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
	public void test()
	{
		try{	

			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			LampEvents  lampEvents	                 = new LampEvents(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMCreateCustomerPage aemCreateCustObj = new AEMCreateCustomerPage(oASelFW);
			AEMCustStoryPage aemCustStoryObj       = new AEMCustStoryPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			String constName="QACustomerStory";
			int random=(int) (Math.random()*100000);
			String customerName=constName+random;
			System.out.println("CustomerName"+customerName);

	
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//click on required site name
			aemSitesObj.clickOnRequiredSiteTitle("Web Apps");
			aemSitesObj.verifySitesPage("Web Apps");
			aemSitesObj.clickOnRequiredSiteTitle("VMmark");
			aemSitesObj.verifySitesPage("VMmark");
			Thread.sleep(5000);
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			Thread.sleep(10000);
			//Filling Details
			
			String VMMark=aemCustStoryObj.createVMMark(customerName);
			System.out.println("vmmark:"+VMMark);
			
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			oASelFW.effecta("selectWindow",win1[0]);
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/web-apps/vmmark");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Click on Search
			aemSitesObj.ClickonSearch();
			Thread.sleep(5000);
			aemSitesObj.searchKeyword(VMMark);
			
			//Verifying The Search Result
			aemCustStoryObj.verifySearchResults_CustomerStory_H4(VMMark);
			
			
		
		
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
 