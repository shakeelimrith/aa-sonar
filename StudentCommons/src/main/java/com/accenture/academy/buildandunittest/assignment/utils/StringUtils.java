package com.accenture.academy.buildandunittest.assignment.utils;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUtils {

	public static final String EMPTY = "";

	private static final String MINUS = "-";

	public static boolean isEmpty(String value) {
		return value.isEmpty();
	}

	public static boolean isEqualsObscure(String value1, String value2) {
		try {
			if (value1 == null) {
				value1 = "";
			}

			if (value2 == null) {
				value2 = "";
			}

			if (value1.equals(value2)) {
				return true;
			}

		} catch (NullPointerException e) {
			System.out.println(e);
		}

		return false;
	}

	public static String getStringOfRegulareExpressionPattern(String string, String pattern)
			throws PatternSyntaxException, NullPointerException {
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
			value1 = value1 + value;
		}
		return value1.toString();
	}

	public static String convertValueToNullifnull(String firstValue) {
		boolean result = false;
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

	private static String createFiller(int numberOfFiller, char typeOfFiller) {
		final StringBuilder fillerString = new StringBuilder();
		for (int i = 0; i < numberOfFiller; i++) {
			fillerString.append(typeOfFiller);
		}
		return fillerString.toString();
	}

	public static String removeTrailingSpacesOrConvertToNull(String input, boolean convertToNull, boolean isPositive) {
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
