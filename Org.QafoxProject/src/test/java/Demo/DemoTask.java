package Demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoTask {
	@Test
	public void extentsReport() {
		// Create the SparkReport
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// configure the SparkReport information
		spark.config().setDocumentTitle("Functionality_Test||Qafox");
		spark.config().setReportName("FunctionalitySuit||verify User Able To Add Desktop_Mac_Product");
		spark.config().setTheme(Theme.DARK);

		// Create the Extents Report
		ExtentReports report = new ExtentReports();

		// Attach the spark report and extent reports
		report.attachReporter(spark);

		// configure the system information in extent report
		report.setSystemInfo("DeviceName", "jaheer");
		report.setSystemInfo("OperatingSystem", "windows_11");
		report.setSystemInfo("BrowserName", "edge");
		report.setSystemInfo("BrowserVersion", "edge_Version 131.0.2903.112");

		// Create the test information
		ExtentTest test = report.createTest("Functionality_Test");

		// Steps information
		test.log(Status.INFO, "Step1:Launching The Browser Sucessful");
		test.log(Status.INFO, "Step2:Navigate to the application Succesfully");
		test.log(Status.PASS, "Step3:verified the web page sucessfull");

		if (true) {
			test.log(Status.PASS, "Step4:verified the web element displayed");
		} else {
			test.log(Status.FAIL, "Step4:verified the web element not displayed");
		}

		// test.log(status.skip,"step5:element is hidden");

		// flush the report information
		report.flush();

		System.out.println("execution done");

	}

}
