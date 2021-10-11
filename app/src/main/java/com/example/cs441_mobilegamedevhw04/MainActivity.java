package com.example.cs441_mobilegamedevhw04;
//Metehan Kundak

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ViewGroup main;
    private float x_new;
    private float y_new;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.image);
        main = (RelativeLayout) findViewById(R.id.Main);

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
}