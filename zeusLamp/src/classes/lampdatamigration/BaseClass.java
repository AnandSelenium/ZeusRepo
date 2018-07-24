package classes.lampdatamigration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jcr.LoginException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.jackrabbit.commons.JcrUtils;

import classes.utilities.UtilityMethods;

import com.arsin.ArsinSeleniumAPI;

public class BaseClass {
	ArsinSeleniumAPI oASelFW;
	public BaseClass(){

	}

	public BaseClass(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}

	public String getNodePath(String fileName) throws BiffException, IOException{

		Properties prop1 = new Properties();

		//prop1.load(RetrieveNode.class.getClassLoader().getResourceAsStream("sharath_poc//config.properties"));
		prop1.load(RetrieveNode.class.getClassLoader().getResourceAsStream("scripts//lampdatamigration//config.properties"));

		//String filePath = prop1.getProperty("FilePath");
		File filepath=new File(oASelFW.sAutomationPath+"Data"+oASelFW.sProjectName+File.separator);
		//String fileName = prop1.getProperty("FileName_CustomerStories");
		String file=filepath+fileName;
		FileInputStream inputStream = new FileInputStream(new File(file));

		//Workbook workbook = Workbook.getWorkbook(new File(filePath));
		Workbook workbook = Workbook.getWorkbook(inputStream);
		String sysdesc  = workbook.getSheet(0).getCell(2,2).getContents();
		String category  = workbook.getSheet(0).getCell(3,2).getContents();

		String part2 = category.toLowerCase().replace(' ', '-')+ "-"+sysdesc.toLowerCase().replace(' ', '-') ; 
		String part1 = "/content/lamp-new/vmmarkRow/";
		String part3 = "/jcr:content/par/text";

		String nodePath = part1+part2+part3;

		System.out.println("Node Path Part2: first :"+category);
		System.out.println("Node Path Part2: second :"+sysdesc);
		System.out.println("Node Path:"+nodePath);
		return nodePath;

	}

	public Session getSession() throws IOException, LoginException, NoSuchWorkspaceException, RepositoryException{

		Properties prop = new Properties();
		prop.load(RetrieveNode.class.getClassLoader().getResourceAsStream("scripts//lampdatamigration//config.properties"));

		System.out.println("****************************************");

		/*String name = prop.getProperty("Username");
		String pwd = prop.getProperty("Password");*/

		String name = "gkonnur";
		String pwd = "W@lc0me@";

		System.out.println("username:" +name);
		System.out.println("password:" +pwd);

		String REPO = prop.getProperty("REPO");
		String WORKSPACE = prop.getProperty("WORKSPACE");


		Repository repository = JcrUtils.getRepository("http://aem-test-auth-1.vmware.com:8080/crx/server");
		//Repository repository = JcrUtils.getRepository("http://aem-dev-auth-1.vmware.com:8080/crx/server");
		Session session = repository.login(new SimpleCredentials(name, pwd.toCharArray()),WORKSPACE);//WORKSPACE

		return session;
	}

	public void closeSession(Session s){

		s.logout();
	}

	public MultiMap getPropertyMapa(Node n1){

		MultiMap mapa = new MultiValueMap();
		String tr="";
		try{
			PropertyIterator i1 = n1.getProperties();
			while(i1.hasNext()){
				Property p1 = i1.nextProperty();
				//System.out.println("Property Name:"+ p1.getProperty().getString());
				tr="";
				if(p1.isMultiple())
				{
					System.out.println("This prop:" +p1.getName()+ " has multiple values. So, printing it below:");
					Value[] a1 =  p1.getValues();
					
					
					for (int j=0;j<a1.length;j++){

						System.out.println("Hi");
						//System.out.println(a1[j].getString());
						if(j!=0)
						{
							tr=tr+","+a1[j].getString();
						}
						else
						{
							tr=tr+a1[j].getString();
						}

					}
					 System.out.println(tr);
					mapa.put(p1.getName(), tr);

					//System.out.println("--------------------------------------");
				}
				else
				{
					/*System.out.println("prop name:"+ p1.getName());
					System.out.println("prop value:"+ p1.getValue().getString());
					System.out.println("--------------------------------------");*/
					mapa.put(p1.getName(), p1.getValue().getString());	
				}
			}



		}
		catch (RepositoryException e1){
			e1.printStackTrace();
		}

		return mapa;

	}
	public boolean validateProperty(MultiMap m1, String propName1, String propValue1){

		boolean b1=false;		
		try{
			String propValue =propValue1.replaceAll("/[^A-Za-z0-9 ]/","").trim();
			String propName = propName1.replaceAll("/[^A-Za-z0-9 ]/","").trim();
			//System.out.println("PropValue:- "+propName);
			//System.out.println("PropName:- "+propName);




			if(m1.get(propName1) != null)
			{

				List<String> lowerList = (List<String>) m1.get(propName1);

				if(lowerList.size()>0)
				{	

					b1  = lowerList.contains(propValue);
					//System.out.println("value of b1:" +b1);


					/*if(b1){

						oASelFW.effecta("sendReport","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Successfully Verified.Property Name:"+propName+"Property Value:"+propValue,"Pass");
					}else{

						oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Unable to Verify value for Property:"+"\""+propName+"\"" +"Displyed Value in Excel is:"+lowerList.get(0),"Pass");
					}
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Unable  to Verify Property:"+"\""+propName+"\""+" as the property is not available in JCR repository","Pass");
				}

			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Unable  to Verify Property:"+"\""+propName+"\""+" as the property is not available in JCR repository","Pass");

			}*/
					String c= lowerList.get(0).replaceAll("/[^A-Za-z0-9 ]/","").trim().replaceAll("", "");
					/*if(b1){

						oASelFW.effecta("sendReport","Validating Excel Data with JCR Content for " +propName+" Property","Successfully Verified.Property Name:"+propName+"Property Value:"+propValue,"Pass");
					}else{

						oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +propName+" Property","Unable to Verify value for Property:"+propName+"Displyed Value in Excel is:"+c,"Pass");
					}
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for "+propName+" Property","Unable  to Verify Property:"+propName+" as the property is not available in JCR repository","Pass");
				}

			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +propName+" Property","Unable  to Verify Property:"+propName+" as the property is not available in JCR repository","Pass");

			}*/

					if(b1){

						oASelFW.effecta("sendReport","Validating Excel Data with JCR Content for " +propName+" Property","Successfully Verified.Property Name:"+propName,"Pass");
					}else{

						oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +propName+" Property","Unable to Verify value for Property:"+propName,"Pass");
					}
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for "+propName+" Property","Unable  to Verify Property:"+propName+" as the property is not available in JCR repository","Pass");
				}

			}
			else
			{
				oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +propName+" Property","Unable  to Verify Property:"+propName+" as the property is not available in JCR repository","Pass");

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}

		/*try{

			propValue = propValue.trim().replace("<strong>", "").trim().replace("</strong>","").trim().replace("<br>","").trim().replace("</br>","").trim().replace("<I>", "").trim().replace("</I>", "").trim().replace("\"", "").trim();
			System.out.println("&&&"+propValue);
			if(m1.get(propName) != null)
			{

				List<String> lowerList = (List<String>) m1.get(propName);

				String myString = new String(theBytes,"iso-8859-1"); 
				if(lowerList.size()>0)
				{	


					b1  = lowerList.contains(propValue);
					if(b1){

						oASelFW.effecta("sendReport","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Successfully Verified.Property Name:"+propName+"Property Value:"+propValue,"Pass");
					}else{

						oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Unable to Verify value for Property:"+"\""+propName+"\"" +"Displyed Value in Excel is:"+propValue+"But value in JCR is:"+lowerList.get(0),"Pass");
					}
				}
				else
				{
					oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for " +"\""+propName+"\"" +" Property","Unable  to Verify Property:"+"\""+propName+"\""+" as the property is not available in JCR repository","Pass");
				}

			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}*/
		return b1;

	}

	public Node getRelativeNode(Session s2, String relativeNodePath) throws RepositoryException{
		Node n3=null;
		try{
			Node root = s2.getRootNode();
			n3 = root.getNode(relativeNodePath);
		}catch(Exception e)
		{

		}
		return n3;

	}	

	public static String bytesToHex(String s) {
		if (s == null) return "null";
		byte[] bytes = s.getBytes();
		final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return "x'" + new String(hexChars) + "'";
	}

	public String removeNonUtf8(String nonUtf8String)
	{
		String utf8tweet = "";
		try {
			byte[] utf8Bytes = nonUtf8String.getBytes("UTF-8");

			utf8tweet = new String(utf8Bytes, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Pattern unicodeOutliers = Pattern.compile("[^\\x00-\\x7F]",
				Pattern.UNICODE_CASE | Pattern.CANON_EQ
				| Pattern.CASE_INSENSITIVE);
		Matcher unicodeOutlierMatcher = unicodeOutliers.matcher(utf8tweet);
		utf8tweet = unicodeOutlierMatcher.replaceAll(" ");
		System.out.println("After: " + utf8tweet.trim());
		return utf8tweet.trim();
	}

	public String validateProperty1(MultiMap m1, String propName1, String propValue1){

		String result="";
		boolean b1=false;		
		try{
			/*String propValue =propValue1.replaceAll("/[^A-Za-z0-9 ]/","").trim();
			String propName = propName1.replaceAll("/[^A-Za-z0-9 ]/","").trim();*/
			//System.out.println("PropValue:- "+propName);
			//System.out.println("PropName:- "+propName);
			String propName2;
			if(propName1.trim().equalsIgnoreCase("Name"))
			{
				propValue1 = propValue1.replaceAll(" ","_");
			}

			/*if(propName1.trim().equalsIgnoreCase("StoryID"))
			{
				float propval=Float.valueOf(propValue1);
				propValue1=Float.toString(propval);
			}*/

			if((m1.get(propName1) != null) && (propValue1.length()>=1) && (!propValue1.equalsIgnoreCase("NULL VALUE")) && (!propValue1.equalsIgnoreCase(" ")))
			{

				propName2=propName1.trim();
				String propValue2=propValue1.trim();


				List<String> lowerList = (List<String>) m1.get(propName2);


				if(lowerList.size()>0)
				{	

					//b1  = lowerList.contains(propValue2);

					for(int y=0;y<lowerList.size();y++)
					{
						if(propName1.trim().equalsIgnoreCase("date"))
						{

	
							if(lowerList.get(y).trim().contains(isValidDate(propValue2)))
								b1=true;

						}
						
					
						if(lowerList.get(y).trim().equalsIgnoreCase(propValue1.trim()))
						{
							b1=true;
							break;
						}
					}
					if(b1){
						result=result+"(value Found and matched for "+propName2+": "+lowerList.get(0).trim()+")"+";";
						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Successfully Verified","Pass");
					}
					else
					{
						result=result+"(value mismatch for "+propName2+": "+lowerList.get(0).trim()+" Expected value: "+propValue2+ ")"+";";

						System.out.println("from map:"+lowerList.get(0).trim());
						System.out.println("-------------------------------------------------------------");
						System.out.println("Excel Data"+propValue2);
						/*System.out.println("Excel Data:"+propValue2+"test");
						System.out.println("JCR DATA:"+lowerList.get(0).trim()+"test");*/


						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for Property:"+propName,"Value Mismatch","PASS");
					}
				}
				else{
					result=result+"(value is empty/null in JCR for: "+propName1+")"+";";
					//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Contentfor property:"+propName,"Unable to Verify as the property value is displayed as empty JCR repository","PASS");
				}
			}
			else
			{
				result=result+"(Property not found in JCR: "+propName1+")"+";";
				//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Unable  to Verify  as the property"+propName+" is not available in JCR repository","PASS");

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public String validateProperty_TechPapers(MultiMap m1, String propName1, String propValue1){

		String result="";
		boolean b1=false;		
		try{


			/*String propValue =propValue1.replaceAll("/[^A-Za-z0-9 ]/","").trim();
			String propName = propName1.replaceAll("/[^A-Za-z0-9 ]/","").trim();*/
			//System.out.println("PropValue:- "+propName);
			//System.out.println("PropName:- "+propName);
			String propName2;
			if(propName1.trim().equalsIgnoreCase("Name"))
			{
				propValue1 = propValue1.replaceAll(" ","_");
			}

			/*if(propName1.trim().equalsIgnoreCase("tprevisiondate"))
			{
				propValue1 = propValue1.replaceAll(" ","T");
				System.out.println("Space Replaced in date and time........"+propValue1);
			}*/

			//***********************

			/*String previsionDate=(String) m1.get("tprevisiondate");
			previsionDate=previsionDate.substring(0, 9);*/



			//****************************

			if((m1.get(propName1) != null) && (propValue1.length()>=1) && (!propValue1.equalsIgnoreCase("NULL VALUE")) && (!propValue1.equalsIgnoreCase(" ")))
			{
				propName2=propName1.trim();
				String propValue2=propValue1.trim();

				List<String> lowerList = (List<String>) m1.get(propName2);

				if(lowerList.size()>0)
				{	

					//b1  = lowerList.contains(propValue2);

					for(int y=0;y<lowerList.size();y++)
					{
						if(propName1.trim().equalsIgnoreCase("tprevisiondate"))
						{

							/* DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							if(propValue1.contains("AM")|| propValue1.contains("PM"))
							{
								String formattedDate = targetFormat.format(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").parse(propValue1)).trim().replace(" ", "T").trim();
								String formattedDate1 = targetFormat.format(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").parse(propValue1)).trim().replace(" ", "T").trim();
								String formattedDate2 = targetFormat.format(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").parse(propValue1)).trim().replace(" ", "T").trim();

								if(lowerList.get(y).trim().contains(formattedDate) || lowerList.get(y).trim().contains(formattedDate1) || lowerList.get(y).trim().contains(formattedDate2))
								{
									b1=true;
									break;
								}
							}
							else
							{
								String formattedDate="";
								if(isValidDate(propValue1.trim()))
								{
									formattedDate= propValue1.trim().trim().replace(" ", "T").trim();
								}
								String formattedDate1 = targetFormat.format(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").parse(propValue1)).trim().replace(" ", "T").trim();
								String formattedDate2 = targetFormat.format(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(propValue1)).trim().replace(" ", "T").trim();
								String formattedDate3 = targetFormat.format(new SimpleDateFormat("yyyy-dd-MM hh:mm:ss").parse(propValue1)).trim().replace(" ", "T").trim();

								if(lowerList.get(y).trim().contains(formattedDate) || lowerList.get(y).trim().contains(formattedDate1) || lowerList.get(y).trim().contains(formattedDate2) || lowerList.get(y).trim().contains(formattedDate3))
								{
									b1=true;

									break;
								}
							}						

							 */
							if(lowerList.get(y).trim().contains(isValidDate(propValue2)))
								b1=true;

						}
						else if(lowerList.get(y).trim().equalsIgnoreCase(propValue1.trim()))
						{
							b1=true;
							break;
						}

					}
					if(b1){
						result=result+"(value Found and matched for "+propName2+": "+lowerList.get(0).trim()+")"+";";

					}
					else
					{
						result=result+"(value mismatch for "+propName2+": "+lowerList.get(0).trim()+" Expected value: "+propValue2+ ")"+";";

						System.out.println("from map:"+lowerList.get(0).trim());
						System.out.println("-------------------------------------------------------------");
						System.out.println("Excel Data"+propValue2);
						/*System.out.println("Excel Data:"+propValue2+"test");
						System.out.println("JCR DATA:"+lowerList.get(0).trim()+"test");*/


						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for Property:"+propName,"Value Mismatch","PASS");
					}
				}
				else{
					result=result+"(value is empty/null in JCR for: "+propName1+")"+";";
					//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Contentfor property:"+propName,"Unable to Verify as the property value is displayed as empty JCR repository","PASS");
				}
			}
			else
			{
				result=result+"(Property not found in JCR: "+propName1+")"+";";
				//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Unable  to Verify  as the property"+propName+" is not available in JCR repository","PASS");

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public String validateProperty2(MultiMap m1, String propName1, String propValue1){

		String result="";
		boolean b1=false;		
		try{
			/*String propValue =propValue1.replaceAll("/[^A-Za-z0-9 ]/","").trim();
			String propName = propName1.replaceAll("/[^A-Za-z0-9 ]/","").trim();*/
			//System.out.println("PropValue:- "+propName);
			//System.out.println("PropName:- "+propName);
			
			
			ArrayList<String> cqfields = new ArrayList<String>();
			cqfields.add("cq:language");
			cqfields.add("cq:locale");
			cqfields.add("cq:status");
			cqfields.add("cq:country");
			cqfields.add("cq:campaign");
			cqfields.add("cq:solution");
			cqfields.add("cq:product");
			cqfields.add("cq:size");
			
			
		
			String propName2;
			if(propName1.trim().equalsIgnoreCase("Name"))
			{
				propValue1 = propValue1.replaceAll(" ","_");
			}

			/*if(propName1.trim().equalsIgnoreCase("StoryID"))
			{
				float propval=Float.valueOf(propValue1);
				propValue1=Float.toString(propval);
			}*/

			if((m1.get(propName1) != null) && (propValue1.length()>=1) && (!propValue1.equalsIgnoreCase("NULL VALUE")) && (!propValue1.equalsIgnoreCase(" ")))
			{

				propName2=propName1.trim();
				String propValue2=propValue1.trim();


				List<String> lowerList = (List<String>) m1.get(propName2);


				if(lowerList.size()>0)
				{	

					//b1  = lowerList.contains(propValue2);

					for(int y=0;y<lowerList.size();y++)
					{
						if(cqfields.contains(propName2))
						{
							if(lowerList.get(y).trim().contains(propValue1.trim()))
							{
								b1=true;
								break;
							}
							if(b1=true)
								break;
						}
						else if(lowerList.get(y).trim().equalsIgnoreCase(propValue1.trim()))
						{
							b1=true;
							break;
						}
					}
					if(b1){
						result=result+"(value Found and matched for "+propName2+": "+lowerList.get(0).trim()+")"+";";
						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Successfully Verified","Pass");
					}
					else
					{
						result=result+"(value mismatch for "+propName2+": "+lowerList.get(0).trim()+" Expected value: "+propValue2+ ")"+";";

						System.out.println("from map:"+lowerList.get(0).trim());
						System.out.println("-------------------------------------------------------------");
						System.out.println("Excel Data"+propValue2);
						/*System.out.println("Excel Data:"+propValue2+"test");
						System.out.println("JCR DATA:"+lowerList.get(0).trim()+"test");*/


						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for Property:"+propName,"Value Mismatch","PASS");
					}
				}
				else{
					result=result+"(value is empty/null in JCR for: "+propName1+")"+";";
					//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Contentfor property:"+propName,"Unable to Verify as the property value is displayed as empty JCR repository","PASS");
				}
			}
			else
			{
				result=result+"(Property not found in JCR: "+propName1+")"+";";
				//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Unable  to Verify  as the property"+propName+" is not available in JCR repository","PASS");

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	// Verify date format
	public static String isValidDate(String inDate) 
	{
		String[] dateFormats={"MM/dd/yyyy hh:mm:ss a","dd/MM/yyyy hh:mm:ss a","yyyy/MM/dd hh:mm:ss a","MM-dd-yyyy hh:mm:ss","dd-MM-yyyy hh:mm:ss","yyyy-dd-MM hh:mm:ss","yyyy-MM-dd HH:mm:ss"};
		String formattedDate="";
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<dateFormats.length;i++)
		{
			SimpleDateFormat sourceFormat = new SimpleDateFormat(dateFormats[i]);
			sourceFormat.setLenient(false);

			try {
				sourceFormat.parse(inDate.trim());
				formattedDate = targetFormat.format(new SimpleDateFormat(dateFormats[i]).parse(inDate)).trim().replace(" ", "T").trim();

			} catch (Exception pe) {
				continue;
			}
		}
		return formattedDate;

	}
	
	
	public String validateProperty3(MultiMap m1, String propName1, String propValue1){

		String result="";
		boolean b1=false;		
		try{
			/*String propValue =propValue1.replaceAll("/[^A-Za-z0-9 ]/","").trim();
			String propName = propName1.replaceAll("/[^A-Za-z0-9 ]/","").trim();*/
			//System.out.println("PropValue:- "+propName);
			//System.out.println("PropName:- "+propName);
			String propName2;
			if(propName1.trim().equalsIgnoreCase("Name"))
			{
				propValue1 = propValue1.replaceAll(" ","_");
			}

			/*if(propName1.trim().equalsIgnoreCase("StoryID"))
			{
				float propval=Float.valueOf(propValue1);
				propValue1=Float.toString(propval);
			}*/

			if((m1.get(propName1) != null) && (propValue1.length()>=1) && (!propValue1.equalsIgnoreCase("NULL VALUE")) && (!propValue1.equalsIgnoreCase(" ")))
			{

				propName2=propName1.trim();
				String propValue2=propValue1.trim();


				List<String> lowerList = (List<String>) m1.get(propName2);


				if(lowerList.size()>0)
				{	

					//b1  = lowerList.contains(propValue2);

					for(int y=0;y<lowerList.size();y++)
					{
						
						if(propName1.trim().equalsIgnoreCase("date"))
						{

	
							if(lowerList.get(y).trim().contains(isValidDate(propValue2)))
								b1=true;

						}
						
					
						if(lowerList.get(y).trim().equalsIgnoreCase(propValue1.trim()))
						{
							b1=true;
							break;
						}
					}
					if(b1){
						result=result+"(value Found and matched for "+propName2+": "+lowerList.get(0).trim()+")"+";";
						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Successfully Verified","Pass");
					}
					else
					{
						result=result+"(value mismatch for "+propName2+": "+lowerList.get(0).trim()+" Expected value: "+propValue2+ ")"+";";

						System.out.println("from map:"+lowerList.get(0).trim());
						System.out.println("-------------------------------------------------------------");
						System.out.println("Excel Data"+propValue2);
						/*System.out.println("Excel Data:"+propValue2+"test");
						System.out.println("JCR DATA:"+lowerList.get(0).trim()+"test");*/


						//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for Property:"+propName,"Value Mismatch","PASS");
					}
				}
				else{
					result=result+"(value is empty/null in JCR for: "+propName1+")"+";";
					//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Contentfor property:"+propName,"Unable to Verify as the property value is displayed as empty JCR repository","PASS");
				}
			}
			else
			{
				result=result+"(Property not found in JCR: "+propName1+")"+";";
				//oASelFW.effecta("sendReportWithOutExit","Validating Excel Data with JCR Content for property:"+propName,"Unable  to Verify  as the property"+propName+" is not available in JCR repository","PASS");

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	

}