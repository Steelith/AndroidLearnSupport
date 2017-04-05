package com.example.androidlearnsupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.text.Html;

public class Activity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        this.setTitle(R.string.btn_3);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainMenu.MESSAGE_KEY);

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(message);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
