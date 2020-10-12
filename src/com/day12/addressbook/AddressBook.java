package com.day12.addressbook;

import java.util.*;

public class AddressBook {

	Scanner sc = new Scanner(System.in);
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private List<Details> addressBook = new ArrayList<Details>();

	public List<Details> getAddressBook() {
		return this.addressBook;
	}

	public void setAddressBook(List<Details> adrs) {
		this.addressBook = adrs;
	}

	public void addDetails(Details detailsObj) {
		addressBook.add(detailsObj); // ADDING DETAILS
	}

	public List<Details> viewAllDetails() {
		return addressBook;
	}

	// DISPLAYING DETAILS
	public Details viewDetailsGivenName(String firstName, String lastName) {
		for (Details c : addressBook)
			if (c.getFirstName() == firstName && c.getLastName() == lastName)
				return c;

		return null;
	}

	// TO EDIT EXISTING DETAILS
	public void edit(Details det) {
		System.out.println("1. Enter the First Name.");
		System.out.println("2. Enter the Last Name.");
		System.out.println("3. Enter the Phone Number.");
		System.out.println("4. Enter the Email ID.");
		System.out.println("5. Enter the Address.");
		System.out.println("6. Enter the City.");
		System.out.println("7. Enter the State.");
		System.out.println("8. Enter the Zip Code.");

		System.out.println("Enter Number of Correspondence Statement.");

		int n = 0;
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Detail");

		switch (choice) {
		case 1:
			updateDetailsFirstName(det, sc.nextLine());
			n = 1;
			break;
		case 2:
			updateDetailsLastName(det, sc.nextLine());
			n = 1;
			break;
		case 3:
			updateDetailsPhoneNumber(det, Long.parseLong(sc.nextLine()));
			n = 1;
			break;
		case 4:
			updateDetailsEmail(det, sc.nextLine());
			n = 1;
			break;
		case 5:
			updateDetailsAddress(det, sc.nextLine());
			n = 1;
			break;
		case 6:
			updateDetailsCity(det, sc.nextLine());
			n = 1;
			break;
		case 7:
			updateDetailsState(det, sc.nextLine());
			n = 1;
			break;
		case 8:
			updateDetailsZip(det, Long.parseLong(sc.nextLine()));
			n = 1;
			break;
		default:
			System.out.println("INVALID INPUT");
			break;
		}
		if (n == 1) {
			System.out.println("Detail Edited");
		} else {
			System.out.println("Name Not Found");
		}

	}

	public void updateDetailsPhoneNumber(Details dObj, long phoneNumber) {
		dObj.setPhoneNumber(phoneNumber);
	}

	public void updateDetailsFirstName(Details dobj, String upFirstName) {
		dobj.setFirstName(upFirstName);
	}

	public void updateDetailsLastName(Details dObj, String lastName) {
		dObj.setLastName(lastName);
	}

	public void updateDetailsEmail(Details dObj, String email) {
		dObj.setEmailId(email);
	}

	public void updateDetailsCity(Details dObj, String city) {
		dObj.setCity(city);
	}

	public void updateDetailsAddress(Details dObj, String address) {
		dObj.setAddress(address);
	}

	public void updateDetailsState(Details dObj, String state) {
		dObj.setState(state);
	}

	public void updateDetailsZip(Details dObj, long zip) {
		dObj.setZipCode(zip);
	}

	// REMOVING ANY DETAIL
	public boolean removeDetails(String first, String last) {
		int n = 0;
		for (Details c : addressBook)
			if (c.getFirstName().equalsIgnoreCase(first) && c.getLastName().equalsIgnoreCase(last)) {
				addressBook.remove(c);
				n = 1;
				return true;

			}
		if (n == 0) {
			System.out.println("Name not Found");
		} else {
			System.out.println("Name Removed");
		}
		return false;

	}

// UserCase 7
	public boolean noDuplicate(String firstName, String lastName) {

		return addressBook.stream().anyMatch(
				contact -> contact.getFirstName().equals(firstName) && contact.getFirstName().equals(lastName));

	}

}

class AddressBookDictionary extends AddressBook {
	Map<String, AddressBook> address_book = new HashMap<>();

	public void addAddressBook(String name, AddressBook addressbook) {
		address_book.put(name, addressbook);
	}

	public boolean presentAddressBook(String name) {
		return address_book.containsKey(name);
	}

	public AddressBook returnAddressBook(String name) {
		return address_book.get(name);
	}
}
