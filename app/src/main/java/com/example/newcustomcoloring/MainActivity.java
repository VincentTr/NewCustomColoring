/*
 * Main Activity Class
 * @author Vincent Truong
 * @date 2/10/2022
 *
 * The MainActivity class connects all of the
 * components of the DrawingView, DrawingController, and
 * the DrawingModel class to ensure that the
 * functionality of occurring actions are working.
 * */
package com.example.newcustomcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

//extending to the AppCompatActivity to inherit its findViewById
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //provided multiple variables to satisfy the parameters of the DrawingController (viewController) object
            DrawingView surfaceView = findViewById(R.id.surfaceView);
            SeekBar redSeekBar = findViewById(R.id.redSeekBar);
            SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
            SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
            TextView elementName = findViewById(R.id.currentElementText);
            DrawingController viewController = new DrawingController(surfaceView, redSeekBar, greenSeekBar, blueSeekBar, elementName);
            surfaceView.setOnTouchListener(viewController);


            //from line 37-49, connected the display of rgb value with their corresponding SeekBar
            TextView redVal = findViewById(R.id.redValue);
            DrawingController control1 = new DrawingController(redVal);
            redSeekBar.setOnSeekBarChangeListener(control1);


            TextView blueVal = findViewById(R.id.blueValue);
            DrawingController control2 = new DrawingController(blueVal);
            blueSeekBar.setOnSeekBarChangeListener(control2);

            TextView greenVal = findViewById(R.id.greenValue);
            DrawingController control3 = new DrawingController(greenVal);
            greenSeekBar.setOnSeekBarChangeListener(control3);

    }
}