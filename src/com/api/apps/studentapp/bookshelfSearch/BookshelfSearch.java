package com.api.apps.studentapp.bookshelfSearch;

import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.core.MyLogger;
import com.reports.ExtentReport;

public class BookshelfSearch extends ExtentReport {

	public BookshelfSearchUiObjects uiObject = new BookshelfSearchUiObjects();

	public void tapSearchTextbox() {
		test = extent.createTest("Sprint 1 - Search Book");
		try {
			MyLogger.log.info("Tap the search text box");
			test.log(Status.INFO, MarkupHelper.createLabel("Tap the search text box", ExtentColor.BROWN));
			uiObject.searchBook().searchTextboxLocation();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Search text box is not available to click");
		}
	}
	
	public void tapBackIcon() {
		test = extent.createTest("Sprint 1 - Back to Bookshelf");
		try {
			MyLogger.log.info("Tap the back icon");
			test.log(Status.INFO, MarkupHelper.createLabel("Tap the back icon", ExtentColor.BROWN));
			uiObject.searchPageBackIcon().searchPageBackIconLocation();
		}catch(NoSuchElementException e) {
			throw new AssertionError("Search page back icon is not avaiable to tap");
		}
	}
	
	public void tapSearchTextCloseIcon() {
		test = extent.createTest("Sprint 1 - Close the Book Search");
		try {
			MyLogger.log.info("Tap the search text close icon");
			test.log(Status.INFO, MarkupHelper.createLabel("Tap the search text close icon", ExtentColor.BROWN));
			uiObject.searchTextCloseIcon().tap();
		}catch(NoSuchElementException e) {
			throw new AssertionError("Search text close icon is not available to tap");
		}
		
	}
}
