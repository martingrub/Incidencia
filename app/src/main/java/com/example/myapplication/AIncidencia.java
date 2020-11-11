package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AIncidencia#} factory method to
 * create an instance of this fragment.
 */
public class AIncidencia extends Fragment {
    public AIncidencia() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View AIncidencia = inflater.inflate(R.layout.fragment_a_incidencia, container, false);
        String[] emergencia = new String[] {"Alta","Mediana","Baja"};
        Spinner spinner = AIncidencia.findViewById(R.id.spinner);
        final ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, emergencia);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Tipo de urgencia");
        spinner.setAdapter(adapter);

        final Button btnAfegirIncidencia = AIncidencia.findViewById(R.id.btnAfegirIncidencia);
        btnAfegirIncidencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtIncidencia = AIncidencia.findViewById(R.id.TextName);
                String txtIncidenciaForm = txtIncidencia.getText().toString();

                ((com.example.myapplication.Fragment)getActivity()).arrayincidencias.add(new Incidencia(txtIncidenciaForm, "alta"));

            }
        });

        return AIncidencia;
    }
}