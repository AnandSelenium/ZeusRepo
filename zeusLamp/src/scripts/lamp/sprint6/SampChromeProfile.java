package scripts.lamp.sprint6;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SampChromeProfile {
	public static void main(String ar[]){

		// specify the path of the chromdriver binary that you have downloaded (see point 2)
		System.setProperty("webdriver.chrome.driver", "W:\\Resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// if you like to specify another profile
		//options.addArguments("user-data-dir=/root/Downloads/aaa"); 
		options.addArguments("start-maximized");
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://aem-test-auth-1.vmware.com:8080/content/vmware/language-master-sites/en/QATestAutomation/utagVerification.html");
		WebDriverWait wait=new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='coral-Heading coral-Heading--1']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit-button']")));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vmachavarapu");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Orion1234%");
		driver.findElement(By.xpath("//button[@id='submit-button']")).click();
		
		//driver.get("http://aem-test-auth-1.vmware.com:8080/editor.html/content/vmware/language-master-sites/en/QATestAutomation/utagVerification.html");
		
		
		//String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		Object netData = ((JavascriptExecutor)driver).executeScript("return window.performance.getEntries();");
		
		System.out.println(netData);
		String value=netData.toString();
		if(value.contains("elqCfg.min.js")&&value.contains("svrGP?pps=3&siteid=279193683&ref2=http://aem-test-auth-1.vmware.com:8080/content/vmware/language-master-sites/en/QATestAutomation/utagVerification.html&tzo=-330&ms=69&optin=disabled")){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		driver.quit();
	}
}
