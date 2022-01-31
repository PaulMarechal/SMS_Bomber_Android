package com.example.sms_bomber;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecupContacts extends AppCompatActivity {

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.contacts_fragment,container,false);

        //this.recupContacts();
        return view;
    }


    public void recupContacts() {
        ContentResolver contentResolver = this.getContentResolver();

        // Récup des contacts dans un curseur
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                        ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);

        if (cursor == null) {
            Log.d("recuperation", "*************** erreur cursor ********************");
        } else {
            EditText txtContacts = (EditText) findViewById(R.id.txtContacts);
            // Parcours des contacts
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                // Affiche la recup
                // ajouter une list adapter
                txtContacts.setText(txtContacts.getText().toString() + "\n\r" + name + " : " + phone);
            }
            // fermer le curseur
            cursor.close();
        }
    }
}
