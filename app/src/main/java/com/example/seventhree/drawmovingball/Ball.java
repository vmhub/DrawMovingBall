package com.example.seventhree.drawmovingball;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Ball extends AppCompatActivity {

    private int start_x = 150;
    private int start_y = 150;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences mPrefs = getSharedPreferences("Values", 0);
        int x = mPrefs.getInt("X", 0);
        int y = mPrefs.getInt("Y", 0);
        int frame = mPrefs.getInt("Frame", 0);
       String color = mPrefs.getString("Color", "");
       Toast.makeText(this,"Using your Preferences", Toast.LENGTH_SHORT).show();
        CreateImage scene= new CreateImage(this, start_x, start_y,x,y,Color.parseColor(color),frame);
        setContentView(scene);
      }





    }


