package com.example.androidlearnsupport;

import android.content.Intent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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

    public void saveFileOnExternal (View view){
        Intent intentToSaveFiles = new Intent(this, saveFileToExternal.class);
        startActivity(intentToSaveFiles);
    }

    public void scrollingTextView(View view){
        Intent scrollingIntent = new Intent(this, scrollingTextView.class);
        startActivity(scrollingIntent);
    }

    public void sendingUserToAnotherApp(View view){
        Intent sendingIntent = new Intent(this, sendingUserToAnotherApp.class);
        startActivity(sendingIntent);
    }

    public void capturingPhoto (View view){
        Intent capturePhotoIntent = new Intent(this, CapturingPhoto.class);
        startActivity(capturePhotoIntent);
    }

    public void gpsActivity (View view){
        Intent gpsIntent = new Intent (this, GPSActivity.class);
        startActivity(gpsIntent);
    }

    public void createASnackbar (View view){
        Intent snackbarIntent = new Intent (this, CreateSnackBar.class);
        startActivity(snackbarIntent);
    }

    public void FloatingActionButton (View view){
        Intent fabIntent = new Intent (this, CreateFloatingActionButton.class);
        startActivity(fabIntent);
    }

    public void alertDialog (View view) {
        Intent alertDialogIntent = new Intent(this, AlertDialogWindow.class);
        startActivity(alertDialogIntent);
    }
}
