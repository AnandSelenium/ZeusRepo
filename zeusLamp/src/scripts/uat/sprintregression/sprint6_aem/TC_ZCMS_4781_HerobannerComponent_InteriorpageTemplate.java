package scripts.uat.sprintregression.sprint6_aem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_4781_HerobannerComponent_InteriorpageTemplate {
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
	public void TC_ZCMS_4781_HerobannerComponent_InteriorpageTemplate() throws Exception{
		
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
			AEMEditCustomer aemEditObj  = new AEMEditCustomer(oASelFW);

			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			Thread.sleep(4000);
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/QAAutoTest60273.html");
			//Verify Home Page
			//aemHomeObj.verifyHomePage();


			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			aemSitesObj.clickOnRequiredSite("Europe");
			
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSite("VMworld_2016");
			
			//aemSitesObj.clickOnRequiredSite("Automation");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page");

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
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Hero Banner");

			//click on inserted site header component
			aemComponentsObj.DoubleClickonInsertedComponent("Hero Banner");
			
			//Enter banner details
			aemEditObj.enter_bannerDetails("US");
			Thread.sleep(5000);
			
			//Click on Toggle
			aemComponentsObj.ClickToggleSidePanel();
			
			//Enter Image Details of Banner
			aemPageCreateObj. insert_Images_HeroBannerComponents1("HP_Circle_Logo_50x50.JPG","Image Alt Text");

			//Click ON Done 3
			aemPageCreateObj.click_PageHeader_tick();


			//GET alt attribute 

			//String altText=oASelFW.driver.findElement(By.xpath("//img[@src='hero_image_full1.jpg']")).getAttribute("alt");


			//Click Preview Button
			samp.click_preview();

			oASelFW.driver.switchTo().frame("ContentFrame");

			//Verify Banner Components
			aemPageCreateObj.verify_HeroBannerComponents("Image Alt Text");



			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 



			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();

			Thread.sleep(10000);
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

