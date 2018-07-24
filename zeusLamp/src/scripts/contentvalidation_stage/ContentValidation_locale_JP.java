package scripts.contentvalidation_stage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;








import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMTechPaperPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class ContentValidation_locale_JP{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("Content_Validation_URL_Stage_jp",oASelFW.instanceName));	
	}
	@SuppressWarnings("unused")
	@Test
	public void ContentValidation_locale_JP() throws Exception
	{
		
		try
		{
			
			UtilityMethods utlmthds              = new UtilityMethods(oASelFW);
			
			String[] urls = utlmthds.getValuesFromPropertiesFile("constant","Content_Validation_URL_Stage_jp").split(",");
			
			outer:
			for(int i=0;i<urls.length;i++)
			{
			
				try{
				oASelFW.driver.get(urls[i]);
				Thread.sleep(15000);
				
			AEMTechPaperPage aemTpObj = new AEMTechPaperPage(oASelFW);
			//String[] error_msg={"error_country","error_fname","error_lname","error_company_name","error_address1","error_city","error_Email","error_Phone","error_title","error_department","error_jobRole","error_relationshipVMware","error_numberEmployeesGlobal","error_respondents_comments"};
			
		/*	aemTpObj.click_Submit_locale();
			
			JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
			je.executeScript("window.scrollBy(0,-250)", "");
			je.executeScript("window.scrollBy(0,-250)", "");
			je.executeScript("window.scrollBy(0,-250)", "");
			je.executeScript("window.scrollBy(0,-250)", "");*/
			
			
			//Verifying Elements
			/*aemTpObj.verify_MainHeading("Contact Sales");
			aemTpObj.verify_SubHeading("Tell Us About Yourself");
			aemTpObj.verify_Description("Complete the form below to");*/
			// aemTpObj.verify_Tags("Home");
			// aemTpObj.verify_Tags("Company");
			// aemTpObj.verify_Tags("Contact Sales");
			
			
			/*//Error Validation
			aemTpObj.errorValidation(error_msg);*/
			//Form Filling
			//Name (last name)
			aemTpObj.form_filling_locale_JP("1","Name (last name)","qa");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale_JP("2","Name (name)","test");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale_JP("3","Company Name","VMware Software India Pvt Ltd");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale_JP("4","Departments and job title","IT - Project Management");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale_JP("5","Work e-mail addres","qatest1215151@vmware.com");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale_JP("6","Work e-mail addres","Work phone number");
			Thread.sleep(3000);
			
			
			//Select drop down value
			//aemTpObj.form_dropdown_locale_second_JP("1","Country","Japan");
			aemTpObj.form_dropdown_locale_second_JP("2","Relation to the VMware","I am a paying customer");
			Thread.sleep(3000);
			aemTpObj.form_dropdown_locale_second_JP("3","Number of employees","500-999");
			Thread.sleep(3000);
			aemTpObj.form_dropdown_locale_second_JP("4","The number held by the current x86 server is","21-50");
			Thread.sleep(3000);
			aemTpObj.form_dropdown_locale_second_JP("5","budget of the virtualization project has been decided","Yes");
			Thread.sleep(3000);
			aemTpObj.form_dropdown_locale_second_JP("6","scheduled time to make a request definition of the project","0-3 mths");
			Thread.sleep(3000);
			
			aemTpObj.form_filling_locale_JP("7","Contact Subject","Thank you");
			Thread.sleep(3000);
			
	
			//click submit
			aemTpObj.click_Submit_locale_JP();
			Thread.sleep(50000);
			
			aemTpObj.verify_MainHeading_locale("Thank You For Contacting VMware!");
			
			aemTpObj.get_URL();
				}	catch(Exception e)
				{
					continue outer;
				}
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
			}
		
		}
			
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}
	}
	
	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}
}
