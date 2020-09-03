package com.seanpetersgichia.contactlistapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seanpetersgichia.contactlistapp.R;
import com.seanpetersgichia.contactlistapp.model.ContactListTable;

import java.util.ArrayList;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder> {
    private List<ContactListTable> contactList = new ArrayList<>();
    @NonNull
    @Override
    public ContactListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListAdapter.MyViewHolder holder, int position) {
      holder.contactName.setText(contactList.get(position).getName());
      holder.contactProfession.setText(contactList.get(position).getProfession());
      holder.contactPhoneNumber.setText(contactList.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void setContactList(List<ContactListTable> contacts){
        this.contactList = contacts;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView contactName;
        private TextView contactProfession;
        private TextView contactPhoneNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName);
            contactPhoneNumber = itemView.findViewById(R.id.contactPhoneNumber);
            contactProfession = itemView.findViewById(R.id.contactProfession);
        }
    }
}
