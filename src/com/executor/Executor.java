package com.executor;

import org.testng.annotations.Test;

import com.core.managers.DriverManager;
import com.tests.TestPrimer;

public class Executor {

	@Test
	public void Checker() {
		DriverManager.createDriver();
		TestPrimer.runner();
	}
}
