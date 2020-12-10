package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList = new ContactList();

    public static void main(String[] args) {

        Contact sosContact = new Contact("Mom", "12345678");
        contactList.newContact(sosContact);

        Contact dad = new Contact ("Dad", "11111111");
        Contact sister = new Contact("Sister", "22222222");
        Contact brother = new Contact("Brother", "33333333");
        contactList.newContact(dad);
        contactList.newContact(sister);
        contactList.newContact(brother);

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {

            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    createNewContact();
                    break;
                case 2:
                    findContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    deleteAll();
                    break;
                case 5:
                    printContactList();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }


    private static void printContactList() {
        System.out.println("Your contact list:");
        contactList.printContactList();
    }

    private static void deleteAll() {
        System.out.println("Are you sure? (Y / N) ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            contactList.deleteAll();
            System.out.println("Deleted all contacts except SOS contact");
        } else {
            System.out.println("Very good :)");
        }

    }

    private static void removeContact() {
        System.out.println("Enter the name or the phone number of contact to remove: ");
        String inputText = scanner.nextLine();
        Contact sos = contactList.getContactList().get(0);
        if (inputText.equalsIgnoreCase(sos.getName()) || inputText.equalsIgnoreCase(sos.getPhoneNumber())) {
            System.out.println("You cannot remove your SOS contact");
        } else {
            boolean didRemove = contactList.removeContact(inputText);
            if (didRemove) {
                System.out.println(inputText + " has been removed from your contacts");
            } else {
                System.out.println(inputText + " is not found in your contacts");
            }
        }
    }

    private static void findContact() {
        System.out.println("Enter the name or phone number of contact to find: ");
        String text = scanner.nextLine();

        Contact info = contactList.findContactInfo(text);

        if (info != null) {
            System.out.println(info);
        } else {
            System.out.println(text + " has not been found in your phone book");
        }
    }


    private static void createNewContact() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number:");
        String number = scanner.nextLine();
        contactList.newContact(name, number);

    }

    private static void printInstructions() {
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To create new contact");
        System.out.println("\t 2 - To find contact ");
        System.out.println("\t 3 - To remove contact ");
        System.out.println("\t 4 - To delete all contacts except the SOS contact");
        System.out.println("\t 5 - To print contact list");
        System.out.println("\t 6 - To quit");
    }
}

/*Create a class Contacts which supports arrayList of objects Contact (Contact has
to be at least 2 fields: name and number)
And implement functionality then in the Main class is possible to:
create new contact
Find contact
Remove contact
Delete all contacts except very first one
Which should be defined from beginning and be “SOS contact”
*/
