package com.example.cs441_mobilegamedevhw04;
//Metehan Kundak

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private int screen_w;
    private int screen_h;
    private ViewGroup main;
    private float x;
    private float y;
    private float image_x;
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    ImageView image = findViewById(R.id.image);
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView image = findViewById(R.id.image);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        },0,10);





    }
    public void changePos(){
        x +=10;
        if (image.getX()+ image.getHeight()>10){
           image_x = (float) Math.floor(Math.random() * image.getHeight());
        }
        image.setX(image_x);
    }
}