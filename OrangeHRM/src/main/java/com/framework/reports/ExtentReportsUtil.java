package com.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsUtil {

	public static void main(String args[]) {

		String path = System.getProperty("user.dir") + "\\reports\\Testreports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		reporter.config().setDocumentTitle("Orange HRM Report");
		reporter.config().setReportName("OrangeHRM execution");

		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "chrome");

		ExtentTest test = extent.createTest("verifyLoginWithValidCredentials");

		test.assignCategory("Login");
		test.log(Status.PASS, "Launch Application");

		test.log(Status.PASS, "Enter Valid Username");
		test.log(Status.PASS, "Enter valid password");
		test.log(Status.PASS, "Click on Login");
		test.log(Status.FAIL, "Verify Success Message");

		ExtentTest test1 = extent.createTest("verifyLoginWithBlankUsername");
		test1.assignCategory("Login");
		test1.log(Status.PASS, "Launch Application");

		test1.log(Status.PASS, "Leave Username Blank");
		test1.log(Status.PASS, "Enter password");
		test1.log(Status.PASS, "Click on Login");
		test1.log(Status.PASS, "Verify Error Message");

		ExtentTest test2 = extent.createTest("VerifyAddUser");

		test2.assignCategory("User management");

		test2.log(Status.PASS, "Launch Application");

		test2.log(Status.PASS, "ENter username");
		test2.log(Status.PASS, "Enter password");
		test2.log(Status.PASS, "Click on Login");
		test2.log(Status.FAIL, "Verify Error Message");

		extent.flush();

	}
}
