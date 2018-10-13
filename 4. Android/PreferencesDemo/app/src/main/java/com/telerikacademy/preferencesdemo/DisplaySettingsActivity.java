package com.telerikacademy.preferencesdemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplaySettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_settings);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();

        builder.append("\nPerform Sync:\t" + sharedPrefs.getBoolean("perform_sync", false));
        builder.append("\nSync Intervals:\t" + sharedPrefs.getString("sync_interval", "-1"));
        builder.append("\nName:\t" + sharedPrefs.getString("full_name", "Not known to us"));
        builder.append("\nEmail Address:\t" + sharedPrefs.getString("email_address", "No EMail Address Provided"));
        builder.append("\nCustomized Notification Ringtone:\t" + sharedPrefs.getString("notification_ringtone", ""));

        TextView settingsTextView = findViewById(R.id.settingsContent);
        settingsTextView.setText(builder.toString());
    }
}
