package scripts.sit.vmware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_VMware_L4_Enterprise_Component2{

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
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp                = new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentObj     = new AEMComponentCreation(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj  = new AEMPartnerLoginPage(oASelFW);
		

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");


			//LOGIN
			aemLoginObj.login(userName,Password);

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
			aemSitesObj.clickOnRequiredSite("My VMware");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMWare L4 Enterprise Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//##########################_Two Column Container_01###############################//
			System.out.println("Contact us with google maps_STARTS");

			aemComponentsObj.clickOnToggleSidePanel();
		
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickOnComponent("columncontainer");

			//details
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container		
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Spotlight Gradient Blue");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");		//Select Radio button 'Yes'
	

			//Save
			aemComponentsObj.ClickSaveIcon();	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//#####################################Partial Width Content Card##############################
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Partial Width Content Card", "Components");
			
			aemComponentsObj.dragAndDropComponents_Twocolumn("Partial Width Content Card", "Components","",1,4);
			
			aahp.clickInsertedComponent("hcontentcard");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			aemComponentsObj.enterTextInput("img-kbyg-vmw-booth-02.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);

			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Partial_Width_Content_Card_1_CTA_LABEL");
			Thread.sleep(5000);

			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 

			aemComponentsObj.ImageProperties_Horizontal("CTA Link Title","Partial_Width_Content_Card_1_CTA_LINK TITLE");
			Thread.sleep(5000);

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//#####################################Partial Width Content Card##############################
			
			//#####################################Brief Text Card##############################
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Brief Text Card", "Components");
			
			aemComponentsObj.dragAndDropComponents_Twocolumn("Brief Text Card", "Components","",1,2);
			
			aahp.clickInsertedComponent("briefcontentcard");
		
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//fill fields in Brief Text Card
			aemstranlationObj.fillFieldsInBreifTextCard("New Window");
			Thread.sleep(10000);
			
			
			//#####################################Brief Text Card##############################
			
			//##########################_Two Column Container_01###############################//
		
			

			//##########################_Two Column Container_02###############################//
	

			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickOnComponent("columncontainer");

			//details
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container		
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Spotlight Gradient Blue");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");		//Select Radio button 'Yes'
	

			//Save
			aemComponentsObj.ClickSaveIcon();	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//#####################################Partial Width Content Card##############################
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Partial Width Content Card", "Components");
			
			aemComponentsObj.dragAndDropComponents_Twocolumn("Partial Width Content Card", "Components","",2,4);
			
			aahp.clickInsertedComponent("hcontentcard");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			aemComponentsObj.enterTextInput("img-kbyg-vmw-booth-02.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);

			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Partial_Width_Content_Card_1_CTA_LABEL");
			Thread.sleep(5000);

			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 

			aemComponentsObj.ImageProperties_Horizontal("CTA Link Title","Partial_Width_Content_Card_1_CTA_LINK TITLE");
			Thread.sleep(5000);

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//#####################################Partial Width Content Card##############################
			
			//#####################################FULL_WIDTH_CONTENT_CARD_STARTS##############################
			
			System.out.println("FULL_WIDTH_CONTENT_CARD_STARTS");

	
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(8000);

			aemComponentsObj.enterTextInput("Full Width Content Card", "Components");
			
			aemComponentsObj.dragAndDropComponents_Twocolumn("Full Width Content Card", "Components","",2,2);
			
			aahp.clickTextComponent("Full Width Content Card");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//Fill the required Image Properties

			//Title
			aemComponentsObj.ImageProperties_Horizontal("Title","WE EMPOWER a brave new it.");
			Thread.sleep(5000);

			//CTA Label
			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Innovate With A Brave New IT");
			Thread.sleep(5000);

			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 

			//Click on Toggle Side Panel
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			aemComponentsObj.enterTextInput("img-thumbnail-vid-alumni-960w.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);

			//Select Icon
			aemComponentsObj.SelectRequiredOption("Select Icon","Bar Chart");

			//Brightcove Video ID
			aemComponentsObj.ImageProperties_Horizontal("Brightcove Video ID","3973449953001");
			Thread.sleep(5000);

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			oASelFW.driver.navigate().refresh();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(8000);
			
			System.out.println("FULL_WIDTH_CONTENT_CARD_ENDS");
			
			
			//#####################################FULL_WIDTH_CONTENT_CARD_STARTS##############################
			
			//##########################_Two Column Container_02###############################//
			
			
			
			//##########################_Two Column Container_03###############################//
	

			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickOnComponent("columncontainer");

			//details
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container		
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Spotlight Gradient Blue");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");		//Select Radio button 'Yes'
	

			//Save
			aemComponentsObj.ClickSaveIcon();	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//#####################################Partial Width Content Card##############################
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Link List Card", "Components");
			
			aemComponentsObj.dragAndDropComponents_Twocolumn("Link List Card", "Components","",3,4);
			
			aahp.clickInsertedComponent("resourcelist");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			aemComponentsObj.enterTextInput("img-kbyg-vmw-booth-02.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);

			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Partial_Width_Content_Card_1_CTA_LABEL");
			Thread.sleep(5000);

			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 

			aemComponentsObj.ImageProperties_Horizontal("CTA Link Title","Partial_Width_Content_Card_1_CTA_LINK TITLE");
			Thread.sleep(5000);

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//#####################################Partial Width Content Card##############################
			
			//#####################################FULL_WIDTH_CONTENT_CARD_STARTS##############################
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Link List Card", "Components");
			
			aemComponentsObj.dragAndDropComponents_Twocolumn("Link List Card", "Components","",3,2);
			
			aahp.clickInsertedComponent("resourcelist");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			aemComponentsObj.clickOnTabPanelLinks("Assets");
			
			aemComponentsObj.enterTextInput("img-kbyg-vmw-booth-02.jpg", "Assets");
			Thread.sleep(5000);
			aemComponentsObj.dragAndDropComponents("", "Assets","Image asset");
			Thread.sleep(5000);

			aemComponentsObj.ImageProperties_Horizontal("CTA Label","Partial_Width_Content_Card_1_CTA_LABEL");
			Thread.sleep(5000);

			//CTA Link
			aemComponentsObj.EnterTextField_Browse("CTA Link","https://www.vmware.com"); 

			aemComponentsObj.ImageProperties_Horizontal("CTA Link Title","Partial_Width_Content_Card_1_CTA_LINK TITLE");
			Thread.sleep(5000);

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			
			//#####################################FULL_WIDTH_CONTENT_CARD_STARTS##############################
			
			//##########################_Two Column Container_03###############################//
		
		
			
			
			
			

			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentObj.rolloutOps();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA");
 			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
				
			
			aemComponentsObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			
			
			
			oASelFW.driver.get("http://www-test15.vmware.com/content/vmware/vmware-published-sites/in/my-vmware/onlyAutoQA/"+pageName+".html");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			
		
			
			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
