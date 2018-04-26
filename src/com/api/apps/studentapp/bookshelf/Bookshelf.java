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
			Thread.sleep(2000);
		} catch (NoSuchElementException | InterruptedException e) {
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
			Thread.sleep(2000);
		} catch (NoSuchElementException | InterruptedException e) {
			throw new AssertionError("List view icon is not available to tap");
		}
	}

	public void tapCoverViewIcon() {
		try {
			MyLogger.log.info("Tap the cover view icon");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the cover view icon", ExtentColor.BROWN));
			uiObject.coverView().tap();
			Thread.sleep(2000);
		} catch (NoSuchElementException | InterruptedException e) {
			throw new AssertionError("Cover view icon is not available to tap");
		}
	}

	public void tapSortOptionDropDown() {
		try {
			MyLogger.log.info("Tap the sort option drop down");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Tap the sort option drop down", ExtentColor.BROWN));
			uiObject.sortOption().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Sort option drop down is not available to tap");
		}
	}

	public void tapSortByTitle() {
		try {
			MyLogger.log.info("Tap the sort by title option");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Tap the sort by title option", ExtentColor.BROWN));
			uiObject.sortByTitle().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Title option is not available to tap");
		}
	}

	public void tapSortByAuthors() {
		try {
			MyLogger.log.info("Tap the sort by authors option");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Tap the sort by authors option", ExtentColor.BROWN));
			uiObject.sortByAuthors().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Authors option is not available to tap");
		}
	}

	public void tapBrightnessIcon() {
		try {
			MyLogger.log.info("Tap the brightness icon");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the brightness icon", ExtentColor.BROWN));
			uiObject.brightness().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Brightness icon is not available to tap");
		}
	}

	public void moveBrightnessSliderToMaximum() {
		try {
			MyLogger.log.info("Slide the brightness seek bar to maximum");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Slide the brightness seek bar to maximum", ExtentColor.BROWN));
			uiObject.brightnessSeekBar().slideToMaximum();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Brightness seek bar is not available to slide");
		}
	}

	public void moveBrightnessSliderToMinimum() {
		try {
			MyLogger.log.info("Slide the brightness seek bar to minimum");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Slide the brightness seek bar to minimum", ExtentColor.BROWN));
			uiObject.brightnessSeekBar().slideToMinimum();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Brightness seek bar is not available to slide");
		}
	}
	
	public void openTheBook() {
		try {
			MyLogger.log.info("Tap the book to open");
			ExtentReport.test.log(Status.INFO,
					MarkupHelper.createLabel("Tap the book to open", ExtentColor.BROWN));
			uiObject.openBook().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Book is not available to open");
		}
	}

}
