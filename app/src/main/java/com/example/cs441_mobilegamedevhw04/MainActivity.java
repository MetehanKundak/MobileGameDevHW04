package com.example.cs441_mobilegamedevhw04;

//Metehan Kundak

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private ImageView image;
    private boolean action_up;
    private boolean action_down;
    private boolean action_right;
    private boolean action_left;

    private boolean action_upright;
    private boolean action_upleft;
    private boolean action_downright;
    private boolean action_downleft;


    private final Timer timer = new Timer();
    private final Handler handler = new Handler();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        @SuppressLint("UseCompatLoadingForDrawables") Drawable imageBox = getResources().getDrawable(R.drawable.baxter);
        findViewById(R.id.up).setOnTouchListener(this);
        findViewById(R.id.down).setOnTouchListener(this);
        findViewById(R.id.left).setOnTouchListener(this);
        findViewById(R.id.right).setOnTouchListener(this);

        findViewById(R.id.up_left).setOnTouchListener(this);
        findViewById(R.id.up_right).setOnTouchListener(this);
        findViewById(R.id.down_left).setOnTouchListener(this);
        findViewById(R.id.down_right).setOnTouchListener(this);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> changePos());
            }
        },0, 20);
    }



    public void changePos(){
        float X = image.getX();
        float Y = image.getY();
        if (action_up) {
            Y -= 10;
        }
        if (action_down) {
            Y += 10;
        }
        if (action_left){
            X -= 10;
        }
        if (action_right){
            X += 10;
        }

        if (action_upright){
            Y -=10;
            X += 10;
        }
        if (action_upleft){
            Y -=10;
            X -= 10;
        }
        if (action_downleft){
            Y +=10;
            X -= 10;
        }
        if (action_downright){
            Y +=10;
            X += 10;
        }











        image.setX(X);
        image.setY(Y);
    }

    @SuppressLint({"ClickableViewAccessibility", "NonConstantResourceId"})
    @Override
    public boolean onTouch(View v, MotionEvent event) {
       if (event.getAction() == MotionEvent.ACTION_DOWN){
           switch (v.getId()){
               case R.id.up:
                   action_up = true;
                   break;
               case R.id.down:
                   action_down = true;
                   break;
               case R.id.left:
                   action_left = true;
                   break;
               case R.id.right:
                   action_right = true;
                   break;
               case R.id.up_left:
                   action_upleft = true;
                   break;
               case R.id.up_right:
                   action_upright = true;
                   break;
               case R.id.down_right:
                   action_downright = true;
                   break;
               case R.id.down_left:
                   action_downleft = true;
                   break;
           }
       }else {
           action_up = false;
           action_down = false;
           action_right = false;
           action_left = false;

           action_downleft = false;
           action_upleft = false;
           action_upright = false;
           action_downright = false;

       }



        return false;
    }
}