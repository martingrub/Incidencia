package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;


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
            public void onClick(View v){
                goToAfegirIncidencia();
            }


        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToListarIncidencia();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Segur que vol eliminar las dades?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbHelper = new IncidenciaDBHelper(getContext());
                                db = dbHelper.getWritableDatabase();
                                dbHelper.remove(db);

                                Toast.makeText(getActivity(), "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                AlertDialog dialog = builder.create();
                builder.show();

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

        public void goToAyuda() {
            FragmentManager menuManager = getFragmentManager();
            FragmentTransaction menuTransaction = menuManager.beginTransaction();
            Fragment fragmentAddIncidencia = new Ayuda();
            menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
            menuTransaction.commit();
        }



}


