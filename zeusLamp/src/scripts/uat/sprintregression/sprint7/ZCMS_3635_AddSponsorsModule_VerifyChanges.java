package scripts.uat.sprintregression.sprint7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMSponsorsPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3635_AddSponsorsModule_VerifyChanges {
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
	public void ZCMS_3635_AddSponsorsModule_VerifyChanges() throws Exception
	{
		try
		{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp                 = new AEMAgendaHeaderPage(oASelFW);
			AEMCallForPage cfp                       = new AEMCallForPage(oASelFW);
			AEMSponsorsPage aemSponsorPage			 = new AEMSponsorsPage(oASelFW);
			AEMAssetsPage aasp 					   	 = new AEMAssetsPage(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			ArrayList<String> values=new ArrayList<String>();

			ArrayList<String> urls=new ArrayList<String>();
			
			//LOGIN
			aemLoginObj.login(userName,Password);

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
			
			Thread.sleep(5000);

			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");
			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(5000);
			
			//Navigating To New Window
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);

			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/global-content/QaAutomationTest/QAAutoTest98014.html");
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Sponsors Header (Manual approach)");
			
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextComponent("Zeus");		

			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("sponsorheader");
			oASelFW.effecta("waitForPageToLoad");
			
			//Sponsor Header Text Title
			cfp.enterComponentDetails("Sponsor Container Heading","SPONSORSHIP - VMWORLD US");
			cfp.enterComponentDetails("Sponsor Level Heading","Sponsor Levels");
			String tabHeader[]={"GlobalDiamond"};
			cfp.clickOnAddfieldAndEnterComponentDetails("Sponsors Tabs", tabHeader,tabHeader.length);
			cfp.clickOnDone();
			
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			//Drag the component "Sponsor Content" for tabHeader ("GlobalDiamond")
			
			for(int i=1;i<=1;i++){
				aemComponentsObj.DoubleClickOnRequiredTabcontentComponent("sponsor-"+i);
				
				Thread.sleep(5000);
				//verify insert new component
				aemComponentsObj.verifyInsertNewComponent();

				//insert the new component from Parsys
				aemComponentsObj.ClickInsertNewComponent_DropdownOption("Sponsor Content (Manual approach)");
				
				//click on inserted site header component
				aemComponentsObj.DoubleClickOnComponent("sponsorcontent");
				oASelFW.effecta("waitForPageToLoad");
				
				//Enter Sponsor Content Details
				cfp.enterComponentDetails("Sponsor Title","VMWARE");  // Enter Sponsor Title
				
				cfp.enterComponentPath("Logo","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg");  //Browse the path of Logo
				
				cfp.enterComponentDetails("Logo Alt Text","Vmware_Alt");  // Enter Logo Alt Text

				cfp.enterComponentPath("Logo UrL","https://www.vmware.com");  //Logo UrL
				
				cfp.selectWindow("Select URL Open type", "New Window");	//Select URL Open type 
				
				cfp.enterComponentPath("Sponsor Banner","/content/dam/digitalmarketing/vmworld/images/sponsor_logo_citrix.jpg");  //Browse the path of Sponsor Banner
				
				cfp.enterComponentDetails("Sponsor Banner Alt Text","Sponsor Banner Alt Text");  // Sponsor Banner Alt Text	
				
				cfp.enterComponentTextAreaDetails("Description","Sample Description");		//Description
				
				cfp.clickOnDone();
				
				Thread.sleep(5000);
				
				
			}
			
			//click on preview
			aemPageCreateObj.click_Preview();
			
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);	
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			
			//Verify Sponsor Container Heading
			aemSponsorPage.VerifySponsorHeaderTitle("SPONSORSHIP - VMWORLD US");
			
			//Verify Rich Text Content
			aemSponsorPage.VerifySponsorContent("Zeus");
			
			//Verify Sponsor Level Heading
			aemSponsorPage.VerifySponsorLevelHeading("Sponsor Levels");
			
			//Verify tabHeader headings
			aemSponsorPage.VerifySponsorTabHeading(tabHeader,tabHeader.length);
			
			//Verify TabTitle section heading
			aemSponsorPage.VerifySponsorTabSectionHeading(tabHeader,tabHeader.length);
			
			//Verify Respective Logo Below Tab Section heading
			aemSponsorPage.VerifySponsorRespectiveLogoBelowHeading("GlobalDiamond","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg");
			
			
			//Verify Sponsor Title
			aemSponsorPage.VerifySponsorLevelHeading("VMWARE");
			
			//Verify Sponsor Description
			aemSponsorPage.VerifySponsorContentDescription("Sample Description");
			
			//Click on Respective Logo
			aemSponsorPage.click_RespectiveLogoAndVerifyPageOpenInNewWindow("GlobalDiamond","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","https://www.vmware.com");
			
			//Verify  Respective sponsor page should be open in a new window
			oASelFW.effecta("selectWindow",wind[2]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
		//	oASelFW.driver.switchTo().defaultContent();
			
			
			
			
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			/*//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}
		}
		catch (Exception e)
		{
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
