package com.example.androidlearnsupport;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidlearnsupport.fragments.saveFileFragment1;
import com.example.androidlearnsupport.fragments.saveFileFragment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class saveFileToExternal extends AppCompatActivity {

    EditText saveFileEditText;
    TextView saveFileViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_file_to_external);
        setTitle(R.string.save_file_external);

        saveFileEditText = (EditText)findViewById(R.id.saveFileEditText);
        saveFileViewText = (TextView)findViewById(R.id.saveFileViewText);
    }
     public void saveFileSave(View view){
        String MessageText = saveFileEditText.getText().toString();
         try {
             FileOutputStream fileOutputStream = openFileOutput("messagetext.txt", MODE_PRIVATE);
             fileOutputStream.write(MessageText.getBytes());
             fileOutputStream.close();
             Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
             saveFileEditText.setText("");

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     public void saveFileLoad(View view){
         try {
             FileInputStream fileInputStream = openFileInput("messagetext.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             StringBuilder stringBuilder = new StringBuilder();
             String lines;

             while((lines=bufferedReader.readLine())!=null){
                stringBuilder.append(lines+"\n");
             }
             saveFileViewText.setText(stringBuilder.toString());
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public void saveFileFragmentSave(View view) {
         Fragment fragment;
         if (view == findViewById(R.id.saveFileFragmentSave)) {
             fragment = new saveFileFragment1();
             android.app.FragmentManager FM = getFragmentManager();
             FragmentTransaction FT = FM.beginTransaction();
             FT.replace(R.id.fragment_placement1, fragment);
             FT.commit();
         }
         if (view == findViewById(R.id.saveFileFragmentLoad)) {
             fragment = new saveFileFragment2();
             android.app.FragmentManager FM = getFragmentManager();
             FragmentTransaction FT = FM.beginTransaction();
             FT.replace(R.id.fragment_placement1, fragment);
             FT.commit();
         }
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
}
