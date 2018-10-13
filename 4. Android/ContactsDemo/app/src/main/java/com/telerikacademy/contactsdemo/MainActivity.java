package com.telerikacademy.contactsdemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab_pref = findViewById(R.id.fab_pick);
        fab_pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modifySettings = new Intent(MainActivity.this, ContactPickerActivity.class);
                startActivity(modifySettings);
            }
        });

        FloatingActionButton fab_display = findViewById(R.id.fab_list);
        fab_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewSettings = new Intent(MainActivity.this, ContactListActivity.class);
                startActivity(viewSettings);
            }
        });
    }
}
