package com.hacktivate8.backgroundproces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class asyn_task extends AppCompatActivity {
    private Button download;
    private ProgressBar progress;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task);

        download = findViewById(R.id.button_at);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start AS
                AsyncTaskDownload asyncTaskDownload = new AsyncTaskDownload();
                asyncTaskDownload.execute(10);
            }
        });
        progress = findViewById(R.id.progressBar);
        status = findViewById(R.id.statusAT);
    }

    private class AsyncTaskDownload extends AsyncTask<Integer, Integer, String> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute (String data){
            super.onPostExecute(data);
            progress.setVisibility(View.GONE);
            status.setVisibility(View.VISIBLE);
            status.setText("DONE");
        }
        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            progress.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress(i + 100 / integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
            return "Download Selesai";
        }

    }
}