package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class Fragment extends AppCompatActivity {
    protected ArrayList<Incidencia> arrayincidencias;

    protected Fragment[] menuFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        arrayincidencias = new ArrayList<Incidencia>();
        Bundle bundle = new Bundle();
        bundle.putSerializable("arrayincidencias", arrayincidencias);

    }
}