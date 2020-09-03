package com.seanpetersgichia.contactlistapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.seanpetersgichia.contactlistapp.R;
import com.seanpetersgichia.contactlistapp.adapter.ContactListAdapter;
import com.seanpetersgichia.contactlistapp.model.ContactListTable;
import com.seanpetersgichia.contactlistapp.viewModel.ContactListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ContactListViewModel contactListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final ContactListAdapter contactListAdapter = new ContactListAdapter();
        recyclerView.setAdapter(contactListAdapter);

        contactListViewModel = new ViewModelProvider(this).get(ContactListViewModel.class);
        contactListViewModel.getAllContacts().observe(this, new Observer<List<ContactListTable>>() {
            @Override
            public void onChanged(List<ContactListTable> contactListTables) {
                contactListAdapter.setContactList(contactListTables);
            }
        });



    }
}