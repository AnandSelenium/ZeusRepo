package scripts.aem.sprint10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.lampdatamigration.LampEvents;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_98_Events_AddEvent{

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
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			String constName="AddEvents";
			int random=(int) (Math.random()*100000);
			String eventName=constName+random;

			Thread.sleep(15000);
			oASelFW.effecta("waitForPageToLoad");
			
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			/*//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//click on required site name
			aemSitesObj.clickOnRequiredSiteTitle("Lamp Apps");
			aemSitesObj.verifySitesPage("Lamp Apps");
			aemSitesObj.clickOnRequiredSiteTitle("Events");
			aemSitesObj.verifySitesPage("Events");
			Thread.sleep(5000);
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			Thread.sleep(10000);*/
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			
			
		    
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/etc/scaffolding/events.html");
			lampEvents.VerifyEventsPage("Events");
			lampEvents.createEvent(eventName,"All Events");
			Thread.sleep(5000);
			lampEvents.VerifyCreatedEventsPage(eventName);
			oASelFW.driver.close();
			Thread.sleep(5000);

			oASelFW.effecta("selectWindow",win1[0]);
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSiteTitle("Lamp Apps");
			
			
			aemSitesObj.clickOnRequiredSite("Sites");
			
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSite("lamp");
			
			Thread.sleep(5000);
			
			
			aemSitesObj.clickOnRequiredSite("events");
			
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSite("2016");
			
			Thread.sleep(5000);
			
			
			//aemSitesObj.clickOnRequiredSite(eventName);
			
			//Thread.sleep(8000);
			
			aemSitesObj.mouseHoverOnLinkAndOpenPage(eventName);
			Thread.sleep(15000);
			
			oASelFW.effecta("selectWindow",win1[1]);
			Thread.sleep(5000);
			//Verify Added details
			lampEvents.VerifyEventsPageDetails("Europe");
			lampEvents.VerifyEventsPageDetails("Netherlands");
			lampEvents.VerifyEventsPageDetails("North Holland");
			lampEvents.VerifyEventsPageDetails("Japanese");
			
			
			
			
			oASelFW.driver.close();
			Thread.sleep(5000);
		
			
			oASelFW.effecta("selectWindow",win1[0]);
			
			Thread.sleep(5000);
			
			
			
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
 