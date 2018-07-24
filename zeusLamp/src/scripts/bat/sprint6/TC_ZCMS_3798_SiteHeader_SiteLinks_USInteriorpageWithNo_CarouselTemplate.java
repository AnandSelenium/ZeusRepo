package scripts.bat.sprint6;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_3798_SiteHeader_SiteLinks_USInteriorpageWithNo_CarouselTemplate {
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
	public void TC_ZCMS_3798_SiteHeader_SiteLinks_USInteriorpageWithNo_CarouselTemplate()
	{
		try
		{	
			AEMLoginPage aemLoginObj                 = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                   = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                 = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj         = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj    = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password=utility.getValuesFromPropertiesFile("constant", "Password");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			//click on required page
			aemSitesObj.clickOnRequiredSite("Splash Page");
			aemSitesObj.verifySitesPage("Splash Page");

			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("US");
			aemSitesObj.verifySitesPage("US");

			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to the new window after click on open page
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));

			//drag the  components
			aemComponentsObj.ClickDragComponents();
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Site Header");

			//click on inserted site header component
			aemComponentsObj.DoubleClickOnComponent("siteheader");

			for(int i=1;i<=2;i++)
			{
				//Click on Add field
				aemComponentsObj.ClickAddField();
				String linkLabels[]={"facebook","google"};
				String linkURls[]={"www.facebook.com","www.google.com"};
				aemComponentsObj.EnterMultiTextField("Link Label",linkLabels[i-1],i);
				aemComponentsObj.EnterMultiTextField_Browse("Link URL",linkURls[i-1],i);
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","New Window",i);  //Select URL Open type
			}
			
			//click on Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//click on Preview
			aemPageCreateObj.click_Preview();

			//verifying added links
			String linkLabels1[]={"facebook","google"};
			aemComponentsObj.verifying_MultipleAddedcomponetValues(linkLabels1,"Site Header",2);

			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			oASelFW.driver.navigate().refresh();
			Thread.sleep(10000);
			
			//logout
			aemHomeObj.AEMLogout();

			if(oASelFW.sResultFlag.contains("Fail"))
			{
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
