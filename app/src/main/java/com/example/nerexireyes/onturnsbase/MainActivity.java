package com.example.nerexireyes.onturnsbase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText correo, contraseña;
    private Button botonLogin, botonRegistro;
   private ProgressDialog progressDialog;
   private FirebaseAuth firebaseAuth;
   Button btntablon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();



        correo = (EditText) findViewById(R.id.user);
        contraseña = (EditText) findViewById(R.id.password);
        botonLogin=(Button) findViewById(R.id.btnlogin);
        btntablon = (Button)findViewById(R.id.btntab);

        progressDialog=new ProgressDialog(this);
        botonLogin.setOnClickListener(this);

        btntablon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttab = new Intent(MainActivity.this, consulta.class);
                startActivity(intenttab);
            }
        });
    }

    private void loguearUsuario() {

        final String email = correo.getText().toString().trim();
        String password = contraseña.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Toast.makeText(MainActivity.this, "Bienvenido: " + correo.getText(), Toast.LENGTH_LONG).show();
                            Intent intencion = new Intent(getApplication(), WellcomeActivity.class);
                            intencion.putExtra(WellcomeActivity.user, user);
                            startActivity(intencion);

                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                            } else {
                                Toast.makeText(MainActivity.this, "Usuario o Contraseña incorrecto ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onClick(View v) {
    loguearUsuario();
    }
}
