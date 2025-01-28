package AutomationExercise_BaseConfiguration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import GenericUtility.ExcelFileLibrary;
import GenericUtility.JavaLibrary;
import GenericUtility.JavaScriptLibrary;
import GenericUtility.PropertyFileLibrary;
import GenericUtility.TakeScreenShotLibrary;
import GenericUtility.WebDriverLibrary;

public class BaseConfiguratiion {		

		public WebDriver driver;
		public static WebDriver staticDriver;
		public WebDriverLibrary webdriverobj;
		public JavaLibrary javaUtilityobj;
		
		

		@BeforeMethod
		public void browserSetup() {
			initObjects();

			driver = new EdgeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String url = "https://www.automationexercise.com/";
			System.out.println("URL : " + url);

			driver.get(url);
			Reporter.log("Navigated to url", true);
			
			String homePageTitle = "Automation Exercise";
			
			Assert.assertEquals(driver.getTitle(), homePageTitle);

			Reporter.log("Home page verified",true);
			
		}

		@AfterMethod

		public void closeBrowser() throws Exception {

			Thread.sleep(1500);

			driver.close();
			Reporter.log("Browser closed");

		}
		
		public void initObjects() {
			  webdriverobj = new WebDriverLibrary();
			  javaUtilityobj = new JavaLibrary();
			
		}

	}

