package com.example.management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class project extends AppCompatActivity {
    SQLiteDatabase sqlitedb;
    Button add1;
    Button update1;
    Button delete1;
    TextView tName;
    TextView tID;
    TextView tDept;
    String nam,id,dep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ConstraintLayout constraintLayout = findViewById(R.id.layoutgra);
        AnimationDrawable animationDrawable = (AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        setContentView(R.layout.activity_department);
        sqlitedb=openOrCreateDatabase("employee", Context.MODE_PRIVATE,null);
        //department details
        sqlitedb.execSQL("create table if not exists project_details(proname varchar(255),proID varchar(255) primary key, prodep varchar(25)) ");
        initviews();
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btna)
                {
                    nam=tName.getText().toString().trim();
                    id=tID.getText().toString().trim();
                    dep=tDept.getText().toString().trim();
                    if(nam.equals("")||id.equals("")||dep.equals(""))
                    {
                        Toast.makeText(project.this,"Field cant be empty",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else
                    {
                        sqlitedb.execSQL("insert into project_details(proname,proID,prodep) values('"+nam+"','"+id+"','"+dep+"')");
                        Toast.makeText(project.this,"Record saved", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnu){
                    nam=tName.getText().toString().trim();
                    id=tID.getText().toString().trim();
                    dep=tDept.getText().toString().trim();
                    if(id.equals(""))
                    {
                        Toast.makeText(project.this,"Enter your project id",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cursorupdate=sqlitedb.rawQuery("select * from project_details where proID = '"+id+"'",null);
                    if(cursorupdate.moveToFirst()){
                        if(nam.equals("")||id.equals("")||dep.equals(""))
                        {
                            Toast.makeText(project.this,"Field cant be empty",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            sqlitedb.execSQL("update project_details set proname='"+nam+"',prodep='"+dep+"' where proID='"+id+"'");
                            Toast.makeText(project.this,"record updated sucessfully!!",Toast.LENGTH_SHORT).show();
                            return;

                        }

                    }
                    else {
                        Toast.makeText(project.this,"DATA NOT FOUND",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnd){
                    nam=tName.getText().toString().trim();
                    id=tID.getText().toString().trim();
                    dep=tDept.getText().toString().trim();
                    if(id.equals(""))
                    {
                        Toast.makeText(project.this,"Enter your department id",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cursorupdate=sqlitedb.rawQuery("select * from project_details where proID = '"+id+"'",null);
                    if(cursorupdate.moveToFirst()){
                        sqlitedb.execSQL("delete from project_details where proID='"+id+"'");
                        Toast.makeText(project.this,"Record deleted !!",Toast.LENGTH_SHORT).show();
                    }
                }


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