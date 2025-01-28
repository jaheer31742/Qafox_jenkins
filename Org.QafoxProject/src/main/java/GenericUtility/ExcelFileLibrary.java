package GenericUtility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Provides Reusable Method To Perform CRUD In Excel FIle
 * 
 * @author Jaheer
 **/

public class ExcelFileLibrary {
	FileInputStream fis;
	FileOutputStream fos;
	Workbook wb;
	DataFormatter df;

	/**
	 * This Method used To Fetch The Single Data From Excel File
	 * 
	 * @param sheet  Name
	 * @param Row    Number
	 * @param column number
	 * @return
	 **/
	public String readSingleData(String sheet, int row, int column) {
		// Step to fetch the Data from external resources--excel file

		return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();

	}

	/**
	 * This Method used To Fetch The Specific column Data From Excel File
	 * 
	 * @param sheet  Name
	 * @param column Number
	 * @return
	 **/
	public ArrayList<Object> readSpecificColumnData(String sheet, int column) {
		// Step to fetch the Data from external resources--excel file

		int lastRow = wb.getSheet("BasicData").getLastRowNum();
		ArrayList<Object> value = new ArrayList<Object>();

		for (int i = 0; i < lastRow; i++) {
			String data = wb.getSheet(sheet).getRow(i).getCell(column).getStringCellValue();
			value.add(data);
		}

		return value;

	}

	/**
	 * This Method used To Fetch The Specific row Data From Excel File
	 * 
	 * @param sheet Name
	 * @param Row   Number
	 * @return
	 **/
	public ArrayList<Object> readSpecificRowData(String sheet, int row) {
		// Step to fetch the Data from external resources--excel file

		int lastColumn = wb.getSheet(sheet).getRow(row).getLastCellNum();
		ArrayList<Object> value = new ArrayList<Object>();

		for (int i = 0; i < lastColumn; i++) {
			String data = wb.getSheet(sheet).getRow(row).getCell(i).getStringCellValue();
			value.add(data);
		}

		return value;

	}

	/**
	 * This Method used To Fetch The Multiple Data From Excel File
	 * 
	 * @param sheet Name
	 * @param Row   Number
	 * @return
	 **/
	public void displayMultipleDataRecords(String sheet) {
		// Step to fetch the Data from external resources--excel file

		int lastRow = wb.getSheet(sheet).getLastRowNum();
		for (int i = 1; i <= lastRow; i++) {
			int lastColumn1 = wb.getSheet(sheet).getRow(i).getLastCellNum();

			for (int j = 1; j < lastColumn1; j++) {

				String data = wb.getSheet(sheet).getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
				System.out.println();
			}

		}

	}

	/**
	 * This Method used To Read The Multiple Data From Excel File
	 * 
	 * @param sheet            Name
	 * @param expectedTestName
	 * @return
	 **/
	public Map<String, String> readFromExcel(String sheet, String expectedTestName) {
		Map<String, String> map = new HashMap<>();
		Sheet sh = wb.getSheet(sheet);

		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			if (df.formatCellValue(sh.getRow(i).getCell(1)).equals(expectedTestName)) {
				for (int j = 1; j <= sh.getLastRowNum(); j++) {
					String key = df.formatCellValue(sh.getRow(i).getCell(2));
					String value = df.formatCellValue(sh.getRow(i).getCell(3));
					map.put(key, value);
					if (key.equals("####")) {
						break;
					}
					break;
				}
			}
		}
		return map;

	}

	/**
	 * This Method is used to Initialize excel file
	 *
	 */
	public void initExcel() {
		// step 1.convert the physical file into java understandable file
		try {
			fis = new FileInputStream(PathConstant.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// step 2.create an work book using workbookfactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		df = new DataFormatter();
	}

	/**
	 * This Method used To close the excel file
	 * 
	 **/
	public void closeExcelFile() {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This Method used To write the single data in excel file
	 * 
	 * @param Sheet    Name
	 * @param row      number
	 * @param column   number
	 * @param TestData
	 **/
	public void writeSingleData_NewRow(String sheet, int row, int column, String data) {
		// create New Row and Create data
		wb.getSheet(sheet).createRow(row).createCell(column).setCellValue(data);

		// write the data
		try {
			fos=new FileOutputStream(PathConstant.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This Method used To update the single data in excel file
	 * 
	 * @param Sheet    Name
	 * @param row      number
	 * @param column   number
	 * @param TestData
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 **/
	public void updateSingleData_ExistingRow(String sheet, int row, int column, String data) throws EncryptedDocumentException, IOException {
		
		// create New Row and Create data
		wb.getSheet(sheet).getRow(row).createCell(column).setCellValue(data);
		
		// write the data
		 
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method used To get the last row num in excel file
	 * 
	 * @param Sheet    Name
	 * @param row      number
	 * 
	 **/
	public int lastrow(String sheet) {
		int lastrow=wb.getSheet(sheet).getLastRowNum();
		return lastrow;
	}

}
