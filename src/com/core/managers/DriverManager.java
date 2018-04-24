package com.core.managers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.api.android.Android;
import com.core.ADB;
import com.core.MyLogger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverManager {

	private static HashMap<String, URL> hosts;
	private static String appPackage = "io.appium.unlock";

	private static DesiredCapabilities getCaps(String deviceID) {
		MyLogger.log.info("Setting the desired capabilities for " + deviceID);

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceID);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6");
		caps.setCapability(MobileCapabilityType.ORIENTATION, "LANDSCAPE");
		caps.setCapability("avd", "AVD_for_Lenovo-YT3-850M");
		File apkPath = new File("/home/johnson/eclipse-workspace/AppiumFramework/APK","/FPIX.apk");
		caps.setCapability(MobileCapabilityType.APP,apkPath.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
		return caps;
	}

	@SuppressWarnings("unused")
	private static URL host(String deviceID) throws MalformedURLException {		
		if (hosts == null) {
			hosts = new HashMap<>();
			hosts.put("Android Emulator", new URL("http://127.0.1.1:4723/wd/hub"));
		}
		return hosts.get(deviceID);
	}

	private static ArrayList<String> getAvailableDevices() {
		MyLogger.log.info("Getting the available devices...");
		ArrayList<String> availableDevices = new ArrayList<>();
		ArrayList<?> connectedDevices = ADB.getConnectedDevices();
		for (Object connectedDevice : connectedDevices) {
			String device = connectedDevice.toString();
			ArrayList<?> apps = new ADB(device).getInstalledPackages();
			if (apps.contains(appPackage))
				availableDevices.add(device);
			else
				MyLogger.log.info(
						"Device: " + device + " has " + appPackage + " installed, assuming it is under testing");
		}
		if (availableDevices.size() == 0)
			throw new RuntimeException("Not a single device is available for testing at this time");
		return availableDevices;
	}

	public static void createDriver() {
		ArrayList<String> devices = getAvailableDevices();
		for (String device : devices) {
			try {
				MyLogger.log.info("Creating driver for device: " + device);
				Android.driver = new AndroidDriver<WebElement>(new URL("http://127.0.1.1:4723/wd/hub"), getCaps(device));
				Android.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Android.adb = new ADB(device);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void killDriver() {
		if (Android.driver != null) {
			MyLogger.log.info("Killing Android Driver");
			Android.driver.quit();
			// Android.adb.uninstallApp(unlockPackage);
		} else
			MyLogger.log.info("No driver to kill at this time");
	}

}
