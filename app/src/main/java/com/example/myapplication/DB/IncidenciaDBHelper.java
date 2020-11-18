package com.example.myapplication.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import com.example.myapplication.DB.IncidenciaContract.*;
import com.example.myapplication.Incidencia;

import java.util.ArrayList;

import static com.example.myapplication.DB.IncidenciaContract.IncidenciaEntry.COLUMN_NAME_TITLE;
import static com.example.myapplication.DB.IncidenciaContract.IncidenciaEntry.TABLE_NAME;
import static com.example.myapplication.DB.IncidenciaContract.IncidenciaEntry.URGENCIA;

public class IncidenciaDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + "(" +
            IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME_TITLE + " TEXT ," + URGENCIA + " TEXT )";

    public IncidenciaDBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void insertIncidencia(SQLiteDatabase db, Incidencia i){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(COLUMN_NAME_TITLE, i.getNom());
            values.put(URGENCIA, i.getUrgencia());

            db.insert(TABLE_NAME, null, values);
        }else{
            Log.d("fastidio","Database is closed");
        }
    }


    public ArrayList<Incidencia> getIncidencias(){
        SQLiteDatabase db = this.getReadableDatabase();
        //Creamos el cursor
        ArrayList<Incidencia> lista = new ArrayList<>();
        Cursor c = db.rawQuery("select * from " + IncidenciaEntry.TABLE_NAME, null);
        while (c.moveToNext()) {


                //Asignamos el valor en nuestras variables para crear un nuevo objeto Comentario
                String nom = c.getString(c.getColumnIndex(COLUMN_NAME_TITLE));
                //String urgencia = c.getString(c.getColumnIndex(URGENCIA));

                Incidencia com = new Incidencia(nom, "urgencia");
                //Añadimos el comentario a la lista
                lista.add(com);
        }
        //Cerramos el cursor
        c.close();
        return lista;
    }
    public void remove(SQLiteDatabase db){
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }



}
