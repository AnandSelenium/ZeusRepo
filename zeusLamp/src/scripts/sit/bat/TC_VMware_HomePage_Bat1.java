package scripts.sit.bat;

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


public class TC_VMware_HomePage_Bat1{

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

			//##########################_FULL_WIDTH_CONTENT_CARD_STARTS_###############################//
			System.out.println("FULL_WIDTH_CONTENT_CARD_STARTS");

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);

			aemComponentsObj.enterTextInput("Full Width Content Card", "Components");
			aemComponentsObj.dragAndDropComponents("Full Width Content Card", "Components","");
			aahp.clickTextComponent("Full Width Content Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Fill the required Image Properties

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

			//##########################_FULL_WIDTH_CONTENT_CARD_ENDS_###############################//
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(5000);
			
			//#############################_Horizontal Line_Ends_######################//

			//#############################_TWO_COLUMN_TABBED_CONTAINER_STARTS_######################//

			System.out.println("TWO_COLUMN_TABBED_CONTAINER_STARTS");

			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);

			aemComponentsObj.enterTextInput("Two Column Tab Container", "Components");
			aemComponentsObj.dragAndDropComponents("Two Column Tab Container", "Components","");
			aahp.clickTextComponent("Two Column Tab Container");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Add_Field
			aahp.click_AddField("List of Tabs", "Add field");

			//Title
			aemComponentsObj.ImageProperties_Horizontal("Tab Title","Two_Column_Tab_Container_Title");
			Thread.sleep(5000);

			//Select Icon
			aemComponentsObj.SelectRequiredOption("Select Icon","Bar Chart");

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			//**********************PARTIAL WIDTH CONTENT CARD 1 STARTS********************************
			System.out.println("PARTIAL WIDTH CONTENT CARD 1 STARTS");

			aahp.clickOnPartialWidthComponent("twocolumntabcontaine","hcontentcard1Two_Column_Tab_Container_Title");
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

			System.out.println("PARTIAL WIDTH CONTENT CARD 1 ENDS");

			//**********************PARTIAL WIDTH CONTENT CARD 2 ********************************

			System.out.println("PARTIAL WIDTH CONTENT CARD 2 STARTS");

			aahp.clickOnPartialWidthComponent("twocolumntabcontaine","hcontentcard2Two_Column_Tab_Container_Title");
			Thread.sleep(8000);

			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("img-kbyg-vmw-booth-03.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);

			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Partial_Width_Content_Card_2_CTA_LABEL");
			Thread.sleep(5000);

			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 

			aemComponentsObj.ImageProperties_Horizontal("CTA Link Title","Partial_Width_Content_Card_2_CTA_LINK TITLE");
			Thread.sleep(5000);

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//**********************PARTIAL WIDTH CONTENT CARD 2 ENDS********************************

			System.out.println("TWO_COLUMN_TABBED_CONTAINER_ENDS");

			//############################_TWO_COLUMN_TABBED_CONTAINER_ENDS_#######################//
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(5000);
			
			//#############################_Horizontal Line_Ends_######################//

			//############################_HomePage_Hero_Carousel_Component_Starts_###################################//

			System.out.println("_HomePage_Hero_Caroisel_Component_Starts");

			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Home Page Hero Carousel", "Components");
			aemComponentsObj.dragAndDropComponents("Home Page Hero Carousel", "Components","");
			aahp.clickInsertedComponent("herocarousel");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aemComponentsObj.Click_requiredLink("Carousel Tab Details");

			//Add_Field
			aahp.click_AddField("List of Tabs", "Add field");
			//Title
			aemComponentsObj.ImageProperties_Horizontal("Title","We make mobile management easy.");
			Thread.sleep(5000);
			//Select Tab Icon
			aemComponentsObj.SelectRequiredOption("Select Tab Icon","Bar Chart");
			Thread.sleep(5000);
			aemComponentsObj.Click_requiredLink("Carousel Note Section");
			//Title
			aemComponentsObj.ImageProperties_Horizontal("Note","Business Mobility gives you the power");
			Thread.sleep(5000);
			//Select Icon
			aemComponentsObj.SelectRequiredOption("Note Icon","Bar Chart");
			Thread.sleep(5000);
			//CTA Link
			aemComponentsObj.EnterTextField_Browse("Note URL","https://www.vmware.com"); 
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("heroCarouselTabs1");
			//Select Carousel Slider Skin Type
			aemComponentObj.SelectRequiredOption("Carousel Slider Skin Type","Gray");
			//inserting image
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("hero-careers-bg.png", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Carousel Image");
			//Enter Carousel Title
			aemComponentObj.EnterTextField("Carousel Title","Vmware");
			//Enter Carousel Description
			aemComponentObj.EnterTextArea("Carousel Description","Empower Mobile workers without the worry");
			//Enter CTA Title
			aemComponentObj.EnterTextField("CTA Title","Learn More About Business Mobility");
			//Select CTA Button Color
			aemComponentObj.SelectRequiredOption("CTA Button Color","Green");
			//Enter Note URL
			aemComponentObj.EnterTextField_Browse("CTA URL","https://www.facebook.com");
			Thread.sleep(3000);
			//Select Select URL Open Type
			aemComponentObj.SelectRequiredOption("Select URL Open type","New Window");
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			System.out.println("HomePage_Hero_Carousel_Component_Ends");
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(8000);

			//############################_HomePage_Hero_Carousel_Component_Ends_###################################//
			
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
			
			aemComponentObj.verifyHeading("WE EMPOWER a brave new it.");
			aemComponentObj.verifyAnchor("Partial_Width_Content_Card_2_CTA_LINK TITLE");
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
