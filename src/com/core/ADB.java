package com.core;

import java.util.ArrayList;
import java.util.Arrays;

import com.core.managers.ServerManager;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ADB {

	private static String ID;

	public ADB(String deviceID) {
		ID = deviceID;
	}

	public static String command(String command)  {
		MyLogger.log.debug("ADB Command before formatted: "+command);
		if (command.startsWith("adb"))
			command = command.replace("adb", ServerManager.androidHome() + "/platform-tools/adb");
		else
			throw new RuntimeException("This method is designed for adb commands only...");
		MyLogger.log.debug("ADB Command after formatted: "+command);
		String output = ServerManager.runCommand(command);
		if (output == null)
			return "";
		else
			return output;
	}

	public static ArrayList getConnectedDevices() {
		ArrayList devices = new ArrayList();
		String output = command("adb devices");
		for (String line : output.split("\n")) {
			line = line.trim();
			if (line.endsWith("device"))
				devices.add(line.replace("device", "").trim());
		}
		return devices;
	}

	public static String getForegroundActivity() {
		return command("adb -s " + ID + " shell dumpsys window windows | grep mCurrentFocus");
	}

	public String getAndroidVersionAsString() {
		String output = command("adb -s " + ID + " shell getprop ro.build.version.release");
		if (output.length() == 3)
			output += ".0";
		return output;
	}

	public int getAndroidVersion() {
		return Integer.parseInt(getAndroidVersionAsString().replaceAll("\\.", ""));
	}

	public ArrayList getInstalledPackages() {
		ArrayList packages = new ArrayList();
		String[] output = command("adb -s " + ID + " shell pm list packages").split("\n");
		for (String packageID : output)
			packages.add(packageID.replace("package:", "").trim());
		return packages;
	}

	public void openAppsActivity(String packageID, String activityID) {
		command("adb -s " + ID
				+ " shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.category.MAIN -n "
				+ packageID + "/" + activityID);
	}

	public void clearAppsData(String packageID) {
		command("adb -s " + ID + " shell pm clear " + packageID);
	}

	public void forceStop(String packageID) {
		command("adb -s " + ID + " shell am force-stop " + packageID);
	}

	public void installApp(String apkPath) {
		command("adb -s " + ID + " install" + apkPath);
	}

	public void uninstallApp(String packageID) {
		command("adb -s " + ID + " uninstall" + packageID);
	}

	public void clearLogBuffer() {
		command("adb -s " + ID + " shell logcat -c");
	}

	public void pushFile(String source, String target) {
		command("adb -s " + ID + " push " + source + " " + target);
	}

	public void pullFile(String source, String target) {
		command("adb -s " + ID + " pull " + source + " " + target);
	}

	public void deleteFile(String target) {
		command("adb -s " + ID + " shell rm " + target);
	}

	public void moveFile(String source, String target) {
		command("adb -s " + ID + " shell mv " + source + " " + target);
	}

	public void screenshot(String target) {
		command("adb -s" + ID + " shell screencap " + target);
	}

	public void reboot() {
		command("adb -s " + ID + " reboot");
	}

	public String getDeviceModel() {
		return command("adb -s " + ID + " shell getprop ro.product.model");
	}

	public String inputText(String value) {
		return command("adb -s " + ID + " shell input text " + value);
	}

	public ArrayList getLogcatProcesses() {
		ArrayList processes = new ArrayList();
		String[] output = command("adb -s " + ID + " shell top -n 1 | grep -i 'logcat'").split("\n");
		for (String line : output) {
			processes.add(line.split(" ")[0]);
			processes.removeAll(Arrays.asList("", null));
		}
		return processes;
	}

	public Object startLogcat(String logID, String grep) {
		ArrayList pidBefore = new ArrayList();

		Thread logcat = new Thread(new Runnable() {
			@Override
			public void run() {
				if (grep == null)
					command("adb -s " + ID + " shell logcat -v threadtime > /home/johnson/Downloads/" + logID + ".txt");
				else
					command("adb -s " + ID + " shell logcat -v threadtime | grep -i '" + grep
							+ "' /home/johnson/Downloads/" + logID + ".txt");
			}
		});
		logcat.setName(logID);
		logcat.start();
		logcat.interrupt();

		ArrayList pidAfter = getLogcatProcesses();
		Timer timer = new Timer();
		timer.start();
		while (!timer.expired(5)) {
			if (pidBefore.size() > 0)
				pidAfter.removeAll(pidBefore);
			if (pidAfter.size() > 0)
				break;
			pidAfter = getLogcatProcesses();
		}
		if (pidBefore.size() == 1)
			return pidBefore.get(0);
		else if (pidAfter.size() > 1)
			throw new RuntimeException("Multiple logcat processes were started when only one required");
		else
			throw new RuntimeException("Failed to start logcat processes");
	}

	public void stopLogcat(Object PID) {
		command("adb -s " + ID + " shell kill" + PID);
	}
}