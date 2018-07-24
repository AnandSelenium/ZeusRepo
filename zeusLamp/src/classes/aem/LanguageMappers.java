package classes.aem;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.util.StringTokenizer;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;


/**
 * @author Swathi Namburi
 * @Page LanguageMappers
 */


public class LanguageMappers {


	ArsinSeleniumAPI oASelFW;


	public LanguageMappers(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}

	
	public void VerifyTranslationReplacePage() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Translation Search and Replace Configuration')]")));
		oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'Translation Search and Replace Configuration')]","Translation Search and Replace Page");
		
	}
	
	
	public void SelectTranslationMethod(String translationMethod){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='translationMethod']")));

		oASelFW.effecta("select","//select[@name='translationMethod']",translationMethod,"Translation Method");
	}
	
	
	public void SelectTranslationLocale(String locale){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='locale']")));

		oASelFW.effecta("select","//select[@id='locale']",locale,"Translation locale--"+locale);
	}
	
	
	public void ClickAdd() throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		Actions action = new Actions(oASelFW.driver);
		
		WebElement element = oASelFW.driver.findElement(By.xpath("//tr//td/input[@id='addDialog']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr//td/input[@id='addDialog']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td/input[@id='addDialog']")));
		oASelFW.effecta("click","//tr//td/input[@id='addDialog']","Click Add");
	}
	
	
	public void EnterEnglishID(String value) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		 
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='addDialogBox']/table/tbody/tr[1]/td/label[contains(text(),'English Id')]/following::td/input")));

		oASelFW.effecta("type","//div[@id='addDialogBox']/table/tbody/tr[1]/td/label[contains(text(),'English Id')]/following::td/input",value,"English ID");
	}
	
	public void EnterTargetLanguageID(String value){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='addDialogBox']/table/tbody/tr[3]/td/label[contains(text(),'Language Id')]/following::td/input")));

		oASelFW.effecta("type","//div[@id='addDialogBox']/table/tbody/tr[3]/td/label[contains(text(),'Language Id')]/following::td/input",value,"Language Id");
	}
	
	
	public void ClickAdd_LanguageReplace(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[contains(text(),'Add')]")));

		oASelFW.effecta("click","//button/span[contains(text(),'Add')]","Click Add under Relace Language");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}




