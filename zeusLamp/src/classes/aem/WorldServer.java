package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

public class WorldServer {
	ArsinSeleniumAPI oASelFW;

	public WorldServer(){

	}
	public WorldServer(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	public void login_world(String username, String password )
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Username']/following-sibling::input")));
		oASelFW.effecta("type","//label[text()='Username']/following-sibling::input",username,"Username");
		oASelFW.effecta("typePassword","//label[text()='Password']/following-sibling::input",password,"Password");
		oASelFW.effecta("click","//button[text()='Login']","login");
		
	}
	public void clickProject(String prjName ) throws Exception
	{
		System.out.println("entered into clickProject method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'projects')]")));
		oASelFW.effecta("clickAndWait","//a[contains(text(),'projects')]","Projects");
		Thread.sleep(30000);
		oASelFW.driver.navigate().refresh();
		Thread.sleep(5000);
		oASelFW.effecta("click","//a[contains(text(),'"+prjName+"')]",prjName);
		Thread.sleep(30000);
	}
	
	public void translate(String pgeName) throws Exception
	{
		System.out.println("Entered into translate method");
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Edit/Translate...')]")));
		Thread.sleep(10000);
		oASelFW.driver.navigate().refresh();
		Thread.sleep(10000);
		oASelFW.effecta("click","//a[contains(text(),'"+pgeName+"')]/../../td[1]/input","Selected Page:"+pgeName);
		Thread.sleep(3000);
		oASelFW.effecta("click","//a[contains(text(),'Edit/Translate...')]","Translate");
		Thread.sleep(3000);
	}
	
	public void translate_UAT(String pgeName) throws Exception
	{
		System.out.println("Entered into translate method");
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Edit/Translate...')]")));
		Thread.sleep(10000);
		oASelFW.driver.navigate().refresh();
		Thread.sleep(10000);
		oASelFW.effecta("click","//a[contains(text(),'"+pgeName+"')]/../../td[1]/input","Selected Page:"+pgeName);
		Thread.sleep(3000);
		oASelFW.effecta("click","//a[contains(text(),'Edit/Translate...')]","Translate");
		Thread.sleep(3000);
	}
	public void click_translationButton(String button) throws Exception
	{
		System.out.println("Entered into click_translationButton method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Edit/Translate...')]")));
		Thread.sleep(3000);
		oASelFW.effecta("click","//a[contains(text(),'"+button+"')]","Complete button Clicked");
		Thread.sleep(3000);
	}
	
	
	
	public String edit_translate() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@class,'bwb_seg_border')]/following-sibling::td[1]/textarea")));
		String title="CloudTransformation";
		int random=(int) (Math.random()*10000);
		title=title+random;
		oASelFW.effecta("type","//td[contains(@class,'bwb_seg_border')]/following-sibling::td[1]/textarea",title,"Translation");
		oASelFW.effecta("click","//a[text()='Save']","Save");
		Thread.sleep(10000);
		return title;
	}
	
	
	public void edit_translate_pdf(String filepath) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Upload a new image:')]/input")));
		oASelFW.effecta("click","//p[contains(text(),'Upload a new image:')]/input","Upload button clicked");
		new ProcessBuilder(oASelFW.sAutomationPath+"\\ZeusLAMP\\auto_it_files\\FileUpload.exe",filepath,"Open").start();
		Thread.sleep(60000);
		oASelFW.effecta("click","//a[text()='Save']","Save");
		Thread.sleep(10000);
	
	}
	
	public void click_submit() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'AEM')]")));
		Thread.sleep(3000);	
		oASelFW.effecta("click","//input[@id='submitButton']","Submit Clicked");
		Thread.sleep(5000);
		oASelFW.effecta("click","//input[@name='ok']","OK Clicked");
		Thread.sleep(3000);
	}
	
	public void click_Preview() throws Exception
	{
		System.out.println("Click AEM Preview");
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/a[contains(text(),'Request AEM Preview...')]")));
		oASelFW.driver.findElement(By.xpath("//td/a[contains(text(),'Request AEM Preview...')]")).click();
		Thread.sleep(5000);
	}
	public void aemPreview()
	{
		System.out.println("Entered into aemPreview method");
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Request Preview']")));
		oASelFW.effecta("click","//input[@type='button']","OK");
	}
	
	public void translatedJob(String pgeName) throws Exception
	{
		System.out.println("Entered into translate method");
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Edit/Translate...')]")));
		Thread.sleep(10000);
		oASelFW.driver.navigate().refresh();
		Thread.sleep(10000);
		oASelFW.effecta("click","//a[contains(text(),'"+pgeName+"')]/../../td[1]/input","Selected Page:"+pgeName);
		Thread.sleep(3000);
	}
	
	
	public String[] getTags()
	{
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Tag'])[1]/following-sibling::ul/li")));
		int tagsCount=Integer.parseInt(oASelFW.effecta("getXpathCount","(//label[text()='Tag'])[1]/following-sibling::ul/li","tags"));
		String[] tags= new String[tagsCount];
		System.out.println("tagsCount :" + tagsCount);
		for(int i=0,j=1;i<tagsCount;i++,j++)
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Tag'])[1]/following-sibling::ul/li["+j+"]/span")));
			tags[i]=oASelFW.effecta("getText","xpath=(//label[text()='Tag'])[1]/following-sibling::ul/li["+j+"]/span","tags");
			System.out.println("Tags["+i+"] :" + tags[i]);
			
		}
		
		return tags;
	}
	
	
	public void compareTags(String[] expectedTags)
	{
		
		WebDriverWait wait = new WebDriverWait(oASelFW.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Tag'])[1]/following-sibling::ul/li")));
		int tagsCount=Integer.parseInt(oASelFW.effecta("getXpathCount","(//label[text()='Tag'])[1]/following-sibling::ul/li","tags"));
		String[] tags= new String[tagsCount];
		System.out.println("tagsCount :" + tagsCount);
		for(int i=0,j=1;i<tagsCount;i++,j++)
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Tag'])[1]/following-sibling::ul/li["+j+"]/span")));
			tags[i]=oASelFW.effecta("getText","xpath=(//label[text()='Tag'])[1]/following-sibling::ul/li["+j+"]/span","tags");
			System.out.println("Tags["+i+"] :" + tags[i]);
			if(expectedTags[i].equalsIgnoreCase(tags[i]))
			oASelFW.effecta("sendReport","Validating tags..","Successfully validate "+expectedTags[i]+ " = "+tags[i],"Pass");
			else
			oASelFW.effecta("sendReport","Validating tags..","Successfully validate "+expectedTags[i]+ " = "+tags[i],"Fail");	
			
		}
		
		
	}
	
	
	
}
