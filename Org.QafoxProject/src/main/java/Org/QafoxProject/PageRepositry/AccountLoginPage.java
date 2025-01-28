package Org.QafoxProject.PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseConfiguration;

public class AccountLoginPage extends BaseConfiguration {

	// declaration

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	public WebElement LoginButton;

	// initialization
	public AccountLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

}
