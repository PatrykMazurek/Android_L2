package com.masiad.myapplication_l2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        EditText etName = findViewById(R.id.eTPersonName);
        EditText etLastName = findViewById(R.id.eTPersonLastName);
        EditText etCity = findViewById(R.id.eTPersonCity);
        Button bSave = findViewById(R.id.bSave);
        Button bPrev = findViewById(R.id.bPrev);

        int id = getIntent().getIntExtra("id", 0);

        if (id > 0){
            bSave.setText("Aktualizuj");
        }else{
            bSave.setText("Dodaj użytkownika");
        }

        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String lastName = etLastName.getText().toString();
                String city = etCity.getText().toString();
            }
        });

    }
}