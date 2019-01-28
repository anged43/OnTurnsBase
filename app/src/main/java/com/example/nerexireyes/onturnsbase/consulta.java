package com.example.nerexireyes.onturnsbase;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class consulta extends AppCompatActivity {

    TextView txtmostrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        txtmostrar = (TextView) findViewById(R.id.txtmos1);




        DatabaseReference bd =
                FirebaseDatabase.getInstance().getReference()
                        .child("Pedidos");


        bd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valor = (String) dataSnapshot.getValue();
                txtmostrar.setText(valor);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });




    }
}
