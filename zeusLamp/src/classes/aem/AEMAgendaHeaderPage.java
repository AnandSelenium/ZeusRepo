package classes.aem;

import java.awt.Color;
import java.io.File;
import java.io.FileFilter;
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


public class AEMAgendaHeaderPage {


	ArsinSeleniumAPI oASelFW;


	public AEMAgendaHeaderPage(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;	
		
	}

	public void clickOnRichTextComponent(String title) throws InterruptedException
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(@title,'"+title+"')]",title);
		oASelFW.effecta("click","//div[contains(@title,'"+title+"')]","clicking on" + title);
		Thread.sleep(3000);
	}

	public void clickOnParagraphText(String text) throws InterruptedException
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(@data-path,'"+text+"')]",text);
		oASelFW.effecta("click","//div[contains(@data-path,'"+text+"')]","clicking on" + text);
		Thread.sleep(3000);
	}


	public void ClickRichTextSaveButton()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);

		Actions action = new Actions(oASelFW.driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'control#save')]")));
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'control#save')]"));
		action.moveToElement(button).click().build().perform();
	}


	public void clickOnTab_RichTextComponent(String title) throws InterruptedException
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-path,'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(@data-path,'"+title+"')]",title);
		oASelFW.effecta("click","//div[contains(@data-path,'"+title+"')]","clicking on" + title);
		Thread.sleep(3000);
	}

	public void clickTextComponent(String title) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'"+title+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(@title,'"+title+"')]",title+ " Text Component");
		oASelFW.effecta("click","//div[contains(@title,'"+title+"')]","clicking on" + title);
	}
	
	public void sameComponentTwice(String title) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'"+title+"')][2]")));
		oASelFW.effecta("verifyElementPresent","xpath=(//div[contains(@title,'"+title+"')])[2]",title+ " Text Component");
		oASelFW.effecta("click","//div[contains(@title,'"+title+"')]","clicking on" + title);
	}

	
	public void clickTextComponent_TwoColumnTab(String title,int i) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'"+title+"')]["+i+"]")));
		oASelFW.effecta("verifyElementPresent","//div[contains(@title,'"+title+"')]["+i+"]",title+ " Text Component");
		oASelFW.effecta("click","//div[contains(@title,'"+title+"')]["+i+"]","clicking on" + title);
	}
	
	
	public void clickInsertedComponent(String component) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[@data-type='Editable' and contains(@data-path,'"+component+"')]",component+ " Text Component");
		oASelFW.effecta("click","//div[@data-type='Editable' and contains(@data-path,'"+component+"')]","clicking on" + component);
	}

	public void clickInsertedComponentInLamp(String component) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@title,'"+component+"')]")));
		oASelFW.effecta("verifyElementPresent","//div[@data-type='Editable' and contains(@title,'"+component+"')]",component+ " Text Component");
		oASelFW.effecta("click","//div[@data-type='Editable' and contains(@title,'"+component+"')]","clicking on" + component);
	}
	
	
	public void clickInsertedFormContainerComponentInLamp(String component) throws InterruptedException
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@title,'"+component+"')]")));
		WebElement button = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@title,'"+component+"')]"));
		action.moveToElement(button,5,5).click().build().perform();
		//oASelFW.effecta("verifyElementPresent","//div[@data-type='Editable' and contains(@title,'"+component+"')]",component+ " Text Component");
		//oASelFW.effecta("click","//div[@data-type='Editable' and contains(@title,'"+component+"')]","clicking on" + component);
	}

	public void clickOnEdit(String tool) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='"+tool+"']")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[@title='"+tool+"']"));
		action.moveToElement(button).click().build().perform();
	}

	public void clickOnDeleteButtonOnConfirmationBox(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'You are going to delete the selected component(s).')]/following::div/button[text()='"+text+"']")));
		oASelFW.effecta("click","//div[contains(text(),'You are going to delete the selected component(s).')]/following::div/button[text()='"+text+"']","clicking on" + text);
	}

	public void clickOnComponentButton(String button)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'"+button+"')]")));
		oASelFW.effecta("verifyElementPresent","//button[contains(@data-action,'"+button+"')]",button+ " Text Component");
		oASelFW.effecta("click","//button[contains(@data-action,'fullscreen#start')]","clicking on" + button);
	}

	public void verifyButtonInComponents()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button")));
		int count=Integer.parseInt(oASelFW.effecta("getXpathCount","//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button"));
		System.out.println("Count: "+ count);
		for(int i=1;i<=count;i++)
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button["+i+"]")));
			oASelFW.effecta("verifyElementPresent","//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button["+i+"]","Component Present");
			if(i==count)
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button["+i+"]")));
				oASelFW.effecta("click","//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button["+i+"]","clicking on Component ");
			}
		}
		Actions action = new Actions(oASelFW.driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'control#save')]")));
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'control#save')]"));
		action.moveToElement(button).click().build().perform();
	}







	public void clickOnTool(String tool)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'"+tool+"')]")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'"+tool+"')]"));
		action.moveToElement(button).click().build().perform();
	}

	public void clickOnLinkUponCustomerStory(String customerStory,String linkTitle) throws InterruptedException
	{
		Thread.sleep(8000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-md-12 search-pagination')]/ul/li")));
		int pageCount=Integer.parseInt(oASelFW.effecta("getXapthCount","//div[contains(@class,'col-md-12 search-pagination')]/ul/li","getting page count"));
		System.out.println("Page Count:  " +pageCount );
		for(int i=1;i<=pageCount;i++)
		{
			Thread.sleep(5000);
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h5[contains(text(),'"+customerStory+"')]")))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(text(),'"+customerStory+"')]/following::a[contains(text(),'"+linkTitle+"')]")));
				oASelFW.effecta("click","//h5[contains(text(),'"+customerStory+"')]/following::a[contains(text(),'"+linkTitle+"')]","clicking on " + linkTitle);
				break;
			}
			else
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-md-12 search-pagination')]/ul/li[contains(@id,'viewNext')]/a")));
				oASelFW.effecta("click","","//div[contains(@class,'col-md-12 search-pagination')]/ul/li[contains(@id,'viewNext')]/a","clicking on pagination");
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(@id,'headerCount')]")));
				Thread.sleep(5000);
			}

		}	
	}

	public void insertTextInRichTextComponent(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		oASelFW.driver.switchTo().frame("ContentFrame");
		WebElement editor = oASelFW.driver.findElement(By.tagName("p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '<p>" +value+ "</p>'", editor);
		oASelFW.driver.switchTo().defaultContent();
		Thread.sleep(5000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'#lists')]")));
		WebElement button1 = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'#lists')]"));
		action.moveToElement(button1).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'lists#unordered')]")));
		WebElement button2 = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'lists#unordered')]"));
		action.moveToElement(button2).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'control#save')]")));
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'control#save')]"));
		action.moveToElement(button).click().build().perform();
	}

	public void insertTextInRichTextComponentValue(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		oASelFW.driver.switchTo().frame("ContentFrame");
		WebElement editor = oASelFW.driver.findElement(By.tagName("p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '<p>" +value+ "</p>'", editor);
		oASelFW.driver.switchTo().defaultContent();
		Thread.sleep(5000);
		Actions action = new Actions(oASelFW.driver);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@data-action,'control#save')]")));
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'control#save')]"));
		action.moveToElement(button).click().build().perform();
	}

	public void insertTextInRichTextTabComponentValue(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		oASelFW.driver.switchTo().frame("ContentFrame");
		WebElement editor = oASelFW.driver.findElement(By.tagName("p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '<p>" +value+ "</p>'", editor);
		oASelFW.driver.switchTo().defaultContent();
		Thread.sleep(5000);

	}

	public void insertTextInRichTextComponentWhenMaxmized(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement editor = oASelFW.driver.findElement(By.tagName("p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '<p>" +value+ "</p>'", editor);
	}

	public void DoubleClickonInsertedComponent(String title) throws InterruptedException
	{
		System.out.println("In method");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='"+title+"']")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"));

		WebElement ele = oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"));
		action.moveToElement(ele, 5, 5).click().build().perform();
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].doubleClick();", element);
		//action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='"+title+"']"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	public void enterComponentDetails(String label,String text)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("verifyElementPresent","//label[contains(text(),'"+label+"')]","verifying "+label);
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::input",text,"typing "+text);
	}

	public void clickOnAddfieldAndEnterComponentDetails(String Heading,String label,String text[],int n)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div")));
		for(int i=1,j=1,l=0;i<=(n*2);i++)
		{
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label")))
			{
				if(i<=(n*2))
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label/following-sibling::input")));
					oASelFW.effecta("verifyElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label/following-sibling::input","verifying "+ Heading);
					oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label/following-sibling::input",text[l],"typing "+text[l]);
					j++;
					l++;
				}
				else
				{
					break;
				}
			}
			else
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/button")));
				oASelFW.effecta("verifyElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","verfied add button");
				oASelFW.effecta("click","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","clicking on "+ Heading);
			}
		}
	}

	public void clickOnDone()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Done']")));
		oASelFW.effecta("click","//button[@title='Done']","Save");
	}

	public void addSubComponents(String text[]) throws InterruptedException
	{
		Thread.sleep(15000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='OverlayWrapper']")));
		int j=1;
		for(int i=8;i>=1;i--)
		{
			if(i==5 || i==1)
			{
				System.out.println("Do Nothing");
			}
			else
			{
				Thread.sleep(15000);			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='OverlayWrapper']/div/div/div["+i+"]")));
				oASelFW.effecta("click","//div[@id='OverlayWrapper']/div/div/div["+i+"]","clicking on sub component" + i);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'Configure')]")));
				oASelFW.effecta("click","//button[contains(@title,'Configure')]","clicking on configure");
				Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Details')]/following-sibling::div/button")));
				oASelFW.effecta("click","//label[contains(text(),'Details')]/following-sibling::div/button","clicking on add button");
				for(int k=1;k<=3;k++)
				{
					for(int p=1,l=0;p<=6;p++,l++)
					{
						if(p==4)
						{
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Details')]/following-sibling::div/ol/li["+k+"]/section/div/div["+p+"]/label/following-sibling::span/span/input/following-sibling::span/button")));
							oASelFW.effecta("click","//label[contains(text(),'Details')]/following-sibling::div/ol/li["+k+"]/section/div/div["+p+"]/label/following-sibling::span/span/input/following-sibling::span/button","clicking on image button");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Select path')]/following::div[contains(text(),'Digital Marketing')]["+j+"]")));
							oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following::div[contains(text(),'Digital Marketing')]["+j+"]","clicking on digital marketing");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Select path')]/following::div[contains(text(),'Digital Marketing')]/following::div[contains(text(),'VMWorld')]["+j+"]")));
							oASelFW.effecta("click","//h2[contains(text(),'Select path')]/following::div[contains(text(),'Digital Marketing')]/following::div[contains(text(),'VMWorld')]["+j+"]","Splash is clicked");
							oASelFW.effecta("click","xpath=(//h2[contains(text(),'Select path')]/following-sibling::button[contains(@title,'Confirm')])["+j+"]","clicking on confirm");
							j++;		
						}
						else
						{
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Details')]/following-sibling::div/ol/li["+k+"]/section/div/div["+p+"]/label/following-sibling::input")));
							oASelFW.effecta("type","//label[contains(text(),'Details')]/following-sibling::div/ol/li["+k+"]/section/div/div["+p+"]/label/following-sibling::input",text[l],"typing text");
						}
					}
					if(k<3)
					{
						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Details')]/following-sibling::div/button")));
						oASelFW.effecta("click","//label[contains(text(),'Details')]/following-sibling::div/button","clicking on add button");
					}

				}
				clickOnDone();
			}
		}
	}

	public void clickOnPreview()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'Preview')]")));
		oASelFW.effecta("click","//button[contains(@title,'Preview')]","clicking on preview button");
	}

	public String getCurrentPageUrlAndRemoveEditor()
	{
		String currentURL = oASelFW.driver.getCurrentUrl();
		if(currentURL.contains("editor.html"))
		{
			String url1=currentURL.substring(0, 39);
			System.out.println(url1);
			String	url2=currentURL.substring(51, currentURL.length());
			System.out.println(url2);
			currentURL=url1.concat(url2);
			System.out.println(currentURL);
		}
		return currentURL;		
	}

	public String getCurrentPageUrlAndAddRandomNumber()
	{
		String currentURL = oASelFW.driver.getCurrentUrl();
		int random=(int) (Math.random()*3000);
		if(currentURL.contains("products.html"))
		{
			String[] sub = currentURL.split("products.html");
			return sub[0]+"products"+random+".html";	
		}
		return currentURL;		
	}


	public String getCurrentPageUrlAndAddEditor()
	{
		String currentURL = oASelFW.driver.getCurrentUrl();
		StringBuffer sb = new StringBuffer(currentURL);
		currentURL=(sb.insert(39,"editor.html/")).toString(); 
		System.out.println(currentURL);
		return currentURL;	
	}

	public String getCurrentPageUrlAndRemoveEditorAndAddPublish()
	{
		String currentURL = oASelFW.driver.getCurrentUrl();
		if(currentURL.contains("editor.html"))
		{
			String	url2=currentURL.substring(51, currentURL.length());
			System.out.println(url2);
			String url3="http://aem-test-pub-1.vmware.com:8085/";
			currentURL=url3.concat(url2);
			System.out.println(currentURL);
		}
		return currentURL;
	}

	public void scrollDown(String value) throws InterruptedException
	{
		WebElement element = oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'"+value+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 	
	}

	public void scrollDown_Modified(String value) throws InterruptedException
	{
		for(int i=1;;i++)
		{
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[contains(text(),'"+value+"')]")))
			{
				WebElement element = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+value+"')]"));
				((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(5000); 
				break;
			}
			else
			{	
				((JavascriptExecutor) oASelFW.driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(5000);
			}
		}	
	}

	public String getStickyHeaderAttribute()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Agenda Header')]/following::div[contains(@class,'agendaTab whiteBg fixed-header')]")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'Agenda Header')]/following::div[contains(@class,'agendaTab whiteBg fixed-header')]"));
		String attribute=element.getAttribute("class");
		System.out.println("attribute: "+ attribute);
		return attribute; 		
	}

	public void validatingStickyHeaderStatus(String attribute)
	{
		if(attribute.equalsIgnoreCase("agendaTab whiteBg fixed-header"))
		{
			System.out.println("Header is fixed");
			oASelFW.effecta("sendReport","Validating whether the header is fixed or not","Validated successfully that header is fixed with the property value as"+ attribute,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Validating whether the header is fixed or not","Validated successfully that header is not fixed with the property value as"+ attribute,"Fail");
		}

	}

	public String[] tabStatusAndBackgroundColor(String value)
	{
		String temp[]=new String[2];
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Agenda Header')]/following::ul/li[contains(@data-scrollid,'"+value+"')]")));
		WebElement element=oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'Agenda Header')]/following::ul/li[contains(@data-scrollid,'"+value+"')]"));
		temp[0]=element.getAttribute("class");
		temp[1]=element.getCssValue("background-color");
		System.out.println("Status: "+ temp[0]);
		System.out.println("BackgroundColor: "+ temp[1]);
		String s1 = temp[1].substring(5);
		StringTokenizer st = new StringTokenizer(s1);
		int r = Integer.parseInt(st.nextToken(",").trim());
		int g = Integer.parseInt(st.nextToken(",").trim());
		int b = Integer.parseInt(st.nextToken(",").trim());
		Color c = new Color(r, g, b);
		temp[1] = "#"+Integer.toHexString(c.getRGB()).substring(2);
		System.out.println(temp[1]);
		return temp;
	}

	public void validatingTabAfterScrolling(String temp[])
	{
		String attribute=temp[0];
		String backgroundColor=temp[1];
		if(attribute.contains("active")&& backgroundColor.equals("#595959"))
		{
			oASelFW.effecta("sendReport","Validating whether the particular tab is highlighted after scrolling","Validated successfully that tab is higlighted as the background color is "+backgroundColor,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Validating whether the particular tab is highlighted after scrolling","Validated successfully that tab is not higlighted as the background color is" + backgroundColor,"Fail");
		}	
	}

	public void clickOnTabs(String value)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Agenda Header')]/following::input[contains(@value,'"+value+"')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Agenda Header')]/following::input[contains(@value,'"+value+"')]","clicking on "+value);
	}


	public void verifyDownloadFile(String FilePath,String FileName,String Exn) throws InterruptedException {
		File dir = new File(FilePath);
		FileFilter fileFilter = new WildcardFileFilter("*"+FileName+"*."+Exn+"");
		File[] files = dir.listFiles(fileFilter);
		try{
			for (int i = 0; i < files.length; i++) {
				System.out.println("before Deleting files"+files[i]);
				File file = new File(String.valueOf(files[i]));
				if(file.delete()){
					System.out.println(file.getName() + " is deleted!");
				}else{
					System.out.println("Delete operation is failed.");
				}
			}
		}catch(NullPointerException ext){
			ext.printStackTrace();
		}
		Thread.sleep(3000);
		System.out.println("Delete Existing download files from Drive");
	}
	
	public void clickOnAddfieldAndEnterComponentDetailsFormContainer(String Heading,String[] label,String[] values,int n)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div")));
		for(int i=1,j=1;i<=8;i++)
		{
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label")))
			{
				for(int k=0;k<2;k++)
				{
					if(i<=2)
					{
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k],"typing "+values[k]);
					}
					else if(i<=4)
					{
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k+2],"typing "+values[k+2]);	
					}
					else
					{
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k+4],"typing "+values[k+4]);	
					}


				}
				j++;


			}
			else
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/button")));
				oASelFW.effecta("verifyElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","verfied add button");
				oASelFW.effecta("click","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","clicking on "+ Heading);

			}

		}
	}

	public void handleErrorMsg()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Fail to load next page.')]/following::button")));
		oASelFW.effecta("clickAndWait","//div[contains(text(),'Fail to load next page.')]/following::button","clicking on close button");
	}

	public void clickOnPage()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@id,'pagination')]/li")));
		int pageCount=Integer.parseInt(oASelFW.effecta("getXpathCount","//ul[contains(@id,'pagination')]/li"));
		System.out.println("Page Count:" + pageCount);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@id,'pagination')]/li["+(pageCount-2)+"]/a")));
		oASelFW.effecta("click","//ul[contains(@id,'pagination')]/li["+(pageCount-2)+"]/a","clicking on page navigation");	
	}

	public void clickOnFeedback() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,30);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Feedback')]")));
		oASelFW.effecta("click","//a[contains(text(),'Feedback')]","clicking on feedback");
		Thread.sleep(3000);	
	}

	public void selectLanguage()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,40);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[contains(@name,'Q_lang')]")));
		Select select= new Select(oASelFW.driver.findElement(By.xpath("//select[contains(@name,'Q_lang')]")));
		select.selectByValue("CS");
		oASelFW.driver.switchTo().defaultContent();
	}

	/**
	 * @author Divanshu_Sharma
	 * @Page Agenda Header Page
	 */

	public void click_AddField(String heading ,String button)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='"+heading+"']")));
		oASelFW.effecta("click","//button[text()='"+button+"']","clicking on"+button);
	}

	public void clickOnPartialWidthComponent(String componentName, String colNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Partial Width Content Card' and contains(@data-path,'jcr:content/par/"+componentName+"/"+colNum+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Partial Width Content Card' and contains(@data-path,'jcr:content/par/"+componentName+"/"+colNum+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Partial Width Content Card' and contains(@data-path,'jcr:content/par/"+componentName+"/"+colNum+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}

	public void typePageTitle(String value) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Page Title(Suggested 100 Characters)')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'Page Title(Suggested 100 Characters)')]/following-sibling::input",value,"Value is" + value);
		Thread.sleep(3000);
	}

	public void typePageDescription(String label,String value) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::input")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::input",value,"Value is" + value);
		Thread.sleep(3000);
	}

	public void richtextScreen(String screen) throws Exception
	{

		WebDriverWait wait=new WebDriverWait(oASelFW.driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'"+screen+"')]")));
		oASelFW.effecta("click","//button[contains(@data-action,'"+screen+"')]","Value is"+screen);
		Thread.sleep(3000);
	}

	public void clickOnAddfieldAndEnterComponentDetailsCheckboxes(String Heading,String[] label,String[] values,int n)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div")));
		for(int i=1,j=1;i<=4;i++)
		{
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label")))
			{
				for(int k=0;k<2;k++)
				{
					if(i<=2)
					{
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k],"typing "+values[k]);
					}
					else
					{
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k+2],"typing "+values[k+2]);	
					}


				}
				j++;


			}
			else
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/button")));
				oASelFW.effecta("verifyElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","verfied add button");
				oASelFW.effecta("click","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","clicking on "+ Heading);

			}

		}
	}


	public void clickOnAddfieldAndEnterComponentDetailsDropdown(String Heading,String[] label,String[] values,int n) throws Exception
	{	
		AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+Heading+"')]/following::div")));
		for(int i=1,j=1;i<=4;i++)
		{
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h4[contains(text(),'"+Heading+"')]/following::div/div[2]/div/div/ol/li["+j+"]/section/div/div/label")))
			{
				for(int k=0;k<2;k++)
				{
					if(i<=2)
					{//h4[contains(text(),'Options for Static Drop down authoring')]/following::div/ol/li[1]/section/div/div[2]/input
						////h4[contains(text(),'"+Heading+"')]/following-sibling::div/div[2]/div/div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'"+Heading+"')]/following::div/div[2]/div/div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//h4[contains(text(),'"+Heading+"')]/following::div/div[2]/div/div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k],"typing "+values[k]);
					}
					else
					{
						wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'"+Heading+"')]/following::div/div[2]/div/div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input")));
						oASelFW.effecta("type","//h4[contains(text(),'"+Heading+"')]/following::div/div[2]/div/div/ol/li["+j+"]/section/div/div/label[text()='"+label[k]+"']/following-sibling::input",values[k+2],"typing "+values[k+2]);	
					}


				}
				j++;


			}
			else
			{
				/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'"+Heading+"')]/following::div/button")));
				oASelFW.effecta("verifyElementPresent","//h4[contains(text(),'"+Heading+"')]/following-sibling::div/button","verfied add button");
				oASelFW.effecta("click","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","clicking on "+ Heading);
*/
				
				aemComponentsObj.ClickAddField();
				Thread.sleep(3000);
			}

		}
	}



}




