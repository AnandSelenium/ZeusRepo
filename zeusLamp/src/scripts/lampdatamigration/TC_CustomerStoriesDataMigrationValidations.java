package scripts.lampdatamigration;

import java.io.IOException;
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

public class TC_CustomerStoriesDataMigrationValidations {
	
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
		
		Properties prop2 = new Properties();
		UtilityMethods utility=new UtilityMethods(oASelFW);
		BaseClass bc1 = new BaseClass();
		
		//retrieving data from config.properties
		prop2.load(RetrieveNode.class.getClassLoader().getResourceAsStream("scripts//lampdatamigration//config.properties"));
		
		//opening in the session in the repository
		Session s1 = bc1.getSession();
		
		System.out.println("session returned.");
		
		//retrieving node path
		//String nodePath1 = bc1.getNodePath("Customer_stories.xlsx");
		
		//get all the node values
		Node n3 = bc1.getRelativeNode(s1, "content/lamp/customer-stories/vmware_virtual_san_h/jcr:content");
		MultiMap m3 = bc1.getPropertyMapa(n3);
		
	/*	
		List<String> colval = utility.readColumnValues("X:\\Data\\ZeusLAMP\\temp.xlsx","person");
		for(int u=0;u<colval.size();u++)
		{
			boolean b2 = bc1.validateProperty(m3, "person",colval.get(u).toString());
			System.out.println("****************"+b2);
		}
		*/
		
		
	}
	
	@AfterClass
	public void oneTearDown() throws IOException
	{
		oASelFW.stopSelenium();
	}


}