package com.api.apps.studentapp.bookshelf;

import com.core.UiObject;
import com.core.UiSelector;

public class BookshelfUiObjects {

	private static UiObject topElement, lastElement, search, listView, coverView, sortOption, sortByAuthors,
			sortByTitle, brightness, brightnessSeekBar, openBook;

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

	public UiObject sortOption() {
		if (sortOption == null)
			sortOption = new UiSelector().descriptionContains("Sort By").makeUiObject();
		return sortOption;
	}

	public UiObject sortByTitle() {
		if (sortByTitle == null)
			sortByTitle = new UiSelector().description("Title").makeUiObject();
		return sortByTitle;
	}

	public UiObject sortByAuthors() {
		if (sortByAuthors == null)
			sortByAuthors = new UiSelector().description("Authors").makeUiObject();
		return sortByAuthors;
	}

	public UiObject brightness() {
		if (brightness == null)
			brightness = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[1]/android.view.View[2]")
					.makeUiObject();
		return brightness;
	}

	public UiObject brightnessSeekBar() {
		if (brightnessSeekBar == null)
			brightnessSeekBar = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[4]/android.widget.SeekBar[1]")
					.makeUiObject();
		return brightnessSeekBar;
	}

	public UiObject openBook() {
		if (openBook == null)
			openBook = new UiSelector().xPath(
					"//android.webkit.WebView[@content-desc='Fpix App']/android.view.View[4]/android.view.View[7]")
					.makeUiObject();
		return openBook;
	}

}
