package scripts.aem.sprint8;


/**
 * @author avinash_ankireddy
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCategory;
import classes.aem.AEMClassicUIPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTaggingPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_2564_UploadPdf {

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
	public void ZCMS_2580() throws Exception{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			String username=oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password=oASelFW.getConstValFrmPropertyFile("Pwd_Girish");

			AEMAssetsPage aemAssestObj			   = new AEMAssetsPage(oASelFW);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			new AEMComponentCreation(oASelFW);
			new AEMAgendaHeaderPage(oASelFW);
			new AEMSitesPage(oASelFW);
			new AEMPageCreation(oASelFW);
			new AEMTaggingPage(oASelFW);
			new AEMCategory(oASelFW);
			new AEMClassicUIPage(oASelFW);
			new AEMCreateCustomerPage(oASelFW);
			new 		AEMCustStoryPage(oASelFW);

			//LOGIN
			aemLoginObj.login(username,password);
		
		
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/assets.html/content/dam/digitalmarketing/vmware/en/pdf/customers/myvmware");
			
			Thread.sleep(8000);
		
			aemHomeObj.clickOnUploadAssets();
			
			aemHomeObj.fileUpload(oASelFW.sAutomationPath+"Pdf_Image\\Automated_Web_Testing.pdf");

			aemHomeObj.clickOnUploadButton();
			
			
			//delete folder
			aemAssestObj.SelectAndDeleteFolder_01("Automated_Web_Testing");
			oASelFW.driver.navigate().refresh();

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

	@AfterClass()
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}

}

