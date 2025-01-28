package AutomationExercise_PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise_BaseConfiguration.BaseConfiguratiion;

public class SearchProductPage extends BaseConfiguratiion{
	//product button
	@FindBy(xpath = "//ul/li[2]/a[text()=' Products']")
	private WebElement ProductButton;
	
	//search text
	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement searchText;
	
	//Search button
	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement searchButton;
	
	
	public WebElement getProductButton() {
		return ProductButton;
	}


	public WebElement getSearchText() {
		return searchText;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}


	public SearchProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

}
