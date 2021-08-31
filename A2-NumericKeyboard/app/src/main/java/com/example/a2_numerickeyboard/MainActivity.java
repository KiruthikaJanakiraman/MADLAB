package com.example.a2_numerickeyboard;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void typeNum(View view) {
        String txt = ((Button)view).getText().toString();
        TextView display = (TextView)findViewById(R.id.editText);
        display.setText(display.getText().toString()+txt);
    }

    public void deleteNum(View view) {
        TextView display = (TextView)findViewById(R.id.editText);
        String txt = display.getText().toString();
        int len = txt.length();
        display.setText(txt.substring(0, len-1));
    }

}