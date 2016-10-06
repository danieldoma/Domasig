package com.mlabs.bbm.firstandroidapp_morningclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Domasig on 05/10/2016.
 */
public class Generate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinates);
        ImageView img;
        img = (ImageView) findViewById(R.id.imageView3);
        img.setOnTouchListener(new View.OnTouchListener() {
            float x = 0;
            float y = 0;
            float x1 = 0;
            float y1 = 0;
            float x2 = 0;
            float y2 = 0;
            String message = " ";
            String message1 = " ";
            String message2 = " ";

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                TextView t1 = (TextView) findViewById(R.id.textView);
                TextView t2 = (TextView) findViewById(R.id.textView2);
                TextView t3 = (TextView) findViewById(R.id.textView3);
                TextView t4 = (TextView) findViewById(R.id.textView4);
                TextView t5 = (TextView) findViewById(R.id.textView5);
                TextView t6 = (TextView) findViewById(R.id.textView6);

                switch (e.getAction()) {git
                    case MotionEvent.ACTION_DOWN:
                        x = e.getX();
                        y = e.getY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        x1 = e.getX();
                        y1 = e.getY();
                        if (x < x1) {
                            message = "Left to Right";
                        } else {
                            message = "Right to Left";
                        }
                        if (y < y1) {
                            message1 = "Top to Bottom";
                        } else {
                            message1 = "Bottom to Top";
                        }
                        if (x1 > 350 && y1 > 350) {
                            message2 = "Quadrant 4";
                        } else if (x1 < 350 && y1 > 350) {
                            message2 = "Quadrant 3";
                        } else if (x1 > 350 && y1 < 350) {
                            message2 = "Quadrant 1";
                        } else if (x1 < 350 && y1 < 350) {
                            message2 = "Quadrant 2";
                        }
                        if (x > x1) {
                            x2 = x - x1;
                        } else if (x < x1) {
                            x2 = x1 - x;
                        }
                        if (y > y1) {
                            y2 = y - y1;
                        } else if (y < y1) {
                            y2 = y1 - y;
                        }
                        if (x2 < 20 && y2 < 20) {
                            message = "No Swipe";
                            message1 = "No Swipe";
                            message2 = "No Quadrant";
                        }
                        t1.setText("x = " + x + " to x =" + x1);
                        t2.setText("y = " + y + " to y =" + y1);
                        t3.setText("Difference of x = " + (x2));
                        t4.setText("Difference of y = " + (y2));
                        t5.setText("Direction = " + message + " and " + message1);
                        t6.setText("Quadrant: " + message2);
                }
                return false;

            }


        });

    }
}

