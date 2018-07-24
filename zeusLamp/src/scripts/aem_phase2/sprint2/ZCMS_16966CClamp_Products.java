package scripts.aem_phase2.sprint2;

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
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_16966CClamp_Products{

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

			oASelFW.driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj = new AEMPartnerLoginPage(oASelFW);
			

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
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

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
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			//drag components
			aemComponentsObj.clickOnToggleSidePanel();
			System.out.println("FULL_WIDTH_CONTENT_CARD_STARTS");

			//aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);

			aemComponentsObj.enterTextInput("Product Category A-Z Header", "Components");
			aemComponentsObj.dragAndDropComponents("Product Category A-Z Header", "Components","");
			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			aahp.clickTextComponent("Product Category A-Z Header");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Title
			aemComponentsObj.ImageProperties_Horizontal("Page Label","Product Page Label -Testing Stage");
			aemComponentsObj.ImageProperties_Horizontal("Page Header","Page Header - Stage");
			aemComponentsObj.EnterTextArea("Page Description","Page Description-Stage");
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Product Category Tabs");
			Thread.sleep(3000);
			aemComponentsObj.ImageProperties_Horizontal("Products Category Tab Label","PRODUCTS BY CATEGORY - Stage");
			aemComponentsObj.ImageProperties_Horizontal("Products A-Z Tab Label","PRODUCTS A-Z TAB LABEL-Stage");
			aemComponentsObj.ImageProperties_Horizontal("Solutions Category Label","SOLUTION BY CATEGORY --Stage");
			aip.clickOnBrowseButton("Solution Category URL");
			aip.clickOnProductURL();
			aahp.clickOnDone();
			Thread.sleep(5000);
			
			//**********************************************************************************************************//
			//Brief Text Blurb
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);
			aemComponentsObj.enterTextInput("Brief Text Blurb", "Components");
			aemComponentsObj.dragAndDropComponents("Brief Text Blurb", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			aahp.clickTextComponent("Brief Text Blurb");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			//Details
			aemComponentsObj.ImageProperties_Horizontal("Title (Suggested 60 Characters)","A-Testing");
			aip.clickOnBrowseButton("Title Path");
			aip.clickOnBlurbURL();
			aemComponentsObj.EnterTextArea("Description Text (Suggested 350 Characters)","A-Description testing");
			aemComponentsObj.SelectRequiredOption("Select Icon","Alert");
			aemComponentsObj.SelectRequiredOption("Select the Icon Color","Dark Blue");
			aemComponentsObj.SelectRequiredOption("Product Type","Uncategorized");
			aahp.clickOnDone();
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);
			aemComponentsObj.enterTextInput("Brief Text Blurb", "Components");
			aemComponentsObj.dragAndDropComponents("Brief Text Blurb", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			aahp.sameComponentTwice("Brief Text Blurb");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			//Details
			aemComponentsObj.ImageProperties_Horizontal("Title (Suggested 60 Characters)","Title-Abtesting");
			aemComponentsObj.TypeDirect_URL("Title Path","http://www.vmware.com/products/vmmark.html");
			aemComponentsObj.EnterTextArea("Description Text (Suggested 350 Characters)","Description : Testing");
			aemComponentsObj.SelectRequiredOption("Select Icon","Poll");
			aemComponentsObj.SelectRequiredOption("Select the Icon Color","Green");
			aemComponentsObj.SelectRequiredOption("Product Type","Categorized");
			aemComponentsObj.Addfield();
			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Download");
			aemComponentsObj.TypeDirect_URL("CTA Link","http://www.vmware.com/go/download-vmmark");
			aahp.clickOnDone();
			Thread.sleep(5000);
			//***************************************************************************************//
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
		/*	
			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();

			url.openMyVMwareURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentsObj.rolloutOps_modified("/us/my-vmware/onlyAutoQA");

			url.openVMware_PublishedURL();
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
			aemstranlationObj.publishPage_NEW();

			url.opentest15URL(pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);*/

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
