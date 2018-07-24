package scripts.uat.sprintregression.sprint7;

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

public class ZCMS_5435_Pdf {

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
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
			
			String username=oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password=oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			AEMAssetsPage aasp 					   	 = new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			//LOGIN
			aemLoginObj.login(username,password);
			
			
			//click on Sites
			aemHomeObj.clickSites();
			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
		
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("HomePage Template");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			
			
			//Thread.sleep(5000);
			aemComponentsObj.OpenNewTab_RobotKeys();
			
			
			
			
			Thread.sleep(10000);
			
			//oASelFW .driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA/PDF_QATest.html");
			
			//Thread.sleep(10000);
			//Navigating To New Window
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			samp.click_Edit();
			Thread.sleep(10000);

			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(10000);
			
			aemComponentsObj.enterTextInput("Features", "Components");
			
			aemComponentsObj.dragAndDropComponents("Features", "Components","");
			
			aahp.clickTextComponent("Features");
			
			aahp.clickOnTool("CONFIGURE");
			
			Thread.sleep(5000);
		
			//Click on Container Level PDF in Feature List Container window
			aemComponentsObj.Click_FeatureListContainer_ContainerLevelPDF_Link();
			
			//Enter Link Label
			aemComponentsObj.FeatureListContainerProperties("Link Label","Testqa");
			
			//Enter Link Title
			aemComponentsObj.FeatureListContainerProperties("Link Title","Testqa_Pdf");
			
			//Enter Link Url
			aemComponentsObj.FeatureListContainerProperties_LinkUrl("Link URL","/content/dam/digitalmarketing/vmware/en/pdf/analysis/socialcast/vmw-idc-marketscape-social-vendor-analysis.pdf");
			
			//select New Window from Target Window
			aemComponentsObj.FeatureListContainerProperties_SelectTargetWindow("New Window");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
		
			Thread.sleep(5000);
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win[1]);
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//Click on Page Information
			aemComponentsObj.ClickPageInformation();
			
			//Click on Publish Page
			aemComponentsObj.ClickPublishPage("Publish Page");
			
			//Deselect Checkbox to publish
			aemComponentsObj.selectCheckBoxAfterPublishing();

			//Click on Publish button
			aemComponentsObj.ClickPublishPage("Publish");
			
			Thread.sleep(5000);
			
			oASelFW.effecta("waitForPageToLoad");
			
			Thread.sleep(3000);
			
			//Verify Page has been successfully published
			//aemComponentsObj.VerifyPublishPage_MessageDisplayed();
			
			oASelFW.driver.close();
			
			
			Thread.sleep(5000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
		/*	//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
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
