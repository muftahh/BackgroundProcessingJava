package com.hacktivate8.backgroundproces;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;

public class background_service extends IntentService {
    public background_service () {
        super("HACKTIVATE SERVICE");
    }

    @Override
    protected void onHandleIntent(@NonNull Intent intent) {
        //program backgorund
        int counter = 0;
        int max = 100;
        while (counter < max) {

            Log.i("Thread ke-" + counter, Thread.currentThread().getName());
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            counter++;
        }

    }
}
