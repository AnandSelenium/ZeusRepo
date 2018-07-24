package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMLoginPage {
	ArsinSeleniumAPI oASelFW;

	public AEMLoginPage(){

	}
	public AEMLoginPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void login(String userName,String password){
		
		System.out.println("userName:" + userName + "password: "+ password);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='coral-Heading coral-Heading--1']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit-button']")));
		
		oASelFW.effecta("type","//input[@id='username']",userName,"User Name");
		oASelFW.effecta("typePassword","//input[@id='password']",password,"Password");
		oASelFW.effecta("clickAndWait","//button[@id='submit-button']","Submit");
	
		System.out.println("Login sucessful");
	}
	
	public void openURL(String url){
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Launching URL","Successfully launched  URL:"+url,"Pass"); 
	}

}
