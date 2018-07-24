package scripts.aem_phase2.july29release;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMClassicUIPage;
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_16608_VMware_BulkDeploy_Publish_Preview_Page{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_UAT",oASelFW.instanceName));	
	}
	@Test
	public void test()
	{
		try{	

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSiteObj                = new AEMSitesPage(oASelFW);
			AEMClassicUIPage aemClassicObj         = new AEMClassicUIPage(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			String path="/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA";

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			aemSiteObj.clickOnRequiredSiteTitle("Tools");
			Thread.sleep(2000);
			aemSiteObj.clickOnRequiredSiteTitle("Bulk Deploy");
			Thread.sleep(2000);

			aemClassicObj.click_mainFolder("VMware Utility");
			Thread.sleep(2000);
			aemClassicObj.click_mainFolder("Bulk Deployment Manager");
			Thread.sleep(2000);
			
			aemSiteObj.clickNew("Bulk Deployment Manager");
			String pageName = aemSiteObj.createPage();
			System.out.println("Page Name"+pageName);
			aemSiteObj.openPage_SiteAdmin(pageName);

			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			Thread.sleep(5000);
			
			aemSiteObj.drop_downWorkflow("Deployment Type","cq:Page");
			aemSiteObj.workflowText("Select Artifacts Under",path);
			Thread.sleep(5000);
			aemSiteObj.WorkflowButton("Execute");
			Thread.sleep(5000);
			aemSiteObj.drop_downWorkflow2("Workflow Model","VMWare Publish To Preview");
	
			aemSiteObj.workflowText("Total Size","100");
			aemSiteObj.workflowText("Batch Size","10");
			aemSiteObj.workflowText("Batch Interval","10");
			aemSiteObj.workflowText("Batch Timeout","20");
			
			aemSiteObj.WorkflowButton("Start Bulk Workflow");	
			Thread.sleep(30000);
			Thread.sleep(20000);
			
			url.dispURL_Preview("123");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			
			//Logout
			//aemHomeObj.AEMLogout();

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
