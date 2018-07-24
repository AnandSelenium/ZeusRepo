package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;



public class AEMCreateCustomerPage {
	ArsinSeleniumAPI oASelFW;

	public AEMCreateCustomerPage(){

	}
	public AEMCreateCustomerPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;

	}

	public void verifyCustomerCreatePage()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Create Customer']")));
		oASelFW.effecta("verifyElementPresent","//h1[text()='Create Customer']","Create Customer");
		oASelFW.driver.switchTo().defaultContent();

	}
	
	
	public void verifyPage(String pageName)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='"+pageName+"']")));
		oASelFW.effecta("verifyElementPresent","//h1[text()='"+pageName+"']",pageName);
		oASelFW.driver.switchTo().defaultContent();

	}
	

	public String createCustomer() throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cq-gen167']")));
		String expandByttonText=oASelFW.driver.findElement(By.xpath("//div[@id='cq-sk']")).getAttribute("class");
		if(expandByttonText.trim().contains("pinned"))
		{
			System.out.println("Toggle button is Expanded");
			oASelFW.effecta("click","//div[@id='cq-gen167']","Toggle Button Collapsed");
		}else
		{
			System.out.println("Toggle button is Collapsed");
		}

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Customer Name']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));

		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		//TITLE
		oASelFW.effecta("type","//label[text()='Customer Name']/../div/input",name,"Customer Name");

		Thread.sleep(10000);
		System.out.println("After wait");

		/**********************Logo Path*************************/
		//oASelFW.driver.findElement(By.xpath("//label[text()='Logo Path']/following-sibling::div[1]//img")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Logo Path']/following::img[1]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[text()='Logo Path']/following::img[1]"));
		JavascriptExecutor executor =(JavascriptExecutor)oASelFW.driver;
		executor.executeScript("arguments[0].click();", element);

		oASelFW.effecta("sendReport","verify click on Log Path Search","Successfully click on logpath Search","Pass");

		//oASelFW.driver.findElement(By.xpath("//label[text()='Logo Path']/following::img[1]")).click();
		//oASelFW.effecta("click","//label[text()='Logo Path']/following::img[1]","LogoPath Search");
		System.out.println("clicked search ************");

		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select Path']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@class,'x-tree-node-el')]//a/../following-sibling::ul"))){
			//oASelFW.effecta("click","//div[contains(@class,'x-tree-node-el')]//a/../following-sibling::ul[1]/li","Selecting Logo Path");

			WebElement element1 = oASelFW.driver.findElement(By.xpath("//div[@id='cq-gen113']//ul/li[@class='x-tree-node']//ul/li"));
			JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
			executor1.executeScript("arguments[0].click();", element1);

		}else{
			WebElement element1 = oASelFW.driver.findElement(By.xpath("//ul[@id='cq-gen103']//div/a/span"));
			JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
			executor1.executeScript("arguments[0].click();", element1);
			//oASelFW.effecta("click","//div[contains(@class,'x-tree-node-el')]//a","Selecting Logo Path");
		}
		oASelFW.effecta("click","//button[text()='OK']","OK for Logo Path");


		/***********************LINK URL************************/
		oASelFW.effecta("click","//label[text()='Link URL']/../div//img","LinkURL Search");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='cq-gen154']")));
		//if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@id='cq-gen185']//div[contains(@class,'x-tree-node-el')]//a/../following-sibling::ul"))){
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//ul[@id='cq-gen162']//li//ul/li//a"))){
			oASelFW.effecta("click","//ul[@id='cq-gen162']//li//ul/li//a","Selecting Link URL");
		}else{
			oASelFW.effecta("click","//ul[@id='cq-gen162']/li/div/a/span&&//div[@id='cq-gen185']//div[contains(@class,'x-tree-node-el')]//a","Selecting Link URL");
		}
		oASelFW.effecta("click","//button[@id='cq-gen197']&&//button[text()='OK']","OK for Link URL");

		/***************************Size***************************/
		oASelFW.effecta("click","//label[text()='Size']/../div//img[@id='cq-gen53']","Size DropDown");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Customerstories Size']")));
		oASelFW.effecta("click","//div[@id='cq-gen249']/ul//a","Size");
		Thread.sleep(3000);

		WebElement we=oASelFW.driver.findElement(By.xpath("//div[@id='cq-gen249']/ul//a"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");


		/***************************Industry***************************/
		oASelFW.effecta("click","//label[text()='Industry']/../div//img[@id='cq-gen63']","Industry DropDown");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Customerstories Industry']")));
		oASelFW.effecta("click","//div[@id='cq-gen291']/ul//a","Industry");
		Thread.sleep(3000);

		WebElement we1=oASelFW.driver.findElement(By.xpath("//div[@id='cq-gen291']/ul//a"));
		Thread.sleep(2000);
		we1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");

		/***********************STATUS**************************/
		oASelFW.effecta("click","//label[text()='Active']/..//input","Status");

		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");

		oASelFW.driver.switchTo().defaultContent();

		return name;
	}

	public String createCustomer_Updated() throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cq-gen167']")));
		String expandByttonText=oASelFW.driver.findElement(By.xpath("//div[@id='cq-sk']")).getAttribute("class");
		if(expandByttonText.trim().contains("pinned"))
		{
			System.out.println("Toggle button is Expanded");
			oASelFW.effecta("click","//div[@id='cq-gen167']","Toggle Button Collapsed");
		}else
		{
			System.out.println("Toggle button is Collapsed");
		}

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Customer Name']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));

		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		//TITLE
		oASelFW.effecta("type","//label[text()='Customer Name']/../div/input",name,"Customer Name");

		Thread.sleep(10000);
		System.out.println("After wait");

		/**********************Logo Path*************************/
		//oASelFW.driver.findElement(By.xpath("//label[text()='Logo Path']/following-sibling::div[1]//img")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Logo Path']/following::img[1]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//label[text()='Logo Path']/following::img[1]"));
		JavascriptExecutor executor =(JavascriptExecutor)oASelFW.driver;
		executor.executeScript("arguments[0].click();", element);

		oASelFW.effecta("sendReport","verify click on Log Path Search","Successfully click on logpath Search","Pass");

		//oASelFW.driver.findElement(By.xpath("//label[text()='Logo Path']/following::img[1]")).click();
		//oASelFW.effecta("click","//label[text()='Logo Path']/following::img[1]","LogoPath Search");
		System.out.println("clicked search ************");

		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select Path']")));
		/*if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@class,'x-tree-node-el')]//a/../following-sibling::ul"))){
			//oASelFW.effecta("click","//div[contains(@class,'x-tree-node-el')]//a/../following-sibling::ul[1]/li","Selecting Logo Path");

			WebElement element1 = oASelFW.driver.findElement(By.xpath("//div[@id='cq-gen113']//ul/li[@class='x-tree-node']//ul/li"));
			JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
			executor1.executeScript("arguments[0].click();", element1);

		}else{
			WebElement element1 = oASelFW.driver.findElement(By.xpath("//ul[@id='cq-gen103']//div/a/span"));
			JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
			executor1.executeScript("arguments[0].click();", element1);
			//oASelFW.effecta("click","//div[contains(@class,'x-tree-node-el')]//a","Selecting Logo Path");
		}*/
		
		WebElement element1 = oASelFW.driver.findElement(By.xpath("//span[contains(text(),'/content/dam')]"));
		Actions act=new Actions(oASelFW.driver);
		//act.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@class='x-window-body']//ul//li//a//span[text()='/content/dam']"))).click().build().perform();
		act.moveToElement(element1).click().build().perform();
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		//oASelFW.effecta("click","//span[contains(text(),'/content/dam')]","Logo Path");
		Thread.sleep(3000);
		oASelFW.effecta("click","//button[text()='OK']","OK for Logo Path");


		/***********************LINK URL************************/
		oASelFW.effecta("click","//label[contains(text(),'Link URL')]/following-sibling::div//img","LinkURL Search");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='cq-gen154']")));
		//if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@id='cq-gen185']//div[contains(@class,'x-tree-node-el')]//a/../following-sibling::ul"))){
		/*if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//ul[@id='cq-gen162']//li//ul/li//a"))){
			oASelFW.effecta("click","//ul[@id='cq-gen162']//li//ul/li//a","Selecting Link URL");
		}else{
			oASelFW.effecta("click","//ul[@id='cq-gen162']/li/div/a/span&&//div[@id='cq-gen185']//div[contains(@class,'x-tree-node-el')]//a","Selecting Link URL");
		}*/
		oASelFW.effecta("click","//span[text()='/content']","Logo Path");
		Thread.sleep(3000);
		
		oASelFW.effecta("click","//button[@id='cq-gen197']&&//button[text()='OK']","OK for Link URL");

		/***************************Size***************************/
		oASelFW.effecta("click","//label[contains(text(),'Size')]/following-sibling::div//img[@class='arrow-trigger']","Size DropDown");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Customerstories Size']")));
		oASelFW.effecta("click","//div[@id='cq-gen249']/ul//a","Size");
		Thread.sleep(3000);

		WebElement we=oASelFW.driver.findElement(By.xpath("//div[@id='cq-gen249']/ul//a"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");


		/***************************Industry***************************/
		oASelFW.effecta("click","//label[contains(text(),'Industry')]/following-sibling::div//img[@class='arrow-trigger']","Industry DropDown");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Customerstories Industry']")));
		oASelFW.effecta("click","//div[@id='cq-gen291']/ul//a","Industry");
		Thread.sleep(3000);

		WebElement we1=oASelFW.driver.findElement(By.xpath("//div[@id='cq-gen291']/ul//a"));
		Thread.sleep(2000);
		we1.sendKeys(Keys.ESCAPE);
		System.out.println("Escape clicked");

		/***********************STATUS**************************/
		oASelFW.effecta("click","//label[text()='Active']/..//input","Status");

		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");

		oASelFW.driver.switchTo().defaultContent();

		return name;
	}

	public String createCustomer1() throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		System.out.println("After waitForPageToLoad");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Customer Name']/../div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		String constName="QAAutoTest";
		int random=(int) (Math.random()*100000);
		String name=constName+random;

		//TITLE
		oASelFW.effecta("type","//label[text()='Customer Name']/../div/input",name,"Customer Name");

		Thread.sleep(10000);
		System.out.println("After wait");
		/***********************STATUS**************************/

		WebElement element1 = oASelFW.driver.findElement(By.xpath("//label[text()='Active']/..//input"));
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", element1);
		
		
		WebElement element2 = oASelFW.driver.findElement(By.xpath("//input[@value='active']"));
		JavascriptExecutor executor2 =(JavascriptExecutor)oASelFW.driver;
		executor2.executeScript("arguments[0].click();", element2);
		
		
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","Create");
		
		Thread.sleep(5000);
		oASelFW.driver.switchTo().defaultContent();
		return name;
	}

	public void verifyCreatedcustomer(String customerName)
	{
		try{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		Thread.sleep(14000);
		customerName=customerName.toLowerCase();
		System.out.println("verifying Started");
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//a[contains(text(),'"+customerName+"')]")))
		{
			oASelFW.effecta("sendReport","Verifying Whether Customer is created are not","Successfully verified Customer is createrd with Name:"+customerName,"Pass");
		}else
		{
			oASelFW.effecta("sendReportWithOutExit","Verifying Whether Customer is created are not","Unable to verify Customer is not createrd","Fail");
		}
		oASelFW.driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void ReSearch(String customerName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='cq-gen156']")));
		//oASelFW.effecta("clickAndWait","//button[@id='cq-gen34']","Website");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Search')]")));
		oASelFW.effecta("click","//span[contains(text(),'Search')]","Search");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Fulltext']/..//div//input",customerName,"Customer Name:"+customerName);
		WebElement we=oASelFW.driver.findElement(By.xpath("//label[text()='Fulltext']/..//div//input"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ENTER);	
	}

}
