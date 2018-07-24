package scripts.uat.sprintregression.sprint8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_2553_TechPapersListingPage{

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
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageObj             = new AEMPageCreation(oASelFW);
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			String username = oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password = oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			//LOGIN
			
			aemLoginObj.login(username, password);

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
			System.out.println("Page Open");
			
			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			Thread.sleep(30000);
			
			//clicking on edit page
			aemPageObj.click_EditPage();
			
			//Click on Drag Components here
			aemComponentObj.ClickDragComponents();
			
			Thread.sleep(5000);
			
			//Verify Insert New Component drop down
			aemComponentObj.verifyInsertNewComponent();
			
			//Click on Insert New Component drop down option
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Three Column Container");
			cfp.editThreeCol();		
			cfp.enterComponentDetails("Title","TECHNICAL PAPERS");
			cfp.descText("threecolumncontainer","Description");
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			//partial width 1
			cfp.clickOnthreecolDragComp("threecolumncontainer","threecolumncontainer1");
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Partial Width Content Card");	
			cfp.clickOnPartialWidth("threecolumncontainer1");
			aemComponentsObj.ClickToggleSidePanel();
			Thread.sleep(5000);
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("vmware-overview-fusion-81-CCD-112.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			cfp.enterComponentDetails("Title","VMware Horizon 6");
			cfp.descText("hcontentcard","Description");
			cfp.clickMenu();
			cfp.enterComponentDetails("CTA Label","Download PDF");
			cfp.enterComponentPath("CTA Link","#");
			cfp.enterComponentDetails("CTA Link Title","Download PDF");
			cfp.selectWindow("Select URL Open type","Same Window");
			cfp.enterDatePicker("Datepicker", "2016-03-28");
			cfp.uncheckVideo("BrightCove Video");
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			//partial width 2
			cfp.clickOnthreecolDragComp("threecolumncontainer","threecolumncontainer2");
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Partial Width Content Card");
			cfp.clickOnPartialWidth("threecolumncontainer2");
			aemComponentsObj.enterTextInput("tech_thumb3.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			cfp.enterComponentDetails("Title","VMware Horizon 6");
			cfp.descText("hcontentcard","Description");
			cfp.clickMenu();
			cfp.enterComponentDetails("CTA Label","Download PDF");
			cfp.enterComponentPath("CTA Link","#");
			cfp.enterComponentDetails("CTA Link Title","Download PDF");
			cfp.selectWindow("Select URL Open type","Same Window");
			cfp.enterDatePicker("Datepicker", "2016-03-28");
			cfp.uncheckVideo("BrightCove Video");
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			//partial width 3
			cfp.clickOnthreecolDragComp("threecolumncontainer","threecolumncontainer3");
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Partial Width Content Card");
			cfp.clickOnPartialWidth("threecolumncontainer3");
			aemComponentsObj.enterTextInput("vmware-fusion-retina-display-spotlight-ccd-112.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			cfp.enterComponentDetails("Title","VMware Horizon 6");
			cfp.descText("hcontentcard","Description");
			cfp.clickMenu();
			cfp.enterComponentDetails("CTA Label","Download PDF");
			cfp.enterComponentPath("CTA Link","#");
			cfp.enterComponentDetails("CTA Link Title","Download PDF");
			cfp.selectWindow("Select URL Open type","Same Window");
			cfp.enterDatePicker("Datepicker", "2016-03-28");
			cfp.uncheckVideo("BrightCove Video");
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			//click on preview
			aemPageCreateObj.click_Preview();
			String authURL=cfp.getAuthURL();
			String publishedURL=cfp.formPublishedURL(authURL);
			System.out.println("publishedURL:"+publishedURL);
			oASelFW.driver.get(publishedURL);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();		
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentObj.verifyTPHeading("TECHNICAL PAPERS");
			aemComponentObj.verifyTPDesc("Description");
			aemComponentObj.verifyPartialWidthHeading("VMware Horizon 6");
			//aemComponentObj.verifyPartialWidthHeading("Description");
			aemComponentObj.verifyImg();
	
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			
			
			//logout
			aemHomeObj.AEMLogout();
				
			
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
