package com.telerikacademy.contactsdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactListActivity extends Activity {
    public static final int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_activity);

        ListView listView = findViewById(R.id.lv_contacts);
        Button button = findViewById(R.id.btn_load);
        enableRuntimePermission();

        button.setOnClickListener((v) -> {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                    ContactListActivity.this,
                    R.layout.contact_items_listview,
                    R.id.textView,
                    getContacts()
            );

            listView.setAdapter(arrayAdapter);
        });

    }

    private ArrayList<String> getContacts() {
        ArrayList<String> contacts = new ArrayList<>();
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(name + " " + ":" + " " + phonenumber);
        }
        cursor.close();

        return contacts;
    }

    private void enableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                ContactListActivity.this,
                Manifest.permission.READ_CONTACTS)) {
            Toast.makeText(ContactListActivity.this, "CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(ContactListActivity.this, new String[]{
                    Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, @NonNull String per[], int[] PResult) {
        switch (RC) {
            case REQUEST_PERMISSION_CODE:
                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(ContactListActivity.this, "Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ContactListActivity.this, "Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}