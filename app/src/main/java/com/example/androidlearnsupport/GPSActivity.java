package com.example.androidlearnsupport;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GPSActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        this.setTitle(R.string.GPS_activity);
        TextView gpsDescription = (TextView) findViewById(R.id.GPSDescription);
        gpsDescription.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "There are no settings yet!", Toast.LENGTH_SHORT).show();
            return true;
        } else if(id == R.id.action_favorite){
            Toast.makeText(this, "There are no favorites yet!", Toast.LENGTH_SHORT).show();
            return true;
        } return super.onOptionsItemSelected(item);
    }

    public void locationActivation (View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Access to location services denied.", Toast.LENGTH_SHORT).show();
        } else {
                LocationManager lom = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                lom.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);
        }
    }

    @Override
    public void onLocationChanged (Location location){
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        Toast.makeText(this, "Latitude is: " + latitude + "\nLongitude is: " + longitude, Toast.LENGTH_SHORT).show();
        String locationIntentData = "geo:" + latitude + "," + longitude;

        Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(locationIntentData));
        startActivity(locationIntent);
    }

    @Override
    public void onStatusChanged (String provider, int status, Bundle extras){
    }

    @Override
    public void onProviderEnabled (String provider){
        Toast.makeText(this, "GPS enabled!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled (String provider){
        Toast.makeText(this, "GPS disabled!", Toast.LENGTH_SHORT).show();
    }

}
