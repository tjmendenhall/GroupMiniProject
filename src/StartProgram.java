import java.util.List;
import java.util.Scanner;

import controller.AddressHelper;
import model.Address;

/**
 * @author dynob - tjmendenhall2@dmacc.edu CIS175 - Fall 2021 Feb 24, 2022
 */
public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static AddressHelper ah = new AddressHelper();

	private static void addAddress() {
		// TODO Auto-generated method stub
		System.out.print("Enter the address owner's name: ");
		String owner = in.nextLine();
		System.out.print("Enter the building/house number: ");
		String bn = in.nextLine();
		System.out.print("Would you like to enter an apartment number([y]es or [n]o): ");
		String input = in.nextLine();
		if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("ye") || input.equalsIgnoreCase("yes")) {
			System.out.print("Enter the apartment number: ");
			String an = in.nextLine();
			System.out.print("Enter the street name: ");
			String sn = in.nextLine();
			System.out.print("Enter the city: ");
			String city = in.nextLine();
			System.out.print("Enter the state: ");
			String state = in.nextLine();
			System.out.print("Enter the zip code: ");
			String zip = in.nextLine();
			Address toAdd = new Address(owner, bn, an, sn, city, state, zip);
			ah.insertAddress(toAdd);
		} else {
			System.out.print("Enter the street name: ");
			String sn = in.nextLine();
			System.out.print("Enter the city: ");
			String city = in.nextLine();
			System.out.print("Enter the state: ");
			String state = in.nextLine();
			System.out.print("Enter the zip code: ");
			String zip = in.nextLine();
			Address toAdd = new Address(owner, bn, sn, city, state, zip);
			ah.insertAddress(toAdd);
		}
	}

	private static void deleteAddress() {
		// TODO Auto-generated method stub
		System.out.println("Enter the address owner's name to delete: ");
		String owner = in.nextLine();
		System.out.print("Enter the building/house number to delete: ");
		String bn = in.nextLine();
		System.out.print("Is there an apartment number([y]es or [n]o): ");
		String input = in.nextLine();
		if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("ye") || input.equalsIgnoreCase("yes")) {
			System.out.print("Enter the apartment number to delete: ");
			String an = in.nextLine();
			System.out.print("Enter the street name to delete: ");
			String sn = in.nextLine();
			System.out.print("Enter the city delete: ");
			String city = in.nextLine();
			System.out.print("Enter the state to delete: ");
			String state = in.nextLine();
			System.out.print("Enter the zip code tp delete: ");
			String zip = in.nextLine();
			Address toDelete = new Address(owner, bn, an, sn, city, state, zip);
			ah.deleteAddress(toDelete);
		} else {
			System.out.print("Enter the street name to delete: ");
			String sn = in.nextLine();
			System.out.print("Enter the city to delete: ");
			String city = in.nextLine();
			System.out.print("Enter the state to delete: ");
			String state = in.nextLine();
			System.out.print("Enter the zip code to delete: ");
			String zip = in.nextLine();
			Address toAdd = new Address(owner, bn, sn, city, state, zip);
			ah.insertAddress(toAdd);
		}

	}

	private static void editAddress() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Owner");
		System.out.println("2 : Search by City");

		int searchBy = in.nextInt();
		in.nextLine();
		List<Address> foundAddresses;
		if (searchBy == 1) {
			System.out.print("Enter the address owner's name to edit: ");
			String owner = in.nextLine();
			foundAddresses = ah.searchForAddressByOwner(owner);
		} else {
			System.out.print("Enter the city to edit: ");
			String city = in.nextLine();
			foundAddresses = ah.searchForAddressByCity(city);

		}

		if (!foundAddresses.isEmpty()) {
			System.out.println("Found Results.");
			for (Address l : foundAddresses) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Address toEdit = ah.searchForAddressById(idToEdit);
			System.out.println("Retrieved " + toEdit.getOwner() + " in " + toEdit.getCity() + ", " + toEdit.getState());
			System.out.println("1 : Update Owner");
			System.out.println("2 : Update Building/House Number");
			System.out.println("3 : Update Apartment Number");
			System.out.println("4 : Update Street Name");
			System.out.println("5 : Update City");
			System.out.println("6 : Update State");
			System.out.println("7 : Update Zip");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Owner: ");
				String newOwner = in.nextLine();
				toEdit.setOwner(newOwner);
			} else if (update == 2) {
				System.out.print("New Building/House Number: ");
				String newBn = in.nextLine();
				toEdit.setBuildingNum(newBn);
			} else if (update == 3) {
				System.out.print("New Apartment Number: ");
				String newAn = in.nextLine();
				toEdit.setAptNum(newAn);
			} else if (update == 4) {
				System.out.print("New Street Name: ");
				String newSn = in.nextLine();
				toEdit.setStreetName(newSn);
			} else if (update == 5) {
				System.out.print("New City: ");
				String newCity = in.nextLine();
				toEdit.setAptNum(newCity);
			} else if (update == 6) {
				System.out.print("New State: ");
				String newState = in.nextLine();
				toEdit.setAptNum(newState);
			} else if (update == 7) {
				System.out.print("New Zip: ");
				String newZip = in.nextLine();
				toEdit.setAptNum(newZip);
			}

			ah.updateAddress(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our Address Book! ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add an address");
			System.out.println("*  2 -- Edit an address");
			System.out.println("*  3 -- Delete an address");
			System.out.println("*  4 -- View the book");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAddress();
			} else if (selection == 2) {
				editAddress();
			} else if (selection == 3) {
				deleteAddress();
			} else if (selection == 4) {
				viewTheBook();
			} else {
				ah.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheBook() {
		// TODO Auto-generated method stub
		List<Address> allAddresses = ah.showAllAddresses();
		for (Address singleA : allAddresses) {
			System.out.println(singleA.returnAddressDetails() + "\n***************************************");
		}

	}

}
