package scripts.uat.sprintregression.sprint6_aem;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;





import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMEditCustomer;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3615_EU {

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
	public void TC_ZCMS_3601_TranslateAssetLinksFromEN_JP() throws Exception{
		try{	

			AEMLoginPage aemLoginObj                   = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                     = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                   = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj           = new AEMPageCreation(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			String linkLabel1="India";
			String linkLabel2="US";
			UtilityMethods utility            = new UtilityMethods(oASelFW);

			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			aemSitesObj.clickOnRequiredSite("Europe");
			
			Thread.sleep(5000);
			
			aemSitesObj.clickOnRequiredSite("VMworld_2016");
			
			//aemSitesObj.clickOnRequiredSite("Automation");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
		
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");

		/*	//SWITCH TO NEW WINDOW AFTER CLICK ON OPEN PAGE
			aemPageCreateObj.switch_window_aftOpenPge(pageName); 

			//String parentwind_name=samp.switch_window_aftOpenPge1("QAAutoTest60273");
			String parentwind_name=samp.switch_window_aftOpenPge1(pageName);
			System.out.println("window name"+parentwind_name);

			AEMEditCustomer AEMEditorPage=new AEMEditCustomer(oASelFW);

			//click edit, toggle panel and component
			AEMEditorPage.click_EditIn_AEMEditorPage();

			//drag images
			AEMEditorPage.dragAndDropImagesIn_AEMEditorPage();

			AEMEditorPage.doubleClick_MeageMenuLinksIn_AEMEditorPage();

			//enter details in mega menu links and titles
			String title=AEMEditorPage.enter_MegaMenuLinksAndTitlesIn_AEMEditorPage(linkLabel1,linkLabel2);

			oASelFW.driver.navigate().refresh();

			Thread.sleep(2000);

			oASelFW.driver.navigate().refresh();

			AEMEditorPage.click_previewIn_AEMEditorPage();

			oASelFW.driver.switchTo().frame("ContentFrame");

			AEMEditorPage.verify_LinksInContainer(title,linkLabel1);
			AEMEditorPage.verify_LinksInContainer(title,linkLabel2);

			oASelFW.driver.switchTo().defaultContent();
			System.out.println("helllllllll");*/


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
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
