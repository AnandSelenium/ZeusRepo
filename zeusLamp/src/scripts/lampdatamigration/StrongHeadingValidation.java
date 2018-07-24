package scripts.lampdatamigration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arsin.ArsinSeleniumAPI;

/**
 * 
 * @author avinash_ankireddy
 *
 */
public class StrongHeadingValidation
{
	
	ArsinSeleniumAPI oASelFW = null;
	
	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})
	
	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
	}
	
	@Test
	public void test() throws Exception
	{
		try
		{

			System.setProperty("webdriver.chrome.driver", "Y:\\Resources\\chromedriver.exe");
			oASelFW.driver = new ChromeDriver();
			oASelFW.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			oASelFW.driver.manage().window().maximize();
			
			oASelFW.driver.get("http://www-stage.vmware.com/in.html");
			
			//oASelFW.driver.findElement(By.xpath("//a[contains(@id,'nav_sidebar_1')]/i/following-sibling::span")).click();
			
			List<WebElement> anchorTagsList = oASelFW.driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are "+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) 
			{
				
					String url = anchorTagElement.getAttribute("title");
					oASelFW.effecta("sendReport","Validating links","Successfully validated the links as :" +url,"Pass");
					System.out.println(url);
				
			}
			
				
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}
		}
			
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.driver.quit();
	}



}