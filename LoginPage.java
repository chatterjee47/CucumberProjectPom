package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement LoginPageUserName;

	@FindBy(id = "password")
	WebElement LoginPagePassword;

	@FindBy(id = "Login")
	WebElement LoginPageSignButton;
	


	// Set user name in textbox
	public void setUserName(String strUserName) {
		LoginPageUserName.sendKeys(strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		LoginPagePassword.sendKeys(strPassword);

	}

	// Click on login button
	public void clickLogin() {
		LoginPageSignButton.click();
	}
	

	public void LoginToApplication(String strUserName, String strPasword) {
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
	}

}
