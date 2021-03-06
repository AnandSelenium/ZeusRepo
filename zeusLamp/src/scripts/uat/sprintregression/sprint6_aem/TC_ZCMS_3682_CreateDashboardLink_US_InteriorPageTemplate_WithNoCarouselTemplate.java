package scripts.uat.sprintregression.sprint6_aem;

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
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_3682_CreateDashboardLink_US_InteriorPageTemplate_WithNoCarouselTemplate {

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
	public void TC_ZCMS_3682_CreateDashboardLink_US_InteriorPageTemplate_WithNoCarouselTemplate() throws Exception{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMAssetsPage aemAssestObj=new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);

			ArrayList<String> values=new ArrayList<String>();



			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Thread.sleep(4000);
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/global-content/onlyAutoQA/QAAutoTest89729.html");

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			aemSitesObj.clickOnRequiredSite("US");
			
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSite("VMworld_2016");
			
			//aemSitesObj.clickOnRequiredSite("Automation");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
	
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			Thread.sleep(5000);
			//select page template
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			
			//fill required fields
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(6000);
			

			//Verify Page Created
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
			Thread.sleep(80000);
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			//Click on Insert New Component drop down option as "Site Header"
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Site Header");
			
			Thread.sleep(5000);
			
			oASelFW.driver.navigate().refresh();
			
			
			Thread.sleep(10000);
			
			
			//Double Click on Inserted Component "Site Header"
			aemComponentsObj.DoubleClickonInsertedComponent_Second("Site Header");
			
			
			
			aemComponentsObj.ClickAddField();
			Thread.sleep(2000);
			
			aemComponentsObj.EnterTextField("Tools Label","DashBoard_Tool");  //Link Name
			
			//Enter details on DashBoard Links window
			aemComponentsObj.EnterTextField("Link Label","DashBoard_Link");  //Link Name
			
			aemComponentsObj.EnterTextField_Browse("Link URL","www.vmware.com");  //Link Url
			
			
			aemComponentsObj.SelectRequiredOption("Select URL Open type","New Window");  //Select URL Open type
			
			aemComponentsObj.SelectRequiredOption("Highlight link","Enable");  //Select Highlight link
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			
			oASelFW.driver.navigate().refresh();
			
			Thread.sleep(8000);
			
			//Verify DashBoard Links on Preview Page
			aemComponentsObj.verify_DashBoardLink("DashBoard_Link");
			Thread.sleep(5000);
			
			/*//Click on Page Information
			aemComponentsObj.ClickPageInformation();

			Thread.sleep(10000);
			
			//Click on Publish Page
			aemComponentsObj.ClickPublishPage("Publish Page");
			
			Thread.sleep(3000);

			
			//Verify Page has been successfully published
			aemComponentsObj.VerifyPublishPage_MessageDisplayed();
			
			Thread.sleep(10000);

			String authURL=aemPageCreateObj.getAuthURL();
			
			Thread.sleep(10000);
			
			String publishedURL=aemPageCreateObj.formPublishedURL(authURL);
			System.out.println("publishedURL:"+publishedURL);

			oASelFW.driver.get(publishedURL);
			Thread.sleep(8000);

			//Verify DashBoard Links on Publish Page
			aemComponentsObj.verify_DashBoardLink("DashBoard_Link");*/
			
		
			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			aemAssestObj.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();
			 
			Thread.sleep(5000);
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
	@AfterClass(enabled=true)
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
