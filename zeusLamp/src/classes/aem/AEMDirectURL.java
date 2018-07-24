package classes.aem;

import com.arsin.ArsinSeleniumAPI;

public class AEMDirectURL {
	
	ArsinSeleniumAPI oASelFW;

	
	public AEMDirectURL(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public void openMyVMwareURL()
	{
		//String url_New="http://aem-test.vmware.com/sites.html/content/vmware/language-master-sites/en/my-vmware/";
		String url="http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/";
		oASelFW.driver.get(url);
		
		oASelFW.effecta("sendReport","Navigating To MyVmware Page","Successfully Navigate to the MyVMware Page"+url,"Pass"); 
	}
	
	public void openMyVMware(String instance)
	{
		//String url_New="http://aem-test.vmware.com/sites.html/content/vmware/language-master-sites/en/my-vmware/";
		String url="http://aem-"+instance+"-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/";
		oASelFW.driver.get(url);
		
		oASelFW.effecta("sendReport","Navigating To MyVmware Page","Successfully Navigate to the MyVMware Page"+url,"Pass"); 
	}
	
	
	public void openVMware_PublishedURL()
	{
		String url="http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To VMware Published Page","Successfully Navigate to VMware Published Page"+url,"Pass"); 
	}
	
	public void openVMware_Published(String instance)
	{
		String url="http://aem-"+instance+"-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To VMware Published Page","Successfully Navigate to VMware Published Page"+url,"Pass"); 
	}
	
	
	public void openVMware_PublishedURLZCMS_16932()
	{
		String url="http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/ZCMS16932";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To VMware Published Page","Successfully Navigate to VMware Published Page"+url,"Pass"); 
	}
	
	public void openMYVMware_PublishedURL()
	{
		String url="http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/us/my-vmware/";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To MyVMware Published Page","Successfully Navigate to MyVMware Published Page"+url,"Pass"); 
	}
	
	
	
	public String opentest15URL(String Pagename)
	{
		String url= "http://www-test15.vmware.com/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA/"+Pagename+".html";
		oASelFW.driver.get(url);
		
		oASelFW.effecta("sendReport","Navigating To Test15 url","Successfully Navigate to  Test15 url"+url,"Pass"); 
		return Pagename;
	}
	
	
	public String opentest15shortenedURL(String Pagename)
	{
		String url= "http://www-test15.vmware.com/us/my-vmware/onlyAutoQA/"+Pagename+".html";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To Test15 url","Successfully Navigate to  Test15 url"+url,"Pass"); 
		return Pagename;
	}
	
	public void VmwarePublishPage(String locale)
	{
		String url="http://aem-uat-auth-1.vmware.com:8080/sites.html/content/vmware/vmware-published-sites/"+locale+"/training/uat_qa/onlyAutoQA";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To VMware Published Page","Successfully Navigate to VMware Published Page"+url,"Pass"); 	
	}
	
	
		public String UatUrl(String locale,String Pagename)
	{
		String url= "http://www-uat.vmware.com/"+locale+"/training/uat_qa/onlyAutoQA/"+Pagename+".html";
		oASelFW.driver.get(url);
		oASelFW.effecta("sendReport","Navigating To Test15 url","Successfully Navigate to  Test15 url"+url,"Pass"); 
		return Pagename;
	}
	
		
			public void openOnlyAutoQaURL()
		{
			String url="http://aem-test-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA";
			oASelFW.driver.get(url);
			oASelFW.effecta("sendReport","Navigating To MyVmware Page","Successfully Navigate to the MyVMware Page"+url,"Pass"); 
		}
		
			
			public void dispURL_Preview(String pagename)
			{
				String url="http://www-review.vmware.com/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA/"+pagename+".html";
				oASelFW.driver.get(url);
				oASelFW.effecta("sendReport","Navigating To dispURL Page","Successfully Navigate to the dispUrl Page"+url,"Pass");
				if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Page Not Found']")))
				{
					
					oASelFW.effecta("sendReportWithOutExit","Verify the page is in preview instance"," Page is not in preview instance","Fail");
				}
				else
				{
					oASelFW.effecta("sendReport","Verify the page is in preview instance"," Page is in preview instance","Pass");

				}
				
			}
			
			public void dispURL_publish(String pagename)
			{
				String url="http://www-review.vmware.com/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA/"+pagename+".html";
				oASelFW.driver.get(url);
				oASelFW.effecta("sendReport","Navigating To dispURL Page","Successfully Navigate to the dispUrl Page"+url,"Pass");
				if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Page Not Found']")))
				{
					oASelFW.effecta("sendReport","Verify the page is in preview instance"," Page is not in preview instance","Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Verify the page is in preview instance","Page is in preview instance","Fail");

				}
			}
			
			public void liveUAT_Preview(String pagename)
			{
				String url="http://www-uat.vmware.com/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA/"+pagename+".html";
				oASelFW.driver.get(url);
				
				if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Page Not Found']")))
				{
					oASelFW.effecta("sendReport","Verify the page is in Live Environment"," Page is not in Live environment","Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Verify the page is in Live Environment"," Page is in Live environment","Fail");

				}

			}
			
			public void liveUAT_Publish(String pagename)
			{
				String url="http://www-review.vmware.com/content/vmware/vmware-published-sites/us/my-vmware/onlyAutoQA/"+pagename+".html";
				oASelFW.driver.get(url);
				oASelFW.effecta("sendReport","Navigating To dispURL Page","Successfully Navigate to the dispUrl Page"+url,"Pass");
				if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//h2[text()='Page Not Found']")))
				{
					
					oASelFW.effecta("sendReportWithOutExit","Verify the is in Live Environment"," Page is not in Live Environment","Fail");
				}
				else
				{
					oASelFW.effecta("sendReport","Verify the is in Live Environment"," Page is in Live Environment","Pass");

				}
				
			}
			
			
			public void lampToAemPage(String instance)
			{
				String url="http://aem-"+instance+"-auth-1.vmware.com:8080/sites.html/content/vmware/language-master-sites/en/my-vmware/onlyAutoQA";
				oASelFW.driver.get(url);
				
				oASelFW.effecta("sendReport","Navigating To MyVmware Page","Successfully Navigate to the MyVMware Page"+url,"Pass"); 
			}
			
			
			
			
}
