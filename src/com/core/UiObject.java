package com.core;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.xpath.operations.And;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.api.android.Android;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentReport;

import io.appium.java_client.TouchAction;

public class UiObject {

	private String locator;

	UiObject(String locator) {
		this.locator = locator;
	}

	private boolean isxPath() {
		return !locator.contains("UiSelector");
	}

	public boolean exists() {
		try {
			WebElement element;
			if (isxPath())
				element = Android.driver.findElementByXPath(locator);
			else
				element = Android.driver.findElementByAndroidUIAutomator(locator);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isCheckable() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("checkable").equals("true");
	}

	public boolean isChecked() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("checked").equals("true");
	}

	public boolean isClickable() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("clickable").equals("true");
	}

	public boolean isEnabled() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("enabled").equals("true");
	}

	public boolean isFocusable() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("focusable").equals("true");
	}

	public boolean isFocused() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("focused").equals("true");
	}

	public boolean isScrollable() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("scrollable").equals("true");
	}

	public boolean isLongClickable() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("longClickable").equals("true");
	}

	public boolean isSelected() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("selected").equals("true");
	}

	public Point getLocation() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getLocation();
	}

	public String getText() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("name");
	}

	public String getResourceId() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("resourceId");
	}

	public String getClassName() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("className");
	}

	public String getContentDesc() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("contentDesc");
	}

	public UiObject clearText() {
		if (isxPath())
			Android.driver.findElementByXPath(locator).clear();
		else
			Android.driver.findElementByAndroidUIAutomator(locator).clear();
		return this;
	}

	public UiObject typeKeys(String value) {
		if (isxPath())
			Android.driver.findElementByXPath(locator).sendKeys(value);
		else
			Android.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);
		return this;
	}

	public UiObject tap() {
		if (isxPath())
			Android.driver.findElementByXPath(locator).click();
		else
			Android.driver.findElementByAndroidUIAutomator(locator).click();
		return this;
	}

	public UiObject scrollDown() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);

		int startX = (int) (Android.driver.manage().window().getSize().getWidth() / 2);
		int startY = (int) (Android.driver.manage().window().getSize().getHeight() * 3 / 4);
		int endX = (int) (Android.driver.manage().window().getSize().getWidth() / 2);
		int endY = (int) (Android.driver.manage().window().getSize().getHeight() / 4);

		TouchAction actions = new TouchAction(Android.driver);
		int scroll;
		for (scroll = 0; scroll < 10; scroll++) {
			actions.press(startX, startY).waitAction(Duration.ofSeconds(1)).moveTo(endX, endY).release().perform();
		}
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Reached the bottom of the screen", ExtentColor.BROWN));
		return this;
	}

	public UiObject scrollUp() {

		int startX = (int) (Android.driver.manage().window().getSize().getWidth() / 2);
		int startY = (int) (Android.driver.manage().window().getSize().getHeight() / 4);
		int endX = (int) (Android.driver.manage().window().getSize().getWidth() / 2);
		int endY = (int) (Android.driver.manage().window().getSize().getHeight() * 3 / 4);

		TouchAction actions = new TouchAction(Android.driver);
		int scroll;
		for (scroll = 0; scroll < 10; scroll++) {
			actions.press(startX, startY).waitAction(Duration.ofSeconds(1)).moveTo(endX, endY).release().perform();
		}
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Reached the top of the screen", ExtentColor.BROWN));
		return this;
	}

	public UiObject waitToAppear(int seconds) {
		Timer timer = new Timer();
		timer.start();
		while (!timer.expired(seconds))
			if (exists())
				break;
		if (timer.expired(seconds) && !exists())
			throw new AssertionError("Element " + locator + " failed to appear within " + seconds + " seconds");
		return this;
	}

	public UiObject waitToDisappear(int seconds) {
		Timer timer = new Timer();
		timer.start();
		while (!timer.expired(seconds))
			if (!exists())
				break;
		if (timer.expired(seconds) && exists())
			throw new AssertionError("Element " + locator + " failed to disapper within " + seconds + " seconds");
		return this;
	}

	public UiObject searchTextboxLocation() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);

		Point elementLocation = element.getLocation();
		int searchStartX = (int) (elementLocation.x * 8);
		int searchStartY = (int) (elementLocation.y);

		TouchAction actions = new TouchAction(Android.driver);
		actions.tap(searchStartX, searchStartY).perform();
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Search text box tapped to enter search keyword", ExtentColor.BROWN));
		return this;
	}

	public UiObject searchPageBackIconLocation() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);

		Point elementLocation = element.getLocation();
		int backIconX = (int) (elementLocation.x * 2);
		int backIconY = (int) (elementLocation.y);

		TouchAction actions = new TouchAction(Android.driver);
		actions.tap(backIconX, backIconY).perform();
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Back icon tapped from the search page", ExtentColor.BROWN));
		return this;
	}

	public UiObject slideToMaximum() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);

		Point elementLocation = element.getLocation();
		int sliderEndX = (int) (elementLocation.x * 23);
		int sliderEndY = (int) (elementLocation.y);

		TouchAction actions = new TouchAction(Android.driver);
		actions.longPress(element).moveTo(sliderEndX, sliderEndY).release().perform();
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Slider seek bar is moved to increase the brightness", ExtentColor.BROWN));
		return this;
	}

	public UiObject slideToMinimum() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);

		Point elementLocation = element.getLocation();
		int sliderEndX = (int) (elementLocation.x / 18);
		int sliderEndY = (int) (elementLocation.y);

		TouchAction actions = new TouchAction(Android.driver);
		actions.longPress(element).moveTo(sliderEndX, sliderEndY).release().perform();
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Slider seek bar is moved to increase the brightness", ExtentColor.BROWN));
		return this;
	}

	public UiObject tapMiddleOfThePage() {
		WebElement element;
		if (isxPath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);

		int pageMiddleX = (int) (Android.driver.manage().window().getSize().getHeight() / 2 );
		int pageMiddleY = (int) (Android.driver.manage().window().getSize().getWidth() / 4 + 20);
		
		TouchAction actions = new TouchAction(Android.driver);
		actions.tap(pageMiddleX, pageMiddleY).perform();
		ExtentReport.test.log(Status.INFO,
				MarkupHelper.createLabel("Slider seek bar is moved to increase the brightness", ExtentColor.BROWN));
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
