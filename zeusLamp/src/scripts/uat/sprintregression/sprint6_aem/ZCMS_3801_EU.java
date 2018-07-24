package scripts.uat.sprintregression.sprint6_aem;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_3801_EU{

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

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMAssetsPage aasp                     = new AEMAssetsPage(oASelFW);
			UtilityMethods utility           	   = new UtilityMethods(oASelFW);
			
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
			
		/*	aemSitesObj.clickOnRequiredSite("VMworld_2016");
			
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
			
			Thread.sleep(5000);
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

				//drag components
			aemComponentObj.ClickDragComponents();

			//verify insert new component
			aemComponentObj.verifyInsertNewComponent();

			//insert new component
			//aemComponentObj.ClickInsertNewComponent_DropdownOption("FAQ Container");
			aemComponentObj.ClickInsertNewComponent_DropdownOption("");

			//double click on component to add fields
			aemComponentObj.DoubleClickonInsertedComponent("");
			Thread.sleep(5000);

			
			oASelFW.effecta("selectWindow",wind[0]);
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmworld/en/us");
			//oASelFW.effecta("waitForPageToLoad");
			//Thread.sleep(5000);

			aemPageCreateObj.clickSelect();
			aemPageCreateObj.openPage("Global Content");

			String windows[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("Windows:"+wind.length);
			System.out.println("In window:"+(windows.length-2));
			oASelFW.effecta("selectWindow",windows[windows.length-2]);
			//oASelFW.effecta("selectWindow",windows[windows.length-1]);

			
			for(String winHandle :oASelFW.driver.getWindowHandles()){
				oASelFW.driver.switchTo().window(winHandle);
			  System.out.println("window Title is :" +oASelFW.driver.getTitle());
			  
			  System.out.println("Window Switched");
				
			}
			
			aemComponentObj.DoubleClickonFatFooter_GlobalContent();
			Thread.sleep(5000);
			aemComponentObj.Addfield();

			String value="Title"+((int)Math.random()*100);
			aemComponentObj.enter_TitleAndLinkLableIn_TitleAndLinks("Title", value);
			aemComponentObj.enter_TitleAndLinkLableIn_TitleAndLinks("Link Label", value);

			aemComponentObj.enter_LinkIn_TitleAndLinks("WWW.Google.com");
			aemComponentObj.selectUrlIn_TitleAndLinks("New Window");
			Thread.sleep(5000);
			
			
			//String windows1=oASelFW.driver.getWindowHandle();

			for(String winHandle :oASelFW.driver.getWindowHandles()){
				oASelFW.driver.switchTo().window(winHandle);
			  System.out.println("window Title is :" +oASelFW.driver.getTitle());
			  
			  System.out.println("Window Switched");
				
			}
			
			
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("In window:"+(win.length-1));
			oASelFW.effecta("selectWindow",win[win.length-1]);
			oASelFW.driver.navigate().refresh();

			aemComponentObj.DoubleClickonFatFooter_GlobalContent();
			aemComponentObj.verifyFatFooterPage(value);
			
			String win[]=oASelFW.effectaArray("getAllWindowNames");
			System.out.println("In window:"+(win.length-2));
			oASelFW.effecta("selectWindow",win[win.length-2]);
			aemComponentObj.deleteCreatedFatFooter();

			oASelFW.driver.switchTo().defaultContent();
			
			aemPageCreateObj.clickDeSelect();
			aemPageCreateObj.clickSelect();
			
			aasp.deleteFolder(pageName);

			//LOGOUT
			aemHomeObj.AEMLogout();*/

			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}

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

	@AfterClass(enabled=false)
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
