package com.sachin.contactUser;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sachin.contact.Contact;
import com.sachin.contact.ContactManipulation;
import com.sachin.contactStorage.ContactStorage;

public class User {

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isValid(String s) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	public static void main(String[] args) {

		boolean res = true;

		Scanner sc = new Scanner(System.in);

		Contact ct1, ct2, ct3, ct4,ct5,ct6,ct7,ct8;

		ContactManipulation cm = new ContactManipulation();
		System.out.println("\nWelcome Admin\n ");
		System.out.println("--------------------------------------------------------");

		do {
			System.out.println(
					"Please Select the following operation to perform \n\n1.Add\n2.Remove\n3.Search\n4.Display\n5.Update\n6.Logout");
			int i = sc.nextInt();
			switch (i) {
			case 1:

				ct1 = new Contact();

				System.out.println("Enter a Mobile Number");
				String ph = sc.next();

				if (isValid(ph)) {

					ct1.setPhNo(ph);
					System.out.println("Enter the Name");
					ct1.setName(sc.next());

					System.out.println("Enter the Email");
					String email = sc.next();

					if (isValidEmailAddress(email)) {
						ct1.setEmail(email);

					}

					else {
						try {
							throw new Exception();
						} catch (Exception e) {
							System.out.println("----------------------------------");
							System.out.println("Invalid Email");
							System.out.println("----------------------------------");
							System.out.println("Please enter the valid email id");
							sc.nextLine();
							break;
						}
					}

				} else {
					try {
						throw new Exception();
					} catch (Exception e) {
						System.out.println("----------------------------------");
						System.out.println("Invalid NUmber");
						System.out.println("----------------------------------");
						System.out.println("Please enter the valid mobile number");
						break;
					}
				}

				cm.addContact(ct1);
				break;

			case 2:
				if (ContactStorage.listofContacts.size() == 0) {
					try {
						throw new Exception();

					} catch (Exception e) {
						System.out.println("----------------------------------");
						System.out.println("List is empty");
						System.out.println("----------------------------------");
						break;

					}
				} else {
					ct2 = new Contact();
					System.out.println("Enter the mobile number you want to delete:");
					String n=sc.next();
					ct3 = cm.searchContact(n);
					cm.removeContact(ct3);
					System.out.println("Contact is removed");

				}
				break;

			case 3:
				if (ContactStorage.listofContacts.size() == 0) {
					try {
						throw new Exception();
					} catch (Exception e) {
						System.out.println("----------------------------------");
						System.out.println("List is empty");
						System.out.println("----------------------------------");
						break;

					}
				} else {

					ct4 = new Contact();
					System.out.println("Enter the mobile number you want to search the details");

					ct5 = cm.searchContact(sc.next());
					if(ct5==null)
					{
						
					}
					else
					{
					System.out.println("*******************");
					System.out.println("\tName" + "\t" + "\tMobile" + "\t" + "\t Email ");
					System.out.println(ct5.getName() + "\t" + ct5.getPhNo() + "\t" + ct5.getEmail());
					System.out.println("*******************");
					}
				}
				break;

			case 4:
				if (ContactStorage.listofContacts.size() == 0) {
					try {
						throw new Exception();
					} catch (Exception e) {
						System.out.println("----------------------------------");
						System.out.println("List is empty");
						System.out.println("----------------------------------");
						break;
					}
				}
				else {
					System.out.println("-----------------------------------------------------");
					System.out.println("Name" + "\t" + "Mobile" + "\t" + "Email ");

					for (Contact ct : ContactStorage.listofContacts) {
						System.out.println(ct.getName() + "\t" + ct.getPhNo() + "\t" + ct.getEmail());
					}
					System.out.println("-----------------------------------------------------");
				}
				break;

			case 5:
				if (ContactStorage.listofContacts.size() == 0) {
					try {
						throw new Exception();
					} catch (Exception e) {
						System.out.println("----------------------------------");
						System.out.println("List is empty");
						System.out.println("----------------------------------");
						break;
					}
				} else {
					ct6 = new Contact();
					System.out.println("Enter the mobile number you want to update the details");
					ct7 = cm.searchContact(sc.next());
					//System.out.println(ct7.getEmail() + "" + ct7.getName() + "" + ct7.getPhNo() + "");

					System.out.println("\nNow Enter the updated values:\n");
					System.out.println("Enter the Name");
					ct7.setName(sc.next());

					System.out.println("Enter the Email");
					ct7.setEmail(sc.next());

					cm.updateContact(ct7);
					System.out.println("Contact is updated");
				}

				break;
			case 6:
				System.out.println("\nYou are logged out !!!\n");
				System.exit(0);

			default:
				System.out.println("Please, Enter the correct choice !!!!");
				break;
			}

		} while (res);

	}
}





























// }
/*
 * else { System.out.println("Wrong Username or password, Try again !!!"); }
 */
/*
 * System.out.println("*******************"); System.out.println("Name" + "\t" +
 * "Mobile" + "\t" + "Email "); System.out.println(ct4.getName() + "\t" +
 * ct4.getPhNo() + "\t" + ct4.getEmail());
 * System.out.println("*******************");
 */
// if ("admin".equals(user) && "password".equals(password)) {
/*
 * System.out.println("\n--------Please Login to continue--------\n");
 * System.out.println("Enter the Username:"); String user = sc.next();
 * System.out.println("Enter the password"); String password = sc.next();
 */