package com.hacktivate8.backgroundproces;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intent_service extends AppCompatActivity {

    private Button start_b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        start_b2 = findViewById(R.id.button_is);
        start_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(intent_service.this, background_service.class);
                startService(intent);
            }
        });
    }

}