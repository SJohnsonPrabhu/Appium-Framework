package com.tests;

import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.studentapp.StudentApp;
import com.core.managers.TestManager;

public class Functionality extends TestManager {

	private static StudentApp studentApp = Android.app.studentApp;

	@Test
	public void sprint1() {
		studentApp.bookshelf.scrollDownToLast();
		studentApp.bookshelf.scrollUptoFirst();

		studentApp.bookshelf.tapSearchIcon();
		studentApp.bookshelfSearch.tapSearchTextbox();
		studentApp.bookshelfSearch.uiObject.searchBook().typeKeys("book4");
		studentApp.bookshelfSearch.tapSearchTextCloseIcon();
		studentApp.bookshelfSearch.uiObject.searchBook().typeKeys("Math");
		studentApp.bookshelfSearch.tapBackIcon();

		studentApp.bookshelf.tapCoverViewIcon();
		studentApp.bookshelf.taplistViewIcon();
	}
}
