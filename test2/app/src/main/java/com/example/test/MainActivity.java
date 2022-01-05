package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.displayArea);
    }
    public void func(View v){
        et.setText(et.getText().toString()+""+v.getTag().toString());
        et.setSelection(et.getText().toString().length());
    }

    public void eval(View v){
        try{
            DoubleEvaluator evaluator = new DoubleEvaluator();
            Double result = evaluator.evaluate(et.getText().toString());
            et.setText(result.toString());
            et.setSelection(et.getText().toString().length());
            return;

        }
        catch (Exception e){
            et.setText("Math error");
            System.err.println("ERROR: " + e.toString());
        }
    }

}