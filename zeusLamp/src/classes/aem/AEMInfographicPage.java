package classes.aem;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.util.StringTokenizer;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;


/**
 * @author avinash_ankireddy
 * @Page Infographic Content Card
 */


public class AEMInfographicPage {


	ArsinSeleniumAPI oASelFW;


	public AEMInfographicPage(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}


	public void selectValueUponLabel(String label,String value) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::span/select")));
		Select sel =new Select(oASelFW.driver.findElement(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::span/select")));
		sel.selectByValue(value);
		Thread.sleep(5000);
	}
	
	
	public void enterValueInInputUponLabel(String label,String value)
	{
		
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::input",value,"entering value "+ value);
		
	}
	
	public void enterValueInInputLinkUrl(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following::span/span/input")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following::span/span/input",value,"entering value "+ value);
		
	}
	
	
	
	public void clickOnBrowseButton(String label) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following::button[contains(@title,'Browse')]")));
		oASelFW.effecta("click","//label[contains(text(),'"+label+"')]/following::button[contains(@title,'Browse')]","clicking on browse button");
		Thread.sleep(3000);
		
		
	}
	
	public void clickOnProductURL() throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Content Root']")));
		oASelFW.effecta("click","//div[text()='Content Root']","Content Root Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='VMware']","VMware Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='Language Master Sites']","Language Master Sites Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='English']","English Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='Products']","Products Clicked");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]","clicking on confirm");
		Thread.sleep(3000);
	}
	
	
	public void clickOnBlurbURL() throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Content Root']")));
		oASelFW.effecta("click","//div[text()='Content Root']","Content Root Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='VMware']","VMware Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='Language Master Sites']","Language Master Sites Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='English']","English Clicked");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]","clicking on confirm");
		Thread.sleep(3000);
	}
	
	
	public void clickOnAssets() throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Assets']")));
		oASelFW.effecta("click","//div[text()='Assets']","Asset Clicked");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]","clicking on confirm");
		Thread.sleep(3000);
	}
	
	public void clickOnbin() throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='bin']")));
		oASelFW.effecta("click","//div[text()='bin']","Asset Clicked");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]","clicking on confirm");
		Thread.sleep(3000);
	}
	
	
	
	
	public void enterValueInTextareaUponLabel(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::textarea")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::textarea",value,"entering value "+ value);
	}
	
	public void assetValue(String label,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+label+"']/following::span/span/input")));
		oASelFW.effecta("type","//label[text()='"+label+"']/following::span/span/input",value,"entering value "+ value);
	}
	
	
	public void verifyElementPresent(String value) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+value+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+value+"')]","Element present with value "+ value);
		Thread.sleep(5000);
	}
	
	public void clickOnLampForm(String form) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='VMware']")));
		oASelFW.effecta("click","//div[text()='VMware']","Asset Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='English']","Asset Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='onlyAutoQAForms']","Asset Clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='"+form+"']","Asset Clicked");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')]","clicking on confirm");
		Thread.sleep(3000);
	}

}




