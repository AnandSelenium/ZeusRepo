package classes.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.lampdatamigration.RetrieveNode;

public class NavigationExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Properties prop = new Properties();
			prop.load(RetrieveNode.class.getClassLoader().getResourceAsStream("Constants//constant.properties"));

			System.out.println("****************************************");

			String lev = prop.getProperty("Assets");
			String[] level1=lev.split(",");
			for(int i=0;i<level1.length;i++)
			{
				navigate(level1[i]);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void navigate(String key)
	{
		try
		{
			Properties prop = new Properties();
			prop.load(RetrieveNode.class.getClassLoader().getResourceAsStream("Constants//constant.properties"));
			if(prop.getProperty(key).length()>0)	
			{
				String[] menu = prop.getProperty(key).split(",");
				
				
			}
			else
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public static void verifyList(String[] excelList, String[] pageList)
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
	}
	
	public static void verifyMenu(String[] pageList)
	{
		
		for(int i=0;i<pageList.length;i++)
		{
			//if()
		}
	}
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
							if(cell.getStringCellValue().trim().equalsIgnoreCase(columnNames.get(c)))
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

							alist.add(String.valueOf((int) cell.getNumericCellValue()));
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
							if(cell.getStringCellValue().trim().equalsIgnoreCase(columnNames.get(c)))
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
						if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
						{
							if (cell == null)
								alist.add("NULL VALUE");
							else 
								alist.add(String.valueOf((int)cell.getNumericCellValue()));
						}

						else if(cell.getCellType()==cell.CELL_TYPE_STRING)
						{
							if (cell == null)
								alist.add("NULL VALUE");

							else if("".equals(cell.getStringCellValue().trim()))
								alist.add(" ");
							else 
								alist.add(cell.getStringCellValue());
						}
					}
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
}
