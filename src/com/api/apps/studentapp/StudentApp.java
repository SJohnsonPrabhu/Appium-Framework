package com.api.apps.studentapp;

import com.api.android.Android;
import com.api.apps.studentapp.bookshelf.Bookshelf;
import com.api.apps.studentapp.bookshelfSearch.BookshelfSearch;
import com.api.interfaces.Application;

public class StudentApp implements Application{
	
	public Bookshelf bookshelf = new Bookshelf();
	public BookshelfSearch bookshelfSearch = new BookshelfSearch();

	@Override
	public void forceStop() {
		Android.adb.forceStop(packageId());
		
	}

	@Override
	public void clearData() {
		Android.adb.clearAppsData(packageId());
		
	}

	@Override
	public Object open() {
		Android.adb.openAppsActivity(packageId(), activityId());
		return null;
	}

	@Override
	public String packageId() {
		return "com.fortunaPix.reader";
	}

	@Override
	public String activityId() {
		return "com.fortunaPix.reader.MainActivity";
	}
}
