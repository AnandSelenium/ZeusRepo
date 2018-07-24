package scripts.aem_phase2.dmr.sprint1;

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

public class ZCMS_16240_ListviewUpdate{

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
	public void ZCMS_16240_ListviewUpdate()
	{
		try{	

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
			aemCustStoryObj.createVmMark_record_selectProperties("Total Cores","40");
			aemCustStoryObj.createVmMark_record_selectProperties("Version","2.0");
			aemCustStoryObj.createVmMark_record_CreateButton_Click();
			
			
			
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
			Thread.sleep(3000);
			aemCustStoryObj.vmMark_Click_UpdateListView();
			Thread.sleep(5000);
			aemCustStoryObj.vmMark_Click_ListViewConfigureColumns_icon();
			
			//aemCustStoryObj.VerifyListViewColumnvalues("Title",VMMark);
			
			aemCustStoryObj.vmMark_select_ListViewConfigureColumns("description");
			aemCustStoryObj.vmMark_select_ListViewConfigureColumns("category");
			aemCustStoryObj.vmMark_select_ListViewConfigureColumns("publishDate");
			aemCustStoryObj.vmMark_select_ListViewConfigureColumns("published");
			aemCustStoryObj.vmMark_select_ListViewConfigureColumns("previewed");
			
			aemCustStoryObj.vmMark_Click_ListViewConfigureColumns_Updatebutton();
			Thread.sleep(10000);
			aemSitesObj.searchKeyword(VMMark);
			Thread.sleep(10000);
			
			aemCustStoryObj.VerifyListViewColumnvalues("System Description","System Description value");
			
			aemCustStoryObj.VerifyListViewColumnvalues("Category","Performance Only");
			aemCustStoryObj.VerifyListViewColumnvalues("Publish Date","2016-07-04");
			
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
 