package com.example.seventhree.drawmovingball;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Ball extends AppCompatActivity {
    private CreateImage scene;
    private int start_x ;
    private int start_y ;
//    private int getx;
//    private int gety;
    public static final String PREFSZ = "BallPrefz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences storedData = getSharedPreferences(PREFSZ, 0);
        start_x = storedData.getInt("curX", 150);
        start_y = storedData.getInt("curY", 150);

        Log.e("start_x", start_x + "");
        Log.e("start_y", start_y + "");



        SharedPreferences mPrefs = getSharedPreferences("Values", 0);
        int x = mPrefs.getInt("X", 0);
        int y = mPrefs.getInt("Y", 0);
        int dx = storedData.getInt("curDX", x);
        int dy = storedData.getInt("curDY", y);
        if (dx<0)
            x*=-1;
        if (dy<0)
            y*=-1;
        int frame = mPrefs.getInt("Frame", 0);
        String color = mPrefs.getString("Color", "");
        Toast.makeText(this,"Using your Preferences", Toast.LENGTH_SHORT).show();
        scene= new CreateImage(this, start_x, start_y,x,y,Color.parseColor(color),frame);
        setContentView(scene);
      }


    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences storedData = getSharedPreferences(PREFSZ, 0);
        SharedPreferences.Editor storedDataEditor = storedData.edit();
        Point [] pointarr = scene.getXY();
        storedDataEditor.putInt("curX", pointarr[0].x);
        storedDataEditor.putInt("curY", pointarr[0].y);
        storedDataEditor.putInt("curDX", pointarr[1].x);
        storedDataEditor.putInt("curDY", pointarr[1].y);

        storedDataEditor.commit();


        Log.e("x", scene.getXY()[0].x + "");
        Log.e("y", scene.getXY()[0].y + "");


    }
}


