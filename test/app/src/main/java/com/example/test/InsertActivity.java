package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    Button insert;
    EditText id, name, salary;
    RadioGroup gender;
    RadioButton sel;
    Spinner dept;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);
        insert = findViewById(R.id.insert);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        gender = findViewById(R.id.rg);
        dept = findViewById(R.id.spinner);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel = findViewById(gender.getCheckedRadioButtonId());
                db.execSQL("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?)", new String[]{name.getText().toString(), sel.getText().toString(), id.getText().toString(), dept.getSelectedItem().toString(), salary.getText().toString()});
                Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}