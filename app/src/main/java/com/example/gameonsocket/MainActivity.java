package com.example.gameonsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button sendBtn;
    private EditText playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataFetcher dataFetcher;
                dataFetcher = new DataFetcher();
                String[] a = {"initSocket", playerName.getText().toString()};
                dataFetcher.execute(a);
            }
        });

    }


    private void initViews() {
        sendBtn = findViewById(R.id.sendBtn);
        playerName = findViewById(R.id.playerName);
    }


}

