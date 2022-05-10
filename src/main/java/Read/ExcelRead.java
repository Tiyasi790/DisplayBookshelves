package Read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
	public static String[] receiver = new String[2];	
	static DataFormatter formatter = new DataFormatter();
	
	public static String[] readrecData(String fileName) throws IOException{
		
		File file= new File("./Excels/input.xlsx");
		FileInputStream fis= new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("recipient");
		XSSFRow row=ws.getRow(0);
		for(int colNo=0;colNo<=1;colNo++)
		{
			receiver[colNo]=formatter.formatCellValue(row.getCell(colNo));
		}
		return receiver;
	}
	public static String[] sender = new String[3];
    
	public static String[] readsendData(String fileName) throws IOException{
		
		File file= new File("./Excels/input.xlsx");
		FileInputStream fis= new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("sender");
		
		XSSFRow row=ws.getRow(0);
		for(int colNo=0;colNo<=2;colNo++)
		{
			sender[colNo]=formatter.formatCellValue(row.getCell(colNo));
		}
		return sender;
	}
	

}
