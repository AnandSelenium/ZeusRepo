package scripts.baseline.vmware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMPageCreation;

import com.arsin.ArsinSeleniumAPI;


public class Vmware_ValidationOf404PageNotFound
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("Product_URL",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try{	

			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAgendaHeaderPage aahp			   = new AEMAgendaHeaderPage(oASelFW);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(30000);
			aemPageCreateObj.verifyElementPresent_Stage("Products");
				
			String newurl=aahp.getCurrentPageUrlAndAddRandomNumber();
			
			System.out.println("New URL"+newurl);
			
			oASelFW.driver.get(newurl);
			Thread.sleep(3000);

			aemPageCreateObj.verifyElementPresent_Stage("Page Not Found");
				
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}
	}
	
	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
