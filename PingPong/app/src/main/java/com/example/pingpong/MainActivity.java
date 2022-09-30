package com.example.pingpong;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.SurfaceHolder;

public class MainActivity extends AppCompatActivity {
    MySurfaceView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        view.setBackgroundResource(R.drawable.xmas_city);
        view = new MySurfaceView(this);
        MySurfaceView sfvTrack = (MySurfaceView)findViewById(R.id.MySurfaceView);
        sfvTrack.setZOrderOnTop(true);    // necessary
        SurfaceHolder sfhTrackHolder = sfvTrack.getHolder();
        sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT);
        setContentView(view);
        //Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.xmas_city);


    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }
}