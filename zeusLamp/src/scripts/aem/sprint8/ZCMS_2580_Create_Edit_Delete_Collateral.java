package scripts.aem.sprint8;


/**
 * @author avinash_ankireddy
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
import classes.aem.AEMCategory;
import classes.aem.AEMClassicUIPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMCreateCustomerPage;
import classes.aem.AEMCustStoryPage;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.AEMTaggingPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_2580_Create_Edit_Delete_Collateral {
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
	public void ZCMS_2580() throws Exception{
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			String username=oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password=oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			
			
			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			AEMSitesPage aemSitesObj =new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj= new AEMPageCreation(oASelFW);
			AEMTaggingPage atp=new AEMTaggingPage(oASelFW);
			AEMCategory aemSizeObj = new AEMCategory(oASelFW);
			AEMClassicUIPage aemClassicObj         = new AEMClassicUIPage(oASelFW);
			AEMCreateCustomerPage aemCustomerPage = new AEMCreateCustomerPage(oASelFW);
			AEMCustStoryPage acsp= new 		AEMCustStoryPage(oASelFW);

			//LOGIN
			aemLoginObj.login(username,password);
			
			//CLICK ON Tools
			aemHomeObj.clickOnLinks("Tools");
		
			//CLICK ON operations
			aemHomeObj.clickOnLinks("Operations");
				
			//CLICK ON operations
			aemHomeObj.clickOnLinks("Tagging");
			
			aemHomeObj.clickOnSubLink("Customerstories Storytype");
			
			atp.clickOnMenuItemsLinks("Create Tag");
			
			String tagname=atp.enter_tagDetails("Title","tagtitle");
			
			atp.click_Create();
			
			atp.verifyTagCreated(tagname);
			
			Thread.sleep(2000);

			oASelFW.driver.navigate().back();
			
			oASelFW.driver.navigate().back();
			
			//Verifying Home Page
			aemHomeObj.verifyHomePage();

			//Navigating To Customer Page
			aemHomeObj.classicUI();

			//Click On Website
			aemClassicObj.click_website();

			//Click On Lamp
			aemClassicObj.click_mainFolder("lamp");

			//Click On Customers
			aemClassicObj.click_mainFolder("customer-stories");

			//Navigating To Create Customer Page
			aemClassicObj.click_Tools();
		
			aemClassicObj.click_mainFolder("Default Page Scaffolding");
			
			oASelFW.waitForPageToLoad();
			Thread.sleep(4000);
			
			aemClassicObj.click_mainFolder("Create Customer Stories");
			
			aemClassicObj.DoubleClick_subFolder("Create Customer Stories");
			
			oASelFW.waitForPageToLoad();
			Thread.sleep(4000);
			
			acsp.clickOnAddItem();
			
			acsp.clickOnImageButton();
			
			acsp.verifyTagNamePresent(tagname);
		
			oASelFW.driver.close();
			
			//Selecting Window
			String win1[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",win1[1]);
			
			oASelFW.driver.close();
			
			Thread.sleep(5000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			//CLICK ON Tools
			aemHomeObj.clickOnLinks("Tools");
		
			//CLICK ON operations
			aemHomeObj.clickOnLinks("Operations");
				
			//CLICK ON operations
			aemHomeObj.clickOnLinks("Tagging");
			
			aemHomeObj.clickOnSubLink("Customerstories Storytype");
			
			atp.clickOnTag(tagname);
			
			atp.clickOnMenuItemsButtons("Edit");
			
			String editedTagname=atp.edit_tagDetails("Title","tagtitle",tagname);
			
			atp.click_Save();
			
			atp.click_OK();
			
			aemHomeObj.clickOnSubLink("Customerstories Storytype");
			
			atp.clickOnTag(editedTagname);
			
			atp.verifyEditedTag(tagname);
			
			atp.clickOnMenuItemsLinks("Delete");
			
			atp.delete_Tag(editedTagname);
			
			aemHomeObj.clickOnSubLink("Customerstories Storytype");
			
			atp.verifydeletedTag(editedTagname);
			
	
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

	@AfterClass()
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}

}

