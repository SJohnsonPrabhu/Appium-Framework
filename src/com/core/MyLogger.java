package com.core;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {

	public static Logger log = Logger.getLogger(MyLogger.class);

	public static void init() {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/Log4j.properties");
        
    }
	
	static{
        init();
    }
}
