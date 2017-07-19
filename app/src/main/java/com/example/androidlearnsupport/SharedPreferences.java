package com.example.androidlearnsupport;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferences extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView dataOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        this.setTitle(R.string.shared_preferences);

        usernameInput = (EditText) findViewById(R.id.SPusernameInput);
        passwordInput = (EditText) findViewById(R.id.SPpasswordInput);
        dataOutput = (TextView) findViewById(R.id.SPdisplayText);
        TextView description = (TextView) findViewById(R.id.textView14);

        description.setMovementMethod(new ScrollingMovementMethod());
    }
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
    public void saveSharedPreferences(View view) {
        android.content.SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        android.content.SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(getApplicationContext(),"User data saved!", Toast.LENGTH_SHORT).show();
    }
    public void loadSharedPreferences(View view) {
        android.content.SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "Save username first");
        String pw = sharedPref.getString("password", "Save password first");

        dataOutput.setText("Username: " + name + ", Password: " + pw);
    }
}
