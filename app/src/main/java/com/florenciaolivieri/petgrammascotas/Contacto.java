package com.florenciaolivieri.petgrammascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void irAtras(View v) {
        Intent i = new Intent(Contacto.this, MainActivity.class);
        startActivity(i);
    }
}