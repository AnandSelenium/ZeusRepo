package scripts.aem_phase2.sprint1_prod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMHomePage;
import classes.vmware.VMwareTechPaperSearchPage;

import com.arsin.ArsinSeleniumAPI;


public class Company_Customers
{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Customers_BrowseStories",oASelFW.instanceName));	
	}
	@Test
	public void Company_Customers() throws Exception
	{
		try{	

			VMwareTechPaperSearchPage vmwtechsearch   = new VMwareTechPaperSearchPage(oASelFW);
			//vmwtechsearch.verifyVMwareCustomerPage();
			
			vmwtechsearch.verifyVMwareCustomerPage_recordcount_totalrecords();
			
			vmwtechsearch.clickViewCustdropdown("View Customer Stories");
			
			vmwtechsearch.clickViewCustdropdown_value("By Country");
			
			vmwtechsearch.clickViewCustdropdown("All");
			
			vmwtechsearch.clickViewCustdropdown_value("India");
			Thread.sleep(8000);
			
			vmwtechsearch.verifyVMwareCustomerPage_recordcount_totalrecords();
			
			
			String srcUrl=oASelFW.driver.getCurrentUrl();
			
			System.out.println("Src url..."+srcUrl);
			//oASelFW.driver.get("https://www-test15.vmware.com/company/customers.html#country=india");
			Thread.sleep(5000);
			
			 Boolean iselementpresent = oASelFW.driver.findElements(By.xpath("//h5[text()='Infosys Limited']")).size()!= 0;
			  if(iselementpresent)
			  {
				System.out.println("Element present");
			  }
			
			oASelFW.driver.close();
			
			WebDriver driver1= new ChromeDriver();
			
			
			Thread.sleep(10000);
			
			driver1.navigate().refresh();
			Thread.sleep(10000);
			driver1.manage().window().maximize();
			
			driver1.get(srcUrl);
			Thread.sleep(20000);
			
			 Boolean iselementpresent1 = driver1.findElements(By.xpath("//h5[text()='Infosys Limited']")).size()!= 0;
			  if(iselementpresent1)
			  {
				System.out.println("Element present");
			  }
				//vmwtechsearch.verifyVMwareCustomerPage_recordcount_totalrecords();
			
			  String recordcnt=driver1.findElement(By.xpath("//span[@id='recordCount']")).getText();
				System.out.println("records"+recordcnt);
				
				String totrecordcnt=driver1.findElement(By.xpath("//span[@id='totalRecords']")).getText();
				System.out.println("tot records"+totrecordcnt);
				if(!recordcnt.isEmpty())
					
				{
					System.out.println("Successfully verifed records in page as: "+recordcnt+" of "+totrecordcnt);
				}
			driver1.close();
			
		
			
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			oASelFW.reportStepDtlsWithScreenshot (e.getMessage(),e.getMessage(),"Fail");
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}
}