package com.company;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String phoneNumber;
    private ArrayList<Contact> contacts;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "\t " + name +
                ":\t" + phoneNumber ;
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
