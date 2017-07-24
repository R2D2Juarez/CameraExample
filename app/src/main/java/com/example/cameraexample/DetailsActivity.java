package com.example.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    TextView name;
    TextView lastname;
    ImageView copyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = (TextView) findViewById(R.id.tv_fullname);
        lastname = (TextView) findViewById(R.id.tv_lastname);
        copyImage = (ImageView) findViewById(R.id.iv_copy_image1);

        Intent intent = getIntent();

        Bitmap imageTaken2 = intent.getParcelableExtra("BitmapImage");
        String fullName = intent.getStringExtra(MainActivity.MAE_FULLNAME);
        //Toast.makeText(this, fullName, Toast.LENGTH_SHORT).show();

        copyImage.setImageBitmap(imageTaken2);
        name.setText(fullName);
    }

}
