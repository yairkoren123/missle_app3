package com.example.searchonmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.datepicker.OnSelectionChangedListener;

import java.util.ArrayList;

public class Setting_activity extends AppCompatActivity {

    Spinner spSize;
    Spinner sp_data_missile;
    String select_value_string = "select a value";
    boolean onfirst_size = true;
    boolean onfirst_data = true;
    String the_selected_size;
    String the_selected_data;
    Switch sw_dark_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        spSize = findViewById(R.id.spSizes);
        sp_data_missile = findViewById(R.id.spinner_data_alarm);
        sw_dark_mode = findViewById(R.id.dark_mode_switch);

        Intent intent = getIntent();
        int w = intent.getIntExtra("width_size",10);
        int h = intent.getIntExtra("height_size",10);

        Log.d("notme", "onCreate: " + w + " and h : " + h);

        ArrayList<String> sizes = new ArrayList<>();
        sizes.add(select_value_string);
        sizes.add("Small");
        sizes.add("Medium");
        sizes.add("Large");

        ArrayList<String> data_list_alarm = new ArrayList<>();

        data_list_alarm.add(select_value_string);
        data_list_alarm.add("10");
        data_list_alarm.add("20");
        data_list_alarm.add("30");
        data_list_alarm.add("40");
        data_list_alarm.add("ALL");


        spSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                the_selected_size = sizes.get(position);
                Log.d("spinner", "onItemClick: size : " +the_selected_size);
                if (onfirst_size == false &&(the_selected_size.equals(select_value_string) ) ){
                    Toast.makeText(Setting_activity.this,"Select another value"
                    ,Toast.LENGTH_LONG)
                            .show();
                }
                onfirst_size = false;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_data_missile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                the_selected_data = data_list_alarm.get(position);
                Log.d("spinner", "onItemSelected: data :  " + the_selected_data);
                if (onfirst_data == false &&(the_selected_data.equals(select_value_string) ) ){
                    Toast.makeText(Setting_activity.this,"Select another value"
                            ,Toast.LENGTH_LONG)
                            .show();
                }
                onfirst_data = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //mode dark
        sw_dark_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sw_dark_mode.setText("Light");
            }
        });








    }
}