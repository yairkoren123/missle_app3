package com.example.yy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Setting_activity extends AppCompatActivity {

    Spinner spSize;
    Spinner sp_data_missile;
    String select_value_string = "select a value";
    boolean onfirst_size = true;
    boolean onfirst_data = true;
    boolean button_switch = true;
    ToggleButton TB_dark_Button;
    String the_selected_size;
    String the_selected_data;
    Button save_button;
    SeekBar sk_data;
    SeekBar sk_size;
    String val_data;
    String val_size;



    Switch sw_dark_mode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sw_dark_mode = findViewById(R.id.dark_mode_switch);
        save_button = findViewById(R.id.setting_save_button);
        sk_data = findViewById(R.id.seekBar_Data);
        sk_size = findViewById(R.id.seekBar_Size);
        TB_dark_Button = findViewById(R.id.toggleButton);





        Intent intent = getIntent();
        int size_main_icon = intent.getIntExtra("width_size",40);
        int data_main = intent.getIntExtra("data",30);

        Log.d("notme", "onCreate: " + size_main_icon + " and h : " + data_main);


        // size list
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("30");
        sizes.add("40");
        sizes.add("50");

        //data list
        ArrayList<String> data_list_alarm = new ArrayList<>();
        data_list_alarm.add("10");
        data_list_alarm.add("20");
        data_list_alarm.add("30");
        data_list_alarm.add("40");
        data_list_alarm.add("50");

        Log.d("seekbartry", "onCreate: " +data_list_alarm.get(1));


        // the data progress bar:
        for (int i = 0; i < data_list_alarm.size(); i++) {
            val_data = data_list_alarm.get(i);
            if (val_data.equals(String.valueOf(data_main))){
                int t = Integer.parseInt(val_data)/10;
                sk_data.setProgress(t-1);
                Log.d("seek", "onCreat1e: d : "+val_data);
                break;
            }
        }
        // the size of the icon progress bar
        for (int i = 0; i < sizes.size(); i++) {
            val_size = sizes.get(i);
            if (val_size.equals(String.valueOf(size_main_icon))){
                int t = (Integer.parseInt(val_size)-20)/10;
                sk_size.setProgress(t-1);
                Log.d("seek", "onCreat1e: s :"+val_size);
                break;
            }
        }


        sk_data.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("seekbart", "onProgressChanged:  d : " + data_list_alarm.get(progress));
                the_selected_data = data_list_alarm.get(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sk_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("seekbart", "onProgressChanged: s :" + sizes.get(progress));
                the_selected_size = sizes.get(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        //mode dark


        TB_dark_Button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == false) {
                    button_switch = true;

                    // Todo dark mode
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


                    button_switch = false;
                }
            }
        });

//        sw_dark_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    sw_dark_mode.setText("Light");
//                    button_switch = false;
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//                } else {
//                    sw_dark_mode.setText("Dark");
//
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//                    dark_mode();
//                    button_switch = true;
//                }
//            }
//        });

//        sw_dark_mode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (button_switch == true){
//                    sw_dark_mode.setText("Light");
//                    button_switch = false;
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//                } else{
//                    sw_dark_mode.setText("Dark");
//
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//                    dark_mode();
//                    button_switch = true;
//                }
//            }
//        });

        save_button.setOnClickListener(v -> {

            if (the_selected_data == null){
                the_selected_data = val_data;
            }
            if (the_selected_size == null){
                the_selected_size = val_size;
            }
            Log.d("setting", "onCreate: data :  " + the_selected_data +
                   " size : " +the_selected_size + " dark "  + button_switch);

                Log.d("returns", "onCreate:  size : " +the_selected_size + " data :  " + the_selected_data) ;


                String button_switch_string = String.valueOf(button_switch);
                if (the_selected_data == null){
                    the_selected_data = val_data;
                }
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("size", the_selected_size);
                intent2.putExtra("data", the_selected_data);
                intent2.putExtra("dark", button_switch_string);

                startActivity(intent2);

//                Toast.makeText(Setting_activity.this,"You need to select values before saving !!"
//                ,Toast.LENGTH_SHORT)
//                        .show();

            Log.d("returns", "onCreate:  size : " + the_selected_size + " data :  " + the_selected_data);

        });
    }



    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //finish();
    }
}