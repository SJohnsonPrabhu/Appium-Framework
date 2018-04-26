package com.api.apps.studentapp.book;

import com.core.UiObject;
import com.core.UiSelector;

public class BookUiObjects {

	private static UiObject toc;

	public UiObject toc() {
		if (toc == null)
			toc = new UiSelector().description("Table of Contents").makeUiObject();
		return toc;
	}
}
