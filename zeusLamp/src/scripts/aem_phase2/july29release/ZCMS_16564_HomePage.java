package scripts.aem_phase2.july29release;

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
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class  ZCMS_16564_HomePage{

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
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Username_S");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_S");
			String sampleText	= utility.getValuesFromPropertiesFile("constant", "vmware_SampleText");
			
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
			Thread.sleep(25000);
			
			//Switch to tab
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			//drag components
			aemComponentObj.clickOnToggleSidePanel();
			
			aemComponentObj.clickOnTabPanelLinks("Components");
			Thread.sleep(15000);
			
			aemComponentObj.enterTextInput("Combination Content Card", "Components");
			aemComponentObj.dragAndDropComponents("Combination Content Card", "Components","");
			aemComponentObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			//Click on Rich Text Component
			aahp.clickOnRichTextComponent("Combination Content Card");
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextTabComponentValue("VMware One Cloud Application");

			//Click on Full Screen icon
			cfp.click_screenSize("fullscreen#start");

			//Enter Text when maximized the screen 
			//cfp.insertTextInRichTextComponentWhenMaxmized(sampleText);

			Thread.sleep(8000);
			//Select the Rich Text value and Click Style
			aemComponentObj.SelectAllText_RobotKeys();
			
			Thread.sleep(8000);
			
			//Click Links Modify button
			cfp.click_RichTextButtons_ModifyLinksButton("links#modifylink");
			//cfp.click_RichTextButtons_LinksModify();
			
			//Enter Text in Input box
			aemComponentObj.EnterTextUnderLinksButton("https://www.vmware.com");
			
			//Click Alt Text 
			aemComponentObj.click_RichText_AltText();
			
			//click on Brightcove button - Yes
			aemComponentObj.click_RichText_BrightcoveLink_Btn_Yes();
			
			//Enter Brightcove video id
			aemComponentObj.EnterText_Brightcove_VideoID("3973449953001");
			
			//Click on Apply button
			aemComponentObj.clickOnApply();
			
			
			//Click on Styles icon
			cfp.click_RichTextButtons_StylesButton("#styles");
			
			Thread.sleep(5000);
			
			//Click Style Type
			aemComponentObj.Click_RichText_StyleType("Video");
			Thread.sleep(5000);
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");		
			Thread.sleep(5000);
			
			// FullScreen Exit
			cfp.click_screenSize("control#save");		
			Thread.sleep(15000);
			
	
			//Click on Preview Button
			aemPageCreateObj.click_Preview();
			Thread.sleep(8000);
			
			/*oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);*/
			
			//Verify Rich Text Entered Value
			aemComponentObj.Verify_RichText_BrightcoveTextValue("VMware One Cloud");
			
			//Verify Rich Text Entered Value
			aemComponentObj.Click_RichText_BrightcoveTextValue_VerifyVideoPlay("VMware One Cloud");
			
			
			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			
			Thread.sleep(3000);
			
			//delete folder
			/*aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
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
