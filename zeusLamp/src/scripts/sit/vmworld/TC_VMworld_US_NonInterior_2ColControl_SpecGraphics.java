package scripts.sit.vmworld;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
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


public class TC_VMworld_US_NonInterior_2ColControl_SpecGraphics{

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
	public void TC_VMworld_US_NonInterior_2ColControl_SpecGraphics() throws Exception
	{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMEditCustomer aemEditObj             = new AEMEditCustomer(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			ArrayList<String> values=new ArrayList<String>();
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//Thread.sleep(4000);
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/global-content/onlyAutoQA/QAAutoTest9386.html");
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
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(6000);
			
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			samp.click_Edit();
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnToggleSidePanel();
			
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(15000);
			
			aemComponentsObj.enterTextInput("Column Control", "Components");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("Column Control", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			
			aemComponentsObj.ClickOnComponent("columncontrol");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);
			
		
			
			//Entering Details
			aemComponentsObj.columnControlEnterDetails("2 Column","2 columns(50%, 50%)");
			
		
			Thread.sleep(5000);
			
			//Click on column control Drag Component
			aemComponentsObj.clickOnColControlDragComponent("par5");
			

			Thread.sleep(5000);
			
			//Select Specialty Graphics
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Specialty Graphics");
			
			aemComponentsObj.ClickOnComponent("specialtygraphics");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			//Verify Speciality Type Link
			aemComponentsObj.VerifyLinkAvailable("Speciality Type");
			
			//Enter Speciality Header
			aemComponentsObj.EnterTextField("Speciality Header","Special Graphics");
			
			//Select Select speciality type option as "4 Image Row"
			aemComponentsObj.SelectRequiredOption("Select speciality type","5 Image Row");
			
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			Thread.sleep(5000);
			
			for(int i=1;i<2;i++)
			{
				
				
				String link_ImageALTText[]= {"AltText1","AltText2","AltText3","AltText4","AltText5"};
				
				
				
				values.add(link_ImageALTText[i-1]);
				
				//Click on Add field
				aemComponentsObj.ClickAddField();
				Thread.sleep(5000);
				aemComponentsObj.EnterMultiTextField("Alt Text",link_ImageALTText[i-1],i);  //Image ALT Text
				
				
				aemComponentsObj.enterTextInput("supermicro.png", "Assets");
				Thread.sleep(5000);
				
				aemComponentsObj.dragAndDropComponents_Multi("", "Assets","Image Path",i);
				
				Thread.sleep(3000);
				
				
			}
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(3000);

			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);

			
			//Verify Column Control title
			aemComponentsObj.VerifyColumnControlTitle("2 Column");
			//Verify Image
			aemComponentsObj.VerifySpecialityGraphicsImage("Special Graphics","supermicro.png",1);
			/*aemComponentsObj.VerifySpecialityGraphicsImage("Special Graphics","supermicro.png",2);
			aemComponentsObj.VerifySpecialityGraphicsImage("Special Graphics","supermicro.png",3);
			aemComponentsObj.VerifySpecialityGraphicsImage("Special Graphics","supermicro.png",4);
			aemComponentsObj.VerifySpecialityGraphicsImage("Special Graphics","supermicro.png",5);
		*/
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			
			AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
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
