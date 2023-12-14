package com.framework.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static Sheet sheet;

	static Map<String, Map<String, String>> rowData = new HashMap<String, Map<String, String>>();

	public static void initializeExcel() {
		Workbook wbook;
		try {
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\OrangeHRM_TestData.xlsx";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			if (path.endsWith(".xlsx")) {
				wbook = new XSSFWorkbook(fis);
			} else {
				wbook = new HSSFWorkbook(fis);
			}

			sheet = wbook.getSheet("TestData");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readAllDataFromExcel() {

		for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {
			String testName = sheet.getRow(rowCount).getCell(0).getStringCellValue();

			Map<String, String> cellData = new HashMap<String, String>();
			for (int cellCount = 1; cellCount < sheet.getRow(rowCount).getLastCellNum(); cellCount++) {
				String key = sheet.getRow(0).getCell(cellCount).getStringCellValue();
				Cell cell = sheet.getRow(rowCount).getCell(cellCount, Row.RETURN_BLANK_AS_NULL);
				String value;
				if (cell != null) {
					value = sheet.getRow(rowCount).getCell(cellCount).getStringCellValue();
				} else {
					value = "";
				}

				cellData.put(key, value);

			}
			rowData.put(testName, cellData);

		}

	}

	public static String readData(String testName, String colName) {

		return rowData.get(testName).get(colName);

	}

	public static void main(String args[]) {
		initializeExcel();
		readAllDataFromExcel();

		System.out.println(readData("loginWithBlankPassword", "Username"));
		System.out.println(readData("VerifyAddEmployee", "Password"));

	}
}
