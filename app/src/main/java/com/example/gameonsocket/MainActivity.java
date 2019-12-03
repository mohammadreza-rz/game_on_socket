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
                netUtils.g1.setText(playerName.getText());
                dataFetcher.execute(a);
            }
        });

    }


    private void initViews() {
        sendBtn = findViewById(R.id.sendBtn);
        playerName = findViewById(R.id.playerName);
        netUtils.ll1 = findViewById(R.id.ll1);

        netUtils.g1 = findViewById(R.id.gamer1);
        netUtils.g2 = findViewById(R.id.gamer2);
        netUtils.g3 = findViewById(R.id.gamer3);
        netUtils.g4 = findViewById(R.id.gamer4);

        netUtils.po1 = findViewById(R.id.point1);
        netUtils.po2 = findViewById(R.id.point2);
        netUtils.po3 = findViewById(R.id.point3);
        netUtils.po4 = findViewById(R.id.point4);
    }


}

