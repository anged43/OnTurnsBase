package com.example.nerexireyes.onturnsbase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class actvity_registro extends AppCompatActivity implements View.OnClickListener {
 private EditText nombres , correo , contraseña ;
 private Button registrarse;
 private ProgressDialog progressDialog;

 private FirebaseAuth firebaseAuth;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity_registro);

        firebaseAuth=FirebaseAuth.getInstance();

        nombres =(EditText)findViewById(R.id.txtnombres);
         correo =(EditText)findViewById(R.id.txtCorreo);
         contraseña =(EditText)findViewById(R.id.txtContrase);
         registrarse =(Button) findViewById(R.id.btnRegistrarse);
     progressDialog = new ProgressDialog(this);

        registrarse.setOnClickListener(this);
    }
    private void registrarUsuario(){


        String datos = nombres.getText().toString().trim();
        String email = correo.getText().toString().trim();
        String password  = contraseña.getText().toString().trim();


        if(TextUtils.isEmpty(datos)){
            Toast.makeText(this,"Se debe ingresar el nombre",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(actvity_registro.this,"Se ha registrado el usuario con el email: "+ correo.getText(),Toast.LENGTH_LONG).show();
                        }else{

                            Toast.makeText(actvity_registro.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View v) {
    registrarUsuario();
    }
}
