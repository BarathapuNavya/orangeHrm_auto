package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.aventstack.extentreports.Status;
import com.framework.base.BasePage;
import com.framework.reports.ExtentReport;

public class LoginPage extends BasePage {

	@FindBy(id = "txtUsername")
	WebElement textBox_UserName;

	@FindBy(id = "txtPassword")
	WebElement textBox_Password;

	@FindBy(id = "btnLogin")
	WebElement button_Login;

	@FindBy(id = "spanCopyright")
	WebElement label_CopyRightText;

	@FindBy(id = "spanMessage")
	WebElement errorMsg_Login;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String uname, String pwd) {

		textBox_UserName.sendKeys(uname);
		ExtentReport.logMessage(Status.PASS, "Enter Username: " + uname, false);
		textBox_Password.sendKeys(pwd);
		ExtentReport.logMessage(Status.PASS, "Enter Password:xxx", false);
		button_Login.click();
		ExtentReport.logMessage(Status.PASS, "Click on Login", true);
	}

	public void verifyFooterText(String expectedMsg) {

		String actualMsg = label_CopyRightText.getText();

		validateField(expectedMsg, actualMsg, "Verify footer message");

	}

	public void verifyLoginErrorMessage(String expectedMessage) {
		String actualMessage = errorMsg_Login.getText();

		validateField(expectedMessage, actualMessage, "Verify error message");

	}

}
