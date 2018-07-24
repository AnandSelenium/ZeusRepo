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
 * @Page TwoColumnContainerPage
 */


public class TwoColumnContainerPage {


	ArsinSeleniumAPI oASelFW;


	public TwoColumnContainerPage(ArsinSeleniumAPI oASelFW)
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
	

	
	
	public void verifyElementPresent(String value) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+value+"')]")));
		oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'"+value+"')]","Element present with value "+ value);
		Thread.sleep(5000);
	}
	
	
	public void verifyVerticalBorderPresent()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'expand_or_collapse_two_col')]/following::div[1]")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@id,'expand_or_collapse_two_col')]/following::div[1]")))
		{
			oASelFW.effecta("sendReport","Verfying whether the vertical border is present or not","Successfully verified vertical border is present","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Verfying whether the vertical border is present or not","Successfully verified vertical border is not present","Fail");
		}
		
		
	}
	
	
	
	public void verifyHorizontalBorderPresent()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Expand All')]/../../../../../../div")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(.,'Expand All')]/../../../../../../div")))
		{
			oASelFW.effecta("sendReport","Verfying whether the Horizontal border is present or not","Successfully verified Horizontal border is present","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Verfying whether the Horizontal border is present or not","Successfully verified Horizontal border is not present","Fail");
		}
		
		
	}
	
	

}




