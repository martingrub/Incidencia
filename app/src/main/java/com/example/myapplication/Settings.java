package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

    public Settings() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View Settings = inflater.inflate(R.layout.fragment_settings, container, false);
        final Button btnEspañol = Settings.findViewById(R.id.btnEspañol);
        final Button btnIngles = Settings.findViewById(R.id.btnIngles);
        final Button btnRuso = Settings.findViewById(R.id.btnJapones);
        final Button btnRestaurar = Settings.findViewById(R.id.btnRestaurar);

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
        btnRuso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("Ja");
            }
        });

        btnRestaurar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //BorrarCredenciles();
                Locale.getDefault().toString();
                String locale = Locale.getDefault().getLanguage();
                BorrarIdioma(locale);
            }
        });

        return Settings;
    }
    public void Save(String locale){
        SharedPreferences preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Idioma",locale );
            editor.commit();
            refresh();
    }
    public void BorrarIdioma(String locale){
        //Chapuza de las gordas pero no me sale otra forma de hacerlo XD
        SharedPreferences preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        refresh();

    }
   public void BorrarCredenciles(){
       SharedPreferences preferences = getActivity().getSharedPreferences("credenciales", Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = preferences.edit();
       editor.clear();
       editor.commit();
       refresh();
    }

   public void refresh(){
       Intent intent = new Intent(getContext(),MainActivity.class);
       startActivity(intent);
    }

}