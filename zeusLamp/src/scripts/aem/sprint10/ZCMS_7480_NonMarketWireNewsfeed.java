package scripts.aem.sprint10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import classes.aem.AEMAgendaHeaderPage;
import classes.aem.AEMAssetsPage;
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

public class ZCMS_7480_NonMarketWireNewsfeed {

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
	public void ZCMS_7480_NonMarketWireNewsfeed() throws Exception{
		try{	

			oASelFW.driver.manage().timeouts().pageLoadTimeout(800, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                     = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj                       = new AEMHomePage(oASelFW);
			AEMSitesPage aemSitesObj                     = new AEMSitesPage(oASelFW);
			AEMPageCreation aemPageCreateObj             = new AEMPageCreation(oASelFW);
			AEMComponentCreation aemComponentsObj        = new AEMComponentCreation(oASelFW);
			UtilityMethods utility                       = new UtilityMethods(oASelFW);
			AEMProjectsPage aemProjectsObj               = new AEMProjectsPage(oASelFW);
			AEMPartnerLoginPage aemPartnerLoginObj       = new AEMPartnerLoginPage(oASelFW);
			AEMNewsAndEventsPage aemNewsAndEventsPageObj = new AEMNewsAndEventsPage(oASelFW);
			AEMAssetsPage aasp 					  		 = new AEMAssetsPage(oASelFW);
			AEMAgendaHeaderPage aahp				= new AEMAgendaHeaderPage(oASelFW);
			
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,password);

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
			
			aemSitesObj.clickOnRequiredSite("Company");
			
	
			aemSitesObj.clickOnRequiredSite("news");
			
			
			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(5000);
			//aemSitesObj.clickOnRequiredSite("onlyAutoQA");
			
			//click on create page
			aemSitesObj.clickCreateAndClickOnRequiredLink("Create Page");
			
			//select page template
			aemSitesObj.selectPageTemplate("VMware CClamp Template");

			//click next after selecting template
			aemSitesObj.clickNext();

			//fill required fields
			String pageName=aemPageCreateObj.page_Creation();
			System.out.println("Page Name"+pageName);

			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			//Click on Open Page
			aemPageCreateObj.ClickOpenPage("Open page");
			Thread.sleep(15000);

			//Switch to tab
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(1));
			
			//oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA/NonMarketNewsFeed.html");

			oASelFW.effecta("waitForPageToLoad");
			Thread.sleep(10000);
			

			aemComponentsObj.clickOnToggleSidePanel();
			
			aemComponentsObj.clickOnTabPanelLinks("Components");
			
			Thread.sleep(10000);
			
			aemComponentsObj.enterTextInput("News Releases Local Listing - Non Market Wire", "Components");
			
			aemComponentsObj.dragAndDropComponents("News Releases Local Listing - Non Market Wire", "Components","");
			Thread.sleep(5000);
			
			aahp.clickTextComponent("News Releases Local Listing - Non Market Wire");
			
			aahp.clickOnTool("CONFIGURE");
			Thread.sleep(5000);

			aemComponentsObj.EnterTextField("Data Size","5");

			
			aemComponentsObj.SelectMarketWireRequiredOption("Select Skin Type","Company Blue");	//Select the Company Blue		
		

			//Save
			aemComponentsObj.ClickSaveIcon();	
			Thread.sleep(5000);


			//Click on Preview button
			aemHomeObj.PreviewButton();
			Thread.sleep(5000);

			oASelFW.driver.navigate().refresh();
			Thread.sleep(2000);
			
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			Thread.sleep(10000);
			 

		
			
			
			//oASelFW.driver.findElement(By.xpath("//div[@class='faq_block']/"));
	        List<WebElement> list1 = oASelFW.driver.findElements(By.xpath("//div[@class='faq_block noFade']"));
	        		 
	        System.out.println("Calender news list "+list1.size());
	        
	        
	        List<String> callist = new ArrayList<String>();

	        for(int j=0,i=1;j<list1.size();j++,i++){  
	        	callist.add(list1.get(j).findElement(By.xpath("//div[@class='faq_block noFade']["+i+"]/a/span/span/p[1]")).getText());
	        	
	           System.out.println("Calendar dates value--"+callist);
	        }
	
	        System.out.println("Calendar dates value--"+callist);
			
	        aemComponentsObj.ValidateDatesInDescendingOrder(callist);

	        oASelFW.driver.close();
			Thread.sleep(5000);
			
			
			oASelFW.driver.switchTo().window(tabs.get(0));
			oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);
			
			
			
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
		catch (Exception e) 
		{
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
