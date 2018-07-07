package com.accenture.academy.buildandunittest.assignment.utils;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	private StringUtils() {
		super();
	}
	private static final Logger LOGGER = Logger.getLogger( StringUtils.class.getName() );
	public static final String EMPTY = "";

	public static boolean isEmpty(String value) {
		
		try {
			return (value.isEmpty() || value.length() == 0);
		}catch(NullPointerException e) {
			return false;
		}
		
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
			LOGGER.log(Level.SEVERE,e.toString());
		}

		return false;
	}

	public static String getStringOfRegulareExpressionPattern(String string, String pattern) {
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
		StringBuilder bld = new StringBuilder();
		for (int i =0;i<value.length;++i) {
			 bld.append(value[i]);
		}
		String value1=bld.toString();
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