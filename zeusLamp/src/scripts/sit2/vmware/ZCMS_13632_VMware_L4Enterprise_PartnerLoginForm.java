package scripts.sit2.vmware;

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
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_13632_VMware_L4Enterprise_PartnerLoginForm {

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
	public void test() throws Exception{
		try{	
			
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                  = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj        = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                  = new UtilityMethods(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj  = new AEMPartnerLoginPage(oASelFW);
			AEMAgendaHeaderPage aahp                = new AEMAgendaHeaderPage(oASelFW);
			AEMTranslation aemstranlationObj        = new AEMTranslation(oASelFW);
			AEMDirectURL url                        = new AEMDirectURL(oASelFW);
			
			
			//partnerLogin details to enter
			String CTALink="https://vmware.my.salesforce.com/secur/login_portal.jsp";
			String ForgotPassword="https://na29.salesforce.com/secur/forgotpasswordp.jsp?orgId=00D400000009hQR&portalId=06040000000D6Nb&retURL=%2Fsecur%2Flogin_portal.jsp";
			String Register="http://vmware.force.com/PartnerForms/User_Self_Reg_Search";
					
			String userName = utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password = utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
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
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page NAme"+pageName);
			
			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			
			//Click on Open Page
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to tab
			Thread.sleep(8000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			Thread.sleep(5000);
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			Thread.sleep(8000);
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			aahp.clickTextComponent("Two Column Container");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			
			//Double Click on Inserted Component
			aemPartnerLoginObj.LoginFormProperties("Title ","VMware"); //Enter Title for Two Column Container
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Spotlight Gradient Blue");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");	
			//Save
			aemComponentsObj.ClickSaveIcon();	
			Thread.sleep(5000);

			//Click on column control Drag Component
			aemComponentsObj.clickOnColumnDragComponentL4("columncontainer","columncontainer1");
			Thread.sleep(5000);
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Login Form");
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Login Form");			
			Thread.sleep(5000);
			
			//click on Login Form Properties link
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Login Form");
			aemPartnerLoginObj.LoginFormProperties_Modified("Header","PartnerLoginProps Header");  //Login Form Header	
			aemPartnerLoginObj.LoginFormProperties_Modified("Username Placeholder Text","Login Form Username Placeholder Text");  //Login Form Username Placeholder Text		
			aemPartnerLoginObj.LoginFormProperties_Modified("Password Placeholder Text","Login Form Password Placeholder Text");  //Login Form Password Placeholder Text
			aemPartnerLoginObj.LoginFormProperties_Modified("Username Input","Login Form Username Input");  
			aemPartnerLoginObj.LoginFormProperties_Modified("Password Input","Login Form Password Input");  
			aemPartnerLoginObj.LoginFormProperties_Modified("Login CTA Label","Login Form Login CTA Label");   //Login CTA Label			
			aemPartnerLoginObj.LoginFormProperties_elements_Modified("Login CTA URL",CTALink);   //Login CTA URL			
			aemPartnerLoginObj.LoginFormProperties_Modified("Forgot Password Text","Login Form Forgot Password Text");   //Forgot Password Text			
			aemPartnerLoginObj.LoginFormProperties_elements_Modified("Forgot Password URL",ForgotPassword);   //Forgot Password		
			aemPartnerLoginObj.LoginFormProperties_Modified("Register Text","Login Form Register Text");   //Register Text
			aemPartnerLoginObj.LoginFormProperties_elements_Modified("Register URL",Register);   //Register	Url		
			Thread.sleep(5000);
			
			//click on Service Form Properties link
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Form Properties");
			aemPartnerLoginObj.LoginFormProperties_Modified("Form Name / ID","FORM NAME"); 
			aemComponentsObj.TargetSelectWindow("Form Submit Method", "GET");
			Thread.sleep(5000);
			
			//click on Service Catalog Properties link
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Catalog Properties");
			
			//Enter Service Catalog Properties
			aemPartnerLoginObj.LoginFormProperties_Modified("Catalog Title","QA_Auto_Test");  //Catalog CTA Title
			aemPartnerLoginObj.LoginFormProperties_ServiceCatalogProperties_SelectCatalogIcon("Select Icon","PDF");  //Select Catalog Icon		
			aemPartnerLoginObj.catalog_Cta_Label("CTA Label(Suggested 25 Characters)","Partner Login  CTA Label");
			aemPartnerLoginObj.catalog_Cta_URL("CTA URL",CTALink);   //CTA URL		
			aemComponentsObj.TargetSelect("New Window");		
			Thread.sleep(5000);
			
			//Save
			aemComponentsObj.ClickSaveIcon();		
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();			
			Thread.sleep(5000);
			
			//Replace Editor.html with content
			aemPartnerLoginObj.modifyUrl();
			Thread.sleep(5000);
			
			//Enter User name
			aemPartnerLoginObj.PartnerLogin_Username("Test");
			
			//Enter Password
			aemPartnerLoginObj.PartnerLogin_Password("Test123");
			
			//Verify CTA Login	
			aemPartnerLoginObj.VerifyPartnerLogin_CTALogin("Login Form Login CTA Label");			
			Thread.sleep(3000);
			
			//Click Login CTA button and Verify the Url
			aemPartnerLoginObj.ClickLoginCTAAndVerifyLink("Login Form Login CTA Label", CTALink);
			
			//Click on Forgot Password button and Verify the URl
			aemPartnerLoginObj.ClickAndVerifyLink("Login Form Forgot Password Text ",ForgotPassword);
			
			//Click on Register Button and Verify the URl
			aemPartnerLoginObj.ClickAndVerifyLink("Login Form Register Text ",Register);
			
			//Verify Catalog Icon is PDF
			aemPartnerLoginObj.PartnerLoginPage_CatelogIcon_PDF();
			
			//Click and Verify Partner Login CTA Link
			aemPartnerLoginObj.ClickAndVerifyLink_PartnerLoginCTALink("Partner Login  CTA Label ",CTALink);
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			
			url.openMyVMwareURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.clickReferences();
			aemstranlationObj.selectPage("My VMware");
			aemComponentsObj.clickLiveCopy();
			aemComponentsObj.rolloutOps_modified("/us/my-vmware");
			
			url.openVMware_PublishedURL();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemstranlationObj.selectPage(pageName);
			aemstranlationObj.clickPageOpen();
			
			//Switch to tab
			Thread.sleep(10000);
			ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tab.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			aemComponentsObj.ClickPageInformation();
			aemstranlationObj.publishPage_NEW();
			
			url.opentest15URL(pageName);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//Verify CTA Login	
			aemPartnerLoginObj.VerifyPartnerLogin_CTALogin("Login Form Login CTA Label");			
			Thread.sleep(3000);
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
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

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
