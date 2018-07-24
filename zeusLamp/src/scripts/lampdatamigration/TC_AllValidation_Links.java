package scripts.lampdatamigration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.commons.collections.MultiMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.lampdatamigration.BaseClass;
import classes.lampdatamigration.RetrieveNode;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


/**
 * 
 * @author avinash_ankireddy
 *
 */
public class TC_AllValidation_Links {


	private static int invalidLinksCount;
	private static int validlinkCount;
	ArsinSeleniumAPI oASelFW = null;
	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})
	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
	}
	@Test
	public void test() throws Exception
	{
		try{


			System.setProperty("webdriver.chrome.driver", "Y:\\Resources\\chromedriver.exe");
			oASelFW.driver = new ChromeDriver();
			oASelFW.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			oASelFW.driver.manage().window().maximize();

			UtilityMethods utility=new UtilityMethods(oASelFW);


			ArrayList<String> colNames = utility.getExcelSheetColumnValues(oASelFW.sAutomationPath+"URL_Mapping.xlsx", 0); // get Column Names

			HashMap<String,String[]> listOfLists =utility.readColumnValues(oASelFW.sAutomationPath+"URL_Mapping.xlsx",colNames);

			List<String> jcr_component = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("LiveUrls").length;d++){
				jcr_component.add((listOfLists.get("LiveUrls")[d]));
			}

			System.out.println(jcr_component);

			List<String> jcr_component1 = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("AEMPreprodURLs").length;d++){
				jcr_component1.add((listOfLists.get("AEMPreprodURLs")[d]));
			}

			System.out.println(jcr_component1);

			List<String> jcr_component2 = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("AEMDEVURLs").length;d++){
				jcr_component2.add((listOfLists.get("AEMDEVURLs")[d]));
			}

			System.out.println(jcr_component2);

			int count=0;
			ArrayList<String> cmnt = new ArrayList<String>();
			ArrayList<String> passed = new ArrayList<String>();
			passed.add("Passed Properties");
			cmnt.add("Comments");
			ArrayList<String> Result = new ArrayList<String>();
			Result.add("Result");
			for(int y=0;y<1;y++)
			{
				String comments="";
				String pas="";
				String r="";


				for(int u=0;u<1;u++){

					if(listOfLists.get(colNames.get(u))[y]!=null)
					{


						if(listOfLists.get(colNames.get(u))[y].trim().equalsIgnoreCase("NULL VALUE") || (listOfLists.get(colNames.get(u))[y].trim().length()<=1 && listOfLists.get(colNames.get(u))[y]==" ") )
						{
							//System.out.println("As the excel value is null no need to compare.......");
						}
						else
						{

							System.out.println("jcr_component.get(y): "+jcr_component.get(y));
							oASelFW.driver.get(jcr_component.get(y));

							try {
								invalidLinksCount = 0;
								List<WebElement> anchorTagsList = oASelFW.driver.findElements(By.tagName("a"));
								System.out.println("Total no. of links are "
										+ anchorTagsList.size());
								for (WebElement anchorTagElement : anchorTagsList) {
									if (anchorTagElement != null) {
										String url = anchorTagElement.getAttribute("href");
										if (url != null && !url.contains("javascript")) {
											System.out.println("Verifying the URL:-"+url);
											r=verifyURLStatus(url);
										} else {
											System.out.println(url+"is not valid ");
											invalidLinksCount++;
										}
									}
								}

								System.out.println("Total no. of invalid links are "
										+ invalidLinksCount);
								System.out.println("Total no. of valid links are "
										+ validlinkCount);

							} catch (Exception e) {
								//e.printStackTrace();

								//System.out.println(e.getMessage());
							}

							//System.out.println("Doing Validation........");



						}
						//System.out.println("The value is:" +r);

						if(r.contains("Valid link")){
							pas=pas+r;
						}
						else{
							comments=comments+r;
						}
					}
					else
					{
						comments=comments+"(Invalid links "+invalidLinksCount+")"+";";

						//oASelFW.effecta("sendReportWithOutExit","validating whether node path from is available in JCR or not","node path is not available in JCR","PASS");
					}
					// row by row
					passed.add(pas);
					cmnt.add(comments);
					if(comments.length()>0)
						Result.add("Fail");
					else
						Result.add("Pass");
					count++;
					System.out.println("No of records processed:"+count);
				}
			
			}

			utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"URL_Mapping.xlsx",Result);
			utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"URL_Mapping.xlsx",cmnt);
			utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"URL_Mapping.xlsx",passed);


		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}


	public String verifyURLStatus(String URL) {
		String result="";
		if(URL.length()>1)
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(URL);
			try {
				HttpResponse response = client.execute(request);
				//System.out.println(URL);

				// verifying response code and The HttpStatus should be 200 if not,
				// increment invalid link count
				////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404


				if (response.getStatusLine().getStatusCode() != 200)
				{
					invalidLinksCount++;
					System.out.println(URL+"   is not working ");

					result=result+"(InValid link "+URL+")"+";";
					//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Successfully Verified","Pass");


				}
				else
				{
					validlinkCount++;
					System.out.println(URL+"   is working ");
					result=result+"(Valid link "+URL+")"+";";

				}


			} catch (Exception e) {
				//System.out.println(URL+"   is not working ");
				//e.printStackTrace();
			}
		}

		else
		{
			// System.out.println("sorry No Link Found in href attribute of Anchor Tag");
		}

		return result;
	}
}


