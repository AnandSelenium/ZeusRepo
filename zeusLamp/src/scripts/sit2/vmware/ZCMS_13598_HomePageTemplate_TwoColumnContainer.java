package scripts.sit2.vmware;

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
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_13598_HomePageTemplate_TwoColumnContainer{

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
	public void LAMPTest() throws Exception
	{
		try{	
			
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);

			AEMPageCreation aemPageCreateObj        = new AEMPageCreation(oASelFW);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj  = new AEMPartnerLoginPage(oASelFW);
			

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
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			
			aemComponentsObj.clickOnToggleSidePanel();
		
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickOnComponent("columncontainer");

			//details
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container		
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Solid white (Default)");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");		//Select Radio button 'Yes'
	

			//Save
			aemComponentsObj.ClickSaveIcon();	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
		
			//Click Preview
			aemPageCreateObj.click_Preview();
			
			
			
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
			aemComponentObj.rolloutOps_modified("/us/my-vmware/onlyAutoQA");
			
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
			
			aemComponentObj.verifyHeading("Test");
			
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
