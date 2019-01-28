package com.example.nerexireyes.onturnsbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Guardar_pedido extends AppCompatActivity {
    TextView estadopordefecto;

    EditText txtturno;
    Button btnguarar;
    private DatabaseReference Pedidos;
    Spinner opciones;
    Spinner opcionespalabase;
    int numeroturno = 1;
    Button btnaumentarturno;
    Switch estadoswi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guardarpedido);
        opciones = (Spinner)findViewById(R.id.spinorden);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ordencliente, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
        estadopordefecto =(TextView)findViewById(R.id.txtenproceso);
        estadoswi = (Switch)findViewById(R.id.estadoswitch);

        Pedidos = FirebaseDatabase.getInstance().getReference("Pedidos");
        txtturno = (EditText) findViewById(R.id.txt1);
        opcionespalabase = (Spinner) findViewById(R.id.spinorden);
        btnaumentarturno= (Button)findViewById(R.id.btn1);
        btnguarar = (Button) findViewById(R.id.btn1);
        btnguarar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Registroturno();


            }
        });
    }

    public void Registroturno(){
        String estadopedido = (String) estadopordefecto.getText();


        String ceduladelcliente = txtturno.getText().toString();
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

    public void Onclick(View view) {

        if (view.getId()==R.id.estadoswitch){
            if (estadoswi.isChecked()){
                estadopordefecto.setText("Listo");


            }else{
                estadopordefecto.setText("En preparación");
            }
        }
    }
}
