package scripts.sit2.lamp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMLoginPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


public class TC_Lamp_TechPaper_Search{

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
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);

			/*//Verify Home Page
			aemHomeObj.verifyHomePage();

			//click on sites
			aemHomeObj.clickSites();

			//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			aemSitesObj.clickOnRequiredSite("My VMware");
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);

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

			//Switch to tab
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			
			//clicking on edit page
			aemPageObj.click_EditPage();
			
			//clicking on edit tech paper page
			aemPageObj.edit_TechPage();
			
			//Enter Tech Paper Values
			
			//Enter Title
			aemComponentsObj.EnterTextField("Enter Tech Paper title", "Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			//Enter Publisher
			aemComponentsObj.EnterTextField("Enter Publisher Value", "VMware");		
			//Enter Revision Date
			aemComponentsObj.EnterTextFieldDate("Revision Date", "March 24, 2016");		
			//Enter Assest Path
			aemComponentsObj.EnterTextField_Browse("Asset Path", "http://www.vmware.com/files/pdf/techpaper/vmware-horizon-6-view-unified-communications-real-time-audio-video.pdf");		
			//Enter Description Text
			aemComponentsObj.EnterTextArea("Description Text", "Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			Thread.sleep(5000);		
			//Enter Related Categories
			aemComponentsObj.EnterTextField_Categories("Related Categories");			
			//Click on Save Button
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);	
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			aemComponentsObj.verifyTechPapersValues("Unified Communications and Real-Time Audio-Video in View 5.x and Horizon 6");
			aemComponentsObj.verifyTechPapersValues("VMware");
			aemComponentsObj.verifyTechPapersValues("March");
			aemComponentsObj.verifyTechPapersValues("Download Pdf");
			aemComponentsObj.verifyTechPapersValues("Overview of Unified Communications and Real-Time Audio-Video capabilities in View 5.x and Horizon 6.");
			
			aemPartnerLoginObj.modifyUrl();
			Thread.sleep(5000);*/

			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA/QAAuto92552.html");
			
			aemComponentsObj.search_item_SIT("vsphere");
			
			aemComponentsObj.verify_result();
			
			/*oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);
			
			//logout
			aemHomeObj.AEMLogout();*/
			
			if(oASelFW.sResultFlag.contains("Fail")){
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
