/**
 * 
 */
package classes.aem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arsin.ArsinSeleniumAPI;

/**
 * @author avinash_ankireddy
 *
 */
public class BusinessCardPromoPage {
	
	
	ArsinSeleniumAPI oASelFW;


	public BusinessCardPromoPage(ArsinSeleniumAPI oASelFW)
	{
		this.oASelFW=oASelFW;		
	}
	
	public void typeTitle(String title)
	{
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[2]/label/following-sibling::input")));
		oASelFW.effecta("type","//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[2]/label/following-sibling::input",title,"typing "+ title);
	}
	
	public void clickAddField()
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[3]/div/button")));
		oASelFW.effecta("click","//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[3]/div/button","clicking on add field");
				
	}
	
	public void detailsInColumn(String colName,String label,String value)
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		
		if(label.equals("CTA URL"))
		{
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[3]/div/ol/li/section[contains(@data-name,'"+colName+"')]/div/div/label[contains(text(),'"+label+"')]/following-sibling::span/span/input")));
			oASelFW.effecta("type","//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[3]/div/ol/li/section[contains(@data-name,'"+colName+"')]/div/div/label[contains(text(),'"+label+"')]/following-sibling::span/span/input",value,"typing value "+ value);
		}else
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[3]/div/ol/li/section[contains(@data-name,'"+colName+"')]/div/div/label[contains(text(),'"+label+"')]/following-sibling::input")));
		oASelFW.effecta("type","//h2[contains(text(),'Business Card Promo')]/following::section[contains(@class,'is-active')]/div/div[3]/div/ol/li/section[contains(@data-name,'"+colName+"')]/div/div/label[contains(text(),'"+label+"')]/following-sibling::input",value,"typing value "+ value);
		}
		
	
	}
	
	public void clickOnDone()
	{
	
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Business Card Promo')]/following::button[contains(@title,'Done')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Business Card Promo')]/following::button[contains(@title,'Done')]","clicking on done");
	
	}
	
	
	public void clickOnColumn(String columnName)
	{
		
		WebDriverWait wait=new WebDriverWait(oASelFW.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Business Card Promo')]/following::a[contains(text(),'"+columnName+"')]")));
		oASelFW.effecta("click","//h2[contains(text(),'Business Card Promo')]/following::a[contains(text(),'"+columnName+"')]","clicking on "+ columnName);
	}
	
	
	

}
