package scripts.uat.sit_bat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.lampdatamigration.LampEvents;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMInfographicPage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.SubmitterPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_Lamp_AddVMMark{

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
	public void test() throws Exception
	{
		try{	

			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			LampEvents  lampEvents	                 = new LampEvents(oASelFW);
			SubmitterPage submitter					= new SubmitterPage(oASelFW);
			AEMComponentCreation aemComponentsObj	= new AEMComponentCreation(oASelFW);
			AEMInfographicPage aip=new AEMInfographicPage(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
		
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			Thread.sleep(15000);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			aemHomeObj.clickSites();
			aemSitesObj.clickOnRequiredSite("lamp");
		
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("submitterdata");
			
			
			aemSitesObj.mouseHoverOnLinkAndOpenPage("submittterInfo");
			Thread.sleep(15000);
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			Thread.sleep(10000);
			
			submitter.clickOnSubmitterComponent();
			submitter.clickOnConfigure();
			submitter.clickOnAddField();
			submitter.typeInputData("Submitter Name","VMware");
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("vm-widget-logo.png", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");
			submitter.typeInputData("Description","VMware");
			submitter.typeInputData("Image Alt Text","VMware");
			submitter.typeInputData("Image Title","VMware");
			submitter.clickOnBrowseButton("Submitter Link");
			aip.clickOnAssets();
			
			//submitter.clickOnDone();
			
			Thread.sleep(5000);
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
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
 