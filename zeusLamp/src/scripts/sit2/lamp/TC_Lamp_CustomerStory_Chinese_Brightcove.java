package scripts.sit2.lamp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import classes.aem.AEMClassicUIPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_Lamp_CustomerStory_Chinese_Brightcove{

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

			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			AEMClassicUIPage aemClassicObj    = new AEMClassicUIPage(oASelFW);
			AEMCustStoryPage aemCustStoryObj  = new AEMCustStoryPage(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			
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
			aemClassicObj.click_mainFolder("customer-stories");

			aemClassicObj.click_Tools();
			aemClassicObj.click_mainFolder("Default Page Scaffolding");
			Thread.sleep(4000);

			aemClassicObj.click_mainFolder("Create Customer Stories");
			aemClassicObj.DoubleClick_subFolder("Create Customer Stories");
			Thread.sleep(4000);
			aemCustStoryObj.verifyCreateCustomerStoryPage(); 
			
			String[] customerStory=aemCustStoryObj.CustomerStory_Sit("zh_cn","Brightcove","Chinese Simplified","07Q2_dr_solution.pdf");
			System.out.println("Customer Story"+customerStory[0]);
			
			aemCustStoryObj.verifyCreatedcustomerStory(customerStory[0]);
			Thread.sleep(5000);
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			
			oASelFW.effecta("selectWindow",win1[0]);
			
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
