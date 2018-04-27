package com.api.apps.studentapp.book;

import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.core.MyLogger;
import com.reports.ExtentReport;

public class Book {

	public BookUiObjects uiObject = new BookUiObjects();

	public void tapTocSection() {
		try {
			MyLogger.log.info("Tap the ToC Section");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the ToC Section", ExtentColor.BROWN));
			uiObject.toc().tapMiddleOfThePage();
		} catch (NoSuchElementException e) {
			throw new AssertionError("ToC page is not available to tap the section");
		}
	}

	public void tapBackToBookshelf() {
		try {
			MyLogger.log.info("Tap the back icon in book to move to bookshelf page");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the back icon in book to move to bookshelf page", ExtentColor.BROWN));
			uiObject.backToBookshelf().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Bookshelf icon in book page is not available to tap");
		}
	}
	
	public void tapToEnableHeaderFooter() {
		try {
			MyLogger.log.info("Tap the book page to enable header and footer");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the book page to enable header and footer", ExtentColor.BROWN));
			uiObject.enableHeaderFooter().tapMiddleOfThePage();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Book page is not available to tap");
		}
	}
	
	public void tapBrightnessIcon() {
		try {
			MyLogger.log.info("Tap the brightness icon in the header");
			ExtentReport.test.log(Status.INFO, MarkupHelper.createLabel("Tap the brightness icon in the header", ExtentColor.BROWN));
			uiObject.brightnessIcon().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Brightness icon is not available to tap");
		}
	}
}
