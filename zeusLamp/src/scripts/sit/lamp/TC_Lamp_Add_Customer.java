package scripts.sit.lamp;

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

public class TC_Lamp_Add_Customer{

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

			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMClassicUIPage aemClassicObj = new AEMClassicUIPage(oASelFW);
			AEMCreateCustomerPage aemCreateCustObj=new AEMCreateCustomerPage(oASelFW);
			AEMEditCustomer aemEditCustObj = new AEMEditCustomer(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			//Navigating To Classic UI
			aemHomeObj.classicUI();
			
			//Click On Website
			aemClassicObj.click_website();
			
			//Click On Lamp
			aemClassicObj.click_mainFolder("lamp");
			
			//Navigating To Customer Creation Page
			aemClassicObj.click_mainFolder("customers");
			aemClassicObj.click_Tools();
			aemClassicObj.click_mainFolder("Default Page Scaffolding");
			aemClassicObj.click_mainFolder("Create Customer");
			aemClassicObj.DoubleClick_subFolder("Create Customer");
			
			//Verifying Customer Creation Page
			aemCreateCustObj.verifyCustomerCreatePage();
			
			//Validating Fields Present
			aemEditCustObj.validateEditCustDetails();
			
			//String customerName=aemCreateCustObj.createCustomer_Updated();
			String customerName=aemCreateCustObj.createCustomer1();
			System.out.println("customerName:"+customerName);
			
			//verify created customer
			//aemCreateCustObj.verifyCreatedcustomer(customerName);
			
			aemHomeObj.switchToDefaultWindow();
			
			oASelFW.driver.switchTo().defaultContent();

			//logout
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
