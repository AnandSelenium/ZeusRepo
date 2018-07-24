package scripts.lampdatamigration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import classes.aem.AEMLoginPage;
import classes.aem.AEMSitesPage;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;


/**
 * 
 * @author avinash_ankireddy
 *
 */
public class AssertValidation {

	ArsinSeleniumAPI oASelFW = null;
	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})
	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium(oASelFW.getURL("AEM_URL",oASelFW.instanceName));	
	}
	@Test
	public void test() throws Exception
	{
		try{
			System.out.println("Starting to Execute");
			oASelFW.driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
			AEMLoginPage aemLoginObj                = new AEMLoginPage(oASelFW);
			UtilityMethods utility                  = new UtilityMethods(oASelFW);
			AEMSitesPage aemSitesObj                = new AEMSitesPage(oASelFW);

			String userName = utility.getValuesFromPropertiesFile("constant", "Uname_Girish");
			String Password = utility.getValuesFromPropertiesFile("constant", "Pwd_Girish");

			//LOGIN
			aemLoginObj.login(userName,Password);
			ArrayList<String> colNames = utility.getExcelSheetColumnValues(oASelFW.sAutomationPath+"Final2.xlsx", 0); // get Column Names
			System.out.println("Col Names"+colNames.size());
			HashMap<String,String[]> listOfLists =utility.readColumnValues(oASelFW.sAutomationPath+"Final2.xlsx",colNames);
			System.out.println("JCR Component"+listOfLists.size());
			List<String> jcr_component = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("titlePath").length;d++)
			{
				jcr_component.add(listOfLists.get("titlePath")[d]);
				System.out.println(jcr_component.get(d));
			}
			System.out.println(jcr_component);
			List<String> jcr_component1 = new ArrayList<String>();
			for(int d=0;d<listOfLists.get("titlePath").length;d++)
			{
				jcr_component1.add(utility.genPath(listOfLists.get("Language")[d])+"_"+utility.genPath(listOfLists.get("Region")[d])+"_"+utility.genPath(listOfLists.get("ProductName")[d])+"_"+utility.genPath(listOfLists.get("SolutionName")[d])+"_"+utility.genPath(listOfLists.get("Persona")[d])+"_"+utility.genPath(listOfLists.get("JourneyStage")[d])+"_"+utility.genPath(listOfLists.get("ASSET_TYPE")[d])+"_"+utility.genPath(listOfLists.get("Country")[d])+"_"+utility.genPath(listOfLists.get("ContentTypes")[d]));
				System.out.println(jcr_component1.get(d));
			}
			System.out.println(jcr_component1);
			int count=0;
			ArrayList<String> cmnt = new ArrayList<String>();
			ArrayList<String> passed = new ArrayList<String>();
			passed.add("Passed Properties");
			cmnt.add("Comments");
			ArrayList<String> Result = new ArrayList<String>();
			Result.add("Result");
			String temp="http://aem-test-auth-1.vmware.com:8080/assets.html/content";
			String result="";
			String temp6="";
			
			outer:
			for(int y=1;y<700;y++)
			{
				try{
				String comments="";
				String pas="";
				for(int u=0;u<1;u++)
				{
					if(listOfLists.get(colNames.get(u))[y]!=null)
					{
						if(listOfLists.get(colNames.get(u))[y].trim().equalsIgnoreCase("NULL VALUE") || (listOfLists.get(colNames.get(u))[y].trim().length()<=1 && listOfLists.get(colNames.get(u))[y]==" ") )
						{

						}
						else
						{
							System.out.println("jcr_component.get("+y+"): "+jcr_component.get(y).split("content")[1]);
							temp=temp+jcr_component.get(y).split("content")[1];
							String Url=temp;
							System.out.println("URL"+Url);
							System.out.println(temp);
							oASelFW.driver.get(temp);
							Thread.sleep(20000);
							temp="http://aem-test-auth-1.vmware.com:8080/assets.html/content";
							temp6="http://aem-test-auth-1.vmware.com:8080/mnt/overlay/dam/gui/content/assets/metadataeditor.html/content";
							if(Boolean.parseBoolean(oASelFW.effecta("isElementPresent","//img[contains(@data-mimetype,'application/pdf') or contains(@data-mimetype,'image/png') or contains(@data-mimetype,'image/gif') or contains(@data-mimetype,'image/jpeg')]")))
							{
								result=result+"Asset Present"+";";
								System.out.println(result);
								pas=pas+result;
								result="";
								oASelFW.effecta("sendReport","Verifying whether asset is present or not for "+Url,"Successfully validated the asset for "+Url,"Pass");
								String heading=oASelFW.effecta("getText","//div[contains(@class,'endor-BlackBar-title')]");
								System.out.println("Heading: "+ heading);
								WebDriverWait wait=new WebDriverWait(oASelFW.driver,60);
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'coral-Icon coral-Icon--chevronLeft')]")));
								oASelFW.effecta("click","//i[contains(@class,'coral-Icon coral-Icon--chevronLeft')]","clicking on icon");
								Thread.sleep(5000);
								aemSitesObj.mouseHoverOnLinkAndOpenPropertyPage(heading);
								Thread.sleep(5000);
								
								System.out.println(temp6+jcr_component.get(y).split("content")[1]);
								String url1=temp6+jcr_component.get(y).split("content")[1];
								oASelFW.driver.get(url1);
								url1="";
								int count1=Integer.parseInt(oASelFW.effecta("getXpathCount","(//label[contains(text(),'Tag')])[1]/following::ul[1]/li"));
								System.out.println(count1);
								ArrayList<String> tags=new ArrayList<String>();
								for(int i=0,j=1;i<count1;i++,j++)
								{
									String temp1=oASelFW.driver.findElement(By.xpath("(//label[contains(text(),'Tag')])[1]/following::ul[1]/li["+j+"]/span")).getText();
									System.out.println("Value: "+ (temp1.split(":")[1]).trim());
									tags.add(temp1.split(":")[1].trim());
								}
								String temp2="";
								for(int i=0,j=1;i<tags.size();i++,j++)
								{
									temp2=temp2+tags.get(i);	
								}
								System.out.println("Application Tags: "+temp2);
								String temp3="";
								temp3=temp3+jcr_component1.get(y);	
								System.out.println("Excel Tags: "+temp3);
								String s1=temp3;
								String s2=temp2;
								System.out.println(s1=s1.replaceAll("[^A-Za-z0-9]+", "").toLowerCase());
								System.out.println(s2=s2.replaceAll("[^A-Za-z0-9]+", "").toLowerCase());
								String s3=s2.replaceAll("vmware","").trim();
								System.out.println(s3);
								
								String[] s4= temp3.split("_");
								System.out.println(Arrays.toString(s4));
								
								String we=oASelFW.driver.getPageSource();
								
								System.out.println(we);
								
								for(int i=0;i<s4.length;i++)
								{
									System.out.println(s4[i]);
									
								if(we.contains(s4[i]))
								{
									oASelFW.effecta("sendReport","Verifying whether the links are present or not  "+s4[i],"Successfully validated tags are present  "+s4[i],"Pass");
									System.out.println("true");
								}
								else
								{
									oASelFW.effecta("sendReportWithOutExit","Verifying whether the links are present or not  "+s4[i],"validated that tags are not present  "+s4[i],"Fail");
								}
								}
							}
						else
						{
							result=result+"Asset Not Present"+";";
							System.out.println(result);
							pas=pas+result;
							result="";
							oASelFW.effecta("sendReportWithOutExit","Verifying whether asset is present or not for "+ Url ,"validated that asset are not found "+Url,"Fail");
						}
						passed.add(pas);
						cmnt.add(comments);
						if(comments.length()>0)
							Result.add("Fail");
						else
							Result.add("Pass");
						System.out.println("No of records processed:"+count);
					}
				}
			}
			// row by row
			count++;
			
				}
				catch(Exception e)
				{
					continue outer;
				}
			
		}
		utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"Final.xlsx",Result);
		utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"Final.xlsx",cmnt);
		utility.writeToExcelResultAndComments(oASelFW.sAutomationPath+"Final.xlsx",passed);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
@AfterClass
public void oneTearDown() throws IOException{
	oASelFW.stopSelenium();
}
}