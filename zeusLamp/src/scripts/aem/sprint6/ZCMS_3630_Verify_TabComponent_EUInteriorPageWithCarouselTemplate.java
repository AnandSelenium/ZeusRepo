package scripts.aem.sprint6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3630_Verify_TabComponent_EUInteriorPageWithCarouselTemplate {
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

	public void ZCMS_3630_Verify_TabComponent_EUInteriorPageWithCarouselTemplate_Copy() throws Exception{
		
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(450, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMAssetsPage aasp = new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			AEMAgendaHeaderPage aahp                 = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);


			Thread.sleep(4000);
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/content/vmworld/en/europe/global-content/onlyAutoQA/QAAutoTest45916.html");
			
			
			//Verify Home Page
			//aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");

			aemSitesObj.clickOnRequiredSite("en");
			

            //CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("Europe");
			aemSitesObj.verifySitesPage("Europe");
			
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(6000);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);


			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			
			oASelFW.effecta("waitForPageToLoad");
			
			

			//Switch to the new window after click on open page
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));

			samp.click_Edit();
			Thread.sleep(10000);
			//drag the  components
			aemComponentsObj.ClickDragComponents();

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Tab Content Component");

			aemComponentsObj.DoubleClickonInsertedComponent("Tab Content Component");

			Thread.sleep(10000);

			String Tabtitles[]={"Title1","Title2"};
			String Tabcontents[]={"Tab_Content1","Tab_Content2"};

			for(int i=1;i<=2;i++)
			{
				//Click on Add field
				aemComponentsObj.ClickAddField();


				aemComponentsObj.EnterMultiTextField("Tab Title",Tabtitles[i-1],i);

				//aemComponentsObj.EnterMultiTextField_Browse("",Tabcontents[i-1],i);
				aemComponentsObj.EnterMultiTextField("Tab Content Title",Tabcontents[i-1],i);
			}


			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			String[] url={"http://aem-test-auth-1.vmware.com:8080","www.google.com"};
			String[] title={"Internal","External"};


			
			//Double click on Tab1 - Drag Components
			aemComponentsObj.DoubleClickonTabComponent_DragComponent("par-tab-title1");
			
			Thread.sleep(5000);
			
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Rich Text Component");
			Thread.sleep(5000);
			
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
			
			//Click on Full Screen icon
			cfp.click_screenSize("fullscreen#start");
			
			
			//Enter Text when maximized the screen 
			cfp.insertTextInRichTextComponentWhenMaxmized("Test1");
			//Thread.sleep(8000);
			
			//Select the Rich Text value and Click Style
			aemComponentsObj.SelectAllText_RobotKeys();
			
			//Thread.sleep(8000);
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			Thread.sleep(8000);
			
			//Click Links Modify button
			cfp.click_RichTextButtons_ModifyLinksButton("links#modifylink");
			//cfp.click_RichTextButtons_LinksModify();
			
			
			
			//Enter Text in Input box
			aemComponentsObj.EnterTextUnderLinksButton("https://www.vmware.com");
			
			//Enter Title
			aemComponentsObj.EnterText_Title("https://www.vmware.com");
			
			
			
			//Click "Open in new page" checkbox
			//aemComponentsObj.OPenInNewPage_Checkbox();
			
			Thread.sleep(3000);
			
			//Click on Apply button
			aemComponentsObj.clickOnApply();
			
			Thread.sleep(5000);
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");
			
			
			Thread.sleep(5000);
			
			
			//click on preview
			aemPageCreateObj.click_Preview();
			Thread.sleep(3000);
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			
			aemComponentsObj.ClickTabComponent_Tab("tab-title2");
			
			Thread.sleep(5000);
			
			//aemPageCreateObj.click_EditPage();
			samp.click_Edit();
			Thread.sleep(5000);
			
		
		
			//Double click on Tab1 - Drag Components
			aemComponentsObj.DoubleClickonTabComponent_DragComponent("par-tab-title2");
			
			Thread.sleep(5000);
			
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Rich Text Component");
			Thread.sleep(5000);
			
			aahp.clickOnTab_RichTextComponent("par-tab-title2/richtext");
			
			//Click on editor icon
			aahp.clickOnEdit("Edit");
			
			//Click on Full Screen icon
			cfp.click_screenSize("fullscreen#start");
			
			
			//Enter Text when maximized the screen 
			cfp.insertTextInRichTextComponentWhenMaxmized("Test2");
			
			//Select the Rich Text value and Click Style
			aemComponentsObj.SelectAllText_RobotKeys();
			
			
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			cfp.click_RichTextButtons_FormatBoldButton("format#bold");
			
			Thread.sleep(8000);
				
			
			//Click Links Modify button
			cfp.click_RichTextButtons_ModifyLinksButton("links#modifylink");
			//cfp.click_RichTextButtons_LinksModify();
			
			
			
			//Enter Text in Input box
			aemComponentsObj.EnterTextUnderLinksButton("https://www.vmware.com");
			
			//Enter Title
			aemComponentsObj.EnterText_Title("https://www.vmware.com");
			
			
			
			//Click "Open in new page" checkbox
			//aemComponentsObj.OPenInNewPage_Checkbox();
			
			//Click "Open in new page" checkbox
			aemComponentsObj.TabComponent_SelectTarget("Target","New Tab");
			
		
			Thread.sleep(3000);
			
			//Click on Apply button
			aemComponentsObj.clickOnApply();

			
			Thread.sleep(5000);
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");
			
			Thread.sleep(5000); 
			
			//click on preview
			aemPageCreateObj.click_Preview();
			
			//Replace Editor.html with content
			aemComponentsObj.modifyUrl();
			Thread.sleep(5000);
			
			
			aemComponentsObj.ClickTabComponentValue("Title1");
			
			Thread.sleep(5000);
			
			aemComponentsObj.VerifyTabComponentValue("Test1");
			
			aemComponentsObj.ClickTabComponentValue("Title2");
			
			Thread.sleep(5000);
			
			aemComponentsObj.VerifyTabComponentValue("Test2");
			
			
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));

			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();


			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail")){
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
				/*AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
				aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();*/
				
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

