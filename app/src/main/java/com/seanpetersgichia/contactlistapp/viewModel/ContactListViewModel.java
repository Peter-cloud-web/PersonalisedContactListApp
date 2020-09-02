package com.seanpetersgichia.contactlistapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.seanpetersgichia.contactlistapp.model.ContactListTable;
import com.seanpetersgichia.contactlistapp.repository.ContactListRepository;

import java.util.List;

public class ContactListViewModel extends AndroidViewModel {

    private ContactListRepository contactListRepository;
    private LiveData<List<ContactListTable>> allContacts;

    public ContactListViewModel(@NonNull Application application) {
        super(application);
        contactListRepository = new ContactListRepository(application);
        allContacts = contactListRepository.getAllContacts();
    }

    public void insert(ContactListTable contactListTable){
        contactListRepository.insert(contactListTable);
    }

    public void update(ContactListTable contactListTable){
        contactListRepository.update(contactListTable);
    }

    public void delete(ContactListTable contactListTable){
        contactListRepository.delete(contactListTable);
    }
    public void deleteAllContacts(ContactListTable contactListTable){
        contactListRepository.deleteAllContacts(contactListTable);
    }
    public LiveData<List<ContactListTable>> getAllContacts(){
        return allContacts;
    }
}
