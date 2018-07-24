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
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_VMware_L4_Enterprise_Component1{

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
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp                = new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);


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
			Thread.sleep(15000);

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
			Thread.sleep(15000);

			//##########################_Contact us with google maps_STARTS_###############################//
			System.out.println("Contact us with google maps_STARTS");

			aemComponentsObj.clickOnToggleSidePanel();
		
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(15000);
			
			aemComponentsObj.enterTextInput("Contact Us With Google Maps", "Components");
			
			aemComponentsObj.dragAndDropComponents("Contact Us With Google Maps", "Components","");
			
			aahp.clickTextComponent("Contact Us With Google Maps");
			
			aahp.clickOnEdit("Edit");

			aahp.clickOnTool("fullscreen#start");

			aahp.verifyButtonInComponents();

			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(8000);
			
			System.out.println("Contact us with google maps_ENDS");

			//##########################Contact us with google maps_ENDS_###############################//



			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			
			Thread.sleep(15000);
			
			//#############################_Horizontal Line_Ends_######################//

			//**********************Small Card Component STARTS********************************
			System.out.println("Small Card Component STARTS");

			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Small Card Component", "Components");
			
			aemComponentsObj.dragAndDropComponents("Small Card Component", "Components","");
		
			oASelFW.driver.navigate().refresh();	
			oASelFW.effecta("waitForPageToLoad");

			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Small Card Component");
			Thread.sleep(3000);

			aemComponentsObj.EnterTextField("Title", "Test News");  //Enter Title
			aemComponentsObj.EnterTextField_Browse("URL", "/content/dam/digitalmarketing/vmware/en/images/products/fusion/vmware-overview-fusion-81-CCD-112.jpg");//Enter Url
			aemComponentsObj.TargetSelectWindow("URL Target","New Window");   //Select URL Target
			aemComponentsObj.TargetSelectWindow("Choose the Icon","News");  //Select Choose the Icon "News
			aemComponentsObj.TargetSelectWindow("Display Style","blueBackground");  //Select Display  Style
			aemComponentsObj.ClickSaveIcon();   //Save
			Thread.sleep(5000);

			System.out.println("Small Card Component ENDS");

			//**********************Small Card Component 2 ENDs ********************************
			
			
			//#############################_Horizontal Line_STARTS_######################//

			System.out.println("Horizontal Line_STARTS");

			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			
			Thread.sleep(15000);
			
			//#############################_Horizontal Line_Ends_######################//
			
		/*	//#############################_3 column container_Starts_######################//

			System.out.println("3 column container STARTS");


			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Three Column Container", "Components");
			aemComponentsObj.dragAndDropComponents("Three Column Container", "Components","");
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickOnComponent("threecolumncontainer1");
			
			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Features");		
			Thread.sleep(10000);
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Features");
			Thread.sleep(10000);
			
			//Click on Container Level PDF in Feature List Container window
			aemComponentsObj.Click_FeatureListContainer_ContainerLevelPDF_Link();
			
			//Details
			aemComponentsObj.FeatureListContainerProperties("Link Label","Testqa");
			aemComponentsObj.FeatureListContainerProperties("Link Title","Testqa_Pdf");
			aemComponentsObj.FeatureListContainerProperties_LinkUrl("Link URL","/content/dam/digitalmarketing/vmware/en/pdf/analysis/socialcast/vmw-idc-marketscape-social-vendor-analysis.pdf");
			aemComponentsObj.FeatureListContainerProperties_SelectTargetWindow("New Window");
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(8000);*/
			
			//**********************3 column container ENDS********************************

			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentObj.rolloutOps();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
				
			
			aemComponentsObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			
			
			
			oASelFW.driver.get("http://www-test15.vmware.com/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA/"+pageName+".html");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
		
			
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
