package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginWithValidCredentials() {

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login("sathish", "Admin");

	}

	@Test
	public void verifyCopyRightText() {

		LoginPage loginPage = new LoginPage(getDriver());

		loginPage.verifyFooterText(getData("copyRightText"));

	}

	@Test
	public void verifyLoginWithInvalidCredentials() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(getData("Username"), getData("Password"));
		loginPage.verifyLoginErrorMessage("Invalid credentials");
	}
	@Test
	public void verifyloginWithBlankPassword(){
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(getData("Username"),getData("Password"));
		loginPage.verifyLoginErrorMessage("Password cannot be empty");

		
	}

}
