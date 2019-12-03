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
    private myLineView m01, m12, m23, m34, m45, m67, m78, m89, m910, m1011, m1213, m1314, m1415, m1516, m1617, m1819, m1920, m2021, m2122, m2223, m2425, m2526, m2627, m2728, m2829, m3031, m3132, m3233, m3334, m3435, m3637, m3738, m3839, m3940, m4041, m4243, m4344, m4445, m4546, m4647;
    private myLineView n06, n17, n28, n39, n410, n511, n612, n713, n814, n915, n1016, n1117, n1218, n1319, n1420, n1521, n1622, n1723, n1824, n1925, n2026, n2127, n2228, n2329, n2430, n2531, n2632, n2733, n2834, n2935, n3036, n3137, n3238, n3339, n3440, n3541, n3642, n3743, n3844, n3945, n4046, n4147;

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
        n1218 = findViewById(R.id.l1218);
        n1319 = findViewById(R.id.l1319);
        n1420 = findViewById(R.id.l1420);
        n1521 = findViewById(R.id.l1521);
        n1622 = findViewById(R.id.l1622);
        n1723 = findViewById(R.id.l1723);
        n1824 = findViewById(R.id.l1824);
        n1925 = findViewById(R.id.l1925);
        n2026 = findViewById(R.id.l2026);
        n2127 = findViewById(R.id.l2127);
        n2228 = findViewById(R.id.l2228);
        n2329 = findViewById(R.id.l2329);
        n2430 = findViewById(R.id.l2430);
        n2531 = findViewById(R.id.l2531);
        n2632 = findViewById(R.id.l2632);
        n2733 = findViewById(R.id.l2733);
        n2834 = findViewById(R.id.l2834);
        n2935 = findViewById(R.id.l2935);
        n3036 = findViewById(R.id.l3036);
        n3137 = findViewById(R.id.l3137);
        n3238 = findViewById(R.id.l3238);
        n3339 = findViewById(R.id.l3339);
        n3440 = findViewById(R.id.l3440);
        n3541 = findViewById(R.id.l3541);
        n3642 = findViewById(R.id.l3642);
        n3743 = findViewById(R.id.l3743);
        n3844 = findViewById(R.id.l3844);
        n3945 = findViewById(R.id.l3945);
        n4046 = findViewById(R.id.l4046);
        n4147 = findViewById(R.id.l4147);


        m01.setTag("0,1");
        m12.setTag("1,2");
        m23.setTag("2,3");
        m34.setTag("3,4");
        m45.setTag("4,5");
        m67.setTag("6,7");
        m78.setTag("7,8");
        m89.setTag("8,9");
        n06.setTag("0,6");
        n17.setTag("1,7");
        n28.setTag("2,8");
        n39.setTag("3,9");
        m910.setTag("9,10");
        n410.setTag("4,10");
        n511.setTag("5,11");
        n612.setTag("6,12");
        n713.setTag("7,13");
        n814.setTag("8,14");
        n915.setTag("9,15");
        m1011.setTag("10,11");
        m1213.setTag("12,13");
        m1314.setTag("13,14");
        m1415.setTag("14,15");
        m1516.setTag("15,16");
        m1617.setTag("16,17");
        n1016.setTag("10,16");
        n1117.setTag("11,17");
        m1819.setTag("18,19");
        m1920.setTag("19,20");
        m2021.setTag("20,21");
        m2122.setTag("21,22");
        m2223.setTag("22,23");
        m2425.setTag("24,25");
        m2526.setTag("25,26");
        m2627.setTag("26,27");
        m2728.setTag("27,28");
        m2829.setTag("28,29");
        m3031.setTag("30,31");
        m3132.setTag("31,32");
        m3233.setTag("32,33");
        m3334.setTag("33,34");
        m3435.setTag("34,35");
        m3637.setTag("36,37");
        m3738.setTag("37,38");
        m3839.setTag("38,39");
        m3940.setTag("39,40");
        m4041.setTag("40,41");
        m4243.setTag("42,43");
        m4344.setTag("43,44");
        m4445.setTag("44,45");
        m4546.setTag("45,46");
        m4647.setTag("46,47");
        n1218.setTag("12,18");
        n1319.setTag("13,19");
        n1420.setTag("14,20");
        n1521.setTag("15,21");
        n1622.setTag("16,22");
        n1723.setTag("17,23");
        n1824.setTag("18,24");
        n1925.setTag("19,25");
        n2026.setTag("20,26");
        n2127.setTag("21,27");
        n2228.setTag("22,28");
        n2329.setTag("23,29");
        n2430.setTag("24,30");
        n2531.setTag("25,31");
        n2632.setTag("26,32");
        n2733.setTag("27,33");
        n2834.setTag("28,34");
        n2935.setTag("29,35");
        n3036.setTag("30,36");
        n3137.setTag("31,37");
        n3238.setTag("32,38");
        n3339.setTag("33,39");
        n3440.setTag("34,40");
        n3541.setTag("35,41");
        n3642.setTag("36,42");
        n3743.setTag("37,43");
        n3844.setTag("38,44");
        n3945.setTag("39,45");
        n4046.setTag("40,46");
        n4147.setTag("41,47");
    }


}

