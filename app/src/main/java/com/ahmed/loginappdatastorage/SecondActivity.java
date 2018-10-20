package com.ahmed.loginappdatastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    Button load;
    Button clear;
    Button remove;
    TextView name;
    TextView email;
    final String FILE = "com.ahmed.loginappdatastorage.FILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        load = findViewById(R.id.loadButton);
        clear = findViewById(R.id.clearButton);
        remove = findViewById(R.id.removeButton);
        name = findViewById(R.id.name2TextView);
        email = findViewById(R.id.email2TextView);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE, Context.MODE_PRIVATE);
                String myname = sharedPreferences.getString("name","Not Avaliable");
                String myEmail = sharedPreferences.getString("email","Not Avaliable");
                name.setText(myname);
                email.setText(myEmail);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("email");
                editor.apply();
            }
        });


    }
}
