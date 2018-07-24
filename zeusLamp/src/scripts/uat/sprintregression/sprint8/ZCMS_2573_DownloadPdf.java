package scripts.uat.sprintregression.sprint8;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTranslation;

import com.arsin.ArsinSeleniumAPI;


public class ZCMS_2573_DownloadPdf{

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
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMTranslation aemstranlationObj       = new AEMTranslation(oASelFW);
			AEMComponentCreation aemComponentObj   = new AEMComponentCreation(oASelFW);
			AEMPageCreation aemPageObj             = new AEMPageCreation(oASelFW);
			
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
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("training");
			aemSitesObj.clickOnRequiredSite("UAT_QA");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
		
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("Tech Paper Page");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemstranlationObj.page_Creation();
			System.out.println("Page Name:"+pageName);
			
			//Verify Page Created
			aemstranlationObj.verifyPageCreated("Page created");
			
			//Click on Open Page
			aemstranlationObj.ClickOpenPage("Open page");
			System.out.println("Page Open");
			
			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			Thread.sleep(30000);
			
			//clicking on edit page
			aemPageObj.click_EditPage();
			
			//clicking on edit tech paper page
			aemPageObj.edit_TechPage();
			
			//Enter Tech Paper Values
			
			//Enter Title
			aemComponentObj.EnterTextField("Enter Tech Paper title", "Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			
			//Enter Publisher
			aemComponentObj.EnterTextField("Enter Publisher Value", "Divanshu");
			
			//Enter Revision Date
			aemComponentObj.EnterTextFieldDate("Revision Date", "March 24, 2016");
			
			//Enter Assest Path
			aemComponentObj.EnterTextField_Browse("Asset Path", "http://www.vmware.com/files/pdf/techpaper/vmware-horizon-6-view-unified-communications-real-time-audio-video.pdf");
			
			//Enter Description Text
			aemComponentObj.EnterTextArea("Description Text", "Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			Thread.sleep(5000);
			
			//Enter Related Categories
			aemComponentObj.EnterTextField_Categories("Related Categories");
			
			//Click on Save Button
			aemComponentObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			aemComponentObj.verifyTechPapersValues("Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			aemComponentObj.verifyTechPapersValues("Divanshu");
			aemComponentObj.verifyTechPapersValues("March");
			aemComponentObj.verifyTechPapersValues("Download Pdf");
			aemComponentObj.verifyTechPapersValues("Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			
			//Download Pdf
			aemComponentObj.clickDownloadPdf();
			Thread.sleep(50000);
			
			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
			
			//logout
			aemHomeObj.AEMLogout();
			
			
			
				
			
		}
		catch (Exception e) {
			
			
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
