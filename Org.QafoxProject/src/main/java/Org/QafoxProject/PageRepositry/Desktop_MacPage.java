package Org.QafoxProject.PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseConfiguration;

public class Desktop_MacPage extends BaseConfiguration {

	@FindBy(xpath = "//h4/child::a[text()='iMac']")
	private WebElement Imac;

	@FindBy(xpath = "//h1[text()='iMac']")
	private WebElement product_Title;

	@FindBy(xpath = "//li/a[text()='Apple']")
	private WebElement product_Brand;

	@FindBy(xpath = "//li[text()='Product Code:Product 14']")
	private WebElement product_Code;

	@FindBy(xpath = "//li[text()='Availability:Out Of Stock']")
	private WebElement product_Availability;

	@FindBy(xpath = "//li/h2[text()='$122.00']")
	private WebElement product_ActualPrice;

	@FindBy(xpath = "//li[text()='Ex Tax:$100.00']")
	private WebElement product_DiscountPrice;

	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement product_Qty;

	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement product_AddToCart;

	@FindBy(xpath = "(//ul[@class='breadcrumb']/following-sibling::div)[1]")
	private WebElement product_heading_message;

	@FindBy(xpath = "//div[@class='tab-content']/div/div")
	private WebElement product_Description;

//	@FindBy(xpath = "//button/span/i")
//	private WebElement product_Cart;

//	@FindBy(xpath = "//p/a/strong[text()='View Cart']")
//	private WebElement view_Cart;

	@FindBy(xpath = "(//td[@class='text-left']/a[text()='iMac'])[2]")
	private WebElement product_Actual_Name;

	@FindBy(xpath = "//div/a[text()='Checkout']")
	private WebElement product_CheckOut;

	public Desktop_MacPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct_Title() {
		return product_Title;
	}

	public WebElement getProduct_Brand() {
		return product_Brand;
	}

	public WebElement getProduct_Availability() {
		return product_Availability;
	}

	public WebElement getProduct_ActualPrice() {
		return product_ActualPrice;
	}

	public WebElement getProduct_Code() {
		return product_Code;
	}

	public WebElement getProduct_DiscountPrice() {
		return product_DiscountPrice;
	}

	public WebElement getProduct_Qty() {
		return product_Qty;
	}

	public WebElement getProduct_AddToCart() {
		return product_AddToCart;
	}

	public WebElement getProduct_heading_message() {
		return product_heading_message;
	}

	public WebElement getProduct_Description() {
		return product_Description;
	}

	public WebElement getProduct_Actual_Name() {
		return product_Actual_Name;
	}

	public WebElement getProduct_CheckOut() {
		return product_CheckOut;
	}

	public WebElement getImac() {
		return Imac;
	}

	

}
