package com.example.yy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class game1Fragment extends Fragment {


    public game1Fragment() {
    }


    public static game1Fragment newInstance(String param1, String param2) {
        game1Fragment fragment = new game1Fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game1,container,false);

        return view;
    }
}