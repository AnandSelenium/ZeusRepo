package scripts.aem_phase2.july29release;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMInfographicPage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16607_UnpublishToPreview{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_UAT",oASelFW.instanceName));	
	}
	@Test
	public void test() throws Exception
	{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");


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
			aemSitesObj.selectPageTemplate("HomePage Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(30000);

			//############################_Infographic Component_Starts_###################################//

			System.out.println("Infographic Component_Starts");

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Infographic", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Infographic", "Components","");
			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponent("infographic");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			aip.selectValueUponLabel("Font Color Class", "grey_infographic full-width company_module section-custom");
			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("banner-hero-execs-01.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Background Image");
			aip.selectValueUponLabel("Select Icon", "fa fa-line-chart");
			aip.enterValueInInputUponLabel("Small Title","by 2017");
			aip.enterValueInTextareaUponLabel("Large Title","27,432 companies");
			aip.enterValueInTextareaUponLabel("Body","Will view mobile solutions as critical");
			aip.enterValueInInputUponLabel("CTA Title","View Now ");
			aip.clickOnBrowseButton("CTA URL");
			aip.clickOnAssets();
			aip.selectValueUponLabel("Select URL Open type","_blank");
			aahp.clickOnDone();

			System.out.println("Infographic Component_Ends");

			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);

			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			oASelFW.driver.get("http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentsObj.rolloutOps_modified("/us/my-vmware");
			
			oASelFW.driver.get("http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.ClickPageInformation();
			//Click on Start Workflow
			aemComponentsObj.ClickPublishPage("Start Workflow");
			Thread.sleep(3000);
			
			//Select Work flow option
			aemComponentsObj.SelectWorkflowModelOption("VMWare Unpublish To Preview");
			Thread.sleep(3000);
			
			//Click on Start Workflow button
			aemComponentsObj.ClickStartWorkflowButton();
			
			//Verify Workflow Started Message
			aemComponentsObj.VerifyWorkflowStartedMessageDisplayed();
			Thread.sleep(3000);
			
			url.liveUAT_Publish(pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			url.dispURL_publish(pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//Navigating to sites page
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//logout
			aemHomeObj.AEMLogout();
			
			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
