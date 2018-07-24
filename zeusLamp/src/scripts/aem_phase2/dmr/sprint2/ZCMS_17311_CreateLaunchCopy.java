package scripts.aem_phase2.dmr.sprint2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMComponentCreation;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_17311_CreateLaunchCopy{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_Stage_PublishedSites_URL",oASelFW.instanceName));	
	}
	@Test
	public void ZCMS_17311_CreateLaunchCopy()
	{
		try{	

			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMCustStoryPage aemCustStoryObj         = new AEMCustStoryPage(oASelFW);
			AEMTranslation aemstranlationObj         = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Naresh");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Naresh");
		
			
			String LaunchTitle="Launch";
			int random=(int) (Math.random()*100000);
			String customerName=LaunchTitle+random;
			System.out.println("LaunchTitle"+LaunchTitle);

	
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//Click on Select
			aemstranlationObj.clickSelect();
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Launch");
			
			Thread.sleep(5000);
			
			aemComponentsObj.EnterTextField("Launch Title",LaunchTitle);
			
			aemComponentsObj.clickLaunchCopy_SubPagesCheckbox("Exclude sub pages");
			
			aemComponentsObj.clickLaunchCopy_SubPagesCheckbox_Uncheck("Inherit source page live data");
			
			aemComponentsObj.ClickCreateButton();
			Thread.sleep(5000);
			
		
			//Thread.sleep(5000);
			
			
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
 