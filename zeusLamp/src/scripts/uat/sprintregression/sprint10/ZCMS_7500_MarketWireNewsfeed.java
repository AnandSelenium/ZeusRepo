package scripts.uat.sprintregression.sprint10;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;






import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_7500_MarketWireNewsfeed {

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
	public void TC_ZCMS_2324_Events_Entry_01() throws Exception{
		try{	

			AEMLoginPage aemLoginObj                     = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                       = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                     = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj             = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj        = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                       = new UtilityMethods(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj       = new AEMPartnerLoginPage(oASelFW);
			AEMAssetsPage aasp 					  		 = new AEMAssetsPage(oASelFW);
			AEMAgendaHeaderPage aahp                     = new AEMAgendaHeaderPage(oASelFW);
			
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,password);

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
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//Click on Open Page
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(15000);

			//Switch to tab
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			

			aemComponentsObj.clickOnToggleSidePanel();
			aemComponentsObj.clickOnTabPanelLinks("Components");
			aemComponentsObj.enterTextInput("Two Column Container", "Components");
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			Thread.sleep(5000);
			aahp.clickTextComponent("Two Column Container");
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(8000);

			//details
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container		
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Spotlight Gradient Blue");	//Select the Background Color	
			aemComponentsObj.SelectRequiredOption("Select the Skin Type","Vertical Thick Border Right (Blue)");	//Select the Background Gradiant color		
			aemComponentsObj.SelectRequiredOption("Border","Yes");		//Select Radio button 'Yes'

			//Save
			aemComponentsObj.ClickSaveIcon();	
			Thread.sleep(5000);
			
			aemComponentsObj.clickOnColControlDragComponentSecond("columncontainer1");
			
			Thread.sleep(5000);

			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Market Wire Feed Dynamic");
			Thread.sleep(5000);
			
			//Fill Details in Market Wire Feed Dynamic component 
			aemComponentsObj.fillMarketWireFeedDynamic();
			
			aemComponentsObj.selectSkinType("companyblue");
			

			oASelFW.driver.navigate().refresh();	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);

			oASelFW.driver.navigate().refresh();
			Thread.sleep(2000);
			
			/*
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			Thread.sleep(10000);
			 */

			oASelFW.driver.switchTo().defaultContent();
			Thread.sleep(5000);

			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(5000);
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			//logout
			aemHomeObj.AEMLogout();


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
	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
