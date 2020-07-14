package com.michelmaia.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    private TextView textName, textAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        textName = findViewById(R.id.textName);
        textAge = findViewById(R.id.textAge);

        // Recover the data from the MainActivity
        Bundle data = getIntent().getExtras();
        String name = data.getString("name");
        int age = data.getInt("year");

        // Display the recovered data
        textName.setText(name);
        textAge.setText(String.valueOf(age));
    }
}