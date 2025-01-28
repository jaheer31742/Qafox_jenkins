package Org.QafoxProject.PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseConfiguration;

/**
 *  
 */
public class RegisterAccount  {
	/**
	 * declaration
	 */

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTextField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastNameTextField;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailTextField;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement telephoneTextField;

	@FindBy(xpath = "//input[contains(@id,'password')]")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[contains(@name,'confirm')]")
	private WebElement passwordConfirmTextField;

	@FindBy(xpath = "//label[text()='Yes']/input")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//label[text()='No']/input")
	private WebElement noRadioButton;

	@FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
	private WebElement acknowledgementCheckBox;

	@FindBy(css = ".btn.btn-primary")
	private WebElement continueButton;

	/**
	 * initialization
	 */
	public RegisterAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return firstNameTextField
	 */

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	/**
	 * @return lastNameTextField
	 */

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	/**
	 * @return emailTextField
	 */

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	/**
	 * @return telephoneTextField
	 */

	public WebElement getTelephoneTextField() {
		return telephoneTextField;
	}

	/**
	 * @return passwordTextField
	 */

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	/**
	 * @return passwordConfirmTextField
	 */

	public WebElement getPasswordConfirmTextField() {
		return passwordConfirmTextField;
	}

	/**
	 * @return yesRadioButton
	 */

	public WebElement getYesRadioButton() {
		return yesRadioButton;
	}

	/**
	 * @return noRadioButton
	 */

	public WebElement getNoRadioButton() {
		return noRadioButton;
	}

	/**
	 * @return acknowledgementCheckBox
	 */

	public WebElement getAcknowledgementCheckBox() {
		return acknowledgementCheckBox;
	}

	/**
	 * @return continueButton
	 */

	public WebElement getContinueButton() {
		return continueButton;
	}
}