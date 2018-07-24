package scripts.uat.sprintregression.sprint8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMClassicUIPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_2581_Collateral_Validations_Pdf_Download{

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
			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			AEMClassicUIPage aemClassicObj    = new AEMClassicUIPage(oASelFW);
			AEMCustStoryPage aemCustStoryObj  = new AEMCustStoryPage(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			

			Thread.sleep(15000);
			oASelFW.effecta("waitForPageToLoad");
			
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
		
			aemSitesObj.clickOnRequiredSiteTitle("Lamp Apps");
			
			
			aemSitesObj.clickOnRequiredSiteTitle("Customer Stories");
			
			
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
		
			
			String customerStory[]=aemCustStoryObj.createCustomerStory_Modified_Ver1("PDF");
			System.out.println("Customer Story*********** "+customerStory[0]);
			System.out.println("Title*********** "+customerStory[1]);
			System.out.println("Url*********** "+customerStory[2]);
			
			
			aemCustStoryObj.click_Create();
			
			aemCustStoryObj.verifyCreatedcustomerStory(customerStory[0]);
			Thread.sleep(5000);
			
			oASelFW.driver.close();
			Thread.sleep(5000);
		
			
			oASelFW.effecta("selectWindow",win1[0]);
			
			Thread.sleep(5000);
			
			
			aemSitesObj.clickOnlink("Lamp Apps");
			
			//click on Sites
			aemHomeObj.clickSites();
			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.verifySitesPage("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.verifySitesPage("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
	
			Thread.sleep(10000);
			
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			Thread.sleep(5000);
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("HomePage Template");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//Click on Oprn Page
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(5000);

			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));


			oASelFW.effecta("waitForPageToLoad");

			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Listing Customerstories", "Components");
			
			aemComponentsObj.dragAndDropComponents("Listing Customerstories", "Components","");

			
			Thread.sleep(15000);

			String newurl=aahp.getCurrentPageUrlAndRemoveEditor();

			oASelFW.driver.get(newurl);
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
		
			aahp.clickOnPage();
			
			aahp.clickOnLinkUponCustomerStory(customerStory[0], customerStory[1]);
			
			
		//	aahp.verifyDownloadFile("C:\\Users\\automationqauser\\Downloads\\", customerStory[1], "pdf");
			
			
			
			oASelFW.driver.close();
			Thread.sleep(5000);
		
			
			oASelFW.effecta("selectWindow",win1[0]);
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
 