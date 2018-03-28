package com.api.android;

import org.openqa.selenium.WebElement;

import com.api.apps.Apps;
import com.core.ADB;

import io.appium.java_client.android.AndroidDriver;

public class Android {
	
	public static AndroidDriver<WebElement> driver;
	public static ADB adb;
	public static Apps app = new Apps();

}
