package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMAssetsPage {
	ArsinSeleniumAPI oASelFW;

	public AEMAssetsPage(){

	}
	public AEMAssetsPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}

	public void verifyAssetsPage(String pageName){
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='endor-BlackBar-title']")));

		oASelFW.effecta("verifyElementPresent","//div[@class='endor-BlackBar-title']",pageName);
	}
	
	
	public void searchAssetwithFileName(String filename) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Search'])[1]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//span[text()='File Name'])[1]","File Name Option in Assets Page");
		oASelFW.effecta("clickAndWait","xpath=(//span[text()='File Name'])[1]","File Name Option in Assets Page");
		oASelFW.effecta("verifyElementPresent","//input[@data-id='searchByName']","File Name Check Box in Assets Page");
		oASelFW.effecta("clickAndWait","//input[@data-id='searchByName']","File Name Check Box in Assets Page");
		Thread.sleep(10000);
		oASelFW.effecta("type","//input[@placeholder='Enter Keyword(s)']",filename,"file name entered");
		Actions action = new Actions(oASelFW.driver);
		WebElement we=oASelFW.driver.findElement(By.xpath("//input[@placeholder='Enter Keyword(s)']"));
		Thread.sleep(2000);
		we.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='info.png']")));
		oASelFW.effecta("verifyElementPresent","//h4[text()='info.png']","Element Found After Search");
		
		
	}

	public void clickUploadAssets(String file) throws Exception
	{
		Thread.sleep(10000);
		System.out.println("After Wait");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']/../following-sibling::span[contains(@class,'FileUpload')]//i[@class='coral-Icon coral-Icon--upload']")));
		Thread.sleep(2000);
		System.out.println("Before Upload popup");
		Thread.sleep(10000);
		WebElement we=oASelFW.driver.findElement(By.xpath("//span[text()='Select']/../following-sibling::span[contains(@class,'FileUpload')]//i[@class='coral-Icon coral-Icon--upload']"));
		Actions act=new Actions(oASelFW.driver);
		JavascriptExecutor executor1 =(JavascriptExecutor)oASelFW.driver;
		executor1.executeScript("arguments[0].click();", we);
		act.moveToElement(we).click().build().perform();
		Thread.sleep(5000);
		oASelFW.effecta("sendReport","Clicking button/link/image: Upload Assets","Successfully clicked button/link/image:  Upload Assets","Pass");
		uploadAssets_AutoIT(file);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Upload']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[text()='Upload']")))
		{
			System.out.println("Upload successfull");
			oASelFW.effecta("clickAndWait","//button[text()='Upload']","Upload");
			Thread.sleep(5000);
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Name Conflict']")))
			{
				oASelFW.effecta("click","//button[text()='Replace']","Replace"); 
				Thread.sleep(5000);
			}else
			{
				System.out.println("Only Single file is available with same name");
			}
		}
	}

	public void uploadAssets_AutoIT(String file)
	{
		try
		{
			String filename=oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\"+file;
			Thread.sleep(5000);
			if(oASelFW.sBrowser.contains("FireFox"))
			{
				Process p=new ProcessBuilder(oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\UploadFile_FireFox.exe",filename,"Open").start();
				System.out.println("Process"+p);
				Thread.sleep(25000);
			}else
			{
				Process p=new ProcessBuilder(oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\NewUploadChrome.exe",filename,"Open").start();
				System.out.println("Process"+p);
				Thread.sleep(25000);
			}
		}catch(Exception e)
		{

		}
	}

	public void clickCreateFolder() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Create Folder']")));
		oASelFW.effecta("click","//span[text()='Create Folder']","Create Folder");
		Thread.sleep(3000);
	}

	public String fillRequiredFields()
	{
		String title="QAAutoTest";
		int random=(int) (Math.random()*10000);
		title=title+random;	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Add Folder']")));
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input",title,"Title");
		oASelFW.effecta("click","//span[text()='Create']","Create Folder");
		return title; 
	}

	public void verifyFolderCreatedMsg(String folderName) throws Exception
	{
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@class='coral-Alert-message']")))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='coral-Alert-message']")));
			String msg=oASelFW.effecta("getText","//div[@class='coral-Alert-message']","Folder Created Message:");
			if(msg.trim().contains(folderName))
			{
				oASelFW.effecta("sendReport","Validating Whether Folder created or not","Folder created Successfully as:"+folderName,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Validating Whether Folder created or not","Folder is not created","Fail");	
			}
		}
	}

	public String renameFolder(String folderName) throws Exception
	{
		oASelFW.effecta("waitForPageToLoad");
		int random=(int) (Math.random()*100);
		String updatedFloderName=folderName+random;
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		JavascriptExecutor jse = (JavascriptExecutor)oASelFW.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		oASelFW.effecta("click","//h4[text()='"+folderName+"']","Folder:"+folderName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));		
		JavascriptExecutor js = (JavascriptExecutor) oASelFW.driver;
		WebElement element = oASelFW.driver.findElement(By.xpath("//span[text()='Folder Settings']/parent::button"));
		js.executeScript("arguments[0].setAttribute('class', 'endor-ActionBar-item coral-Button coral-Button--quiet coral-Button--graniteActionBar cq-damadmin-admin-actions-foldershare foundation-collection-action dam-collection-share-action')",element);
		wait.until(ExpectedConditions.visibilityOf(element));
		oASelFW.effecta("clickAndWait","//span[text()='Folder Settings']","Folder Settings");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Folder Settings']")));
		oASelFW.effecta("type","//label[text()='Folder Title']/following-sibling::input",updatedFloderName,"Folder Title");
		oASelFW.effecta("clickAndWait","//button[text()='Save']","Save");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='foldersharesettings-success']//div//h2")));
		oASelFW.effecta("verifyElementPresent","//div[@id='foldersharesettings-success']//div//h2","Success");
		oASelFW.effecta("getText","//div[@id='foldersharesettings-success']//div[contains(@id,'modal')]","Folder Settings success Message:");
		oASelFW.effecta("clickAndWait","//button[text()='OK']","OK");
		Thread.sleep(5000);
		return updatedFloderName;
	}

	public void deleteFolder(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[text()='Deselect']")))
		{
			oASelFW.effecta("click","//span[text()='Deselect']","DeSelect");
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[text()='"+folderName+"']","Folder:"+folderName);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='deleteasset']//div//h2")));
		oASelFW.effecta("verifyElementPresent","//div[@id='deleteasset']//div//h2","Delete Asset");
		oASelFW.effecta("getText","//div[@id='deleteasset']//div[2]","Folder delete Message:");
		oASelFW.effecta("clickAndWait","//div[@id='deleteasset']/div[3]/button[text()='Delete']&&//button[text()='Delete']","Delete");
	}

	public void SelectAndDeleteFolder_01(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[contains(text(),'"+folderName+"')]","Folder:"+folderName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Delete')]")));
		oASelFW.effecta("verifyElementPresent","//p[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete button");
		oASelFW.effecta("clickAndWait","//p[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete");
	}
	
	public void SelectAndDeleteFolder(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//span[text()='Select']","Select");
		oASelFW.effecta("click","//h4[contains(text(),'"+folderName+"')]","Folder:"+folderName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Delete')]")));
		oASelFW.effecta("verifyElementPresent","//p/b[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete button");
		oASelFW.effecta("clickAndWait","//p/b[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete");
	}
	
	public void SelectFolder(String pagename) throws Exception
	{
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
	Thread.sleep(5000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select']")));
	oASelFW.effecta("click","//span[text()='Select']","Select");
	oASelFW.effecta("click","//h4[contains(text(),'"+pagename+"')]","Folder:"+pagename);
	Thread.sleep(5000);
	}
	
	
	public void clickFolder(String pagename) throws Exception
	{
	WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+pagename+"')]")));
	
	oASelFW.effecta("click","//h4[contains(text(),'"+pagename+"')]","Folder:"+pagename);
	Thread.sleep(5000);
	}
	
	public void DeleteFolder(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//h4[contains(text(),'"+folderName+"')]","Folder:"+folderName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Delete')]")));
		oASelFW.effecta("verifyElementPresent","//p/b[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete button");
		oASelFW.effecta("clickAndWait","//p/b[contains(text(),'"+folderName+"')]/following::button[contains(text(),'Delete')]","Delete");
	}
	
	public void selectPage_ViewProperties(String folderName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select']")));
		oASelFW.effecta("click","//h4[contains(text(),'"+folderName+"')]","Folder:"+folderName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='More']")));
		oASelFW.effecta("click","//span[text()='More']","More");
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='View Properties']","View Properties");
		Thread.sleep(3000);
		}
	
	public void clickViewProperties_Edit() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Edit']")));
		oASelFW.effecta("click","//span[text()='Edit']","Edit");
		
	}
	
	
	public void clickViewProperties_Done() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Done']")));
		oASelFW.effecta("click","//span[text()='Done']","Done");
		
	}
	
	
	public void clickViewProperties_ReleaseTags_Browse() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[contains(text(),'Release Tags')]/following::button[@title='Browse'])[1]")));
		oASelFW.effecta("click","xpath=(//label[contains(text(),'Release Tags')]/following::button[@title='Browse'])[1]","Release Tags");

	}
	
	public void clickViewPropertiesReleaseTags(String value) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+value+"')]")));
		oASelFW.effecta("click","//div[contains(text(),'"+value+"')]",value);
		Thread.sleep(5000);
	}
	
	
	public void clickReleaseTags_SaveIcon() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h2[contains(text(),'Select Tags')]/following::button)[1]")));
		oASelFW.effecta("click","xpath=(//h2[contains(text(),'Select Tags')]/following::button)[1]","Save");
		Thread.sleep(5000);
	}
			
	
		
}
