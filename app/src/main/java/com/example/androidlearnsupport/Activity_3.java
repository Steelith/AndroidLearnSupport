package com.example.androidlearnsupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        this.setTitle(R.string.btn_3);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainMenu.MESSAGE_KEY);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(message);
    }
}
