package com.example.androidlearnsupport;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    public static final String MESSAGE_KEY = "random_shit";
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        this.setTitle(R.string.mainMenu);
        actionBar = getSupportActionBar();
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
    /*public void saveSharedPreferences (View view){
        EditText editText = (EditText) findViewById(R.id.editText8);
        String message = editText.getText().toString();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("haslo", message);
        editor.apply();
    }
    public void readSharedPreferences (View view){
        TextView textView7 = (TextView) findViewById(R.id.textView7);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String defaultValue = sharedPref.getString("haslo", "");

        textView7.setText(defaultValue);
    }*/
    public void createNewToast (View view){
        Intent intent = new Intent(this, CreateNewToast.class);
        startActivity(intent);
    }

    public  void splashScreen (View view){
        Intent intent = new Intent(this, CreateSplashScreen.class);
        startActivity(intent);
    }

    public void createFragments (View view){
        Intent intent = new Intent(this, CreateFragments.class);
        startActivity(intent);
    }
    public void gitbashFilesAdd (View view){
        Intent intent = new Intent(this, GitBashFilesAdd.class);
        startActivity(intent);
    }
    public void sharedPreferences (View view){
        Intent intent = new Intent(this, SharedPreferences.class);
        startActivity(intent);
    }
}
