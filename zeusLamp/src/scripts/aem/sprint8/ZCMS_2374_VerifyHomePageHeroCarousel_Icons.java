package scripts.aem.sprint8;

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
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_2374_VerifyHomePageHeroCarousel_Icons {

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
	public void ZCMS_2374_VerifyHomePageHeroCarousel_Icons() throws Exception{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			UtilityMethods utility=new UtilityMethods(oASelFW);
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			String destinationLocator=oASelFW.getConstValFrmPropertyFile("destinationLocator");
			
			String sourceImage="slideHero-3.jpg";
			
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
			
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			
			aemSitesObj.clickOnRequiredSite("English");
			

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
		
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("HomePage Template");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("PAGE NAME:-"+pageName);
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);

		
			//Click on Drag Components here
			aemComponentsObj.ClickDragComponents();
		
			Thread.sleep(5000);

			//Verify Insert New Component dropdown
			aemComponentsObj.verifyInsertNewComponent();

			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Home Page Hero Carousel");
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("herocarousel");
			
			Thread.sleep(5000);
			
			//Click on Carousel Tab Details
			aemComponentObj.Click_requiredLink("Carousel Tab Details");
			
			//Click on Add field
			aemComponentsObj.ClickAddField();
		
			ArrayList<String> values=new ArrayList<String>();

			ArrayList<String> title=new ArrayList<String>();
			
			for(int i=1;i<4;i++)
			{
				String IconTitle[]= {"Carousel Section 1","Carousel Section 2","Carousel Section 3"};
				
				String iconvalue[]={"Checklist","Alert","Bar Chart"};
			
				values.add(iconvalue[i-1]);
				
				title.add(IconTitle[i-1]);
				
				//Click on Add field
				aemComponentsObj.ClickAddField();
				
				Thread.sleep(3000);
				
				aemComponentsObj.EnterMultiTextField("Title",IconTitle[i-1],i);  //Title
				
				//aemComponentsObj.EnterMultiButtonField("Please Select",i);  //Click Please Select
				Thread.sleep(8000);
				
				aemComponentsObj.SelectMultiRequiredOption("Select Tab Icon",iconvalue[i-1],i);  //Select Tab Icon
				Thread.sleep(8000);
			}
			
			
			
		
			
			//Click on Carousel Note Section
			aemComponentObj.Click_requiredLink("Carousel Note Section");
			
			//Enter Note
			aemComponentObj.EnterTextField("Note","Test Note");
			
			//Select Note Icon
			aemComponentObj.SelectRequiredOption("Note Icon","Business");
			
			//Enter Note URL
			aemComponentObj.EnterTextField_Browse("Note URL","https://www.vmware.com");
			
			
			//Select Select URL Open Type
			aemComponentObj.SelectRequiredOption("Select URL Open Type","New Window");
			
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("heroCarouselTabs1");
			Thread.sleep(5000);
			
			//Select Carousel Slider Skin Type
			aemComponentObj.SelectRequiredOption("Carousel Slider Skin Type","Gray");
			
			//Click on Toggle Side Panel
			aemComponentsObj.ClickToggleSidePanel();
			Thread.sleep(5000);
			
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			//aemComponentsObj.enterTextInput("Capture1.JPG", "Assets");
			
			//Drage and drop Image to Image Asset
			aemComponentsObj.dragAndDrop_Image_To_RequiredImageAsset("slideHero-3.jpg");
			Thread.sleep(5000);
			
			
			//Enter Carousel Title
			aemComponentObj.EnterTextField("Carousel Title","Vmware Home Page");
			
			

			//Enter Carousel Description
			aemComponentObj.EnterTextArea("Carousel Description","Vmware Home Page Description");
			
			
			//Enter CTA Title
			aemComponentObj.EnterTextField("CTA Title","Login CTA Button");
			
			
			//Select CTA Button Color
			aemComponentObj.SelectRequiredOption("CTA Button Color","Green");
			
			//Enter Note URL
			aemComponentObj.EnterTextField_Browse("CTA URL","https://www.facebook.com");
			
			Thread.sleep(3000);
			
			//Select Select URL Open Type
			aemComponentObj.SelectRequiredOption("Select URL Open type","New Window");
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
		
			
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//Verify Carousel Title
			
			aemComponentObj.VerifyHomePageHeroCarousel_Note("Test Note");
			
			
			String IconTitle[]= {"Carousel Section 1","Carousel Section 2","Carousel Section 3"};
			
			String iconvalue[]={"Checklist","Alert","Bar Chart"};
			
			aemComponentObj.VerifyHomePageHeroCarousel_MultipleTabIcon(iconvalue[0], 1);
			
			aemComponentObj.VerifyHomePageHeroCarousel_MultipleTabIcon(iconvalue[1], 2);
			
			aemComponentObj.VerifyHomePageHeroCarousel_MultipleTabIcon(iconvalue[2], 3);
			
			
			
			
			
			//Verify CTA Button link behaviour is external
			
			//aemComponentObj.ClickHomePageHeroCarousel_CTATitle("Login CTA Button");
			
			Thread.sleep(5000);
			
			aemComponentObj.ClickHomePageHeroCarousel_CTATitle_LinkBehaviour("Test Note", "https://www.vmware.com");
			
			
			Thread.sleep(5000);
			oASelFW.driver.close();
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
				
			 
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
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
