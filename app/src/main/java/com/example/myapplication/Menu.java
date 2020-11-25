package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.DB.IncidenciaDBHelper;

import java.util.ArrayList;

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
        final Button button4 = menu.findViewById(R.id.btnSettings);

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
                builder.setMessage(getResources().getString(R.string.TextEliminar));
                builder.setPositiveButton(getResources().getString(R.string.TextS),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbHelper = new IncidenciaDBHelper(getContext());
                                db = dbHelper.getWritableDatabase();
                                dbHelper.remove(db);

                                Toast.makeText(getActivity(), getResources().getString(R.string.TextMensaje), Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.setNegativeButton(getResources().getString(R.string.TextN), new DialogInterface.OnClickListener() {
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
            Fragment fragmentAddIncidencia = new Settings();
            menuTransaction.replace(R.id.fragmentID, fragmentAddIncidencia);
            menuTransaction.commit();
        }



}


