package com.reports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.api.android.Android;

public class Screenshot {

	public static String captureScreenshot(ITestResult result, String status) {

		String destDir = "";
		new File(destDir).mkdirs();

		String methodName = result.getMethod().getRealClass().getSimpleName() + "_"
				+ result.getMethod().getMethodName();

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_HH:mm:ss_aa");

		if (status.equalsIgnoreCase("Fail")) {
			destDir = System.getProperty("user.dir") + "/screenshot/Failures";
		} else if (status.equalsIgnoreCase("Pass")) {
			destDir = System.getProperty("user.dir") + "/screenshot/Success";
		} else {
			destDir = System.getProperty("user.dir") + "/screenshot/Skipped";
		}

		File source = ((TakesScreenshot) Android.driver).getScreenshotAs(OutputType.FILE);
		String dest = destDir + "/" + methodName + "_" + dateFormat.format(new Date()) + ".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dest;
	}
}
