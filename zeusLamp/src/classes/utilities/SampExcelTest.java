package classes.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampExcelTest {

	public static void main(String ar[]){

		try{
			FileInputStream fileInputStream = new FileInputStream("D:\\ExcelTest.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = wb.getSheetAt(0);

			int totalrows=sheet.getLastRowNum();
			//System.out.println("Total no.of rows are" +totalrows);
			int x=0;
			int  y=0;
			int rslt =0;
			for(int i=0;i<totalrows; i++)
			{
				XSSFRow row1=sheet.getRow(i);
				Cell cell = row1.getCell(0,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);
				if(cell.getCellType()==cell.CELL_TYPE_STRING)
				{
					if (cell.getStringCellValue() != null &&  cell.getStringCellValue().length() != 0)
					{
						if(cell.getStringCellValue().trim().contains("India"))
						{
							x=i;
							System.out.println("India:" +cell.getStringCellValue().trim());
						}
						else
						{
							y=i;
							break;
						}

						if(rslt>0)
							break;
					}	
				}

				/*XSSFCell country=row1.getCell(0,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK );

				String cellValueStr=country.toString();



				if(cellValueStr.contains("India")){

					x=i;
					//System.out.println("The value of x:"+x);
					rslt++;
				}
				else if()
				{
					rslt++;
					y=i;
				}

				if(rslt>1 ){
					break;
					//System.out.println("The value of y:"+y);
				}
				//break;
*/			}

			ArrayList<String> alist = new ArrayList<String>();
			for(int k=x+1;k<=y-1;k++)
			{
				XSSFRow row1=sheet.getRow(k);
				//XSSFCell country=row1.getCell(0);
				Cell cell = row1.getCell(1, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);
				if(cell.getCellType()==cell.CELL_TYPE_STRING)
				{
					if (cell.getStringCellValue() != null &&  cell.getStringCellValue().length() != 0)
					{
						System.out.println("states are:" +cell.getStringCellValue().trim());
						alist.add(cell.getStringCellValue().trim());
					}	
				}
			}
			System.out.println("Array List size:"+alist.size());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
