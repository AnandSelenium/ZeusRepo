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
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.aem.TwoColumnContainerPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_4629_BorderSelectionOption {
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
	public void ZCMS_3625_US() throws Exception{
		try{	

			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			String username=oASelFW.getConstValFrmPropertyFile("Uname_Girish");
			String password=oASelFW.getConstValFrmPropertyFile("Pwd_Girish");
			


			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			TwoColumnContainerPage tccp=new TwoColumnContainerPage(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);
		
			Thread.sleep(15000);
			oASelFW.effecta("waitForPageToLoad");
			
			
			//LOGIN
			aemLoginObj.login(username,password);
			
		
			//click on sites
			aemHomeObj.clickSites();
			
			
				//verify sites page
			aemSitesObj.verifySitesPage("Sites");

			//click on required site name
			aemSitesObj.clickOnRequiredSite("VMware");
			
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			
			aemSitesObj.clickOnRequiredSite("English");
			
			aemSitesObj.clickOnRequiredSite("My_VMware");
	
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
	
		
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("HomePage Template");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();
			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			//Click on Oprn Page
			aemPageCreateObj.ClickOpenPage("Open page");

		
	
			Thread.sleep(15000);
			
			
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			oASelFW.effecta("waitForPageToLoad");

			
			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Two column Container", "Components");
			
			aemComponentsObj.dragAndDropComponents("Two Column Container", "Components","");
			
			aahp.clickInsertedComponent("columncontainer");
			
			aahp.clickOnTool("CONFIGURE");
			
			tccp.selectValueUponLabel("Select the Background Color", "white");
			
			tccp.selectValueUponLabel("Select the Skin Type", "default");
		
			tccp.selectValueUponLabel("Border", "yes");
			
			aahp.clickOnDone();
			
			String newurl=aahp.getCurrentPageUrlAndRemoveEditor();

			oASelFW.driver.get(newurl);

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			
			tccp.verifyVerticalBorderPresent();
			
			String newurl1=aahp.getCurrentPageUrlAndAddEditor();

			oASelFW.driver.get(newurl1);

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			aahp.clickInsertedComponent("columncontainer");
			
			aahp.clickOnTool("CONFIGURE");
			
			
			tccp.selectValueUponLabel("Select the Skin Type", "verticalthickborderleftblue");
			
			tccp.selectValueUponLabel("Border", "yes");
			
			aahp.clickOnDone();
			
			
			
			String newurl2=aahp.getCurrentPageUrlAndRemoveEditor();

			oASelFW.driver.get(newurl2);

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);
			
			
			tccp.verifyHorizontalBorderPresent();
			
			
			oASelFW.driver.close();
			
			
			Thread.sleep(5000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[1]);
			
			//delete folder
			aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);
			oASelFW.driver.navigate().refresh();
			Thread.sleep(5000);
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

	@AfterClass(enabled=false)
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}

}

