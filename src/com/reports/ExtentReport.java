package com.reports;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport extends Screenshot{

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setUpExtentReport() {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/StudentAppTR.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Operating System", "Ubuntu");
		extent.setSystemInfo("Sprint", "One");
		extent.setSystemInfo("QA Name", "Johnson Prabhu");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			String failScreenshotPath = captureScreenshot(result, "Fail");
			test.log(Status.INFO,"Kindly refer below Screenshot for more information: ");
			test.addScreenCaptureFromPath(failScreenshotPath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));
			String passScreenshotPath = captureScreenshot(result, "Pass");
			test.log(Status.INFO,"Kindly refer below Screenshot for more information: ");
			test.addScreenCaptureFromPath(passScreenshotPath);
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.PURPLE));
			test.skip(result.getThrowable());
			String skipScreenshotPath = captureScreenshot(result, "Skip");
			test.log(Status.INFO,"Kindly refer below Screenshot for more information: ");
			test.addScreenCaptureFromPath(skipScreenshotPath);
		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
