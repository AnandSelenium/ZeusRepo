
package scripts.bat.sprint6;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMNewsAndEventsPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_3802_US_AddFooterLink_VerifyInNewWindow {



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
	public void TC_ZCMS_3802_US_AddFooterLink_VerifyInNewWindow()
	{
		try
		{	
			//AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMAssetsPage aemAssestObj                        = new AEMAssetsPage(oASelFW);
			AEMLoginPage aemLoginObj                          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                            = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                          = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj                  = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj             = new AEMComponentCreation(oASelFW);
			AEMNewsAndEventsPage aemNewsAndEventsPageObj      = new AEMNewsAndEventsPage(oASelFW);
			UtilityMethods utility                            = new UtilityMethods(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password=utility.getValuesFromPropertiesFile("constant", "Password");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//click on Sites
			aemHomeObj.clickSites();

			//click on VMworld site
			aemSitesObj.clickOnRequiredSite("VMworld");

			//click on Splash Page
			aemSitesObj.RequiredSitePage("Splash Page");

			//click on US
			aemSitesObj.RequiredSitePage("US");
			aemSitesObj.RequiredSitePage("Global Content");


			//click on Create and Create page link
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//click on VMWorld Gobal Data Page

			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//click on Next
			aemSitesObj.clickNext();

			//VMworld Page Creation
			String pagename =	aemPageCreateObj.VMworld_page_Creation();
			System.out.println("pageName"+pagename);
			
			//Verify Page Created message window
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//Click on Open Page
			aemPageCreateObj.ClickOpenPage("Open page");


			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));


			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			//Drag components
			aemComponentsObj.ClickDragComponents();

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();
			
			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Fat Footer");
			
			Thread.sleep(10000);
			
			//click on fat footer Link component
			aemComponentsObj.DoubleClick_Fatfooter_LinkComponent();

			aemComponentsObj.EnterTextField("Title","AutoTest_News_AddfooterLink");

			//Click on Add field
			aemComponentsObj.ClickAddField();
			Thread.sleep(5000);

			//Enter Tool Tip
			aemComponentsObj.EnterTextField("Link Label","Linklable123");  //Link Label
			
			String link="/content/dam/digitalmarketing/vmworld/images/img-speaker-raghu.jpg";
			aemComponentsObj.EnterTextField_Browse("Link",link);  //Browse Link

			aemComponentsObj.SelectRequiredOption("Select URL Open type","New Window");  //Select URL Open type

			//click on Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(8000);

			aemPageCreateObj.click_Preview();
			Thread.sleep(8000);

			//click on Link to Open
		//	aemComponentsObj.click_LinkToOpenWindow	("");

			ArrayList<String> tabs1 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs1.get(2));

			Thread.sleep(10000);
			String url=oASelFW.driver.getCurrentUrl();

			aemComponentsObj.Verifying_AddedLinkInNewWindow(url,link);
			Thread.sleep(10000);
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(10000);
			//logout
			aemHomeObj.AEMLogout();


			if(oASelFW.sResultFlag.contains("Fail")){
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
