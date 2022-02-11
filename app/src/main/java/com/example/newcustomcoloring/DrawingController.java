/*
* Drawing Controller Class
* @author Vincent Truong
* @date 2/10/2022
*
* This DrawingController class implements
* SeekBar and OnTouch Listeners to add functionality
* into the GUI, SeekBar, and DrawingView.
* */
package com.example.newcustomcoloring;


import static com.example.newcustomcoloring.DrawingView.grassFloorLength;
import static com.example.newcustomcoloring.DrawingView.grassFloorWidth;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class DrawingController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener{
    private TextView sbTextView;
    private DrawingView view;
    private DrawingModel model;
    private SeekBar redSB;
    private SeekBar greenSB;
    private SeekBar blueSB;
    private TextView elemName;
    private int redValue;
    private int blueValue;
    private int greenValue;


    public DrawingController(TextView initSBTextView){
        this.sbTextView = initSBTextView;
    }

    /*
    DrawingController constructor
     */
    public DrawingController(DrawingView initView, SeekBar initRedSB, SeekBar initGreenSB, SeekBar initBlueSB, TextView initElemName){
        this.view = initView;
        model = view.getModel();
        this.redSB = initRedSB;
        this.greenSB = initGreenSB;
        this.blueSB = initBlueSB;
        this.elemName = initElemName;
    }

    /*
    This onProgressChanged changes the number next
    to the seekBar
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        this.sbTextView.setText("" + i);

        //if(seekBar == redSB && model.touchGrass == true){
            //i = Color.red(view.getGrassFloorPaint().getColor().setColor(Color.rgb(model.red, model.green, model.blue)));
        //}
        //if(model.touchGrass) {
            //view.getGrassFloorPaint().setColor(Color.rgb(model.red, model.green, model.blue));
        //}
        //view.invalidate();
        //if(model.touchGrass == true) {
            //view.getGrassFloorPaint().setColor(model.color);
        //}
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }


    //these floats are the horizontal distances away from the original tree
    float treeX1 = 800.0f;
    float treeX2 = 1300.0f;


    /*
    This onTouch method uses the (x, y) coordinates to
    accesses the RGB values and the name of the paint objects.
    Then, the information from the (x,y), RGB values, and names
    are stored in the model. After all of the information is
    initialized to the public instance variables, the red, green,
    and blue SeekBar uses setProgress to change the parameter(i)
    with its corresponding SeekBars.
     */
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x >= 700.0f && x < grassFloorLength && y >= 850.0f && y < 850.0f + grassFloorWidth) {
                int red = Color.red(view.getGrassFloorPaint().getColor());
                int green = Color.green(view.getGrassFloorPaint().getColor());
                int blue = Color.blue(view.getGrassFloorPaint().getColor());
                model.red = red;
                model.green = green;
                model.blue = blue;
                String name = "GRASSY GRASS";
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ model.red + " green: " + model.green + " blue:" + model.blue);
                model.touchGrass = true;
            }
            else if(x >= 0.0f && x < 700.0f && y >= 850.0f && y < 850.0f + grassFloorWidth){
                int red = Color.red(view.getOceanPaint().getColor());
                int green = Color.green(view.getOceanPaint().getColor());
                int blue = Color.blue(view.getOceanPaint().getColor());
                model.red = red;
                model.blue = blue;
                model.green = green;
                String name = "OCEAN";
                model.name = name;
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ red + " green: " + green + " blue:" + blue);
                model.touchOcean = true;
            }
            else if(x >= 2000.0f && x < 2200.0f && y >= 740.0f && y < 850.0f){
                int red = Color.red(view.getBenchPaint().getColor());
                int green = Color.green(view.getBenchPaint().getColor());
                int blue = Color.blue(view.getBenchPaint().getColor());
                model.red = red;
                model.blue = blue;
                model.green = green;
                String name = "BENCH";
                model.name = name;
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ red + " green: " + green + " blue:" + blue);
                model.touchBench = true;
            }
            else if (x >= 90.0f && x < 520.0f && y >= 190.0f && y < 590.0f) {
                int red = Color.red(view.getSunPaint().getColor());
                int green = Color.green(view.getSunPaint().getColor());
                int blue = Color.blue(view.getSunPaint().getColor());
                model.red = red;
                model.blue = blue;
                model.green = green;
                String name = "SUN";
                model.name = name;
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ red + " green: " + green + " blue:" + blue);
                model.touchSun = true;
            }
            else if (x >= 900.0f && x < 1370.0f && y >= 250.0f && y < 450.0f) {
                int red = Color.red(view.getCloudPaint().getColor());
                int green = Color.green(view.getCloudPaint().getColor());
                int blue = Color.blue(view.getCloudPaint().getColor());
                model.red = red;
                model.blue = blue;
                model.green = green;
                String name = "CLOUD";
                model.name = name;
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ red + " green: " + green + " blue:" + blue);
                model.touchCloud = true;
            }
            else if(x >= 1000.0f && x < 1050.0f && y >= 725.0f && y < 850.0f
                    || x >= 1000.0f + treeX1 && x < 1050.0f + treeX1 && y >= 725.0f && y < 850.0f
                    || x >= 1000.0f + treeX2 && x < 1050.0f + treeX2 && y >= 725.0f && y < 850.0f){
                int red = Color.red(view.getTreeTrunkPaint().getColor());
                int green = Color.green(view.getTreeTrunkPaint().getColor());
                int blue = Color.blue(view.getTreeTrunkPaint().getColor());
                model.red = red;
                model.blue = blue;
                model.green = green;
                String name = "TREE TRUNK";
                model.name = name;
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ red + " green: " + green + " blue:" + blue);
                model.touchTreeTrunk = true;
            }
            else if(x >= 950.0f && x < 1100.0f && y >= 500.0f && y < 725.0f
                    || x >= 950.0f + treeX1 && x < 1100.0f + treeX1 && y >= 500.0f && y < 725.0f
                    || x >= 950.0f + treeX2 && x < 1100.0f + treeX2 && y >= 500.0f && y < 725.0f){
                int red = Color.red(view.getTreeLeavesPaint().getColor());
                int green = Color.green(view.getTreeLeavesPaint().getColor());
                int blue = Color.blue(view.getTreeLeavesPaint().getColor());
                model.red = red;
                model.blue = blue;
                model.green = green;
                String name = "TREE LEAVES";
                model.name = name;
                model.x = x;
                model.y = y;
                model.name = name;
                Log.d("name:" + model.name + "rgb", "red: "+ red + " green: " + green + " blue:" + blue);
                model.touchTreeLeaves = true;

            }
            else{
                //do nothing
            }

            redSB.setProgress(model.red);
            greenSB.setProgress(model.green);
            blueSB.setProgress(model.blue);
            elemName.setText(model.name);
            view.invalidate();
        }
        return true;
    }
    
}
