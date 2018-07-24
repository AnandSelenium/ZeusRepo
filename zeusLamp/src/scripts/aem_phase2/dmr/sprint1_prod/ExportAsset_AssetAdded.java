package scripts.aem_phase2.dmr.sprint1_prod;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.lampdatamigration.LampEvents;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ExportAsset_AssetAdded{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_Prod_URL",oASelFW.instanceName));	
	}
	@Test
	public void ExportAsset_AssetAdded()
	{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			LampEvents  lampEvents	                 = new LampEvents(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMCreateCustomerPage aemCreateCustObj = new AEMCreateCustomerPage(oASelFW);
			AEMCustStoryPage aemCustStoryObj       = new AEMCustStoryPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Prod");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Prod");
			
		
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//click on required site name
			aemSitesObj.clickOnRequiredSiteTitle("Tools");
			//aemSitesObj.verifySitesPage("Tools");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSiteTitle("Assets");
			
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSiteTitle("Reports");
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSiteTitle("Asset Reports");
			Thread.sleep(5000);
			aemSitesObj.clickOnAssetReport_Report();
			Thread.sleep(5000);
			
			aemComponentObj.AssetReport_SelectReportOption("Select Report","Asset Added");
			Thread.sleep(5000);
			//Click on Date Range
			aemComponentObj.clickAssetReport_DateRange("In The Last");
			Thread.sleep(5000);
			//Enter Start Date and time
			aemComponentObj.EnterAssetReport_DateRange_DateTime("Start Date","2016-07-26 00:00");
			
			
			//Enter End Date and time
			aemComponentObj.EnterAssetReport_DateRange_DateTime("End Date","2016-08-03 00:00");
			
			
			
			
			/*//Enter Keyword
			aemComponentObj.EnterTextField("Keyword","VMware");
			
			//Enter Path to search
			aemComponentObj.EnterTextField_Browse("Path","/content/dam/digitalmarketing/vmware");
			
			Thread.sleep(20000);*/
			
			//Click on Generate Report
			aemComponentObj.clickAssetReport_GenerateReport("Generate Report");
			Thread.sleep(20000);
			
			//Click on Customize Columns
			aemComponentObj.clickAssetReport_CustomizeColumns();
			Thread.sleep(10000);
			
			aemComponentObj.selectColumnListCheckbox("Title");
			
			aemComponentObj.selectColumnListCheckbox("Type");
			Thread.sleep(10000);
			//Click on Customize Columns Submit button
			aemComponentObj.clickAssetReport_CustomizeColumns_Submit();
			
			Thread.sleep(20000);
			
			
			//Click on Export to CSV button
			aemComponentObj.clickAssetReport_ExportToCSV("Export to CSV");
			Thread.sleep(40000);
			
			//logout
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
 