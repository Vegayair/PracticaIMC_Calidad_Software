package com.example.superpc.imc_practica;

/**
 * Created by SuperPc on 24/04/2017.
 */

public class IMC {
    public float calcula(float kg,float cm) {
        float m = (cm / 100);
        float bmi = (kg / (m * m));
        return bmi;
    }
}
