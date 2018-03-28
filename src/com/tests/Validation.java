package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.studentapp.StudentApp;
import com.core.managers.TestManager;

public class Validation extends TestManager{
	
	private static StudentApp studentApp = Android.app.studentApp;
	
	@Test
	public void fieldValidation() {
		testInfo.tcId("TC001").name("Checking the bookshelf having all elements");
		Assert.assertTrue(studentApp.bookshelf.uiObject.search().exists());
	}

}
