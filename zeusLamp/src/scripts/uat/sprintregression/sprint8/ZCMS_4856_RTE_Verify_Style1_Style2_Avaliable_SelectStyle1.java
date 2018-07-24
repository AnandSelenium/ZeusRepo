package scripts.uat.sprintregression.sprint8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.aem.WorldServer;
import classes.utilities.OpenURLs;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class  ZCMS_4856_RTE_Verify_Style1_Style2_Avaliable_SelectStyle1{

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
	public void ZCMS_4856_RTE_Verify_Style1_Style2_Avaliable_SelectStyle1() throws Exception
	{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMProjectsPage aemProjectsObj         = new AEMProjectsPage(oASelFW);
			OpenURLs aemUrl                        = new OpenURLs(oASelFW);
			WorldServer worldObj                   = new WorldServer(oASelFW); 
			AEMPageCreation aemPageObj             = new AEMPageCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);
			
		//	oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/my-vmware/QAAutomationTest/QAAuto39511.html");


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
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
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
			Thread.sleep(25000);
			
			//Switch to tab
			
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			

			//drag components
			aemComponentObj.ClickDragComponents();

			//verify insert new component
			aemComponentObj.verifyInsertNewComponent();
			
			//insert new component
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Rich Text");  //Insert Rich Text
			
			Thread.sleep(5000);
	
			//Click on Rich Text Component
			aahp.clickOnRichTextComponent("Rich Text");
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
			
			//Click on Full Screen icon
			cfp.click_screenSize("fullscreen#start");
			
			//Enter Text when maximized the screen 
			cfp.insertTextInRichTextComponentWhenMaxmized("GreenButton");
			
			Thread.sleep(5000);
			
			//Select the Rich Text value and Click Style
			aemComponentObj.SelectAllText_RobotKeys();
			
			//Click on Styles icon
			cfp.click_RichTextButtons_StylesButton("#styles");
			
			Thread.sleep(5000);
			//cfp.click_RichTextButtons_Styles();
			
			//Verify Style Type
			aemComponentObj.Verify_RichText_StyleType("Button Green");
			aemComponentObj.Verify_RichText_StyleType("Button White");
			
			
			//Click Style Type
			aemComponentObj.Click_RichText_StyleType("Button Green");
			
			Thread.sleep(5000);
			
			//Click Links Modify button
			cfp.click_RichTextButtons_ModifyLinksButton("links#modifylink");
			//cfp.click_RichTextButtons_LinksModify();
			
			
			
			//Enter Text in Input box
			aemComponentObj.EnterTextUnderLinksButton("https://www.vmware.com");
			
			//Enter Title
			aemComponentObj.EnterText_Title("https://www.vmware.com");
			
			
			
			//Click "Open in new page" checkbox
			aemComponentObj.OPenInNewPage_Checkbox();
			
			Thread.sleep(3000);
			
			//Click on Apply button
			aemComponentObj.clickOnApply();
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");
			
			//Click on Preview Button
			aemPageCreateObj.click_Preview();
			
			Thread.sleep(8000);
			
			
			//Verify Rich Text Entered Value
			aemComponentObj.Verify_RichText_Value("GreenButton");
			
			aemComponentObj.Verify_RichText_ButtonColor("btn btn-green","green");
			
			//Verify Style Properties
			aemComponentObj.Verify_RichText_FontSize("GreenButton","18px");
			
			//aemComponentObj.Verify_RichText_FontFamily("GreenButton", "proxima_novasemibold");
			
			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			
			Thread.sleep(3000);
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
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
