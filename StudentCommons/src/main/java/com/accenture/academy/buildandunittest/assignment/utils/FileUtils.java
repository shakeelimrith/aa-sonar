package com.accenture.academy.buildandunittest.assignment.utils;

public final class FileUtils {
	
	private FileUtils() {
		throw new IllegalStateException("Utility Class");
	}

	public static boolean isCsvFile(String fileName) {
		return fileName != null && fileName.endsWith(".csv");
	}

	public static String[] splitFile(String line, String delimeter) {
		return line.split(delimeter);
	}

}
