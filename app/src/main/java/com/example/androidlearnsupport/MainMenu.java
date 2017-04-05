package com.example.androidlearnsupport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    public static final String MESSAGE_KEY = "random_shit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        this.setTitle(R.string.mainMenu);
    }

    public void assignMethodToButton (View view) {
        Intent intent = new Intent(this, Activity_1.class);
        startActivity(intent);
    }
    public void openNewActivity (View view) {
        Intent intent = new Intent(this, Activity_2.class);
        startActivity(intent);
    }
    public void rememberValuesFromActivity (View view) {
        Intent intent = new Intent(this, Activity_3.class);
        EditText editText = (EditText) findViewById(R.id.editText4);
        String message = editText.getText().toString();
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
    }
    public void eraseHelpText (View view){
        TextView textView = (TextView) findViewById(R.id.editText4);
        textView.setText("");
        textView.setTextColor(getResources().getColor(R.color.black));

    }
    public void getTextFromNewFileInResource (View view) {
        Intent intent = new Intent(this, Activity_4.class);
        startActivity(intent);
    }
}
