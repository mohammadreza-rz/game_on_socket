package com.example.gameonsocket;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private Button sendBtn;
    private TextView m01, m12, m23, m34, m45, m67, m78, m89, m910, m1011, m1213, m1314, m1415, m1516, m1617, m1819, m1920, m2021, m2122, m2223, m2425, m2526, m2627, m2728, m2829, m3031, m3132, m3233, m3334, m3435, m3637, m3738, m3839, m3940, m4041, m4243, m4344, m4445, m4546, m4647;
    private TextView n06, n17, n28, n39, n410, n511, n612, n713, n814, n915, n1016, n1117, n1218;
    private String nobatName;
    private DataFetcher dataFetcher, dataFetcher2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        final String[] a = {"initSocket"};



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataFetcher = new DataFetcher();
                dataFetcher2 = new DataFetcher();
                dataFetcher.execute(a);
            }
        });

        m01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                String[] sa = {"sendUserAction","0,1"};
                dataFetcher2.execute(sa);
            }
        });
        m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());
                String[] sa = {"sendUserAction","1, 2"};
                dataFetcher2.execute(sa);
            }
        });
        m23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });

        m67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m910.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m1011.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });

        n06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n410.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n511.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());
            }
        });

        n612.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n713.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n814.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n915.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n1016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        n1117.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m1213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m1314.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());
            }
        });
        m1415.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m1516.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });
        m1617.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.color.red);
                Log.d("bbma", "onClick: " + v.getId());

            }
        });



    }



    private void initViews() {
        sendBtn = findViewById(R.id.sendBtn);

        m01 = findViewById(R.id.l01);
        m12 = findViewById(R.id.l12);
        m23 = findViewById(R.id.l23);
        m34 = findViewById(R.id.l34);
        m45 = findViewById(R.id.l45);

        m67 = findViewById(R.id.l67);
        m78 = findViewById(R.id.l78);
        m89 = findViewById(R.id.l89);
        m910 = findViewById(R.id.l910);
        m1011 = findViewById(R.id.l1011);

        m1213 = findViewById(R.id.l1213);
        m1314 = findViewById(R.id.l1314);
        m1415 = findViewById(R.id.l1415);
        m1516 = findViewById(R.id.l1516);
        m1617 = findViewById(R.id.l1617);

        n06 = findViewById(R.id.l06);
        n17 = findViewById(R.id.l17);
        n28 = findViewById(R.id.l28);
        n39 = findViewById(R.id.l39);
        n410 = findViewById(R.id.l410);
        n511 = findViewById(R.id.l511);
        n612 = findViewById(R.id.l612);
        n713 = findViewById(R.id.l713);
        n814 = findViewById(R.id.l814);
        n915 = findViewById(R.id.l915);
        n1016 = findViewById(R.id.l1016);
        n1117 = findViewById(R.id.l1117);

        m1819 = findViewById(R.id.l1819);
        m1920 = findViewById(R.id.l1920);
        m2021 = findViewById(R.id.l2021);
        m2122 = findViewById(R.id.l2122);
        m2223 = findViewById(R.id.l2223);

        m2425 = findViewById(R.id.l2425);
        m2526 = findViewById(R.id.l2526);
        m2627 = findViewById(R.id.l2627);
        m2728 = findViewById(R.id.l2728);
        m2829 = findViewById(R.id.l2829);

        m3031 = findViewById(R.id.l3031);
        m3132 = findViewById(R.id.l3132);
        m3233 = findViewById(R.id.l3233);
        m3334 = findViewById(R.id.l3334);
        m3435 = findViewById(R.id.l3435);

        m3637 = findViewById(R.id.l3637);
        m3738 = findViewById(R.id.l3738);
        m3839 = findViewById(R.id.l3839);
        m3940 = findViewById(R.id.l3940);
        m4041 = findViewById(R.id.l4041);

        m4243 = findViewById(R.id.l4243);
        m4344 = findViewById(R.id.l4344);
        m4445 = findViewById(R.id.l4445);
        m4546 = findViewById(R.id.l4546);
        m4647 = findViewById(R.id.l4647);
    }


}

