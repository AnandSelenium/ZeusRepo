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

public class TC_ZCMS_4698_CreateSocialShare_EU_InteriorPageWithNoCarouselTemplate {

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
	public void TC_ZCMS_4698_CreateSocialShare_US_InteriorPageWithNoCarouselTemplate() throws Exception{
		
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

			ArrayList<String> urls=new ArrayList<String>();
			

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

			Thread.sleep(3000);

			
			//select page template
			aemSitesObj.selectPageTemplate("VMWorld Interior Page with No Carousel");


			//click next after selecting template
			aemSitesObj.clickNext();


			//fill required fields
			pageName=aemPageCreateObj.page_Creation();
			Thread.sleep(6000);


			//Verify Page Created
			aemPageCreateObj.verifyPageCreated("Your page has been created");

			Thread.sleep(15000);
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
			Thread.sleep(5000);
			
			 
			//Click on Insert New Component drop down option as "Social Share"
			aemComponentsObj.ClickInsertNewComponent_DropdownOption("Social Share");
			
			Thread.sleep(5000);
			
			/*oASelFW.driver.navigate().refresh();
			
			
			Thread.sleep(10000);*/
			
			
			//Double Click on Inserted Component "Social Share"
			aemComponentsObj.DoubleClickonInsertedComponent_Second("Social Share");
			
			
			//Enter details on Social Share window
			for(int i=1;i<5;i++)
			{
				//String value="SocialMedia"+i;
				
				String link_Label[]= {"Facebook","Twitter","LinkedIn","Youtube"};
				String link_ImageALTText[]= {"Facebook_Alt","Twitter_Alt","LinkedIn_Alt","Youtube_Alt"};
				String link_ImagePath[]= {"/content/dam/digitalmarketing/vmworld/images/header-facebook.png","/content/dam/digitalmarketing/vmworld/images/header-twitter.png","/content/dam/digitalmarketing/vmworld/images/icons_linkedin.png","/content/dam/digitalmarketing/vmworld/images/icons_youtube.png"};
				String link_BrowseSocialMedia_Url[]={"https://www.facebook.com","https://twitter.com/login","https://www.linkedin.com/","https://www.youtube.com/"};
				
				
				
				values.add(link_ImageALTText[i-1]);
				
				urls.add(link_BrowseSocialMedia_Url[i-1]);
				
				System.out.println("Array index: "+link_ImageALTText[i-1]);
				System.out.println("Multi Browser Array index: "+link_ImageALTText[i-1]);
			
				//Click on Add field
				aemComponentsObj.ClickAddField();
				
				Thread.sleep(3000);
				
				//aemComponentsObj.EnterMultiTextField_Browse("Image Path",link_ImagePath[i-1],i);  //Image Path
				
				aemComponentsObj.EnterMultiTextField("Image Alt Text",link_ImageALTText[i-1],i);  //Image ALT Text
				
				aemComponentsObj.EnterMultiTextField_Browse("URL",link_BrowseSocialMedia_Url[i-1],i);  //Browse Link
				
				aemComponentsObj.SelectMultiRequiredOption("Select URL Open type","New Window",i);  //Select URL Open type
			
			}
			
			
			//Save
			aemComponentsObj.ClickSaveIcon();
			
			Thread.sleep(5000);
			
			//Click on Preview button
			aemHomeObj.PreviewButton();
			
			Thread.sleep(3000);
			
			//Replace Editor.html with content
			/*aemComponentsObj.modifyUrl();
			Thread.sleep(5000);*/
			
			
			
			/*oASelFW.driver.navigate().refresh();
			Thread.sleep(8000);*/
			
			String link_Label[]= {"Facebook","Twitter","LinkedIn","Youtube"};
			
			String link_ImagePath[]= {"/content/dam/digitalmarketing/vmworld/images/header-facebook.png","/content/dam/digitalmarketing/vmworld/images/header-twitter.png","/content/dam/digitalmarketing/vmworld/images/icons_linkedin.png","/content/dam/digitalmarketing/vmworld/images/icons_youtube.png"};
			
			String link_BrowseSocialMedia_Url[]={"https://www.facebook.com","https://twitter.com/login","https://www.linkedin.com/","https://www.youtube.com/"};
			
			String link_ImageALTText[]= {"Facebook_Alt","Twitter_Alt","LinkedIn_Alt","Youtube_Alt"};
				
				//Verify Social Media Channels on Preview Page
				aemComponentsObj.verify_SocialShare_Values_US(link_ImageALTText[0],link_Label[0],1);	//facebook
				aemComponentsObj.verify_SocialShare_Values_US(link_ImageALTText[1],link_Label[1],2);	//Twitter
				aemComponentsObj.verify_SocialShare_Values_US(link_ImageALTText[2],link_Label[2],3);	//LinkedIn
				aemComponentsObj.verify_SocialShare_Values_US(link_ImageALTText[3],link_Label[3],4);	//Youtube
				
				
				//Click on Social Media Channel
				aemComponentsObj.ClickOn_SocialShare_Values_US(link_ImageALTText[0],link_BrowseSocialMedia_Url[0],1,link_Label[0]);	//facebook
				
				aemComponentsObj.ClickOn_SocialShare_Values_US(link_ImageALTText[1],link_BrowseSocialMedia_Url[1],2,link_Label[1]);	//Twitter
				aemComponentsObj.ClickOn_SocialShare_Values_US(link_ImageALTText[2],link_BrowseSocialMedia_Url[2],3,link_Label[2]);	//LinkedIn
				aemComponentsObj.ClickOn_SocialShare_Values_US(link_ImageALTText[3],link_BrowseSocialMedia_Url[3],4,link_Label[3]);	//Youtube 
			
		 oASelFW.driver.close();
			 oASelFW.driver.switchTo().window(tabs.get(0));
			 
			 aemAssestObj.SelectAndDeleteFolder(pageName);
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
