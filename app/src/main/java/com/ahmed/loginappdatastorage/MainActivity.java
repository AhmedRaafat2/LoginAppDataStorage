package com.ahmed.loginappdatastorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name_edit;
    EditText email_edit;
    Button save;
    Button load;
    TextView nameView;
    TextView emailView;
    Button secondActivitybutton;
    Switch aSwitch;
    RelativeLayout relativeLayout;
    final String FILE = "com.ahmed.loginappdatastorage.FILE";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_edit = findViewById(R.id.nameEditText);
        email_edit = findViewById(R.id.emailEditText);
        save = findViewById(R.id.saveButton);
        load = findViewById(R.id.loadButton);
        nameView = findViewById(R.id.nameTextView);
        emailView = findViewById(R.id.emailTextView);
        secondActivitybutton = findViewById(R.id.secondActiviryButton);
        aSwitch = findViewById(R.id.switchBtn);
        relativeLayout = findViewById(R.id.mainActivityView);

        secondActivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name_edit.getText().toString());
                editor.putString("email",email_edit.getText().toString());
                editor.apply();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE,Context.MODE_PRIVATE);
                String myname = sharedPreferences.getString("name","Not Avaliable");
                String myEmail = sharedPreferences.getString("email","Not Avaliable");
                nameView.setText(myname);
                emailView.setText(myEmail);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPreferences = getSharedPreferences(FILE,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();


               /* editor.putBoolean("color",isChecked);
                editor.apply();
                relativeLayout.setBackgroundColor(isChecked ? getResources().getColor());
                */
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1 :
                Toast.makeText(MainActivity.this,"item 1",Toast.LENGTH_SHORT).show();
            case R.id.item2 :
                Toast.makeText(MainActivity.this,"item 2",Toast.LENGTH_SHORT).show();
            }


        return super.onOptionsItemSelected(item);

    }
}
