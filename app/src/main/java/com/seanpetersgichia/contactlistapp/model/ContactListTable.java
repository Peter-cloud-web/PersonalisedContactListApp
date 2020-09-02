package com.seanpetersgichia.contactlistapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contactList_table")
public class ContactListTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String phoneNumber;
    private String businessNumber;
    private String email;
    private String homeAddress;
    private String work;
    private String profession;

    public ContactListTable(String name, String phoneNumber, String businessNumber, String email, String homeAddress, String work, String profession) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.businessNumber = businessNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.work = work;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public String getWork() {
        return work;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

}
