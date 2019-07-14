package com.example.ud3_ejemplo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos el TextView de la actividad 1 por su id (actividad1).
        TextView actividad1 = findViewById(R.id.actividad1);

        // Asignamos un Click Listener sobre el TextView
        actividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct1 = new Intent(MainActivity.this, Actividad1.class);
                startActivity(intentAct1);
            }
        });

        // Buscamos el TextView de la actividad 2 por su id (actividad2).
        TextView actividad2 = findViewById(R.id.actividad2);

        // Asignamos un Click Listener sobre el TextView
        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct2 = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intentAct2);
            }
        });
    }
}
