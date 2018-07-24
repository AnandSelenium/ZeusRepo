package scripts.lampdatamigration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import classes.aem.AEMTechPaperPage;

import com.arsin.ArsinSeleniumAPI;

public class ContentValidation{

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("Content_Validation_URL",oASelFW.instanceName));	
	}
	@Test
	public void LAMPTest() throws Exception
	{
		try
		{
			AEMTechPaperPage aemTpObj = new AEMTechPaperPage(oASelFW);
			String[] error_msg={"error_country","error_fname","error_lname","error_company_name","error_address1","error_city","error_Email","error_Phone","error_title","error_department","error_jobRole","error_relationshipVMware","error_numberEmployeesGlobal","error_respondents_comments"};
			
			aemTpObj.click_Submit("Contact Sales");
			
			//Verifying Elements
			aemTpObj.verify_MainHeading("Contact Sales");
			aemTpObj.verify_SubHeading("Tell Us About Yourself");
			aemTpObj.verify_Description("Complete the form below to");
			aemTpObj.verify_Tags("Home");
			aemTpObj.verify_Tags("Company");
			aemTpObj.verify_Tags("Contact Sales");
			
			//Error Validation
			aemTpObj.errorValidation(error_msg);
			
			//Form Filling
			aemTpObj.form_dropdown("Contact Sales", "Country");
			Thread.sleep(3000);
			aemTpObj.click_result("Country","India");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "First Name", "Naresh");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "Last Name", "rasamalla");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "Company", "Prolifics");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "Address 1", "hyderabad");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "City", "chanda nagar");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "Work Email", "naresh@abcd.com");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "Business Number", "9874563210");
			Thread.sleep(3000);
			aemTpObj.form_filling("Contact Sales", "Job Title", "lead");
			Thread.sleep(3000);
			aemTpObj.form_dropdown("Contact Sales", "Department");
			Thread.sleep(3000);
			aemTpObj.click_result("Department","Finance");
			Thread.sleep(3000);
			aemTpObj.form_dropdown("Contact Sales", "Job Role");
			Thread.sleep(3000);
			aemTpObj.click_result("Job Role","CFO");
			Thread.sleep(3000);
			aemTpObj.form_dropdown("Contact Sales", "Product Interest");
			Thread.sleep(3000);
			aemTpObj.click_result("Product Interest","Airwatch");
			Thread.sleep(3000);
			aemTpObj.form_dropdown("Contact Sales", "Relationship with VMware?");
			Thread.sleep(3000);
			aemTpObj.click_result("Relationship with VMware?","Customer");
			Thread.sleep(3000);
			aemTpObj.form_dropdown("Contact Sales", "Number of Employees, Globally?");
			Thread.sleep(3000);
			aemTpObj.click_result("Relationship with VMware?","Less Than 100");
			Thread.sleep(3000);
			aemTpObj.form_desc("Additional Information", "Bye");
			
			aemTpObj.checkbox("Additional Information");
			
			//click submit
			aemTpObj.click_Submit("Contact Sales");
			Thread.sleep(10000);
			
			aemTpObj.verify_MainHeading("Thank You For Contacting VMware!");
			Thread.sleep(5000);
				
			
			if(oASelFW.sResultFlag.contains("Fail"))
			{
				oASelFW.testNgFail();
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
