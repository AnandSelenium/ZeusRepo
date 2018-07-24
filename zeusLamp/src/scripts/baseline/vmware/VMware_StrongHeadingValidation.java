package scripts.baseline.vmware;

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
public class VMware_StrongHeadingValidation
{
	
	ArsinSeleniumAPI oASelFW = null;
	
	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})
	
	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("VMware_Events",oASelFW.instanceName));
	}
	
	@Test
	public void test() throws Exception
	{
		try
		{

			oASelFW.driver.get("http://www-stage.vmware.com/in.html");
			Thread.sleep(8000);
			
			List<WebElement> anchorTagsList = oASelFW.driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are "+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) 
			{
				
					String url = anchorTagElement.getAttribute("title");
					oASelFW.effecta("sendReport","Verifying the url "+url,"Successfully validated the url  "+url,"Pass");
					System.out.println(url);
					
				
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