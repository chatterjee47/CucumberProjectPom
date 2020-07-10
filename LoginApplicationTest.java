package seleniumgluecode;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.vimalselvam.cucumber.listener.Reporter;

import BaseClass.Browser;
import BaseClass.ListenersClass;
import PageObjectRepository.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Listeners(ListenersClass.class)
public class LoginApplicationTest extends Browser{

public static WebDriver driver;
   LoginPage login;
  
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {  
    	driver = Browser.StartBrowser("Chrome", "https://test.salesforce.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        Reporter.addStepLog("Chrome Browser is opened successfully");
        Thread.sleep(1000);
    }
    
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
    	 login = new LoginPage(driver);
   	     login.clickLogin();
   	     Reporter.addStepLog("Login Button is clicked successfully");
    }
    
  
    @Then("^user enter username \"([^\"]*)\" and User enter password \"([^\"]*)\"$")
    public void user_enter_username_UserName_and_User_enter_password_Password(String username, String password) {
    	login = new LoginPage(driver);
  	    login.setUserName(username);
  	    Reporter.addStepLog("User Name enetered successfully");
  	    login.setPassword(password);
  	    Reporter.addStepLog("Password enetered successfully");
    }
    
    
    @Then("^Close the browser$")
    public void close_the_browser() {
    //    driver.quit();
        Reporter.addStepLog("Browser is closed successfully");

    }
    
    
    
    @After
    public void tearDown(Scenario scenario) {
      try {
        if (scenario.isFailed()) {
          final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot, "image/png");
        }
      } finally {
        driver.quit();
      }
    }}



