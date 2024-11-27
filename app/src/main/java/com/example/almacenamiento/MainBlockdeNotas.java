package com.example.almacenamiento;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainBlockdeNotas extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_blockde_notas);

        et1 = findViewById(R.id.notas);
        String archivos[] = fileList();
        if (ArchivoExistes(archivos, "notas.txt")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String NotasCompleta = "";
                while (linea != null) {
                    NotasCompleta = NotasCompleta + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et1.setText(NotasCompleta);

            } catch (IOException e) {

            }
        }

    }

    private boolean ArchivoExistes(String archivo[], String NombreArchivo) {
        for (int i = 0; i < archivo.length; i++) {
            if (NombreArchivo.equals(archivo[1])) {
                return true;
                return false;
            }

            public void GuardarNotas (View view){
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("notas.txt", AppCompatActivity.MODE_PRIVATE));
                    archivo.write(et1.getText().toString());
                }
            }
        }
    }
}
