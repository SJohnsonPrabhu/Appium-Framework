package com.api.apps.studentapp.bookshelf;

import com.core.UiObject;
import com.core.UiSelector;

public class BookshelfUiObjects {

	private static UiObject topElement, lastElement, search, listView, coverView;

	public UiObject search() {
		if (search == null)
			search = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[2]/android.view.View[3]")
					.makeUiObject();
		return search;
	}

	public UiObject topElement() {
		if (topElement == null)
			topElement = new UiSelector().descriptionContains("BOOK").makeUiObject();
		return topElement;
	}

	public UiObject lastElement() {
		if (lastElement == null)
			lastElement = new UiSelector().descriptionContains("COURSES").makeUiObject();
		return lastElement;
	}

	public UiObject listView() {
		if (listView == null)
			listView = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[2]/android.view.View[2]")
					.makeUiObject();
		return listView;
	}

	public UiObject coverView() {
		if (coverView == null)
			coverView = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[2]/android.view.View[2]")
					.makeUiObject();
		return coverView;
	}

}
