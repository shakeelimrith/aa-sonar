package com.accenture.academy.buildandunittest.assignment.utils;

public final class FileUtils {

	public static boolean isCsvFile(String fileName) {
		return fileName != null && fileName.endsWith(".csv");
	}

	public static String[] splitFile(String line, String delimeter) {
		return line.split(delimeter);
	}
	private FileUtils() {}

}
