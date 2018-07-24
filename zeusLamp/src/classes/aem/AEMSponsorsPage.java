package classes.aem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;


/**
 * @author avinash_ankireddy
 * @Page Agenda Header Page
 */


public class AEMSponsorsPage {


	ArsinSeleniumAPI oASelFW;


	public AEMSponsorsPage(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}


	//h1[contains(text(),'SPONSORSHIP - VMWORLD US')]
		public void VerifySponsorHeaderTitle(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'"+text+"')]","verifying "+text);

			//oASelFW.driver.switchTo().defaultContent();
		}

		
		public void VerifySponsorHeaderTitle_InPublishMode(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'"+text+"')]","verifying "+text);

			//oASelFW.driver.switchTo().defaultContent();
		}

		
		public void VerifySponsorContent(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//ul/li[contains(text(),'"+text+"')]","verifying "+text);

			//oASelFW.driver.switchTo().defaultContent();
		}
		
		public void VerifySponsorContent_InPublishMode(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//ul/li[contains(text(),'"+text+"')]","verifying "+text);

			//oASelFW.driver.switchTo().defaultContent();
		}
		
		public void VerifySponsorContentDescription(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//p[contains(text(),'"+text+"')]","verifying "+text);

			oASelFW.driver.switchTo().defaultContent();
		}
		
		public void VerifySponsorLevelHeading(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//h3[contains(text(),'"+text+"')]","verifying "+text);

			//oASelFW.driver.switchTo().defaultContent();
			
		}
		
		
		
		public void VerifySponsorLevelHeading_InPublishMode(String text)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'"+text+"')]")));
			oASelFW.effecta("verifyElementPresent","//h3[contains(text(),'"+text+"')]","verifying "+text);

			//oASelFW.driver.switchTo().defaultContent();
			
		}
		
		public void VerifySponsorTabSectionHeading(String text[],int n)
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			for(int i=0;i<n;i++)
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text[i]+"')]")));
			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text[i]+"')]","verifying "+text[i]);
			}
			
			//oASelFW.driver.switchTo().defaultContent();
		}
	
		
		public void VerifySponsorTabSectionHeading_InPublishMode(String text[],int n)
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			for(int i=0;i<n;i++)
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+text[i]+"')]")));
			//oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+text[i]+"')]","verifying "+text[i]);
			}
			
			oASelFW.driver.switchTo().defaultContent();
		}
	
		
		public void VerifySponsorTabHeading(String text[], int n)
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			for(int i=0;i<n;i++)
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[contains(text(),'"+text[i]+"')]")));
			oASelFW.effecta("verifyElementPresent","//li/a[contains(text(),'"+text[i]+"')]","verifying "+text[i]);
			}
			//oASelFW.driver.switchTo().defaultContent();
			
		}
		
		

		public void VerifySponsorTabHeading_InPublishMode(String text[], int n)
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			for(int i=0;i<n;i++)
			{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[contains(text(),'"+text[i]+"')]")));
			oASelFW.effecta("verifyElementPresent","//li/a[contains(text(),'"+text[i]+"')]","verifying "+text[i]);
			}
			//oASelFW.driver.switchTo().defaultContent();
			
		}
		
		
		
		public void VerifySponsorRespectiveLogoBelowHeading(String sponsorTabHeading,String logo)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+sponsorTabHeading+"')]/following::img[@src='"+logo+"']")));
			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+sponsorTabHeading+"')]/following::img[@src='"+logo+"']","Verifying Respective Logo below "+sponsorTabHeading);
			oASelFW.driver.switchTo().defaultContent();
		}
		
		public void ClickSponsorRespectiveLogoBelowHeading(String sponsorTabHeading,String logo)
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+sponsorTabHeading+"')]/following::img[@src='"+logo+"']")));
			oASelFW.effecta("click","//h2[contains(text(),'"+sponsorTabHeading+"')]/following::img[@src='"+logo+"']","Respective Logo below "+sponsorTabHeading);
			
		}
		
		public void click_RespectiveLogoAndVerifyPageOpenInNewWindow(String sponsorTabHeading,String logo,String linkUrl) throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);	
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+sponsorTabHeading+"')]/following::img[@src='"+logo+"']")));
			oASelFW.effecta("click","//h2[contains(text(),'"+sponsorTabHeading+"')]/following::img[@src='"+logo+"']","Respective Logo below "+sponsorTabHeading);
			
			/*Thread.sleep(5000);
			String wind[]=oASelFW.effectaArray("getAllWindowNames");
			oASelFW.effecta("selectWindow",wind[1]);
			oASelFW.effecta("waitForPageToLoad");*/
			Thread.sleep(5000);
			ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
			oASelFW.driver.switchTo().window(tabs.get(2));
			String url=oASelFW.driver.getCurrentUrl();
			if(url.contains(linkUrl))
			{
				oASelFW.effecta("sendReport","Verify Respective Sponsor Page Open in New Window ","Successfully Verified Respective Sponsor Page Open in New Window","Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Respective Sponsor Page Open in New Window ","Unable to Open in New Window","Fail");
			}
			
			oASelFW.driver.switchTo().defaultContent();
			oASelFW.driver.close();
			Thread.sleep(3000);
			oASelFW.driver.switchTo().window(tabs.get(1));
			
		}
		
		
		public void verify_Sponsors_ListImages(String imagePath,String Label, int i) throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);	
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			oASelFW.effecta("waitForElementPresent","//h2[contains(text(),'"+Label+"')]/following::li/a/img","40");
			
			List<WebElement> list=oASelFW.driver.findElements(By.xpath("//h2[contains(text(),'"+Label+"')]/following::li/a/img"));
			System.out.println("list size is:"+list.size());

			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+Label+"')]/following::li["+i+"]/a/img","Sponsors Image");
			WebElement text=oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'"+Label+"')]/following::li["+i+"]/a/img"));
			String actualText=text.getAttribute("src");

			System.out.println("Actual ImagePath:"+actualText);
			if(actualText.contains(imagePath))
			{
				oASelFW.effecta("sendReport","Verify Sponsors Logo is available under :"+Label,"Sponsors Logo is available under :"+Label,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Sponsors Logo is available under :"+Label,"Sponsors Logo is not available under :"+Label,"Fail");
			}
			//oASelFW.driver.switchTo().defaultContent();
		}
		
		
		public void verify_Sponsors_ListImages_InpublishMode(String imagePath,String Label, int i) throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);	
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			oASelFW.effecta("waitForElementPresent","//h2[contains(text(),'"+Label+"')]/following::li/a/img","40");
			
			List<WebElement> list=oASelFW.driver.findElements(By.xpath("//h2[contains(text(),'"+Label+"')]/following::li/a/img"));
			System.out.println("list size is:"+list.size());

			oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+Label+"')]/following::li["+i+"]/a/img","Sponsors Image");
			WebElement text=oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'"+Label+"')]/following::li["+i+"]/a/img"));
			String actualText=text.getAttribute("src");

			System.out.println("Actual ImagePath:"+actualText);
			if(actualText.contains(imagePath))
			{
				oASelFW.effecta("sendReport","Verify Sponsors Logo is available under :"+Label,"Sponsors Logo is available under :"+Label,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Sponsors Logo is available under :"+Label,"Sponsors Logo is not available under :"+Label,"Fail");
			}
			//oASelFW.driver.switchTo().defaultContent();
		}
		
		
		
		public void ClickSponsorHeading_InPublishMode(String sponsorTabHeading) throws InterruptedException
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			Actions action = new Actions(oASelFW.driver);
			
			WebElement element = oASelFW.driver.findElement(By.xpath("(//div[@class='container'])/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]"));
			((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			
			
			action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[@class='container'])/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]"))).click().build().perform();
			Thread.sleep(5000);
			oASelFW.effecta("sendReport","Click Sponsors Header: "+sponsorTabHeading,"Sponsors Header is Clicked successfully","Pass");
			
			/*wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='container'])[3]/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]")));
			oASelFW.effecta("click","(//div[@class='container'])[3]/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]",sponsorTabHeading);*/
		}
		
		public void ClickSponsorHeading_InPreviewMode(String sponsorTabHeading) throws InterruptedException
		{
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
			
			Actions action = new Actions(oASelFW.driver);
			
			WebElement element = oASelFW.driver.findElement(By.xpath("(//div[@class='container'])[3]/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]"));
			((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500); 
			
			
			action.moveToElement(oASelFW.driver.findElement(By.xpath("(//div[@class='container'])[3]/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]"))).click().build().perform();
			Thread.sleep(5000);
			oASelFW.effecta("sendReport","Click Sponsors Header: "+sponsorTabHeading,"Sponsors Header is Clicked successfully","Pass");
			
			/*wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='container'])[3]/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]")));
			oASelFW.effecta("click","(//div[@class='container'])[3]/ul/li/a[contains(text(),'"+sponsorTabHeading+"')]",sponsorTabHeading);*/
			//oASelFW.driver.switchTo().defaultContent();
		}
		
		
		
		
		
		
		
		
		
		
		
}




