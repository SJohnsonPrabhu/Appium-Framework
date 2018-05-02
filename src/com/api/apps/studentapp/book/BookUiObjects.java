package com.api.apps.studentapp.book;

import com.core.UiObject;
import com.core.UiSelector;

public class BookUiObjects {

	private static UiObject toc, bookToBookshelf, enableHeaderFooter, brightnessIcon, brightnessSeekBar, nightMode,
			defaultMode;

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

	public UiObject brightnessSeekBar() {
		if (brightnessSeekBar == null)
			brightnessSeekBar = new UiSelector()
					.xPath("//android.webkit.WebView[@content-desc='Fpix App']/android.widget.SeekBar[1]")
					.makeUiObject();
		return brightnessSeekBar;
	}

	public UiObject nightMode() {
		if (nightMode == null)
			nightMode = new UiSelector().description("NIGHT").makeUiObject();
		return nightMode;
	}

	public UiObject defaultMode() {
		if (defaultMode == null)
			defaultMode = new UiSelector().description("DEFAULT").makeUiObject();
		return defaultMode;
	}
}
