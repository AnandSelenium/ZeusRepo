package scripts.baseline.lamp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class LAMP_Customer_Stories_E2E{

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
			oASelFW.driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);

			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMCustStoryPage aemCustStoryObj         = new AEMCustStoryPage(oASelFW);
			AEMTranslation aemstranlationObj         = new AEMTranslation(oASelFW);
			
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
			aemSitesObj.clickOnRequiredSiteTitle("Customer Stories");
			aemSitesObj.verifySitesPage("Customer Stories");
			Thread.sleep(5000);
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			Thread.sleep(10000);
			//Filling Details
			
			String customerStory=aemCustStoryObj.createCustomerStory(customerName);
			System.out.println("customer story:"+customerStory);
			
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			oASelFW.effecta("selectWindow",win1[0]);
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/web-apps/customer-stories/2016");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			// Write publish operation for particular customer story
			
			
			//Click on Search
			aemSitesObj.ClickonSearch();
			Thread.sleep(5000);
			aemSitesObj.searchKeyword(customerStory);
			
			//Verifying The Search Result
			aemCustStoryObj.verifySearchResults_CustomerStory_H4(customerStory);
			
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/training/home/sit/lamp/Listing_CustomerStories.html");
			Thread.sleep(10000);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Click Preview
			aemPageCreateObj.click_Preview();
			
			aemPageCreateObj.clickPageNation();
			aemCustStoryObj.verifySearchResults_CustomerStoryAfterRollout(customerStory);
			
			aemstranlationObj.rollOutPage();
		
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
 