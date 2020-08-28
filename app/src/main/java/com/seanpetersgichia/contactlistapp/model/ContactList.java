package com.seanpetersgichia.contactlistapp.model;

import androidx.room.PrimaryKey;

public class ContactList {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String phoneNumber;
    private String otherPhoneNumber;
    private String email;
    private String homeAddress;

    public ContactList(String name, String phoneNumber, String otherPhoneNumber, String email, String homeAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.otherPhoneNumber = otherPhoneNumber;
        this.email = email;
        this.homeAddress = homeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOtherPhoneNumber() {
        return otherPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

}
