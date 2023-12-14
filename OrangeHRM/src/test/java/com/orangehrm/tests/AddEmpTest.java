package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.dataaccess.PropertyUtil;
import com.orangehrm.pages.AddEmpPage;
import com.orangehrm.pages.LoginPage;

public class AddEmpTest extends BaseTest {
	@Test
	public void VerifyAddEmployee() {
		LoginPage loginPage =  new LoginPage(getDriver());
		loginPage.login(PropertyUtil.readProperty("username"), PropertyUtil.readProperty("password"));
		 AddEmpPage  addEmployeePage = new  AddEmpPage (getDriver());
		addEmployeePage. navigateToAddemp();

		String expectedEmpId = addEmployeePage.AddEmpDetails(getData("fname"),getData("lname"));

		addEmployeePage.navigateToEmplist();
		addEmployeePage.verifyRecord(expectedEmpId);
		
	}
}