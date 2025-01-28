package GenericUtility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Org.QafoxProject.PageRepositry.AccountLoginPage;
import Org.QafoxProject.PageRepositry.HomePage;

/**
 * This Class Describes The Configuration For The TestScript
 * 
 * This class is used for configure all precondition and post condition for test
 * script
 * 
 * and also initializing all the library utility class
 * 
 * @author Jaheer
 */

public class BaseConfiguration {

	public WebDriverLibrary webdriverobj;
	public ExcelFileLibrary excelfileobj;
	public PropertyFileLibrary propertyfileobj;
	public JavaLibrary javaUtilityobj;
	public JavaScriptLibrary jsUtilityobj;
	public TakeScreenShotLibrary tsUtilityobj;

	public ExtentSparkReporter spark;
	public ExtentReports report;
	//public ExtentTest test;

	/**
	 * This Method Used To Configure The Browser SetUp
	 * 
	 * @param
	 **/

	@BeforeClass
	public void browserSetUp() {

		// initialize all the libraries
		initObjects();

		// Test Log
		String browser = "edge";
		String url = "https://tutorialsninja.com/demo/";
		// Precondition 1:launch the browser
		webdriverobj.launchBrowser(browser);
		Reporter.log("Browser Launch Succesfully", true);

		// Precondition 2:Navigate to the application
		webdriverobj.navigateToApp(url);
		Reporter.log("Navigate to the application Succesfully", true);

		// Precondition 3:Maximize the browser
		webdriverobj.maximizeBrowser();
		Reporter.log("Maximize The browser Succesfully", true);

		HomePage homePageObj = new HomePage(webdriverobj.driver);

		// click on my account header link
		homePageObj.getMyAccount_headerLink().click();
		Reporter.log("clicked on My account headerlink succesfull", true);

		// click on the register header link
		homePageObj.getRegisterAccount_headerLink().click();
		Reporter.log("clicked on the Register header link succesful", true);

		homePageObj.getMyAccount_headerLink().click();
		Reporter.log("clicked on My account headerlink succesfull", true);

		// click on the "Login" header link
		homePageObj.getAccountLogin_headerLink().click();
		Reporter.log("clicked on the Login header link succesful", true);

	}

	/**
	 * This Method Used To Configure The Browser Terminate
	 **/
	@AfterClass
	public void teminate() {
		// Post condition 1:Close The Browser
		webdriverobj.closeAllBrowser();
		Reporter.log("Browser Terminated Succesfully", true);

	}

	/**
	 * This Method Used To Perform Login Activity
	 **/
	@BeforeMethod(enabled = true)
	public void login() {
		// provide wait statement
		webdriverobj.waitUntilElementFound();

		AccountLoginPage loginobj = new AccountLoginPage(webdriverobj.driver);
		String email = "sk.jaheerbasha92@gmail.com";
		String password = "moin317";

		// enter email
		loginobj.getEmailAddress().sendKeys(email);
		// enter password
		loginobj.getPassword().sendKeys(password);
		// click on login button
		loginobj.getLoginButton().click();
		// Test Log
		Reporter.log("Login Succesfully", true);
	}

	/**
	 * This Method Used To Perform LogOut Activity
	 **/
	@AfterMethod(enabled = false)
	public void logOut() {

		HomePage homePageObj = new HomePage(webdriverobj.driver);

		homePageObj.getMyAccount_headerLink().click();
		Reporter.log("clicked on My account headerlink succesfull", true);

		// perform logout action
		homePageObj.getAccount_Logout().click();

		// Test Log
		Reporter.log("LogOut Succesfully", true);

	}

	/**
	 * This Method Used To Get/Configure The TestRunner Level Connection
	 **/
	@BeforeTest
	public void getTestRunnerConnection() {
		// Test Log
		Reporter.log("Get TestRunner Connection Succesfull", true);

	}

	/**
	 * This Method Used To Terminate The TestRunner Level Connection
	 **/
	@AfterTest
	public void terminateTestRunnerConnection() {
		// Test Log
		Reporter.log("Terminate TestRunner connection  Succesfull", true);
	}

	/**
	 * This Method Used To Get/Configure The Database or Advance Report Connection
	 **/
	@BeforeSuite
	public void getReportConnection() {

		// Create the SparkReport
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// configure the SparkReport information
		spark.config().setDocumentTitle("Functionality_Test||Qafox");
		spark.config().setReportName("FunctionalitySuit||verify User Able To Add Desktop_Mac_Product");
		spark.config().setTheme(Theme.DARK);

		// Create the Extents Report
		report = new ExtentReports();

		// Attach the spark report and extent reports
		report.attachReporter(spark);

		// configure the system information in extent report
		report.setSystemInfo("DeviceName", "jaheer");
		report.setSystemInfo("OperatingSystem", "windows_11");
		report.setSystemInfo("BrowserName", "edge");
		report.setSystemInfo("BrowserVersion", "edge_Version 131.0.2903.112");

		// Test Log
		Reporter.log("Get Report Connection Succesfull", true);
	}

	/**
	 * This Method Used To Terminate The Database or Advance Report Connection
	 **/
	@AfterSuite
	public void terminateReportConnection() {

		// flush the report information
		report.flush();

		// Test Log
		Reporter.log("Terminate Report Succesfull", true);
	}

	public void initObjects() {
		webdriverobj = new WebDriverLibrary();
		excelfileobj = new ExcelFileLibrary();
		propertyfileobj = new PropertyFileLibrary();
		javaUtilityobj = new JavaLibrary();
		jsUtilityobj = new JavaScriptLibrary();
		tsUtilityobj = new TakeScreenShotLibrary();
	}

}
