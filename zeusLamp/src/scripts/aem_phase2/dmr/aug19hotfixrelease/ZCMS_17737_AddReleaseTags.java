package scripts.aem_phase2.dmr.aug19hotfixrelease;


//import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
//import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_17737_AddReleaseTags{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_Stage_URL",oASelFW.instanceName));	
	}
	@Test
	public void ZCMS_17737_AddReleaseTags() throws Exception
	{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			AEMAssetsPage aemAssetsObj				=	new AEMAssetsPage(oASelFW);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMEditCustomer aemEditObj             = new AEMEditCustomer(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
		
			//LOGIN
			aemLoginObj.login(userName,Password);

			aemHomeObj.verifyHomePage();

			//click on sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("My VMware");
			//aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pagename=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pagename);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Done");
			Thread.sleep(5000);
			
			
			aemAssetsObj.selectPage_ViewProperties(pagename);
			
			aemAssetsObj.clickViewProperties_Edit();
			
			
			
			

			
			//Logout
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
			/*AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
				aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();*/
				
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
