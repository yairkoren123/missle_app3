package com.example.yy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;

public class Setting_activity extends AppCompatActivity {

    Spinner spSize;
    Spinner sp_data_missile;
    String select_value_string = "select a value";
    boolean onfirst_size = true;
    boolean onfirst_data = true;
    boolean button_switch = true;
    String the_selected_size;
    String the_selected_data;
    Button save_button;

    Switch sw_dark_mode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        spSize = findViewById(R.id.spSizes);
        sp_data_missile = findViewById(R.id.spinner_data_alarm);
        sw_dark_mode = findViewById(R.id.dark_mode_switch);
        save_button = findViewById(R.id.setting_save_button);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


//        Intent intent = getIntent();
//        int w = intent.getIntExtra("width_size",10);
//        int h = intent.getIntExtra("height_size",10);

//        Log.d("notme", "onCreate: " + w + " and h : " + h);


        // size list
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add(select_value_string);
        sizes.add("Small");
        sizes.add("Medium");
        sizes.add("Large");

        //data list
        ArrayList<String> data_list_alarm = new ArrayList<>();
        data_list_alarm.add(select_value_string);
        data_list_alarm.add("10");
        data_list_alarm.add("20");
        data_list_alarm.add("30");
        data_list_alarm.add("40");
        data_list_alarm.add("ALL");

        // the size of the icon
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
        // the amount ot th data
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

                if (button_switch){
                    sw_dark_mode.setText("Light");
                    button_switch = false;
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                } else{
                    sw_dark_mode.setText("Dark");

                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    dark_mode();
                    button_switch = true;
                }
            }
        });

        save_button.setOnClickListener(v -> {
            Log.d("setting", "onCreate: data :  " + the_selected_data +
                   " size : " +the_selected_size + " dark "  + button_switch);

            if (the_selected_size.equals(select_value_string)
                    || the_selected_data.equals(select_value_string)){
                Toast.makeText(Setting_activity.this,"You need to select values before saving !!"
                ,Toast.LENGTH_SHORT)
                        .show();

            }else {

                String button_switch_string = String.valueOf(button_switch);

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("size", the_selected_size);
                intent.putExtra("data", the_selected_data);
                intent.putExtra("dark", button_switch_string);

                startActivity(intent);
            }

        });
    }


    private void dark_mode() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}