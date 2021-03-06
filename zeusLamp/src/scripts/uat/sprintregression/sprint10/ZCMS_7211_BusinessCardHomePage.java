/**
 * @author avinash_ankireddy
 */

package scripts.uat.sprintregression.sprint10;

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
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.BusinessCardPromoPage;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_7211_BusinessCardHomePage
{

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
			oASelFW.driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAgendaHeaderPage aahp			   = new AEMAgendaHeaderPage(oASelFW);
			BusinessCardPromoPage	bcpp		   = new BusinessCardPromoPage(oASelFW);
			
			
			
			String username = oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password = oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			//LOGIN

			aemLoginObj.login(username, password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			//click on sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");


			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			
			aemSitesObj.clickOnRequiredSite("Business Cards Languages Masters");
			
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("QA-UAT-SmokePages");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("Business Card");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("pagename"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
	
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
		
			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Business Card Promo", "Components");
			
			aemComponentsObj.dragAndDropComponents("Business Card Promo", "Components","");
			
			aahp.clickTextComponent("Business Card Promo");
			
			aahp.clickOnTool("CONFIGURE");
			
			bcpp.clickOnColumn("Left Column");
			
			bcpp.typeTitle("Left Column");
			
			bcpp.clickAddField();
			
			bcpp.detailsInColumn("leftcol", "CTA Label", "test123");
			
			bcpp.detailsInColumn("leftcol", "CTA URL", "test12345");
			
			
			bcpp.clickOnColumn("Right Column");
			
			bcpp.typeTitle("Right Column");
			
			bcpp.clickAddField();
			
			bcpp.detailsInColumn("rightcol", "CTA Label", "test123");
			
			bcpp.detailsInColumn("rightcol", "CTA URL", "test12345");
			
			bcpp.clickOnDone();
			
			//Navigating To Home Window
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			oASelFW.driver.navigate().refresh();
	
			//logout
			aemHomeObj.AEMLogout();
				
		}
		catch (Exception e)
		{
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
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}