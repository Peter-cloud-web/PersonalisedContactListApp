package com.seanpetersgichia.contactlistapp.db;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.seanpetersgichia.contactlistapp.dao.ContactListDao;
import com.seanpetersgichia.contactlistapp.model.ContactListTable;

@Database(entities = {ContactListTable.class}, version = 1)
public abstract class ContactRoomDb extends RoomDatabase {

    public static ContactRoomDb instance;
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public static synchronized ContactRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ContactRoomDb.class, "contactList_table")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    public abstract   ContactListDao contactListDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private ContactListDao contactListDao;

        public PopulateDbAsyncTask(ContactRoomDb roomDb) {
            this.contactListDao = roomDb.contactListDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            contactListDao.insertContact(new ContactListTable("John", "0724500460", "0707890098", "john@gmail.com", "87-Nakuru"));
            contactListDao.insertContact(new ContactListTable("Joan", "0784560460", "0707890098", "joan@gmail.com", "847-Meru"));
            contactListDao.insertContact(new ContactListTable("Siz", "0765890098", "0756789098", "gee@gmail.com", "65889-Nakuru"));
            return null;
        }
    }

}
