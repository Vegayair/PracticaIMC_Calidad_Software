package com.example.superpc.imc_practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EjercicioIMC extends AppCompatActivity implements View.OnClickListener{

    EditText peso, altura; // declaracion de variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_imc);

        Button calcular = (Button) findViewById(R.id.Calcular);
        calcular.setOnClickListener(this);

        Button salir = (Button) findViewById(R.id.Salir);
        salir.setOnClickListener(this);

        peso = (EditText) findViewById(R.id.Peso);
        altura = (EditText) findViewById(R.id.Altura);

    }

    public void onClick(View v) {
        // metodo  de las acciones de los botones switch que sirve para saber cuando alguno de los campos esta vacio.
        switch (v.getId()) {
            case R.id.Salir:
                System.exit(0);
                break;
            case R.id.Calcular:
                if (peso.getText().toString().trim().length() == 0) {
                    peso.requestFocus();
                    Toast.makeText(EjercicioIMC.this,
                            "El campo peso esta vacio", Toast.LENGTH_SHORT)
                            .show();
                } else if (altura.getText().toString().trim().length() == 0) {
                    altura.requestFocus();
                    Toast.makeText(EjercicioIMC.this,
                            "El campo altura esta vacio",
                            Toast.LENGTH_SHORT).show();
                } else {
                    CalcuIMC();
                    break;
                }
        }
    }



    public void CalcuIMC(){
        // metodo que  sirve para calcular el IMC
        IMC calcu = new IMC();
        float kg=Float.parseFloat(peso.getText().toString());
        float cm=Float.parseFloat(altura.getText().toString());
        calcu.calcula(kg,cm);
        float m = (cm / 100);
        float bmi = (kg / (m * m));


        //Clasificacion de promedio de masa corporal , Delgado , normal , sobrepeso y obesidad por medio de un rango determinado.
        if (bmi < 18.5) {
            Toast.makeText(EjercicioIMC.this,
                    "Tu IMC es " + bmi + "\n" + "Estas delgado",
                    Toast.LENGTH_SHORT).show();
            limpiar();
        } else {
            if (bmi < 24.9) {
                Toast.makeText(
                        EjercicioIMC.this,
                        "Tu IMC es " + bmi + "\n"
                                + "Tu peso es normal",
                        Toast.LENGTH_SHORT).show();
                limpiar();
            } else {
                if (bmi < 29.9) {
                    Toast.makeText(
                            EjercicioIMC.this,
                            "Tu IMC es " + bmi + "\n"
                                    + "Tienes sobrepeso",
                            Toast.LENGTH_SHORT).show();
                    limpiar();

                } else {
                    if (bmi > 30) {
                        Toast.makeText(
                                EjercicioIMC.this,
                                "Tu IMC es " + bmi + "\n"
                                        + "Padeces obesidad",
                                Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
            }
        }
    }


    public void limpiar(){
        peso.setText("");
        altura.setText("");
    }
    // metodo para limpiar los campos , cada vez que se requiere otra consulta .
}


