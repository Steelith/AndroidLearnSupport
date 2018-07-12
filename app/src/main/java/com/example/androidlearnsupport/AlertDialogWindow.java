package com.example.androidlearnsupport;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AlertDialogWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_window);
        this.setTitle(R.string.alert_dialog_pop_up);
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
        public void alertDialogTest(View view) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Test 01");
            alert.setCancelable(true);
            alert.setMessage("Nice click mate!\nYou can click somewhere else to close a window");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
    }

}
