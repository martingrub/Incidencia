package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {



    public Menu() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ArrayList<Incidencia> In;


        In = new ArrayList<Incidencia>();
        View menu = inflater.inflate(R.layout.opciones, container, false);
        final Button button1 = menu.findViewById(R.id.btnIncidencia);
        final Button button2 = menu.findViewById(R.id.btnListaIncidencia);
        final Button button3 = menu.findViewById(R.id.btnEliminar);
        final Button button4 = menu.findViewById(R.id.btnAyuda);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("info", "funciona");
                //goToAfegirIncidencia();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentAddIncidencia = new AIncidencia();
                menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
                Log.i("prova", "clic");
                menuTransaction.commit();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToListarIncidencia();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToEliminarIncidencia();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToAyuda();
            }
        });
        return  menu;
    }


        public void goToAfegirIncidencia() {
            FragmentManager menuManager = getFragmentManager();
            FragmentTransaction menuTransaction = menuManager.beginTransaction();
            Fragment fragmentAddIncidencia = new AIncidencia();
            menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
            menuTransaction.commit();
        }
        public void goToListarIncidencia() {
            FragmentManager menuManager = getFragmentManager();
            FragmentTransaction menuTransaction = menuManager.beginTransaction();
            Fragment fragmentAddIncidencia = new LIncidencia();
            menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
            menuTransaction.commit();
        }
        public void goToEliminarIncidencia() {
            FragmentManager menuManager = getFragmentManager();
            FragmentTransaction menuTransaction = menuManager.beginTransaction();
            Fragment fragmentAddIncidencia = new EIncidencia();
            menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
            menuTransaction.commit();
        }
        public void goToAyuda() {
            FragmentManager menuManager = getFragmentManager();
            FragmentTransaction menuTransaction = menuManager.beginTransaction();
            Fragment fragmentAddIncidencia = new Ayuda();
            menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
            menuTransaction.commit();
        }

    }


