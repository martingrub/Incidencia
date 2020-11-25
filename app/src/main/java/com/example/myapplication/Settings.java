package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settings#} factory method to
 * create an instance of this fragment.
 */
public class Settings extends Fragment {
    protected SharedPreferences prefs;

    public Settings() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View Settings = inflater.inflate(R.layout.fragment_settings, container, false);
        final Button btnEspañol = Settings.findViewById(R.id.btnEspañol);
        final Button btnIngles = Settings.findViewById(R.id.btnIngles);






        btnEspañol.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Save("Es");
            }
        });
        btnIngles.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Save("En");
            }
        });


        return Settings;
    }
    public void Save(String locale){
        prefs = getContext().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Idioma",locale );
        editor.commit();
        refresh();
    }

    public void refresh(){
        Intent intent = ((MainActivity)getActivity()).getIntent();
        startActivity(intent);

        Fragment SetF = new Settings();

        FragmentManager menuManager = getFragmentManager();
        FragmentTransaction menuTransaction = menuManager.beginTransaction();

        menuTransaction.replace(R.id.Menu, SetF);
        menuTransaction.commit();
    }

}