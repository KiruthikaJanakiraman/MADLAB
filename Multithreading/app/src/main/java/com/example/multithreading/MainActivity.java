package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb;
    private TextView tv;
    private Button btn;
    Handler h;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar)findViewById(R.id.pb);
        tv = findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        check();
                    }
                });
                t.start();
            }
        });
    }
    public void check()
    {
        pb.setProgressTintList(ColorStateList.valueOf(Color.GRAY));
        for(int c=0;c<101;c++)
        {
            pb.setProgress(c);
            if(c==24)
            {
                pb.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            }
            if(c==49)
            {
                pb.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }
            if(c==74)
            {
                pb.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
            }
            int finalC = c;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv.setText(String.valueOf(finalC)+"%");
                }
            });
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}