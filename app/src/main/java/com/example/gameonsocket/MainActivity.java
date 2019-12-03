package com.example.gameonsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button sendBtn;
    private EditText playerName;
    private TextView g1,g2,g3,g4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        netUtils.ctx = this;
        initViews();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataFetcher dataFetcher;
                dataFetcher = new DataFetcher();
                String[] a = {"initSocket", playerName.getText().toString()};
                g1.setText(playerName.getText());
                dataFetcher.execute(a);
            }
        });

    }


    private void initViews() {
        sendBtn = findViewById(R.id.sendBtn);
        playerName = findViewById(R.id.playerName);

        g1 = findViewById(R.id.gamer1);
        g2 = findViewById(R.id.gamer2);
        g3 = findViewById(R.id.gamer3);
        g4 = findViewById(R.id.gamer4);
    }


}

