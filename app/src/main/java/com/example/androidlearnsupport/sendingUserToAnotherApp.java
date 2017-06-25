package com.example.androidlearnsupport;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class sendingUserToAnotherApp extends AppCompatActivity {

    EditText location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_user_to_another_app);
        location = (EditText)findViewById(R.id.mapLocation);
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
}
