package scripts.cdci;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class VMworld_US_SiteHeader_QuickLinks {

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
	public void VMworld_US_SiteHeader_QuickLinks() throws Exception{
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMAssetsPage aemAssestObj=new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			String notificatioDevUrl = utility.getValuesFromPropertiesFile("constant", "Notifications_DevUrl");
			ArrayList<String> values=new ArrayList<String>();


			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on Sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on VMWorld
			aemSitesObj.clickOnRequiredSite("VMworld");

			aemSitesObj.clickOnRequiredSite("en");
			//Click on US
			aemSitesObj.clickOnRequiredSite("US");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("Learning");
			
			aemSitesObj.clickOnRequiredSite("test");
			
			
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");



			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			

			//select page template
			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			pageName=aemPageCreateObj.page_Creation();
		
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(6000);
			

			
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			
			samp.click_Edit();
			Thread.sleep(3000);
			
		
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(5000);
			
			aemComponentsObj.enterTextInput("Quicklinks", "Components");
			Thread.sleep(5000);
			
			aemComponentsObj.dragAndDropComponents("Quicklinks", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(5000);
			
			aemComponentsObj.ClickOnComponent("quicklinks");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);

			
			String links[]= {"/content/vmworld/en"};
			//Enter details on Quick Links window
			for(int i=1;i<=2;i++)
			{
				String value="QuicklinkText"+i;

				values.add(value);

				Thread.sleep(5000);
				//Click on Add field
				aemComponentsObj.ClickAddField();
				Thread.sleep(3000);

				//Enter Tool Tip
				aemComponentsObj.EnterMultiTextField("Link Label",value,i);  //Link Label

				aemComponentsObj.EnterMultiTextField_Browse("Link",links[0],i);  //Browse Link


				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","Same Window",i);  //Select URL Open type


			}


			//Save
			aemComponentsObj.ClickSaveIcon();

			Thread.sleep(5000);

			
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(8000);
			
			aemComponentsObj.enterTextInput("Site Header", "Components");
			Thread.sleep(3000);
			
			aemComponentsObj.dragAndDropComponents("Site Header", "Components","");
			aemComponentsObj.clickOnToggleSidePanel();
			Thread.sleep(3000);
			
			aemComponentsObj.ClickOnComponent("siteheader");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(3000);

		

			
			aemComponentsObj.EnterTextField("Tools Label","DashBoard_Tool");  //Tools Label
			for(int i=1;i<=1;i++)
			{
				
				
				//Click on Add field
				aemComponentsObj.ClickAddField();
				String linkLabels[]={"Facebook","Twitter"};
				String linkURls[]={"https://www.facebook.com","https://twitter.com/login"};
				
				aemComponentsObj.EnterMultiTextField("Link Label",linkLabels[i-1],i);
				aemComponentsObj.EnterMultiTextField_Browse("Link URL",linkURls[i-1],i);
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","New Window",i);  //Select URL Open type
				aemComponentsObj.SelectMultiRequiredOption("Highlight link","Enable",i);  //Select URL Open type
			}
			Thread.sleep(5000);
			//click on Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(3000);
			
		

			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(3000);

			oASelFW.driver.navigate().refresh();
			Thread.sleep(3000);
		
			ArrayList<String> expectedList=new ArrayList<String>();

			for(int i=0;i<values.size();i++)

			{
				String text=values.get(i);

				expectedList.add(text);
			}

			ArrayList<String> actualList= aemComponentsObj.verify_QuickLinks_Values_InPreview();
			aemComponentsObj.compareValues(actualList, expectedList);

		
		
			String linkURls1[]={"https://www.facebook.com","https://twitter.com/login"};
			
			//verifying added links
			String linkLabels1[]={"Facebook","Twitter"};
		
			
			
			//Verify Site Header links
			aemComponentsObj.click_SiteHeader_DifferentWind_InPreview(linkLabels1[0],linkURls1[0]);
			//aemComponentsObj.click_SiteHeader_DifferentWind_InPreview(linkLabels1[1],linkURls1[1]);
			
			//navigating to home screen
			oASelFW.driver.close();
			Thread.sleep(2000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			
			//delete folder
			/*aemAssestObj.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();*/
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
