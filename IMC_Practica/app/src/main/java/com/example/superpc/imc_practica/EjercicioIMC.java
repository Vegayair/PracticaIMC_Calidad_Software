package com.example.superpc.imc_practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class EjercicioIMC extends AppCompatActivity {

    EditText peso, altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_imc);

        Button calcular = (Button) findViewById(R.id.Calcular);
        Button salir = (Button) findViewById(R.id.Salir);


        peso = (EditText) findViewById(R.id.Peso);
        altura = (EditText) findViewById(R.id.Altura);

    }

    public void limpiar(){
        peso.setText("");
        altura.setText("");
    }

}


