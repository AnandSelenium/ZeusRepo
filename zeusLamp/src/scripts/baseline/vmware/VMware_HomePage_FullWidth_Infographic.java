package scripts.baseline.vmware;

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
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMInfographicPage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class VMware_HomePage_FullWidth_Infographic{

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
			oASelFW.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
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
			Thread.sleep(15000);
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

			//############################_Infographic Component_Ends_###################################//
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);
			
			//#############################_Horizontal Line_Ends_######################//

			//##########################_FULL_WIDTH_CONTENT_CARD_STARTS_###############################//
			System.out.println("FULL_WIDTH_CONTENT_CARD_STARTS");

			//aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);

			aemComponentsObj.enterTextInput("Full Width Content Card", "Components");
			aemComponentsObj.dragAndDropComponents("Full Width Content Card", "Components","");
			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
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
			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
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

			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);

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
			aemComponentsObj.rolloutOps_modified("/in/my-vmware/onlyAutoQA");
			
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
			
			/*url.opentest15URL(pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.verifyFullWidthTitle("WE EMPOWER a brave new it.");
			aemComponentsObj.verifyFullWidthCTALabel("Innovate With A Brave New IT");
			
			url.opentest15shortenedURL(pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);*/
			
			//Navigating to sites page
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//un-publish folder
			aemComponentsObj.SelectAndUnpublishFolder(pageName);
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.SelectAndDeleteFolderAfterRollout(pageName);
			
			url.openOnlyAutoQaURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//delete folder
			aasp.DeleteFolder(pageName);
			Thread.sleep(5000);
			
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
