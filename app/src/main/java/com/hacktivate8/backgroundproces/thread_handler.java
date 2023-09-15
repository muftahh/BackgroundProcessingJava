package com.hacktivate8.backgroundproces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class thread_handler extends AppCompatActivity {
    private Button start_b1;
    private TextView status_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler);

        start_b1 = findViewById(R.id.button_th);
        status_v = findViewById(R.id.status);

        start_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread();
            }
        });

    }

    private void startThread() {
        status_v.setText("Thread Start...");
        Log.i("Thread", "Thread Start");

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //process TH
                synchronized (this) {
                    try {
                        Log.i("Thread", "Thread Run");

                        for (int i = 5; i >= 0; i--){
                            wait(1000);
                            status_v.setText("Waiting " + i +" second...");
                        }
                    } catch (InterruptedException e){

                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        status_v.setText("Thread finish.");
                        Log.i("Thread", "Thread Finish");
                        Intent intent = new Intent(thread_handler.this, halaman_2.class);
                        startActivity(intent);
                    }
                });
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}