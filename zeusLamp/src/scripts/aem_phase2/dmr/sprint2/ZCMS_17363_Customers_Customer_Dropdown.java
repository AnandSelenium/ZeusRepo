package scripts.aem_phase2.dmr.sprint2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.vmware.VMwareTechPaperSearchPage;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_17363_Customers_Customer_Dropdown
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Customers_BrowseStories_URL",oASelFW.instanceName));	
	}
	@Test
	public void ZCMS_17363_Customers_Customer_Dropdown() throws Exception
	{
		try{	

			VMwareTechPaperSearchPage vmwtechsearch   = new VMwareTechPaperSearchPage(oASelFW);
			//vmwtechsearch.verifyVMwareCustomerPage();
			
			vmwtechsearch.verifyVMwareCustomerPage_recordcount_totalrecords();
			
			vmwtechsearch.clickViewCustdropdown("View Customer Stories");
			
			vmwtechsearch.clickViewCustdropdown_value("By Customers");
			
			vmwtechsearch.clickViewCustdropdown("All");
			
			vmwtechsearch.clickViewCustdropdown_value("A New Zealand Government Department");
			Thread.sleep(8000);
			
			vmwtechsearch.verifyVMwareCustomerPage_recordcount_totalrecords();
			
			
			Thread.sleep(3000);
			//oASelFW.driver.close();
			
			
			
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