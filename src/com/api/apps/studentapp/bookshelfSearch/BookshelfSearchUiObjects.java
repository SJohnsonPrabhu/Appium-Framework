package com.api.apps.studentapp.bookshelfSearch;

import com.core.UiObject;
import com.core.UiSelector;

public class BookshelfSearchUiObjects {

	private static UiObject searchBook, searchPageBackIcon, searchTextCloseIcon;

	public UiObject searchBook() {
		if (searchBook == null)
			searchBook = new UiSelector().description("Search").makeUiObject();
		return searchBook;
	}

	public UiObject searchPageBackIcon() {
		if (searchPageBackIcon == null)
			searchPageBackIcon = new UiSelector().descriptionContains("Bookshelf").makeUiObject();
		return searchPageBackIcon;
	}

	public UiObject searchTextCloseIcon() {
		if (searchTextCloseIcon == null)
			searchTextCloseIcon = new UiSelector()
					.xPath("//android.webkit.WebView[@content-desc='Fpix App']/android.widget.Button[2]")
					.makeUiObject();
		return searchTextCloseIcon;
	}
}
