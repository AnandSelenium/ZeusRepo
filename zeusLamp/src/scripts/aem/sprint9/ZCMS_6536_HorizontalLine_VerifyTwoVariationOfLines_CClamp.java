package scripts.aem.sprint9;

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
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_6536_HorizontalLine_VerifyTwoVariationOfLines_CClamp {

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
		try
		{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			AEMAgendaHeaderPage aahp               	 = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                       = new AEMCallForPage(oASelFW);
			UtilityMethods utility					 = new UtilityMethods(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on Sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			Thread.sleep(10000);
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			Thread.sleep(10000);
			aemSitesObj.clickOnRequiredSite("English");
			Thread.sleep(10000);
			aemSitesObj.clickOnRequiredSite("My VMware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			Thread.sleep(5000);
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("PAGE NAME:-"+pageName);
			Thread.sleep(10000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));


			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA/6842Retest.html");
			
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
			cfp.insertTextInRichTextComponentWhenMaxmized("RichText");
			
			// FullScreen Exit
			cfp.click_screenSize("fullscreen#finish");
			cfp.click_ControlSave("control#save");
			Thread.sleep(3000);
			
			//drag components
			aemComponentObj.ClickDragComponents();

			//verify insert new component
			aemComponentObj.verifyInsertNewComponent();
			
			//insert new component
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Horizontal Line");  //Insert Horizontal Line
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("horizontalline");
			Thread.sleep(5000);
			aemComponentObj.verifyConfiguredComponentWindowTitle("Horizontal Line");
			
			//Select Select Skin Type as Gradient Corporate
			aemComponentObj.SelectRequiredOption("Select Skin Type","Gradient Corporate");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(3000);

			//drag components for Freature --Adding Another Component
			aemComponentObj.ClickDragComponents();

			//verify insert new component
			aemComponentObj.verifyInsertNewComponent();
			
			//insert new component
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Features");  //Insert Features
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("featurelistcontainer");
			Thread.sleep(5000);
			
			//Click on Feature List Container Title
			aemComponentObj.Click_requiredLink("Feature List Container Title");
			
			//Enter Feature Title
			aemComponentObj.EnterTextField("Title","Feature");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(3000);
		
			//drag components
			aemComponentObj.ClickDragComponents();

			//verify insert new component
			aemComponentObj.verifyInsertNewComponent();
			
			//insert new component
			aemComponentObj.ClickInsertNewComponent_DropdownOption("Horizontal Line");  //Insert Horizontal Line
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("horizontalline_");
			Thread.sleep(5000);
			aemComponentObj.verifyConfiguredComponentWindowTitle("Horizontal Line");
			
			//Select Select Skin Type as Gradient Corporate
			aemComponentObj.SelectRequiredOption("Select Skin Type","Thin Light Grey");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(3000);
			
			//Click on Preview Button
			aemPageCreateObj.click_Preview();
			Thread.sleep(5000);
			
			//Verify Rich Text Component Text
			aemComponentObj.VerifyRichTextComponentSavedTitle("RichText");
			
			//Verify Features Component Title
			aemComponentObj.VerifyFeatureComponentSavedTitle("Feature");
			
			//Verify Horizontal Line displayed as Thick Green-Blue
			aemComponentObj.VerifyHorizontalLineThickGradient();
			
			//Verify Horizontal Line displayed as Thin Gray
			aemComponentObj.VerifyHorizontalLineThinGray();
			Thread.sleep(3000);
			
			//Navigating To Home Page
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
		
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
