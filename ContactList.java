package com.company;

import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public ContactList() {
        this.contactList = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void newContact(Contact contact) {
        contactList.add(contact);
    }

    public void newContact (String name, String number) {
        contactList.add(new Contact(name, number));
    }

    public boolean searchContact(String text) {
        boolean found = false;
        for (Contact contact: contactList) {
            if (contact.getName().equalsIgnoreCase(text) ||
            contact.getPhoneNumber().equalsIgnoreCase(text)) {
                found = true;
            }
        }
        return found;
    }

    public Contact findContactInfo(String text) {
        for (Contact contact: contactList) {
            if (contact.getName().equalsIgnoreCase(text) ||
                    contact.getPhoneNumber().equalsIgnoreCase(text)) {
                return contact;
            }
        }
        return null;
    }

    public void printContactList() {
        for (Contact contact: contactList) {
            System.out.println(contact);
        }
    }


    public void deleteAll() {
        while (!(contactList.size() == 1)) {
            contactList.remove(1);
        }
    }

    public int findContactIndex(String text) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getName().equalsIgnoreCase(text) ||
                    contact.getPhoneNumber().equalsIgnoreCase(text)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeContact(String text) {
        int indexOfContact = findContactIndex(text);
        if (indexOfContact > 0) {
            contactList.remove(indexOfContact);
            return true;
        } else {
            return false;
        }
    }
}


/*Create a class Contacts which supports arrayList of objects Contact (Contact has to be at least 2 fields:
name and number)
And implement functionality then in the Main class is possible to:
create new contact
Find contact
Remove contact
Delete all contacts except very first one
Which should be defined from beginning and be “SOS contact”
*/
