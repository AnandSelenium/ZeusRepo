package scripts.aem_phase2.sprint1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMNewsAndEventsPage;
import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16628_Filters_Pagination_AssetDownload_US
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Customer",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try{	

		
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			oASelFW.driver.get("https://www-test15.vmware.com/us/company/customers.html");
			Thread.sleep(10000);
			AEMNewsAndEventsPage aem = new AEMNewsAndEventsPage(oASelFW);
			aem.clickOnCustomerButton();
			aem.mouseOverAndClickOnlink();
			aem.clickOnCustomerButton1();
			aem.mouseOverAndClickOnLink2();
			aem.clickPDFToDownload();
			aem.verifyPagenation();
			String url=aem.getPageurl();
			oASelFW.driver.get(url);
			Thread.sleep(10000);
			

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