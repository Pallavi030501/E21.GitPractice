package genericUtilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic methods related to file operations.
 * @author SANKET
 * 
 * 
 */

public class FileUtility
{
	/**
	 * This method will read data from property file and return value to caller
	 * @param key
	 * @return  value
	 * @throws IOException
	 */


	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p =new Properties();
		p.load(fis);
		String value =p.getProperty(key);
		return value;
	}
	
	/**
	 * This method will read string data from the given row and cell and return the value to caller
	 * @param sheetName
	 * @param rowno
	 * @param cellno
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value =wb.getSheet(sheetName).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;

	}
	/**
	 * This method will read numeric  data from excel the sheet
	 * @param sheetName
	 * @param rowno
	 * @param cellno
	 * @return numValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  double readNumericDataFromExcelFile(String sheetName,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		double numValue =wb.getSheet("Products").getRow(1).getCell(2).getNumericCellValue();
		return numValue;

	}
	

}
