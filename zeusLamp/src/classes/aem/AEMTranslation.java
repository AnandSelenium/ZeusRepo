package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMTranslation {
	ArsinSeleniumAPI oASelFW;

	public AEMTranslation(){

	}
	public AEMTranslation(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}

	public String page_Creation()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		String constName="QAAuto";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Name')]/following-sibling::input",name,"Name");
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input",name,"Title");
		//DESCRIPTION
		oASelFW.effecta("type","//label[contains(text(),'Page Title')]/following-sibling::input",name,"Page Title");
		//ANALYTICS METADATA
		oASelFW.effecta("select","//label[contains(text(),'Page Content Type')]/following-sibling::span/descendant::select","Home","Page Content Type");
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		System.out.println("The name of the page is "+name);
		return name;
	}
	
	public String page_Creation_vmworld()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		String constName="TranslationPage";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Name')]/following-sibling::input",name,"Name");
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input",name,"Title");
		//DESCRIPTION
		oASelFW.effecta("type","//label[contains(text(),'Page Title')]/following-sibling::input",name,"Page Title");
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		System.out.println("The name of the page is "+name);
		return name;
	}

	public void verifyPageCreated(String pageCreatedMessage)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'"+pageCreatedMessage+"')]")));
		oASelFW.effecta("verifyElementPresent","//button[text()='Open page']","Open page");
	}

	
	
	
	public void verifyRolloutPagedata(String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//div/a[contains(text(),'"+text+"')]",text);
		//oASelFW.driver.switchTo().defaultContent();
	}
	
	
	public void ClickOpenPage(String fieldname) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+fieldname+"']")));
		oASelFW.effecta("click","//button[text()='"+fieldname+"']",fieldname);
		Thread.sleep(5000);
	}


	public void fillFieldsInBreifTextCard(String urlOpenType) throws InterruptedException
	{
		String title="QATest";
		int random=(int) (Math.random()*10000);
		title=title+random;
		int ran=20;
		String expected="";
		for(int i=0;i<ran;i++)
		{
			expected=expected+title;
		}
		String Description=expected.substring(0, ran);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Brief Text Card']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input","Fusion_Pro","Title");
		Thread.sleep(3000);
		WebElement element=oASelFW.driver.findElement(By.xpath("//div[contains(@class,'coral-RichText-editable')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].innerHTML = '<p>" + Description + "</p>';", element);
		
		oASelFW.effecta("type","//label[contains(text(),'Link Name')]/following-sibling::input","Read_Delta's_Story","Link Name");	
		oASelFW.effecta("clickAndWait","//label[text()='Link Path']/following-sibling::span//span[@class='coral-InputGroup-button']","Link Path Image");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='VMware']","Vmware");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='Language Master Sites']","Language Master Sites");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='English']","English");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='My VMware']","My VMware");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='onlyAutoQA']","onlyAutoQA");
		Thread.sleep(5000);
		oASelFW.effecta("click","//h2[text()='Select path']/following::button[1]","Path Selected");
		//oASelFW.effecta("clickAndWait","//h2[text()='Select path']/following-sibling::button[contains(@class,'pathbrowser')]","Selected Path");		
		Thread.sleep(5000);		
		oASelFW.effecta("select","//label[text()='Select URL Open type']/following-sibling::span//select",urlOpenType,"Select URL Open type");	
		Thread.sleep(5000);
		oASelFW.effecta("clickAndWait","//button[@title='Done']","Done");	
		Thread.sleep(3000);
		System.out.println("Brief Text Card Method Completed");
	}
	
	public String returnString(String info,String val){
		int ran=Integer.parseInt(val);
		String expected="";
		for(int i=0;i<ran;i++)
		{
			expected=expected+info;
		}
		System.out.println(expected);
		oASelFW.effecta("sendReport","Retrieving Description Field From Database","Successfully retrieved the value of length : "+val,"Pass");
		return expected.substring(0, ran);
	}
	public String cloud_config()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create']")));
		String constName="CloudTranslation";
		int random=(int) (Math.random()*100000);
		String name=constName+random;
		//TITLE
		oASelFW.effecta("type","//label[contains(text(),'Name')]/following-sibling::input",name,"Name");
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input",name,"Title");
		//DESCRIPTION
		oASelFW.effecta("type","//label[contains(text(),'Page Title')]/following-sibling::input",name,"Page Title");
		//ANALYTICS METADATA
		oASelFW.effecta("select","//label[contains(text(),'Page Content Type')]/following-sibling::span/descendant::select","Home","Page Content Type");
		//CLICK BUTTON
		oASelFW.effecta("clickAndWait","//button[text()='Create']","CREATE");
		System.out.println("The name of the page is "+name);
		return name;
	}
	
	public void clickReferences() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='References']")));
		oASelFW.effecta("clickAndWait","//button[@title='References']","References");
		Thread.sleep(2000);
	}
	
	
	public void clickDeselect() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Deselect']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[@title='Deselect']")))
		{
			oASelFW.effecta("click","//button[@title='Deselect']","Deselect");
		}
		else
		{
			System.out.println("Page is already deselected");
		}
		
		Thread.sleep(2000);
	}
	
	public void clickSelect() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Select']")));
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[@title='Select']")))
		{
			oASelFW.effecta("click","//button[@title='Select']","Select");
		}
		else
		{
			System.out.println("Page is already Selected");
		}
		
		Thread.sleep(2000);
	}
	
	
	
	public void fillFieldsInBreifTextCard_UAT(String urlOpenType) throws InterruptedException
	{
		String title="QATest";
		int random=(int) (Math.random()*10000);
		title=title+random;
		int ran=20;
		String expected="";
		for(int i=0;i<ran;i++)
		{
			expected=expected+title;
		}
		String Description=expected.substring(0, ran);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Brief Text Card']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input","Fusion_Pro","Title");
		Thread.sleep(3000);
		WebElement element=oASelFW.driver.findElement(By.xpath("//div[contains(@class,'coral-RichText-editable')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].innerHTML = '<p>" + Description + "</p>';", element);
		oASelFW.effecta("select","//label[contains(text(),'Select Icon')]/following-sibling::span/select","Bar Chart","Select Icon");
		oASelFW.effecta("type","//label[contains(text(),'Link Name')]/following-sibling::input","Read_Delta's_Story","Link Name");	
		oASelFW.effecta("clickAndWait","//label[text()='Link Path']/following-sibling::span//span[@class='coral-InputGroup-button']","Link Path Image");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='VMware']","Vmware");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='Language Master Sites']","Language Master Sites");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='English']","English");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='training']","training");
		Thread.sleep(5000);
		/*oASelFW.effecta("click","//div[text()='UAT_QA']","UAT_QA");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='onlyAutoQA']","onlyAutoQA");
		Thread.sleep(5000);*/
		oASelFW.effecta("click","//h2[text()='Select path']/following::button[1]","Path Selected");
		
		Thread.sleep(5000);		
		oASelFW.effecta("select","//label[text()='Select URL Open type']/following-sibling::span//select",urlOpenType,"Select URL Open type");	
		Thread.sleep(5000);
		oASelFW.effecta("clickAndWait","//button[@title='Done']","Done");	
		Thread.sleep(3000);
		System.out.println("Brief Text Card Method Completed");
	}
	
	
	public void selectPage(String pageName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='"+pageName.trim()+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='"+pageName.trim()+"']")));
		oASelFW.effecta("clickAndWait","//h4[text()='"+pageName.trim()+"']","Page:"+pageName);
		Thread.sleep(2000);
	}
	
	public void clickLanguageCopy() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@data-type='languageCopy']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@data-type='languageCopy']")));
		oASelFW.effecta("clickAndWait","//section[@data-type='languageCopy']","languageCopy");
		Thread.sleep(2000);
	}
	
	public void assetLanguageCopy() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Language Copies')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Language Copies')]")));
		oASelFW.effecta("clickAndWait","//a[contains(text(),'Language Copies')]","languageCopy");
		Thread.sleep(2000);
	}
	
	
	
	public void clickLiveCopy() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[contains(text(),'Live Copies')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[contains(text(),'Live Copies')]")));
		oASelFW.effecta("click","//div/a[contains(text(),'Live Copies')]","Live Copies");
		Thread.sleep(2000);
	}
	
	
	
	
	
	public void clickLiveCopyShortPath(String locator) throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//Span[contains(@title,'"+locator+"')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//Span[contains(@title,'"+locator+"')]")));
		oASelFW.effecta("click","//Span[contains(@title,'"+locator+"')]","Page Path");
		Thread.sleep(2000);
	}
	
	
	
	public void clickLiveCopySynchronize() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'block')]/button[contains(text(),'Synchronize')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@style,'block')]/button[contains(text(),'Synchronize')]")));
		oASelFW.effecta("click","//div[contains(@style,'block')]/button[contains(text(),'Synchronize')]","Synchronize");
		Thread.sleep(2000);
	}
	
	public void clickLiveCopyRollout() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Rollout')]")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Rollout')]")));
		
		oASelFW.effecta("click","//span[contains(text(),'Rollout page and all subpages')]/../input[@type='radio']","Rollout page and all subpages");
		Thread.sleep(8000);
		
		
		oASelFW.effecta("click","//label/span[contains(text(),'Background rollout')]/preceding-sibling::input[@type='checkbox']","Background rollout checkbox");
		Thread.sleep(8000);
		
		
		oASelFW.effecta("click","//button[contains(text(),'Rollout')]","Rollout");
		Thread.sleep(5000);
		
		
		
		
	}
	
	public void clickLiveCopyRollout_Page() throws Exception
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Rollout')]")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Rollout')]")));
		
		oASelFW.effecta("click","//span[text()='Rollout page']/../input[@type='radio']","Rollout page");
		Thread.sleep(8000);
		
		
		oASelFW.effecta("click","//label/span[contains(text(),'Background rollout')]/preceding-sibling::input[@type='checkbox']","Background rollout checkbox");
		Thread.sleep(8000);
		
		
		oASelFW.effecta("click","//button[contains(text(),'Rollout')]","Rollout");
		Thread.sleep(5000);
		
		
		
		
	}
	
	
	
	
	
	
	public void clickCreateAndTranslate() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Create & Translate']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create & Translate']")));
		oASelFW.effecta("clickAndWait","//span[text()='Create & Translate']","Create & Translate");
		Thread.sleep(2000);
	}
	
	public void clickCreate_Translate() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(@class,'coral-Collapsible-header')]/descendant::span[contains(text(),'Create')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(@class,'coral-Collapsible-header')]/descendant::span[contains(text(),'Create')]")));
		oASelFW.effecta("clickAndWait","//h3[contains(@class,'coral-Collapsible-header')]/descendant::span[contains(text(),'Create')]","Create");
		Thread.sleep(5000);
	}
	
	
	
	public void SelectLanguages(String language) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Languages']/following::select[@name='languages']")));
	
		oASelFW.effecta("select","//label[text()='Languages']/following::select[@name='languages']",language,"Languages");
		
	}
	
	public void ClickSelectLanguages_Checkbox() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Select all sub-pages')]/preceding-sibling::input[@type='checkbox']")));
	
		oASelFW.effecta("click","//span[contains(text(),'Select all sub-pages')]/preceding-sibling::input[@type='checkbox']","Select Languages Checkbox");
		
	}
	
	public void verifyCheckBox()
	{
		WebElement element=oASelFW.driver.findElement(By.xpath("//span[contains(text(),'Select all sub-pages')]/preceding-sibling::input[contains(@type,'checkbox')][1]"));
		String value=element.getAttribute("value");
		
		System.out.println("getAttribute value:"+value);
		
		if(element.isSelected())
		{
			System.out.println("Fail");
			
			oASelFW.effecta("sendReport","Validating whether 'Select all sub-pages' checkbox is by default unchecked","'Select all sub-pages' checkbox is checked","Done");
		}
		else
		{
			System.out.println("Pass");
			oASelFW.effecta("sendReport","Validating whether 'Select all sub-pages' checkbox is by default unchecked","'Select all sub-pages' checkbox is by default unchecked","Pass");
		}
	}
	
	
	public String fillFieldsInCreateAndTranslate(String languageName,String project) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Create & Translate']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create & Translate']")));
		oASelFW.effecta("select","//label[text()='Languages']/../span//select",languageName,"Language");
		oASelFW.effecta("select","//label[text()='Project']/../span//select",project,"Project");
		String title=languageName+(int)(Math.random()*100000);
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::input",title,"Title");
		Thread.sleep(3000);
		oASelFW.effecta("clickAndWait","//button[@data-oppositetext='Add']","Create");
		return title;
	}
	
	public void translationdetails_Dropdown(String button, String option) throws Exception
	{
		Actions translation = new Actions(oASelFW.driver);
		translation.moveToElement(oASelFW.driver.findElement(By.xpath("//label[text()='"+button+"']/../span/button/span")),5,5).build().perform();
		translation.click().perform();
		Thread.sleep(10000);
		translation.moveToElement(oASelFW.driver.findElement(By.xpath("//li[text()='"+option+"']"))).build().perform();
		translation.click().perform();
		Thread.sleep(5000);
	}
	
	
	public void selectValue(String button, String option) throws Exception
	{
		Actions translation = new Actions(oASelFW.driver);
		translation.moveToElement(oASelFW.driver.findElement(By.xpath("//label[text()='"+button+"']/../span/button/span")),5,5).build().perform();
		translation.click().perform();
		Thread.sleep(30000);
		Select select = new Select(oASelFW.driver.findElement(By.xpath("//label[text()='"+button+"']/../span/button/span/following::select[1]")));
		select.selectByValue(option);
	}
	
	
	public void selectsourceLanguage(String option) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select[@name='languageCopies'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='languageCopies'])[1]")));
		oASelFW.effecta("select","(//select[@name='languageCopies'])[1]",option,"Source Language");
		
	}
	
	public String translationdetails_text(String button) throws Exception
	{
		String title="Project_translation"+(int)(Math.random()*100000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+button+"']")));
		oASelFW.effecta("type","//label[text()='"+button+"']/following-sibling::input",title,"Text in"+button);
		return title;
	}
	
	public void translation_Workflow(String button,String title) throws Exception
	{
		//String title="Workflow_translation"+(int)(Math.random()*100000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='"+button+"']")));
		oASelFW.effecta("type","xpath=(//input[@name='workflowTitle'])[2]",title,"Workflow");
	}
	
	public void translation_button() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Start'])[2]")));
		oASelFW.effecta("click","xpath=(//button[text()='Start'])[2]","Click Start");
	}
	
	public void clickAdd_TranslationJob() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add']")));
		oASelFW.effecta("click","//span[text()='Add']","ADD");
		Thread.sleep(2000);
	}
	
	public void click_SelectPath(String path) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Select path']")));
		
		oASelFW.effecta("click","//div[text()='"+path+"']",path);
		Thread.sleep(5000);
	}
	public void click_SelectPath_PopUP(String path) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Select path']")));
		oASelFW.effecta("click","//a[text()='Content']/ancestor::div[3]/div[2]/div[2]/div/nav[1]/div/a/div[2][text()='"+path+"']",path);
		Thread.sleep(2000);
	}
	
	public void click_confirm()
	{
		oASelFW.effecta("click","//button[@title='Confirm']","Confirm");
	}
	
	public void selectAssets( String asset) throws Exception
	{
		oASelFW.effecta("click","//h4[contains(text(),'"+asset+"')]/../preceding-sibling::i","Confirm");
		Thread.sleep(2000);
	}
	
	public void click_delete()
	{
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		oASelFW.effecta("click","//button[text()='Delete']","Delete Confirm");
	}
	
	public void verify_PathDeleted()
	{
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[contains(text(),'VMware-IT-Business-Management-Suite-Datasheet.pdf')]/../preceding-sibling::i")))
		{
			oASelFW.effecta("sendReport","validating whether Asset is avavilable in AEM or not","Unable to verify Asset","Fail");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether Asset is avavilable in AEM or not","Successfully verified Asset is Deleted","Pass");
		}	
	}
	
	
	public void clickPageOpen() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Open']/span[text()='Open']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Open']/span[text()='Open']")));
		oASelFW.effecta("clickAndWait","//button[@title='Open']/span[text()='Open']","Page Open");
		Thread.sleep(2000);
	}
	
	
	public void clickPageViewProperties() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@title='View Properties'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='View Properties'])[1]")));
		oASelFW.effecta("click","xpath=(//button[@title='View Properties'])[1]","Page View Properties");
		Thread.sleep(2000);
	}
	
	
	public void publishPage_NEW() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Page Information']")));
		oASelFW.effecta("click","//button[text()='Publish Page']","Publish Page Button Clicked");
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[text()='Publish']")))
		{
			oASelFW.effecta("click","//button[text()='Publish']","Publish Button Clicked");
			Thread.sleep(5000);	
		}
	
		
	}
	
	public void rollOutPage() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Page Information']")));
		oASelFW.effecta("click","//button[text()='Rollout Page']","Publish Page Button Clicked");
		Thread.sleep(5000);
		
	}
	
	public void ClickBack() throws Exception
	{
	WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'coral-Icon coral-Icon--chevronLeft')]")));
	oASelFW.effecta("click","//i[contains(@class,'coral-Icon coral-Icon--chevronLeft')]","clicking on icon");
	Thread.sleep(5000);
	}
	
	
	public void completeTask(String task) throws Exception
	{
		WebDriverWait wait =new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+task+"')]/../input")));
		oASelFW.effecta("click","//label[contains(text(),'"+task+"')]/../input","Task"+task);
		Thread.sleep(3000);
		oASelFW.effecta("click","//input[@name='ok']","ok Clicked");
		Thread.sleep(60000);
	}
	
	
	public void completeTaskButton() throws Exception
	{
		WebDriverWait wait =new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='ok']")));
		oASelFW.effecta("click","//input[@name='ok']","ok Clicked");
		Thread.sleep(60000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

