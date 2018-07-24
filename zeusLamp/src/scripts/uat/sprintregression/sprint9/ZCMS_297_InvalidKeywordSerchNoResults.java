package scripts.uat.sprintregression.sprint9;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.vmware.VMwareSearchPage;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_297_InvalidKeywordSerchNoResults
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Search_Uat",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest()
	{
		try{	

			VMwareSearchPage vmwsearch   = new VMwareSearchPage(oASelFW);

			//Verifying Search Home Page
			vmwsearch.verifyVMwareSearchPage();

			Thread.sleep(10000);

			//Searching with invalid search item and validating search results
			vmwsearch.specificInvalidSearchNoResults("zeuswrasa");
			
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}