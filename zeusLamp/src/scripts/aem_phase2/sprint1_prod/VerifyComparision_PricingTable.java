package scripts.aem_phase2.sprint1_prod;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import classes.aem.AEMHomePage;
import classes.vmware.VMwareTechPaperSearchPage;

import com.arsin.ArsinSeleniumAPI;


public class VerifyComparision_PricingTable
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_products_Vsphere",oASelFW.instanceName));	
	}
	@Test
	public void VerifyComparision_PricingTable() throws Exception
	{
		try{	

			VMwareTechPaperSearchPage vmwtechsearch   = new VMwareTechPaperSearchPage(oASelFW);

			oASelFW.driver.navigate().refresh();
			Thread.sleep(10000);
			//Verifying Vsphere page
			vmwtechsearch.verifyVMwareVspherePage();

			Thread.sleep(10000);
			
			vmwtechsearch.verifyVMwareVspherePricingsectionHeading();

			vmwtechsearch.verifyVMwareVspherePricingsectionTableheader("VMware vSphere and vSphere with Operations Management Editions","PRODUCT TITLE");
			
			vmwtechsearch.verifyVMwareVspherePricingsectionTableheader("VMware vSphere and vSphere with Operations Management Editions","License Price");
			vmwtechsearch.verifyVMwareVspherePricingsectionTableheader("VMware vSphere and vSphere with Operations Management Editions","1 Year Support & Subscription");
			
			vmwtechsearch.Verify_PricingComparisionBorders("Pricing","VMware vSphere and vSphere with Operations Management Editions","PRODUCT TITLE");
			
			vmwtechsearch.verifyVMwareVsphereComparisionsectionTableheader("License Entitlement");
			
			vmwtechsearch.verifyVMwareVsphereComparisionsectionTableheader("License Entitlement","vSphere Standard");
			vmwtechsearch.verifyVMwareVsphereComparisionsectionTableheader("License Entitlement","vSphere Enterprise Plus");
			vmwtechsearch.verifyVMwareVsphereComparisionsectionTableheader("License Entitlement","vSphere with Operations Management Enterprise Plus");
			
			vmwtechsearch.Verify_PricingComparisionBorders("Comparision","License Entitlement","vSphere with Operations Management Enterprise Plus");

			
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