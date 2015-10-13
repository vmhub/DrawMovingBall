package com.example.seventhree.drawmovingball;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
private Spinner dropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        dropdown = (Spinner)findViewById(R.id.color);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colorNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       dropdown.setAdapter(adapter);


    }
    public void sendParams(View view) {
        Intent draw = new Intent(getApplicationContext(),Ball.class);
        EditText dx = (EditText)findViewById(R.id.dxInput);
        EditText dy = (EditText)findViewById(R.id.dyInput);
        EditText framerate = (EditText)findViewById(R.id.frameInput);
      //  Spinner dropdown = (Spinner)findViewById(R.id.color);
        int x,y,frame;
        SharedPreferences mPrefs = getSharedPreferences("Values", 0);
        SharedPreferences.Editor ed = mPrefs.edit();

        try{

           x= Integer.parseInt(dx.getText().toString());
        }catch(NumberFormatException e){
            x=0;
        }
        try{

            y=Integer.parseInt(dy.getText().toString());
             }catch(NumberFormatException e){
             y=0;
              }
        try{

            frame= Integer.parseInt(framerate.getText().toString());
        }catch(NumberFormatException e){
        frame=0;
        }

        ed.putInt("X",x);
        ed.putInt("Y",y);
        ed.putInt("Frame", frame);
       ed.putString("Color", dropdown.getSelectedItem().toString());
        ed.commit();
        dx.setText("");
        dy.setText("");
        framerate.setText("");
        startActivity(draw);
        // Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }


}
