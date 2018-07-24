package scripts.uat.sprintregression.sprint5;

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
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_2239_ComparisonTable_10 {

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
	public void test() throws Exception{
		
		
		String pageName=null;
		try{	
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj               = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                 = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj               = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj       = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj  = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                 = new UtilityMethods(oASelFW);
			AEMAssetsPage aasp 					   = new AEMAssetsPage(oASelFW);

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
			pageName=aemPageCreateObj.page_Creation();
			System.out.println("PAGE NAME:-"+pageName);
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");		
			Thread.sleep(3000);
			
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(5000);
			
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			Thread.sleep(10000);

			oASelFW.effecta("waitForPageToLoad");

			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			aemComponentsObj.enterTextInput("Compare Table", "Components");
			
			aemComponentsObj.dragAndDropComponents("Compare Table", "Components","");
			
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickOnComponent("comparisontable");

			//Feature Heading in Comparision Table
			aemComponentsObj.ComparisionTableHeaderProperties("Feature Heading","Paramenter");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 1 Heading","Test 1");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 2 Heading","Test 2");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 3 Heading","Test 3");
			aemComponentsObj.ComparisionTableHeaderProperties("Column 4 Heading","Test 4");
			for(int i=1;i<=3;i++)
			{
				Thread.sleep(5000);
				//Click on Add field
				aemComponentsObj.ClickAddField();

				//Enter Tool Tip
				aemComponentsObj.ComparisionToolTip("Tooltip Text","Show Details 1",i);
				aemComponentsObj.ComparisionTableProperties("Feature Name","Speed",i);
				aemComponentsObj.ComparisionTableProperties("Column 1 Text","80km/hr",i);
				aemComponentsObj.ComparisionTableProperties("Column 2 Text","100km/hr",i);
				aemComponentsObj.ComparisionTableProperties("Column 3 Text","70km/hr",i);
				aemComponentsObj.ComparisionTableProperties("Column 4 Text","90km/hr",i);
				
				//Column 1 Feature (Dropdown Yes/No)
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 1 - Feature Present?","YES",i);
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 2 - Feature Present?","NO",i);
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 3 - Feature Present?","YES",i);
				aemComponentsObj.ComparisionColumnFeatureYes_No("Column 4 - Feature Present?","YES",i);
			}

			//Save
			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);
			
			//Replace Editor.html with content
			aemComponentsObj.modifyUrl();
			Thread.sleep(5000);
			
			
			//Verify ToolTip
			aemComponentsObj.VerifyToolTipText("Show Details 1",pageName);	
			//aemComponentsObj.VerifyToolTipText("Show Details 1","QAAutoTest92801");	
			Thread.sleep(5000);
			
			
			oASelFW.driver.close();
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
				
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
				AEMAssetsPage aasp				   = new AEMAssetsPage(oASelFW);
				aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();
				
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
