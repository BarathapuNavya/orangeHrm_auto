package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.framework.base.BasePage;
import com.framework.reports.ExtentReport;

public class AddEmpPage extends BasePage {


	@FindBy(id = "menu_pim_addEmployee")
	WebElement addemploye_link;

	@FindBy(id = "firstName")
	WebElement textbox_fname;

	@FindBy(id = "lastName")
	WebElement textbox_lname;

	@FindBy(id = "employeeId")
	WebElement textbox_empid;

	@FindBy(id = "btnSave")
	WebElement button_save;

	@FindBy(id = "menu_pim_viewEmployeeList")
	WebElement emplink_List;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
	List<WebElement> table_record;

	public AddEmpPage(WebDriver driver) {
		super(driver);
	}

	public void navigateToAddemp() {
		 addemploye_link.click();
	}

	public String AddEmpDetails(String firstname, String lastname) {
		textbox_fname.sendKeys(firstname);
		ExtentReport.logMessage(Status.PASS, "Enter Firstname:" + firstname, false);
		textbox_lname.sendKeys(lastname);
		ExtentReport.logMessage(Status.PASS, "Enter Lastname:" + lastname, false);
		String ExpectedId = textbox_empid.getAttribute("value");
		button_save.click();
		ExtentReport.logMessage(Status.PASS, "Click on save", true);
		return ExpectedId;

	}

	public void navigateToEmplist() {
		emplink_List.click();
		ExtentReport.logMessage(Status.PASS, "click on emplist", false);
	}

	public void verifyRecord(String expectedId) {

		String actualId = null;
		boolean status = false;

		for (WebElement id : table_record) {
			actualId = id.getText();
			if (actualId.equals(expectedId)) {
				status = true;
				break;
			}
		}

		validateField(expectedId, actualId, "Verify the record");

		System.out.println("verify the record-expected empId:" + expectedId + "actual empid:" + actualId);
	}

}
