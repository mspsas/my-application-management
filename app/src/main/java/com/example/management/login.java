package com.example.management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.design.widget.TextInputLayout;
//import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import static java.lang.Class.forName;

public class login extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    Button login;
    Bundle register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
   /* public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu._main,menu);
        return true;
    }*/

    public void onloginlick(View v){
     if(v.getId() == R.id.Blogin){
         EditText a=(EditText)findViewById(R.id.tfusername);
         String str=a.getText().toString();
         EditText b=(EditText)findViewById(R.id.tfpassword);
         String pass=b.getText().toString();

         String password = helper.searchPass(str);
         if(pass.equals(password))
         {
             Intent i =new Intent(login.this,select.class);
             startActivity(i);
         }
         else {
             Toast temp = Toast.makeText(login.this,"username and password don't match",Toast.LENGTH_SHORT);
             temp.show();
         }


     }
    if (v.getId()==R.id.Bsignup){
        Intent i=new Intent(login.this,signup_form.class);
        startActivity(i);
    }
    }}