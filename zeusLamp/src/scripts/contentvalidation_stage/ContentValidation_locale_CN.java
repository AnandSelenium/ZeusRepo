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

public class ContentValidation_locale_CN{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("Content_Validation_URL_Stage_cn",oASelFW.instanceName));	
	}
	@SuppressWarnings("unused")
	@Test
	public void ContentValidation_locale_CN() throws Exception
	{
		
		try
		{
			
			UtilityMethods utlmthds              = new UtilityMethods(oASelFW);
			
			String[] urls = utlmthds.getValuesFromPropertiesFile("constant","Content_Validation_URL_Stage_cn").split(",");
			
			outer:
			for(int i=0;i<urls.length;i++)
			{
			
				try{
				oASelFW.driver.get(urls[i]);
				Thread.sleep(20000);
				
			AEMTechPaperPage aemTpObj = new AEMTechPaperPage(oASelFW);
			String[] error_msg={"error_country","error_fname","error_lname","error_company_name","error_address1","error_city","error_Email","error_Phone","error_title","error_department","error_jobRole","error_relationshipVMware","error_numberEmployeesGlobal","error_respondents_comments"};
			
			aemTpObj.click_Submit_locale();
			
			JavascriptExecutor je = (JavascriptExecutor) oASelFW.driver;
			je.executeScript("window.scrollBy(0,-250)", "");
			
			je.executeScript("window.scrollBy(0,-250)", "");
			je.executeScript("window.scrollBy(0,-250)", "");
			je.executeScript("window.scrollBy(0,-250)", "");
			
			//Verifying Elements
			aemTpObj.verify_MainHeading("Contact Sales");
			aemTpObj.verify_SubHeading("Tell Us About Yourself");
			aemTpObj.verify_Description("Complete the form below to");
			// aemTpObj.verify_Tags("Home");
			// aemTpObj.verify_Tags("Company");
			// aemTpObj.verify_Tags("Contact Sales");
			
			
			//Error Validation
			aemTpObj.errorValidation(error_msg);
			
			//Form Filling
			aemTpObj.form_dropdown_locale("1","country","India");
			Thread.sleep(3000);
			System.out.println("selected country");
			aemTpObj.form_filling_locale("1", "First Name", "qa");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale("2", "Last Name", "test");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale("3", "Company", "VMware Software India Pvt Ltd");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale("4", "Address 1", "JP Nagar");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale("6", "City", "Bengaluru");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale("9", "Work Email", "qatest1215151@vmware.com");
			Thread.sleep(3000);
			aemTpObj.form_filling_locale("10", "Business Number", "+918040440000");
			Thread.sleep(3000);
	
			
			aemTpObj.form_filling_locale("11", "Job Title", "Test Manager");
			Thread.sleep(3000);
			
			
			aemTpObj.form_dropdown_locale_second("2","department","IT - Project Management");
			Thread.sleep(6000);
			aemTpObj.form_dropdown_locale_second("3","jobRole", "Analyst");
			Thread.sleep(3000);
			aemTpObj.form_dropdown_locale_second("4","product_interest","Airwatch");
			Thread.sleep(3000);
			/*aemTpObj.form_dropdown_locale_second("5","relationshipvmware","Customer");
			Thread.sleep(3000);*/
			
			System.out.println("before VM informarion need");
			
			aemTpObj.form_dropdown_locale_three("6","numberemployeesglobal","Less Than 100");
			Thread.sleep(30000);
			
			
			aemTpObj.form_desc_locale("Thank You");
			
			aemTpObj.checkbox_locale();
			
			//click submit
			aemTpObj.click_Submit_locale();
			Thread.sleep(90000);
			
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
