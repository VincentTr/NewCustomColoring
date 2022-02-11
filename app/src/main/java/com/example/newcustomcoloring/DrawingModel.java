/*
 * Drawing Model Class
 * @author Vincent Truong
 * @date 2/10/2022
 *
 * The DrawingModel class stores data from
 * Paint objects.
 * */
package com.example.newcustomcoloring;

import android.graphics.Color;

public class DrawingModel{
    public int x = 0;
    public int y = 0;
    public int red = 0;
    public int green = 0;
    public int blue = 0;
    public String name = "";
    public boolean touchGrass = false;
    public boolean touchOcean = false;
    public boolean touchBench = false;
    public boolean touchSun = false;
    public boolean touchCloud = false;
    public boolean touchTreeTrunk = false;
    public boolean touchTreeLeaves = false;
    public int color = Color.rgb(red, green, blue);
}
