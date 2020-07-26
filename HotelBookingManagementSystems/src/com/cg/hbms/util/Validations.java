package com.cg.hbms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	// city validation
	public static boolean checkCity(String cityName) {
		String regex;
		boolean matches;
		regex = "[A-Z][a-z]*";
		matches = Pattern.matches(regex, cityName);
		return matches;
	}

	// hotel name validation
	public static boolean checkHotelName(String hotelName) {
		String regex;
		boolean matches;
		regex = "[A-Z][a-z]*";
		matches = Pattern.matches(regex, hotelName);
		return matches;
	}

	// password validation
	private static Pattern pattern;
	private static Matcher matcher;

	public static boolean validatePassword(String password) {
		String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!&]).{8,40})";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	// validate mobile number

	public static boolean checkPhoneNumber(String phoneNumber) {
		Pattern p = Pattern.compile("[5-9][0-9]{9}");
		Matcher m = p.matcher(phoneNumber);
		return (m.find() && m.group().equals(phoneNumber));
	}

	// validate email

	public static boolean validateEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// validate number rating
	public static boolean checkRating(double rating) {
		if (1 <= rating && rating <= 5) {
			return true;
		} else {
			return false;
		}

	}

	// validate number of adults
	public static boolean checkAdults(int num) {
		if (num <= 2) {
			return true;
		} else {
			return false;
		}
	}

	// validate number of children
	public static boolean checkChildren(int num) {
		if (num <= 1) {
			return true;
		} else {
			return false;
		}
	}

	// validate date format mm/dd/yyyy
	public static boolean checkDate(String date) {

		boolean matches;
		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		matches = Pattern.matches(regex, date);
		return matches;
	}

	// validate use use
	public static boolean checkUserRole(String user) {
		if (user.equalsIgnoreCase("Employee") || user.equalsIgnoreCase("Customer")) {
			return true;
		} else {
			return false;
		}
	}

}
