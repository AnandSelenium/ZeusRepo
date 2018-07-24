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


public class TC_VMware_L4Enterprise_Component3{

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
			aemSitesObj.selectPageTemplate("VMWare L4 Enterprise Template");

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

			//##########################_FULL_WIDTH_CONTENT_CARD_STARTS_###############################
			System.out.println("FULL_WIDTH_CONTENT_CARD_STARTS");

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);

			aemComponentsObj.enterTextInput("Full Width Content Card", "Components");
			aemComponentsObj.dragAndDropComponents("Full Width Content Card", "Components","");
			aahp.clickTextComponent("Full Width Content Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Title
			aemComponentsObj.ImageProperties_Horizontal("Title","WE EMPOWER a brave new it.");
			Thread.sleep(5000);
			//CTA Label
			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Innovate With A Brave New IT");
			Thread.sleep(5000);
			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 
			//Click on Toggle Side Panel
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("img-thumbnail-vid-alumni-960w.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);
			//Select Icon
			aemComponentsObj.SelectRequiredOption("Select Icon","Bar Chart");
			//Brightcove Video ID
			aemComponentsObj.ImageProperties_Horizontal("Brightcove Video ID","3973449953001");
			Thread.sleep(5000);
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			System.out.println("FULL_WIDTH_CONTENT_CARD_ENDS");

			//##########################_FULL_WIDTH_CONTENT_CARD_ENDS_###############################

			//#############################_Horizontal Line_STARTS_######################

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(5000);

			//#############################_Horizontal Line_Ends_######################
			
			//#############################_Combination Content Card_STARTS_######################
			
			System.out.println("Combination Content Card_STARTS");
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Combination Content Card", "Components");
			aemComponentsObj.dragAndDropComponents("Combination Content Card", "Components","");
			aahp.clickTextComponent("Combination Content Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Title
			aemComponentsObj.ImageProperties_Horizontal("Title","Vmware Global");
			//Image Asset
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("img-thumbnail-vid-alumni-960w.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			System.out.println("Combination Content Card_STARTS");
			
			//#############################_Combination Content Card_End_######################
			
			//#############################_Horizontal Line_STARTS_######################

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);

			//#############################_Horizontal Line_Ends_######################

			//#################_TWO_COLUMN_CONTAINER_START_##############################//

			System.out.println("TWO_COLUMN_CONTAINER_START");
			
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
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			//#####################################Partial Width Content Card##############################

			//Click on column control Drag Component
			aemComponentsObj.twoColparContainer("columncontainer","columncontainer1");
			Thread.sleep(5000);
			System.out.println("Partial Width Content Card starts");
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Partial Width Content Card");
			aahp.clickTextComponent("Partial Width Content Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
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
			
			System.out.println("Brief Text Card starts");
			
			//Click on column control Drag Component
			aemComponentsObj.twoColparContainer("columncontainer","columncontainer2");
			Thread.sleep(5000);
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Brief Text Card");
			aahp.clickTextComponent("Brief Text Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			//fill fields in Brief Text Card
			aemstranlationObj.fillFieldsInBreifTextCard("New Window");
			Thread.sleep(10000);
			
			System.out.println("Brief Text Card Ends");
			//**************************_TWO Column Container Ends***************************************

			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);
			aemComponentsObj.clickOnToggleSidePanel();

			//#############################_Horizontal Line_Ends_######################//
			
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
			aemComponentObj.rolloutOps_modified("/in/my-vmware/onlyAutoQA");

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

			aemComponentObj.verifyHeading("WE EMPOWER a brave new it.");
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
