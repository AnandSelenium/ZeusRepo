package scripts.aem.sprint10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_97_LampEvents {

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
	public void TC_ZCMS_3597_ReviewTranslatedContent_04() throws Exception{
		
		String pageName="";
	
		
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
			
			
			String username=oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password=oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			String imgLocator=oASelFW.getConstValFrmPropertyFile("imgLocator");
			
			AEMMethods samp = new AEMMethods(oASelFW);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			//LOGIN
			aemLoginObj.login(username,password);
			
			
			//click on Sites
			aemHomeObj.clickSites();
			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			
			aemSitesObj.clickOnRequiredSite("English");
			
			aemSitesObj.clickOnRequiredSite("My VMware");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();
			
			//fill required fields
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//Click on Oprn Page
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(5000);

			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			Thread.sleep(10000);
	
			samp.click_Edit();
		

			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(10000);

			aemComponentsObj.clickOnTabPanelLinks("Components");
		
			
			aemComponentsObj.enterTextInput("Events", "Components");
			
			aemComponentsObj.dragAndDropComponents("Events", "Components","");
		
			
			oASelFW.driver.close();
			
			
			Thread.sleep(5000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
		
			//logout
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
