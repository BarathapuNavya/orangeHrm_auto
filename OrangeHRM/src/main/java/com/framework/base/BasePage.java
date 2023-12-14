package com.framework.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.framework.reports.ExtentReport;

public class BasePage {
	
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void validateField(String expectedMsg,String actualMsg,String message ) {
		if (expectedMsg.equals(actualMsg)) {

			ExtentReport.logMessage(
					Status.PASS, message + "<b><font color=" + "green" + "><br> Expected value : "
							+ expectedMsg + ".<br> Actual value : " + actualMsg + ".</font><b><br>",
					true);
		} else {

			ExtentReport.logMessage(
					Status.FAIL, message + "<b><font color=" + "red" + "><br> Expected value : "
							+ expectedMsg + ".<br> Actual value : " + actualMsg + ".</font><b><br>",
					true);
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	public void validateField(int expectedValue,int actualValue,String message ) {
		if (expectedValue==actualValue) {

			ExtentReport.logMessage(
					Status.PASS, message + "<b><font color=" + "green" + "><br> Expected value : "
							+ expectedValue + ".<br> Actual value : " + actualValue + ".</font><b><br>",
					true);
		} else {

			ExtentReport.logMessage(
					Status.FAIL, message + "<b><font color=" + "red" + "><br> Expected value : "
							+ expectedValue + ".<br> Actual value : " + actualValue + ".</font><b><br>",
					true);
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	public void validateField(float expectedValue,float actualValue,String message ) {
		if (expectedValue==actualValue) {

			ExtentReport.logMessage(
					Status.PASS, message + "<b><font color=" + "green" + "><br> Expected value : "
							+ expectedValue + ".<br> Actual value : " + actualValue + ".</font><b><br>",
					true);
		} else {

			ExtentReport.logMessage(
					Status.FAIL, message + "<b><font color=" + "red" + "><br> Expected value : "
							+ expectedValue + ".<br> Actual value : " + actualValue + ".</font><b><br>",
					true);
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	public void validateField(boolean expected,boolean actual,String message ) {
		if (expected==actual) {

			ExtentReport.logMessage(
					Status.PASS, message + "<b><font color=" + "green" + "><br> Expected value : "
							+ expected + ".<br> Actual value : " + actual + ".</font><b><br>",
					true);
		} else {

			ExtentReport.logMessage(
					Status.FAIL, message + "<b><font color=" + "red" + "><br> Expected value : "
							+ expected + ".<br> Actual value : " + actual + ".</font><b><br>",
					true);
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}

	
	
	public void validateFieldContains(String expectedMsg,String actualMsg,String message ) {
		if (actualMsg.contains(expectedMsg)) {

			ExtentReport.logMessage(
					Status.PASS, message + "<b><font color=" + "green" + "><br> Expected value : "
							+ expectedMsg + ".<br> Actual value : " + actualMsg + ".</font><b><br>",
					true);
		} else {

			ExtentReport.logMessage(
					Status.FAIL, message + "<b><font color=" + "red" + "><br> Expected value : "
							+ expectedMsg + ".<br> Actual value : " + actualMsg + ".</font><b><br>",
					true);
			Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
		}
	}
	
	public void jsClickOnElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public WebDriver getDriver() {
		return  driver;
	}

}
