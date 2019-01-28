package com.example.nerexireyes.onturnsbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class modificarestadopedido extends AppCompatActivity {
    TextView txtestao;
    Switch estadodelpedid;
    private DatabaseReference Pedidos;
    Button btnguardarcambios;
    EditText cedula;
    Spinner opcionespalabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificarestadopedido);
        txtestao = (TextView)findViewById(R.id.txtmostrarestado);
        estadodelpedid = findViewById(R.id.switchestado);
        btnguardarcambios =(Button)findViewById(R.id.btnaceptarcambios);
        opcionespalabase = (Spinner) findViewById(R.id.spinorden);

        Pedidos = FirebaseDatabase.getInstance().getReference("Pedidos");

        btnguardarcambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificacion();
            }
        });
    }

    public void onclick(View view) {
        if (view.getId()==R.id.switchestado){
            if (estadodelpedid.isChecked()){
                txtestao.setText("Listo");


            }else{
                txtestao.setText("En preparación");
            }
        }
    }

    public void modificacion(){
        String estadopedido = (String) txtestao.getText();


        String ceduladelcliente = cedula.getText().toString();
        String spinpedido = opcionespalabase.getSelectedItem().toString();
        if (!TextUtils.isEmpty(ceduladelcliente)){
            String id = Pedidos.push().getKey();
            Pedidos t = new Pedidos(id, ceduladelcliente, spinpedido, estadopedido);



            Pedidos.child(ceduladelcliente).setValue(t);
            Toast.makeText(this, "Registrado con éxito", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Por favor llenar el campo cédula", Toast.LENGTH_LONG).show();
        }

    }
}
