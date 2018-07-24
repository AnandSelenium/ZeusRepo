package scripts.aem_phase2.dmr.sprint1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMNewsAndEventsPage;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16628_Filters_EventLandingPage_US
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Events",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try{	


			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMNewsAndEventsPage aem=new AEMNewsAndEventsPage(oASelFW);
			oASelFW.driver.get("https://www-test15.vmware.com/us/company/customers.html");
			Thread.sleep(10000);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(60000);
			aem.clickOnCaret();
			aem.mouseOverAndClickOnButton();
			
			

		}
		catch (Exception e)
		{
						
			e.printStackTrace();
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}