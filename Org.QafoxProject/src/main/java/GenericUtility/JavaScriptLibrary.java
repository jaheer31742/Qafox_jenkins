package GenericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * This class provide the reusable methods to perform javaScript Related Actions
 * 
 * @author Jaheer
 */

public class JavaScriptLibrary {
	public JavascriptExecutor javascriptobj;

	/**
	 * This method is used to enter the data in the disabled element
	 */
	public void enterData_DisabledElement(WebElement element, String data) {
		javascriptobj = (JavascriptExecutor) WebDriverLibrary.static_driver;
		javascriptobj.executeScript("arguments[0].value='+data+'", element);
	}

	/**
	 * This method is used to perform "click "on disabled element
	 */
	public void click_DisabledElement(WebElement element) {
		javascriptobj = (JavascriptExecutor) WebDriverLibrary.static_driver;
		javascriptobj.executeScript("arguments[0].click()", element);
	}

	/**
	 * This method is used to scroll on web page based on scrollBy
	 */
	public void defaultVerticalScrollBy() {
		javascriptobj = (JavascriptExecutor) WebDriverLibrary.static_driver;
		javascriptobj.executeScript("window.scrollBy(1000,1000)");
	}

	/**
	 * This method is used to scroll on web page based on scrollTo
	 */
	public void defaultVerticalScrollTo() {
		javascriptobj = (JavascriptExecutor) WebDriverLibrary.static_driver;
		javascriptobj.executeScript("window.scrollTo(1000,1000)");
	}

	/**
	 * This method is used to scroll untill the element visible
	 */
	public void ScrollUsingView(WebElement element, boolean value) {
		javascriptobj = (JavascriptExecutor) WebDriverLibrary.static_driver;
		javascriptobj.executeScript("arguments[0].scrollIntoView(" + value + ");", element);
	}

}
