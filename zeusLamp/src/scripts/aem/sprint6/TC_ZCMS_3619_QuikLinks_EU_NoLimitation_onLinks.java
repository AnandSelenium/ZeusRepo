package scripts.aem.sprint6;

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
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_3619_QuikLinks_EU_NoLimitation_onLinks {

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
	public void TC_ZCMS_3619_QuikLinks_EU_NoLimitation_onLinks() throws Exception{
		
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
			

            //CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("Europe");
			aemSitesObj.verifySitesPage("Europe");
			
			aemSitesObj.clickOnRequiredSite("test");
			
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			
			
			//select page template
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");

			//click next after selecting template
			aemSitesObj.clickNext();
			
			
			//fill required fields
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(5000);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			Thread.sleep(15000);

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");
		//	oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(50000);
			
			//Navigating To New Window
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(80000);
			
			
			//Navigating To New Window
		
			
			//drag the  components
			aemComponentsObj.ClickDragComponents();
			//oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);


			//Verify Insert New Component dropdown
			aemComponentsObj.verifyInsertNewComponent();
			//Click on Insert New Component drop down option as "Quick Links"
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Quicklinks");
			

			aemComponentsObj.DoubleClickonInsertedComponent("Quicklinks");
			
			Thread.sleep(5000);
			
			//Enter details on Quick Links window
			for(int i=1;i<=4;i++)
			{
				String value="QuicklinkText"+i;
				
				values.add(value);
				
			
				//Click on Add field
				aemComponentsObj.ClickAddField();
				

				//Enter Tool Tip
				aemComponentsObj.EnterMultiTextField("Link Label",value,i);  //Link Label
				
				aemComponentsObj.EnterMultiTextField_Browse("Link","/content/dam/digitalmarketing/vmware/en/files/myvmware/vmware-it-journey/my-vmware-it-innovation-ppt.pdf",i);  //Browse Link
				
				
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","New Window",i);  //Select URL Open type
				

			}
			
			
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(8000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			
			//Replace Editor.html with content
			aemComponentsObj.modifyUrl();
			
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);

		
			//Validate Quick Links
			/*for(int i=0;i<values.size();i++)
		
			{
				String text=values.get(i);
				
				System.out.println("Text value is:"+text);
				
				Thread.sleep(5000);
				
				aemComponentsObj.verify_QuickLinks_Values(text);
				
			}*/
			
			ArrayList<String> expectedList=new ArrayList<String>();
			
			for(int i=0;i<values.size();i++)
				
			{
				String text=values.get(i);
				
				expectedList.add(text);
			}
			
			/*String values1[]={"QuicklinkText1","QuicklinkText2","QuicklinkText3","QuicklinkText4"};
			
			aemComponentsObj.verify_QuickLinks_Values(values1[0]);
			aemComponentsObj.verify_QuickLinks_Values(values1[1]);
			aemComponentsObj.verify_QuickLinks_Values(values1[2]);
			aemComponentsObj.verify_QuickLinks_Values(values1[3]);*/
			
			ArrayList<String> actualList= aemComponentsObj.verify_QuickLinks_Values();
			aemComponentsObj.compareValues(actualList, expectedList);
			
		
			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			//delete folder
			aemAssestObj.SelectAndDeleteFolder(pageName);
			oASelFW.driver.navigate().refresh();
			 
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
