package scripts.uat.sprintregression.sprint8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMCallForPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_1837_CClamp
{

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
			AEMCallForPage cfp                     = new AEMCallForPage(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			
			String username = oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password = oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			//LOGIN
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8081");
			aemLoginObj.login(username, password);
			
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
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);
			
			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");
			
			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");
			System.out.println("Page Open");
			
			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
		
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Carousel");

			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("carousel");
			
			//Heading 1
			aemComponentsObj.Click_requiredLink("Transition Section");
			aemComponentsObj.transitionSection("Transition off/on");
			
			//Heading 2
			aemComponentsObj.Click_requiredLink("Icons");
			
			//link1
			cfp.clickAddField("Carousel Icons");
			aemComponentsObj.ClickToggleSidePanel();
			Thread.sleep(5000);
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("slideHero-3.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Icons");
			cfp.clickAddField("Carousel Icons");
			
			//Heading 3
			aemComponentsObj.Click_requiredLink("Carousel Properties");
			cfp.enterComponentDetails("View All Title","View All Title");
			cfp.enterLogo("View All Url","https://google.com");
			cfp.selectWindow("Select URL Open type","Same Window");
			cfp.enterComponentDetails("Carousel Heading","Carousel Heading");
			
			//Click Done
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("carouselContent1");
			cfp.enterComponentDetails("Carousel Title","CarouselTitle1");
			cfp.enterDescription("Carousel Description","Data Validation");
			cfp.enterComponentDetails("CTA Label","Validity");
			cfp.enterLogo("CTA URL","/content/vmware/language-master-sites/en/onlyQA/Reventh/ZCMS6460_Retest");
			cfp.selectWindow("Select URL Open type","New Window");
			aemComponentsObj.enterTextInput("vmware-desktop-related-assets1-ccd-1030.jpg", "Assets");
			aemComponentsObj.dragAndDropComponents("", "Assets","Background Image");
			cfp.clickOnDone();
			Thread.sleep(3000);
			
			
			aemPageCreateObj.click_Preview();
			String authURL=cfp.getAuthURL();
			String publishedURL=cfp.formPublishedURL(authURL);
			System.out.println("publishedURL:"+publishedURL);
			oASelFW.driver.get(publishedURL);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();		
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.VerifyCarousel_Title("CarouselTitle1");
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			//logout
			aemHomeObj.AEMLogout();
				
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
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}