package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText ed1,ed2,ed3;
   Button btn;
String name,username,password;
database g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editTextTextPersonName3);
        ed2=(EditText) findViewById(R.id.editTextTextPersonName);
        ed3=(EditText) findViewById(R.id.editTextTextPersonName2);
        btn=(Button)findViewById(R.id.button);
        g=new database(this);
       // g.getReadableDatabase();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ed1.getText().toString();
                String username =ed2.getText().toString();
                String password=ed3.getText().toString();
               if(name.equals("")||username.equals("")||password.equals("")){
                   Toast.makeText(MainActivity.this,"enter all fields",Toast.LENGTH_SHORT).show();
               }    else {
                        Boolean B =g.insert_data(name,username,password);
                        if(B==true){
                            Toast.makeText(MainActivity.this,"successful",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this," not successful",Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });


       }



    }
