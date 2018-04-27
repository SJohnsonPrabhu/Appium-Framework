package com.tests;

import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.studentapp.StudentApp;
import com.reports.ExtentReport;

public class Sprint2 extends ExtentReport {

	private static StudentApp studentApp = Android.app.studentApp;

	@Test(priority = 0)
	public void tapSortOption() {
		test = extent.createTest("Sprint 2 - Tap Sort Option");
		studentApp.bookshelf.tapSortOptionDropDown();
		studentApp.bookshelf.uiObject.sortOption().waitToAppear(2);
	}

	@Test(priority = 1)
	public void sortTitleInDescending() {
		test = extent.createTest("Sprint 2 - Sort Title in Descending");
		studentApp.bookshelf.tapSortByTitle();
		studentApp.bookshelf.uiObject.sortOption().waitToAppear(2);
	}

	@Test(priority = 2)
	public void sortTitleInAscending() {
		test = extent.createTest("Sprint 2 - Sort Title in Ascending");
		studentApp.bookshelf.tapSortOptionDropDown();
		studentApp.bookshelf.tapSortByTitle();
		studentApp.bookshelf.uiObject.sortOption().waitToAppear(2);
	}

	@Test(priority = 3)
	public void sortAuthorsInDescending() {
		test = extent.createTest("Sprint 2 - Sort Authors in Descending");
		studentApp.bookshelf.tapSortOptionDropDown();
		studentApp.bookshelf.tapSortByAuthors();
		studentApp.bookshelf.uiObject.sortOption().waitToAppear(2);
	}

	@Test(priority = 4)
	public void sortAuthorsInAscending() {
		test = extent.createTest("Sprint 2 - Sort Authors in Ascending");
		studentApp.bookshelf.tapSortOptionDropDown();
		studentApp.bookshelf.tapSortByAuthors();
		studentApp.bookshelf.uiObject.sortOption().waitToAppear(2);
	}

	@Test(priority = 5)
	public void tapBrightnessIcon() {
		test = extent.createTest("Sprint 2 - Tap the Brightness Icon");
		studentApp.bookshelf.tapBrightnessIcon();
		studentApp.bookshelf.uiObject.brightnessSeekBar().waitToAppear(2);
	}

	@Test(priority = 6)
	public void slideToMaximum() {
		test = extent.createTest("Sprint 2 - Brightness slider to maximum");
		studentApp.bookshelf.moveBrightnessSliderToMaximum();
		studentApp.bookshelf.uiObject.brightnessSeekBar().waitToAppear(2);
	}

	@Test(priority = 7)
	public void slideToMinimum() {
		test = extent.createTest("Sprint 2 - Brightness slider to minimum");
		studentApp.bookshelf.moveBrightnessSliderToMinimum();
		studentApp.bookshelf.uiObject.brightnessSeekBar().waitToAppear(2);
	}
	
	@Test(priority=8)
	public void openTheBook() {
		test = extent.createTest("Sprint 2 - Open the Book");
		studentApp.bookshelf.openTheBook();
		studentApp.book.uiObject.toc().waitToAppear(2);
	}
	
	@Test(priority=9)
	public void openTocSection() {
		test = extent.createTest("Sprint 2 - Open the ToC section");
		studentApp.book.tapTocSection();
	}
	
	@Test(priority=10)
	public void tapToEnableHeaderFooter() {
		test = extent.createTest("Sprint 2 - View the Header and Footer");
		studentApp.book.tapToEnableHeaderFooter();
	}
	
	@Test(priority=11)
	public void bookToBookshelf() {
		test = extent.createTest("Sprint 2 - Back to Bookshelf Page");
		studentApp.book.tapBackToBookshelf();
	}
	
	@Test(priority=12)
	public void tapBookBrightnessIcon() {
		test = extent.createTest("Sprint 2 - Tap the Brightness Icon");
		studentApp.bookshelf.openTheBook();
		studentApp.book.tapToEnableHeaderFooter();
		studentApp.book.tapBrightnessIcon();
	}

	
	
	
	

}
