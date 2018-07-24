package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMProjectsPage {
	ArsinSeleniumAPI oASelFW;

	public AEMProjectsPage(){

	}
	public AEMProjectsPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void verifyProjectsPage(String pageName){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='endor-BlackBar-title']")));
		
		oASelFW.effecta("verifyElementPresent","//div[@class='endor-BlackBar-title']",pageName);
		System.out.println("Verified Projects Page");
	}
	
	public void ClickRequiredPage(String pageName){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+pageName+"')]")));

		oASelFW.effecta("click","//h4[contains(text(),'"+pageName+"')]",pageName);
	}
	
	public void ClickRequiredTitle_Translation(String title){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+title+"')]/following::button/i")));

		oASelFW.effecta("click","//h5[text()='Method']/parent::div/parent::li/parent::ul/parent::div/following-sibling::div/button/i&&//a[contains(text(),'"+title+"')]/following::button/i",title);
	}
	
	public void Click_TranslationJob(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//a[contains(text(),'Translation Job')]/following::button/i
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article[@id='translation_pod_translationjob']/div/nav//a/following::div/following::div/following::div/button")));
		oASelFW.effecta("click","//article[@id='translation_pod_translationjob']/div/nav//a/following::div/following::div/following::div/button","Translation Job");
	}
	
	public void ClickRequiredTitle_EditButton(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Edit']")));

		oASelFW.effecta("click","//button[@title='Edit']","Edit");
	}
	
	public void ClickTranslation(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Translation']")));

		oASelFW.effecta("click","//a[text()='Translation']","Translation");
	}
	
	
	public void SelectTranslationMethod(String translationMethod){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='translationMethod']")));

		oASelFW.effecta("select","//select[@name='translationMethod']",translationMethod,"Translation Method");
	}
	
	public void SelectTranslationProvider(String translationProvider){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='translationProvider']")));

		oASelFW.effecta("select","//select[@name='translationProvider']",translationProvider,"Translation Provider");
	}
	
	public void ClickDone(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[text()='Done']")));

		oASelFW.effecta("click","//button/span[text()='Done']","Done");
	}
	
	public void ClickBackIcon(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Back']")));

		oASelFW.effecta("click","//button[@title='Back']","Back icon");
	}
	
	
	public void selectJob(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='select']")));
		oASelFW.effecta("click","//i[@class='select']","select job");
	}
	
	public void ClickTranslationJob_dropdown(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-target='#translation_popover_translationjob']")));

		oASelFW.effecta("click","//a[@data-target='#translation_popover_translationjob']","Translation Job drop down");
	}
	
	public void ClickTranslationJob_dropdown_ClickStart(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'start')]")));

		oASelFW.effecta("click","//a[contains(@class,'start')]","Start");
	}
	
	
	public void ClickTranslationJob_ClickRequiredTitle(String title){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+title+"')]/parent::a/preceding-sibling::i[1]")));

		oASelFW.effecta("click","//h4[contains(text(),'"+title+"')]/parent::a/preceding-sibling::i[1]",title);
	}
	
}
