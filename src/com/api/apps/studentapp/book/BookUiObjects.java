package com.api.apps.studentapp.book;

import com.core.UiObject;
import com.core.UiSelector;

public class BookUiObjects {

	private static UiObject toc, bookToBookshelf, enableHeaderFooter, brightnessIcon;

	public UiObject toc() {
		if (toc == null)
			toc = new UiSelector().descriptionContains("Table").makeUiObject();
		return toc;
	}

	public UiObject backToBookshelf() {
		if (bookToBookshelf == null)
			bookToBookshelf = new UiSelector().description("Bookshelf").makeUiObject();
		return bookToBookshelf;
	}

	public UiObject enableHeaderFooter() {
		if (enableHeaderFooter == null)
			enableHeaderFooter = new UiSelector().descriptionContains("Page").makeUiObject();
		return enableHeaderFooter;
	}

	public UiObject brightnessIcon() {
		if (brightnessIcon == null)
			brightnessIcon = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[1]/android.view.View[2]/android.view.View[4]")
					.makeUiObject();
		return brightnessIcon;
	}
}
