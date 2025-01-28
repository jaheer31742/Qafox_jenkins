package AutomationExercise_SearchProduct;

import org.testng.annotations.Test;

import AutomationExercise_BaseConfiguration.BaseConfiguratiion;
import AutomationExercise_PageRepository.SearchProductPage;

public class Search_Products extends BaseConfiguratiion {
	
	@Test
	public void SearchProduct() {
		SearchProductPage productpage=new SearchProductPage(webdriverobj.driver);
		//perform click action on product button
		productpage.getProductButton().click();
		javaUtilityobj.pause(2000);
	
		productpage.getSearchText().sendKeys("Men Tshirt");
		javaUtilityobj.pause(2000);
		
		productpage.getSearchButton().click();
		javaUtilityobj.pause(2000);
	}

}
