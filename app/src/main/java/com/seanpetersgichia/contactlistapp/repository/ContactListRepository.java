package com.seanpetersgichia.contactlistapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.seanpetersgichia.contactlistapp.dao.ContactListDao;
import com.seanpetersgichia.contactlistapp.db.ContactRoomDb;
import com.seanpetersgichia.contactlistapp.model.ContactListTable;

import java.util.List;

public class ContactListRepository {
    private ContactListDao  contactListDao;
    private LiveData<List<ContactListTable>> allContacts;

    public ContactListRepository(Application application) {
        ContactRoomDb contactRoomDb  = ContactRoomDb.getInstance(application);
        contactListDao = contactRoomDb.contactListDao();
        allContacts = contactListDao.getAllContacts();
    }

    public ContactListRepository(ContactListDao contactListDao){
        this.contactListDao = contactListDao;
    }

    private static class InsertContactAsyncTask extends AsyncTask<ContactListTable,Void,Void>{
        private ContactListDao contactListDao;

        public InsertContactAsyncTask(ContactListDao contactListDao) {
            this.contactListDao = contactListDao;
        }
        @Override
        protected Void doInBackground(ContactListTable... contactListTables) {
            contactListDao.insertContact(contactListTables[0]);
            return null;
        }
    }
}
