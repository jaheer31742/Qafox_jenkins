package Org.QafoxProject.PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseConfiguration;

public class Componenets_ScannerPage extends BaseConfiguration {

	// heading text
	@FindBy(xpath = "//h2[text()='Scanners']")
	private WebElement headingText;

	// paragraph text
	@FindBy(xpath = "//p[contains(text(),'There ')]")
	private WebElement paragraphText;

	// continue Button
	@FindBy(xpath = "//div/a[text()='Continue']")
	private WebElement ContinueButton;

	public WebElement getHeadingText() {
		return headingText;
	}

	public WebElement getParagraphText() {
		return paragraphText;
	}

	// initialization
	public Componenets_ScannerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration
	public WebElement getContinueButton() {
		return ContinueButton;
	}

	

}
