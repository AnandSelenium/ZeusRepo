package classes.aem;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMPartnerLoginPage {
	ArsinSeleniumAPI oASelFW;

	public AEMPartnerLoginPage(){

	}
	public AEMPartnerLoginPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	
	public void LoginFormProperties(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::input")));
	
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following-sibling::input",value,fieldName);
	
	}
	
	public void LoginFormProperties_Modified(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following::input")));
	
		oASelFW.effecta("type","//label[contains(text(),'"+fieldName+"')]/following::input",value,fieldName);
	
	}
	
	
	public void LoginFormProperties_elements(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following::input")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following::input",value,fieldName);
	}
	
	public void catalog_Cta_Label(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::input")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following-sibling::input",value,fieldName);
	}
	
	public void catalog_Cta_URL(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following::input")));
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following::input",value,fieldName);
	}
	
	public void LoginFormProperties_elements_Modified(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following::span/span/input")));
		oASelFW.effecta("type","//label[contains(text(),'"+fieldName+"')]/following::span/span/input",value,fieldName);
	}
	
	
	public void LoginFormProperties_ForgotPassword(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='./forgotpassword']")));
	
		oASelFW.effecta("type","//input[@name='./forgotpassword']",value,"Forgot Passowrd");
	
	}
	
	
	public void LoginFormProperties_Register(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='./register']")));
	
		oASelFW.effecta("type","//input[@name='./register']",value,"Register");
	
	}
	
	public void LoginFormPropertiesHeaderLinks(String fieldName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'"+fieldName+"')]")));
	
		oASelFW.effecta("click","//a[contains(text(),'"+fieldName+"')]",fieldName);
	
	}
	
	public void LoginFormProperties_ServiceCatalogProperties(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following-sibling::input")));
	
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following-sibling::input",value,fieldName);
	
	}
	
	
	public void PartnerLogin_Username(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
		oASelFW.effecta("type","//input[@id='username']",value,"Username");
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void PartnerLogin_Password(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
		oASelFW.effecta("type","//input[@id='password']",value,"Password");
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	public void VerifyPartnerLogin_CTALogin(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'"+value+"')]")));
		oASelFW.effecta("verifyElementPresent","//button[contains(text(),'"+value+"')]",value);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[contains(text(),'"+value+"')]")))
		{
			oASelFW.effecta("sendReport","Verify Author is able to view CTALogin", "Author is able to view CTALogin","Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Author is able to view CTALogin","Author is unable to view CTALogin","Fail");
		}
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	
	public void ClickonLoginCTA(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+value+"']")));
		oASelFW.effecta("click","//button[text()='"+value+"']","Login CTA Button");
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void ClickonLink(String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
		oASelFW.effecta("click","//a[text()='"+value+"']",value);
		oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public String modifyUrl(){
		String editorurl=oASelFW.driver.getCurrentUrl();
		String  contenturl=null;
		
		if(editorurl.contains("/editor.html")){
			contenturl=editorurl.replaceAll("/editor.html", "");
			
			oASelFW.driver.get(contenturl);
			
		}
		
		return contenturl;
	}
	
	
	
	public void ClickAndVerifyLink(String value,String linkUrl) throws Exception{
		
		//modifyUrl();
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));
	
		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']",value);

		Thread.sleep(3000);

		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		
		/*ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
*/		
		String url=oASelFW.driver.getCurrentUrl();
	
		if(url.contains(linkUrl)){
			oASelFW.effecta("sendReport","Verify "+value+" link is configured","Successfully verified link as:"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify "+value+" link is configured","Unable to verify link as:"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		
		
		
		Thread.sleep(3000);
		
	//	oASelFW.driver.switchTo().window(tabs.get(1));
		
		//oASelFW.driver.switchTo().defaultContent();
		
		oASelFW.driver.navigate().back();
	}

		
	
	public void ClickLoginCTAAndVerifyLink(String value,String linkUrl) throws Exception{
	//	modifyUrl();
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		
	//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+value+"']")));
	
		oASelFW.effecta("clickAndWait","//button[text()='"+value+"']",value);

		Thread.sleep(3000);

		/*String wins[]=oASelFW.effectaArray("getAllWindowNamws");
		oASelFW.effecta("selectWindow",wins[wins.length-1]);*/
		
		/*ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
*/
		String url=oASelFW.driver.getCurrentUrl();
		
		if(url.contains(linkUrl)){
			oASelFW.effecta("sendReport","Verify Login CTA '"+value+"' link is configured","Successfully verified link as:"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Login CTA '"+value+"' link is configured","Unable to verify link as:"+linkUrl+" Displayed url is:"+url,"Fail");
		}
		
		
		
	//	oASelFW.driver.close();
		Thread.sleep(3000);
		
	//	oASelFW.driver.switchTo().window(tabs.get(1));
		
		//oASelFW.driver.switchTo().defaultContent();
		
		oASelFW.driver.navigate().back();
	}

	
	public void ClickAndVerifyLink_PartnerLoginCTALink(String value,String linkUrl) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+value+"']")));

		oASelFW.effecta("clickAndWait","//a[text()='"+value+"']",value);
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		oASelFW.driver.switchTo().window(tabs.get(2));
		String url=oASelFW.driver.getCurrentUrl();
		Thread.sleep(5000);

		if(url.contains(linkUrl)){
			oASelFW.effecta("sendReport","Verify "+value+" link is configured","Successfully verified link as:"+linkUrl,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify "+value+" link is configured","Unable to verify link as:"+linkUrl+" Displayed url is:"+url,"Fail");
		}
	oASelFW.driver.close();
	Thread.sleep(3000);
	oASelFW.driver.switchTo().window(tabs.get(1));
}

	
	public void LoginFormProperties_ServiceCatalogProperties_Elements(String fieldName,String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+fieldName+"']/following::input")));
	
		oASelFW.effecta("type","//label[text()='"+fieldName+"']/following::input",value,fieldName);
	
	}
	
	public void LoginFormProperties_ServiceCatalogProperties_SelectCatalogIcon(String fieldName, String value)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+fieldName+"')]/following::select")));
	
		oASelFW.effecta("select","//label[contains(text(),'"+fieldName+"')]/following::select",value,fieldName);
	
	}
	
	//h1[contains(text(),'LoginPage')]
	
	public void PartnerLoginPage_VerifyLoginTitle(String title) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'"+title+"')]")));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//Thread.sleep(2000);
		System.out.println("ContentFrame");
		//WebElement frame = oASelFW.driver.findElement(By.xpath("//iframe[@id='ContentFrame']"));
		//oASelFW.driver.switchTo().frame(frame);
		Thread.sleep(5000);
	    System.out.println("//h3[contains(text(),'"+title+"')]");
		oASelFW.effecta("verifyElementPresent","//h3[contains(text(),'"+title+"')]",title);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h1[contains(text(),'"+title+"')]")))
			{
				oASelFW.effecta("sendReport","Verify Partner Login Page login Title is displaying as expected","Partner Login Page login Title is displaying as expected: "+title,"Pass");
			}
			else{
				oASelFW.effecta("sendReport","Verify Partner Login Page login Title is displaying as expected","Partner Login Page login Title is not displaying as expected: "+title,"Fail");

			}
		
		//oASelFW.driver.switchTo().defaultContent();
		}
		


	public void PartnerLoginPage_CatelogIcon_PDF() throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='catelog_panel skyblue']/i[@class='fa fa fa-file-pdf-o']")));
	   
		oASelFW.effecta("verifyElementPresent","//div[@class='catelog_panel skyblue']/i[@class='fa fa fa-file-pdf-o']","PDF Icon");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='catelog_panel skyblue']/i[@class='fa fa fa-file-pdf-o']")))
			{
				oASelFW.effecta("sendReport","Verify Partner Login Catalog Icon","Partner Login Catalog Icon is PDF","Pass");
			}
			else{
				oASelFW.effecta("sendReport","Verify Partner Login Catalog Icon","Partner Login Catalog Icon is not displayed","Fail");

			}
		
		//oASelFW.driver.switchTo().defaultContent();
		}
	
	
	
public void PartnerLoginPage_VerifyLoginCTA(String loginCTA) throws Exception{
		
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("ContentFrame")));
	Thread.sleep(2000);
	System.out.println("ContentFrame");

	//oASelFW.driver.switchTo().frame(oASelFW.driver.findElement(By.id("ContentFrame")));
	
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'"+loginCTA+"')]",loginCTA);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+loginCTA+"')]")))
			{
				oASelFW.effecta("sendReport","Verify Partner Login Page login CTA is displaying as expected","Partner Login Page login CTA is displaying as expected: "+loginCTA,"Pass");
			}
			else{
				oASelFW.effecta("sendReport","Verify Partner Login Page login CTA is displaying as expected","Partner Login Page login CTA is not displaying as expected: "+loginCTA,"Fail");

			}
		
		oASelFW.driver.switchTo().defaultContent();
		
		}
	
public void LoginFormProperties_ClickLoginCTA(String loginCTA) throws InterruptedException
{
	
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("ContentFrame")));
	Thread.sleep(2000);
	
	System.out.println("ContentFrame");
	
	oASelFW.effecta("click","//a[contains(text(),'"+loginCTA+"')]",loginCTA);
	
	oASelFW.driver.switchTo().defaultContent();
}
	

public void PartnerLoginPage_VerifyLoginCTA_OpenNewWindowOrSelf() throws Exception{
	
	Thread.sleep(15000);
	ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
	 oASelFW.driver.switchTo().window(tabs.get(2));
	
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Sign In to Partner Central')]")));

	oASelFW.effecta("verifyElementPresent","//h2[contains(text(),'Sign In to Partner Central')]","Sign In to Partner Central");
	if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[contains(text(),'Sign In to Partner Central')]")))
		{
			oASelFW.effecta("sendReport","Verify Partner login page is opened in new window as expected","Partner login page is opened in new window as expected","Pass");
		}
		else{
			oASelFW.effecta("sendReport","Verify Partner login page is opened in new window as expected","Partner login page is displayed as expected","Fail");

		}
	
	//oASelFW.driver.switchTo().window(tabs.get(0));
	}

	








}