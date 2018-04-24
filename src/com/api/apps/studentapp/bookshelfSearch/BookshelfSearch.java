package com.api.apps.studentapp.bookshelfSearch;

import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.core.MyLogger;
import com.reports.ExtentReport;

public class BookshelfSearch {

	public BookshelfSearchUiObjects uiObject = new BookshelfSearchUiObjects();

	public void tapSearchTextbox() {
		try {
			MyLogger.log.info("Tap the search text box");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the search text box", ExtentColor.BROWN));
			uiObject.searchBook().searchTextboxLocation();
			
		} catch (NoSuchElementException e) {
			throw new AssertionError("Search text box is not available to click");
		}
	}

	public void tapBackIcon() {
		try {
			MyLogger.log.info("Tap the back icon");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the back icon", ExtentColor.BROWN));
			uiObject.searchPageBackIcon().searchPageBackIconLocation();
			Thread.sleep(2000);
		} catch (NoSuchElementException | InterruptedException e) {
			throw new AssertionError("Search page back icon is not avaiable to tap");
		}
	}

	public void tapSearchTextCloseIcon() {
		try {
			MyLogger.log.info("Tap the search text close icon");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Tap the search text close icon", ExtentColor.BROWN));
			uiObject.searchTextCloseIcon().tap();
			Thread.sleep(2000);
		} catch (NoSuchElementException | InterruptedException e) {
			throw new AssertionError("Search text close icon is not available to tap");
		}

	}
}
