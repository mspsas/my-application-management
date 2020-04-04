package com.example.management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class department extends AppCompatActivity {
    SQLiteDatabase sqlitedb;
    Button add;
    Button update;
    Button delete;
    TextView tName;
    TextView tID;
    TextView tLoc;
    String nam,id, loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        sqlitedb=openOrCreateDatabase("employee", Context.MODE_PRIVATE,null);
        //department details
        sqlitedb.execSQL("create table if not exists department_details(depname varchar(255),depID varchar(255) primary key, dlocation varchar(25)) ");

        initviews();
       // emp1 = new selectsql(this);
        //tName.setText("Accounts");
        //tID.setText("121");
        //tLoc.setText("Here");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btnx)
                {
                    nam=tName.getText().toString().trim();
                    id=tID.getText().toString().trim();
                    loc=tLoc.getText().toString().trim();
                    if(nam.equals("")||id.equals("")||loc.equals(""))
                    {
                        Toast.makeText(department.this,"Field cant be empty",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else
                    {
                        sqlitedb.execSQL("insert into department_details(depname,depID,dlocation) values('"+nam+"','"+id+"','"+loc+"')");
                        Toast.makeText(department.this,"Record saved", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btny){
                    nam=tName.getText().toString().trim();
                    id=tID.getText().toString().trim();
                    loc=tLoc.getText().toString().trim();
                    if(id.equals(""))
                    {
                        Toast.makeText(department.this,"Enter your department id",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cursorupdate=sqlitedb.rawQuery("select * from department_details where depID = '"+id+"'",null);
                    if(cursorupdate.moveToFirst()){
                        if(nam.equals("")||id.equals("")||loc.equals(""))
                        {
                            Toast.makeText(department.this,"Field cant be empty",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            sqlitedb.execSQL("update department_details set depname='"+nam+"',dlocation='"+loc+"' where depID='"+id+"'");
                            Toast.makeText(department.this,"record updated sucessfully!!",Toast.LENGTH_SHORT).show();
                            return;

                        }

                    }
                    else {
                        Toast.makeText(department.this,"DATA NOT FOUND",Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnz){
                    nam=tName.getText().toString().trim();
                    id=tID.getText().toString().trim();
                    loc=tLoc.getText().toString().trim();
                    if(id.equals(""))
                    {
                        Toast.makeText(department.this,"Enter your department id",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cursorupdate=sqlitedb.rawQuery("select * from department_details where depID = '"+id+"'",null);
                    if(cursorupdate.moveToFirst()){
                        sqlitedb.execSQL("delete from department_details where depID='"+id+"'");
                        Toast.makeText(department.this,"Record deleted !!",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }
    private void initviews(){
        add=(Button)findViewById(R.id.btnx);
        update=(Button)findViewById(R.id.btny);
        delete=(Button)findViewById(R.id.btnz);
        tName= findViewById(R.id.textView2);
        tID=findViewById(R.id.textView3);
        tLoc=findViewById(R.id.textView4);
    }
}
