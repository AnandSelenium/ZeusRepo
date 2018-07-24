package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class AEMTaggingPage {
	ArsinSeleniumAPI oASelFW;

	public AEMTaggingPage(){

	}
	public AEMTaggingPage(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	/**
	 * @author divanshu_sharma
	 * @param link
	 * @throws InterruptedException
	 */

	public void click_namespace(String namespace) throws Exception
	{ 
		System.out.println("entered into click_namespace method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+namespace+"']")));
		Actions act=new Actions(oASelFW.driver);
		act.click(oASelFW.driver.findElement(By.xpath("//div[text()='"+namespace+"']"))).perform();
		System.out.println("completed click_namespace method");
	}
	public void click_operations(String operation)
	{
		System.out.println("entered into click_operations method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='"+operation+"']")));
		oASelFW.effecta("clickAndWait","//button[@title='"+operation+"']","click");
		System.out.println("completed click_operations method"+operation);
	}
		
		public String enter_tagDetails(String header ,String id)
		{
			System.out.println("entered into enter_tagDetails method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Add Tag']")));
			String constName="Tech_Papers";
			int random=(int) (Math.random()*1000);
			String name=constName +random;
			oASelFW.effecta("type","//label[text()='"+header+"']/following-sibling::input[@id='"+id+"']",name,"Title"+name);
			System.out.println("completed enter_tagDetails method");
			return name;
		}
		
		public void click_Create() throws InterruptedException
		{
			System.out.println("entered into click_Create method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Add Tag']")));
			oASelFW.effecta("clickAndWait","//button[@id='createtag-submit']","Create");
			System.out.println("completed click_Create method");
			Thread.sleep(5000);
		}
		
		public void verifyTagCreated(String tagCreated)
		{
			System.out.println("entered into verifyTagCreated method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'"+tagCreated+"')]")));
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@title,'"+tagCreated+"')]")))
			{
			oASelFW.effecta("sendReport","Checking Whether Tag Is Created:-"+tagCreated,"Successfully created the tag:-"+tagCreated,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Checking Whether Tag Is Created:-"+tagCreated,"Failed To Create the tag","Fail");
			}
			System.out.println("completed verifyTagCreated method");
		}
		
		public String edit_tagDetails(String header ,String id)
		{
			System.out.println("entered into edit_tagDetails method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Edit Tag']")));
			String constName="Edited_Tech_Papers";
			int random=(int) (Math.random()*1000);
			String name=constName +random;
			oASelFW.effecta("type","//label[text()='"+header+"']/following-sibling::input[@id='"+id+"']",name,"Title"+name);	
			System.out.println("completed edit_tagDetails method");
			return name;
		}
		
		public void click_Save()
		{
			System.out.println("entered into click_Save method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Edit Tag']")));
			oASelFW.effecta("click","//button[text()='Save']","Clicked Save");
			System.out.println("completed click_Save method");
		}
		
		public void click_OK()
		{
			System.out.println("entered into click_OK method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Success']")));
			oASelFW.effecta("click","//button[text()='OK']","Clicked Save");
			System.out.println("completed click_OK method");	
		}
		
		public void delete_Tag(String tagCreated) throws Exception
		{
			System.out.println("entered into delete_Tag method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Delete Tag']")));
			oASelFW.effecta("clickAndWait","//p[contains(text(),'"+tagCreated+"')]/following::button[contains(text(),'Delete')]","Delete");
			System.out.println("completed delete_Tag method");	
		}
		
		
		public void delete_Tag1(String tagCreated) throws Exception
		{
			System.out.println("entered into delete_Tag method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Delete Tag']")));
			oASelFW.effecta("click","//div[text()='"+tagCreated+"']","clicking "+tagCreated);	
			oASelFW.effecta("click","//a[@title='Delete Tag']","Delete Tag");
			Thread.sleep(2000);
			oASelFW.effecta("click","//button[text()='Delete']","Tag Deleted");
			System.out.println("completed delete_Tag method");	
		}
		
		public void verifydeletedTag(String tagCreated)
		{
			System.out.println("entered into verifydeletedTag method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Create Tag']")));
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[text()='"+tagCreated+"']")))
			{
			oASelFW.effecta("sendReport","Checking Whether Tag Is deleted:-"+tagCreated,"Failed to Delete the tag:-"+tagCreated,"Fail");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Checking Whether Tag Is deleted:-"+tagCreated,"Successfully Deleted the tag:","Pass");
			}
			System.out.println("completed verifydeletedTag method");
		}
		
		
		
		/**-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 * @author avinash_ankireddy
		 * @param link
		 * @throws InterruptedException
		 */
		
		public void clickOnMenuItemsLinks(String link) throws InterruptedException
		{
		
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'"+link+"')]")));
			oASelFW.effecta("click","//a[contains(@title,'"+link+"')]","Clicking on "+ link);
			Thread.sleep(5000);
		}
		
		
		public void clickOnMenuItemsButtons(String button) throws InterruptedException
		{
		
			
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title,'"+button+"')]")));
			oASelFW.effecta("click","//button[contains(@title,'"+button+"')]","Clicking on "+ button);
			Thread.sleep(5000);
		}
		
		
		public void clickOnTag(String tagname) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@title,'"+tagname+"')]")));
			oASelFW.effecta("click","//div[contains(@title,'"+tagname+"')]","Clicking on "+ tagname);
			Thread.sleep(5000);
		}
	
		public String edit_tagDetails(String header ,String id,String tagname)
		{
			System.out.println("entered into edit_tagDetails method");
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Edit Tag']")));
			String constName="Edited_";
			String name=constName +tagname;
			oASelFW.effecta("type","//label[text()='"+header+"']/following-sibling::input[@id='"+id+"']",name,"Title"+name);	
			System.out.println("completed edit_tagDetails method");
			return name;
		}
		
		public void verifyEditedTag(String tagname)
		{
			WebDriverWait wait=new WebDriverWait(oASelFW.driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@title,'Edited_"+tagname+"')]")));
			if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//div[contains(@title,'Edited_"+tagname+"')]")))
			{
			oASelFW.effecta("sendReport","Checking Whether Tag Is Created:-Edited_"+tagname,"Successfully created the tag:-"+tagname,"Pass");
			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Checking Whether Tag Is Created:-"+tagname,"Failed To Create the tag","Fail");
			}
			System.out.println("completed verifyTagCreated method");
		}

		
	
	

}
