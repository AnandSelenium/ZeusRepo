package scripts.uat.sit_bat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.vmware.VMwareSearchPage;
import classes.vmware.VMwareTechPaperSearchPage;

import com.arsin.ArsinSeleniumAPI;


public class TC_SearchSupportResults
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Search4",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try{	

			
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			VMwareSearchPage vmwsearch   = new VMwareSearchPage(oASelFW);
			//Verifying Search Home Page
			vmwsearch.verifyVMwareSearchPage();

			//Searching with invalid search item and validating search results
			vmwsearch.specificValidSearch("vmware");
			
			//Searching word to get suggestions and selecting from suggestions
			vmwsearch.specificSearchSuggestions("vmware","vmware vsphere");
			
			//Click on support 
			vmwsearch.clickSupport();
			
			//Verifying Category & Type sub section in Filter By section
			vmwsearch.selectCategoryTypeAndFilter("vmware","Product Documentation","Web");
			
		
		}
		catch (Exception e)
		{
			
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

	@AfterClass
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}