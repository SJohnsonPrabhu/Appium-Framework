package com.core;

public class UiSelector {

	private String locator="new UiSelector()";

	public UiSelector xPath(String xPath) {
		locator = xPath;
		return this;
	}

	public UiSelector index(int value) {
		locator += ".index(" + value + ")";
		return this;
	}

	public UiSelector text(String value) {
		locator += ".text(\"" + value + "\")";
		System.out.println(value);
		return this;
	}

	public UiSelector textContains(String value) {
		locator += ".textContains(\"" + value + "\")";
		return this;
	}

	public UiSelector resourceId(String value) {
		locator += ".resourceId(\"" + value + "\")";
		return this;
	}

	public UiSelector className(String value) {
		locator += ".className(\"" + value + "\")";
		return this;
	}

	public UiSelector classNameMatches(String regex) {
		locator += ".classNameMatches(\"" + regex + "\")";
		return this;
	}

	public UiSelector description(String value) {
		locator += ".description(\"" + value + "\")";
		return this;
	}

	public UiSelector descriptionContains(String value) {
		locator += ".descriptionContains(\"" + value + "\")";
		return this;
	}

	public UiSelector descriptionMatches(String regex) {
		locator += ".descriptionMatches(\"" + regex + "\")";
		return this;
	}

	public UiSelector enabled(boolean value) {
		locator += ".enabled(" + value + ")";
		return this;
	}

	public UiSelector checked(boolean value) {
		locator += ".checked(" + value + ")";
		return this;
	}

	public UiSelector longClickable(boolean value) {
		locator += ".longClickable(" + value + ")";
		return this;
	}

	public UiSelector scrollable(boolean value) {
		locator += ".scrollable(" + value + ")";
		return this;
	}

	public UiObject makeUiObject() {
		return new UiObject(locator);
	}

}
