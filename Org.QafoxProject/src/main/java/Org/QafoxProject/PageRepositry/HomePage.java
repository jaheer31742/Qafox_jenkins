package Org.QafoxProject.PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseConfiguration;

public class HomePage extends BaseConfiguration {

	// declaration
	// my account
	@FindBy(xpath = "//li[@class='dropdown'][1]/child::a[@title='My Account']")
	private WebElement myAccount_headerLink;

	/// login
	@FindBy(xpath = "//li/child::a[text()='Login']")
	private WebElement accountLogin_headerLink;

	// register
	@FindBy(xpath = "(//a[text()='Register'])[1]")
	private WebElement registerAccount_headerLink;

	// desktop
	@FindBy(xpath = "//li/a[text()='Desktops']")
	private WebElement desktop_header;

	// Mac
	@FindBy(xpath = "//li/a[contains(text(),'Mac ')]")
	private WebElement desktop_header_Mac;

	// Pc
	@FindBy(xpath = "//li/a[contains(text(),'PC ')]")
	private WebElement desktop_header_Pc;

	// Logout
	@FindBy(xpath = "//li/child::a[text()='Logout']")
	private WebElement account_Logout;

	// laptop & notbook
	@FindBy(xpath = "//li/a[text()='Laptops & Notebooks']")
	private WebElement laptop_and_Notebook;

	// components
	@FindBy(xpath = "//li/a[text()='Components']")
	private WebElement components;

	// Scanner
	@FindBy(xpath = "//li/a[text()='Scanners (0)']")
	private WebElement Scanner;

	public WebElement getScanner() {
		return Scanner;
	}

	// Tablets
	@FindBy(xpath = "//li/a[text()='Tablets']")
	private WebElement tablets;

	// cameras
	@FindBy(xpath = "//li/a[text()='Cameras']")
	private WebElement cameras;

	// software
	@FindBy(xpath = "//li/a[text()='Software']")
	private WebElement softwares;

//	@FindBy(xpath = "//button/span/i")
//	private WebElement product_Cart;
//	
//	@FindBy(xpath = "//p/a/strong[text()='View Cart']")
//	private WebElement view_Cart;
//
//	public WebElement getProduct_Cart() {
//		return product_Cart;
//	}
//
//	public WebElement getView_Cart() {
//		return view_Cart;
//	}

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDesktop_header() {
		return desktop_header;
	}

	public WebElement getLaptop_and_Notebook() {
		return laptop_and_Notebook;
	}

	public WebElement getComponents() {
		return components;
	}

	public WebElement getTablets() {
		return tablets;
	}

	public WebElement getCameras() {
		return cameras;
	}

	public WebElement getMyAccount_headerLink() {
		return myAccount_headerLink;
	}

	public WebElement getAccountLogin_headerLink() {
		return accountLogin_headerLink;
	}

	public WebElement getRegisterAccount_headerLink() {
		return registerAccount_headerLink;
	}

	public WebElement getSoftwares() {
		// TODO Auto-generated method stub
		return softwares;
	}

	public WebElement getDesktop_header_Mac() {
		return desktop_header_Mac;
	}

	public WebElement getDesktop_header_Pc() {
		return desktop_header_Pc;
	}

	public WebElement getAccount_Logout() {
		// TODO Auto-generated method stub
		return account_Logout;
	}

	

}
