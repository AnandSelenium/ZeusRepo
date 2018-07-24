package scripts.aem.sprint7;


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
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3626_US {
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
			AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
			AEMAgendaHeaderPage aahp=new AEMAgendaHeaderPage(oASelFW);
			AEMSitesPage aemSitesObj =new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj= new AEMPageCreation(oASelFW);
			AEMAssetsPage aasp 					   	 = new AEMAssetsPage(oASelFW);

		
			//LOGIN
			aemLoginObj.login(username,password);


		/*	oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmworld/en/us/asda.html");
			Thread.sleep(4000);*/

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");
			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			aemSitesObj.clickOnRequiredSite("en");
			aemSitesObj.verifySitesPage("en");
			
			
			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("US");
			
			aemSitesObj.clickOnRequiredSite("test");
			Thread.sleep(3000);
			aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			Thread.sleep(5000);
			
			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");


			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to the new window after click on open page
			Thread.sleep(15000);

			String[] windows=oASelFW.effectaArray("getAllWindowNames");
			int windowsCount=windows.length;
			System.out.println("First Time"+windowsCount);
			if(windowsCount==2)
			{
				System.out.println(windows[1]);
				oASelFW.effecta("selectWindow",windows[1]);
				System.out.println("Ok passed Successfully Handled");
				Thread.sleep(5000);
			}

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);

			//drag the  components
			aemComponentsObj.ClickDragComponents();
			

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();

			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Agenda Header");
			
			aahp.clickOnRichTextComponent("Rich Text Component");
			
			aahp.clickOnEdit("Edit");
			
			aahp.insertTextInRichTextComponent("Zeus");		

			aahp.DoubleClickonInsertedComponent("Agenda Header");

			oASelFW.effecta("waitForPageToLoad");
		
			aahp.enterComponentDetails("Enter Header","Agenda Header");

			aahp.enterComponentDetails("View By Day Title","View By Day");

			String viewDays[]={"Saturday August 29","Saturday August 30","Saturday August 31"};
			
			String viewActivities[]={"Activity1","Activity2","Activity3"};

			aahp.clickOnAddfieldAndEnterComponentDetails("View By Day Tabs","Day Tab Header",viewDays,viewDays.length);

			aahp.enterComponentDetails("View By Activity Title","View By Activity");

			aahp.clickOnAddfieldAndEnterComponentDetails("View By Activity Tabs","Activity Tab Header",viewActivities,viewActivities.length);

			aahp.clickOnDone();

			String text[]={"07:00AM - 06:00PM","Registration","Location","","HP","Breakout Sessions","","LG"};

			aahp.addSubComponents(text);

			String newurl=aahp.getCurrentPageUrlAndRemoveEditor();

			oASelFW.driver.get(newurl);

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(15000);


			aahp.scrollDown(viewDays[0]);

			String attribute=aahp.getStickyHeaderAttribute();

			aahp.validatingStickyHeaderStatus(attribute);

			aahp.scrollDown(viewDays[1]);

			String temp[]=aahp.tabStatusAndBackgroundColor("date2");

			aahp.validatingTabAfterScrolling(temp);

			aahp.clickOnTabs("View By Activity");

			String temp1[]=aahp.tabStatusAndBackgroundColor("activity1");

			aahp.validatingTabAfterScrolling(temp1);


			aahp.clickOnTabs("View By Day");

			String temp2[]=aahp.tabStatusAndBackgroundColor("date1");

			aahp.validatingTabAfterScrolling(temp2);

			oASelFW.driver.close();
			
			
			Thread.sleep(5000);
			String wins[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wins[0]);
			
			//delete folder
		/*	aasp.SelectAndDeleteFolder(pageName);
			Thread.sleep(5000);*/
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

	@AfterClass()
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}

}

