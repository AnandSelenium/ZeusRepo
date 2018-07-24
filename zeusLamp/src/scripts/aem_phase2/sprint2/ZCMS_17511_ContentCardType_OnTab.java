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
import classes.aem.AEMMethods;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_17511_ContentCardType_OnTab{

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
	public void ZCMS_17511_ContentCardType_OnTab() throws Exception
	{
		try{	

			oASelFW.driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			String videoID="3973449953001";
			String stagePub_Url		= utility.getValuesFromPropertiesFile("constant", "AEM_URL_Publish_Url");
			
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
			
			samp.click_Edit();
			Thread.sleep(3000);
			
			aemComponentObj.clickOnToggleSidePanel();
			aemComponentObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);

			aemComponentObj.enterTextInput("Two Column Tab Container", "Components");
			aemComponentObj.dragAndDropComponents("Two Column Tab Container", "Components","");
			Thread.sleep(5000);
			
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);

			aahp.clickInsertedComponent("twocolumntabcontaine");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			
			
			String Tabtitles[]={"Tab1","Tab2"};
			String Tabcontents[]={"Two partial width content card","One partial width content card"};
			String selectIcon[]={"Alert","Checklist"};
			

			for(int i=1;i<=2;i++)
			{
				//Click on Add field
				aemComponentsObj.ClickAddField();


				aemComponentsObj.EnterMultiTextField("Tab Title",Tabtitles[i-1],i);
				
				aemComponentObj.SelectMultiRequiredOption("Select Icon",selectIcon[i-1], i);

				aemComponentObj.SelectMultiRequiredOption("Bake In Component",Tabcontents[i-1], i);
			}
			
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
		
			//******************* Partial Width -First section(Two partial width content card) ******************************
			aahp.clickTextComponent_TwoColumnTab("Partial Width Content Card", 3);
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aemComponentObj.clickOnTabPanelLinks("Assets");
			aemComponentObj.enterTextInput("banner-hero-execs-01.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aip.enterValueInInputUponLabel("Title","Title for Partial Width one");
			aemComponentObj.ImageProperties_Horizontal("CTA Label","CTA Label for Partial Width one");
			Thread.sleep(5000);
			aip.enterValueInInputLinkUrl("CTA Link","https://www.youtube.com/watch?v=_GVZHuHHdnk");
			aemComponentObj.ImageProperties_Horizontal("CTA Link Title","Test Title");
			Thread.sleep(5000);
			
			aemComponentObj.SelectRequiredOption("Select URL Open type","New Window");
			//Select Icon
			aemComponentObj.SelectRequiredOption("Select Icon","Bar Chart");
		
			aemComponentsObj.EnterTextField("Brightcove Video ID",videoID);
			//Save
			aemComponentObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			
			//******* Ends ************ Partial Width -First section(Two partial width content card) ******************************
			
			
			//******************* Partial Width -second section(Two partial width content card) ******************************
			aahp.clickTextComponent_TwoColumnTab("Partial Width Content Card", 2);
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aemComponentObj.clickOnTabPanelLinks("Assets");
			aemComponentObj.enterTextInput("img-thumbnail-vid-alumni-960w.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aip.enterValueInInputUponLabel("Title","Title for Partial Width two");
			aemComponentObj.ImageProperties_Horizontal("CTA Label","CTA Label for Partial Width two");
			Thread.sleep(5000);
			aip.enterValueInInputLinkUrl("CTA Link","https://www.youtube.com/watch?v=_GVZHuHHdnk");
			aemComponentObj.ImageProperties_Horizontal("CTA Link Title","Test Title");
			Thread.sleep(5000);
			
			aemComponentObj.SelectRequiredOption("Select URL Open type","New Window");
			//Select Icon
			aemComponentObj.SelectRequiredOption("Select Icon","PDF");
			
			aemComponentsObj.EnterTextField("Brightcove Video ID",videoID);
			//Save
			aemComponentObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//*********Ends********** Partial Width -second section(Two partial width content card) ******************************
			
			//click on preview
			aemHomeObj.PreviewButton();
			Thread.sleep(3000);
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			aemComponentObj.clickContainerCardTabComponent_Tabs("Tab2",2);
			
			samp.click_Edit();
			Thread.sleep(3000);
			

			//******************* Partial Width -second section(One partial width content card) ******************************
			aahp.clickTextComponent_TwoColumnTab("Partial Width Content Card", 1);
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aemComponentObj.clickOnTabPanelLinks("Assets");
			aemComponentObj.enterTextInput("img-thumbnail-vid-alumni-960w.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aip.enterValueInInputUponLabel("Title","Title for Partial Width");
			aemComponentObj.ImageProperties_Horizontal("CTA Label","CTA Label for Partial Width");
			Thread.sleep(5000);
			aip.enterValueInInputLinkUrl("CTA Link","https://www.youtube.com/watch?v=_GVZHuHHdnk");
			aemComponentObj.ImageProperties_Horizontal("CTA Link Title","Test Title");
			Thread.sleep(5000);
			
			aemComponentObj.SelectRequiredOption("Select URL Open type","New Window");
			//Select Icon
			aemComponentObj.SelectRequiredOption("Select Icon","Checklist");
		
			aemComponentsObj.EnterTextField("Brightcove Video ID",videoID);
			//Save
			aemComponentObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//click on preview
			aemHomeObj.PreviewButton();
			Thread.sleep(3000);
			
			
			aemComponentObj.clickContainerCardTabComponent_Tabs("Tab1",1);
			
			
			aemComponentObj.verifyColumnContainerTab_PartialWidth_Title_InPreview("Title for Partial Width one");
			
			aemComponentObj.verifyColumnContainerTab_PartialWidth_Icons_InPreview("bar-chart");
			
			aemComponentObj.verifyColumnContainerTab_PartialWidth_Title_InPreview("Title for Partial Width two");
			
			aemComponentObj.verifyColumnContainerTab_PartialWidth_Icons_InPreview("pdf");
			
			
			aemComponentObj.clickContainerCardTabComponent_Tabs("Tab2",2);
			
			aemComponentObj.verifyColumnContainerTab_PartialWidth_Title_InPreview("Title for Partial Width");
			
			aemComponentObj.verifyColumnContainerTab_PartialWidth_Icons_InPreview("check");
			
			
			
			//Navigating To Home Window
			oASelFW.driver.close();
		
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();

			url.openMyVMware("stage");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentObj.clickLiveCopy();
			aemComponentObj.rolloutOps_modified("/us/my-vmware/onlyAutoQA");

			url.openVMware_Published("stage");
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

			aemComponentObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();

			//url.opentest15URL(pageName);
			String publishedpageurl=oASelFW.driver.getCurrentUrl();
			
			System.out.println("Published page url---"+publishedpageurl);
			
			aemComponentObj.modifyUrl_VMware_WithPublishPage_stage(publishedpageurl,stagePub_Url);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
		
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
