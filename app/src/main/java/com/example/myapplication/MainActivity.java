package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.btnLogin);
        final EditText username = findViewById(R.id.TextName);
        final EditText password = findViewById(R.id.TextPassword);
        final TextView resultado = findViewById(R.id.TextResult);
        
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String txtUsername = username.getText().toString();
                String txtPassword = password.getText().toString();

                if (txtUsername.equals("") && txtPassword.equals("")) {
                    //Login bien!
                    resultado.setText(R.string.TextResultbien);
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


}
