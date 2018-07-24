package scripts.aem_phase2.dmr.sprint2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16930_VMware_De_EnhanceSite_Index_Checked{

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
	public void ZCMS_16930_VMware_De_EnhanceSite_Index_Checked() throws Exception
	{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			String sampleText	= utility.getValuesFromPropertiesFile("constant", "vmware_SampleText");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
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
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
		
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);
			
			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");
			
			//Click on Open Page
			//aemstranlationObj.ClickOpenPage("Open page");
			aemstranlationObj.ClickOpenPage("Done");
			
			Thread.sleep(5000);
			
			/*aemComponentObj.SelectAndDeleteFolderAfterRollout(pageName);
			
			aemComponentObj.Click_Component_ViewProperties(pageName);
			//	oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);*/
			aasp.SelectFolder(pageName);
			Thread.sleep(2000);
			aemstranlationObj.clickPageViewProperties();
			Thread.sleep(5000);

			aemComponentObj.ClickPageEditOption_InParentWindow("Edit");
			Thread.sleep(5000);
			aemComponentObj.VerifyHideInSiteMapIsChecked("Hide in Sitemap");
			
			Thread.sleep(5000);
			aemComponentObj.ClickProperties_Done();
			Thread.sleep(10000);
			oASelFW.driver.navigate().back();
			Thread.sleep(8000);
			aasp.SelectFolder(pageName);
			Thread.sleep(2000);
			aemstranlationObj.clickPageOpen();
			
			
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(25000);
			
			
			samp.click_Edit();
			Thread.sleep(3000);


			//Click on Preview Button
			aemPageCreateObj.click_Preview();
			Thread.sleep(5000);

			aemComponentObj.ClickPageInformation();
			Thread.sleep(8000);
			//Click on Open Properties
			aemComponentObj.ClickPageInfoOptions("Open Properties");
			Thread.sleep(20000);
			
			aemComponentObj.VerifyHideInSiteMapIsChecked("Hide in Sitemap");
			
			Thread.sleep(5000);
			
			
			oASelFW.driver.close();
		
			oASelFW.driver.switchTo().window(tab.get(0));
			Thread.sleep(3000);
		
			Thread.sleep(3000);
			
			//delete folder
			/*aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
			/*oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);*/
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
