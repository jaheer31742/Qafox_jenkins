package Qrg.QafoxProject_Components;

import java.io.IOException;

import org.jspecify.annotations.Nullable;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseConfiguration;
import Org.QafoxProject.PageRepositry.Componenets_ScannerPage;
import Org.QafoxProject.PageRepositry.HomePage;

@Listeners(Org.QafoxProject.ListenerFeature.ListenerImplementation.class)
public class Components_Scanners_Test extends BaseConfiguration {

	

	@Test(enabled = false, priority = 0, invocationCount = 2)
	public void ScannerProduct_0() {
		// Create the test information
		ExtentTest test = super.report.createTest("AddProduct_Components_Scanner");
		HomePage homepageObj = new HomePage(webdriverobj.driver);
		Componenets_ScannerPage scannerPage = new Componenets_ScannerPage(webdriverobj.driver);

		// perform mouse hover action o Components
		webdriverobj.mouseHouseToElement(homepageObj.getComponents());
		test.log(Status.PASS, "Step1:Perform Mouse House Action_Components");
		javaUtilityobj.pause(5000);

		// perform mouse hover action on Scanner
		webdriverobj.mouseHouseToElement(homepageObj.getScanner());
		test.log(Status.PASS, "Step2.1:Perform Mouse House Action_Component_Scanner");

		// verify the web element
		String expectedTextOfWebElement = "Scanners (0)";
		String actualTextOfWebElement = homepageObj.getScanner().getText();
		Assert.assertEquals(actualTextOfWebElement, expectedTextOfWebElement);
		javaUtilityobj.pause(5000);

		homepageObj.getScanner().click();
		test.log(Status.PASS, "Step2.2:Perform Click Action_Component_Scanner");
		javaUtilityobj.pause(5000);

		scannerPage.getContinueButton().click();
		Reporter.log("continue button click sucessfull");
		javaUtilityobj.pause(5000);

	}

	@Test(enabled = true, priority = 1)
	public void ScannerProduct_1() {
		// Create the test information
		ExtentTest test = super.report.createTest("AddProduct_Components_Scanner");
		HomePage homepageObj = new HomePage(webdriverobj.driver);
		Componenets_ScannerPage scannerPage = new Componenets_ScannerPage(webdriverobj.driver);

		// verify the web element
		if (homepageObj.getComponents().isDisplayed() && homepageObj.getComponents().isEnabled()) {
			// perform mouse hover action o Components
			webdriverobj.mouseHouseToElement(homepageObj.getComponents());
			test.log(Status.PASS, "Step1:Perform Mouse House Action_Components");
			javaUtilityobj.pause(5000);

			if (homepageObj.getScanner().isDisplayed() && homepageObj.getScanner().isEnabled()) {
				// perform mouse hover action on Scanner
				webdriverobj.mouseHouseToElement(homepageObj.getScanner());
				test.log(Status.PASS, "Step2.1:Perform Mouse House Action_Component_Scanner");
				javaUtilityobj.pause(5000);

				// perform click actions
				homepageObj.getScanner().click();
				test.log(Status.PASS, "Step2.2:Perform Click Action_Component_Scanner");

				// verify the web page
				String currentUrl = webdriverobj.getCurrentUrl();
				String title = webdriverobj.getTitle();
				Assert.assertEquals(currentUrl,
						"https://tutorialsninja.com/demo/index.php?route=product/category&path=25_31");
				Assert.assertEquals(title, "Scanners");
			}
		}

		// verify the web element
		String HeadingText = scannerPage.getHeadingText().getText();
		String paragraphText = scannerPage.getParagraphText().getText();
		Assert.assertEquals(HeadingText, "Scanners");
		Assert.assertEquals(paragraphText, "There are no products to list in this category.");
		Reporter.log(HeadingText, true);
		Reporter.log(paragraphText, true);

		// get property
		String tagName = scannerPage.getHeadingText().getTagName();
		Reporter.log(tagName, true);
		Dimension location = scannerPage.getHeadingText().getSize();
		System.out.println(location.getHeight());
		System.out.println(location.getWidth());
		Reporter.log(scannerPage.getHeadingText().getText(), location.getWidth(), true);
		javaUtilityobj.pause(5000);

		// write the property value in the excel file
		String sheetName = "BasicData";
		excelfileobj.initExcel();
		int lastRowNum = excelfileobj.lastrow(sheetName);
		System.out.println(lastRowNum);		
	
		
		excelfileobj.writeSingleData_NewRow(sheetName, lastRowNum+1, 1, tagName);
		Reporter.log("excel file is updated with the heading tag name", true);
		javaUtilityobj.pause(5000);
		
		propertyfileobj.initPropertyFile();
		try {
			propertyfileobj.writeProperty("Name", "jaheer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			propertyfileobj.writeProperty("Height ", String.valueOf(location.getHeight()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("property file is updated with the heading tag name", true);
		

//		scannerPage.getContinueButton().click();
		Reporter.log("continue button click sucessfull");
		javaUtilityobj.pause(5000);

	}

}
