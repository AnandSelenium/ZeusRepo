package scripts.aem_phase2.sprint1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMDirectURL;
import classes.aem.AEMHomePage;
import classes.aem.AEMInfographicPage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTechPaperPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_8483_Forms_Checkbox{

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
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAgendaHeaderPage aahp               = new AEMAgendaHeaderPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMDirectURL url                       = new AEMDirectURL(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMInfographicPage aip                 = new AEMInfographicPage(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj = new AEMPartnerLoginPage(oASelFW);
			AEMMethods samp                        = new AEMMethods(oASelFW);
			AEMTechPaperPage aemTpObj = new AEMTechPaperPage(oASelFW);
			
			
			ArrayList<String> values=new ArrayList<String>();
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			String Labels[]={"Option Label","Option Value"};
			String Values[]={"Option1","123","Option2","234"};
			String ContainerFieldLlabel[]={"Field Name","Field Value"};
			String ContainerFiledValues[]={"elqFormName","2007_Corp_ContactSales","elqSiteID","524","elqDefaultTargetURL","http://www.vmware.com/company/thankyou.html","elqPost"};
			String DropdownHeading[]={"Label","Value"};
			String DropdownValues[]={"label1","123","label2","456"};
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMForms");
			aemSitesObj.clickOnRequiredSite("VMware");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("onlyAutoQAForms");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMWare Forms Template ");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");
			Thread.sleep(25000);

			//Switch to tab
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			//********************************************************************************//
			//VMware Form Container Component]
			
			aahp.clickInsertedFormContainerComponentInLamp("Form Container Component");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aemComponentsObj.ImageProperties_Horizontal("Target URL","https://secure.eloqua.com/e/f2.aspx");
			aemComponentsObj.ImageProperties_Horizontal("Form Name / ID","2007_Corp_ContactSales");
			aahp.clickOnAddfieldAndEnterComponentDetailsFormContainer("Add Hidden Form Fields",ContainerFieldLlabel,ContainerFiledValues,ContainerFieldLlabel.length);
			Thread.sleep(5000);
			aahp.clickOnDone();
			Thread.sleep(5000);
			samp.click_Edit();
			Thread.sleep(5000);
			//********************************************************************************//
			
			
			//********************************************************************************//
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Text Area", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Text Area", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Text Area");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			//VmwareTextARea
			aemComponentsObj.ImageProperties_Horizontal("Title","VMware Text Area");
			aemComponentsObj.SelectRequiredOption("Variant","Fullwidth - No content in field");
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Validation");
			Thread.sleep(3000);
			aemComponentsObj.mandatoryCheckbox();
			aemComponentsObj.ImageProperties_Horizontal("Warning Message","Required Feilds");
			aahp.clickOnDone();
		//***********************************************************************************************//	
			
			
		/*	//VMware Form Container Component]
			aahp.clickInsertedFormContainerComponentInLamp("Form Container Component");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aemComponentsObj.ImageProperties_Horizontal("Target URL","https://secure.eloqua.com/e/f2.aspx");
			aemComponentsObj.ImageProperties_Horizontal("Form Name / ID","2007_Corp_ContactSales");
			aahp.clickOnAddfieldAndEnterComponentDetailsFormContainer("Add Hidden Form Fields",ContainerFieldLlabel,ContainerFiledValues,ContainerFieldLlabel.length);
			Thread.sleep(5000);
			aahp.clickOnDone();*/
			Thread.sleep(5000);
			
	//********************************************************************************************************		
			samp.click_Edit();
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Check Box", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Check Box", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Check Box");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Select Icon
			aemComponentsObj.SelectRequiredOption("Variant","Stacked");
			aemComponentsObj.ImageProperties_Horizontal("Title","CheckBox");
			//aahp.clickOnAddfieldAndEnterComponentDetailsCheckboxes("Add CheckBoxes",Labels,Values,Labels.length);
			
			String Label[]={"Checkbox1","Checkbox2","Checkbox3","Checkbox4"};
			String Value[]={"Checkboxvalue1","Checkboxvalue2","Checkboxvalue3","Checkboxvalue4"};
			String Hiperlink[]={"Hyperlink1","Hyperlink2","Hyperlink3","Hyperlink4"};
			
			for(int i=1;i<=2;i++)
			{
	
				Thread.sleep(5000);
				//Click on Add field
				aemComponentsObj.ClickAddField();
				Thread.sleep(3000);

				aemComponentsObj.EnterMultiTextArea("Option Label with Hyperlink",Hiperlink[i-1],i);  //Link Label
				aemComponentsObj.EnterMultiTextField("Option Label",Label[i-1],i);  //Link Label

				aemComponentsObj.EnterMultiTextField("Option Value",Value[i-1],i);  //Link Label
				

				
			}
			aahp.clickOnDone();
			//**************************************************************************************//
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Text Box", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Text Box", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Text Box");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Vmware TextBox
			aemComponentsObj.ImageProperties_Horizontal("Title","VMware Text Box");
			aemComponentsObj.SelectRequiredOption("Variant","Fullwidth - No content in field");
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Validation");
			aemComponentsObj.mandatoryCheckbox();
			//aemComponentsObj.ImageProperties_Horizontal("Error Message","Check Details Again");
			aemComponentsObj.ImageProperties_Horizontal("Warning Message","Required Feilds");
			aemComponentsObj.SelectRequiredOption("Validation Pattern","Email");
			aahp.clickOnDone();
			//********************************************************************************************//
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Drop Down", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Drop Down", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Drop Down");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Drop-Down Component
			//General
			aemComponentsObj.ImageProperties_Horizontal("Title","Dropdown Field Title");
			aemComponentsObj.SelectRequiredOption("Static or dynamic drop down?","Static Values");
			aemComponentsObj.ImageProperties_Horizontal("Select Label","Select Label");
			//aahp.clickOnAddfieldAndEnterComponentDetailsDropdown("Options for Static Drop down authoring",Labels,Values,Labels.length);\
			
			String dropdownLabel[]={"dropdown1","dropdown2","dropdown3","dropdown4"};
			String dropdownValue[]={"dropdownvalue1","dropdownvalue2","dropdownvalue3","dropdownvalue4"};
			
			
			for(int i=1;i<=4;i++)
			{
			
				//Click on Add field
				aemComponentsObj.ClickAddField();
				Thread.sleep(3000);

				
				aemComponentsObj.EnterMultiTextField_dropdown_Forms("Label",dropdownLabel[i-1],i);  //Link Label

				aemComponentsObj.EnterMultiTextField_dropdown_Forms("Value",dropdownValue[i-1],i);  //Link Label
				

				
			}
			//Validation
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Validation");
			aemComponentsObj.mandatoryCheckbox();
			aemComponentsObj.ImageProperties_Horizontal("Warning Message","Required Feilds");
			aahp.clickOnDone();
			
			//*****************************************************************************************
			//Radio Button component starts....
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Radio Button", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Radio Button", "Components","");			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Radio Button");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Enter details 
			aemComponentsObj.SelectRequiredOption("Variant","Across");
			aemComponentsObj.ImageProperties_Horizontal("Title","Select Radio button");
			aemComponentsObj.ClickAddField();
			Thread.sleep(3000);
			aemComponentsObj.ImageProperties_TextArea("Option Label with Hyperlink", "Select required option");
			aemComponentsObj.ImageProperties_Horizontal("Option Label", "VMware Radio button");
			aemComponentsObj.ImageProperties_Horizontal("Option Value", "Vmware value");
			aemComponentsObj.ImageProperties_Horizontal("Tool Tip", "Tooltip");
			Thread.sleep(3000);
			aahp.clickOnDone();
			
			//Radio Button component Ends....
			//*****************************************************************************************
			//Hidden Field Component
			
			/*aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Hidden Field", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Hidden Field", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Hidden Field");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			aemComponentsObj.ImageProperties_Horizontal("Field Label","Field Label");
			aemComponentsObj.ImageProperties_Horizontal("Field Placeholder Text","Field Placeholder Text");
			aemComponentsObj.ImageProperties_Horizontal("Field Hidden Text","Field Hidden Text");
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Validation");
			Thread.sleep(3000);
			aemComponentsObj.mandatoryCheckbox();
			aemComponentsObj.ImageProperties_Horizontal("Warning Message","Required Feilds");
			aemComponentsObj.SelectRequiredOption("Validation Regex","Email");
			aahp.clickOnDone();
			Thread.sleep(3000);*/
			//*****************************************************************************************
			//Address Component Starts....
			
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Address", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Address", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Address");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Enter details 
			aemComponentsObj.ImageProperties_Horizontal("Component Header","VMware Address Field");
			Thread.sleep(3000);
			aemComponentsObj.ImageProperties_Horizontal("Company Header", "Vmware Header");
			aemComponentsObj.ImageProperties_Horizontal("Company Placeholder Text", "VMware Banglore");
			aemComponentsObj.ImageProperties_Horizontal("First Address Header", "Address 1");
			aemComponentsObj.ImageProperties_Horizontal("Second Address Header", "Address 2");
			aemComponentsObj.ImageProperties_Horizontal("City Header", "City");
			aemComponentsObj.ImageProperties_Horizontal("State Header", "State");
			aemComponentsObj.ImageProperties_Horizontal("Zip Code Header", "Zip Code");
			Thread.sleep(3000);
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Validation");
			Thread.sleep(5000);
			aemComponentsObj.ImageProperties_Horizontal("Company Warning Message","Check Company details again");
			aemComponentsObj.ImageProperties_Horizontal("Address1 Warning Message","Address1 is required");
			aemComponentsObj.ImageProperties_Horizontal("Address1 Error Message","Address1 is not valid");
			aemComponentsObj.ImageProperties_Horizontal("Address2 Error Message","Address2 is not valid");
			
			aemComponentsObj.ImageProperties_Horizontal("City Warning Message","City is required");
			aemComponentsObj.ImageProperties_Horizontal("City Error Message","City is not valid");
			aemComponentsObj.ImageProperties_Horizontal("State Error Message","State is not valid");
			aemComponentsObj.ImageProperties_Horizontal("Zip Code Error Message","Zip Code is not valid");
			
			Thread.sleep(3000);
			aahp.clickOnDone();
			Thread.sleep(3000);
			// Address Component Ends....
			//****************************************************************************
			
			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("Submit/Reset Button", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("Submit/Reset Button", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponentInLamp("Submit/Reset Button");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			//Submit/Reset Button
			aemComponentsObj.ImageProperties_Horizontal("Submit Button Title","SUBMIT BUTTON");
			aemComponentsObj.ImageProperties_Horizontal("Submit Button Label","SUBMIT");
			aemComponentsObj.SelectRequiredOption("Submit Button Color","Green Button White Text");
			aemComponentsObj.ImageProperties_Horizontal("Reset Button Title","RESET BUTTON");
			aemComponentsObj.ImageProperties_Horizontal("Reset Button Label","RESET");
			aemComponentsObj.SelectRequiredOption("Reset Button Color","White Button Green Text");
			aahp.clickOnDone();
			Thread.sleep(5000);
			//*********************************************************************************************//
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//NAavigating To Site Admin
			oASelFW.driver.close();
			Thread.sleep(2000);
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println(win.length);
			oASelFW.effecta("selectWindow",win[0]);
			oASelFW.driver.switchTo().defaultContent();
			
			url.lampToAemPage("test");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageNameAEM=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageNameAEM);

			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");

			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tabs3 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			System.out.println(tabs3.size());
			oASelFW.driver.switchTo().window(tabs3.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(30000);
			samp.click_Edit();

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(10000);
			aemComponentsObj.enterTextInput("VMware Forms HTML Component", "Components");
			Thread.sleep(3000);
			aemComponentsObj.dragAndDropComponents("VMware Forms HTML Component", "Components","");
			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			aahp.clickInsertedComponent("formcomponent");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);
			
			aip.clickOnBrowseButton("Form Path");
			aip.clickOnLampForm(pageName);
			aahp.clickOnDone();
			Thread.sleep(3000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
			
			url.openMyVMwareURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("onlyAutoQA");
			aemComponentsObj.clickLiveCopy();
			aemComponentsObj.rolloutOps_modified("/us/my-vmware");
			
			url.openVMware_PublishedURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageNameAEM);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.ClickPageInformation();
			Thread.sleep(5000);
			aemstranlationObj.publishPage_NEW();
		//	aemstranlationObj.publishPage_NEW();
			Thread.sleep(10000);
			url.opentest15shortenedURL(pageNameAEM);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			
			//Validations of Form 
			aemComponentsObj.enterFormdetailsInTextArea("VMware Text Area","Vmware Textarea");
			//Thread.sleep(3000);
			//aemComponentsObj.selectFormCheckbox("Checkbox1");
			
			aemComponentsObj.ImageProperties_Horizontal("VMware Text Box","abc@vmware.com");
			Thread.sleep(5000);
			aemComponentsObj.ImageProperties_Horizontal_Selectdropdown("Dropdown Field Title","dropdown1");
			Thread.sleep(3000);
			//aemComponentsObj.selectForm_radiobutton("VMware Radio button");
			
			aemComponentsObj.ImageProperties_Horizontal("Vmware Header","VMware");
			Thread.sleep(3000);
			aemComponentsObj.VerifyandClickFormActionListbox_Values("VMware (Burlington, CA)");
			
		/*	aemComponentsObj.ImageProperties_Horizontal("Vmware Header","");
			aemComponentsObj.ImageProperties_Horizontal("Banglore","1122 International Blvd");
			aemComponentsObj.ImageProperties_Horizontal("Address 2","Address");
			aemComponentsObj.ImageProperties_Horizontal("City","Burlington");
			aemComponentsObj.ImageProperties_Horizontal("State","Karnataka");
			aemComponentsObj.ImageProperties_Horizontal("Zip Code","500052");*/
			Thread.sleep(3000);
			aemComponentsObj.selectForm_submit_button();
			Thread.sleep(15000);
			
			aemTpObj.verify_MainHeading_locale("Thank You For Contacting VMware!");
			
			
			
			
			//Navigating to sites page
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//logout
			aemHomeObj.AEMLogout();
			
		
			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) 
		{
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			if(tabs.size()>1)
			{
				AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);

				oASelFW.driver.close();
				Thread.sleep(5000);

				String wins[]=oASelFW.effectaArray("getAllWindowNames");
				oASelFW.effecta("selectWindow",wins[0]);

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
	

	@AfterClass()
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}
