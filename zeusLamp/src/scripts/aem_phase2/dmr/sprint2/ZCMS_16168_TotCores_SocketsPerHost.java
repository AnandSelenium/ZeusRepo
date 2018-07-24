package scripts.aem_phase2.dmr.sprint2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
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

public class ZCMS_16168_TotCores_SocketsPerHost{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_Stage_URL",oASelFW.instanceName));	
	}
	@Test
	public void ZCMS_16168_TotCores_SocketsPerHost()
	{
		try{	

			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMCustStoryPage aemCustStoryObj         = new AEMCustStoryPage(oASelFW);
			AEMTranslation aemstranlationObj         = new AEMTranslation(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Naresh");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Naresh");
			String VMware_VMmark=utility.getValuesFromPropertiesFile("constant", "VMware_VMmark");
			
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
			
		
			String VMMark=aemCustStoryObj.createVmMark_record_Title(customerName);
			System.out.println("vmmark:"+VMMark);
			aemCustStoryObj.createVmMark_record_PublishDate("2016-07-04");
			aemCustStoryObj.createVmMark_record_AEMToggle();
			
			aemCustStoryObj.createVmMark_record_selectProperties("Category","Performance Only");
			aemCustStoryObj.createVmMark_record_selectProperties("Select Submitter","Lenovo");
			aemCustStoryObj.createVmMark_record_EnterText("System Description","System Description value");
			aemCustStoryObj.createVmMark_record_EnterText("Total Cores","40");
			aemCustStoryObj.createVmMark_record_selectProperties("Version","2.0");
			aemCustStoryObj.createVmMark_record_EnterText("Sockets per Host","2");
			aemCustStoryObj.createVmMark_record_CreateButton_Click();
			
			
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			oASelFW.effecta("selectWindow",win1[0]);
			Thread.sleep(5000);
			
			oASelFW.driver.get("http://aem-stage-auth-1.vmware.com:8080/sites.html/content/web-apps/vmmark");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Click on Search
			aemSitesObj.ClickonSearch();
			Thread.sleep(5000);
			aemSitesObj.searchKeyword(VMMark);
			
			//Verifying The Search Result
			//aemCustStoryObj.verifySearchResults_CustomerStory_H4(VMMark);
			Thread.sleep(5000);
			
			//Click on Select
			aemstranlationObj.clickSelect();
			
			aemSitesObj.clickOnVMmarkPageTitle(VMMark);
			
			/*//Publish Pages
			aemSitesObj.publishAll();
			
			Thread.sleep(5000);
			
			oASelFW.driver.get(VMware_VMmark);
			
			Thread.sleep(5000);
			
			aemCustStoryObj.clickOn_VMmark_ColumnsFilter();
			
			aemCustStoryObj.clickOn_VMmark_ColumnsFilter_value("totalcores");
			
			aemCustStoryObj.clickOn_VMmark_ColumnsFilter_ApplyButton();
			*/
			Thread.sleep(5000);
			
		
			//oASelFW.driver.navigate().back();
			//Thread.sleep(5000);
			
			
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
 