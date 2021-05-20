package com.example.yy.DATA;

import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Enter_data_text extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";

    EditText mEditText;


    public void save(String lac, LatLng latLng) {
        String text = lac;
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            mEditText.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String load() {
        String ll = "null";

        try {
            File myObj = new File(FILE_NAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ll = data;
            }
            myReader.close();
            return ll;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "null";
    }


//
//        FileInputStream fis = null;
//
//        try {
//            fis = openFileInput(FILE_NAME);
//            Log.d("TAG", "load: FILE_NAME :" + FILE_NAME);
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader br = new BufferedReader(isr);
//            StringBuilder sb = new StringBuilder();
//            String text1 ;
//
//            while ((text1 = br.readLine()) != null) {
//                sb.append(text1).append("\n");
//            }
//            String wo = sb.toString();
//            Log.d("pp", "load: "+ wo);
//            String[] aar  = wo.split(" ");
//            for (int i = 0; i < aar.length; i++) {
//                Log.d("TAG3", "load: "+ aar[i]);
//                String[] bbr = aar[i].split(",");
//                for (int j = 0; j < bbr.length; j++) {
//                    Log.d("TAG4", "load: "+ bbr[0]);
//
//                }
//            }
//            Log.d("wow", "loa1d: " + aar[1]  + " sd " + aar.length);
//
//            for (int i = 0; i < aar.length; i++) {
//                Log.d("wow", "load: " + aar[1]);
//            }
//            Log.d("bees", "load: " + sb.toString());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


}