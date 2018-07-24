package scripts.bat.sprint6;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.aem.AEMAssetsPage;
import classes.aem.AEMComponentCreation;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.aem.AEMMethods;
import classes.aem.AEMPageCreation;
import classes.aem.AEMProjectsPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ZCMS_3630_Verify_TabComponent_EUInteriorPageWithCarouselTemplate {
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

	public void ZCMS_3630_Verify_TabComponent_EUInteriorPageWithCarouselTemplate()
	{
		try
		{	

			AEMLoginPage aemLoginObj                = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                  = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj        = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                  = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj          = new AEMProjectsPage(oASelFW);
			AEMAssetsPage aasp                      = new AEMAssetsPage(oASelFW);
			AEMMethods samp = new AEMMethods(oASelFW);

			String userName=utility.getValuesFromPropertiesFile("constant", "UserName");
			String Password=utility.getValuesFromPropertiesFile("constant", "Password");
			
			//LOGIN
			aemLoginObj.login(userName,Password);
	
			//Verify Home Page
			aemHomeObj.verifyHomePage();

			//CLICK ON SITES
			aemHomeObj.clickSites();

			//VERIFY SITES PAGE
			aemSitesObj.verifySitesPage("Sites");

			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("VMworld");
			aemSitesObj.verifySitesPage("VMworld");
			
			//CLICK ON REQUIRED SITE NAME
			aemSitesObj.clickOnRequiredSite("Splash Page");
			aemSitesObj.verifySitesPage("Splash Page");
			
			//CLICK ON US PAGE TEMPLATE
			aemSitesObj.clickOnRequiredSite("Europe");
			aemSitesObj.verifySitesPage("Europe");

			//CLICK ON CREATE PAGE
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");

			//SELECT PAGE TEMPLATE
			aemSitesObj.selectPageTemplate("VMWorld Interior Page");

			//CLICK NEXT AFTER SELECTING TEMPLATE
			aemSitesObj.clickNext();

			//FILL REQUIRED FIELDS
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//VERIFY PAGE CREATED
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//CLICK ON OPEN PAGE
			aemPageCreateObj.ClickOpenPage("Open page");

			//Switch to the new window after click on open page
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));

			//drag components
			aemComponentsObj.ClickDragComponents();

			//verify insert new component
			aemComponentsObj.verifyInsertNewComponent();
			Thread.sleep(5000);

			//insert new component
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Tab Content Component");

			//double click on component to add fields
			aemComponentsObj.DoubleClickOnComponent("tabcontent");
			Thread.sleep(10000);

			String Tabtitles[]={"Title1","Title2"};
			String Tabcontents[]={"Tab_Content1","Tab_Content2"};

			for(int i=1;i<=2;i++)
			{
				//Click on Add field
				aemComponentsObj.ClickAddField();
				aemComponentsObj.EnterMultiTextField("Tab Title",Tabtitles[i-1],i);
				aemComponentsObj.EnterMultiTextField("Tab Content Title",Tabcontents[i-1],i);
			}

			aemComponentsObj.ClickSaveIcon();
			Thread.sleep(5000);

			String[] url={"http://aem-test-auth-1.vmware.com:8080","www.google.com"};
			String[] title={"Internal","External"};


			for(int j=1;j<=2;j++)
			{
				aemComponentsObj.clickOnTabs_TabComponent(Tabtitles[j-1]);
				if(j==2)
				{
					aemPageCreateObj.click_Edit();
				}
				aemComponentsObj.click_givenDragComponents("par-tab-"+j+"");

				oASelFW.effecta("waitForPageToLoad");
				Thread.sleep(15000);

				//insert the new component from Parsys
				aemComponentsObj.ClickInsertNewComponent_DropdownOption("Rich Text Component");
				aemComponentsObj.clickonComponent("Rich Text Component");

				//click on Edity button
				aemComponentsObj.clickOnEDitButton_tabs();
				aemComponentsObj.entertText_tabs();
				aemComponentsObj.clickOn_ButtonTOogiveURls_Tab();
				aemComponentsObj.EnterURlTitle( url[j-1], title[j-1]);

				if(j==2)
				{
					aemComponentsObj.OPenInNewPage_Checkbox();
				}
				aemComponentsObj.clickOnApply();

				//click on preview
				aemPageCreateObj.click_Preview();
				if(j==1)
				{
					//aemComponentsObj.click_LinkToOpenWindow	("link=URLvalue");
					String url1=oASelFW.driver.getCurrentUrl();
					aemComponentsObj.Verifying_AddedLinkInSameWindow(url1, url[j-1]);
				}
				if(j==2)
				{
					//aemComponentsObj.click_LinkToOpenWindow	("link=URLvalue");
					ArrayList<String> tabs1 = new ArrayList<String> (oASelFW.driver.getWindowHandles());
					if(tabs1.size()>=2)
					{
						oASelFW.driver.switchTo().window(tabs1.get(2));
						String url1=oASelFW.driver.getCurrentUrl();
						aemComponentsObj.Verifying_AddedLinkInNewWindow(url1, url[j-1]);
					}
				}
				oASelFW.driver.close();
				oASelFW.driver.switchTo().window(tabs.get(0));

				//delete folder
				//	aasp.SelectAndDeleteFolder(pageName);
				oASelFW.driver.navigate().refresh();

				Thread.sleep(10000);
				//logout
				aemHomeObj.AEMLogout();

			}

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

