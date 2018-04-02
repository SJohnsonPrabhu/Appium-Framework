package com.api.apps.studentapp.bookshelf;

import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.core.MyLogger;
import com.reports.ExtentReport;

public class Bookshelf {

	public BookshelfUiObjects uiObject = new BookshelfUiObjects();

	public void tapSearchIcon() {
		try {
			MyLogger.log.info("Tap the search icon");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the search icon", ExtentColor.BROWN));
			uiObject.search().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Search icon is not available to tap");
		}
	}

	public void scrollDownToLast() {
		try {
			MyLogger.log.info("Scrolling to the last element in the Bookshelf");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Scrolling to the last element in the Bookshelf", ExtentColor.BROWN));
			uiObject.topElement().scrollDown();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Unable to scroll till the last element in the screen");
		}
	}

	public void scrollUptoFirst() {
		try {
			MyLogger.log.info("Scrolling to the first element in the Bookshelf");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Scrolling to the first element in the Bookshelf", ExtentColor.BROWN));
			uiObject.lastElement().scrollUp();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Unable to scroll to first element in the screen");
		}
	}

	public void taplistViewIcon() {
		try {
			MyLogger.log.info("Tap the list view icon");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the list view icon", ExtentColor.BROWN));
			uiObject.listView().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("List view icon is not available to tap");
		}
	}

	public void tapCoverViewIcon() {
		try {
			MyLogger.log.info("Tap the cover view icon");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the cover view icon", ExtentColor.BROWN));
			uiObject.coverView().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Cover view icon is not available to tap");
		}
	}
}
