package com.example.androidlearnsupport;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class sendingUserToAnotherApp extends AppCompatActivity {

    EditText location, phoneNumber, websiteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_user_to_another_app);
        location = (EditText)findViewById(R.id.mapLocation);
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        websiteEditText = (EditText)findViewById(R.id.websiteEditText);
    }

    public void mapIntent(View view){
        String locationString = location.getText().toString();
        if (locationString.equals("")){
            locationString = "Crewe";
        }
        locationString = "geo:0,0?q=" + locationString;

        // Build the intent
        Uri location = Uri.parse(locationString);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(this, "There is no application to handle that intent", Toast.LENGTH_SHORT).show();
        }
    }

    public void makeACall(View view){
        String editTextNumber = phoneNumber.getText().toString();
        String number = "tel:" + editTextNumber;

        Uri parsedNumber = Uri.parse(number);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, parsedNumber);

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(callIntent);
        } else {
            Toast.makeText(this, "There is no application to handle that intent", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToWebsite(View view){
        String webAddress = websiteEditText.getText().toString();
        String address = "http://www." + webAddress;

        Uri websiteParse = Uri.parse(address);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, websiteParse);

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(webIntent);
        } else {
            Toast.makeText(this, "There is no application to handle that intent", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendAnEmail(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kisielarobert@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "This is the text of email");

        try {
            startActivity(Intent.createChooser(emailIntent, "Pick an email client"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "There is no email clients installed", Toast.LENGTH_SHORT).show();
        }
    }
}
