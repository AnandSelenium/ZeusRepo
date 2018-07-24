package scripts.aem_phase2.dmr.aug19hotfixrelease;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
		oASelFW.startSelenium(oASelFW.getURL("AEM_PublishedSites_URL",oASelFW.instanceName));	
	}
	@Test
	public void ZCMS_17311_CreateLaunchCopy()
	{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMCustStoryPage aemCustStoryObj         = new AEMCustStoryPage(oASelFW);
			AEMTranslation aemstranlationObj         = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			ArrayList<String> values=new ArrayList<String>();
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
		
			String localesArr[]={"Deutsch","Australia","India","Canada (English)","Belgium (English)","Asia Pacific","Middle East and North Africa","United Kingdom","English","Swedish","Magyar","Polski","South Africa","Singapore","Malaysia (business card)","Indonesia (Business Card)","Portuguese","Danish","Saudi Arabia (business card)","Norwegian","Finnish","Hebrew"};
			
		/*	String Launchtitle="Launch";
			int random=(int) (Math.random()*10000);
			String title=Launchtitle+random;*/

	
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
		
			//Click on Select
			aemstranlationObj.clickSelect();
		
			for(int i=1;i<=localesArr.length;i++)
			{	
			
				
				String value="Launch1"+i;

				values.add(value);
				
				aemSitesObj.selectPageTitle(localesArr[i-1]);
				
				Thread.sleep(3000);
				
				//CLICK ON CREATE PAGE
				aemSitesObj.clickCreateLink_LaunchCopy("Create Launch");
				
				Thread.sleep(5000);
				
				aemComponentsObj.EnterTextField("Launch Title",value);
				
				aemComponentsObj.clickLaunchCopy_SubPagesCheckbox("Exclude sub pages");
				Thread.sleep(3000);
				
				aemComponentsObj.clickLaunchCopy_SubPagesCheckbox_Uncheck("Inherit source page live data");
				
				aemComponentsObj.ClickCreateButton();
				Thread.sleep(8000);
				
				aemComponentsObj.VerifyLaunchCreatedpopup("Launch created");
				
				//Open Launch
				aemstranlationObj.ClickOpenPage("Open Launch");
				Thread.sleep(5000);
				
				
				aemComponentsObj.VerifyLaunchPageisOpened(value, localesArr[i-1]);
			
				Thread.sleep(5000);
				//aemSitesObj.selectPageTitle(localesArr[i-1]);
			}
			
			
			
			
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
 