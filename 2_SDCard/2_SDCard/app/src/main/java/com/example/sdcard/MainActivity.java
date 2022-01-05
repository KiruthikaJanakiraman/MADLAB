package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText fname,cont,rfname;
    Button btn1,btn2;
    String fn,text_con;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont=findViewById(R.id.cont);
        fname=findViewById(R.id.fname);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        rfname=findViewById(R.id.rfname);
        tv=findViewById(R.id.tv);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn = fname.getText().toString();
                text_con = cont.getText().toString();
                try {
                    File f=new File("/sdcard/"+fn);
                    f.createNewFile();
                    FileOutputStream fos;
                    fos = new FileOutputStream(f);
                    OutputStreamWriter mout= new OutputStreamWriter(fos);
                    mout.append(text_con);
                    mout.close();
                    fos.close();
                    Toast.makeText(MainActivity.this, "Data written to SD Card",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File f=new File("/sdcard/"+rfname.getText().toString());
                try {
                    FileInputStream fin = new FileInputStream(f);
                    BufferedReader bf=new BufferedReader(new InputStreamReader(fin));
                    String drow="";
                    String dbuf="";
                    while((drow=bf.readLine())!=null)
                    {
                        dbuf+=drow+"\n";

                    }
                    tv.setText(dbuf);
                    bf.close();
                    fin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
