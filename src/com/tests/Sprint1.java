package com.tests;

import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.studentapp.StudentApp;
import com.reports.ExtentReport;

public class Sprint1 extends ExtentReport{

	private static StudentApp studentApp = Android.app.studentApp;

	@Test (priority = 0)
	public void scrollDownToLast() {
		test = extent.createTest("Sprint 1 - Scroll Down");
		studentApp.bookshelf.scrollDownToLast();
	}
	
	@Test (priority = 1)
	public void scrollUptoFirst() {
		test = extent.createTest("Sprint 1 - Scroll Up");
		studentApp.bookshelf.scrollUptoFirst();
	}
	
	@Test (priority = 2)
	public void tapSearchIcon() {
		test = extent.createTest("Sprint 1 - Tap Search Icon");
		studentApp.bookshelf.tapSearchIcon();
	}
	
	@Test (priority = 3)
	public void tapSearchTextbox() {
		test = extent.createTest("Sprint 1 - Tap Search Text Box");
		studentApp.bookshelfSearch.tapSearchTextbox();
	}
	
	@Test (priority = 4)
	public void searchBookByBookName() {
		test = extent.createTest("Sprint 1 - Search Book by Book Name");
		studentApp.bookshelfSearch.uiObject.searchBook().typeKeys("book4");
	}
	
	@Test (priority = 5)
	public void tapSearchTextCloseIcon() {
		test = extent.createTest("Sprint 1 - Close the Book Search");
		studentApp.bookshelfSearch.tapSearchTextCloseIcon();
	}
	
	@Test (priority = 6)
	public void searchBookByAuthorName() {
		test = extent.createTest("Sprint 1 - Search Book by Author Name");
		studentApp.bookshelfSearch.uiObject.searchBook().typeKeys("Math");
	}
	
	@Test (priority = 7)
	public void tapBackIcon() {
		test = extent.createTest("Sprint 1 - Back to Bookshelf");
		studentApp.bookshelfSearch.tapBackIcon();
	}
	
	@Test (priority = 8)
	public void tapCoverViewIcon() {
		test = extent.createTest("Sprint 1 - Bookshelf Cover View");
		studentApp.bookshelf.tapCoverViewIcon();
	}
	
	@Test (priority = 9)
	public void taplistViewIcon() {
		test = extent.createTest("Sprint 1 - Bookshelf List View");
		studentApp.bookshelf.taplistViewIcon();
	}
}
