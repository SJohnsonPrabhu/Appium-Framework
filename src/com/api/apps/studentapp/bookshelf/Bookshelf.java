package com.api.apps.studentapp.bookshelf;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;

import com.api.android.Android;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.core.MyLogger;
import com.reports.ExtentReport;

public class Bookshelf extends ExtentReport {

	public BookshelfUiObjects uiObject = new BookshelfUiObjects();

	public void tapSearchIcon() {
		test = extent.createTest("Sprint 1 - Tap Search Icon");
		try {
			MyLogger.log.info("Tap the search icon");
			test.log(Status.INFO, MarkupHelper.createLabel("Tap the search icon", ExtentColor.BROWN));
			uiObject.search().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Search icon is not available to tap");
		}
	}

	public void scrollDownToLast() {
		test = extent.createTest("Sprint 1 - Scroll Down");
		try {
			MyLogger.log.info("Scrolling to the last element in the Bookshelf");
			test.log(Status.INFO, MarkupHelper.createLabel("Scrolling to the last element in the Bookshelf", ExtentColor.BROWN));
			uiObject.topElement().scrollDown();
			boolean result = Android.driver
					.findElementByAccessibilityId("CSEC STORY Guidekim John Groove").isDisplayed();
			assertEquals(true, result, "Common Error Message");
			test.log(Status.INFO, MarkupHelper.createLabel("Verification of \"Books\" collection heading to stop scroll up",
					ExtentColor.BROWN));
		} catch (NoSuchElementException e) {
			throw new AssertionError("Unable to scroll till the last element in the screen");
		}
	}

	public void scrollUptoFirst() {
		test = extent.createTest("Sprint 1 - Scroll Up");
		try {
			MyLogger.log.info("Scrolling to the first element in the Bookshelf");
			test.log(Status.INFO, MarkupHelper.createLabel("Scrolling to the first element in the Bookshelf", ExtentColor.BROWN));
			uiObject.lastElement().scrollUp();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Unable to scroll to first element in the screen");
		}
	}

	public void taplistViewIcon() {
		test = extent.createTest("Sprint 1 - Bookshelf List View");
		try {
			MyLogger.log.info("Tap the list view icon");
			test.log(Status.INFO, MarkupHelper.createLabel("Tap the list view icon", ExtentColor.BROWN));
			uiObject.listView().tap();
		}catch (NoSuchElementException e) {
		throw new AssertionError("List view icon is not available to tap");
		}
	}
	
	public void tapCoverViewIcon() {
		test = extent.createTest("Sprint 1 - Bookshelf Cover View");
		try {
			MyLogger.log.info("Tap the cover view icon");
			test.log(Status.INFO, MarkupHelper.createLabel("Tap the cover view icon", ExtentColor.BROWN));
			uiObject.coverView().tap();
		}catch (NoSuchElementException e) {
			throw new AssertionError("Cover view icon is not available to tap");
		}
	}
}
