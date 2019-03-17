package com.qa.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.base.BaseApi;

import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
public class ExcelUtil 
{
 
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelFile(String Path,String SheetName) throws FileNotFoundException 
	{
		
		FileInputStream ExcelFile = new FileInputStream(Path);
		try {
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int findRow (String TCName) {
	    for (Row row : ExcelWSheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(TCName)) {
	                    return row.getRowNum();  
	                }
	            }
	        }
	    }               
	    return -1;
	}
	//This method is to get the column number corresponding column name
		public static int findcolumn (String columnName) {
		        for (Cell cell : ExcelWSheet.getRow(0)) {
		            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
		                if (cell.getRichStringCellValue().getString().trim().equals(columnName)) {
		                    return cell.getColumnIndex();  
		                }
		        }
		    }               
		    return -1;
		}
		public static String getCellData(int RowNum, int ColNum) throws Exception{
			try{
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;
			}catch (Exception e){
				return"";
			}
		}
}