package classes.aem;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMMethods {
	ArsinSeleniumAPI oASelFW;
	

	public AEMMethods(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;

	}



	/*=======================================MEGA MENU CONTAINER METHODS===============================================================================*/
	public void drag_drop_megaMenu(int count) throws InterruptedException
	{
		System.out.println("Inside drag_drop_megaMenu");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'MegaMenu Container')]/parent::div/parent::a/parent::article")));
		Actions action = new Actions(oASelFW.driver);
		WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'MegaMenu Container')]/parent::div/parent::a/parent::article"));
		WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		Thread.sleep(3000);
		for(int i=1;i<=count;i++)
		{
			WebElement SourceLocator1=oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'MegaMenu Links')]/parent::div/parent::a/parent::article"));
			WebElement Destinationlocatore2 = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']"));
			action.dragAndDrop(SourceLocator1,Destinationlocatore2).build().perform();
			Thread.sleep(2000);
		}



	}

	public void namesmega_Links(int count) throws InterruptedException
	{
		System.out.println("Inside namesmega_Links");
		Actions action = new Actions(oASelFW.driver);
		/*List<WebElement> list = oASelFW.driver.findElements(By.xpath("//div[@title='Drag components here']/following::div/following-sibling::div"));
		int count = list.size();*/
		//System.out.println("The count is----"+count);
		for(int i=1;i<=count;i++)
		{
			WebElement we = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/following-sibling::div["+i+"]"));
			oASelFW.effecta("click","//div[@title='Drag components here']/following::div/following-sibling::div["+i+"]","Links Name to be clicked ");
			//((JavascriptExecutor)oASelFW.driver).executeScript("arguments[0].click();", we);
			WebElement we2 = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[1]"));
			action.moveToElement(we2).click().build().perform();
			Thread.sleep(4000);
			WebDriverWait wait = new WebDriverWait(oASelFW.driver,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Mega Menu Links and Titles')]")));
			oASelFW.effecta("type","//label[contains(text(),'Title')]/../input","Countries["+i+"]","Mega Links Name");
			oASelFW.effecta("click","//button[@title='Done']","Done button is clicked");
			Thread.sleep(4000);
		}

	}	
	public void namesmega_Links1(String link1) throws InterruptedException
	{
		System.out.println("Inside namesmega_Links");
		/*Actions action = new Actions(oASelFW.driver);
		WebElement we = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']/following::div/following::div"));
		oASelFW.effecta("click","//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']/following::div/following::div","Links Name to be clicked ");
		//((JavascriptExecutor)oASelFW.driver).executeScript("arguments[0].click();", we);
		WebElement we2 = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[1]"));
		action.moveToElement(we2).click().build().perform();*/
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Mega Menu Links and Titles')]")));
		//oASelFW.effecta("click","//button[contains(text(),'Add field')]","Add button is clicked");
		oASelFW.effecta("type","//label[contains(text(),'Title')]/../input",link1,"Mega Links Name");
		//oASelFW.effecta("click","//button[@title='Done']","Done button is clicked");
		Thread.sleep(4000);

	}

	public void namesmega_Links2(String link2) throws InterruptedException
	{
		System.out.println("Inside namesmega_Links2");
		Actions action = new Actions(oASelFW.driver);
		WebElement we = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']/following::div"));
		oASelFW.effecta("click","//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']/following::div","Links Name to be clicked ");
		//((JavascriptExecutor)oASelFW.driver).executeScript("arguments[0].click();", we);
		WebElement we2 = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[1]"));
		action.moveToElement(we2).click().build().perform();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Mega Menu Links and Titles')]")));
		oASelFW.effecta("type","//label[contains(text(),'Title')]/../input",link2,"Mega Links Name");
		oASelFW.effecta("click","//button[@title='Done']","Done button is clicked");
		Thread.sleep(4000);

	}

	public void namemega_Sublinks1(String PageTemplate,String sublink1,String link1) throws InterruptedException
	{
		System.out.println("Inside naming of sublinks1");
		/*Actions action = new Actions(oASelFW.driver);
		oASelFW.effecta("click","//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']/following::div","Links Name to be clicked");
		WebElement we2 = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[1]"));
		action.moveToElement(we2).click().build().perform();*/
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Mega Menu Links and Titles')]")));
		oASelFW.effecta("type","//label[contains(text(),'Title')]/../input",link1,"Mega Links Name");
		Thread.sleep(3000);
		oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		Thread.sleep(3000);
		oASelFW.effecta("type","//label[contains(text(),'URL Label')]/../input",sublink1,"SUbLInk is India");
		Thread.sleep(3000);
		oASelFW.effecta("type","//label[contains(text(),'URL')]/../span/span/input","https://www.google.co.in","Google Link URL is typed");
		Thread.sleep(6000);
		Select dropdown = new Select(oASelFW.driver.findElement(By.xpath("//label[contains(text(),'Select URL Open type')]/../span/button/..//select[@class='coral-Select-select coral-Select-select--native']")));
		dropdown.selectByVisibleText("New Window");
		oASelFW.effecta("sendReport","Selecting New window from dropdown","New Window is selected from DropDown","Pass");
		Thread.sleep(3000);
	}

	public void namemega_Sublinks2(String PageTemplate,String sublink2) throws InterruptedException
	{
		AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
		System.out.println("Inside  namemega_Sublinks2");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		Thread.sleep(3000);
		oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		Thread.sleep(3000);
		oASelFW.effecta("type","//label[contains(text(),'URL Label')]/following::label/../input",sublink2,"Sublink is Australia");
		
		//aemComponentsObj.EnterTextField_Browse("URL","/content/dam/digitalmarketing/vmworld");
		aemComponentsObj.EnterMultiTextField_Browse("URL","/content/dam/digitalmarketing/vmworld",2);
		
		/*oASelFW.effecta("click","//label[contains(text(),'type')]/following::label/../input/following::label/../span/span/span/button","LinkPath img is clicked");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(),'VMworld')])[11]")));
		oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')])[11]","Vmworld is clicked");
		oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')])[10]","VMworld is clicked");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(@class,'is-active')]/following::div[text()='en']")));
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::div[text()='en']","en is clicked");
		Thread.sleep(2000);*/
		
		
		/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']")));
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']",PageTemplate+" is selected");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//nav[contains(@class,'is-active')]/following::div[text()='test123'])[1]")));
		oASelFW.effecta("click","xpath=(//nav[contains(@class,'is-active')]/following::div[text()='test123'])[1]","Verified Site URL is configured at the menu section");
		Thread.sleep(6000);*/
		//oASelFW.effecta("click","xpath=(//h2[contains(text(),'path')]/../button[@title='Confirm'])[2]","Confirm is clicked");
		Thread.sleep(6000);
		//oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
		//oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
		oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
		Thread.sleep(3000);


	}

	public void click_preview() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Preview']")));
		oASelFW.effecta("click","//button[@title='Preview']","Preview button is clicked");
		oASelFW.driver.navigate().refresh();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void get_menulinkscreenShot()
	{
		oASelFW.effecta("captureEntirePageScreenshot","Capturing Menu Link Screen SHot","Menu Link Verified Screen SHot");
	}

	public void verify_menulinks(String value) throws Exception
	{
		Thread.sleep(3000);
		oASelFW.driver.switchTo().frame("ContentFrame");
		System.out.println("Inside verify_menulinks");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,40);	
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li[@class='dropdown']/a")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li[@class='dropdown']/ul/li")));
		//div[@id='navbar']/ul/li[@class='section dropdown'][1]/a
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li/a[contains(text(),'"+value+"')]")));

		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/a"));
		System.out.println("-------"+list.size());

		boolean flag=false;
		for(WebElement text:list)
		{
			String value1=text.getText();
			if(value1.contains(value))
			{

				flag=true;


			}
		}

		if(flag==true)
		{
			oASelFW.effecta("sendReport","Verify Menu Links displayed as expected","Menu Links text is displayed as expected"+value,"Pass");
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Quick Links displayed as expected","Menu Links text is not displayed as expected","Fail");

		}

		oASelFW.driver.switchTo().defaultContent();

	}



	public void VerifyMenuLinks(String value) throws InterruptedException 
	{
		Thread.sleep(3000);
		oASelFW.driver.switchTo().frame("ContentFrame");
		System.out.println("Inside verify_menulinks");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,40);	

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/a")));


		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/a"));
		System.out.println("-------"+list.size());


		for(WebElement text:list)
		{
			String value1=text.getText();
			if(value1.contains(value))
			{
				oASelFW.effecta("sendReport","Verify Menu Links displayed as expected","Menu Links text is displayed as expected"+value,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Menu Links displayed as expected","Menu Links text is not displayed as expected","Fail");
			}

		}
		oASelFW.driver.switchTo().defaultContent();
	}



	public void VerifySubMenuLinks(String value,String menu) throws InterruptedException 
	{
		Thread.sleep(3000);
		oASelFW.driver.switchTo().frame("ContentFrame");
		System.out.println("Inside verify_Submenulinks");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,40);	

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li/a[contains(text(),'"+menu+"')]")));

		WebElement element=oASelFW.driver.findElement(By.xpath("//div[@id='navbar']/ul/li/a[contains(text(),'"+menu+"')]"));
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(10000);

		//ul[contains(@class,'navbar-nav')]/li/ul/li
		//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li"));
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li"));
		//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul/li[2][contains(@class,'section')]/a/../ul/li/a"));
		System.out.println("Sub Menu list size is:"+list.size());
		Thread.sleep(5000);

		for(int i=1;i<=list.size();i++)

		{
			System.out.println("Enter for loop");
			//String value1=oASelFW.effecta("getText","//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li["+i+"]/a");
			//String val=oASelFW.driver.findElement(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li["+i+"]/a")).getText();
			String val=oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li["+i+"]/a")).getText();
			System.out.println("Sub Menu Links---"+val);
			System.out.println("Expected Sub Menu Links---"+value);


			if(val.equals(value))
			{
				oASelFW.effecta("sendReport","Verify Sub Menu Links displayed as expected","Sub Menu Links text is displayed as expected"+value,"Pass");
				
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Verify Sub Menu Links displayed as expected","Sub Menu Links text is not displayed as expected"+value,"Fail");
			}

		}

		oASelFW.driver.switchTo().defaultContent();	

	}
	public void verify_submenulinks(String sub_menu,int i) throws Exception
	{
		Thread.sleep(3000);
		oASelFW.driver.switchTo().frame("ContentFrame");
		System.out.println("Inside verify_Submenulinks");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,40);	

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/a")));

		WebElement element=oASelFW.driver.findElement(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/a"));
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(8000);
		
		
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li"));
		//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul/li[2][contains(@class,'section')]/a/../ul/li/a"));
		System.out.println("Sub Menu list size is:"+list.size());
		Thread.sleep(5000);
		
		
		System.out.println("Enter for loop");
		//String value1=oASelFW.effecta("getText","//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li["+i+"]/a");
		//String val=oASelFW.driver.findElement(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li["+i+"]/a")).getText();
		String val=oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li["+i+"]/a")).getText();
		System.out.println("Sub Menu Links---"+val);
		System.out.println("Expected Sub Menu Links---"+sub_menu);


		if(val.equals(sub_menu))
		{
			oASelFW.effecta("sendReport","Verify Sub Menu Links displayed as expected","Sub Menu Links text is displayed as expected"+sub_menu,"Pass");
			
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Sub Menu Links displayed as expected","Sub Menu Links text is not displayed as expected"+sub_menu,"Fail");
		}
		

		oASelFW.driver.switchTo().defaultContent();	
	}

	
	public void verify_submenulinks_Modified(String menu,String sub_menu,int i) throws Exception
	{
		Thread.sleep(3000);
		oASelFW.driver.switchTo().frame("ContentFrame");
		System.out.println("Inside verify_Submenulinks");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,40);	

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbar']/ul/li/a[contains(text(),'"+menu+"')]")));

		WebElement element=oASelFW.driver.findElement(By.xpath("//div[@id='navbar']/ul/li/a[contains(text(),'"+menu+"')]"));
		Actions action=new Actions(oASelFW.driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(8000);
		
		
		List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li"));
		//List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul/li[2][contains(@class,'section')]/a/../ul/li/a"));
		System.out.println("Sub Menu list size is:"+list.size());
		Thread.sleep(5000);
		
		
		System.out.println("Enter for loop");
		//String value1=oASelFW.effecta("getText","//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li["+i+"]/a");
		//String val=oASelFW.driver.findElement(By.xpath("//div[@id='navbar']/ul/li[@class='section dropdown'][1]/ul/li["+i+"]/a")).getText();
		String val=oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li["+i+"]/a")).getText();
		System.out.println("Sub Menu Links---"+val);
		System.out.println("Expected Sub Menu Links---"+sub_menu);


		if(val.equals(sub_menu))
		{
			oASelFW.effecta("sendReport","Verify Sub Menu Links displayed as expected","Sub Menu Links text is displayed as expected"+sub_menu,"Pass");
			
		}
		else
		{
			oASelFW.effecta("sendReportWithOutExit","Verify Sub Menu Links displayed as expected","Sub Menu Links text is not displayed as expected"+sub_menu,"Fail");
		}
		

		oASelFW.driver.switchTo().defaultContent();	
	}

	
	
	
	public void drag_drop_megaMenu22(int count) throws InterruptedException
	{
		System.out.println("Inside drag_drop_megaMenu");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Megamenu Container')]/parent::div/parent::a/parent::article")));
		Actions action = new Actions(oASelFW.driver);
		WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'Megamenu Container')]/parent::div/parent::a/parent::article"));
		WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		Thread.sleep(3000);
		for(int i=1;i<=count;i++)
		{
			WebElement SourceLocator1=oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'MegaMenu Links')]/parent::div/parent::a/parent::article"));
			WebElement Destinationlocatore2 = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']"));
			action.dragAndDrop(SourceLocator1,Destinationlocatore2).build().perform();
			Thread.sleep(2000);
		}

		List<WebElement> totaldiv=oASelFW.driver.findElements(By.xpath("//div[@title='Drag components here']/following-sibling::div[contains(@class,'cq-draggable')]/div/div"));

		System.out.println("Total div are:" +totaldiv.size());

		for(int j=2;j<=totaldiv.size();j++)
		{

			String element=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following-sibling::div[contains(@class,'cq-draggable')]/div/div["+j+"]")).getAttribute("draggable");
			System.out.println("Attribute value is: " +element);

			if(element.contains("true"))
			{
				WebElement text=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following-sibling::div[contains(@class,'cq-draggable')]/div/div["+j+"]"));
				JavascriptExecutor scritp=(JavascriptExecutor) oASelFW.driver;
				scritp.executeScript("arguments[0].click();",text);

				//text.click();

				WebElement we2 = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[1]"));
				action.moveToElement(we2).click().build().perform();
				Thread.sleep(4000);

				oASelFW.effecta("click","//button[@title='Cancel']","Done button is clicked");
				Thread.sleep(3000);
			}
		}

	}
	public void verifying_External_InternalLink() throws InterruptedException
	{	oASelFW.driver.switchTo().frame("ContentFrame");
	WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li/a")));
	WebElement element=oASelFW.driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
	Actions action=new Actions(oASelFW.driver);
	action.moveToElement(element).build().perform();
	Thread.sleep(3000);
	List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li"));
	int count = list.size();
	System.out.println("list size is:"+list.size());
	for(int i=1;i<=count;i++)
	{
		if(i!=1){

			oASelFW.driver.switchTo().frame("ContentFrame");
			Thread.sleep(2000);
			System.out.println("successfully changed into this frame");
		}

		WebElement element1=oASelFW.driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
		Thread.sleep(2000);
		action.moveToElement(element1).build().perform();
		System.out.println("Mouse over on countries");
		Thread.sleep(2000);
		WebElement list1 = oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li["+i+"]/a"));
		Thread.sleep(2000);
		String listname = list1.getText();
		action.moveToElement(list1).click().build().perform();
		Thread.sleep(5000);




		//String parent_url = oASelFW.driver.getCurrentUrl();
		String parent_window = oASelFW.driver.getWindowHandle();
		System.out.println("The parent window is "+parent_window);
		ArrayList<String> tabs = new ArrayList<String> (oASelFW.driver.getWindowHandles());
		for(String winhandle:tabs)
			oASelFW.driver.switchTo().window(winhandle);
		String current_window = oASelFW.driver.getWindowHandle();
		System.out.println(parent_window+"-----------------------"+current_window);
		String current_url = oASelFW.driver.getCurrentUrl();

		ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());

		System.out.println("Window Size:" +tab.size());
		//oASelFW.driver.switchTo().window(tab.get(2));



		if(tab.get(1)!=tab.get(2))
		{
			oASelFW.effecta("sendReport","Verifying External link is accepting at the sub menu section",listname+"Verified it is accepting External link as"+current_url,"Pass");
			oASelFW.driver.close();
			//Thread.sleep(3000);				//oASelFW.driver.switchTo().window(tabs.get(0));
			Thread.sleep(5000);
			oASelFW.driver.switchTo().window(tab.get(1));
			Thread.sleep(3000);
			/*System.out.println("Insdide");
				//System.out.println("It is an external link "+list1.getText());
				oASelFW.effecta("sendReport","Verifying External link is accepting at the sub menu section","Verified it is accepting External link as"+current_url,"Pass");
				oASelFW.driver.close();
				Thread.sleep(3000);
				oASelFW.driver.switchTo().window(parent_window);
				Thread.sleep(6000);*/
		}
		else
		{
			//System.out.println("It is an external link "+list1.getText());
			oASelFW.effecta("sendReport","Verifying Internal link is accepting at the sub menu section",listname+"Verified it is accepting Internal link as"+current_url,"Pass");

		}


		/*Thread.sleep(3000);
			oASelFW.driver.switchTo().frame("ContentFrame");
		 */
	}

	oASelFW.driver.switchTo().defaultContent();

	}

	/*==================================================================================================================================*/

	public void verifyingExternal_InternalLink() throws InterruptedException
	{	
	oASelFW.driver.switchTo().frame("ContentFrame");
	WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/li/a")));
	WebElement element=oASelFW.driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
	Actions action=new Actions(oASelFW.driver);
	action.moveToElement(element).build().perform();
	Thread.sleep(3000);
	List<WebElement> list=oASelFW.driver.findElements(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li"));
	int count = list.size();
	System.out.println("list size is:"+list.size());
	for(int i=1;i<=count;i++)
	{
		WebElement element1=oASelFW.driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a"));

		action.moveToElement(element1).build().perform();
		Thread.sleep(3000);

		WebElement list1 = oASelFW.driver.findElement(By.xpath("//ul[contains(@class,'navbar-nav')]/li/ul/li["+i+"]/a"));
		Thread.sleep(2000);
		String listname = list1.getText();
		System.out.println("Sub Menu List Name----"+listname);

		action.moveToElement(list1).click().build().perform();
		Thread.sleep(5000);

		ArrayList<String> tab = new ArrayList<String> (oASelFW.driver.getWindowHandles());

		System.out.println("Window Size:" +tab.size());
		//oASelFW.driver.switchTo().window(tab.get(2));	

		if(tab.size()==3)
		{
			oASelFW.effecta("sendReport","Verifying External link is accepting at the sub menu section",listname+" Verified it is accepting External link","Pass");

			oASelFW.driver.close();
			
			ArrayList<String> tab1 = new ArrayList<String> (oASelFW.driver.getWindowHandles());

			System.out.println("Window Size:" +tab1.size());
			oASelFW.driver.switchTo().window(tab1.get(1));
			Thread.sleep(3000);
		}
		else
		{
			oASelFW.effecta("sendReport","Verifying Internal link is accepting at the sub menu section",listname+" Verified it is accepting Internal link","Pass");

			// oASelFW.driver.navigate().back();
			// Thread.sleep(3000);

		}

	}



	oASelFW.driver.switchTo().defaultContent();

	}





	/*====================================VMWARE LOGO METHODS	=============================================================*/
	public void configure_vmwarelogo() throws InterruptedException 
	{
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[@title='Drag components here']/following::div","VM-Ware logo configured at the Menu Section");
		Actions action = new Actions(oASelFW.driver);
		WebElement we2 = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[1]"));
		action.moveToElement(we2).click().build().perform();    

	}

	public void vmware_siteurl(String title,String Page) throws InterruptedException
	{
		AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
		Thread.sleep(6000);
		oASelFW.effecta("click","//h2[contains(text(),'Mega Menu')]/following::div/following::div/div/div/span/span/span/button","Path button is clicked");
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'VMworld')]","Vmworld is clicked");
		Thread.sleep(6000);
		
		/*oASelFW.effecta("click","//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]","Splash is clicked");
		Thread.sleep(6000);
		oASelFW.effecta("click","//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]/following::nav/div/a/div/../div[contains(text(),'"+PageTemplate+"')]",PageTemplate+" is selected");
		Thread.sleep(7000);
		oASelFW.effecta("click","//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]/following::nav/div/a/div/../div[contains(text(),'"+PageTemplate+"')]/following::nav/div/a[2]/div/following::div[contains(text(),'test123')]","Verified Site URL is configured at the menu section");
		Thread.sleep(6000);
		*/
		oASelFW.effecta("click","//h2[contains(text(),'path')]/../button[@title='Confirm']","Confirm is clicked");
		Thread.sleep(6000);
		
		
		/*aemComponentsObj.EnterTextField_Browse(title,Page);
		Thread.sleep(3000);*/
		
		oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
		Thread.sleep(6000);
	}


	public void click_vmwaresite_url() throws InterruptedException
	{
		oASelFW.driver.switchTo().frame("ContentFrame");
		oASelFW.effecta("click","//ul[@class='nav navbar-nav']/../a","Site URL is clicked associated to Vmware logo");
		Thread.sleep(4000);
		String url = oASelFW.driver.getCurrentUrl();
		oASelFW.effecta("sendReport","Author is able to configure site url","The URL comes after clicking"+url,"Pass");
		oASelFW.driver.switchTo().defaultContent();
	}

	/*public void verify_submenulinks(i,String link1,String link2,String parent_window) throws InterruptedException
	{
		oASelFW.effecta(")

		Thread.sleep(6000);
		oASelFW.driver.close();
		oASelFW.driver.switchTo().window(parent_window);
		Thread.sleep(6000);


	}*/


	/*=============================================HOL FEED RENDER COMPONENTS METHODS==============================================================*/


	public void click_HOL() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Preview']/following::div/following::div/following::div[@id='ContentScrollView']/div[2]/div[2]/div[2]")));

		oASelFW.effecta("click","//button[@title='Preview']/following::div/following::div/following::div[@id='ContentScrollView']/div[2]/div[2]/div[2]","HOL Feed Render COmponent is clicked");
		Thread.sleep(3000);
	}

	public void click_Verify_HOL_Feed_Render_Component() throws InterruptedException
	{

		WebElement we = oASelFW.driver.findElement(By.xpath("//div[@id='EditableToolbar']/button[@title='Copy']"));

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[@id='EditableToolbar']/button[@title='Copy']")))
		{
			System.out.println("Configure Element is not Present");
			oASelFW.effecta("sendReport","Verifying user access","Configure element is not present author cannot configure the page","Pass");
		}
		else
		{
			System.out.println("Configure Element is Present");
			oASelFW.effecta("sendReport","Verifying user access to author","Configure element is present author can configure the page","Fail");
		}

	}
	/*===============================================================================================================================================*/

	/*=================================================FOOTER LINKS METHOD===========================================================================*/
	public void click_onFooterFooterLink() throws InterruptedException
	{
		Thread.sleep(4000);
		oASelFW.effecta("click","//div[@id='ContentScrollView']/div[2]/div[2]/div[2]/div[2]","FatFooterLInk is clicked");

	}

	public String add_title()
	{

		String title ="Copyrights. © 2006–2007 VMware, Inc.";
		WebDriverWait  wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Title')]/../input")));
		oASelFW.effecta("type","//label[contains(text(),'Title')]/../input",title,"Copy Right Date is added to the Link");
		oASelFW.effecta("click","//button[@title='Done']","Done button is clicked");
		return title;
	}

	public void verify_yearchnge(String text1) throws InterruptedException
	{
		System.out.println("enter into verify_yearchnge");
		oASelFW.driver.switchTo().frame("ContentFrame");
		Thread.sleep(3000);
		String value=oASelFW.driver.getPageSource();
		System.out.println(value);
		/*oASelFW.effecta("verifyElementPresent","xpath=(//div[contains(@class,'footerMenu')]/div[3]/div/h4)[0]","The year has been changed in preview mode");
		//String text2= oASelFW.effecta("getText","//div[@class='footerMenu pd-main']/div[4]/h4");
		String text2= oASelFW.driver.findElement(By.xpath("xpath=(//div[contains(@class,'footerMenu')]/div[3]/div/h4)[0]")).getText();*/
		if(value.contains(text1))
		{
			System.out.println("Enter into correct condition");
			oASelFW.effecta("sendReport","Verifying date has been changed in preview mode",text1+"Date has been changed as the date type by author and displayed date are equal"+text1,"Pass");

		}
		else
		{
			System.out.println("Dates are not equal displayed");
		}

		oASelFW.driver.switchTo().defaultContent();

	}


	/*===============================================================================================================================================*/


	/*=========================================PRICING HEADER COMPONENTS ============================================================================*/

	public void enter_PricingDetails(String PageTemplate,String Page) throws Exception
	{
		AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
		System.out.println("Enter into enter_PricingDetails");
		Thread.sleep(3000);
		String type_pass="Typeofpass";
		int random=(int) (Math.random()*10000);
		type_pass=type_pass+random;
		oASelFW.effecta("type","//label[contains(text(),'Type of Pass')]/../input",type_pass,"Typeofpass");
		Thread.sleep(3000);

		WebElement element = oASelFW.driver.findElement(By.xpath("//button[contains(text(),'Add field')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		//oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		Thread.sleep(3000);

		String packagetype="PackageType";
		int t=(int) (Math.random()*10000);
		packagetype=packagetype+t;
		oASelFW.effecta("type","//label[contains(text(),'Package Type')]/../input",packagetype,"PackageType");
		Thread.sleep(3000);

		String tooltip="TooltipText";
		int rand=(int) (Math.random()*10000);
		tooltip=tooltip+rand;
		oASelFW.effecta("type","//label[contains(text(),'Tooltip Text')]/../textarea",tooltip,"TooltipText");
		Thread.sleep(3000);

		String birdprice = "EarlyBirdPrice";
		int rand1=(int) (Math.random()*10000);
		birdprice=birdprice+rand1;
		oASelFW.effecta("type","//label[contains(text(),'Early Bird Price')]/../input",birdprice,"Event Date");

		Thread.sleep(4000);


		/*oASelFW.effecta("click","//label[contains(text(),'URL')]/../span/span/span/button","Path button is clicked");

		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='VMworld'])")));
		oASelFW.effecta("click","xpath=(//nav[contains(@class,'is-active')]/following::div[text()='VMworld'])","VMworld is clicked");

		Thread.sleep(6000);
		
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::div[text()='Splash Page']","Splash is clicked");
		Thread.sleep(6000);
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']",PageTemplate+" is selected");
		Thread.sleep(6000);
		oASelFW.effecta("click","xpath=(//nav[contains(@class,'is-active')]/following::div[text()='"+Page+"'])[1]","Verified Site URL is configured at the menu section");
		Thread.sleep(6000);
		oASelFW.effecta("click","xpath=(//h2[contains(text(),'path')]/../button[@title='Confirm'])[2]","Confirm is clicked");
*/

		aemComponentsObj.EnterTextField_Browse("Pricing page URL","/content/dam/digitalmarketing/vmworld");
		
		
		Thread.sleep(3000);

		String regularprice = "regularPrice";
		int rand11=(int) (Math.random()*10000);
		regularprice=regularprice+rand11;
		oASelFW.effecta("type","//label[contains(text(),'Regular Price')]/../input",regularprice,"Event Date");

		Thread.sleep(3000);
		String price = "Price";
		int rand10=(int) (Math.random()*10000);
		price=price+rand10;
		oASelFW.effecta("type","//label[contains(text(),'Regular Price')]/parent::div/following::div/label/../input",price,"Price");


		Thread.sleep(3000);
		oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");



	}

	public void verify_pricingdetails() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ContentFrame']")));
		String PackageType = oASelFW.effecta("getText","//div[contains(@class,'pricingdetails section')]/div[@class='dataRow']/div/div[1]");
		System.out.println(PackageType);
		oASelFW.effecta("verifyElementPresent","//div[contains(@class,'pricingdetails section')]/div[@class='dataRow']/div/div[1]",PackageType+"is present as a PackageType");
		Thread.sleep(2000);

		String pricing_type=oASelFW.effecta("getText","//div[contains(@class,'pricingdetails section')]/div[@class='dataRow whiteHead']/div/div[1]");
		System.out.println(pricing_type);
		oASelFW.effecta("verifyElementPresent","//div[contains(@class,'pricingdetails section')]/div[@class='dataRow whiteHead']/div/div[1]",pricing_type+"is present");
		Thread.sleep(2000);

		String tooltip=oASelFW.effecta("getText","//div[contains(@class,'pricingdetails section')]/div[@class='dataRow']/div/div[1]/a");
	    System.out.println(tooltip);
		oASelFW.effecta("verifyElementPresent","//div[contains(@class,'pricingdetails section')]/div[@class='dataRow']/div/div[1]",tooltip+"is present");

		Thread.sleep(2000);
		oASelFW.effecta("click","//div[@class='pricingdetails section']/div[2]/div/div[3]/div/a","Page URL is clicked");

		Thread.sleep(2000);
		String url = oASelFW.driver.getCurrentUrl();
		oASelFW.effecta("sendReport","Verifying pricing page URL","Verified Pricing Page URL"+url,"Pass");

		Thread.sleep(4000);
		oASelFW.driver.switchTo().defaultContent();
	}





	public void click_DragComponent_insidePriceHeader() throws InterruptedException
	{
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here' and contains(@data-path,'pricingheader')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'pricingheader')]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'pricingheader')]"))).doubleClick().build().perform();
		Thread.sleep(10000);
	}

	public void verify_link()
	{
		oASelFW.effecta("verifyElementPresent","//a[contains(text(),'link')]","Link is verified");

	}
	public void enter_PricingHeader(String PageTemplate,String Page) throws Exception
	{
		
		AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
		System.out.println("Enter into PricingHeader");
		Thread.sleep(3000);

		String enter_Componentheader="Enter The Component Header";
		int random=(int) (Math.random()*10000);
		enter_Componentheader=enter_Componentheader+random;
		oASelFW.effecta("type","//label[contains(text(),'Enter The Component Header')]/../input",enter_Componentheader,"Component Header");
		Thread.sleep(3000);


		String enter_header="Enter The Header";
		int random1=(int) (Math.random()*10000);
		enter_header=enter_header+random1;
		oASelFW.effecta("type","//label[contains(text(),'Enter The Header')]/../input",enter_header,"Header");
		Thread.sleep(3000);

		String earlybird="EarlyBird";
		int t=(int) (Math.random()*10000);
		earlybird=earlybird+t;
		oASelFW.effecta("type","//label[contains(text(),'Earlybird')]/../input",earlybird,"EarlyBird");
		Thread.sleep(3000);

		String daterange="DateRange";
		int rand=(int) (Math.random()*10000);
		daterange=daterange+rand;
		oASelFW.effecta("type","//label[contains(text(),'Date Range')]/../input",daterange,"DateRange");
		Thread.sleep(3000);

		/*oASelFW.effecta("click","//label[contains(text(),'URL')]/../span/span/span/button","Path button is clicked");
		Thread.sleep(4000);
		 fill_details_PricingHeader(PageTemplate,Page);
		*/
		aemComponentsObj.EnterTextField_Browse("URL","/content/dam/digitalmarketing/vmworld");
		
       

		String expandtext="ExpandText";
		int rand11=(int) (Math.random()*10000);
		expandtext=expandtext+rand11;
		oASelFW.effecta("type","//label[contains(text(),'Expand Text')]/../input",expandtext,"ExpandText");
		Thread.sleep(3000);

		String collapsetext="CollapseText";
		int rand12=(int) (Math.random()*10000);
		collapsetext=collapsetext+rand12;
		oASelFW.effecta("type","//label[contains(text(),'Collapse Text')]/../input",collapsetext,"CollapseText");

		Thread.sleep(3000);
		oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
		Thread.sleep(3000);


	}
	
	public void fill_details_PricingHeader(String PageTemplate,String Page) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//nav[@class='coral-ColumnView-column'])[1]/div/a/div[contains(text(),'VMworld')]")));
		oASelFW.effecta("click","xpath=(//nav[@class='coral-ColumnView-column'])[1]/div/a/div[contains(text(),'VMworld')]","Vmworld is clicked");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]")));
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::div[text()='Splash Page']","Splash is clicked");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]/following::nav/div/a/div/../div[contains(text(),'"+PageTemplate+"')]")));
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']",PageTemplate+" is selected");
		Thread.sleep(8000);
		//oASelFW.effecta("click","//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')]/following::nav/div/a/div/../div[contains(text(),'"+PageTemplate+"')]/following::nav/div/a[2]/div/following::div[contains(text(),'"+Page+"')]","Verified Site URL is configured at the menu section");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//nav[contains(@class,'is-active')]/following::a[@title='"+Page+"'])[1]")));
		oASelFW.effecta("click","xpath=(//nav[contains(@class,'is-active')]/following::a[@title='"+Page+"'])[1]","testeurope is clicked");
		Thread.sleep(6000);

		oASelFW.effecta("click","//h2[contains(text(),'path')]/../button[@title='Confirm']","Confirm is clicked");
		Thread.sleep(3000);
		
		
		
	}


	/*==================================================================================================================================================*/

	/*====================================================COMMON METHODS===============================================================================*/
	public void drag_drop(String element) throws InterruptedException
	{
		System.out.println("Inside drag_drop_megaMenu");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'"+element+"')]/parent::div/parent::a/parent::article")));
		Actions action = new Actions(oASelFW.driver);
		WebElement Sourcelocator = oASelFW.driver.findElement(By.xpath("//h4[contains(text(),'"+element+"')]/parent::div/parent::a/parent::article"));
		WebElement Destinationlocator=oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		Thread.sleep(3000);
	}

	public void single_click_Component(String component) throws InterruptedException
	{
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-text,'"+component+"')]")));
		Thread.sleep(3000);
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-text,'"+component+"')]"));

		action.moveToElement(element).click().build().perform();
	}

	public void click_onTool(String tool) throws InterruptedException
	{
		Thread.sleep(3000);
		Actions action = new Actions(oASelFW.driver);
		WebElement button = oASelFW.driver.findElement(By.xpath("//button[@title='"+tool+"']"));
		action.moveToElement(button).click().build().perform();
		Thread.sleep(3000);


	}

	public String switch_window_aftOpenPge1(String pageno) throws InterruptedException
	{
		Thread.sleep(6000);

		String parent_window=null;

		String[] wind=oASelFW.effectaArray("getAllWindowNames");
		System.out.println(wind.length);

		oASelFW.effecta("selectWindow",wind[1]);	
		Thread.sleep(5000);

		oASelFW.effecta("waitForPageToLoad");

		if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","xpath=(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]")))
		{
			oASelFW.effecta("selectWindow",wind[1]);
		}

		else
		{
			oASelFW.effecta("selectWindow",wind[1]);
		}


		return parent_window;
	}

	public void click_Edit_SidePannel_Components() throws InterruptedException
	{
		System.out.println("Inside click_Edit_SidePannel_Components");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]")));
		Thread.sleep(3000);
		oASelFW.effecta("click","xpath=(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]","Edit button is clicked");
		Thread.sleep(3000);
		oASelFW.effecta("click","//div[@class='editor-GlobalBar-leftContainer']/button","Toggle side panel is Clicked");
		oASelFW.effecta("click","//a[contains(text(),'Components')]","Clicked on components");
		Thread.sleep(3000);

	}

	public void click_toggleButton() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='editor-GlobalBar-leftContainer']/button")));
		oASelFW.effecta("click","//div[@class='editor-GlobalBar-leftContainer']/button","Toggle side panel is Clicked");
	}
	public void click_Edit() throws InterruptedException
	{
		System.out.println("Inside Edit");
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]")));
		Thread.sleep(3000);
		oASelFW.effecta("click","xpath=(//div[@class='editor-GlobalBar-rightContainer']/div/div/following::button)[1]","Edit button is clicked");
	}

	/*=============================================================================PRICE HEADER FOR EUROPE====================================*/

	public void single_click_PriceHeader_Europe(String component) throws InterruptedException
	{

		Actions action = new Actions(oASelFW.driver);

		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@data-type='Editable' and contains(@data-path,'"+component+"')]"));
		//WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here' and contains(@data-path,'par')]/following::div[3]"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		//action.moveToElement(element).click().build().perform();
	}


	public void click_SelectPath(String PageTemplate,String Page) 
	{
		try
		{
			oASelFW.effecta("click","//label[contains(text(),'URL')]/../span/span/span/button","Path button is clicked");
			Thread.sleep(4000);
			WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='VMworld'])")));
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='VMworld'])[3]")));
			//oASelFW.effecta("click","xpath=(//a[@title='VMworld'])[3]","VMworld is clicked");
			oASelFW.effecta("click","xpath=(//a[@title='VMworld'])","VMworld is clicked");
			Thread.sleep(6000);
			//oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')])","Splash is clicked");
			//oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')])[2]","Splash is clicked");
			oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::div[text()='Splash Page']","Splash is clicked");
			Thread.sleep(6000);
			oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']",PageTemplate+" is selected");
			Thread.sleep(6000);
			oASelFW.effecta("click","xpath=(//nav[contains(@class,'is-active')]/following::div[text()='"+Page+"'])[1]","Verified Site URL is configured at the menu section");
			Thread.sleep(6000);
			oASelFW.effecta("click","xpath=(//h2[contains(text(),'path')]/../button[@title='Confirm'])[2]","Confirm is clicked");

			if(Boolean.parseBoolean(oASelFW.effecta("verifyElementPresent","//label[contains(text(),'Expand Text')]/../input")))
			{
				String expandtext="ExpandText";
				int rand11=(int) (Math.random()*10000);
				expandtext=expandtext+rand11;
				oASelFW.effecta("type","//label[contains(text(),'Expand Text')]/../input",expandtext,"ExpandText");
				Thread.sleep(3000);

				if(Boolean.parseBoolean(oASelFW.effecta("verifyElementPresent","//label[contains(text(),'Expand Text')]/../input")))
				{
					String collapsetext="CollapseText";
					int rand12=(int) (Math.random()*10000);
					collapsetext=collapsetext+rand12;
					oASelFW.effecta("type","//label[contains(text(),'Collapse Text')]/../input",collapsetext,"CollapseText");
				}
				else
				{
					Thread.sleep(3000);
					oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
				}
			}

			else
			{
				Thread.sleep(3000);
				oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	//=====================================================HERO BANNER======================================================================================//

	public void insert_Images_HeroBannerComponents() throws InterruptedException
	{
		AEMComponentCreation aemComponentsObj   = new AEMComponentCreation(oASelFW);
		Thread.sleep(5000);
		aemComponentsObj.ClickToggleSidePanel();
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Hero Banner')]/following::nav/a[contains(text(),'Hero Carousel Images')]")));
		//	WebElement we = oASelFW.driver.findElement(By.xpath("//h2[contains(text(),'Hero Banner')]/following::nav/a[contains(text(),'Hero Carousel Images')]"));
		//Actions action = new Actions(oASelFW.driver);
		//action.moveToElement(we).click().build().perform();
		Thread.sleep(2000);
		oASelFW.effecta("click","//a[text()='Hero Carousel Images']","Hero Carousel Images Tab");
		Thread.sleep(3000);
		
		
		oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		Thread.sleep(4000);
		
		
		aemComponentsObj.clickOnTabPanelLinks("Assets");
		Thread.sleep(5000);
		
		aemComponentsObj.enterTextInput("card-banner.jpg", "Assets");
		Thread.sleep(5000);
		
		aemComponentsObj.dragAndDropComponents("", "Assets","Image Path");
		

		//Drage and drop Image to Image Asset
		//aemComponentsObj.dragAndDrop_Image_To_RequiredImageAsset("slideHero-1.jpg");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("xpath=(//label[contains(text(),'Image')]/following::span/span/input)[1]")));
		/*WebElement we1 = oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Image')]/following::span/span/input)[1]"));
		we1.sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
		Thread.sleep(6000);*/
		//oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Image')]/following::span/span/input)[1]")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Clear')])[2]")));

		/*	oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		WebElement we3 = oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Image')]/following::span/span/input)[3]"));
		we3.sendKeys("C:/Users/Public/Pictures/Sample Pictures/Jellyfish.jpg");
		Thread.sleep(6000);*/

		/*oASelFW.effecta("click","//button[contains(text(),'Add field')]","AddField Button is clicked");
		Thread.sleep(4000);

		//Drage and drop Image to Image Asset
		aemComponentsObj.dragAndDrop_Image_To_RequiredImageAsset("slideHero-1.jpg");
		Thread.sleep(5000);
*/
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[contains(text(),'Image')]/following::span/span/input)[3]")));
		//oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Image')]/following::span/span/input)[1]")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Jellyfish");
		//oASelFW.effecta("type","//label[contains(text(),'Video ID')]/following::label/following::span/span/input","banner-hero-network-02.jpg","Image selected");	
	}

	public void single_click_Html() throws InterruptedException {
		Thread.sleep(3000);

		//oASelFW.effecta("click","xpath=(//div[@title='Drag components here']/../div)[2])","HtmlComponent Clicked");
		WebElement we = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/../div[2]"));
		((JavascriptExecutor)oASelFW.driver).executeScript("arguments[0].click();", we);

	}

	public void double_click_MegaLinks() throws InterruptedException
	{
		System.out.println("Entered into double_click_MegaLinks");
		Thread.sleep(5000);
		Actions action = new Actions(oASelFW.driver);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']")));
		WebElement element = oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']"));
		((JavascriptExecutor) oASelFW.driver).executeScript("arguments[0].click();", element);
		action.moveToElement(oASelFW.driver.findElement(By.xpath("//div[@title='Drag components here']/following::div/div/div[@title='Drag components here']"))).doubleClick().build().perform();
		Thread.sleep(10000);
	}

	public void fillmega(String title,String Page) throws InterruptedException
	{
		Thread.sleep(4000);
		AEMComponentCreation aemComponentsObj= new AEMComponentCreation(oASelFW);
		aemComponentsObj.EnterTextField_Browse(title,Page);
		//oASelFW.effecta("click","//label[contains(text(),'URL')]/../span/span/span/button","Path button is clicked");
		//Thread.sleep(4000);
		/*WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='VMworld'])")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='VMworld'])[3]")));
		//oASelFW.effecta("click","xpath=(//a[@title='VMworld'])[3]","VMworld is clicked");
		oASelFW.effecta("click","xpath=(//a[@title='VMworld'])","VMworld is clicked");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(@class,'is-active')]/following::div[text()='Splash Page']")));
		//oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')])","Splash is clicked");
		//oASelFW.effecta("click","xpath=(//div[contains(text(),'VMworld')]/following::nav/div/a/div/../div[contains(text(),'Splash Page')])[2]","Splash is clicked");
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::div[text()='Splash Page']","Splash is clicked");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']")));
		oASelFW.effecta("click","//nav[contains(@class,'is-active')]/following::a[@title='"+PageTemplate+"']",PageTemplate+" is selected");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//nav[contains(@class,'is-active')]/following::div[text()='"+Page+"'])[1]")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[contains(@class,'is-active')]/following::div[text()='"+Page+"'])[1]")));
		oASelFW.effecta("click","xpath=(//nav[contains(@class,'is-active')]/following::div[text()='"+Page+"'])[1]","Verified Site URL is configured at the menu section");
		Thread.sleep(2000);
		
		oASelFW.effecta("click","xpath=(//h2[contains(text(),'path')]/../button[@title='Confirm'])","Confirm is clicked");
		Thread.sleep(2000);*/
		
		oASelFW.effecta("click","//button[@title='Done']","TICK is clicked");
		
	}


	public void Check_InsertNewComponent() throws Exception
	{
		AEMComponentCreation aem = new AEMComponentCreation(oASelFW);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div[2]/ul")));
		Thread.sleep(5000);
		System.out.println("after wait");

		for(int i=0;i<=5;i++)
		{

			List<WebElement> list=oASelFW.driver.findElements(By.xpath("//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div[2]/ul/li"));
			int count = list.size();
			System.out.println("list size is:"+list.size());
			if(list.size()>=1)
			{

				System.out.println("The component is present");
				break;	

			}

			else
			{
				oASelFW.effecta("click","//h2[text()='Insert New Component']/ancestor::div[contains(@style,'display: block')]/div/button","Close Clicked");
				Thread.sleep(3000);
				aem.ClickDragComponents();
			}

		}
	}
	
	
}



