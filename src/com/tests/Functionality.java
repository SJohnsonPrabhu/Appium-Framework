package com.tests;

import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.studentapp.StudentApp;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentReport;


public class Functionality extends ExtentReport {

	private static StudentApp studentApp = Android.app.studentApp;

	@Test
	public void sprint1() {
		
		test = extent.createTest("Sprint 1 Use Cases");
		test.log(Status.INFO, MarkupHelper.createLabel("Element Identification to scroll down", ExtentColor.BROWN));
		
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
