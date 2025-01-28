package GenericUtility;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class Contains reusable Method to Perform driver related operations
 * 
 * @author Jaheer
 */

public class WebDriverLibrary {
	public WebDriver driver;
	public static WebDriver static_driver;
	public Actions action;
	public Select select;

	/**
	 * This method launch specified browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser info");

		}
		static_driver = driver;
		return driver;

	}

	/**
	 * This Method is used to maximize the browser
	 * 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This Method is used to navigate to the application
	 * 
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}

	/**
	 * This Method is used to close to the browser
	 * 
	 */
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * This Method is used to close all the browser window/tab
	 * 
	 */
	public void closeAllBrowser() {
		driver.quit();
	}

	/**
	 * This Method is used to wait until element or element is found
	 * 
	 * @param time
	 * 
	 */
	public void waitUntilElementFound() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PathConstant.DURATION));
	}

	/**
	 * This Method is used to wait until element is visible on the web page
	 * 
	 * @param element
	 * 
	 */
	public void waitUntilElementFound(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PathConstant.DURATION));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method is used to mouse hover on an element
	 * 
	 * @param element
	 * 
	 */
	public void mouseHouseToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This Method is used to double click on an element
	 * 
	 * @param element
	 * 
	 */
	public void doubleClickOnElement(WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This Method is used to right click on an element
	 * 
	 * @param element
	 * 
	 */
	public void rightClickOnElement(WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This Method is used to drag and drop an element to target location
	 * 
	 * @param element
	 * @param target
	 * 
	 */
	public void dragAndDropElement(WebElement source, WebElement target) {
		action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	/**
	 * This Method is used to select an element from drop down based on index
	 * 
	 * @param element
	 * @param index
	 * 
	 */
	public void selectFromDropDown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This Method is used to select an element from drop down based on value
	 * 
	 * @param element
	 * @param value
	 * 
	 */
	public void selectFromDropDown(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This Method is used to select an element from drop down based on visible text
	 * 
	 * @param element
	 * @param text
	 * 
	 */
	public void selectFromDropDown(String visibleText, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * This Method is used to switch to frame based on index
	 * 
	 * @param element
	 * 
	 * 
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This Method is used to switch to frame based on id or name attribute value
	 * 
	 * @param idOrName
	 * 
	 * 
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	/**
	 * This Method is used to switch to frame based on frame element
	 * 
	 * @param element
	 * 
	 * 
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This Method is used to switch back to default window
	 * 
	 * 
	 */
	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This Method is used to switch back to parent window
	 * 
	 * 
	 */
	public void switchToParentWindow() {
		driver.switchTo().parentFrame();
	}

	/**
	 * This Method is used to handle alert pop up
	 * 
	 * @param status
	 * 
	 */
	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok")) {
			al.accept();
		} else {
			al.dismiss();
		}
	}

	/**
	 * This Method convert dynamic xpath to web element
	 * 
	 * @param commonpath
	 * @param replaceData
	 * @return
	 * 
	 */
	public WebElement convertDynamicXpathToWebElement(String commonPath, String replaceData) {
		String requiredPath = String.format(commonPath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}

	/**
	 * This Method is used to get the title of the web page
	 * @return
	 * 
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * This Method is used to get the current url of the web page
	 * @return
	 * 
	 */
	public String getCurrentUrl() {
		String title = driver.getCurrentUrl();
		return title;
	}

}
