package scripts.aem.sprint6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMNewsAndEventsPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_3802_EU_AddFooterComponentAndVerify {

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
	public void TC_ZCMS_3802_EU_AddFooterComponentAndVerify() throws Exception{
		
		
		String pagename=null;
		try{	
			
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			//AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMAssetsPage aemAssestObj=new AEMAssetsPage(oASelFW);

			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility                   = new UtilityMethods(oASelFW);
			AEMNewsAndEventsPage aemNewsAndEventsPageObj=new AEMNewsAndEventsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);




			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			//LOGIN
			aemLoginObj.login(userName,Password);

			//click on Sites
			aemHomeObj.clickSites();

			//click on VMworld site
			aemSitesObj.clickOnRequiredSite("VMworld");

			aemSitesObj.clickOnRequiredSite("en");
			

            //CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("Europe");
			aemSitesObj.verifySitesPage("Europe");
			
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");


			//click on Create and Create page link
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//click on VMWorld Gobal Data Page

			aemSitesObj.selectPageTemplate("VMWorld Gobal Data Page");

			//click on Next
			aemSitesObj.clickNext();

			//VMworld Page Creation

			pagename =	aemPageCreateObj.VMworld_page_Creation();
			Thread.sleep(6000);

			//Verify Page Created message window
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(5000);

			
			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//Navigating To New Window
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);



			//click on fat footer component

			//aemComponentsObj.DoubleClickonInsertedComponent("");
			

			//insert the new component from Parsys
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Fat Footer");
			
			//click on inserted site header component
			//aemComponentsObj.DoubleClickonInsertedComponent("");
			Thread.sleep(5000);


			
			//click on fat footer Link component
			aemComponentsObj.DoubleClick_Fatfooter_LinkComponent();


			aemComponentsObj.EnterTextField("Title","AutoTest_News_Addfooter");




			//xpath=(//div[contains(@data-path,'fatfooter1')]/preceding-sibling::div)[1]
			int n=2;
			for(int i=1;i<=n;i++)
			{

				String array1[]={"footer1","footer2"};

				Thread.sleep(5000);
				//Click on Add field
				aemComponentsObj.ClickAddField();
				Thread.sleep(5000);

				aemComponentsObj.EnterMultiTextField_Browse("Link","/content/dam/digitalmarketing/vmworld/images/img-speaker-raghu.jpg",i);  //Browse Link

				//Enter Tool Tip
				aemComponentsObj.EnterMultiTextField("Link Label",array1[i-1],i);  //Link Label

				aemComponentsObj.EnterMultiTextField_Browse("Link","/content/dam/digitalmarketing/vmworld/images/img-speaker-raghu.jpg",i);  //Browse Link

				if(i==1){
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","New Window",i);  //Select URL Open type
					}
				if(i==n){
					aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","Same Window",i);  //Select URL Open type
					//click on Save
					aemComponentsObj.ClickSaveIcon();
					Thread.sleep(8000);
					//click on preview
					aemPageCreateObj.click_Preview();
					for(int j=1;j<=n;j++)
					{
						
						//Verifying added footer component values
						aemComponentsObj.Verifying_AddedFooterComponentValues(array1,j);

					}

				}

			}


			oASelFW.driver.close();
			oASelFW.driver.switchTo().window(tabs.get(0));

			//delete folder
			aemAssestObj.SelectAndDeleteFolder(pagename);
			oASelFW.driver.navigate().refresh();

			//Thread.sleep(10000);
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
				aasp.SelectAndDeleteFolder(pagename);
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

