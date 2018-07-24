
package scripts.aem.sprint6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
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
	public void TC_ZCMS_3802_US_AddFooterLink_VerifyInNewWindow() throws Exception
	{
		
		String pageName=null;
		try
		{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			//AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMAssetsPage aemAssestObj                        = new AEMAssetsPage(oASelFW);
			AEMLoginPage aemLoginObj                          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                            = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                          = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj                  = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj             = new AEMComponentCreation(oASelFW);
			AEMNewsAndEventsPage aemNewsAndEventsPageObj      = new AEMNewsAndEventsPage(oASelFW);
			UtilityMethods utility                            = new UtilityMethods(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			//click on Sites
			aemHomeObj.clickSites();

			//click on VMworld site
			aemSitesObj.clickOnRequiredSite("VMworld");


			aemSitesObj.clickOnRequiredSite("en");
			
			//Click on US
			aemSitesObj.clickOnRequiredSite("US");
			
			
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");

			


			//click on Create and Create page link
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//click on VMWorld Gobal Data Page

			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//click on Next
			aemSitesObj.clickNext();

			//VMworld Page Creation
			pageName =	aemPageCreateObj.VMworld_page_Creation();
			Thread.sleep(6000);
			System.out.println("pageName"+pageName);
			
			//Verify Page Created message window
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//Navigating To New Window
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);


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
			aemComponentsObj.click_LinkToOpenWindow	();

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
