package com.api.apps.studentapp.bookshelf;

import org.openqa.selenium.NoSuchElementException;

import com.core.MyLogger;

public class Bookshelf {

	public BookshelfUiObjects uiObject = new BookshelfUiObjects();

	public void tapSearchIcon() {
		try {
			MyLogger.log.info("Tap the search icon");
			uiObject.search().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Search icon is not available to tap");
		}
	}

	public void scrollDownToLast() {
		try {
			MyLogger.log.info("Scrolling to the last element in the Bookshelf");
			uiObject.topElement().scrollDown();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Unable to scroll till the last element in the screen");
		}
	}

	public void scrollUptoFirst() {
		try {
			MyLogger.log.info("Scrolling to the first element in the Bookshelf");
			uiObject.lastElement().scrollUp();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Unable to scroll to first element in the screen");
		}
	}

	public void taplistViewIcon() {
		try {
			MyLogger.log.info("Tap the list view icon");
			uiObject.listView().tap();
		}catch (NoSuchElementException e) {
		throw new AssertionError("List view icon is not available to tap");
		}
	}
	
	public void tapCoverViewIcon() {
		try {
			MyLogger.log.info("Tap the cover view icon");
			uiObject.coverView().tap();
		}catch (NoSuchElementException e) {
			throw new AssertionError("Cover view icon is not available to tap");
		}
	}
}
