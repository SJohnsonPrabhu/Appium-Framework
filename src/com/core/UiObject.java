package com.core;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.api.android.Android;

import io.appium.java_client.TouchAction;

public class UiObject {

	private String locator;

	UiObject(String locator) {
		this.locator = locator;
		// MyLogger.log.info("New UiObject is: " + this.locator);
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
		return this;
	}
}
