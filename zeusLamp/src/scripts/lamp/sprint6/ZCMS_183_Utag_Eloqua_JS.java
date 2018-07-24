package scripts.lamp.sprint6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_183_Utag_Eloqua_JS
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

			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMPageCreation aemPageObj             = new AEMPageCreation(oASelFW);
			String templates[]={"VMware Canvas Template","VMware CClamp Template"};

			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			

			for(int i=0;i<templates.length;i++){

				
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
				aemSitesObj.verifySitesPage("VMware");
				aemSitesObj.clickOnRequiredSite("Language Master Sites");
				aemSitesObj.verifySitesPage("Language Master Sites");
				aemSitesObj.clickOnRequiredSite("English");
				aemSitesObj.verifySitesPage("English");
				aemSitesObj.clickOnRequiredSite("My VMware");
				aemSitesObj.clickOnRequiredSite("onlyAutoQA");
				oASelFW.effecta("waitForPageToLoad");
				Thread.sleep(5000);
				
				//click on create page
				aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

				//select page template
				aemSitesObj.selectPageTemplate(templates[i]);

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
				Thread.sleep(10000);
				ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
				oASelFW.driver.switchTo().window(tabs.get(1));
				oASelFW.effecta("waitForPageToLoad");
				Thread.sleep(5000);

				//verify utag and Eloqua tags in created page vie source
				aemPageObj.verifyUtag_jsFile();
				//aemPageObj.verifyEloqua_JsFile();

				Thread.sleep(10000);
				oASelFW.driver.close();
				Thread.sleep(2000);
				String wins[]=oASelFW.effectaArray("getAllWindowNames");
				oASelFW.effecta("selectWindow",wins[0]);
				oASelFW.driver.navigate().refresh();
				Thread.sleep(2000);
				
				//Logout
				aemHomeObj.AEMLogout();
			
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
			
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}

		}
	

		@AfterClass
		public void oneTearDown() throws IOException{
			oASelFW.stopSelenium();
		}
	}
