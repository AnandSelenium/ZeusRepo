package scripts.lampdatamigration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


/**
 * 
 * @author avinash_ankireddy
 *
 */
public class DataMigrationSample {



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



			ArrayList<String> live = new ArrayList<String>();
			ArrayList<String> test15 = new ArrayList<String>();
			live.add("Prod");
			test15.add("test15");

			ArrayList<String> cmnt = new ArrayList<String>();
			ArrayList<String> passed = new ArrayList<String>();
			

		
			UtilityMethods utility=new UtilityMethods(oASelFW);


			ArrayList<String> colNames = utility.getExcelSheetColumnValues(oASelFW.sAutomationPath+"DataMigration_Links_Verification.xlsx", 0); // get Column Names

			HashMap<String,String[]> listOfLists =utility.readColumnValues(oASelFW.sAutomationPath+"DataMigration_Links_Verification.xlsx",colNames);


			System.setProperty("webdriver.chrome.driver", "Y:\\Resources\\chromedriver.exe");
			oASelFW.driver = new ChromeDriver();
			oASelFW.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			oASelFW.driver.manage().window().maximize();



			List<String> jcr_component = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("Source_URL").length;d++){
				jcr_component.add((listOfLists.get("Source_URL")[d]));
			}

			System.out.println(jcr_component);

			List<String> jcr_component1 = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("Destination_URL").length;d++){
				jcr_component1.add((listOfLists.get("Destination_URL")[d]));
			}

			System.out.println(jcr_component1);


			String r="";
			String pas="";
			String temp="";
		

			System.out.println(listOfLists.size());
			
			for(int y=0;y<1;y++){

			for(int i=0;i<listOfLists.size();i++){

				if(i==0)
				{
					oASelFW.driver.get(jcr_component1.get(i));
				}
				if(i==1)
				{
					oASelFW.driver.get(jcr_component.get(i-1));
				}


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
								System.out.println(r);

								if(i==0)
								{
									pas=pas+r;
								}

								if(i==1)
								{
									temp=temp+r;
								}

							} else {
								
								/*if(i==0)
								{
									pas=pas+r;
								}

								if(i==1)
								{
									temp=temp+r;
								}*/

								invalidLinksCount++;
							}


							if(i==0)
							{

									passed.add(pas);
									pas="";
									System.out.println(passed);
							}

							if(i==1)
							{

									cmnt.add(temp);
									temp="";
									System.out.println(cmnt);
							}
						}


					}

					System.out.println("Total no. of invalid links are "
							+ invalidLinksCount);
					System.out.println("Total no. of valid links are "
							+ validlinkCount);



				} catch (Exception e) {

				}
			}
			
			}

			//Removing null values from the arrayList
			passed.removeAll(Collections.singleton("")); 
			cmnt.removeAll(Collections.singleton("")); 
			
			
		

			// Comparing urls in both the instances by storing all the urls in arrayList
			for(int i=0;i<6;i++){

				System.out.println(passed.get(i));
				System.out.println(cmnt.get(i));

				String[] live1= passed.get(i).split("com/");
				String[] test15_1= cmnt.get(i).split("com/");

				System.out.println(live1[1]+" "+test15_1[1]);
				if(live1[1].equals(test15_1[1]))
				{
					System.out.println(live1[1]+" url is present in "+test15_1[1] );

					oASelFW.effecta("sendReport","Validating whether "+passed.get(i)+" url in prod instance is present in test15 instance as "+cmnt.get(i),"Successfully verified that url is present in both the instances as "+passed.get(i)+" "+cmnt.get(i),"Pass");
				}
				else
				{
					System.out.println(live1[1]+" url is not present in "+test15_1[1] );
					oASelFW.effecta("sendReportWithOutExit","Validating whether "+test15_1[1]+" url is present in live instance ","verified that url is not present in both the instances","Fail");
				}
			}
			
			
			
			String temp1 ="",temp2 ="";
			
			for(int i=0;i<passed.size();i++)
			{
				temp1=temp1+passed.get(i);
				
			}
			temp1=temp1+")";
		
			
			for(int i=0;i<cmnt.size();i++)
			{
				temp2=temp2+cmnt.get(i);
				
			}
			
		

			System.out.println(temp1+" "+temp2);


			test15.add(temp2);
			live.add(temp1);
			
			utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"DataMigration_Links_Verification.xlsx",test15);
			utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"DataMigration_Links_Verification.xlsx",live);
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


				if (response.getStatusLine().getStatusCode() != 200)
				{
					invalidLinksCount++;
					System.out.println(URL+"   is not working ");

					result=result+"(InValid link "+URL+")"+";";

				}
				else
				{
					validlinkCount++;
					System.out.println(URL+"   is working ");
					result=result+"(Valid link "+URL+")"+";";

				}


			} catch (Exception e) {

			}
		}

		else
		{

		}
		return URL;


	}




}