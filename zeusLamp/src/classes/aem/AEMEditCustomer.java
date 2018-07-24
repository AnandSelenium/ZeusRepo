package classes.aem;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMEditCustomer {
	ArsinSeleniumAPI oASelFW;

	public AEMEditCustomer(){


	}
	public AEMEditCustomer(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}


	public void clickProperties(String customerName) throws Exception{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+customerName+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerName+"']"))).perform();
		Thread.sleep(2000);
		oASelFW.driver.findElement(By.xpath("//span[text()='Properties...']")).click();

		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//span[contains(text(),'Page Properties of')]")))
		{
			oASelFW.effecta("sendReport","clicking on Properties for Customer:"+customerName,"Successfully Clciked on Properties","Pass");
		}
		else
		{
			act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerName+"']"))).perform();
			Thread.sleep(2000);
			oASelFW.driver.findElement(By.xpath("//span[text()='Properties...']")).click();
		}	
	}

	public String editCustomer(){
		long n=(long) (Math.random()*100000);
		String custName="CustomerName"+n;
		oASelFW.effecta("verifyElementPresent","//label[text()='Title']/..//div/input","Title");
		oASelFW.effecta("type","//label[text()='Title']/following-sibling::div/input",custName,"Title");
		oASelFW.effecta("click","//button[contains(text(),'OK')]","Clicked OK");
		oASelFW.driver.navigate().refresh();
		return custName;
	}

	public void Search(String customerName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='cq-gen34']")));
		oASelFW.effecta("clickAndWait","//button[@id='cq-gen34']","Website");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Search')]")));
		oASelFW.effecta("click","//span[contains(text(),'Search')]","Search");
		Thread.sleep(2000);
		WebElement we=oASelFW.driver.findElement(By.xpath("//label[text()='Fulltext']/..//div//input"));
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[text()='Fulltext']/..//div//input",customerName,"Customer Name:"+customerName);
		we.sendKeys(Keys.ENTER);
	}

	public void verifySerchResults_Customer(String customerName) throws Exception
	{	
		/*WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='cq-gen166']")));
			Thread.sleep(5000);
			oASelFW.effecta("click","//span[contains(text(),'Search')]","Search");
			Thread.sleep(2000);
			oASelFW.effecta("type","//label[text()='Fulltext']/..//div//input",customerName,"Customer Name:"+customerName);
			WebElement we=oASelFW.driver.findElement(By.xpath("//label[text()='Fulltext']/..//div//input"));
			Thread.sleep(2000);
			we.sendKeys(Keys.ENTER);
			Actions act=new Actions(oASelFW.driver);
			act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerName+"']"))).perform();
			Thread.sleep(2000);
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[text()='"+customerName+"')]"))){
				oASelFW.effecta("sendReport","validating whether Created Customer "+customerName+" is avavilable in AEM or not","Successfully verified.Customer is available with name: "+customerName,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","validating whether Created Customer "+customerName+" is avavilable in AEM or not","Unable to verify the Customer with name: "+customerName,"Fail");
			}*/
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+customerName+"')]")));
		Thread.sleep(5000);
		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(text(),'"+customerName+"')]")))
		{
			oASelFW.effecta("sendReport","validating whether Created Customer "+customerName+" is avavilable in AEM or not","Successfully verified.Customer is available with name: "+customerName,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","validating whether Created Customer "+customerName+" is avavilable in AEM or not","Unable to verify the Customer with name: "+customerName,"Fail");
		}	
	}

	public void validateEditCustDetails()
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='cq-cf-frame']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Customer Name']/../div/input")));
		oASelFW.effecta("verifyElementPresent","//label[text()='Customer Name']/../div/input","Customer Name");
		oASelFW.effecta("verifyElementPresent","//label[text()='Logo Path']","Logo Path");
		oASelFW.effecta("verifyElementPresent","//label[text()='Link URL']","Link URL");
		oASelFW.effecta("verifyElementPresent","//label[text()='Size']","Size");
		oASelFW.effecta("verifyElementPresent","//label[contains(text(),'Industry')]/following-sibling::div//img[@class='arrow-trigger']","Industry");
		oASelFW.driver.switchTo().defaultContent();

	}

	public void deleteCustomer(String customerName) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		Thread.sleep(5000);
		System.out.println("After wait");
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].setAttribute('class','x-grid3-row  x-grid3-row-first x-grid3-row-last x-grid3-row-selected')", oASelFW.driver.findElement(By.xpath("//div[@class='x-grid3-row  x-grid3-row-first x-grid3-row-last']")));
		Actions act=new Actions(oASelFW.driver);
		act.contextClick(oASelFW.driver.findElement(By.xpath("//div[text()='"+customerName+"']"))).perform();
		Thread.sleep(3000);
		oASelFW.effecta("click","//span[text()='Delete']","Delete");
		Thread.sleep(2000);
		oASelFW.effecta("click","//button[text()='Yes']","Sure");
	}

	public void click_EditIn_AEMEditorPage() throws Exception
	{
		//oASelFW.effecta("waitForElementPresent","xpath=(//button[text()='Edit'])[2]","50");
		WebDriverWait wait= new WebDriverWait(oASelFW.driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Edit') and contains(@data-align,'right')]")));
		oASelFW.effecta("click","//button[contains(text(),'Edit') and contains(@data-align,'right')]","Edit");
		oASelFW.effecta("click","//div[@class='editor-GlobalBar-leftContainer']/button[1]","Toggle Panel");
		oASelFW.effecta("click","//a[text()='Components']","Components");

	}

	public void dragAndDropImagesIn_AEMEditorPage() throws Exception
	{
		Thread.sleep(5000);
		WebElement megamenuContainer=oASelFW.driver.findElement(By.xpath("//h4[text()='Megamenu Container']/parent::div[@class='label']/parent::a/parent::article"));
		WebElement destination=oASelFW.driver.findElement(By.xpath("//div[@data-text='Drag components here']"));

		Actions action=new Actions(oASelFW.driver);
		action.dragAndDrop(megamenuContainer,destination).build().perform();

		for(int i=1;i<=2;i++)
		{
			WebElement megaMenuLinks=oASelFW.driver.findElement(By.xpath("//h4[text()='MegaMenu Links']/parent::div[@class='label']/parent::a/parent::article"));

			action.dragAndDrop(megaMenuLinks, destination).build().perform();
		}
		Thread.sleep(3000);
	}

	public void doubleClick_MeageMenuLinksIn_AEMEditorPage() throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//div[contains(@class,'is-disabled')]/div[4]","50");
		WebElement megamenuContainer=oASelFW.driver.findElement(By.xpath("//div[contains(@class,'is-disabled')]/div[4]"));
		megamenuContainer.click();
		Thread.sleep(3000);
		WebElement configure=oASelFW.driver.findElement(By.xpath("//i[@title='Configure']"));
		configure.click();
		Thread.sleep(3000);
	}

	public String enter_MegaMenuLinksAndTitlesIn_AEMEditorPage(String linkLabel1,String linkLabel2) throws Exception
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

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text()='Title')]/following-sibling::input")));

		oASelFW.effecta("type","//label[contains(text(),'Title')]/following-sibling::input",title,"Title");
		oASelFW.effecta("click","//button[text()='Add field']","Add field");
		Thread.sleep(2000);
		oASelFW.effecta("type","//label[contains(text(),'Link Label')]/following-sibling::input",linkLabel1,"link label");
		Thread.sleep(3000);	
		oASelFW.effecta("clickAndWait","//label[text()='Link Path']/following-sibling::span//span[@class='coral-InputGroup-button']","Link Path Image");
		Thread.sleep(5000);
		oASelFW.effecta("click","//div[text()='VMware']","Vmware");
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[text()='Language Master Sites']","Language Master Sites");
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[text()='English']","English");
		Thread.sleep(2000);
		oASelFW.effecta("click","//div[text()='QATestAutomation']","QATestAutomation");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[text()='test3456']","Path Selected");
		oASelFW.effecta("clickAndWait","//h2[text()='Select path']/following-sibling::button[@title='Confirm']","Selected Path");

		Thread.sleep(3000);

		oASelFW.effecta("select","//label[text()='Select URL Open type']/following-sibling::span//select","New Window","Select URL Open type");

		oASelFW.effecta("click","//button[text()='Add field']","Add field");

		Thread.sleep(2000);

		oASelFW.effecta("type","//label[contains(text(),'Link Label')]/following-sibling::input[contains(@class,'is-invalid')]",linkLabel2,"link label");

		oASelFW.effecta("type","//label[text()='Link Path']/following-sibling::span//span[@class='coral-InputGroup-button']/preceding-sibling::input[contains(@class,'is-invalid')]","www.google.com","link path");

		Thread.sleep(2000);

		oASelFW.effecta("click","//button[@title='Done']/i","Done");

		Thread.sleep(3000);

		return title;
	}

	public void click_previewIn_AEMEditorPage() throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//span[text()='Preview']","50");
		oASelFW.effecta("click","//span[text()='Preview']","Preview");

	}
	
	public void dragAndDropComponentAEMEditorPage() throws Exception
	{
		Thread.sleep(5000);
		WebElement megamenuContainer=oASelFW.driver.findElement(By.xpath("//h4[text()='Banner Text']/parent::div[@class='label']/parent::a/parent::article"));
		WebElement destination=oASelFW.driver.findElement(By.xpath("//div[@data-text='Drag components here']"));

		Actions action=new Actions(oASelFW.driver);
		action.dragAndDrop(megamenuContainer,destination).build().perform();

		for(int i=1;i<=2;i++)
		{
			WebElement megaMenuLinks=oASelFW.driver.findElement(By.xpath("//h4[text()='Banner Text']/parent::div[@class='label']/parent::a/parent::article"));

			action.dragAndDrop(megaMenuLinks, destination).build().perform();
		}
		Thread.sleep(3000);
	}


	public void verify_LinksInContainer(String title,String submenu) throws Exception
	{
		oASelFW.effecta("waitForElementPresent","//a[contains(text(),'"+title+"')]","50");
		WebElement title1=oASelFW.driver.findElement(By.xpath("//a[contains(text(),'"+title+"')]"));

		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(title1).build().perform();

		Thread.sleep(5000);

		boolean flag=false;
		List<WebElement> value=oASelFW.driver.findElements(By.xpath("//a[contains(text(),'"+title+"')]/following-sibling::ul/li"));
		System.out.println("total li are:"+value.size());

		for(WebElement text:value)
		{
			String t=text.getText();
			System.out.println("text value is:" +t);
			if(text.getText().contains(submenu))
			{
				flag=true;
			}
		}

		if(flag==true)
		{
			oASelFW.effecta("sendReport","Verify Submenu "+submenu,submenu+" Successfully verified.","Pass");
		}
		else
		{
			oASelFW.effecta("sendReport","Verify Submenu "+submenu,"Fail to verify Submenu " +submenu,"Fail");

		}

	}
	
	public void enter_bannerDetails(String PageTemplate) throws Exception
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Event Notification']/following-sibling::input")));
		
		String eventName="EventNotification";
		int random=(int) (Math.random()*10000);
		eventName=eventName+random;
		oASelFW.effecta("type","//label[text()='Event Notification']/following-sibling::input",eventName,"Event Description");
		Thread.sleep(3000);
		
		String date="EventCTA";
		int t=(int) (Math.random()*10000);
		date=date+t;
		oASelFW.effecta("type","//label[text()='CTA Label']/following-sibling::input",date,"Event CTA Label");
		Thread.sleep(3000);

		String info="EventCTA_URL";
		int rand=(int) (Math.random()*10000);
		info=info+rand;
		oASelFW.effecta("type","//label[text()='CTA URL']/following-sibling::input",info,"Event CTA Url");
		Thread.sleep(3000);
		
		String eventdesc="EventDesc";
		int random1=(int) (Math.random()*10000);
		eventdesc=eventdesc+random1;
		oASelFW.effecta("type","//label[text()='Event Description']/following-sibling::input",eventdesc,"Event Description");
		Thread.sleep(3000);
		
		String date1 = "EventDate";
		int rand1=(int) (Math.random()*10000);
		date1=date1+rand1;
		oASelFW.effecta("type","//label[contains(text(),'Event Date')]/../input",date1,"Event Date");
		Thread.sleep(3000);
		
		String location ="EventLocation";
		int rando=(int) (Math.random()*10000);
		location=rando+location;
		oASelFW.effecta("type","//label[contains(text(),'Location')]/../input",location,"Event Address");
		
		Thread.sleep(6000);
		oASelFW.effecta("click","//label[contains(text(),'Location')]/../input/following::span[4]/button","Image button is clicekd");
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'Content Root')]","Content Root is clicked");
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'Content Root')]/following::nav/div/a/div/../div[contains(text(),'VMworld')]","VMworld is clicked");
		Thread.sleep(6000);
		/*oASelFW.effecta("click","//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]","Splsah PAge is selected");
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]/following::nav/div/a/div/../div[contains(text(),'"+PageTemplate+"')]","Verified Site URL is configured at the menu section");
        Thread.sleep(8000);
		oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]/following::nav/div/a/div/../div[contains(text(),'"+PageTemplate+"')]/following::nav/div/a/div/../div[contains(text(),'test123')])[1]","test123 logo url is selected");
		Thread.sleep(3000);*/
		oASelFW.effecta("click","//h2[contains(text(),'Select path')]/../button[@title='Confirm']","Details Completed");
	}
	
	
		public void click_publishPage()
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='coral-Link editor-GlobalBar-item']/i")));	
			oASelFW.effecta("click","//a[@class='coral-Link editor-GlobalBar-item']/i","LINK EDITOR");
			oASelFW.effecta("click","//button[text()='Publish Page']","Publish Page");
			//oASelFW.effecta("sendReport","Verifying The Publish Page","Successfully Verified The Page","Pass");
		}
		
		public void click_publish() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Publish']")));
			oASelFW.effecta("click","//button[text()='Publish']","PUBLISH");
			Thread.sleep(3000);
		}
		
		public void click_publish1() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Publish']")));
			oASelFW.effecta("click","//button[text()='Publish']","PUBLISH");
			Thread.sleep(3000);
		}
		
		public void htmlText_details() throws Exception
		{
			String name="GoogleMap";
			int random=(int) (Math.random()*10000);
			name=name+random;
			String text=oASelFW.getConstantValue("HTMLText_GoogleMAP");
			oASelFW.effecta("type","//label[text()='Title']/following-sibling::input",name,"Title");
			Thread.sleep(2000);
			oASelFW.effecta("type","//label[text()='HTML Text']/following-sibling::textarea",text,"Java Script Code");
			Thread.sleep(2000);
			oASelFW.effecta("click","//button[@title='Done']","Details Completed");
			Thread.sleep(2000);	
			oASelFW.effecta("sendReport","Sending Html Text component Details","Successfully Validate The Details","Pass");
		}
		
		public void colControl_details() throws Exception
		{
			String name="VMwareBlog";
			int random=(int) (Math.random()*10000);
			name=name+random;
			String text=oASelFW.getConstantValue("Column_Control");
			oASelFW.effecta("type","//label[text()='Title']/following-sibling::input",name,"Title");
			Thread.sleep(2000);
			oASelFW.effecta("type","//label[text()='HTML Text']/following-sibling::textarea",text,"Java Script Code");
			Thread.sleep(2000);
			oASelFW.effecta("click","//button[@title='Done']","Details Completed");
			Thread.sleep(2000);	
			oASelFW.effecta("sendReport","Sending Html Text component Details","Successfully Validate The Details","Pass");
		}
		
		public void verifyEditMode() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Edit']")));
			Thread.sleep(3000);
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//button[text()='Edit']")))
			{
				oASelFW.effecta("sendReport","Verifying Google Map in Edit Mode","Successfully verifed Google Map is in Edit Mode","Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verifying Google Map in Edit Mode","Unable to verify","Fail") ;
			}
		}
		
		public void verifyColControlEditMode() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]")));
			Thread.sleep(3000);
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]")))
			{
				oASelFW.effecta("sendReport","Verifying Column Control in Edit Mode","Successfully verifed Column Control is in Edit Mode","Pass") ;
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verifying Column Control in Edit Mode","Unable to verify","Fail") ;
			}
		}
		
		public void click_rolloutPage() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='coral-Link editor-GlobalBar-item']/i")));	
			oASelFW.effecta("click","//a[@class='coral-Link editor-GlobalBar-item']/i","LINK EDITOR");
			oASelFW.effecta("click","//button[contains(text(),'Rollout Page')]","Rollout Page");
			Thread.sleep(3000);
		}
		
		public void selectSite() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Rollout page and all sub pages']")));	
			oASelFW.effecta("click","//span[text()='Rollout page and all sub pages']/preceding-sibling::span","Rollout All");
			oASelFW.effecta("click","//span[contains(text(),'All')]/preceding-sibling::span","Uncheck all Site");
			oASelFW.effecta("click","//span[contains(text(),'/content/vmware/vmware-published-sites/ca/en')]/../../../div/label/span","English Locale");
			oASelFW.effecta("click","//button[@title='Rollout']","Rollout");
			Thread.sleep(3000);
		}
		
		public void selectSite_Japan() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Rollout page and all sub pages']")));	
			oASelFW.effecta("click","//span[text()='Rollout page and all sub pages']/preceding-sibling::span","Rollout All");
			//oASelFW.effecta("click","//span[contains(text(),'All')]/preceding-sibling::span","Uncheck all Site");
			oASelFW.effecta("click","//span[contains(text(),'/content/vmware/vmware-published-sites/jp')]/../../../div/label/span","Japan Locale");
			oASelFW.effecta("click","//button[@title='Rollout']","Rollout");
			Thread.sleep(3000);
		}
		
		public void Rollout_Pages() throws Exception
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Rollout page and all sub pages']")));	
			oASelFW.effecta("click","//span[text()='Rollout page and all sub pages']/preceding-sibling::span","Rollout All");
			oASelFW.effecta("click","//button[@title='Rollout']","Rollout");
			Thread.sleep(3000);
		}
		
		public void eventInfo_details() throws Exception
		{
			String name="EventText";
			int random=(int) (Math.random()*10000);
			name=name+random;
			oASelFW.effecta("type","//label[text()='Event Text']/following-sibling::input",name,"Title");
			Thread.sleep(2000);
			
			String date="DateText";
			int random1=(int) (Math.random()*10000);
			date=date+random1;
			oASelFW.effecta("type","//label[text()='Date Text']/following-sibling::input",date,"Java Script Code");
			Thread.sleep(2000);
			
			String event="EventInformation";
			int event1=(int) (Math.random()*10000);
			event=event+event1;
			oASelFW.effecta("type","//label[text()='Event Information']/following-sibling::input",event,"Event Information");
			Thread.sleep(2000);	

			String img="ImageALTText";
			int img1=(int) (Math.random()*10000);
			img=img+img1;
			oASelFW.effecta("type","//label[text()='Mobile logo ALT Text']/following-sibling::input",img,"Image ALT Text");
			Thread.sleep(2000);	
			
			oASelFW.effecta("clickAndWait","//label[text()='Mobile logo Path']/following-sibling::span//span[@class='coral-InputGroup-button']","Image Path");
			Thread.sleep(5000);
			oASelFW.effecta("click","//div[text()='VMworld']","VMworld");
			Thread.sleep(2000);
			oASelFW.effecta("click","//div[text()='en']","Splash Page");
			Thread.sleep(2000);
			oASelFW.effecta("click","//div[text()='US']","US");
			Thread.sleep(3000);
			oASelFW.effecta("click","//div[text()='VMworld_2016']","Path Selected");
			Thread.sleep(2000);
			oASelFW.effecta("clickAndWait","//h2[text()='Select path']/following-sibling::button[@title='Confirm']","Selected Path");
			Thread.sleep(3000);
			oASelFW.effecta("click","//button[@title='Done']","Details Completed");
			Thread.sleep(2000);	
			oASelFW.effecta("sendReport","Sending Event Info component Details","Successfully Validating  The Event Info Componenet Details","Pass");
		}
	
		
		
		
		
}
