package scripts.lamp.sprint5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;







import classes.aem.AEMClassicUIPage;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_2547{

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
	public void LAMPTest()
	{
		try{	

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMClassicUIPage aemClassicObj         = new AEMClassicUIPage(oASelFW);
			AEMEditCustomer aemEditCustObj         = new AEMEditCustomer(oASelFW);
			AEMCreateCustomerPage aemCreateCustObj = new AEMCreateCustomerPage(oASelFW);
			UtilityMethods utility            	   = new UtilityMethods(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			//Navigating To Customer Page
			aemHomeObj.classicUI();
			
			//Click On Website
			aemClassicObj.click_website();
			
			//Click On Lamp
			aemClassicObj.click_mainFolder("lamp");
			
			//Click On Customers
			aemClassicObj.click_mainFolder("customers");
			aemClassicObj.click_Tools();
			aemClassicObj.click_mainFolder("Default Page Scaffolding");
			aemClassicObj.click_mainFolder("Create Customer");
			aemClassicObj.DoubleClick_subFolder("Create Customer");
			
			//create customer
			String customerName=aemCreateCustObj.createCustomer1();
			
			//verify created customer
			//aemCreateCustObj.verifyCreatedcustomer(customerName);
			
			oASelFW.driver.close();
			Thread.sleep(2000);
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win[1]);
			
			//Searching Customer Details
			/*aemEditCustObj.Search(customerName);
			
			aemEditCustObj.clickProperties(customerName);
			
			//Editing Customer Details
			String updatedCustomerName=aemEditCustObj.editCustomer();
			
			//Searching Customer Details
			aemCreateCustObj.ReSearch(updatedCustomerName);
			*/
			//Verifying The Search Result
			//aemEditCustObj.verifySerchResults_Customer(updatedCustomerName);
			
			//Navigating To Home Window
			oASelFW.driver.switchTo().defaultContent();
			
			//Logout
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
