package com.example.cs441_mobilegamedevhw04;
//Metehan Kundak

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private ImageView image;
    private FrameLayout frame;
    private Drawable imageBoxRight;
    private Drawable imageBoxLeft;
    private float boxX;
    private float boxY;
    private boolean action_up;
    private boolean action_down;
    private boolean action_right;
    private boolean action_left;


    private Timer timer = new Timer();
    private Handler handler = new Handler();










    private ViewGroup main;
    private float x_new;
    private float y_new;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        frame = findViewById(R.id.frame);
        imageBoxRight = getResources().getDrawable(R.drawable.baxter);
        findViewById(R.id.up).setOnTouchListener(this);
        findViewById(R.id.down).setOnTouchListener(this);
        findViewById(R.id.left).setOnTouchListener(this);
        findViewById(R.id.right).setOnTouchListener(this);

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
        },0, 20);
    }







/*

        ImageView image = (ImageView) findViewById(R.id.image);
        main = (LinearLayout) findViewById(R.id.Main);

        image.setOnTouchListener(onTouchListener());



    }
    @SuppressLint("ClickableViewAccessibility")
    private OnTouchListener onTouchListener() {


        return (view, event) -> {
            float x = event.getRawX();
            float y = event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    x_new = x - Params.leftMargin;
                    y_new = y - Params.topMargin;
                    break;

                case MotionEvent.ACTION_UP:
                    Toast.makeText(MainActivity.this, "You have clicked the image", Toast.LENGTH_SHORT).show();
                    break;



                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = (int) (x - x_new);
                    layoutParams.rightMargin = 0;
                    layoutParams.topMargin = (int) (y - y_new);
                    layoutParams.bottomMargin = 0;
                    view.setLayoutParams(layoutParams );
                    break;




            }
            main.invalidate();
            return true;
        };
    }
*/

    public void changePos(){
        boxX= image.getX();
        boxY= image.getY();
        if (action_up) boxY -= 30;
        if (action_down) boxY += 30;
        if (action_left){
            boxX -= 30;
        }
        if (action_right){
            boxX += 30;
        }


        image.setX(boxX);
        image.setY(boxY);
    }




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
           }
       }else {
           action_up = false;
           action_down = false;
           action_right = false;
           action_left = false;

       }



        return false;
    }
}