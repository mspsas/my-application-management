package com.example.management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class department extends AppCompatActivity {
    Button add;
    Button update;
    Button delete;
    TextView tName;
    TextView tID;
    TextView tLoc;
    selectsql emp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        initviews();
        emp1 = new selectsql(this);
        tName.setText("Accounts");
        tID.setText("121");
        tLoc.setText("Here");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
