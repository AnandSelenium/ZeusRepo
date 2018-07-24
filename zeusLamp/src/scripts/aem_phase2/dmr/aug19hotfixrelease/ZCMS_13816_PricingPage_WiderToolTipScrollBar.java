package scripts.aem_phase2.dmr.aug19hotfixrelease;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_13816_PricingPage_WiderToolTipScrollBar {

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
	public void ZCMS_13816_PricingPage_WiderToolTipScrollBar() throws Exception{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMAssetsPage aasp = new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
		
			String notificatioDevUrl = utility.getValuesFromPropertiesFile("constant", "Notifications_DevUrl");
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			String tooltip1=utility.getValuesFromPropertiesFile("constant", "VMworld_TooltipValue");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			//aemHomeObj.verifyHomePage();
			//Thread.sleep(4000);
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/global-content/onlyAutoQA/QAAutoTest74525.html");
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
			
			//Click on US
			aemSitesObj.clickOnRequiredSite("US");
			
			
			
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("Learning");
			
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

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);


			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Navigating To New Window
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//drag components
			aemComponentsObj.clickOnToggleSidePanel();
			System.out.println("Pricing Header");

			//aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);

			aemComponentsObj.enterTextInput("Pricing Header", "Components");
			aemComponentsObj.dragAndDropComponents("Pricing Header", "Components","");
			
			aemComponentsObj.clickOnToggleSidePanel();
			
			Thread.sleep(3000);
			samp.click_DragComponent_insidePriceHeader();
			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Pricing Details component");
			//samp.drag_drop("Pricing Details component");
			//double click on component to add fields
			//aemComponentsObj.DoubleClickonInsertedComponent("Pricing Details component");*/
			Thread.sleep(3000);
			
			//single click on element
			samp.single_click_PriceHeader_Europe("pricingheader");
			Thread.sleep(3000);

			//Click on configure tool
			samp.click_onTool("Configure");

			Thread.sleep(3000);
			samp.enter_PricingHeader("US","test123");
			
			Thread.sleep(3000);

			samp.single_click_Component("Pricing Details component");

			//Click on configure tool
			samp.click_onTool("Configure");
			
			Thread.sleep(3000);
			
			aemComponentsObj.EnterTextField("Type of Pass","Type of Pass value");
			
			//Click on Add field
			aemComponentsObj.ClickAddField();
			
			aemComponentsObj.EnterTextField("Package Type","Package Type1");
			
			aemComponentsObj.EnterTextArea("Tooltip Text",tooltip1);
			
			aemComponentsObj.EnterTextField_Browse("Pricing page URL", "https://www.vmware.com");
			
			aemComponentsObj.EnterTextField("Early Bird Price","Early Bird Price");
			
			aemComponentsObj.SelectRequiredOption("URL Target","New Window");
			
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			


			//Click on Preview
			samp.click_preview();
			Thread.sleep(3000);
			
			
			/*oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);*/
			
			
			aemComponentsObj.VerifyToolTipText_Pricing("Package Type1",tooltip1);	
			
			aemComponentsObj.Verify_Tooltip_ScrollBar();
			
		/*	Thread.sleep(5000);
			String pageUrl_Preview=oASelFW.driver.getCurrentUrl();
			System.out.println("Page Url--"+pageUrl_Preview);
		

			oASelFW.driver.get(pageUrl_Preview);*/
			
			/*Thread.sleep(10000);
			String pageUrl=oASelFW.driver.getCurrentUrl();
			System.out.println("Page Url--"+pageUrl);
		
			//Click on Page Information
			aemComponentsObj.ClickPageInformation();
			Thread.sleep(5000);
			
			//Click on Start Workflow
			aemComponentsObj.ClickPublishPage("Start Workflow");
			Thread.sleep(3000);
			
			//Select Work flow option
			aemComponentsObj.SelectWorkflowModelOption("VMWorld Pre Prod Deployment Workflow");
			Thread.sleep(3000);
			
			//Click on Start Workflow button
			aemComponentsObj.ClickStartWorkflowButton();
			
			//Verify Workflow Started Message
			aemComponentsObj.VerifyWorkflowStartedMessageDisplayed();
			Thread.sleep(3000);
			
			//Navigate to notifications url
			aemComponentsObj.modifyUrlWithNotifications();
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			//Verify Notification  window
			aemComponentsObj.VerifyNotificationWindow();
			
			//Click required workflow check box
			aemComponentsObj.ClickRequiredNotificationsCheckbox(pageName,"VMWorld Pre Prod Deployment Workflow");
			Thread.sleep(10000);
			
			//Click on Complete
			aemComponentsObj.ClickNotificationComplete();
			Thread.sleep(10000);
			
			//Select  Workflow User
			aemComponentsObj.SelectWorkflowUser("VMworld test");
			Thread.sleep(5000);
			//Click on Complete
			aemComponentsObj.ClickWorkflowNotificationComplete();
			Thread.sleep(5000);
			oASelFW.driver.get(notificatioDevUrl);
			Thread.sleep(5000);
			String devUrl=oASelFW.driver.getCurrentUrl();
			System.out.println("Dev Url---"+devUrl);
			System.out.println("Page Url--"+pageUrl);
			
			//Navigate to Workflow Url--dev-doc3
			aemComponentsObj.modifyUrlWithNotifications(pageUrl, devUrl);
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			aemComponentsObj.VerifyToolTipText_Pricing(tooltip1);
			
			
			
*/

			oASelFW.driver.close();
		
			Thread.sleep(3000);
			oASelFW.driver.switchTo().window(tabs.get(0));
			
			//DELETE FOLDER
			/*aasp.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();*/
			 
			//LOGOUT
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
