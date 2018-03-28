package com.api.apps.studentapp.bookshelfSearch;

import org.openqa.selenium.NoSuchElementException;

import com.core.MyLogger;

public class BookshelfSearch {

	public BookshelfSearchUiObjects uiObject = new BookshelfSearchUiObjects();

	public void tapSearchTextbox() {
		try {
			MyLogger.log.info("Tap the search text box");
			uiObject.searchBook().searchTextboxLocation();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Search text box is not available to click");
		}
	}
	
	public void tapBackIcon() {
		try {
			MyLogger.log.info("Tap the back icon");
			uiObject.searchPageBackIcon().searchPageBackIconLocation();
		}catch(NoSuchElementException e) {
			throw new AssertionError("Search page back icon is not avaiable to tap");
		}
	}
	
	public void tapSearchTextCloseIcon() {
		try {
			MyLogger.log.info("Tap the search text close icon");
			uiObject.searchTextCloseIcon().tap();
		}catch(NoSuchElementException e) {
			throw new AssertionError("Search text close icon is not available to tap");
		}
		
	}
}
