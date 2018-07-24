package scripts.sit.vmware;

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
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_VMware_Cclamp_Component2{

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

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);

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

			//#################_TWO_COLUMN_CONTAINER_START_##############################//

			System.out.println("TWO_COLUMN_CONTAINER_START");
			
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			aahp.clickTextComponent("Two Column Container");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Title
			aemComponentsObj.ImageProperties_Horizontal("Title","Vmware");
			//Select_Column
			aemComponentsObj.SelectRequiredOption("Column Layout","2 columns(50%, 50%)");
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Spotlight Gradient Blue");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");	
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			//Click on column control Drag Component
			aemComponentsObj.clickOnColumnDragComponent("columncontainer","columncontainer1");
			Thread.sleep(5000);
			System.out.println("Partial width content starts");
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Partial Width Content Card");
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Partial Width Content Card");			
			Thread.sleep(5000);
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("img-kbyg-vmw-booth-02.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);
			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Partial_Width_Content_Card_1_CTA_LABEL");
			Thread.sleep(5000);
			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 
			aemComponentsObj.ImageProperties_Horizontal("CTA Link Title","Partial_Width_Content_Card_1_CTA_LINK TITLE");
			Thread.sleep(5000);
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(4000);
			
			//Click on column control Drag Component
			aemComponentsObj.clickOnColumnDragComponent("columncontainer","columncontainer2");
			Thread.sleep(5000);
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Rich Text");
			aahp.clickOnRichTextComponent("Rich Text");
			
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextTabComponentValue("Zeus");
			Thread.sleep(3000);
			/*aahp.richtextScreen("fullscreen#start");
			
			//aahp.insertTextInRichTextTabComponentValue("Zeus");		
			Thread.sleep(3000);
			aahp.richtextScreen("fullscreen#finish");*/
			
			aahp.richtextScreen("control#save");
			Thread.sleep(3000);
			
			
			System.out.println("TWO Column Container Ends");
			//**************************_TWO Column Container Ends***************************************
			
			aemComponentObj.ClickDragComponentsUpper();
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Page Header Anchor Navigation");		
			Thread.sleep(10000);
			
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
			aemstranlationObj.selectPage("My VMware");
			aemComponentsObj.clickLiveCopy();
			aemComponentObj.rolloutOps_modified("/in/my-vmware");

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
			
			//Verify 
			aemComponentObj.verifyAnchor("Partial_Width_Content_Card_1_CTA_LINK TITLE");
			
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
