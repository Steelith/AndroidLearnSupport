package com.example.androidlearnsupport;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

public class CreateFragments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_fragments);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void changeFragment (View view){
        Fragment fragment;
        if (view == findViewById(R.id.fragment_btn1)){
            fragment = new FragmentOne();
            fragmentMethod(fragment);
            toastAppear("Fragment 1 activated");
        }
        if (view == findViewById(R.id.fragment_btn2)){
            fragment = new FragmentTwo();
            fragmentMethod(fragment);
            toastAppear("Fragment 2 activated");
        }
        if (view == findViewById(R.id.fragment_btn3)){
            fragment = new FragmentThree();
            fragmentMethod(fragment);
            toastAppear("Fragment 3 activated");
        }
        if (view == findViewById(R.id.fragment_btn4)){
            fragment = new FragmentFour();
            fragmentMethod(fragment);
            toastAppear("Fragment 4 activated");
        }
    }
    private void fragmentMethod(Fragment fragment){
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fragment_placement, fragment);
        FT.commit();
    }
    private void toastAppear (String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
