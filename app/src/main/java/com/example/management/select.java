package com.example.management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select extends AppCompatActivity {

    Button empdetail;
    Button department;
    Button project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initviews();
        empdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), empdetail.class);
                startActivity(i);
            }
        });
        department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), department.class);
                startActivity(i);
            }
        });
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), project.class);
                startActivity(i);
            }
        });
    }
    public void initviews()
    {
     empdetail=(Button)findViewById(R.id.button2);
     department=(Button)findViewById(R.id.button);
     project=(Button)findViewById(R.id.button4);


    }
}

