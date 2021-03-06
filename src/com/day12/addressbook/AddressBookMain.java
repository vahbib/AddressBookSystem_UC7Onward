// Branch UserCase7
package com.day12.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	public static AddressBook getAddressBook(String name) {
		AddressBook ab = new AddressBook();
		ab.setName(name);
		return ab;
	}

	public static void main(String[] args) {
		String addBookName;
		System.out.println("Welcome to Address Book Program in AddressBookMain class on START Master Branch");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AddressBook obj = new AddressBook();
		AddressBook ab;
		AddressBookDictionary abdict = new AddressBookDictionary();
		boolean while1 = true, while2 = true;

		while (while1) {
//			System.out.println(
//					"1. Add New Address Book.\n2. Modify Existing Address Book.\n3. View All Contact in City.\n4. View All Contact in State.\n5. Exit.");
			System.out.println("1. Add New Address Book.\n2. Modify Existing Address Book.\n5. Exit.");
			System.out.println("Enter your choice: ");
			int ch = Integer.parseInt(sc.nextLine());
			if (ch == 1) {
				System.out.println("Enter the name of Address Book");
				addBookName = sc.nextLine();
				abdict.addAddressBook(addBookName, getAddressBook(addBookName));
			} else if (ch == 2) {
				System.out.println("Enter the name of Address Book");
				String name = sc.nextLine();
				if (abdict.presentAddressBook(name) == true) {
					ab = abdict.returnAddressBook(name);

					while (while2) {

						System.out.println(
								"1. Add Address.\n2. Display The Details.\n3. Edit a Detail.\n4. Remove a Detail.\n5. Go to Main Menu");
						System.out.println("Enter your choice: ");
						int n = Integer.parseInt(sc.nextLine());

						if (n == 1) {

							System.out.println("Enter the First Name:");
							String first = sc.nextLine();

							System.out.println("Enter the Last Name:");
							String last = sc.nextLine();

							if (ab.noDuplicate(first, last))
								System.out.println("Name Already Exists.");
							else {

								System.out.println("Enter the Phone No.:");
								long num = Long.parseLong(sc.nextLine());

								System.out.println("Enter the Email:");
								String email = sc.nextLine();

								System.out.println("Enter the Address:");
								String add = sc.nextLine();

								System.out.println("Enter the City:");
								String city = sc.nextLine();

								System.out.println("Enter the State:");
								String state = sc.nextLine();

								System.out.println("Enter the Zip Code:");
								long zp = Long.parseLong(sc.nextLine());

								Details adrs = new Details(first, last, num, email, add, city, state, zp);
								obj.addDetails(adrs);
							}
						} else if (n == 2) {
							System.out.println("The Details in the List are:");
							ArrayList<Details> list = (ArrayList<Details>) obj.viewAllDetails();
							for (Details c : list)
								System.out.println("\nFirst Name: " + c.getFirstName() + "\nLast Name: "
										+ c.getLastName() + "\nPhone no.: " + c.getPhoneNumber() + "\nEmail: "
										+ c.getEmailId() + "\nAddress: " + c.getAddress() + "\nCity: " + c.getCity()
										+ "\nState: " + c.getState() + "\nState: " + c.getState() + "\nZip Code: "
										+ c.getZipCode());
						} else if (n == 3) {
							System.out.println("Enter the Name to Edit the Details");
							System.out.println("Enter First Name: ");
							String fN = sc.nextLine();
							System.out.println("Enter Last Name: ");
							String lN = sc.nextLine();
							ArrayList<Details> list = (ArrayList<Details>) obj.viewAllDetails();
							for (Details c : list)
								if (c.getFirstName().equalsIgnoreCase(fN) && c.getLastName().equalsIgnoreCase(lN)) {
									obj.edit(c);
								}
						} else if (n == 4) {
							System.out.println("Enter the First Name to remove :");
							String first = sc.nextLine();
							System.out.println("Enter the Last Name to remove :");
							String last = sc.nextLine();
							System.out.println("Do you want to remove the Detail (Y/N):");
							String ans = sc.nextLine();
							if (ans.equals("Y")) {
								if (obj.removeDetails(first, last))
									System.out.println("The Address Detail is successfully deleted.");
							}
						} else if (n == 5) {
							while2 = false;

						} else {
							System.out.println("PLease Enter a Valid Number.\nThank You!");

						}
					}
				} else {
					System.out.println("Oops!! NO SUCH ADDRESS BOOK EXISTS.");
				}
//			else if (ch == 3) {
//				System.out.println("Enter the City Name:");
//				String city = sc.nextLine();
//				obj.viewByCity(city);
//
//			} else if (ch == 4) {
//				System.out.println("Enter the State Name:");
//				String state = sc.nextLine();
//				obj.viewByState(state);
//
			} else if (ch == 5) {
				System.exit(0);
			} else {
				System.out.println("Invalid Input");
			}
		}
	}

}
