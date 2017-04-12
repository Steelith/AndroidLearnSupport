package com.example.androidlearnsupport;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    public static final String MESSAGE_KEY = "random_shit";
    ActionBar actionBar;
    Button B6, B7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        this.setTitle(R.string.mainMenu);
        actionBar = getSupportActionBar();
        B6 = (Button)findViewById(R.id.button6);
        B7 = (Button)findViewById(R.id.button7);

        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentOne F1 = new FragmentOne();
                FragmentTwo F2 = new FragmentTwo();

                FT.remove(F2);
                FT.add(R.id.fr1_id, F1);
                FT.addToBackStack("f1");
                FT.commit();
            }
        });

        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                FragmentOne F1 = new FragmentOne();
                FragmentTwo F2 = new FragmentTwo();

                FT.remove(F1);
                FT.add(R.id.fr2_id, F2);
                FT.addToBackStack("f2");
                FT.commit();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
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
    public void overflowMenuShow (View view){
        Intent intent = new Intent(this, Activity_5.class);
        startActivity(intent);
    }
}
