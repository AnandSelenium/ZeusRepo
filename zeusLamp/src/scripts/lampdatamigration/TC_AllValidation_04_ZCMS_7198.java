package scripts.lampdatamigration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.commons.collections.MultiMap;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.lampdatamigration.BaseClass;
import classes.lampdatamigration.RetrieveNode;
import classes.aem.AEMHomePage;
import classes.aem.AEMLoginPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


/**
 * 
 * @author avinash_ankireddy
 *
 */
public class TC_AllValidation_04_ZCMS_7198 {

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
	public void test() throws Exception
	{
		try{
			
			AEMLoginPage aemLoginObj          = new AEMLoginPage(oASelFW);
			AEMHomePage aemHomeObj            = new AEMHomePage(oASelFW);
			UtilityMethods utility            = new UtilityMethods(oASelFW);
			String userName=utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password=utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");
			
			
			Thread.sleep(15000);
			oASelFW.effecta("waitForPageToLoad");
			
			
			//LOGIN
			aemLoginObj.login(userName,Password);
			
			//Verify Home Page
			aemHomeObj.verifyHomePage();
			
			oASelFW.driver.get("http://aem-test-auth-1.vmware.com:8080/aem/tags.html/etc/tags");
			Thread.sleep(5000);
			
			Properties prop2 = new Properties();
			BaseClass bc1 = new BaseClass(oASelFW);
			
			//retrieving data from config.properties
			prop2.load(RetrieveNode.class.getClassLoader().getResourceAsStream("scripts//lampdatamigration//config.properties"));
			
			String[] tags={"Techpaper Solutionarea","Techpaper Technicalresource"};
			
			String[] fileNames={"TechPapersolutionarea","TechPaperTechnicalResource"}; 
			
			for(int x=0;x<tags.length;x++){
			

			ArrayList<String> colNames = utility.getExcelSheetColumnValues(oASelFW.sAutomationPath+"Data\\ZeusLAMP\\"+fileNames[x]+".xlsx", 0); // get Column Names

			HashMap<String,String[]> listOfLists =utility.readColumnValues(oASelFW.sAutomationPath+"Data\\ZeusLAMP\\"+fileNames[x]+".xlsx",colNames);

			List<String> jcr_component = new ArrayList<String>();
			for(int d=0;d<listOfLists.get(colNames.get(0)).length;d++){
				jcr_component.add(listOfLists.get("jcr:title")[d]);
			}
			
			
			List<String> jcr_component1 = new ArrayList<String>();
			for(int d=0;d<listOfLists.get(colNames.get(0)).length;d++){
				jcr_component1.add(listOfLists.get("jcr:description")[d]);
			}
		
		
				
				WebDriverWait wait= new WebDriverWait(oASelFW.driver,60);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+tags[x]+"')]")));
				oASelFW.effecta("verifyElementPresent","//div[contains(text(),'"+tags[x]+"')]","Element "+tags[x]+" is present");
				oASelFW.effecta("click","//div[contains(text(),'"+tags[x]+"')]","clicking on "+ tags[x]);
				Thread.sleep(6000);
				
			
			for(int y=0;y<listOfLists.get("jcr:title").length;y++){
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+jcr_component.get(y).trim()+"')]")));
				oASelFW.effecta("verifyElementPresent","//div[contains(text(),'"+jcr_component.get(y).trim()+"')]","Element "+jcr_component.get(y)+" is present");
				oASelFW.effecta("click","//div[contains(text(),'"+jcr_component.get(y).trim()+"')]","clicking on "+ jcr_component.get(y));
				Thread.sleep(5000);
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+jcr_component1.get(y).trim()+"')]")));
				oASelFW.effecta("verifyElementPresent","//div[contains(text(),'"+jcr_component1.get(y).trim()+"')]","Element "+jcr_component1.get(y)+" is present");
	
				
			}
			}
			
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}


}