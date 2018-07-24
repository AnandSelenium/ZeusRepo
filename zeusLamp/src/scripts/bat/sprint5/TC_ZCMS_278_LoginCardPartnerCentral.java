package scripts.bat.sprint5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_278_LoginCardPartnerCentral {

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
	public void TC_ZCMS_278_LoginCardPartnerCentral(){
		try{	

			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj=new AEMPartnerLoginPage(oASelFW);
			
			//partnerLogin details to enter
			String CTALink="https://vmware.my.salesforce.com/secur/login_portal.jsp";
			//String ForgotPassword="https://na6.salesforce.com/secur/forgotpasswordp.jsp?orgId=00D400000009hQR&amp;portalId=06040000000D6Nb&amp;retURL=%2Fsecur%2Flogin_portal.jsp";
			String ForgotPassword="https://na29.salesforce.com/secur/forgotpasswordp.jsp?orgId=00D400000009hQR&portalId=06040000000D6Nb&retURL=%2Fsecur%2Flogin_portal.jsp";
			//String Register="http://vmware.force.com/PartnerForms/self_reg_search";
			String Register="http://vmware.force.com/PartnerForms/User_Self_Reg_Search";
					
			
			String userName = utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password = utility.getValuesFromPropertiesFile("constant", "Password");
			
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
			aemSitesObj.verifySitesPage("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.verifySitesPage("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			
			Thread.sleep(5000);
			//Click on Existing Template
			aemComponentsObj.scrollPage();
			oASelFW.effecta("waitForPageToLoad");
			aemSitesObj.clickOnRequiredSite("test");
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

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
			//Click on Drag Components here
			aemComponentsObj.ClickDragComponents();
			Thread.sleep(5000);
			
			//Verify Insert New Component dropdown
			//aemComponentsObj.verifyInsertNewComponent();
			
			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Two Column Container");
			
			Thread.sleep(5000);
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Two Column Container");
			
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			//Click on Drag Components here
			aemComponentsObj.Click_TwoColumnContainer_DragComponents();
			
			Thread.sleep(5000);
			
			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Partner Login");
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Partner Login");
			
			Thread.sleep(5000);
			
			//click on Login Form Properties link
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Login Form"); //Click on Login Form link
			
			//Enter Login Form Properties
			aemPartnerLoginObj.LoginFormProperties("Header","PartnerLoginProps Header");  //Login Form Header
			
			aemPartnerLoginObj.LoginFormProperties("Username Placeholder Text","Login Form Username Placeholder Text");  //Login Form Username Placeholder Text
			
			aemPartnerLoginObj.LoginFormProperties("Password Placeholder Text","Login Form Password Placeholder Text");  //Login Form Password Placeholder Text
			aemPartnerLoginObj.LoginFormProperties("Password Placeholder Text","Login Form Password Placeholder Text");  //Login Form Password Placeholder Text
			
			aemPartnerLoginObj.LoginFormProperties("Login CTA Label","Login Form Login CTA Label");   //Login CTA Label
			
			aemPartnerLoginObj.LoginFormProperties_elements("Login CTA URL",CTALink);   //Login CTA URL
			
			aemPartnerLoginObj.LoginFormProperties("Forgot Password Text","Login Form Forgot Password Text");   //Forgot Password Text
			
			aemPartnerLoginObj.LoginFormProperties_elements("Forgot Password URL",ForgotPassword);   //Forgot Password
			
			aemPartnerLoginObj.LoginFormProperties("Register Text","Login Form Register Text");   //Register Text
			
			aemPartnerLoginObj.LoginFormProperties_elements("Register URL",Register);   //Register	Url
			
			Thread.sleep(5000);
			
			//click on Service Catalog Properties link
			aemPartnerLoginObj.LoginFormPropertiesHeaderLinks("Catalog Properties");
			
			
			//Enter Service Catalog Properties
			aemPartnerLoginObj.LoginFormProperties("Catalog Title","QA_Auto_Test");  //Catalog CTA Title
			
			aemPartnerLoginObj.LoginFormProperties_elements("CTA URL",CTALink);   //CTA URL
			
			aemPartnerLoginObj.LoginFormProperties_ServiceCatalogProperties_SelectCatalogIcon("Select Icon","PDF");  //Select Catalog Icon
			
			aemPartnerLoginObj.LoginFormProperties("CTA Label","Partner Login  CTA Label");   //CTA Label
			
			//Select Events Target
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
			
			//Verify Login Title in Partner Login Page
			aemPartnerLoginObj.PartnerLoginPage_VerifyLoginTitle("PartnerLoginProps Header");   
			
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
			//aemPartnerLoginObj.ClickonLink("Login Form Forgot Password Text ");
			aemPartnerLoginObj.ClickAndVerifyLink("Login Form Forgot Password Text ",ForgotPassword);
			
			
			//Click on Register Button and Verify the URl
			//aemPartnerLoginObj.ClickonLink("Login Form Register Text ");
			aemPartnerLoginObj.ClickAndVerifyLink("Login Form Register Text ",Register);
			
			//Verify Catalog Icon is PDF
			aemPartnerLoginObj.PartnerLoginPage_CatelogIcon_PDF();
			
			//Click and Verify Partner Login CTA Link
			aemPartnerLoginObj.ClickAndVerifyLink_PartnerLoginCTALink("Partner Login  CTA Label ",CTALink);
			
						
			
			
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			
			//logout
			aemHomeObj.AEMLogout();
			
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
