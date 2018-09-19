package com.sachin.contactUser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile1 {

	public static boolean isValidEmailAddress(String email) {
		/*
		 * String ePattern =
		 * "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]  +@((\\  [[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
		 * ;
		 */

		String ePatter = "[0-9][a-z][A-Z]";

		// java.util.regex.Pattern public = java.util.regex.Pattern.compile(ePattern);
		// java.util.regex.Matcher m = p.matcher(email);
		Matcher m;
		// return m.matches();
		return false;
	}

	public static boolean isValid(String s) {
		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	public static void main(String[] args) {
		System.out.println("Enter the a mobile number");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if (isValid(s)) {
			System.out.println("true");
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("----------------------------------");
				System.out.println("Invalid NUmber");
				System.out.println("----------------------------------");
				System.out.println("Please enter the valid mobile number");
				sc.nextLine();

			}
			System.out.println("Enter the email id");
			String email = sc.next();
			if (isValidEmailAddress(email)) {
				System.out.println("Valid email");
			} else {
				try {
					throw new Exception();
				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Invalid NUmber");
					System.out.println("----------------------------------");
					System.out.println("Please enter the valid mobile number");

				}
			}
		}
	}
}
