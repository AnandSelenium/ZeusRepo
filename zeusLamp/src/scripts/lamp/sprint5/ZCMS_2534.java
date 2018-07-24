package scripts.lamp.sprint5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMClassicUIPage;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_2534{

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
			AEMCustStoryPage aemCustStoryObj       = new AEMCustStoryPage(oASelFW);
			AEMCreateCustomerPage aemCreateCustObj = new AEMCreateCustomerPage(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			
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
			
			//Verifying Create Customer Page
			aemCreateCustObj.verifyCustomerCreatePage();
			
			//Create Customer
			String customerName=aemCreateCustObj.createCustomer1();
			System.out.println("customerName :" + customerName);
			
			//Verify Created Customer
			//aemCreateCustObj.verifyCreatedcustomer(customerName);
			
			//Navigating To Parent Window
			oASelFW.driver.close();
			Thread.sleep(2000);
			
			//Selecting Window
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win[1]);
			
            //Clicking On Customer Story Creation Page
			aemClassicObj.click_mainFolder("Default Page Scaffolding");
			aemClassicObj.click_mainFolder("Create Customer Stories");			
			aemClassicObj.DoubleClick_subFolder("Create Customer Stories");
			
			//Filling Details
			String customerStory=aemCustStoryObj.createCustomerStory(customerName);
			System.out.println("customer story:"+customerStory);
			
			//Verify Created Customer Story
			//aemCustStoryObj.verifyCreatedcustomerStory(customerStory);
			
			//Navigating To Parent Window
			oASelFW.driver.close();
			Thread.sleep(2000);
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			
			//Searching The Required Story
			aemCustStoryObj.click_websitesImgae();
			aemCustStoryObj.Search(customerStory);
			Thread.sleep(5000);
			
			//Verifying The Search Result
			aemCustStoryObj.verifySearchResults_CustomerStory(customerStory);
			
		
			
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
