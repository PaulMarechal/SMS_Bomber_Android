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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_fragment,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.recupContacts();
    }

    public void recupContacts() {
        ContentResolver contentResolver = getContext().getContentResolver();

        // Récup des contacts dans un curseur
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                        ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);

        if (cursor == null) {
            Log.d("recuperation", "*************** erreur cursor ********************");
        } else {
            EditText txtContacts = (EditText) getView().findViewById(R.id.txtContacts);
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







    //@SuppressLint("SetTextI18n")
    //public void recupContacts() {
    // acces au contenu du mobile
    //ContentResolver contentResolver = this.getContentResolver();

    // Récup des contacts dans un curseur
    //Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
    //        new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
    //                ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);

    //if (cursor == null) {
    //    Log.d("recuperation", "*************** erreur cursor ********************");
    //} else {
    //    EditText txtContacts = (EditText) findViewById(R.id.txtContacts);
    //    // Parcours des contacts
    //    while (cursor.moveToNext()) {
    //        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
    //        @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

    // Affiche la recup
    // ajouter une list adapter
    //       txtContacts.setText(txtContacts.getText().toString() + "\n\r" + name + " : " + phone);
    //  }
    // fermer le curseur
    //    cursor.close();
    // }
    // }


//public ContentResolver getContentResolver() {
//    return mContentResolver;
//}

//public void setContentResolver(ContentResolver contentResolver) {
//    mContentResolver = contentResolver;
//}

