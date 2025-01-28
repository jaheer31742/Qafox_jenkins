package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

/**
 * This Class provides Reusable Method To Perform CRUD in Property File
 */
public class PropertyFileLibrary {
	FileInputStream fis;
	FileOutputStream fos;
	Properties propertyObj;

	/**
	 * This method is used to initialize the property file
	 */
	public void initPropertyFile() {

		// Steps to fetch the data from the external resource --property file

		// convert the physical file into java understandable

		try {
			fis = new FileInputStream(PathConstant.PROPERTY_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create an object for the properties class
		propertyObj = new Properties();

		// call the non static method---to load the property

		try {
			propertyObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This Method used To read The Data From Property File
	 **/

	public String readProperty(String key) throws IOException {

		return propertyObj.getProperty(key);
	}

	/**
	 * This Method used To Fetch The Data From Property File
	 **/

	public void writeProperty(String key, String value) throws IOException {

		propertyObj.put(key, value);// update and write are same

		try {
			fos = new FileOutputStream(PathConstant.PROPERTY_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// save
		try {
			propertyObj.store(fos, "upload latest file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to dispaly the property file
	 */

	public void displayPropertyFile(String key) {

		String data = propertyObj.getProperty(key);

		// display the data
		Reporter.log(key + ":" + data);

	}
}
