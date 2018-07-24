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

public class ZCMS_5746_VerifyHomePagePromoComponent_InPreview {

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
	public void ZCMS_5746_VerifyHomePagePromoComponent_InPreview() throws Exception{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			AEMAssetsPage aasp 					   	 = new AEMAssetsPage(oASelFW);
			UtilityMethods utility					 =new UtilityMethods(oASelFW);
			
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
			
			aemSitesObj.clickOnRequiredSite("My_VMware");
	
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
			
			//Drag and Drop Component
			//aemComponentsObj.dragAndDropComponents("Home Page Hero Carousel","Components","");
			Thread.sleep(5000);

			//Verify Insert New Component dropdown
			aemComponentsObj.verifyInsertNewComponent();

			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("VMWare Home Page Promo");
			
			//Double Click on Inserted Component
			aemComponentObj.DoubleClickOnComponent("homepagepromo");
			
			//Click on Left Column
			aemComponentObj.Click_requiredLink("Left Column");
			
			//Select Backround color
			aemComponentObj.SelectRequiredOption_Left_RightBackgroundColor("Background Color","Blue","Left");
			
			//Enter Title
			aemComponentObj.EnterTextField_Left_Right("Title","HomePage_LeftColumn","left");
			
			//Enter Body
			aemComponentObj.EnterTextArea_Left_Right("Body","Vmware Home Page Window","left");
			
			//Enter Link Title
			aemComponentObj.EnterTextField_Left_Right("CTA Label","Vmware Link Page Title","left");
			
			//Enter Link
			aemComponentObj.EnterTextField_Browse_Left_Right("CTA URL","https://www.vmware.com","left");
			
			//Select Click behaviour window
			aemComponentObj.SelectRequiredOption_Left_Right("Click Behaviour","New Window","left");
			
			
			//Click on Toggle Side Panel
			aemComponentsObj.ClickToggleSidePanel();
			Thread.sleep(5000);
			
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			
			//Drage and drop Image to Image Asset
			aemComponentsObj.dragAndDrop_Image_To_RequiredImageAsset("slideHero-3.jpg");
			Thread.sleep(5000);
			
			
			
			//Click on Right Column
			aemComponentObj.Click_requiredLink("Right Column");
			
			//Select Backround color
			aemComponentObj.SelectRequiredOption_Left_RightBackgroundColor("Background Color","Green","Right");
			
			//Enter Title
			aemComponentObj.EnterTextField_Left_Right("Title","HomePage_RightCloumn","right");
			
			//Enter Body
			aemComponentObj.EnterTextArea_Left_Right("Body","Vmworld Home Page Window","right");
			
			//Enter Link Title
			aemComponentObj.EnterTextField_Left_Right("CTA Label","Vmworld Link Page Title","right");
			
			//Enter Link
			aemComponentObj.EnterTextField_Browse_Left_Right("CTA URL","/content/vmware/language-master-sites/en","right");
			
			//Select Click behaviour window
			aemComponentObj.SelectRequiredOption_Left_Right("Click Behaviour","Same Window","right");
			
			
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			
			
			//Verify Home Page Title for the left column
			//aemComponentObj.VerifyHomePagePromo_Title("HomePage_RightCloumn");
			
			//Verify Home Page Body for the left column
		//	aemComponentObj.VerifyHomePagePromo_Body("Vmware Home Page Window");
			
			//Verify Home Page Promo Link Title
			aemComponentObj.VerifyHomePagePromo_Link_InPreview("Vmware Link Page Title");
			
			aemComponentObj.ClickHomePagePromo_LinkInPreview("Vmware Link Page Title");
			
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(2));
			
			//Verify the External Link Behaviour for Left Column
			aemComponentObj.VerifyHomePagePromo_Link_ExternalBehaviour("https://www.vmware.com");
			
			oASelFW.driver.close();
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			
			//Verify Home Page Title for the Right column
			//aemComponentObj.VerifyHomePagePromo_Title("HomePage_LeftColumn");
			
			//Verify Home Page Body for the Right column
			//aemComponentObj.VerifyHomePagePromo_Body("Vmworld Home Page Window");
			
			//Verify Home Page Promo Right Title
			aemComponentObj.VerifyHomePagePromo_Link_InPreview("Vmworld Link Page Title");
			
			aemComponentObj.ClickHomePagePromo_LinkInPreview("Vmworld Link Page Title");
			
			Thread.sleep(5000);
			
			
			//Verify the Internal  Link Behaviour for Right Column
			aemComponentObj.VerifyHomePagePromo_Link_InternalBehaviour("/content/vmware/language-master-sites/en");
			
			Thread.sleep(5000);
			
			//oASelFW.driver.navigate().back();
			
			oASelFW.driver.close();
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			Thread.sleep(5000);
			 
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
