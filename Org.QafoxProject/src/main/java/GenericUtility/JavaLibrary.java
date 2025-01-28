package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable methods to perform java related operation
 * 
 * @author Jaheer
 */

public class JavaLibrary {

	/**
	 * This method is used to pause the script execution for specified time
	 * 
	 * @param time
	 */
	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch current date and time(date stamp)
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}
	
	
	/**
	 * This method is used to generate random number within the specific limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
	}

}
