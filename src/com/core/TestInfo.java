package com.core;

public class TestInfo {
	
	private static String TIMESTAMP, VERSION, SUITEID, TCID, NAME, EXCEPTED, ACTUAL, REMARKS;
	
	public void reset() {
		TIMESTAMP = null;
		VERSION = null;
		SUITEID = null;
		TCID = null;
		NAME = null;
		EXCEPTED = null;
		ACTUAL = null;
		REMARKS = null;
	}
	
	public TestInfo timestamp(String value) {
		TIMESTAMP = value;
		return this;
	}

	public TestInfo version(String value) {
		VERSION = value;
		return this;
	}
	
	public TestInfo suiteId(String value) {
		SUITEID = value;
		return this;
	}
	
	public TestInfo tcId(String value) {
		TCID = value;
		return this;
	}

	public TestInfo name(String value) {
		NAME = value;
		return this;
	}
	public TestInfo excepted(String value) {
		EXCEPTED = value;
		return this;
	}
	
	public TestInfo actual(String value) {
		ACTUAL = value;
		return this;
	}
	
	public TestInfo remarks(String value) {
		REMARKS = value;
		return this;
	}
	
	public static String timestamp() {
		return TIMESTAMP;
	}
	
	public static String version() {
		return VERSION;
	}
	
	public static String suiteId() {
		return SUITEID;
	}
	
	public static String tcId() {
		return TCID;
	}

	public static String name() {
		return NAME;
	}
	public static String excepted() {
		return EXCEPTED;
	}
	
	public static String actual() {
		return ACTUAL;
	}
	
	public static String remarks() {
		return REMARKS;
	}
}
