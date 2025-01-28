package Org.QafoxProject.ListenerFeature;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import GenericUtility.BaseConfiguration;
import GenericUtility.WebDriverLibrary;

public class ListenerImplementation extends BaseConfiguration implements ITestListener, IRetryAnalyzer {
	int count = 1;

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("onTestStart...!!", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("onTestSuccess...!!", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("onTestFailure...!!", true);

		// Fetch the Test Method Name
		String methodName = result.getName();

		// Provide Implementation For Taking ScreenShot

		// 1.perform type casting
		TakesScreenshot ts = (TakesScreenshot) WebDriverLibrary.static_driver;

		// 2.call the ScreenShot method
		// 3.store the screenshot in temp file
		File src = ts.getScreenshotAs(OutputType.FILE);

		// 4.create the screen shot in perm file
		File dest = new File("./TestScreenShot/" + methodName + ".png");

		// 5.copy the screen shot from temp to permt file
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("Test Failure Method Executed..... ScreenShot Taken", true);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("onTestSkipped...!!", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("onTestFailedButWithinSuccessPercentage...!!", true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("onTestFailedWithTimeout...!!", true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart...!!", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish...!!", true);
	}

	@Override
	public boolean retry(ITestResult result) {
		
		int retryUntil = 5;
		boolean flag = false;
		if (count <=retryUntil) {
			Reporter.log("Retry..!!",true);
			count++;
			flag = true;
		}
		return flag;
	}

}
