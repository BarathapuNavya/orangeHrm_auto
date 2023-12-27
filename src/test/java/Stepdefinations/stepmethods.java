package Stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class stepmethods {

	public static WebDriver driver;
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-3.0.1/symfony/web/index.php/auth/login";

	@Given("User should Open Chrome Browser in the System")
	public void user_should_open_chrome_browser_in_the_system() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("open the browser");

	}

	@When("User enters OrangeHRM Application Url Address")
	public void user_enters_orange_hrm_application_url_address() throws InterruptedException {
		driver.get(applicationUrlAddress);
		System.out.println("open the application");
		Thread.sleep(3000);
	}

	@Then("User should be navigated to OrangeHRM Application LogIn WebPage")
	public void user_should_be_navigated_to_orange_hrm_application_log_in_web_page() {
		By logInPanelTextProperty = By.id("logInPanelHeading");
		WebElement logInPanel = driver.findElement(logInPanelTextProperty);

		String expected_OrangeHRMApplicationLogInPageText = "LOGIN Panel";
		System.out.println(" The expected Text of the OrangeHRM Application LogIn Page is :- "
				+ expected_OrangeHRMApplicationLogInPageText);

		String actual_OrangeHRMApplicationLogInPageText = logInPanel.getText();
		System.out.println(" The actual Text of the OrangeHRM Application LogIn Page is :- "
				+ actual_OrangeHRMApplicationLogInPageText);

		if (actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)) {
			System.out.println(" OrangeHRM Application LogIn Page Text Validation Successfull - PASS ");
		} else {
			System.out.println(" OrangeHRM Application LogIn Page Text Validation UNSuccessfull - FAIL ");
		}
		System.out.println("login the webpage");

	}

	@Then("User should close the OrangeHRM Application along with the Browser")
	public void user_should_close_the_orange_hrm_application_along_with_the_browser() {
		driver.close();
		System.out.println("close the application");
	}
}
