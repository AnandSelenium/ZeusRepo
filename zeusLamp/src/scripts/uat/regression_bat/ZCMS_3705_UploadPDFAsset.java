package scripts.uat.regression_bat;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3705_UploadPDFAsset {
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
	public void LAMPTest() throws Exception
	{
		try
		{	
			AEMLoginPage aemLoginObj    = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj      = new AEMHomePage(oASelFW);
			AEMAssetsPage aemAssestObj  = new AEMAssetsPage(oASelFW);
			UtilityMethods utility      = new UtilityMethods(oASelFW);

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			//click Assets
			aemHomeObj.clickAssets();
			
			//verify assets page
			aemAssestObj.verifyAssetsPage("Assets");
			
			//upload assets
			aemAssestObj.clickUploadAssets("Samp.pdf");
			
			//LOGOUT
			aemHomeObj.AEMLogout();


			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) {
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			if(tabs.size()>1)
			{
				AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
				
				oASelFW.driver.close();
				Thread.sleep(5000);
				
				String wins[]=oASelFW.effectaArray("getAllWindowNames");
				oASelFW.effecta("selectWindow",wins[0]);
				
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
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
