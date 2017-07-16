package com.example.androidlearnsupport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CapturingPhoto extends AppCompatActivity {

    ImageView capturedPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturing_photo);
        capturedPhoto = (ImageView) findViewById(R.id.capturedPhotoFromCamera);
    }

    public void sendUserToCamera (View view){
        Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(photoIntent, 0);
        Toast.makeText(this, "Starting camera application...", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        capturedPhoto.setImageBitmap(photo);
        capturedPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
