package com.example.a5_database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, contact, dob, email;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        email = findViewById(R.id.email);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT, contactTXT, dobTXT, emailTXT;
                nameTXT = name.getText().toString();
                contactTXT = contact.getText().toString();
                dobTXT = dob.getText().toString();
                emailTXT = email.getText().toString();
                boolean checkInsert = DB.insertData(nameTXT, contactTXT, dobTXT, emailTXT);
                if(checkInsert == true)
                    Toast.makeText(MainActivity.this, "Inserted successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Insertion failed", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT, contactTXT, dobTXT, emailTXT;
                nameTXT = name.getText().toString();
                contactTXT = contact.getText().toString();
                dobTXT = dob.getText().toString();
                emailTXT = email.getText().toString();
                boolean checkUpdate = DB.updateData(nameTXT, contactTXT, dobTXT, emailTXT);
                if(checkUpdate == true)
                    Toast.makeText(MainActivity.this, "Updated successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Updation failed", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT, contactTXT, dobTXT, emailTXT;
                nameTXT = name.getText().toString();
                boolean checkDelete = DB.deleteData(nameTXT);
                if(checkDelete == true)
                    Toast.makeText(MainActivity.this, "Deleted successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Deletion failed", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getData();
                if(res.getCount() == 0)
                    Toast.makeText(MainActivity.this, "No entries too view",Toast.LENGTH_SHORT).show();
                else
                {
                    StringBuffer buff = new StringBuffer();
                    while(res.moveToNext()) {
                        buff.append("Name: "+res.getString(0)+"\n");
                        buff.append("Contact: "+res.getString(1)+"\n");
                        buff.append("DOB: "+res.getString(2)+"\n");
                        buff.append("Email: "+res.getString(3)+"\n");
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Entries");
                    builder.setMessage(buff.toString());
                    builder.show();
                }
            }
        });
    }
}