package scripts.uat.sprintregression.sprint11;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.aem.AEMTechPaperPage;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_9144_TPSearch{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("TPSearch_test15",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try
		{
			AEMTechPaperPage aemTpObj = new AEMTechPaperPage(oASelFW);
			
			//Verifying Search Home Page
			aemTpObj.verifyLocalizedSearchPage("Technical Papers");
			Thread.sleep(5000);
			aemTpObj.verifyLocalizedSearchPage_test15("BROWSE TECHNICAL PAPERS");
			Thread.sleep(5000);

			//Searching with invalid search item and validating search results
			aemTpObj.LocalizedspecificValidSearch_test15("BROWSE TECHNICAL PAPERS","vsphere");
			Thread.sleep(10000);
			
			//Verifying Category & Type sub section in Filter By section
			aemTpObj.verifyLocalizedCategoryTypeSubSection_test15("BROWSE TECHNICAL PAPERS","vsphere");
			

			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			if(tabs.size()>1)
			{
				AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
				
				oASelFW.driver.close();
				Thread.sleep(5000);
				
				String wins[]=oASelFW.effectaArray("getAllWindowNames");
				oASelFW.effecta("selectWindow",wins[0]);
				
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
