package classes.aem;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMHomePage {
	ArsinSeleniumAPI oASelFW;

	public AEMHomePage(){

	}
	public AEMHomePage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}

	public void verifyHomePage() throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='endor-Brand ']")));
		Thread.sleep(3000);

		//oASelFW.effecta("verifyElementPresent","//a[@class='endor-Brand']","Adobe Marketing Cloud");

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(text(),'Projects')]"))){
			oASelFW.effecta("sendReport","Verifying whether User Navigated to Home Page or not","Successfully verifed.User Navigated to AEM Home Page","Pass") ;
		}
		else{
			oASelFW.effecta("sendReportWithOutExit","Verifying whether User Navigated to Home Page or not","Unable to verify","Fail") ;
		}
	}

	public void clickSites()throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Experience Manager')]/following::div/a/div[contains(text(),'Sites')]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Experience Manager')]/following::div/a[@href='/sites.html/content']")));
		System.out.println("After wait for sites");
		Thread.sleep(10000);
		oASelFW.effecta("clickAndWait","//div[contains(text(),'Experience Manager')]/following::div/a/div[contains(text(),'Sites')]&&//div[contains(text(),'Experience Manager')]/following::div/a[@href='/sites.html/content']","Sites Option is clicked");
		System.out.println("Clicked on Sites");
		Thread.sleep(3000);
	}

	public void clickAssets(){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Assets')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/mnt/overlay/dam/gui/content/assetsrouter.html']")));
		System.out.println("After wait for sites");

		oASelFW.effecta("clickAndWait","//a[@href='/mnt/overlay/dam/gui/content/assetsrouter.html']/div[contains(text(),'Assets')]","Assets");
	}
	
	
	
	public void clickHeaderOptions(String option){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='heading']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Experience Manager']/following::span[text()='Search'])[1]")));
		System.out.println("wait for search");

		oASelFW.effecta("clickAndWait","xpath=(//span[text()='"+option+"'])[1]","Search");
		System.out.println("click on for search");
	}
	
	

	public void clickProjects() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Projects']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Projects']")));
		System.out.println("After wait for Projects");

		oASelFW.effecta("clickAndWait","//div[text()='Projects']","Projects");
		Thread.sleep(5000);

	}

	public void classicUI() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Projects')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Projects')]")));
		Actions act = new Actions(oASelFW.driver);
		WebElement mainMenu = oASelFW.driver.findElement(By.xpath("//div[contains(text(),'Projects')]"));
		Thread.sleep(3000);
		System.out.println("after sleep");
		act.moveToElement(mainMenu).moveToElement(oASelFW.driver.findElement(By.xpath("//div[contains(text(),'Projects')]"))).build().perform();
		Thread.sleep(3000);
		oASelFW.effecta("clickAndWait","//div[text()='Projects']/following-sibling::i[@title='Switch to Classic UI']&&//div[contains(text(),'Projects')]/i","Classic UI");
		Thread.sleep(10000);
		System.out.println("After wait for new window");
		String windows[]=oASelFW.effectaArray("getAllWindowNames");
		System.out.println("Windows size is"+windows.length);
		oASelFW.effecta("selectWindow",windows[1]);
		System.out.println("selected window");
	}

	public void AEMLogout() throws Exception{
		oASelFW.effecta("waitForPageToLoad");
		String windows[]=oASelFW.effectaArray("getAllWindowNames");
		System.out.println("Windows size is"+windows.length);
		
		if(windows.length>0){
			oASelFW.effecta("selectWindow",windows[0]);
		}
		
		Thread.sleep(2000);
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'endor-UserProfile-avatar')]")));

		//WebElement we=oASelFW.driver.findElement(By.xpath("//div[contains(@class,'endor-UserProfile-avatar')]"));

		/*Actions act=new Actions(oASelFW.driver);
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", we);
		act.moveToElement(we).click().build().perform();*/

		oASelFW.effecta("click","//div[contains(@class,'endor-UserProfile-avatar')]","End User Profile");
		Thread.sleep(3000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Sign Out')]")));
		oASelFW.effecta("clickAndWait","//a[contains(text(),'Sign Out')]","Sign Out");
	}

	public void switchToDefaultWindow() throws Exception{
		Thread.sleep(10000);
		String windows[]=oASelFW.effectaArray("getAllWindowNames");
		oASelFW.effecta("selectWindow",windows[0]);
	}
	
	public void PreviewButton() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[text()='Preview']")));
	
		oASelFW.effecta("click","//button/span[text()='Preview']","Preview");
		Thread.sleep(10000);
	
	}
	public void selectColumnView() throws Exception{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Card View']")));
		oASelFW.effecta("clickAndWait","//button[@title='Card View']","Card View");
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='List View']")));
		oASelFW.effecta("clickAndWait","//button[@title='List View']","List View");
		Thread.sleep(5000);
		
	}
	
	public void selectListView() throws Exception{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@title='Card View'])[2]")));
		oASelFW.effecta("clickAndWait","xpath=(//button[@title='Card View'])[2]","Card View");
		Thread.sleep(5000);
		
	}
	
	//button[@title='Card View']/i/following::span[text()='Card View'][2]
	
	/**--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * @author avinash_ankireddy
	 * @param link
	 * @throws InterruptedException
	 */
	
	public void clickOnLinks(String link) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+link+"')]")));
		oASelFW.effecta("click","//div[contains(text(),'"+link+"')]","Clicking on "+ link);
		Thread.sleep(5000);
		
	}
	
	public void clickOnSubLink(String link) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Create Namespace')]/following::div[contains(@title,'"+link+"')]")));
		oASelFW.effecta("click","//a[contains(@title,'Create Namespace')]/following::div[contains(@title,'"+link+"')]","Clicking on "+ link);
		Thread.sleep(5000);
	}
	
	public void clickOnUploadAssets() throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@title,'Upload Assets')]")));
		oASelFW.effecta("click","//input[contains(@title,'Upload Assets')]","Clicking on upload assets");
		Thread.sleep(5000);
	}
	
	public void fileUpload(String filepath) throws IOException
	{
				
		new ProcessBuilder(oASelFW.sAutomationPath+"\\ZeusLAMP\\auto_it_files\\FileUpload.exe",filepath,"Open").start();
	}
			
	
	public void clickOnUploadButton() throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Upload')]")));
		oASelFW.effecta("click","//button[contains(text(),'Upload')]","Clicking on upload assets");
		Thread.sleep(10000);
	}
	
	public void verifyAsset()
	{
	
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(@data-foundation-content-history-title,'Desert.jpg')]")))
		{
			oASelFW.effecta("sendReport","Verifying whether image is inserted in assest or not","Successfully verifed image is inserted","Pass") ;
		}
		else
		{
			oASelFW.effecta("sendReport","Verifying whether image is inserted in assest or not","verifed image is not inserted","Fail") ;
		}
	}
	
	
	
	
	
	
	
	
	
}
