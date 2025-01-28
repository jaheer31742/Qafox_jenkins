package Qrg.QafoxProject.Desktop;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseConfiguration;
import Org.QafoxProject.PageRepositry.CartPage;
import Org.QafoxProject.PageRepositry.Desktop_MacPage;
import Org.QafoxProject.PageRepositry.HomePage;


/**
 * @author Jaheer
 */

public class Desktop_Mac_Test extends BaseConfiguration {
	@Test
	public void addProduct_Desktop_Mac() {
		// Create the test information
		ExtentTest test = report.createTest("AddProduct_Desktop_Mac");

		HomePage homepageObj = new HomePage(webdriverobj.driver);
		Desktop_MacPage macObj = new Desktop_MacPage(webdriverobj.driver);
		CartPage cartObj=new CartPage(webdriverobj.driver);

		// perform mouse hover action
		webdriverobj.mouseHouseToElement(homepageObj.getDesktop_header());
		test.log(Status.PASS, "Step1:Perform Mouse House Action_Desktop");

		javaUtilityobj.pause(5000);

		// perform mouse hover action
		webdriverobj.mouseHouseToElement(homepageObj.getDesktop_header_Mac());
		test.log(Status.PASS, "Step2.1:Perform Mouse House Action_Desktop_Mac");

		homepageObj.getDesktop_header_Mac().click();
		test.log(Status.PASS, "Step2.2:Perform Click Action_Desktop_Mac");

		javaUtilityobj.pause(5000);
		test.log(Status.INFO, "Desktops_Mac_Product Added Sucessfull");

		macObj.getImac().click();
		javaUtilityobj.pause(5000);

		String productTitle = macObj.getProduct_Title().getText();
		Reporter.log(productTitle, true);
		javaUtilityobj.pause(5000);

		String productBrand = macObj.getProduct_Brand().getText();
		Reporter.log(productBrand, true);
		javaUtilityobj.pause(5000);

		String productCode = macObj.getProduct_Code().getText();
		Reporter.log(productCode, true);
		javaUtilityobj.pause(5000);

		String productAvailability = macObj.getProduct_Availability().getText();
		Reporter.log(productAvailability, true);
		javaUtilityobj.pause(5000);

		String productActualPrice = macObj.getProduct_ActualPrice().getText();
		Reporter.log(productActualPrice, true);
		javaUtilityobj.pause(5000);

		String productDiscountPrice = macObj.getProduct_DiscountPrice().getText();
		Reporter.log(productDiscountPrice, true);
		javaUtilityobj.pause(5000);

		macObj.getProduct_Qty().sendKeys("5");
		Reporter.log("QTY is entered sucessfully",true);
		javaUtilityobj.pause(5000);

		macObj.getProduct_AddToCart().click();
		Reporter.log("add cart button click sucessfully ",true);
		javaUtilityobj.pause(5000);

		String productHeadingMessage = macObj.getProduct_heading_message().getText();
		Reporter.log(productHeadingMessage, true);
		javaUtilityobj.pause(5000);

		String productDescription = macObj.getProduct_Description().getText();
		Reporter.log(productDescription, true);
		javaUtilityobj.pause(5000);

		cartObj.getProduct_Cart().click();
		Reporter.log("shopping cart button click sucessfull", true);
		javaUtilityobj.pause(5000);

		cartObj.getView_Cart().click();
		Reporter.log("view cart button click sucessfull");
		javaUtilityobj.pause(5000);

		macObj.getProduct_CheckOut().click();
		Reporter.log("check out button click sucessfull");
		javaUtilityobj.pause(5000);

		productHeadingMessage = macObj.getProduct_heading_message().getText();
		Reporter.log(productHeadingMessage, true);
		javaUtilityobj.pause(5000);
	}

}
