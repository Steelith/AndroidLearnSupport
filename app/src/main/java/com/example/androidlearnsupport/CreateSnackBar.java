package com.example.androidlearnsupport;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateSnackBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_snack_bar);
    }

    public void snackbarPopUp (View view){
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.snackbarLayout), "An ordinary snackbar appears!", Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }
}
