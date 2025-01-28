package Org.QafoxProject.PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseConfiguration;

public class CartPage extends BaseConfiguration {

	@FindBy(xpath = "//button/span/i")
	private WebElement product_Cart;

	@FindBy(xpath = "//p/a/strong[text()='View Cart']")
	private WebElement view_Cart;

	public WebElement getProduct_Cart() {
		return product_Cart;
	}

	public WebElement getView_Cart() {
		return view_Cart;
	}

	// initialization
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
