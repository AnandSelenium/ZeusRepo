package scripts.sit.bat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_Lamp_TechPaper_Bat{

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

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMPageCreation aemPageObj             = new AEMPageCreation(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);

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
			aemSitesObj.clickOnRequiredSite("My_VMware");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("Tech Paper Page");

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
			Thread.sleep(5000);
			
			//clicking on edit page
			aemPageObj.click_EditPage();
			
			//clicking on edit tech paper page
			aemPageObj.edit_TechPage();
			
			//Enter Tech Paper Values
			
			//Enter Title
			aemComponentsObj.EnterTextField("Enter Tech Paper title", "Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			
			//Enter Publisher
			aemComponentsObj.EnterTextField("Enter Publisher Value", "VMware");
			
			//Enter Revision Date
			aemComponentsObj.EnterTextFieldDate("Revision Date", "March 24, 2016");
			
			//Enter Assest Path
			aemComponentsObj.EnterTextField_Browse("Asset Path", "http://www.vmware.com/files/pdf/techpaper/vmware-horizon-6-view-unified-communications-real-time-audio-video.pdf");
			
			//Enter Description Text
			aemComponentsObj.EnterTextArea("Description Text", "Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			Thread.sleep(5000);
			
			//Enter Related Categories
			aemComponentsObj.EnterTextField_Categories("Related Categories");
			
			//Click on Save Button
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);
			
			//#############################_Horizontal Line_Ends_######################//
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);

			aemComponentsObj.enterTextInput("Brief Text Card", "Components");
			aemComponentsObj.dragAndDropComponents("Brief Text Card", "Components","");
			aahp.clickTextComponent("Brief Text Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//fill fields in Brief Text Card
			aemstranlationObj.fillFieldsInBreifTextCard("New Window");
			Thread.sleep(10000);
			
			//closing toggle button
			aemComponentsObj.clickOnToggleSidePanel();
			
			
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentsObj.rolloutOps();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA");
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
			
			oASelFW.driver.get("http://www-test15.vmware.com/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA/"+pageName+".html");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("VMware");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("March");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Download Pdf");
			aemComponentsObj.verifyTechPapersValues_WithoutFrame("Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			
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
