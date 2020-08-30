package com.seanpetersgichia.contactlistapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.seanpetersgichia.contactlistapp.dao.ContactListDao;
import com.seanpetersgichia.contactlistapp.db.ContactRoomDb;
import com.seanpetersgichia.contactlistapp.model.ContactListTable;

import java.util.List;

public class ContactListRepository {
    private ContactListDao contactListDao;
    private LiveData<List<ContactListTable>> allContacts;

    public ContactListRepository(Application application) {
        ContactRoomDb contactRoomDb = ContactRoomDb.getInstance(application);
        contactListDao = contactRoomDb.contactListDao();
        allContacts = contactListDao.getAllContacts();
    }

    public ContactListRepository(ContactListDao contactListDao) {
        this.contactListDao = contactListDao;
    }

    public void insert(ContactListTable contactListTable) {
        new InsertContactAsyncTask(contactListDao).execute(contactListTable);
    }

    public void update(ContactListTable contactListTable) {
        new DeleteContactAsyncTask(contactListDao).execute(contactListTable);
    }

    public void delete(ContactListTable contactListTable) {
        new DeleteContactAsyncTask(contactListDao).execute(contactListTable);
    }

    public void deleteAllContacts(ContactListTable contactListTable) {
        new DeleteAllContactsAsyncTask(contactListDao).execute();
    }

    public LiveData<List<ContactListTable>> getAllContacts(){
        return allContacts;
    }


    private static class InsertContactAsyncTask extends AsyncTask<ContactListTable, Void, Void> {
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

    private static class UpdateContactAsyncTask extends AsyncTask<ContactListTable, Void, Void> {
        private ContactListDao contactListDao;

        public UpdateContactAsyncTask(ContactListDao contactListDao) {
            this.contactListDao = contactListDao;
        }

        @Override
        protected Void doInBackground(ContactListTable... contactListTables) {
            contactListDao.updateContact(contactListTables[0]);
            return null;
        }
    }

    private static class DeleteContactAsyncTask extends AsyncTask<ContactListTable, Void, Void> {

        private ContactListDao contactListDao;

        public DeleteContactAsyncTask(ContactListDao contactListDao) {
            this.contactListDao = contactListDao;
        }

        @Override
        protected Void doInBackground(ContactListTable... contactListTables) {
            contactListDao.deleteContact(contactListTables[0]);
            return null;
        }
    }

    private static class DeleteAllContactsAsyncTask extends AsyncTask<Void, Void, Void> {
        private ContactListDao contactListDao;

        public DeleteAllContactsAsyncTask(ContactListDao contactListDao) {
            this.contactListDao = contactListDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            contactListDao.deleteAllContacts();
            return null;
        }
    }
}
