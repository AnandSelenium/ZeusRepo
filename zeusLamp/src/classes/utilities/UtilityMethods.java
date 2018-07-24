package classes.utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;





import classes.lampdatamigration.RetrieveNode;

import com.arsin.ArsinSeleniumAPI;
import com.sun.jna.platform.win32.OaIdl;


public class UtilityMethods {
	/**
	 * @author Yatheesh_Nadindlu
	 * @date 30-12-2013
	 * @param oASelFW
	 * @param b 
	 */
	ArsinSeleniumAPI oASelFW;
	public UtilityMethods(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;

	}



	public void generateDatabaseReport(ArsinSeleniumAPI oASelFW,boolean b){
		if(b==true)
			oASelFW.effecta("sendReport","Verifying data has stored in the database","Successfully Verified","Pass");
		else
			oASelFW.effecta("sendReport","Verifying data has stored in the database","Successfully Verified, Data not generated in DB","Fail");
	}

	/**
	 * @author paramesh_bandari
	 * @param key
	 * @return
	 * This methos return the value from the Validation.Properties files based upon the key that is passed as argument.
	 */

	public static String getValidationMessage(String key)
	{
		try {

			FileInputStream fis = new FileInputStream(new File("W:\\VMWare\\Constants\\validation.properties"));
			Properties prop=new Properties();
			prop.load(fis);

			return prop.get(key).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author naresh_akkala
	 * @param propertiesFileName
	 * @param key
	 *@deprecated
	 *It is used get the value when key is passed as parameter
	 */

	public  String getValidationMessage(String propertiesFileName,String key) {
		try
		{

			FileInputStream fis = new FileInputStream(new File("W:\\VMWare\\Constants\\"+propertiesFileName+".properties"));
			Properties prop=new Properties();
			prop.load(fis);
			return prop.get(key).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public String getValidationMsge(String propertiesFileName,String key){
		try{
			Properties prop=new Properties();
			prop.load(new FileInputStream(oASelFW.sAutomationPath+oASelFW.sProjectName+File.separator+"Constants"+File.separator+propertiesFileName+".properties"));
			return prop.get(key).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}


	public HashMap<String,String> getDBData(String dbName,String testCaseName) throws FileNotFoundException, IOException{
		Properties prop= new Properties();
		prop.load(new FileInputStream(oASelFW.sAutomationPath+oASelFW.sProjectName+File.separator+"Constants"+File.separator+"testCaseNames.properties"));
		String sTestCaseName=prop.getProperty(testCaseName);
		String dbNme=prop.getProperty(dbName);
		String sSelectSQL = "Select * from "+dbNme+" where sTestCaseID = '"+sTestCaseName+"' and sEnvironment = '"+oASelFW.instanceName+"'";
		HashMap oHash=oASelFW.readDataFromAccessDB(sSelectSQL);
		return oHash;

	}

	public HashMap<String,String> getDBData(String dbName,String testCaseName,String orderType) throws FileNotFoundException, IOException{
		Properties prop= new Properties();
		prop.load(new FileInputStream(oASelFW.sAutomationPath+oASelFW.sProjectName+File.separator+"Constants"+File.separator+"testCaseNames.properties"));
		String sTestCaseName=prop.getProperty(testCaseName);
		String dbNme=prop.getProperty(dbName);
		String orType=prop.getProperty(orderType);
		System.out.println("sTestCaseName"+sTestCaseName);
		String sSelectSQL = "Select * from "+dbNme+"  where sTestCaseID = '"+sTestCaseName+"'  and sEnvironment = '"+oASelFW.instanceName+"' and bFlag='T' and sOrderType='"+orType+"'";
		System.out.println("sSelectSQLsSelectSQL"+sSelectSQL);
		HashMap oHash=oASelFW.readDataFromAccessDB(sSelectSQL);
		return oHash;

	}



	public HashMap<String,String> getSDPData(String tbleName,String testCaseName) throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		String sSelectSQL = "Select * from "+tbleName+"  where TestDataTableLinkID = '"+testCaseName+"'  and sEnvironment = '"+oASelFW.instanceName+"' ";
		String sDbName=prop.getProperty("SDPDBNAME");
		System.out.println("DB Name&***********"+sDbName);
		HashMap oHash=oASelFW.readDataFromAccessDB(sDbName,sSelectSQL);
		return oHash;

	}

	//******* Oracle DB connection ***************
	public  int getConnection_unitType(String hostName, String usrName, String pwd,String serviceName)
	{
		Connection con=null;
		int recordsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc:oracle:thin:@"+hostName+":1521:"+serviceName+","+usrName+","+pwd);
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":1521/"+serviceName,usrName,pwd);
			if(con!=null)
			{
				System.out.println("connection established");
				//step3 create the statement object  
				Statement stmt=con.createStatement();  

				//step4 execute query 

				ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_unit_types_summ");


				ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();

				while(rs.next()) 
				{
					// For getting the row count
					recordsCount= rs.getInt(1);
					System.out.println(recordsCount);
					oASelFW.effecta("sendReportWithOutExit","Executing query to retreive count"," Sucessfully executed query count is "+recordsCount+"","Pass");

					// For printing all the records in the table
					/*for(int i=1;i<=columnsNumber;i++)
					{
						System.out.print(rs.getString(i)+"   ");
					}

					System.out.println();*/
				}

				//step5 close the connection object  
				con.close();  
			}
			else
				System.out.println("connection not established");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return recordsCount;
	}

	public  int getConnection_Usages_sum(String hostName, String usrName, String pwd,String serviceName)
	{
		Connection con=null;
		int recordsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc:oracle:thin:@"+hostName+":1521:"+serviceName+","+usrName+","+pwd);
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":1521/"+serviceName,usrName,pwd);
			if(con!=null)
			{
				System.out.println("connection established");
				//step3 create the statement object  
				Statement stmt=con.createStatement();  

				//step4 execute query 


				ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_usages_summ");
				//ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_services_summ");
				//ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_plans_summ");
				//ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_inv_items_summ");

				ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();

				while(rs.next()) 
				{
					// For getting the row count
					recordsCount= rs.getInt(1);
					System.out.println(recordsCount);

					// For printing all the records in the table
					/*for(int i=1;i<=columnsNumber;i++)
					{
						System.out.print(rs.getString(i)+"   ");
					}

					System.out.println();*/
				}

				//step5 close the connection object  
				con.close();  
			}
			else
				System.out.println("connection not established");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return recordsCount;
	}

	public  int getConnection_Usages_sum_serviceSum(String hostName, String usrName, String pwd,String serviceName)
	{
		Connection con=null;
		int recordsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc:oracle:thin:@"+hostName+":1521:"+serviceName+","+usrName+","+pwd);
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":1521/"+serviceName,usrName,pwd);
			if(con!=null)
			{
				System.out.println("connection established");
				//step3 create the statement object  
				Statement stmt=con.createStatement();  

				//step4 execute query 

				ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_services_summ");
				//ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_plans_summ");
				//ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_inv_items_summ");

				ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();

				while(rs.next()) 
				{
					// For getting the row count
					recordsCount= rs.getInt(1);
					System.out.println(recordsCount);

					// For printing all the records in the table
					/*for(int i=1;i<=columnsNumber;i++)
					{
						System.out.print(rs.getString(i)+"   ");
					}

					System.out.println();*/
				}

				//step5 close the connection object  
				con.close();  
			}
			else
				System.out.println("connection not established");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return recordsCount;
	}

	public  int getConnection_Usages_sum_plans_sum(String hostName, String usrName, String pwd,String serviceName)
	{
		Connection con=null;
		int recordsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc:oracle:thin:@"+hostName+":1521:"+serviceName+","+usrName+","+pwd);
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":1521/"+serviceName,usrName,pwd);
			if(con!=null)
			{
				System.out.println("connection established");
				//step3 create the statement object  
				Statement stmt=con.createStatement();  

				//step4 execute query 


				ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_plans_summ");
				//ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_inv_items_summ");

				ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();

				while(rs.next()) 
				{
					// For getting the row count
					recordsCount= rs.getInt(1);
					System.out.println(recordsCount);

					// For printing all the records in the table
					/*for(int i=1;i<=columnsNumber;i++)
					{
						System.out.print(rs.getString(i)+"   ");
					}

					System.out.println();*/
				}

				//step5 close the connection object  
				con.close();  
			}
			else
				System.out.println("connection not established");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return recordsCount;
	}

	public  int getConnection_Usages_sum_inv_items_summ(String hostName, String usrName, String pwd,String serviceName)
	{
		Connection con=null;
		int recordsCount=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc:oracle:thin:@"+hostName+":1521:"+serviceName+","+usrName+","+pwd);
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":1521/"+serviceName,usrName,pwd);
			if(con!=null)
			{
				System.out.println("connection established");

				//step3 create the statement object  
				Statement stmt=con.createStatement();  

				//step4 execute query 
				ResultSet rs=stmt.executeQuery("select count (*) from xxvmsdp.xxvm_aria_all_inv_items_summ");

				ResultSetMetaData rsmd = rs.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();

				while(rs.next()) 
				{
					// For getting the row count
					recordsCount= rs.getInt(1);
					System.out.println(recordsCount);

					// For printing all the records in the table
					/*for(int i=1;i<=columnsNumber;i++)
					{
						System.out.print(rs.getString(i)+"   ");
					}

					System.out.println();*/
				}

				//step5 close the connection object  
				con.close();  
			}
			else
				System.out.println("connection not established");
			oASelFW.effecta("sendReportWithOutExit","Establishing connection with oracle db","Failed to Establish connection","Pass");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return recordsCount;
	}


	/**
	 * @author naresh_akkala
	 * Changing the folder Name randomly
	 * @throws IOException 
	 */
	public String changeFolderName(String path,String fileName) throws IOException{
		String var="";
		if(fileName.contains("Empty Price List"))
			var="Empty Price List-";
		else if(fileName.contains("Price List"))
			var="Price List-";
		File file=new File(path,fileName);
		Random rand=new Random();
		int ran=0;
		for(int i=0;i<6;){
			ran=rand.nextInt(36);
			if(ran>10){
				var=var+Character.forDigit(ran, 36);
				i++;
			}

		}
		file.renameTo(new File(path,var+".xls"));
		System.out.println(var);
		FileOutputStream out=new FileOutputStream(new File("W:\\VMWare\\Constants\\sdpPartners.properties"),true);
		Properties prop=new Properties();
		if(fileName.contains("Empty Price List"))
			prop.setProperty("Emptyxlsfile", var);
		else if(fileName.contains("Price List"))
			prop.setProperty("PriceList",var);
		else
			prop.setProperty(var,var);

		prop.store(out, "changed file name");
		return var;

	}


	/**
	 * @author naresh_akkala
	 * @Date 06/02/2014
	 * @param dbName(database table Name),testCaseName(testcaseId),values(custemail,password,fname,lname,bflag)
	 * This method is used to insert invited user of ems to database
	 * Note::This method is developed based on urm module requirement.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */

	public void insertIntoDB(String dbName,String testCaseName,String... values) throws FileNotFoundException, IOException{
		Properties prop= new Properties();
		prop.load(new FileInputStream(oASelFW.sAutomationPath+oASelFW.sProjectName+File.separator+"Constants"+File.separator+"testCaseNames.properties"));
		String sTestCaseName=prop.getProperty(testCaseName);
		String dbNme=prop.getProperty(dbName);
		String sql="insert into "+dbNme+"(sTestcaseId,sEnvironment,sCust_EMail,sPassword,FName,LName,bFlag) values('"+sTestCaseName+"',' "+oASelFW.instanceName+"','"+values[0]+"','"+values[1]+"',"+values[2]+"','"+values[3]+"','"+values[4]+"')";
		oASelFW.insertDataIntoAccessDB(oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\MYVMware",sql);

	}



	/**
	 * @author naresh_akkala
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @Date 07/02/2014
	 * @param dbName(database table Name given in properties file),testCaseName(testcaseId),keyValues(database column heading,value) in hash map
	 * This method is used to update data into database if testcaseid is present,else insert data in to database 
	 * Note:Any doubts please contact naresh kumar akkala
	 */
	public void updateOrInsertIntoDataBase(String dbName,String testCaseName,HashMap<String,String> keyValues) throws FileNotFoundException, IOException{
		Properties prop= new Properties();
		String sData="";
		Set<String> set=null;
		prop.load(new FileInputStream(oASelFW.sAutomationPath+oASelFW.sProjectName+File.separator+"Constants"+File.separator+"testCaseNames.properties"));
		String dbNme=dbName;
		System.out.println(dbNme);
		String sSelectSQL = "Select count(*)  from "+dbNme+" where SeleniumScriptName = '"+testCaseName+"'";
		System.out.println(sSelectSQL+"**************");
		HashMap<String,String> oHash=oASelFW.readDataFromAccessDB(sSelectSQL);
		//This condition is used for inserting the data in to database
		if(oHash.get("Expr1000").equals("0")){
			sData="insert into  "+dbNme+"(SeleniumScriptName,";
			set=keyValues.keySet();
			for(String key:set){
				sData=sData+key+" ,";
			}
			sData=sData+"sEnvironment) values('"+testCaseName+"','";
			for(String keyset:set){
				sData=sData+keyValues.get(keyset)+"','";
			}
			sData=sData+oASelFW.instanceName+"')";
		}
		else{
			sData="update "+dbNme+" set ";
			set=keyValues.keySet();
			for(String key:set){
				sData=sData+key+"= '"+keyValues.get(key)+"' ,";
			}
			sData=sData.substring(0, sData.lastIndexOf(","));
			sData=sData+" where  SeleniumScriptName='"+testCaseName+"' ";


		}
		System.out.println(sData+"Print the sData"); 
		oASelFW.insertDataIntoAccessDB(oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\MYVMware",sData);
	}
	/**
	 * @author Lavanya
	 * @param key
	 * @return
	 * This methos return the value from the Validation.Properties files based upon the key that is passed as argument.
	 */

	public String getValuesFromPropertiesFile(String propertiesFileName,String key)
	{
		try
		{

			FileInputStream fis = new FileInputStream(new File(oASelFW.sAutomationPath+oASelFW.sProjectName+"\\Constants\\"+propertiesFileName+".properties"));
			Properties prop=new Properties();
			prop.load(fis);
			return prop.get(key).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public String[] getUrl(String scriptname) throws FileNotFoundException, IOException{

		String	sData="";
		String url ="";
		String countryCode = "";
		String sDbName="W:\\Data\\SDP\\SDP";
		System.out.println("DB Name&***********"+sDbName);
		sData =  "select first(TestDataTableLinkID) as testData from FunctionalScenario_Praxis where SeleniumScriptName='"+scriptname+"'";
		System.out.println(sData);
		String sData1="Select * from FunctionalScenario_Praxis_Output where TestDataTableLinkID=("+sData+")";
		System.out.println(sData1);
		HashMap<String,String> hm1=oASelFW.readDataFromAccessDB(sDbName,sData1);
		/*String countryCode=hm1.get("PraxisSignup_CountryCode");
		url = hm1.get("PraxisURL");*/
		String testDataTableLinkID=hm1.get("TestDataTableLinkID");
		System.out.println("******************************************************************"+testDataTableLinkID);
		return new String[]{url,testDataTableLinkID,countryCode};
	}

	public String[] getAddressDetails(String testDataTableLinkID)
	{
		//String dbPath =oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\SDP_BAT";
		String sData="Select * from OutputData_Praxis where TestDataTableLinkID='"+testDataTableLinkID+"'";
		HashMap<String,String> hm1=oASelFW.readDataFromAccessDB(sData);
		String state=hm1.get("sState");
		String city=hm1.get("sCity");
		String zipcode=hm1.get("sZIP");
		String Address=hm1.get("sAddress");
		String country = hm1.get("sCountry");
		String email = hm1.get("sITSuper_User_Email");
		sData="Select * from FunctionalScenario_Praxis where TestDataTableLinkID='"+testDataTableLinkID+"'";

		String currency=hm1.get("Currency Desc");
		String cardNumber = hm1.get("CardNumber");
		String Promocode = hm1.get("Promocode");
		return new String[]{Address,city,state,country,zipcode,currency,cardNumber,Promocode};
	}


	public String[] getAddressDetailsforPraxis(String testDataTableLinkID)
	{
		//String dbPath =oASelFW.sAutomationPath+"Data\\"+oASelFW.sProjectName+"\\SDP_BAT";
		//String sData="Select * from FunctionalScenario_Praxis_Output where TestDataTableLinkID='"+testDataTableLinkID+"'";
		String sData="Select * from FunctionalScenario_Praxis_Output Where ExecutionTag = 'T'";
		String sDbName="W:\\Data\\SDP\\SDP";
		System.out.println("path"+sData);
		HashMap<String,String> hm1=oASelFW.readDataFromAccessDB(sDbName,sData);
		String state=hm1.get("sState");
		String city=hm1.get("sCity");
		String zipcode=hm1.get("sZip");
		String Address=hm1.get("sAddress");
		String country = hm1.get("sCountry");
		String email = hm1.get("sITSuper_User_Email");
		//sData="Select * from FunctionalScenario_Praxis where TestDataTableLinkID='"+testDataTableLinkID+"'";
		System.out.println("path"+state);
		String currency=hm1.get("Currency Desc");
		String cardNumber = hm1.get("CardNumber");
		String Promocode = hm1.get("Promocode");

		/*		System.out.println("state"+state);
		System.out.println("address"+Address);
		System.out.println("country"+country);
		System.out.println("zip"+zipcode);*/

		return new String[]{Address,city,state,country,zipcode,currency,cardNumber,Promocode};
	}

	public void click_Attachfile(String uploadfile ) throws InterruptedException
	{

		try{

			System.out.println("in the click_Attachfilelink");
			String filename=oASelFW.sAutomationPath+oASelFW.sProjectName+"\\"+uploadfile;
			System.out.println(filename);

			Thread.sleep(3000);


			if(oASelFW.sBrowser.contains("Chrome")){
				new ProcessBuilder(oASelFW.sAutomationPath+oASelFW.sProjectName+"\\UpLoadAttachmentChrome.exe", filename, "Open").start(); 

				Thread.sleep(15000);
			}

			if(oASelFW.sBrowser.contains("Internet Explorer")){
				new ProcessBuilder(oASelFW.sAutomationPath+oASelFW.sProjectName+"\\UpLoadAttachmentIE.exe", filename, "Open").start(); 
				Thread.sleep(9000);
			}
			if(oASelFW.sBrowser.contains("Firefox")){
				System.out.println("in the fire fox browser");
				new ProcessBuilder(oASelFW.sAutomationPath+oASelFW.sProjectName+"\\UpLoadAttachmentFirefox.exe", filename, "Open").start(); 

				Thread.sleep(9000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}   


	/** @author gunasekhar_kalla
	 * @param filepathAndName
	 * @param valuesToBeVerified
	 * @throws IOException
	 * @Date Of Creation: 10-09-2015
	 * @Functionality:  Excel File values validation API
	 */
	public void readExcelFile(String filepathAndName, ArrayList<String> valuesToBeVerified) throws IOException 
	{

		try{
			InputStream input = new FileInputStream(filepathAndName);
			if(filepathAndName.contains(".xlsx"))
			{

				XSSFWorkbook wb = new XSSFWorkbook(input);
				for(String cellContent: valuesToBeVerified)
				{
					int count=0;
					for(XSSFSheet sheet: wb)
					{
						for (Row row : sheet) 
						{
							for (Cell cell : row) 
							{
								if (cell.getCellType() == Cell.CELL_TYPE_STRING)
								{
									System.out.println(cell.getRichStringCellValue().getString());
									if (cell.getRichStringCellValue().getString().contains(cellContent) && count==0)
									{
										System.out.println("******** Found! *********"+ cellContent);
										oASelFW.effecta("sendReportWithOutExit","Verifying :"+cellContent,"value found in Excel Sheet:"+cellContent,"Pass");
										count++;
									}

								}
							}
						}    
					}
					if(count==0)
					{
						System.out.println("---------> Not Found -------"+ cellContent);
						oASelFW.effecta("sendReportWithOutExit","Verifing :"+cellContent,"value Not found in Excel Sheet :"+cellContent,"Fail");
					}
				}
				wb.close();
			}
			else if(filepathAndName.contains(".xls"))
			{
				HSSFWorkbook wb1 = new HSSFWorkbook(input);
				int sheets = wb1.getNumberOfSheets();
				for(String cellContent: valuesToBeVerified)
				{
					int count=0;
					for(int i=0;i<sheets;i++)
					{
						HSSFSheet sheet = wb1.getSheetAt(i);

						for (Row row : sheet) 
						{
							for (Cell cell : row) 
							{
								if (cell.getCellType() == Cell.CELL_TYPE_STRING)
								{

									System.out.println(cell.getRichStringCellValue().getString());
									if (cell.getRichStringCellValue().getString().contains(cellContent) && count==0)
									{
										System.out.println("******** Found! *********"+ cellContent);
										oASelFW.effecta("sendReportWithOutExit","Verifying :"+cellContent,"value found in Excel Sheet:"+cellContent,"Pass");
										count++;
									}

								}
							}
						}    
					}
					if(count==0)
					{
						System.out.println("--------- Not Found -------"+ cellContent);
						oASelFW.effecta("sendReportWithOutExit","Verifing :"+cellContent,"value Not found in Excel Sheet :"+cellContent,"Fail");
					}
				}
				wb1.close();
			}
			input.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			/*File f = new File(filepathAndName);
			f.delete();	
			 */}

	}


	public void readExcelFile_RealtimeOM(String filepathAndName, ArrayList<String> valuesToBeVerified) throws IOException 
	{

		try{
			InputStream input = new FileInputStream(filepathAndName);
			if(filepathAndName.contains(".xlsx"))
			{
				XSSFWorkbook wb = new XSSFWorkbook(input);
				for(String cellContent: valuesToBeVerified)
				{
					int count=0;
					for(XSSFSheet sheet: wb)
					{
						sheet.getSheetName();

						for (Row row : sheet) 
						{
							for (Cell cell : row) 
							{
								if (cell.getCellType() == Cell.CELL_TYPE_STRING)
								{
									System.out.println(cell.getRichStringCellValue().getString());
									if (cell.getRichStringCellValue().getString().contains(cellContent) && count==0)
									{
										System.out.println("******** Found! *********"+ cellContent);
										oASelFW.effecta("sendReportWithOutExit","Verifying :"+cellContent,"value found in Excel Sheet:"+cellContent,"Pass");
										count++;
									}

								}
							}
						}    
					}
					if(count==0)
					{
						System.out.println("---------> Not Found -------"+ cellContent);
						oASelFW.effecta("sendReportWithOutExit","Verifing :"+cellContent,"value Not found in Excel Sheet :"+cellContent,"Fail");
					}
				}
				wb.close();
			}
			else if(filepathAndName.contains(".xls"))
			{
				HSSFWorkbook wb1 = new HSSFWorkbook(input);
				int sheets = wb1.getNumberOfSheets();
				for(String cellContent: valuesToBeVerified)
				{
					int count=0;
					for(int i=0;i<sheets;i++)
					{
						HSSFSheet sheet = wb1.getSheetAt(i);

						for (Row row : sheet) 
						{
							for (Cell cell : row) 
							{
								if (cell.getCellType() == Cell.CELL_TYPE_STRING)
								{

									System.out.println(cell.getRichStringCellValue().getString());
									if (cell.getRichStringCellValue().getString().contains(cellContent) && count==0)
									{
										System.out.println("******** Found! *********"+ cellContent);
										oASelFW.effecta("sendReportWithOutExit","Verifying :"+cellContent,"value found in Excel Sheet at coloumn "+((cell.getColumnIndex())+1)+":" +cellContent,"Pass");
										count++;
									}

								}
							}
						}    
					}
					if(count==0)
					{
						System.out.println("--------- Not Found -------"+ cellContent);
						oASelFW.effecta("sendReportWithOutExit","Verifing :"+cellContent,"value Not found in Excel Sheet :"+cellContent,"Fail");
					}
				}
				wb1.close();
			}
			input.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			/*File f = new File(filepathAndName);
			f.delete();	
			 */}

	}




	/** @author gunasekhar_kalla
	 * @param csvFile
	 * @param valuesToBeVerified
	 * @throws IOException
	 * @Date Of Creation: 10-09-2015
	 * @Functionality:  CSV File values validation API
	 */

	public void readcsv(String filepathAndName,  ArrayList<String> valuesToBeVerified)
	{
		try { 

			//String csvFile = "C:\\SampleCSV.csv";

			//create BufferedReader to read csv file
			BufferedReader br =null;
			String line = "";
			StringTokenizer st = null;

			int lineNumber = 0; 
			int tokenNumber = 0;
			int count=0;
			String s ="";
			for(String cellContent: valuesToBeVerified)
			{

				br = new BufferedReader(new FileReader(filepathAndName));
				count=0;
				lineNumber = 0; 
				while ((line = br.readLine()) != null) 
				{
					lineNumber++;

					//use comma as token separator
					st = new StringTokenizer(line, ",");
					//reset token number
					tokenNumber = 0;
					while (st.hasMoreTokens()) 
					{

						tokenNumber++;
						s= st.nextToken();
						//display csv values
						System.out.print(s + "  ");

						if(s.equalsIgnoreCase(cellContent) && count==0)
						{
							System.out.println("***** Found! ****");
							oASelFW.effecta("sendReportWithOutExit","Verifying :"+cellContent,"value found in csv file:"+cellContent,"Pass");
							count++;
						}
						if(count>0)
							break;
					}

					System.out.println();
					if(count>0)
						break;
				}

				br.close();
				if(count==0)
				{
					System.out.println("--------- Not Found -------"+ cellContent);
					oASelFW.effecta("sendReportWithOutExit","Verifing :"+cellContent,"value Not found in csv file :"+cellContent,"Fail");
				}
			}



			// csvFile.delete();

		} 
		catch (Exception e) 
		{
			System.err.println("CSV file cannot be read : " + e);
			e.printStackTrace();
		}
		finally
		{
			// driver.close();

		}


	}


	public ArrayList<String> readCellValuesFromExcelFile(String filepathAndName, int rownum,int colnum) throws IOException 
	{
		System.out.println("Haio I am in readCellValues");
		ArrayList<String> alist=new ArrayList<String>();
		try{
			InputStream input = new FileInputStream(filepathAndName);
			if(filepathAndName.contains(".xlsx"))
			{
				System.out.println("step - workbook");
				XSSFWorkbook wb = new XSSFWorkbook(input);
				for(XSSFSheet sheet: wb)
				{

					System.out.println("step - sheet");
					for (int i=rownum;i<sheet.getLastRowNum();i++) 
					{
						Row row=sheet.getRow(i);
						System.out.println("step - Row");
						Cell cell = row.getCell(colnum);

						System.out.println("step - Cell");
						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						{
							//System.out.println(cell.getRichStringCellValue().getString());
							alist.add(cell.getRichStringCellValue().getString());


						}
						else
						{
							//System.out.println(cell.getRichStringCellValue().getString());
							//alist.add(cell.getRichStringCellValue().getString());
						}

					}    
				}

				wb.close();
			}
			else if(filepathAndName.contains(".xls"))
			{

				HSSFWorkbook wb1 = new HSSFWorkbook(input);
				int sheets = wb1.getNumberOfSheets();
				for(int i=0;i<sheets;i++)
				{
					HSSFSheet sheet = wb1.getSheetAt(i);

					for (int j=rownum;j<sheet.getLastRowNum();j++) 
					{
						Row row=sheet.getRow(j);
						Cell cell = row.getCell(colnum);

						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						{
							//System.out.println(cell.getRichStringCellValue().getString());
							alist.add(cell.getRichStringCellValue().getString());


						}

					}    
				}

				wb1.close();
			}
			input.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return alist;

	}


	public void writeCellValuesFromExcelFile(String filepathAndName, int rownum,int colnum, ArrayList<String> sdp,ArrayList<String> subad,ArrayList<String> autoupprice) throws IOException 
	{
		try{

			if(filepathAndName.contains(".xlsx"))
			{
				InputStream input = new FileInputStream(filepathAndName);
				XSSFWorkbook wb = new XSSFWorkbook(input);


				for(XSSFSheet sheet: wb)
				{

					for (int i=rownum;i<sheet.getLastRowNum();i++) 
					{
						Row row=sheet.getRow(i);

						Cell cell = row.getCell(colnum);
						cell.setCellValue(sdp.get(i-rownum));	

						cell = row.getCell(colnum+1);
						cell.setCellValue(subad.get(i-rownum));	

						cell = row.getCell(colnum+2);
						cell.setCellValue(autoupprice.get(i-rownum));	
					}    
				}
				input.close();
				FileOutputStream output_file =new FileOutputStream(new File(filepathAndName));  //Open FileOutputStream to write updates

				wb.write(output_file); //write changes

				output_file.close();  //close the stream

				wb.close();
			}
			else if(filepathAndName.contains(".xls"))
			{
				InputStream input = new FileInputStream(filepathAndName);
				HSSFWorkbook wb1 = new HSSFWorkbook(input);
				int sheets = wb1.getNumberOfSheets();
				for(int i=0;i<sheets;i++)
				{
					HSSFSheet sheet = wb1.getSheetAt(i);

					for (int j=rownum;j<sheet.getLastRowNum();j++) 
					{
						Row row=sheet.getRow(i);
						Cell cell = row.getCell(colnum);

						cell.setCellValue(sdp.get(i-rownum));	

						cell = row.getCell(colnum+1);
						cell.setCellValue(subad.get(i-rownum));	

						cell = row.getCell(colnum+2);
						cell.setCellValue(autoupprice.get(i-rownum));	

					}    
				}
				input.close();
				FileOutputStream output_file =new FileOutputStream(new File(filepathAndName));  //Open FileOutputStream to write updates

				wb1.write(output_file); //write changes

				output_file.close();

				wb1.close();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	//public List <HashMap <String, String>> getMultipleRecords(String selectQuery)
	public ResultSet getMultipleRecords(String selectQuery, String path)
	{

		ResultSet rs = null;
		try{

			// Load MS accces driver class
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			//  location of your database 
			String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + path;

			// specify url, username, pasword - make sure these are valid 
			Connection conn = DriverManager.getConnection(url, "", "");

			System.out.println("Connection Succesfull");

			Statement s = conn.createStatement();

			// Fetch table
			s.execute(selectQuery);
			rs = s.getResultSet();

		} 
		catch (Exception e) 
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		//return list;
		return rs;
	}


	public String[] get_testdataLinkValues(String dbpath, String sSQL)
	{
		Connection conn = oASelFW.getConnectionObj(dbpath);
		Statement smt = null;
		String testData[] =new String[200];
		try
		{
			smt = conn.createStatement();
			smt.execute(sSQL);
			ResultSet rs = smt.getResultSet();
			int i=0;
			while(rs.next())
			{ 
				String str1 = rs.getString("TestDataTableLinkID");
				System.out.println("%%%%%%%%%"+str1);
				testData[i]=str1;
				i++;

			}
			smt.close();
			conn.close();
		}
		catch(Exception e)
		{

		}

		return testData;

	}

	/** @author gunasekhar_kalla
	 * @Date Of Creation: 20-01-2016
	 * @Functionality: getCurrentTime in given format
	 */
	public String getCurrentTime(String format)
	{
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String finalDate = sdf.format(today);
		return finalDate;
	}


	// vineela

	public HashMap<String,String[]> readColumnValues(String filepathAndName, ArrayList<String> columnNames) throws IOException 
	{
		HashMap<String,String[]> listOfLists = new HashMap<String,String[]>();
		ArrayList<String> alist = new ArrayList<String>();


		InputStream input = new FileInputStream(filepathAndName);

		int rslt=0;
		if(filepathAndName.contains(".xlsx"))
		{
			XSSFWorkbook wb = new XSSFWorkbook(input);
			int i=0,j=0;
			for(XSSFSheet sheet: wb)
			{
				for(int c=0;c<columnNames.size();c++)
				{
					for (i=0;i<sheet.getLastRowNum();i++) 
					{
						Row row=sheet.getRow(i);

						for(j=0;j<row.getLastCellNum();j++)
						{
							Cell cell = row.getCell(j);
							if (cell == null)
							{
								alist.add("");
							}
							else if(cell.getStringCellValue().trim().equalsIgnoreCase(columnNames.get(c)))
							{
								rslt=1;
								//System.out.println("ROw="+i+"Column="+j);
								break;
							}

						}
						if(rslt==1)
							break;
					}
					//System.out.println(sheet.getPhysicalNumberOfRows());
					//System.out.println("i="+i+" "+"j="+j);
					for (int k=(i+1);k<=sheet.getLastRowNum();k++) 
					{
						Row row=sheet.getRow(k);

						Cell cell = row.getCell(j, Row.RETURN_NULL_AND_BLANK);
						if (cell == null)
						{
							alist.add("NULL VALUE");
						}
						else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if("".equals(cell.getStringCellValue().trim()))
								alist.add(" ");
							else 
								alist.add(cell.getStringCellValue());
							//alist.add(String.valueOf((int) cell.getNumericCellValue()));
						}
						else if(cell.getCellType()==cell.CELL_TYPE_STRING)
						{

							if("".equals(cell.getStringCellValue().trim()))
								alist.add(" ");
							else 
								alist.add(cell.getStringCellValue());
						}
						else
						{
							alist.add(" ");
						}


					}
					String[] stockArr = new String[alist.size()];
					stockArr = alist.toArray(stockArr);

					listOfLists.put(columnNames.get(c),stockArr);
					//System.out.println(listOfLists.get(columnNames.get(c)));
					//System.out.println(listOfLists.get("name"));
					alist.clear();
				}

			}    
			input.close();
			wb.close();

		}
		else if(filepathAndName.contains(".xls"))
		{
			InputStream input_Xls = new FileInputStream(filepathAndName);
			HSSFWorkbook wb1 = new HSSFWorkbook(input_Xls);
			int sheets = wb1.getNumberOfSheets();
			int j=0,i=0;
			for(int a=0;a<sheets;a++)
			{
				HSSFSheet sheet = wb1.getSheetAt(a);
				for(int c=0;c<columnNames.size();c++)
				{
					for (i=0;i<sheet.getLastRowNum();i++) 
					{
						Row row=sheet.getRow(a);

						for(j=0;j<row.getLastCellNum();j++)
						{
							Cell cell = row.getCell(j);
							if (cell == null)
							{
								alist.add("NULL VALUE");
							}
							else if(cell.getStringCellValue().trim().equalsIgnoreCase(columnNames.get(c)))
							{
								rslt=1;
								break;
							}

						}
						if(rslt==1)
							break;

					}  

					for (int k=(i+1);k<=sheet.getLastRowNum();k++) 
					{
						Row row=sheet.getRow(k);
						Cell cell = row.getCell(j, Row.RETURN_NULL_AND_BLANK);
						if (cell == null)
						{
							alist.add("NULL VALUE");
						}
						else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if("".equals(cell.getStringCellValue().trim()))
								alist.add(" ");
							else 
								alist.add(cell.getStringCellValue());
							//alist.add(String.valueOf((int) cell.getNumericCellValue()));
						}
						else if(cell.getCellType()==cell.CELL_TYPE_STRING)
						{

							if("".equals(cell.getStringCellValue().trim()))
								alist.add(" ");
							else 
								alist.add(cell.getStringCellValue());
						}
						else
						{
							alist.add(" ");
						}					}
					String[] stockArr = new String[alist.size()];
					stockArr = alist.toArray(stockArr);

					listOfLists.put(columnNames.get(c),stockArr);
					alist.clear();

				}

			}

			input_Xls.close();

			wb1.close();
		}


		/*}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		return listOfLists;

	}

	public static ArrayList<String> test(String filename) throws Exception
	{
		ArrayList<String> data=new ArrayList<String>();
		FileInputStream fileInputStream = new FileInputStream(filename);
		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = wb.getSheetAt(0);

		int row=sheet.getLastRowNum();
		System.out.println("Total No. of Rows are:"+row);

		/*XSSFRow row1=sheet.getRow(0);*/
		XSSFRow row1=sheet.getRow(1);
		int num=row1.getLastCellNum();
		System.out.println("Total No. of Cols are:" +num);


		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			for(int j=0;j<19;j++)
			{
				XSSFRow row2=sheet.getRow(i);
				XSSFCell cell=row2.getCell(j,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK );
				String cellValueStr=cell.toString();
				data.add(cellValueStr);


			}
		}
		return data;
	}

	public   ArrayList<String> getExcelSheetColumnValues(String filepathAndName, int rowIndex) throws IOException 
	{
		ArrayList<String> alist = new ArrayList<String>();
		try{

			InputStream input = new FileInputStream(filepathAndName);

			int rslt=0;
			if(filepathAndName.contains(".xlsx"))
			{

				XSSFWorkbook wb = new XSSFWorkbook(input);

				int i=0,j=0;


				for(XSSFSheet sheet: wb)
				{

					Row row=sheet.getRow(rowIndex);

					for(j=0;j<row.getLastCellNum();j++)
					{
						Cell cell = row.getCell(j, Row.RETURN_NULL_AND_BLANK);
						if (cell == null)
							alist.add("NULL VALUE");
						else if("".equals(cell.getStringCellValue().trim()))
							alist.add(" ");
						else 
							alist.add(cell.getStringCellValue());


					}

				}

				input.close();
				wb.close();

			}
			else if(filepathAndName.contains(".xls"))
			{
				InputStream input_Xls = new FileInputStream(filepathAndName);
				HSSFWorkbook wb1 = new HSSFWorkbook(input_Xls);
				int sheets = wb1.getNumberOfSheets();
				int j=0,i=0;
				for(int a=0;a<sheets;a++)
				{
					HSSFSheet sheet = wb1.getSheetAt(a);

					for (i=0;i<sheet.getLastRowNum();i++) 
					{
						Row row=sheet.getRow(rowIndex);

						for(j=0;j<row.getLastCellNum();j++)
						{

							Cell cell = row.getCell(j, Row.RETURN_NULL_AND_BLANK);
							if (cell == null)
								alist.add("NULL VALUE");
							else if("".equals(cell.getStringCellValue().trim()))
								alist.add(" ");
							else 
								alist.add(cell.getStringCellValue());

						}

					}


				}

				input_Xls.close();

				wb1.close();
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alist;

	}

	public ArrayList<String> GetNodePathPart_CustomerStories(List<String> list){
		ArrayList<String> alist=new ArrayList<String>();
		String nodePath ="";

		for(int i=0;i<list.size();i++){
			String value=list.get(i).toString();
			//System.out.println("Value:++++++++++++"+value);

			if(value.contains("<strong>")){
				value=value.replaceAll("<strong>", "");
			}

			if(value.contains("</strong>")){
				value=value.replaceAll("</strong>", "");
			}

			if(value.contains("<br>")){
				value=value.replaceAll("<br>", "");
			}

			if(value.contains(" ")){
				value=value.replaceAll(" ", "_");
			}

			if(value.length()>=20){
				nodePath= value.substring(0, 20);
				//System.out.println(nodePath);
			}

			nodePath=nodePath.toLowerCase();
			alist.add(nodePath);

		}
		for(int j=0;j<alist.size();j++){
			//System.out.println("************************"+alist.get(j).toString());
		}

		return alist;
	}

	public ArrayList<String> GetNodePathPart_CustomerStoriesDev(List<String> list){
		ArrayList<String> alist=new ArrayList<String>();
		String nodePath ="";

		for(int i=0;i<list.size();i++){
			String value=list.get(i).toString();
			//System.out.println("Value:++++++++++++"+value);

			if(value.contains(" ")){
				value=value.replaceAll(" ", "_");
			}

			/*if(value.length()>=20){
				nodePath= value.substring(0, 20);
				//System.out.println(nodePath);
			}
			 */
			nodePath=nodePath.toLowerCase();
			alist.add(nodePath);

		}
		/*for(int j=0;j<alist.size();j++){
			//System.out.println("************************"+alist.get(j).toString());
		}*/

		return alist;
	}

	public  String genPath(String value){
		
		if(value.contains("English"))
		{
			value=value.trim().replace("English", "en");
		}
		
		if(value.contains("Deutsch"))
		{
			value=value.trim().replace("Deutsch", "de");
		}
		
		if(value.contains("Français"))
		{
			value=value.trim().replace("Français", "fr");
		}
		
		if(value.contains("Japanese"))
		{
			value=value.trim().replace("Japanese", "jp");
		}
		
		if(value.contains("Chinese (simplified)"))
		{
			value=value.trim().replace("Chinese (simplified)", "cn");
		}
		
		if(value.contains("Brazil"))
		{
			value=value.trim().replace("Brazil", "br");
		}
		
		if(value.contains("Latam"))
		{
			value=value.trim().replace("Latam", "latam");
		}
		
		if(value.contains("Latam"))
		{
			value=value.trim().replace("Latam", "latam");
		}
		
		if(value.contains(" "))
		{
			value=value.trim().replace(" ", "_");
			//value=value.trim().replace(" ", "-");
		}
		if(value.contains("á"))
		{
			value=value.trim().replace("á", "");
		}
		if(value.contains("/"))
		{
			value=value.trim().replace("/", "%2F");
		}
		if(value.contains("*"))
		{
			value=value.trim().replace("\\*", "%2A");
		}
		if(value.contains("\t"))
		{
			value=value.trim().replace("\t", "");
		}
		if(value.contains(","))
		{
			value=value.replace(",","");
			
		}
		if(value.contains("."))
		{
			value=value.replace(".", "");
		}
		return value.trim();
	}

	public void getEntireRow(ArrayList<String> inputList){

	}

	public static void main(String args[])
	{
		try {
			/*ArrayList<String> cmnt = new ArrayList<String>();
			cmnt.add("Comments");
			ArrayList<String> Result = new ArrayList<String>();
			Result.add("Result");*/
			//writeToExcelResultAndComments("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx",Result);
			//writeToExcelResultAndComments("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx",cmnt);
			 /*ArrayList<String> data=test("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx");

			 for(int i=0;i<data.size();i++)
			 {
				 System.out.println("value is:"+data.get(i));
			 }
			 System.out.println("size is:"+data.size());

			ArrayList<String> colNames = getExcelSheetColumnValues("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx", 0); // get Column Names    

			HashMap<String,String[]> listOfLists =readColumnValues("W:\\Data\\ZeusLAMP\\Customerstories_updated.xlsx",colNames);

			System.out.println("listoflist size:"+listOfLists.size());

			List<String> jcr_component = new ArrayList<String>();
			 for(int d=0;d<listOfLists.get(colNames.get(0)).length;d++)
			 {

				 System.out.println(genPath(listOfLists.get("name")[d])+"_"+genPath(listOfLists.get("language")[d])+"_"+genPath(listOfLists.get("language_displayed_name")[d])+"_"+genPath(listOfLists.get("story_id")[d]));
				 //System.out.println(listOfLists.get(1)[d]+"_"+listOfLists.get(colNames.indexOf(2))[d]+"_"+"_"+listOfLists.get(0)[d]);
				 //jcr_component.add(listOfLists.get(colNames.indexOf("name"))[d]+"_"+listOfLists.get(colNames.indexOf("language"))[d]+"_"+listOfLists.get(colNames.indexOf("language_displayed_name"))[d]+"_"+listOfLists.get(colNames.indexOf("story_id"))[d]);
			 }

			for(String s : listOfLists.get(colNames.get(4)))
			 System.out.println(s);*/

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}



	public  void navigate(String key,String constantsFile){

		try{
			String x= key.replace(' ','_');
			System.out.println("x="+x);
			
			
			if(oASelFW.driver.findElements(By.xpath("//div[@title='"+key.trim()+"']")).size()>0)
			{
				oASelFW.driver.findElement(By.xpath("//div[@title='"+key.trim()+"']")).click();
				Thread.sleep(5000);
				if(getValuesFromPropertiesFile(constantsFile,x)!= null)
				{
					if(getValuesFromPropertiesFile(constantsFile,x).length()>0)
					{
						String[] menu =getValuesFromPropertiesFile(constantsFile,x).split(",");
						verifyMenu(menu);
						for(int j=0;j<menu.length;j++)
						{
							//oASelFW.effecta("verifyElementPresent","//div[@title='"+menu[j]+"']",menu[j]);
							if(oASelFW.driver.findElements(By.xpath("//div[@title='"+menu[j]+"']")).size()>0)
							{
								//System.out.println("In Before click");
								//oASelFW.effecta("click","//div[@title='"+menu[j]+"']",menu[j]);
								navigate(menu[j],constantsFile);
							}
							else
							{

							}

						}
					}
				}
			}

		}catch(Exception e){
			//e.printStackTrace();
		}


	}
	/*public  void verifyList(String[] excelList, String[] pageList)
	{
		int count=0;
		for(int i=0;i<pageList.length;i++)
		{
			for(int j=0;j<excelList.length;j++)
			{
				if(pageList[i].trim().equalsIgnoreCase(excelList[j]))
				{
					count++;
					break;
				}
			}
			if(count>0)
			{
				System.out.println(pageList[i]+" Pass");
			}
		}
	}*/

	public  void verifyMenu(String[] pageList)
	{
		try{
			Thread.sleep(6000);
			for(int i=0;i<pageList.length;i++)
			{
				String URL=oASelFW.driver.getCurrentUrl();
				System.out.println("URL:"+URL);
				String path[]=URL.split("content/");
				String[] ss= path[1].split("/", 2);
				
				if(oASelFW.driver.findElements(By.xpath("//div[@title='"+pageList[i]+"']")).size()>0)
				{
					oASelFW.effecta("sendReportWithOutExit","Validating whether "+pageList[i]+" is Available under "+ss[1],"Successfully validated "+pageList[i]+" Under:"+ss[1],"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validating whether "+pageList[i]+" is Available under "+ss[1],"Item "+pageList[i]+" not found Under:"+ss[1],"Fail");
				}
				
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}
	
	public  void verifyMenu2(String[] pageList)
	{
		try{
			//Thread.sleep(10000);
			for(int i=0;i<pageList.length;i++)
			{
				String URL=oASelFW.driver.getCurrentUrl();
				//System.out.println("URL:"+URL);
				String path[]=URL.split(".html/");
				//String[] ss= path[1].split("/", 2);
				
				//String[] ss=URL.split("content");
				
				if(oASelFW.driver.findElements(By.xpath("//div[@title='"+pageList[i]+"']")).size()>0)
				{
					oASelFW.effecta("sendReportWithOutExit","Validating whether "+pageList[i]+" is Available under "+path[1],"Successfully validated "+pageList[i]+" Under:"+path[1],"Pass");
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validating whether "+pageList[i]+" is Available under "+path[1],"Item "+pageList[i]+" not found Under:"+path[1],"Fail");
				}
				
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}
	
	
	
	// Write into Excel file adding the rows
	
	public void writeToExcelResultAndComments(String filepathAndName, ArrayList<String> jcr) throws IOException 
	{
		try{

			
			System.out.println(jcr);
			System.out.println(jcr.size());
			
			
			
			if(filepathAndName.contains(".xlsx"))
			{
				InputStream input = new FileInputStream(filepathAndName);
				XSSFWorkbook wb = new XSSFWorkbook(input);

				for(XSSFSheet sheet: wb)
				{
					Row row=sheet.getRow(0);
					int col = row.getLastCellNum();
					System.out.println(col);
					
					for (int i=0;i<jcr.size();i++) 
					{
						
						row=sheet.getRow(i);

						System.out.println(jcr.get(i));
						
						if(jcr.get(i)!=null)
						{
							
							
							row.createCell(col).setCellValue(jcr.get(i));
						}
						else
							row.createCell(col).setCellValue(" ");
					}    
				}
				input.close();
				FileOutputStream output_file =new FileOutputStream(new File(filepathAndName));  //Open FileOutputStream to write updates

				wb.write(output_file); //write changes

				output_file.close();  //close the stream

				wb.close();
			}
			/*else if(filepathAndName.contains(".xls"))
			{
				InputStream input = new FileInputStream(filepathAndName);
				HSSFWorkbook wb1 = new HSSFWorkbook(input);
				int sheets = wb1.getNumberOfSheets();
				for(int i=0;i<sheets;i++)
				{
					HSSFSheet sheet = wb1.getSheetAt(i);

					for (int j=rownum;j<sheet.getLastRowNum();j++) 
					{
						Row row=sheet.getRow(i);
						Cell cell = row.getCell(colnum);

						cell.setCellValue(sdp.get(i-rownum));	

						cell = row.getCell(colnum+1);
						cell.setCellValue(subad.get(i-rownum));	

						cell = row.getCell(colnum+2);
						cell.setCellValue(autoupprice.get(i-rownum));	

					}    
				}
				input.close();
				FileOutputStream output_file =new FileOutputStream(new File(filepathAndName));  //Open FileOutputStream to write updates

				wb1.write(output_file); //write changes

				output_file.close();

				wb1.close();
			}
*/

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	

	public String UTILITY_GET_VALUES_FROM_PROP_FILE(String propertiesFileName,String key)
	{
		try
		{
		
		FileInputStream fis = new FileInputStream(new File(oASelFW.sAutomationPath+oASelFW.sProjectName+"\\Constants\\"+propertiesFileName+".properties"));
		Properties prop=new Properties();
		prop.load(fis);
		return prop.get(key).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	


}