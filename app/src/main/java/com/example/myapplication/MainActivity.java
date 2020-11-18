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
                Log.i("btn click", "Me has clicado, tu deseo no sera concedido no soy un genio soy un mensaje");
                String txtUsername = username.getText().toString();
                String txtPassword = password.getText().toString();

                if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                    //Login bien!
                    resultado.setText("Bien");
                    goToMenu();
                } else {
                    resultado.setText("Mal");
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
