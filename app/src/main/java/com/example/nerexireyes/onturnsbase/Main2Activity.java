package com.example.nerexireyes.onturnsbase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Main2Activity extends AppCompatActivity {
    ImageButton  btNGURADADOPEDIDO;
    ImageButton btnmodificarestado;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnmodificarestado = (ImageButton)findViewById(R.id.btnmodi);



        //btnSccanner = (ImageButton) findViewById(R.id.btnScanner);
        btNGURADADOPEDIDO = (ImageButton) findViewById(R.id.btnVisualizador);

        btNGURADADOPEDIDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Guardar_pedido.class);
                startActivity(intent);
            }
        });
    }
}

