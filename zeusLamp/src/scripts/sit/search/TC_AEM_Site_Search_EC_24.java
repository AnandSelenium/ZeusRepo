package scripts.sit.search;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.vmware.VMwareSearchPage;

import com.arsin.ArsinSeleniumAPI;


public class TC_AEM_Site_Search_EC_24
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Support_Search",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try{	

			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			VMwareSearchPage vmwsearch   = new VMwareSearchPage(oASelFW);

			///Verifying Search Home Page
			vmwsearch.verifyVMwareSupportPage();

			//Searching with valid search item and validating search results
			vmwsearch.supportSearchComponent("vSphere");
			
			//Searching word to get suggestions and selecting from suggestions
			vmwsearch.specificSearchSuggestions("vmware","vmware vsphere");
			
			//Click on support 
			vmwsearch.clickSupport();
			
			//Verifying Category & Type sub section in Filter By section
			vmwsearch.selectCategoryTypeAndFilterNoResutls("vmware","Store","Web");

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