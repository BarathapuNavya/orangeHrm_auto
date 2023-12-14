package com.framework.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.dataaccess.ExcelUtil;
import com.framework.dataaccess.PropertyUtil;
import com.framework.reports.ExtentReport;

public class BaseTest {
	private static WebDriver driver;
	String testName;
	public static ExtentTest test;

	@BeforeSuite
	public void initialize() throws IOException {
		PropertyUtil.initializeProperty();
		ExcelUtil.initializeExcel();
		ExcelUtil.readAllDataFromExcel();
		ExtentReport.initializeReport();
	}

	@BeforeMethod
	public void launchBrowser(Method methodName,ITestContext context) {
		testName = methodName.getName();   
		String moduleName = context.getName();
		test = ExtentReport.createExtentTest(testName, moduleName);
		String browserName = PropertyUtil.readProperty("browserName");
		String path = System.getProperty("user.dir");
		String runMode=PropertyUtil.readProperty("runMode");;
	//if(runMode.equals("Local")) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", path + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	/*}else if(runMode.equals("Grid")) {
		String hubUrl = PropertyUtil.readProperty("hubUrl");

		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			try {
				driver = new RemoteWebDriver(new URL(hubUrl), capability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}else {
		System.out.println("Looks like you given incorrect runMode");*/
	
		
		ExtentReport.logMessage(Status.PASS, "Launch Browser", false);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	
	}
	@BeforeMethod(dependsOnMethods = "launchBrowser")
	public void launchApplication() {
		String url = PropertyUtil.readProperty("url");
		driver.get(url);
		ExtentReport.logMessage(Status.PASS, "Launch Application: "+url, true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public String getData(String colName) {
		String value = ExcelUtil.readData(testName, colName);
	     return value;
	}
	
	@AfterSuite
	public static void tearDown() {
		ExtentReport.flushTests();
	}

}
