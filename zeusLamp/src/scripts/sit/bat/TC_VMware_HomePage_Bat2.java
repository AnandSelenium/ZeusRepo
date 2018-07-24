package scripts.sit.bat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMInfographicPage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_VMware_HomePage_Bat2{

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
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
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
			Thread.sleep(5000);

			//############################_Infographic Component_Starts_###################################//

			System.out.println("Infographic Component_Starts");

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);
			aemComponentsObj.enterTextInput("Infographic", "Components");
			aemComponentsObj.dragAndDropComponents("Infographic", "Components","");
			aahp.clickInsertedComponent("infographic");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			aip.selectValueUponLabel("Font Color Class", "grey_infographic full-width company_module section-custom");
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

			//############################_Infographic Component_Ends_###################################//
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);
			
			//#############################_Horizontal Line_Ends_######################//

			//############################_Vmware_HomePage_Promo_Component_Starts_###################################//

			System.out.println("Vmware_HomePage_Promo_Component_Starts");			

			aemComponentsObj.clickOnTabPanelLinks("Components");	
			aemComponentsObj.enterTextInput("VMWare Home Page Promo", "Components");	
			aemComponentsObj.dragAndDropComponents("VMWare Home Page Promo", "Components","");	
			aahp.clickTextComponent("VMWare Home Page Promo");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Click on Left Column
			aemComponentObj.Click_requiredLink("Left Column");
			//Select Backround color
			aemComponentObj.SelectRequiredOption_Left_RightBackgroundColor("Background Color","Blue","Left");
			//Enter Title
			aemComponentObj.EnterTextField_Left_Right("Title","VMware Horizon Air","left");
			//Enter Body
			//aemComponentObj.EnterTextArea_Left_Right("Body","Lower costs and provide a premium experience","left");
			//Enter Link Title
			aemComponentObj.EnterTextField_Left_Right("CTA Label","Try VMware Horizon 6 for Free ","left");
			//Enter Link
			aemComponentObj.EnterTextField_Browse_Left_Right("CTA URL","https://www.vmware.com","left");
			//Select Click behaviour window
			aemComponentObj.SelectRequiredOption_Left_Right("Click Behaviour","New Window","left");
			//inserting image
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("img-why-attend-04.gif", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");

			//Click on Right Column
			aemComponentObj.Click_requiredLink("Right Column");
			//Select Backround color
			aemComponentObj.SelectRequiredOption_Left_RightBackgroundColor("Background Color","Green","Right");
			//Enter Title
			aemComponentObj.EnterTextField_Left_Right("Title","VMware Horizon Flex","right");
			//Enter Body
			//aemComponentObj.EnterTextArea_Left_Right("Body","Align IT spending with business priorities","right");
			//Enter Link Title
			aemComponentObj.EnterTextField_Left_Right("CTA Label","Sign Up For a Free VMware Horizon Flex Trial ","right");
			//Enter Link
			aemComponentObj.EnterTextField_Browse_Left_Right("CTA URL","/content/vmware/language-master-sites/en","right");
			//Select Click behaviour window
			aemComponentObj.SelectRequiredOption_Left_Right("Click Behaviour","Same Window","right");
			//inserting image
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("Cisco_Logo_RGB_44x44-2-color.gif", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			System.out.println("Vmware_HomePage_Promo_Component_Ends");
			
			//############################_Vmware_HomePage_Promo_Component_Ends_###################################//
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(10000);
			
			//#############################_Horizontal Line_Ends_######################//

			//############################_Carousel_Components_Starts_##############################################//
			
			System.out.println("Carousel_Components_Starts");
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Carousel", "Components");
			aemComponentsObj.dragAndDropComponents("Carousel", "Components","");
			aemComponentObj.DoubleClickonInsertedComponent("Carousel");
			Thread.sleep(5000);

			//Heading 1
			aemComponentsObj.Click_requiredLink("Transition Section");
			aemComponentsObj.transitionSection("Transition off/on");

			//Heading 2
			aemComponentsObj.Click_requiredLink("Icons");

			//link1
			
			String logo[]= {"vsan-icon.png","vmw-hro-pcf-photon.jpg"};
			cfp.clickAddField("Carousel Icons");
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			aemComponentsObj.enterTextInput(logo[0], "Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents_MultiField("", "Assets","Logo",1);
			
			Thread.sleep(5000);
			
			/*aemComponentsObj.enterTextInput("vsan-icon.png", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Icons");*/
			cfp.clickAddField("Carousel Icons");
			/*aemComponentsObj.enterTextInput("vmw-hro-pcf-photon.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Icons");*/
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			aemComponentsObj.enterTextInput(logo[1], "Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents_MultiField("", "Assets","Logo",2);
			
			Thread.sleep(5000);

			//Heading 3
			aemComponentsObj.Click_requiredLink("Carousel Properties");
			cfp.enterComponentDetails("View All Title","View All Title");
			cfp.enterLogo("View All Url","https://google.com");
			cfp.selectWindow("Select URL Open type","Same Window");
			cfp.enterComponentDetails("Carousel Heading","Carousel Heading");

			//Click Done
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			aemComponentsObj.DoubleClickOnCarouselComponent();
			cfp.enterComponentDetails("Carousel Title","Enabling productivity in the air");
			cfp.enterDescription("Carousel Description","Business mobility technology enables Delta Airlines flight");
			cfp.enterComponentDetails("CTA Label","Read Delta's Story");
			cfp.enterLogo("CTA URL","/content/vmware/language-master-sites/en/onlyQA/Reventh/ZCMS6460_Retest");
			cfp.selectWindow("Select URL Open type","New Window");
			aemComponentsObj.enterTextInput("vmware-desktop-related-assets1-ccd-1030.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Background Image");
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			System.out.println("Carousel_Components_Ends");
			
			aemComponentsObj.clickOnToggleSidePanel();
			
			//############################_Carousel_Components_Ends_##############################################//
		
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
			
			aemComponentObj.verifySubHeading("VMware Horizon Air");
			aemComponentObj.verifySubHeading("VMware Horizon Flex");
			aemComponentObj.verifyHeading("Carousel Heading");
			aemComponentObj.verifyAnchortag("View Now");
			
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
