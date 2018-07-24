package scripts.aem.sprint6;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_3623_FullWidth_Add4Graphics{

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
	public void ZCMS_3623_FullWidth_Add4Graphics() throws Exception
	{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMEditCustomer aemEditObj             = new AEMEditCustomer(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			Thread.sleep(5000);
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/global-content/onlyAutoQA/QAAutoTest69666.html");

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");

			aemSitesObj.clickOnRequiredSite("en");
			
			//Click on US
			aemSitesObj.clickOnRequiredSite("US");
			
			
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");

			
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(6000);
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(10000);

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			
		/*	
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			*/
			//Switch to tab
			//Thread.sleep(8000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			oASelFW.effecta("waitForPageToLoad");

			Thread.sleep(10000);
			
			samp.click_Edit();
			//drag components
			aemComponentsObj.ClickDragComponents();

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();
			
			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Column Control");

			//double click on component to add fields
			aemComponentsObj.DoubleClickOnComponent("columncontrol");
			
			
			
			//Entering Details with fullWidth Component(1 column(100%))
			aemComponentsObj.columnControlDetails("1 column(100%)");
			
			//Click on column control Drag Component
			aemComponentsObj.clickOnColControlDragComponent("par2");
			
			Thread.sleep(5000);
			
			//Select Specialty Graphics
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Specialty Graphics");
			
			//Click on Specialty Graphics Component
			aemComponentsObj.DoubleClickOnComponent("specialtygraphics");
			
			//Verify Speciality Type Link
			aemComponentsObj.VerifyLinkAvailable("Speciality Type");
			
			//Enter Speciality Header
			aemComponentsObj.EnterTextField("Speciality Header","Special Graphics");
			
			//Select Select speciality type option as "4 Image Row"
			aemComponentsObj.SelectRequiredOption("Select speciality type","4 Image Row");

			//Click on Add field
			aemComponentsObj.ClickAddField();
			
			//Enter Alt Text
			aemComponentsObj.EnterTextField("Alt Text","Image Row");
			
		
			aemComponentsObj.ClickToggleSidePanel();
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.enterTextInput("HP_Circle_Logo_50x50.JPG", "Assets");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");
			
			
			
			Thread.sleep(5000);
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);

			
			//oASelFW.driver.switchTo().frame("ContentFrame");
			/*oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			*/
			
			
			//Verify Image
			aemComponentsObj.VerifyImage("HP_Circle_Logo_50x50.JPG");
			
			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			
			Thread.sleep(3000);
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();
			//Logout
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
