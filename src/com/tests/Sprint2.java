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
	
//	@Test(priority=9)
//	public void 
	
	
	
	
	
	
	

}
