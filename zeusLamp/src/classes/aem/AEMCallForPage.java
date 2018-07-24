package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;


/**
 * @author Divanshu
 * @Page Call For Page
 */

public class AEMCallForPage 
{
	ArsinSeleniumAPI oASelFW;

	public AEMCallForPage(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}

	public void enterComponentDetails(String label,String text)
	{
		System.out.println("Entered into enterComponentPath");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::input",text,"typing "+text);
	}
	
	public void enterDatePicker(String label,String text)
	{
		System.out.println("Entered into enterDatePicker");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::span/descendant::input",text,"typing "+text);
	}
	
	public void uncheckVideo(String label)
	{
		System.out.println("Entered into uncheckVideo");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("click","//label[contains(text(),'"+label+"')]/following-sibling::div/label[2]/input/following::span",label);
	}
	
	public void enterComponentTextAreaDetails(String label,String text)
	{
		System.out.println("Entered into enterComponentPath");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::textarea",text,"typing "+text);
	}

	public void enterComponentPath(String label,String text)
	{
		System.out.println("Entered into enterComponentPath");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::span/descendant::span/input",text,"typing "+text);
	}	
	
	public void selectWindow(String label, String window)
	{
		System.out.println("Entered into selectWindow");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("select","//label[text()='"+label+"']/following-sibling::span/select",window,"Selecting "+window);
	}
	
	public void clickOnDone()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Done']")));
		oASelFW.effecta("click","//button[@title='Done']","Save");
	}
	
	public void clickOnAddfieldAndEnterComponentDetails(String Heading,String text[],int n)
	{
		System.out.println("Entered into clickOnAddfieldAndEnterComponentDetails");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div")));
		System.out.println("N value:" +n);
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

	public void headerCfp(String header) throws Exception
	{
		System.out.println("Entered into headerCfp");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+header+"')]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+header+"')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+header+"')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void clickOnCFPDragComponent(String header,String componentNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/callforpapers/"+header+"/"+componentNum+"/')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/callforpapers/"+header+"/"+componentNum+"/')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/callforpapers/"+header+"/"+componentNum+"/')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void click_multipleRichTextComponent(String header,String componentNum)  throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Rich Text Component' and contains(@data-path,'jcr:content/par/callforpapers/"+header+"/"+componentNum+"/callforpapers/richtext')]")));
		oASelFW.effecta("click","//div[@title='Rich Text Component' and contains(@data-path,'jcr:content/par/callforpapers/"+header+"/"+componentNum+"/callforpapers/richtext')]","clicking on" + header);
		Thread.sleep(5000);
	}
	
	public void Verify(String label,String text)
	{
		System.out.println("Entered into enterComponentPath");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::input",text,"typing "+text);
	}
	
	public void enterLogo(String label,String text)
	{
		System.out.println("Entered into enterLogo");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::span/descendant::span/input",text,"typing "+text);
	}
	
	public void enterDescription(String label,String text)
	{
		System.out.println("Entered into enterLogo");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+label+"')]")));
		oASelFW.effecta("type","//label[contains(text(),'"+label+"')]/following-sibling::textarea",text,"typing "+text);
	}
	
	
	public void clickOnSponsoredDrag(String header)  throws Exception
	{
		System.out.println("Entered into clickOnSponsoredDrag");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/sponsorheader/"+header+"/')]")));
		Thread.sleep(5000);
		System.out.println("after wait");
		int size=oASelFW.driver.findElements(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/sponsorheader/"+header+"/')]")).size();
		System.out.println("size:"+size);
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/sponsorheader/"+header+"/')]",header);
	}
	
	public void sponsorHeader(String header) throws Exception
	{
		System.out.println("Entered into headerCfp");
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+header+"/sponsorcontent')]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+header+"/sponsorcontent')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+header+"/sponsorcontent')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public String getAuthURL() throws Exception
	{
		Thread.sleep(5000);
		//String win[]=oASelFW.effectaArray("getAllWindowNames");
		//oASelFW.effecta("selectWindow",win[1]);
		String authURL=oASelFW.driver.getCurrentUrl();
		System.out.println("authURL:"+authURL);
		return authURL;
	}

	
	public String formPublishedURL(String authoringURL)
	{
		String publishedURL="";
		publishedURL=authoringURL.replaceAll("/editor.html", "");
		return publishedURL;
	}
	
	public void VerifySponsorHeaderTitle(String text)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h1[contains(text(),'"+text+"')]","verifying "+text);
	}

	public void VerifySponsorContent(String text)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//ul/li[contains(text(),'"+text+"')]","verifying "+text);
	}
	
	public void VerifySponsorContentDescription(String text)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//p[contains(text(),'"+text+"')]","verifying "+text);
	}
	
	public void VerifySponsorLevelHeading(String text)
	{	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'"+text+"')]")));
		oASelFW.effecta("verifyElementPresent","//h3[contains(text(),'"+text+"')]","verifying "+text);	
	}
	
	public void clicklevelHeading(String heading, String company, String logoLink)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+heading+"']")));
		oASelFW.effecta("click","//a[text()='"+heading+"']","clicking "+heading);	
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h3[text()='"+company+"']/../div/div/descendant::img[@src='"+logoLink+"']")))
		{
		oASelFW.effecta("sendReport","Checking Whether Element Is Coming Under:-"+heading,"Element Is Coming Successfully Under:-"+heading,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Checking Whether Element Is Coming Under:-"+heading,"Element Is Not Coming Successfully Under:-"+heading,"Fail");
		}
	}
	
	public void click_screenSize(String screen) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-action='"+screen+"']")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[@data-action='"+screen+"']"));
		action.moveToElement(button).click().build().perform();
	}
	
	public void click_ControlSave(String buttonType) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-action='"+buttonType+"']")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[@data-action='"+buttonType+"']"));
		action.moveToElement(button).click().build().perform();
	}
	
	public void click_RichTextButtons_StylesButton(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button[24]")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button[24]"));
		action.moveToElement(button).click().build().perform();
		oASelFW.effecta("sendReport","Click on Styles","Successfully clicked on Styles","Pass");	
	}
	
	public void click_RichTextButtons_ModifyLinksButton(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button[6]")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button[6]"));
		action.moveToElement(button).click().build().perform();
		oASelFW.effecta("sendReport","Click on Links Modify","Successfully clicked on Links Modify","Pass");	
	}
	
	public void click_RichTextButtons_FormatBoldButton(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button[1]")));
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//div[contains(@class,'coral-RichText-toolbar is-sticky is-active')]/button[1]"));
		action.moveToElement(button).click().build().perform();	
		oASelFW.effecta("sendReport","Click on Links Modify","Successfully clicked on Bold Format","Pass");	
	}
	
	public void click_RichTextButtons_Styles() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'#styles')]")));
		JavascriptExecutor js = (JavascriptExecutor) oASelFW.driver;
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'#styles')]"));
		js.executeScript("arguments[0].setAttribute('class', 'coral-RichText-toolbar-item coral-Icon coral-Icon--textStyle coral-RichText--trigger')",element);
	}
	
	
	public void click_RichText_ValueDoubleClick(String text) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/p[contains(text(),'"+text+"')]")));
		JavascriptExecutor js = (JavascriptExecutor) oASelFW.driver;
		WebElement element = oASelFW.driver.findElement(By.xpath("//div/p[contains(text(),'"+text+"')]"));
		js.executeScript("arguments[0].doubleClick();",element);
		oASelFW.effecta("sendReport","Select entered text","Entered text is selected successfully","Pass");	
	}
	
	
	public void click_RichTextButtons_LinksModify() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@data-action,'links#modifylink')]")));
		JavascriptExecutor js = (JavascriptExecutor) oASelFW.driver;
		WebElement element = oASelFW.driver.findElement(By.xpath("//button[contains(@data-action,'links#modifylink')]"));
		js.executeScript("arguments[0].setAttribute('class', 'coral-RichText-toolbar-item disabled coral-Icon coral-Icon--link coral-RichText--trigger')",element);
	}
	
	public void insertTextInRichTextComponentWhenMaxmized(String value) throws InterruptedException
	{
		/*Thread.sleep(5000);
		WebElement editor = oASelFW.driver.findElement(By.xpath("//div[@class='coral-RichText-editor is-edited gecko']/p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '" +value+ "';", editor);	*/
		
		
		Thread.sleep(5000);
		WebElement editor = oASelFW.driver.findElement(By.tagName("p"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) oASelFW.driver;
		jsExecutor.executeScript("arguments[0].innerHTML = '<p>" +value+ "</p>'", editor);	
	
	}
	
	public void clickOnAddfieldAndEnterComponentDetails8081(String Heading,String text[],int n)
	{
		System.out.println("Entered into clickOnAddfieldAndEnterComponentDetails");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div")));
		System.out.println("N value:" +n);
		for(int i=1,j=1,l=0;i<=(n*2);i++)
		{
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label")))
			{
				if(i<=(n*2))
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label/following::input")));
					oASelFW.effecta("verifyElementPresent","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label/following::input::input","verifying "+ Heading);
					oASelFW.effecta("type","//label[contains(text(),'"+Heading+"')]/following-sibling::div/ol/li["+j+"]/section/div/div/label/following::input",text[l],"typing "+text[l]);
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
	
	public void clickAddField(String Heading)
	{
		System.out.println("Entered into clickOnAddField");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+Heading+"')]/following-sibling::div")));
		oASelFW.effecta("click","//label[contains(text(),'"+Heading+"')]/following-sibling::div/button","clicking on "+ Heading);	
	}
	
	
	public void descText(String header, String text)
	{
		System.out.println("Entered into descText");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title')]")));
		oASelFW.effecta("type","//div[@contenteditable='true' and contains(@data-config-path,'/mnt/override/apps/vmwaredevapp/components/content/"+header+"/cq:dialog/content')]",text,"Description Text");
	}
	
	public void clickOnthreecolDragComp(String header,String componentNum)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+header+"/"+componentNum+"/')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+header+"/"+componentNum+"/')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'jcr:content/par/"+header+"/"+componentNum+"/')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void clickOnPartialWidth(String header)  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Partial Width Content Card' and contains(@data-path,'jcr:content/par/threecolumncontainer/"+header+"/hcontentcard')] ")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Partial Width Content Card' and contains(@data-path,'jcr:content/par/threecolumncontainer/"+header+"/hcontentcard')] "));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Partial Width Content Card' and contains(@data-path,'jcr:content/par/threecolumncontainer/"+header+"/hcontentcard')] "))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void editThreeCol()  throws Exception
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Three Column Container' and contains(@data-path,'jcr:content/par/threecolumncontainer')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Three Column Container' and contains(@data-path,'jcr:content/par/threecolumncontainer')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Three Column Container' and contains(@data-path,'jcr:content/par/threecolumncontainer')]"))).doubleClick().build().perform();
		Thread.sleep(5000);
	}
	
	public void clickMenu()
	{
		oASelFW.effecta("click","//span[text()='Disable Hamburger Menu ?']/../descendant::input","Uncheck button");	
	}

	
	
}




