package scripts.aem_phase2.sprint1;

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
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class  ZCMS_8487_VMware_FormNamewithActions{

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
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj = new AEMPartnerLoginPage(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);

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
			aemSitesObj.clickOnRequiredSite("VMForms");
			aemSitesObj.clickOnRequiredSite("VMware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("onlyAutoQAForms");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMWare Forms Template ");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");
			Thread.sleep(25000);

			//Switch to tab
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			//******************************************************************************//
			//drag components
			aemComponentObj.clickOnToggleSidePanel();
			aemComponentObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentObj.enterTextInput("Text With Action", "Components");
			Thread.sleep(3000);
			aemComponentObj.dragAndDropComponents("Text With Action", "Components","");
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Text With Action");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Form Text Action
			aemComponentObj.ImageProperties_Horizontal("Component Header","Form With Actions");
			aemComponentObj.ImageProperties_Horizontal("Title","Form With Actions Title");
			aemComponentObj.ImageProperties_Horizontal("Placeholder Text","Placeholder Text");
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Validation");
			aemComponentObj.mandatoryCheckbox();
			aemComponentObj.ImageProperties_Horizontal("Warning Message","Required Feilds");
			aahp.clickOnDone();
			Thread.sleep(5000);
			//**************************************************************************************//
			
			//Click on Preview Button
			aemPageCreateObj.click_Preview();
			Thread.sleep(8000);

			//NAavigating To Site Admin
			oASelFW.driver.close();
			Thread.sleep(2000);
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println(win.length);
			oASelFW.effecta("selectWindow",win[0]);
			oASelFW.driver.switchTo().defaultContent();
			
			url.lampToAemPage("test");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageNameAEM=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageNameAEM);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tabs3 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			System.out.println(tabs3.size());
			oASelFW.driver.switchTo().window(tabs3.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(30000);
			samp.click_Edit();
			//*******************************************************************************************//
			aemComponentObj.clickOnToggleSidePanel();
			aemComponentObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentObj.enterTextInput("VMware Forms HTML Component", "Components");
			Thread.sleep(3000);
			aemComponentObj.dragAndDropComponents("VMware Forms HTML Component", "Components","");
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponent("formcomponent");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aip.clickOnBrowseButton("Form Path");
			aip.clickOnLampForm(pageName);
			aahp.clickOnDone();
			Thread.sleep(3000);
			//********************************************************************************************//
			
			//Click on Preview Button
			aemPageCreateObj.click_Preview();
			Thread.sleep(8000);
			
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
			aemComponentObj.clickLiveCopy();
			aemComponentObj.rolloutOps_modified("/us/my-vmware");
			
			url.openVMware_PublishedURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageNameAEM);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			aemComponentObj.ClickPageInformation();
			Thread.sleep(5000);
			
			aemstranlationObj.publishPage_NEW();
			Thread.sleep(5000);
			
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			url.opentest15shortenedURL(pageNameAEM);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentObj.enterFormdActionsText("Form With Actions Title", "vmware");
			Thread.sleep(3000);
			aemComponentObj.VerifyFormActionListbox_Values();
			
			//Navigating to sites page
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
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
