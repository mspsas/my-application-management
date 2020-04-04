package com.example.management;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class empdetail extends AppCompatActivity {
    SQLiteDatabase sqlitedb;
    Button ad;
    Button updat;
    Button delet;
    Button getdetail;
    TextView edepa;
    TextView eid;
    TextView enam;
    TextView esex;
    TextView eage;
    String depa,nam,id,age,sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empdetail);
        sqlitedb=openOrCreateDatabase("employee", Context.MODE_PRIVATE,null);
        //department details
        sqlitedb.execSQL("create table if not exists employee_details(dep_name varchar(255),ename varchar(255), empID varchar(25) primary key,sex varchar(25),eage varchar(25)) ");
        initviews();
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btnad)
                {
                    depa=edepa.getText().toString().trim();
                    nam=enam.getText().toString().trim();
                    id=eid.getText().toString().trim();
                    sex=esex.getText().toString().trim();
                    age=eage.getText().toString().trim();
                    if(depa.equals("")||nam.equals("")||id.equals("")||sex.equals("")||age.equals(""))
                    {
                        Toast.makeText(empdetail.this,"Field cant be empty",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else
                    {
                        sqlitedb.execSQL("insert into employee_details(dep_name,ename,empID,sex,eage) values('"+depa+"','"+nam+"','"+id+"','"+sex+"','"+age+"')");
                        Toast.makeText(empdetail.this,"Record saved", Toast.LENGTH_SHORT).show();

                    }

                }
                else {
                    Toast.makeText(empdetail.this,"DATA NOT FOUND",Toast.LENGTH_SHORT).show();
                }
            }
        });
        updat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnup){
                    depa=edepa.getText().toString().trim();
                    nam=enam.getText().toString().trim();
                    id=eid.getText().toString().trim();
                    sex=esex.getText().toString().trim();
                    age=eage.getText().toString().trim();

                    if(id.equals(""))
                    {
                        Toast.makeText(empdetail.this,"Enter your project id",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cursorupdate=sqlitedb.rawQuery("select * from employee_details where empID = '"+id+"'",null);
                    if(cursorupdate.moveToFirst()){
                        if(depa.equals("")||nam.equals("")||id.equals("")||sex.equals("")||age.equals(""))
                        {
                            Toast.makeText(empdetail.this,"Field cant be empty",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            sqlitedb.execSQL("update employee_details set dep_name='"+depa+"',ename='"+nam+"',sex='"+sex+"',eage='"+age+"' where empID='"+id+"'");
                            Toast.makeText(empdetail.this,"record updated sucessfully!!",Toast.LENGTH_SHORT).show();
                            return;

                        }

                    }
                    else {
                        Toast.makeText(empdetail.this,"DATA NOT FOUND",Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btndel){
                    depa=edepa.getText().toString().trim();
                    nam=enam.getText().toString().trim();
                    id=eid.getText().toString().trim();
                    sex=esex.getText().toString().trim();
                    age=eage.getText().toString().trim();


                    if(id.equals(""))
                    {
                        Toast.makeText(empdetail.this,"Enter your employee id",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cursorupdate=sqlitedb.rawQuery("select * from employee_details where empID = '"+id+"'",null);
                    if(cursorupdate.moveToFirst()){
                        sqlitedb.execSQL("delete from employee_details where empID='"+id+"'");
                        Toast.makeText(empdetail.this,"Record deleted !!",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(empdetail.this,"DATA NOT FOUND",Toast.LENGTH_SHORT).show();
                }

            }
        });
        getdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btngd) {
                    depa = edepa.getText().toString().trim();
                    nam = enam.getText().toString().trim();
                    id = eid.getText().toString().trim();
                    sex = esex.getText().toString().trim();
                    age = eage.getText().toString().trim();
                    if(enam.getText().toString().trim().length()==0)
                    {
                        Toast.makeText(empdetail.this,"enter your name pls",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Cursor cu=sqlitedb.rawQuery("select * from employee_details where ename = '"+nam+"'",null);
                    if(cu.moveToFirst()){
                        edepa.setText(cu.getString(5));
                        enam.setText(cu.getString(1));
                        eid.setText(cu.getString(2));
                        eage.setText(cu.getString(3));
                        esex.setText(cu.getString(4));
                    }

                }
                else {
                    Toast.makeText(empdetail.this,"DATA NOT FOUND",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void initviews(){
        ad=(Button)findViewById(R.id.btnad);
        updat=(Button)findViewById(R.id.btnup);
        delet=(Button)findViewById(R.id.btndel);
        getdetail=(Button)findViewById(R.id.btngd);
        edepa=findViewById(R.id.depname);
        enam=findViewById(R.id.epname);
        esex=findViewById(R.id.sex);
        eage=findViewById(R.id.age);
        eid=findViewById(R.id.id);


    }
}
