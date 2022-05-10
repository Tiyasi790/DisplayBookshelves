package Write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	/******* variables declaration *******/
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	
	//Writing first 3 serach from 
	public static void output(String[] sname, String[] sprice) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output");
		for (int i = 0; i < 3; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(sname[i]);
			row.createCell(1).setCellValue(sprice[i]);
		}
		sheet.autoSizeColumn(0);
		
		/******* Writing the output to Excel file using FileOutputStream *******/
		try {
			fos = new FileOutputStream("./Excels/output.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//writing details of study chairs in excel sheet
	public static void output1(String[] cname, String[] cprice) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output1");
		for (int i = 0; i < 3; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(cname[i]);
			row.createCell(1).setCellValue(cprice[i]);
		}
		sheet.autoSizeColumn(0);
		/******* Writing the output to Excel file using FileOutputStream *******/
		try {
			fos = new FileOutputStream("./Excels/output1.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//writing all items from "all furniture' section in excel sheet
	
	public static void output2(String[] prodname){
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output2");

		for (int i = 0; i < 6; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(prodname[i]);
		}
		sheet.autoSizeColumn(0);
		/******* Writing the output to Excel file using FileOutputStream *******/
		try {
			fos = new FileOutputStream("./Excels/output2.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
