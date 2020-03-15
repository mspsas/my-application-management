package com.example.management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class project extends AppCompatActivity {
    Button add1;
    Button update1;
    Button delete1;
    TextView tName;
    TextView tID;
    TextView tDept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ConstraintLayout constraintLayout = findViewById(R.id.layoutgra);
        AnimationDrawable animationDrawable = (AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        initviews();
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initviews(){
        add1=(Button)findViewById(R.id.btna);
        update1=(Button)findViewById(R.id.btnu);
        delete1=(Button)findViewById(R.id.btnd);
        tName= findViewById(R.id.textView5);
        tID=findViewById(R.id.textView6);
        tDept=findViewById(R.id.textView7);
    }

}