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

public class TC_TechPapers {

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

			ArrayList<String> colNames = utility.getExcelSheetColumnValues("W:\\Data\\ZeusLAMP\\TechPapers_new.xlsx", 0); // get Column Names

			HashMap<String,String[]> listOfLists =utility.readColumnValues("W:\\Data\\ZeusLAMP\\TechPapers_new.xlsx",colNames);

			List<String> jcr_component = new ArrayList<String>();
			for(int d=0;d<listOfLists.get(colNames.get(0)).length;d++){
				//System.out.println(listOfLists.get(1)[d]+"_"+listOfLists.get(colNames.indexOf(2))[d]+"_"+"_"+listOfLists.get(0)[d]);
				jcr_component.add("techpaper"+listOfLists.get("nid")[d]);
			}

			//System.out.println(listOfLists.get("story_id").length);
			String temp="";
			Session s1 = bc1.getSession();
			int count=0;
			ArrayList<String> cmnt = new ArrayList<String>();
			ArrayList<String> passed = new ArrayList<String>();
			passed.add("Passed Properties");
			cmnt.add("Comments");
			ArrayList<String> Result = new ArrayList<String>();
			Result.add("Result");
			//for(int y=0;y<1;y++)
			for(int y=0;y<listOfLists.get("nid").length;y++){
				String comments="";
				String pas="";
				String r="";
				///content/vmware/listingtechpapers/techpaper236/jcr:content/techpaperspar
				temp="content/vmware/listingtechpapers/"+jcr_component.get(y)+"/jcr:content/techpaperspar";
				//System.out.println("Path is:" +temp);
				Node n3 = bc1.getRelativeNode(s1, temp);
				if(n3!=null){
					MultiMap m3 = bc1.getPropertyMapa(n3);

					for(int u=0;u<listOfLists.size();u++){
						if(listOfLists.get(colNames.get(u))[y]!=null){

							//System.out.println(u+"-->"+listOfLists.get(colNames.get(u))[y]);
							//System.out.println(" characters length:-"+listOfLists.get(colNames.get(u))[y].length());
							//System.out.println("-------------------------------------------------------------------");
							if(listOfLists.get(colNames.get(u))[y].trim().equalsIgnoreCase("NULL VALUE") || (listOfLists.get(colNames.get(u))[y].trim().length()<=1 && listOfLists.get(colNames.get(u))[y]==" ") )
							{
								//System.out.println("As the excel value is null no need to compare.......");
							}
							else{

								//System.out.println("Doing Validation........");
								//r = bc1.validateProperty1(m3,colNames.get(u),listOfLists.get(colNames.get(u))[y]);
								r = bc1.validateProperty_TechPapers(m3,colNames.get(u),listOfLists.get(colNames.get(u))[y]);
								//System.out.println("The value is:" +r);

								if(r.contains("Found and matched")){
									pas=pas+r;
								}
								else{
									comments=comments+r;
								}
							}
						}
						
					}
					
				}
				else{
					comments=comments+"(Node path is not available in JCR: "+temp+")"+";";
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

			utility.writeToExcelResultAndComments("W:\\Data\\ZeusLAMP\\TechPapers_new.xlsx",Result);
			utility.writeToExcelResultAndComments("W:\\Data\\ZeusLAMP\\TechPapers_new.xlsx",cmnt);
			utility.writeToExcelResultAndComments("W:\\Data\\ZeusLAMP\\TechPapers_new.xlsx", passed);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterClass
	public void oneTearDown() throws IOException{
		oASelFW.stopSelenium();
	}


}