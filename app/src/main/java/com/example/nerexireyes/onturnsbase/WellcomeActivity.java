package com.example.nerexireyes.onturnsbase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WellcomeActivity extends AppCompatActivity {
    public static final String user = "names";
    TextView txtUser;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        siguiente = (Button) findViewById(R.id.btnsiguiente);
        txtUser = (TextView) findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("¡Bienvenid@ " + user + "!");

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WellcomeActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}


