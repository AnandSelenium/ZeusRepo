package scripts.lampdatamigration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.commons.collections.MultiMap;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classes.lampdatamigration.BaseClass;
import classes.lampdatamigration.RetrieveNode;
import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class TC_AllValidation {

	ArsinSeleniumAPI oASelFW = null;

	@Parameters({ "prjName", "testEnvironment","instanceName","sauceUser","moduleName","testSetName"})

	@BeforeClass
	public void oneTimeSetUp(String prjName,String testEnvironment,String instanceName,String sauceUser,String moduleName,String testSetName) throws InterruptedException
	{
		String[] environment=new ArsinSeleniumAPI().getEnvironment(testEnvironment,this.getClass().getName());
		String os=environment[0];String browser=environment[1];String testCasename=this.getClass().getSimpleName();
		oASelFW = new ArsinSeleniumAPI(prjName,testCasename,browser,os,instanceName,sauceUser,moduleName,testSetName);
		oASelFW.startSelenium();	
	}
	@Test
	public void test() throws Exception
	{
		try{
			Properties prop2 = new Properties();
			UtilityMethods utility=new UtilityMethods(oASelFW);
			BaseClass bc1 = new BaseClass(oASelFW);

			//retrieving data from config.properties
			prop2.load(RetrieveNode.class.getClassLoader().getResourceAsStream("scripts//lampdatamigration//config.properties"));


			ArrayList<String> colNames = utility.getExcelSheetColumnValues("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx", 0); // get Column Names


			HashMap<String,String[]> listOfLists =utility.readColumnValues("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx",colNames);

			List<String> jcr_component = new ArrayList<String>();
			for(int d=0;d<listOfLists.get(colNames.get(0)).length;d++)
			{
				//System.out.println(listOfLists.get(1)[d]+"_"+listOfLists.get(colNames.indexOf(2))[d]+"_"+"_"+listOfLists.get(0)[d]);
				jcr_component.add(utility.genPath(listOfLists.get("name")[d])+"_"+utility.genPath(listOfLists.get("language")[d])+"_"+utility.genPath(listOfLists.get("language_displayed_name")[d])+"_"+utility.genPath(listOfLists.get("story_id")[d]));
			}

			System.out.println(listOfLists.get("story_id").length);
			String temp="";

			Session s1 = bc1.getSession();
			String temp1="";
			for(int y=0;y<listOfLists.get("story_id").length;y++)
			{
				temp="content/lamp/customer-stories/"+jcr_component.get(y)+"/jcr:content";
				System.out.println("Path is:" +temp);
				Node n3 = bc1.getRelativeNode(s1, temp);
				if(n3!=null)
				{
					MultiMap m3 = bc1.getPropertyMapa(n3);

					for(int u=0;u<listOfLists.size();u++)
					{

						if(listOfLists.get(colNames.get(u))[y]!=null)
						{
							//System.out.println("value of m3:"+m3);
							//System.out.println("value of colNames:"+colNames.get(u));
							//System.out.println("value of listOfLists:"+listOfLists.get(colNames.get(u))[y]);
							//boolean b2 = bc1.validateProperty(m3,colNames.get(u),listOfLists.get(colNames.get(u))[y]);
							String r = bc1.validateProperty1(m3,colNames.get(u),listOfLists.get(colNames.get(u))[y]);
							//System.out.println("result=="+b2);
						}
					}
				}
				else{
					
					temp1 = temp.replaceAll("/[^A-Za-z0-9 ]/","").trim();
					oASelFW.effecta("sendReportWithOutExit","validating whether node path from is available in JCR or not","node path is not available in JCR","PASS");

				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}


}