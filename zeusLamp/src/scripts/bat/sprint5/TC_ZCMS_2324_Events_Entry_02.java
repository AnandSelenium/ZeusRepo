package scripts.bat.sprint5;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMNewsAndEventsPage;
import classes.aem.AEMPageCreation;
import classes.aem.AEMPartnerLoginPage;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_ZCMS_2324_Events_Entry_02 {

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
	public void TC_ZCMS_2324_Events_Entry_02(){
		try{	

			AEMLoginPage aemLoginObj=new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj=new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj=new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj=new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			UtilityMethods utility = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj=new AEMProjectsPage(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj=new AEMPartnerLoginPage(oASelFW);
			AEMNewsAndEventsPage aemNewsAndEventsPageObj=new AEMNewsAndEventsPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password=utility.getValuesFromPropertiesFile("constant", "Password");
			
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
			aemSitesObj.verifySitesPage("VMware");
			aemSitesObj.clickOnRequiredSite("Language Master Sites");
			aemSitesObj.verifySitesPage("Language Master Sites");
			aemSitesObj.clickOnRequiredSite("English");
			
			Thread.sleep(5000);
			//Click on Existing Template
			aemSitesObj.clickOnRequiredSite("test");
			
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			

			//select page template
			aemSitesObj.selectPageTemplate("VMware L4 Consumer Product Template");
			
			

			//click next after selecting template
			aemSitesObj.clickNext();

			
			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");
			

			//Click on Oprn Page
			aemPageCreateObj.ClickOpenPage("Open page");
			//Thread.sleep(15000);

			
			
			
			//Switch to tab
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			 oASelFW.driver.switchTo().window(tabs.get(1));
			
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/test/QAAutoTest40441.html");
			 
			 oASelFW.effecta("waitForPageToLoad");
			 
				Thread.sleep(10000);
			//Click on Drag Components here
			aemComponentsObj.ClickDragComponents();
			
			Thread.sleep(5000);
			
			//Verify Insert New Component dropdown
			aemComponentsObj.verifyInsertNewComponent();
			
			
			
			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Two Column Container");
			
			
			
			
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Two Column Container");
			
			aemPartnerLoginObj.LoginFormProperties("Title ","Test"); //Enter Title for Two Column Container
			
			aemComponentsObj.SelectRequiredOption("Select the Background Color","Light Gray");	//Select the Background Color
			
			aemComponentsObj.SelectRequiredOption("Select the Background Gradiant color","HighlightFeature/SpotLight - Blue");	//Select the Background Gradiant color
			
			aemComponentsObj.SelectRadioButton_Yes();	//Select Radio button 'Yes'
			
			aemComponentsObj.SelectRequiredOption("Select the border width type","Thick");	//Select the border width type
			
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			
			//Click on Drag Components here
			aemComponentsObj.Click_TwoColumnContainer_DragComponents();
			
			Thread.sleep(5000);
			
			//Click on Insert New Component drop down option
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Small Card Component");
			
			//Double Click on Component
			Thread.sleep(5000);
			//Double Click on Inserted Component
			aemComponentsObj.DoubleClickonInsertedComponent("Small Card Component");
			
			Thread.sleep(3000);
			
			//Enter Title
			aemComponentsObj.EnterTextField("Title", "Events");
			
			//Enter Url
			aemComponentsObj.EnterTextField_Browse("URL", "/content/dam/digitalmarketing/vmware/en/images/products/fusion/vmware-overview-fusion-81-CCD-112.jpg");
			
			
			//Select URL Target
			aemComponentsObj.TargetSelectWindow("URL Target","New Window");
			
		
			//Select Choose the Icon "News"
			aemComponentsObj.TargetSelectWindow("Choose the Icon","Events");
			
			//Select Display  Style
			aemComponentsObj.TargetSelectWindow("Display Style","blueBackground");
			
			//Enter Date
			aemComponentsObj.Events_DatePicker_SelectDate("10 Mar");
	
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			
			Thread.sleep(2000);
			
			oASelFW.driver.navigate().refresh();
			
			Thread.sleep(2000);
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			Thread.sleep(10000);
			
			//Verify News Heading
			aemComponentsObj.VerifyNewsEvents_Title("Events");
			
			//Verify  Calendar
			aemComponentsObj.VerifyCalendar();
			
			oASelFW.driver.switchTo().defaultContent();
			
			Thread.sleep(2000);
			
			 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			 
				Thread.sleep(10000);
				//logout
				aemHomeObj.AEMLogout();

			
			if(oASelFW.sResultFlag.contains("Fail")){
				oASelFW.testNgFail();
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
