package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication.DB.IncidenciaDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AIncidencia#} factory method to
 * create an instance of this fragment.
 */
public class AIncidencia extends Fragment {
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;
    public AIncidencia() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View AIncidencia = inflater.inflate(R.layout.fragment_a_incidencia, container, false);
        final String[] emergencia = new String[] {"Alta","Mediana","Baja"};
        final Spinner spinner = AIncidencia.findViewById(R.id.spinner);
        final ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, emergencia);
        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Tipo de urgencia");
        spinner.setAdapter(adapter);

        final Button btnAfegirIncidencia = AIncidencia.findViewById(R.id.btnAfegirIncidencia);
        btnAfegirIncidencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtIncidencia = AIncidencia.findViewById(R.id.TextName);
                String txtIncidenciaForm = txtIncidencia.getText().toString();
                String urgencia = spinner.getSelectedItem().toString();
                ((com.example.myapplication.Fragment)getActivity()).arrayincidencias.add(new Incidencia(txtIncidenciaForm,urgencia));
                Incidencia incidencia = new Incidencia(txtIncidenciaForm,urgencia);
                dbHelper.insertIncidencia(db, incidencia);

            }
        });

        return AIncidencia;
    }

}