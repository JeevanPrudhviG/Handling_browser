

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData 
{
	public static String getUrl()throws Exception 
	{
		//Creating a FileInputStream class to read data from the Excel
		FileInputStream file =new FileInputStream("C:\\Users\\2318831\\eclipse-workspace\\seleniumprudhvi\\src\\test\\java\\miniProjectBrowserWindows\\testData\\ExcelProjectData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String input =  cell.toString();
		wb.close();
		return input;
	}
}
