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
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_VMware_L4Enterprise_Component5{

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
			
			//##########################Compare table Starts###############################//
			System.out.println("Compare table Starts");
			
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);
			aemComponentsObj.enterTextInput("Compare Table", "Components");
			aemComponentsObj.dragAndDropComponents("Compare Table", "Components","");
			aahp.clickTextComponent("Compare Table");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Feature Heading in Comparision Table
			aemComponentsObj.ComparisionTableHeaderProperties("Feature Heading","Paramenter");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 1 Heading","Test 1");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 2 Heading","Test 2");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 3 Heading","Test 3");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 4 Heading","Test 4");
			for(int i=1;i<=3;i++)
			{
				Thread.sleep(5000);
				//Click on Add field
				aemComponentsObj.ClickAddField();

				//Enter Tool Tip
				aemComponentsObj.ComparisionToolTip("Tooltip Text","Show Details 1",i);
				aemComponentsObj.ComparisionTableProperties("Feature Name","Speed",i);
				aemComponentsObj.ComparisionTableProperties("Column 1 Text","80km/hr",i);
				aemComponentsObj.ComparisionTableProperties("Column 2 Text","100km/hr",i);
				aemComponentsObj.ComparisionTableProperties("Column 3 Text","70km/hr",i);
				aemComponentsObj.ComparisionTableProperties("Column 4 Text","90km/hr",i);

				//Column 1 Feature (Dropdown Yes/No)
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 1 - Feature Present?","YES",i);
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 2 - Feature Present?","NO",i);
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 3 - Feature Present?","YES",i);
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 4 - Feature Present?","YES",i);
			}

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			System.out.println("Compare table ends");

			//##########################_Compare table ends_###############################//
			
			//#############################_Horizontal Line_STARTS_######################

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);

			//#############################_Horizontal Line_Ends_######################
			
			//#############################_Features_Starts_######################
			
			System.out.println("Feature Column 1 starts");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);
			aemComponentsObj.enterTextInput("Features", "Components");
			aemComponentsObj.dragAndDropComponents("Features", "Components","");
			aahp.clickTextComponent("Features");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
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
			//#############################_Features_Ends_######################
			
			//#############################_Horizontal Line_STARTS_######################

			System.out.println("Horizontal Line_STARTS");
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Horizontal Line", "Components");
			aemComponentsObj.dragAndDropComponents("Horizontal Line", "Components","");
			Thread.sleep(15000);

			//#############################_Horizontal Line_Ends_######################
			
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
			Thread.sleep(10000);
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

			//Verify ToolTip
			aemComponentsObj.VerifyToolTipText("Show Details 1",pageName);	

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
