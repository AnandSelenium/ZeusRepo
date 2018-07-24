package classes.aem;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
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
 * @Page Agenda Header Page
 */


public class SubmitterPage {


	ArsinSeleniumAPI oASelFW;


	public SubmitterPage(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}



	public void clickOnSubmitterComponent()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-path,'submitter') and contains(@draggable,'true')]")));
		oASelFW.effecta("click","//div[contains(@data-path,'submitter') and contains(@draggable,'true')]","clicking on submitter component");

	}

	public void clickOnConfigure()
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'Configure')]")));
		oASelFW.effecta("click","//button[contains(@title,'Configure')]","clicking on configure");
	}


	public void clickOnAddField()
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Submitter Data')]/following::button[contains(text(),'Add field')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Submitter Data')]/following::button[contains(text(),'Add field')]","clicking on add field");
	}


	public void typeInputData(String label, String value)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[contains(text(),'"+label+"')])[12]/following-sibling::input")));
		oASelFW.effecta("type","xpath=(//label[contains(text(),'"+label+"')])[12]/following-sibling::input",value,"typing "+ value);
		
	
	}
	
	
	
	
			
			public void clickOnBrowseButton(String label)
			{
				
				WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[contains(text(),'"+label+"')])[12]/following::button[contains(@title,'Browse')]")));
				oASelFW.effecta("click","xpath=(//label[contains(text(),'"+label+"')])[12]/following::button[contains(@title,'Browse')]","Clicking on browse button");
				
			
			}	
	
	
	public void typeInputData1(String label, String value)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[contains(text(),'"+label+"')])[12]/following-sibling::span/span/input")));
		oASelFW.effecta("type","xpath=(//label[contains(text(),'"+label+"')])[12]/following-sibling::span/span/input",value,"typing "+ value);
		
	
	}
	
	
	
		public void clickOnDone()
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Done']")));
			oASelFW.effecta("click","//button[@title='Done']","Save");
		}

	



}




