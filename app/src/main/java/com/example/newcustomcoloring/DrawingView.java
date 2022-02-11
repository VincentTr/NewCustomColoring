/*
 * Drawing View Class
 * @author Vincent Truong
 * @date 2/10/2022
 *
 * This DrawingView class creates and displays
 * the Paint objects by calling multiple
 * helper methods as well as the onDraw method.
 * */
package com.example.newcustomcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DrawingView extends SurfaceView {
    Paint treeTrunkPaint = new Paint();
    Paint treeLeavesPaint = new Paint();
    Paint benchPaint = new Paint();
    Paint grassFloorPaint = new Paint();
    Paint sunPaint = new Paint();
    Paint oceanPaint = new Paint();
    Paint cloudPaint = new Paint();
    Paint xyCoordPaint = new Paint();
    Paint rgbValuePaint = new Paint();

    public static final float treeTrunkHeight = 200.0f;
    public static final float grassFloorLength = 2560.0f;
    public static final float grassFloorWidth = 200.0f;



    private DrawingModel model;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         * These colors will change!! The colors for the comments
         * are just the default for now!
         */
        treeTrunkPaint.setColor(0xFF796C57);//brown
        treeTrunkPaint.setStyle(Paint.Style.FILL);
        treeLeavesPaint.setColor(0xFF76A36C);//mossy-green
        treeLeavesPaint.setStyle(Paint.Style.FILL);
        benchPaint.setColor(0xFFE4DFB4);//birch
        benchPaint.setStyle(Paint.Style.FILL);
        grassFloorPaint.setColor(0xFF548B5E);//dark mossy-green
        grassFloorPaint.setStyle(Paint.Style.FILL);
        cloudPaint.setColor(0xFFF3F0EB);//light gray-white
        cloudPaint.setStyle(Paint.Style.FILL);
        sunPaint.setColor(0xFFFFAD21); //bright orangey-yellow
        sunPaint.setStyle(Paint.Style.FILL);
        oceanPaint.setColor(0xFF9DEBEC);//blue
        oceanPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(0xFFEFD879);  //oangey background

        model = new DrawingModel();
    }

    public DrawingModel getModel(){
        return model;
    }



    public void drawGrass(Canvas canvas){
        canvas.drawRect(0, 850.0f, grassFloorLength, 850.0f+ grassFloorWidth, grassFloorPaint);
    }

    public void drawTree(Canvas canvas, float x){
        canvas.drawRect(1000.0f+x, 850.0f-treeTrunkHeight, 1000.0f+50.0f+x, 850.0f, treeTrunkPaint);
        canvas.drawOval(950.0f+x, 850.0f-treeTrunkHeight-150.0f, 1000.0f+100.0f+x, 725.0f,treeLeavesPaint);
    }

    public void drawBench(Canvas canvas){
        for(int i = 0; i < 5; i++){
            //back of the bench
            canvas.drawRect(2000.0f, 740.0f+(i*15), 2200.0f, 750.0f+(i*15), benchPaint);
        }
        //legs of the bench
        canvas.drawRect(2000.0f, 740.0f+65.0f, 2020.0f, 850.0f, benchPaint);
        canvas.drawRect(2180.0f, 740.0f+65.0f, 2200.0f, 850.0f, benchPaint);
    }

    public void drawSun(Canvas canvas){
        canvas.drawCircle(300.0f, 400.0f, 300.0f, sunPaint);
    }

    public void drawOcean(Canvas canvas){
        canvas.drawRect(0, 850.0f, 700.0f, 1050.0f, oceanPaint);
    }

    public void drawCloud(Canvas canvas){
        canvas.drawCircle(1000.0f, 350.0f, 100.0f, cloudPaint);
        canvas.drawCircle(1100.0f, 300.0f, 100.0f, cloudPaint);
        canvas.drawCircle(1200.0f, 300.0f, 100.0f, cloudPaint);
        canvas.drawCircle(1160.0f, 350.0f, 100.0f, cloudPaint);
        canvas.drawCircle(1270.0f, 350.0f, 100.0f, cloudPaint);
    }


    float treeX1 = 800.0f;
    float treeX2 = 1300.0f;

    @Override
    public void onDraw(Canvas canvas)
    {

        drawSun(canvas);

        drawGrass(canvas);

        drawOcean(canvas);

        drawTree(canvas, 0.0f);
        drawTree(canvas, treeX1);
        drawTree(canvas, treeX2);

        drawBench(canvas);

        drawCloud(canvas);

        canvas.drawText(model.x+", "+ model.y, 50, 50,xyCoordPaint);
        canvas.drawText(model.red + ", "+ model.green + ", " +model.blue, 50, 100, rgbValuePaint);



    }//onDraw

    public Paint getTreeTrunkPaint(){
        return treeTrunkPaint;
    }
    public Paint getTreeLeavesPaint(){
        return treeLeavesPaint;
    }
    public Paint getOceanPaint(){
        return oceanPaint;
    }
    public Paint getSunPaint(){
        return sunPaint;
    }
    public Paint getBenchPaint(){
        return benchPaint;
    }
    public Paint getCloudPaint(){
        return cloudPaint;
    }
    public Paint getGrassFloorPaint(){
        return grassFloorPaint;
    }
}
