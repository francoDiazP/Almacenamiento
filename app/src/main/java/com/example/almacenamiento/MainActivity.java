package com.example.almacenamiento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnShared, agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        agenda = findViewById(R.id.btn_agenda);
        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainAgenda.class);
                startActivity(i);
            }
        });
    }

    public void shared(View view){
        Intent i = new Intent(MainActivity.this, MainShared.class);
        startActivity(i);
    }
}


/**btnShared=findViewById(R.id.btn_Shared);

 btnShared.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent shared = new Intent(MainActivity.this, MainShared.class);
startActivity(shared);
}
});**/