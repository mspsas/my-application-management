package com.example.management;
import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.Snackbar;
//import android.support.design.widget.TextInputLayout;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;

public class signup_form extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Signup");
    }

    public void onsignup_formClick(View v){
        if(v.getId()==R.id.Blogin){
            EditText name=(EditText)findViewById(R.id.tfname);
            EditText uname=(EditText)findViewById(R.id.tfuname);
            EditText email=(EditText)findViewById(R.id.tfemail);
            EditText pass1=(EditText)findViewById(R.id.tfpass1);
            EditText pass2=(EditText)findViewById(R.id.tfpass2);

            String namestr=name.getText().toString();
            String emailstr=email.getText().toString();
            String unamestr=uname.getText().toString();
            String pass1str=pass1.getText().toString();
            String pass2str=pass2.getText().toString();
            if (!pass1str.equals(pass2str)){
                //popup mag
                Toast pass = Toast.makeText(signup_form.this,"password don't match",Toast.LENGTH_SHORT);
                pass.show();
            }
            else {
                //insert the details in database
                contact c=new contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                c.setPass(pass2str);

                helper.insertcontact(c);


            }

        }

    }

    //this method is used to connect XML views to its Objects


    }



