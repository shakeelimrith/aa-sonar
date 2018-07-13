package com.accenture.academy.buildandunittest.assignment.utils;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static final String EMPTY = "";

	
	/**
	 * Private Constructor for utility class
	 */
	private StringUtils() {
	}

	public static boolean isEmpty(String value) {
		return (value == null || value.isEmpty() || value.length() == 0);
	}

	public static boolean isEqualsObscure(String value1, String value2) {
		
			if (value1 == null) {
				value1 = "";
			}

			if (value2 == null) {
				value2 = "";
			}

			if (value1.equals(value2)) {
				return true;
			}

		
		return false;
	}

	public static String getStringOfRegulareExpressionPattern(String string, String pattern)
			 {
		if (StringUtils.isEmpty(string) || StringUtils.isEmpty(pattern)) {
			throw new IllegalArgumentException(" The pattern or the string to search is empty");
		}

		final Pattern p = Pattern.compile(pattern);
		final String enter = string;

		final Matcher m = p.matcher(enter);
		final StringBuilder buffer = new StringBuilder();
		while (m.find()) {
			buffer.append(enter.substring(m.start(), m.end()));
		}

		return buffer.toString();
	}

	public static String concatenate(String... value) {
		String value1 = "";
		for (String string : value) {
			value1 = value1 + string;
		}
		return value1;
	}

	public static String convertValueToNullifnull(String firstValue) {
		if (firstValue == null) {
			firstValue = "null";
		}
		return firstValue;
	}

	public static boolean stringContainsInList(List list, String value) {
		boolean result = false;
		for (final Iterator iterator = list.iterator(); iterator.hasNext();) {
			final String valueInList = (String) iterator.next();
			if (valueInList.equals(value.replaceAll("[\\s+_]", ""))) {
				result = true;
				break;
			}
		}
		return result;
	}



	public static String removeTrailingSpacesOrConvertToNull(String input, boolean convertToNull) {
		if (input != null) {
			final String rtrim = input.replaceAll("\\s+$", "");

			if (convertToNull && "".equals(rtrim)) {
				return null;
			}

			return rtrim;

		}
		return null;
	}

}
