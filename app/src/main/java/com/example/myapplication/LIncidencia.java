package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.DB.IncidenciaDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LIncidencia#} factory method to
 * create an instance of this fragment.
 */
public class LIncidencia extends Fragment {
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;

    public LIncidencia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        View listIncidencia = inflater.inflate(R.layout.fragment_l_incidencia, container, false);
        RecyclerView recyclerView = listIncidencia.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(listIncidencia.getContext()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, (dbHelper.getIncidencias()));

        recyclerView.setAdapter(adapter);
        return listIncidencia;
    }

}