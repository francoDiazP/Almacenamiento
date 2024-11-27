package com.example.almacenamiento;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainAgenda extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_agenda);

        et1 = findViewById(R.id.nombre);
        et2 = findViewById(R.id.apellido);

    }

    public void GuardarDatos(View view){
        String nombre = et1.getText().toString();
        String apellido = et2.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(nombre, apellido);
        obj_editor.commit();
        Toast.makeText(this, "los datos han sido guardados", Toast.LENGTH_SHORT).show();
        //al presionar
        finish();
    }

    public void Buscar(View view){
        String nombre = et1.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String apellido = preferences.getString(nombre, "");
        if(apellido.length()==0){
            Toast.makeText(this, "No se encuentra ningún registro", Toast.LENGTH_SHORT).show();
        }else{
            et2.setText(apellido);
        }
    }
}