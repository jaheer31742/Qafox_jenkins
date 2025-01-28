package Qrg.QafoxProject.RegisterAccount;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseConfiguration;
import GenericUtility.WebDriverLibrary;
import Org.QafoxProject.PageRepositry.RegisterAccount;

@Listeners(Org.QafoxProject.ListenerFeature.ListenerImplementation.class)

public class RegisterAccountTest extends BaseConfiguration {

	@Test(retryAnalyzer = Org.QafoxProject.ListenerFeature.ListenerImplementation.class)
	public void VerifyWithValidInput() {
		RegisterAccount registerAccount = new RegisterAccount(WebDriverLibrary.static_driver);
		registerAccount.getFirstNameTextField().sendKeys("shaik");
		registerAccount.getLastNameTextField().sendKeys("jaheer");
		registerAccount.getEmailTextField().sendKeys("sk.jaheerbasha92@gmail.com");
		registerAccount.getTelephoneTextField().sendKeys("9553205434");
		registerAccount.getPasswordTextField().sendKeys("moin317");
		registerAccount.getPasswordConfirmTextField().sendKeys("moin317");
		registerAccount.getYesRadioButton().click();
		registerAccount.getAcknowledgementCheckBox().click();
		registerAccount.getContinueButton().click();

		// Test Log
		Reporter.log("RegisterAccount Verified With Valid Input", true);

	}

	@Test(retryAnalyzer = Org.QafoxProject.ListenerFeature.ListenerImplementation.class)
	public void VerifyWithInValidInput() {

		// Test Log
		Reporter.log("RegisterAccount Verified With InValid Input", true);
	}

}
