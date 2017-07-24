package com.example.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String MAE_FULLNAME = "com.example.cameraexample.MAE_FULLNAME";
    public Bitmap MAE_IMAGE_TAKEN;
    public  static final int CAMERA_PIC_REQUEST = 2;
    EditText name;
    EditText lastname;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.et_name);
        lastname = (EditText)findViewById(R.id.et_lastname);
        picture = (ImageView) findViewById(R.id.iv_image1);
    }

    public void openCamera(View view) {

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            MAE_IMAGE_TAKEN = (Bitmap) data.getExtras().get("data");
            // do whatever you want with the image now
            picture.setImageBitmap(MAE_IMAGE_TAKEN);

            //Intent intentImage = new Intent(MainActivity.this, DetailsActivity.class);
            //intentImage.putExtra("BitmapImage", MAE_IMAGE_TAKEN);
            //startActivity(intentImage);
        }
    }

    public void openDetails(View view) {

        String fullName = name.getText().toString() +  " " + lastname.getText().toString();
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("BitmapImage", MAE_IMAGE_TAKEN);
        intent.putExtra(MAE_FULLNAME, fullName);
        startActivity(intent);
    }
}
