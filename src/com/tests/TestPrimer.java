package com.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestPrimer {

	public static void runner() {
		TestNG runner = new TestNG();
		List<String> suiteFiles = new ArrayList<String>();
		suiteFiles.add("/home/johnson/eclipse-workspace/AppiumFramework/testng.xml");
		runner.setTestSuites(suiteFiles);
		runner.run();
	}
	
}
