package com.example.myapplication;

import java.io.Serializable;

public class Incidencia implements Serializable {

    private String Nom;
    private String Urgencia;

    public Incidencia(String Nom, String Urgencia){
        this.Nom=Nom;
        this.Urgencia=Urgencia;
    }
    public String getNom(){
        return Nom;
    }
    public String getUrgencia() {
        return Urgencia;
    }

    public void setNom(String newNom) {
        this.Nom = newNom;
    }

    public void setUrgencia(String newUrgencia) {
        this.Urgencia = newUrgencia;
    }
}
