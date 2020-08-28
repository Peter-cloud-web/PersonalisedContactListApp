package com.seanpetersgichia.contactlistapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.seanpetersgichia.contactlistapp.model.ContactListTable;

import java.util.List;

@Dao
public interface ContactListDao {

    @Insert
    void insertContact(ContactListTable contactListTable);

    @Update
    void updateContact(ContactListTable contactListTable);

    @Delete
    void deleteContact(ContactListTable contactListTable);

    @Query("DELETE FROM contactList_table")
    void deleteAllContacts();

    @Query("SELECT * FROM contactList_table")
    LiveData<List<ContactListTable>> getAllContacts();

}
