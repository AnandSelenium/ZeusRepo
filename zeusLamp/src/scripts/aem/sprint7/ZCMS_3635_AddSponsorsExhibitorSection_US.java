package scripts.aem.sprint7;

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

public class ZCMS_3635_AddSponsorsExhibitorSection_US {
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
	public void ZCMS_3635_AddSponsorsExhibitorSection_US() throws Exception
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
			
			
			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("US");
			
			aemSitesObj.clickOnRequiredSite("test");
			Thread.sleep(3000);
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
			Thread.sleep(5000);

			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/global-content/QaAutomationTest/QAAutoTest98014.html");
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
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
			String tabHeader[]={"Exhibitor"};
			cfp.clickOnAddfieldAndEnterComponentDetails("Sponsors Tabs", tabHeader,tabHeader.length);
			cfp.clickOnDone();
			
			Thread.sleep(3000);
			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.DoubleClickOnRequiredTabcontentComponent("sponsor-1");
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();
			Thread.sleep(8000);
			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Sponsor Logos (Manual approach)");
			
			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("sponsorlogos");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
			
			//Enter details
			for(int i=1;i<7;i++)
			{
				
				String logo[]= {"/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","/content/dam/digitalmarketing/vmworld/images/img-speaker-raghu.jpg","/content/dam/digitalmarketing/vmworld/images/img-speaker-tom.jpg","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg"};
				String logoUrl[]= {"https://vmware.com","https://vmworld.com","https://vmware.com","https://vmworld.com","https://vmworld.com","https://vmworld.com"};
				String LogoAltText[]= {"Alt_Text1","Alt_Text2","Alt_Text3","Alt_Text4","Alt_Text5","Alt_Text6"};
				
				
				values.add(logo[i-1]);
				
				urls.add(logoUrl[i-1]);
				
				System.out.println("Array index: "+logo[i-1]);
				System.out.println("Multi Browser Array index: "+logoUrl[i-1]);
			
				//Click on Add field
				aemComponentsObj.ClickAddField();
				
				aemComponentsObj.EnterMultiTextField_Browse("Logo",logo[i-1],i);  //Logo
				
				aemComponentsObj.EnterMultiTextField_Browse("Logo UrL",logoUrl[i-1],i);  //Logo Url
				
				aemComponentsObj.EnterMultiTextField("Logo Alt Text",LogoAltText[i-1],i);  //Logo Alt Text
				
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","New Window",i);  //Select URL Open type
			
			}
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			//click on preview
			aemPageCreateObj.click_Preview();
			
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);	
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			
			String logo[]= {"/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","/content/dam/digitalmarketing/vmworld/images/img-speaker-raghu.jpg","/content/dam/digitalmarketing/vmworld/images/img-speaker-tom.jpg","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg","/content/dam/digitalmarketing/vmworld/images/img-crowds-03.jpg"};
			String logoUrl[]= {"https://vmware.com","https://vmworld.com","https://vmware.com","https://vmworld.com","https://vmworld.com","https://vmworld.com"};
			String LogoAltText[]= {"Alt_Text1","Alt_Text2","Alt_Text3","Alt_Text4","Alt_Text5","Alt_Text6"};
			
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
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[0],"Exhibitor",1); 
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[1],"Exhibitor",2); 
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[2],"Exhibitor",3); 
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[3],"Exhibitor",4); 

			aemSponsorPage.verify_Sponsors_ListImages(logo[4],"Exhibitor",5); 
			
			aemSponsorPage.verify_Sponsors_ListImages(logo[5],"Exhibitor",6); 
			
			Thread.sleep(5000);
			
			//oASelFW.driver.switchTo().defaultContent();
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			//oASelFW.driver.navigate().refresh();
			Thread.sleep(2000);
			
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
