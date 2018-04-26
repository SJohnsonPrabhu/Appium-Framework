package com.api.apps.studentapp.book;

import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.core.MyLogger;
import com.reports.ExtentReport;

public class Book {

	public BookUiObjects uiObject = new BookUiObjects();

	public void tocPage() {
		try {
			MyLogger.log.info("View ToC Page");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("View ToC Page", ExtentColor.BROWN));
			uiObject.toc().exists();
		} catch (NoSuchElementException e) {
			throw new AssertionError("ToC page is not available to view");
		}
	}

}
