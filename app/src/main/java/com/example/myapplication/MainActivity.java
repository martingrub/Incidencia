package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static  com.example.myapplication.Settings.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int comprobante = 0;
    int ComIdioma;
    int Contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.btnLogin);
        final EditText username = findViewById(R.id.TextName);
        final EditText password = findViewById(R.id.TextPassword);
        final TextView resultado = findViewById(R.id.TextResult);


        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        comprobante = (preferences.getInt("comprobante", 0));

        if (comprobante != 0) {

            username.setText(preferences.getString("Username",""));
            password.setText(preferences.getString("Password",""));
            String txtUsername = username.getText().toString();
            String txtPassword = password.getText().toString();


            if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                Intent intentmenu = new Intent(this,Fragment.class);
                startActivity(intentmenu);
            }
        }
        
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String txtUsername = username.getText().toString();
                String txtPassword = password.getText().toString();
                    if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                        //Login bien!
                        resultado.setText(R.string.TextResultbien);
                        guardarPreferancias();
                        goToMenu();
                    } else {
                        resultado.setText(R.string.TextResult);
                        //Login mala!!
                    }
                }


        });
    }
        public void goToMenu() {
            Intent intentmenu = new Intent(this,Fragment.class);
            startActivity(intentmenu);
    }




    private void guardarPreferancias() {
        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", ((EditText) findViewById(R.id.TextName)).getText().toString());
        editor.putString("Password", ((EditText) findViewById(R.id.TextPassword)).getText().toString());
        editor.putInt("comprobante", 1);
        editor.commit();
    }
    public void Save(String locale){
        SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Idioma",locale );
        editor.commit();
        refresh();
    }
    public void refresh() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
