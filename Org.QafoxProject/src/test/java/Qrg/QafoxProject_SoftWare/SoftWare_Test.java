package Qrg.QafoxProject_SoftWare;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseConfiguration;

import Org.QafoxProject.PageRepositry.HomePage;

public class SoftWare_Test extends BaseConfiguration{
	@Test
	public void add_software_product() {
		HomePage homepageObj=new HomePage(webdriverobj.driver);
		
		//perform mouse hover action
		webdriverobj.mouseHouseToElement(homepageObj.getSoftwares());
		
		Reporter.log("Software_Product Added",true);
		
		
	}

}
