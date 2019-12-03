package com.example.gameonsocket;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import com.example.gameonsocket.databinding.ActivityMainBinding;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class DataFetcher extends AsyncTask<String, Void, String> {

    private static final String TAG = "fetcherLogs";
    private boolean myTurn;
    private myLineView m01, m12, m23, m34, m45, m67, m78, m89, m910, m1011, m1213, m1314, m1415, m1516, m1617, m1819, m1920, m2021, m2122, m2223, m2425, m2526, m2627, m2728, m2829, m3031, m3132, m3233, m3334, m3435, m3637, m3738, m3839, m3940, m4041, m4243, m4344, m4445, m4546, m4647;
    private myLineView n06, n17, n28, n39, n410, n511, n612, n713, n814, n915, n1016, n1117, n1218, n1319, n1420, n1521, n1622, n1723, n1824, n1925, n2026, n2127, n2228, n2329, n2430, n2531, n2632, n2733, n2834, n2935, n3036, n3137, n3238, n3339, n3440, n3541, n3642, n3743, n3844, n3845, n4046, n4147;


    @Override
    protected String doInBackground(String... job) {
        Log.d(TAG, "*********** one background task created ***********");
        findRequiredViews();
        switch (job[0]) {
            case "initSocket":
                initSocket(job[1]);
                break;
            case "sendUserAction":
                sendUserAction(job[1]);
                break;
        }
        return null;
    }


    private void sendUserAction(String action) {
        OutputStream os = null;
        try {
            os = netUtils.s.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter p = new PrintWriter(os);
        p.println(action);
        p.flush();
        Log.d(TAG, "----------- this sentence -> " + action + " sent to server -----------");
    }

    private void initSocket(String name) {
        try {
            netUtils.s = new Socket(InetAddress.getByName("172.16.35.183"), 2000);
            DataInputStream is = new DataInputStream(netUtils.s.getInputStream());
            int nobat = Integer.parseInt(is.readLine());
            switch (nobat) {
                case 1:
                    netUtils.userColor = R.color.red;
                    break;
                case 2:
                    netUtils.userColor = R.color.green;
                    break;
                case 3:
                    netUtils.userColor = R.color.yellow;
                    break;
                case 4:
                    netUtils.userColor = R.color.black;
                    break;
            }

            while (true) {
                Log.d(TAG, "........... LISTENING TO READ ...........");
                String readLine = is.readLine();
                Log.d(TAG, "+++++++++++ read line -> " + readLine + " +++++++++++");
                if (readLine.equals("your name ?")) {
                    sendUserAction(name);
                } else {
                    if (readLine.equals("your turn")) {
                        netUtils.waitingToSend = true;
                        while (netUtils.waitingToSend) {
                        }
                        sendUserAction(netUtils.userMove);
                    } else {
                        int userNum = Integer.parseInt(readLine.substring(0, 0));
                        switch (userNum) {
                            case 0:
                                setNewMoveToBoard(readLine.substring(2, 4), userNum, R.color.red);
                                break;
                            case 1:
                                setNewMoveToBoard(readLine.substring(2, 4), userNum, R.color.green);
                                break;
                            case 2:
                                setNewMoveToBoard(readLine.substring(2, 4), userNum, R.color.yellow);
                                break;
                            case 3:
                                setNewMoveToBoard(readLine.substring(2, 4), userNum, R.color.black);
                                break;
                        }

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNewMoveToBoard(String move, int userNum, int color) {
        ActivityMainBinding binding = DataBindingUtil.setContentView(netUtils.ctx, R.layout.activity_main);
        switch (move) {
            case "0,1":
                binding.l01.setBackgroundResource(color);
                binding.l01.setClickable(false);
                break;
            case "1,2":
                binding.l12.setBackgroundResource(color);
                binding.l12.setClickable(false);
                break;
            case "2,3":
                binding.l23.setBackgroundResource(color);
                binding.l23.setClickable(false);
                break;
            case "3,4":
                binding.l34.setBackgroundResource(color);
                binding.l34.setClickable(false);
                break;
            case "4,5":
                binding.l45.setBackgroundResource(color);
                binding.l45.setClickable(false);
                break;
            case "6,7":
                binding.l67.setBackgroundResource(color);
                binding.l67.setClickable(false);
                break;
            case "7,8":
                binding.l78.setBackgroundResource(color);
                binding.l78.setClickable(false);
                break;
            case "8,9":
                binding.l89.setBackgroundResource(color);
                binding.l89.setClickable(false);
                break;
            case "0,6":
                binding.l06.setBackgroundResource(color);
                binding.l06.setClickable(false);
                break;
            case "1,7":
                binding.l17.setBackgroundResource(color);
                binding.l17.setClickable(false);
                break;
            case "2,8":
                binding.l28.setBackgroundResource(color);
                binding.l28.setClickable(false);
                break;
            case "3,9":
                binding.l39.setBackgroundResource(color);
                binding.l39.setClickable(false);
                break;
            case "9,10":
                binding.l910.setBackgroundResource(color);
                binding.l910.setClickable(false);
                break;
            case "4,10":
                binding.l410.setBackgroundResource(color);
                binding.l410.setClickable(false);
                break;
            case "5,11":
                binding.l511.setBackgroundResource(color);
                binding.l511.setClickable(false);
                break;
            case "6,12":
                binding.l612.setBackgroundResource(color);
                binding.l612.setClickable(false);
                break;
            case "7,13":
                binding.l713.setBackgroundResource(color);
                binding.l713.setClickable(false);
                break;
            case "8,14":
                binding.l814.setBackgroundResource(color);
                binding.l814.setClickable(false);
                break;
            case "9,15":
                binding.l915.setBackgroundResource(color);
                binding.l915.setClickable(false);
                break;
            case "10,11":
                binding.l1011.setBackgroundResource(color);
                binding.l1011.setClickable(false);
                break;
            case "13,14":
                binding.l1314.setBackgroundResource(color);
                binding.l1314.setClickable(false);
                break;
            case "12,13":
                binding.l1213.setBackgroundResource(color);
                binding.l1213.setClickable(false);
                break;
            case "14,15":
                binding.l1415.setBackgroundResource(color);
                binding.l1415.setClickable(false);
                break;
            case "15,16":
                binding.l1516.setBackgroundResource(color);
                binding.l1516.setClickable(false);
                break;
            case "16,17":
                binding.l1617.setBackgroundResource(color);
                binding.l1617.setClickable(false);
                break;
            case "10,16":
                binding.l1016.setBackgroundResource(color);
                binding.l1016.setClickable(false);
                break;
            case "11,17":
                binding.l1117.setBackgroundResource(color);
                binding.l1117.setClickable(false);
                break;
            case "18,19":
                binding.l1819.setBackgroundResource(color);
                binding.l1819.setClickable(false);
                break;
            case "19,20":
                binding.l1920.setBackgroundResource(color);
                binding.l1920.setClickable(false);
                break;
            case "20,21":
                binding.l2021.setBackgroundResource(color);
                binding.l2021.setClickable(false);
                break;
            case "21,22":
                binding.l2122.setBackgroundResource(color);
                binding.l2122.setClickable(false);
                break;
            case "22,23":
                binding.l2223.setBackgroundResource(color);
                binding.l2223.setClickable(false);
                break;
            case "24,25":
                binding.l2425.setBackgroundResource(color);
                binding.l2425.setClickable(false);
                break;
            case "25,26":
                binding.l2526.setBackgroundResource(color);
                binding.l2526.setClickable(false);
                break;
            case "26,27":
                binding.l2627.setBackgroundResource(color);
                binding.l2627.setClickable(false);
                break;
            case "27,28":
                binding.l2728.setBackgroundResource(color);
                binding.l2728.setClickable(false);
                break;
            case "28,29":
                binding.l2829.setBackgroundResource(color);
                binding.l2829.setClickable(false);
                break;
            case "30,31":
                binding.l3031.setBackgroundResource(color);
                binding.l3031.setClickable(false);
                break;
            case "31,32":
                binding.l3132.setBackgroundResource(color);
                binding.l3132.setClickable(false);
                break;
            case "32,33":
                binding.l3233.setBackgroundResource(color);
                binding.l3233.setClickable(false);
                break;
            case "33,34":
                binding.l3334.setBackgroundResource(color);
                binding.l3334.setClickable(false);
                break;
            case "34,35":
                binding.l3435.setBackgroundResource(color);
                binding.l3435.setClickable(false);
                break;
            case "36,37":
                binding.l3637.setBackgroundResource(color);
                binding.l3637.setClickable(false);
                break;
            case "37,38":
                binding.l3738.setBackgroundResource(color);
                binding.l3738.setClickable(false);
                break;
            case "38,39":
                binding.l3839.setBackgroundResource(color);
                binding.l3839.setClickable(false);
                break;
            case "39,40":
                binding.l3940.setBackgroundResource(color);
                binding.l3940.setClickable(false);
                break;
            case "40,41":
                binding.l4041.setBackgroundResource(color);
                binding.l4041.setClickable(false);
                break;
            case "42,43":
                binding.l4243.setBackgroundResource(color);
                binding.l4243.setClickable(false);
                break;
            case "43,44":
                binding.l4344.setBackgroundResource(color);
                binding.l4344.setClickable(false);
                break;
            case "44,45":
                binding.l4445.setBackgroundResource(color);
                binding.l4445.setClickable(false);
                break;
            case "45,46":
                binding.l4546.setBackgroundResource(color);
                binding.l4546.setClickable(false);
                break;
            case "46,47":
                binding.l4647.setBackgroundResource(color);
                binding.l4647.setClickable(false);
                break;
            case "12,18":
                binding.l1218.setBackgroundResource(color);
                binding.l1218.setClickable(false);
                break;
            case "13,19":
                binding.l1319.setBackgroundResource(color);
                binding.l1319.setClickable(false);
                break;
            case "14,20":
                binding.l1420.setBackgroundResource(color);
                binding.l1420.setClickable(false);
                break;
            case "15,21":
                binding.l1521.setBackgroundResource(color);
                binding.l1521.setClickable(false);
                break;
            case "16,22":
                binding.l1622.setBackgroundResource(color);
                binding.l1622.setClickable(false);
                break;
            case "17,23":
                binding.l1723.setBackgroundResource(color);
                binding.l1723.setClickable(false);
                break;
            case "18,24":
                binding.l1824.setBackgroundResource(color);
                binding.l1824.setClickable(false);
                break;
            case "19,25":
                binding.l1925.setBackgroundResource(color);
                binding.l1925.setClickable(false);
                break;
            case "20,26":
                binding.l2026.setBackgroundResource(color);
                binding.l2026.setClickable(false);
                break;
            case "21,27":
                binding.l2127.setBackgroundResource(color);
                binding.l2127.setClickable(false);
                break;
            case "22,28":
                binding.l2228.setBackgroundResource(color);
                binding.l2228.setClickable(false);
                break;
            case "23,29":
                binding.l2329.setBackgroundResource(color);
                binding.l2329.setClickable(false);
                break;
            case "24,30":
                binding.l2430.setBackgroundResource(color);
                binding.l2430.setClickable(false);
                break;
            case "25,31":
                binding.l2531.setBackgroundResource(color);
                binding.l2531.setClickable(false);
                break;
            case "26,32":
                binding.l2632.setBackgroundResource(color);
                binding.l2632.setClickable(false);
                break;
            case "27,33":
                binding.l2733.setBackgroundResource(color);
                binding.l2733.setClickable(false);
                break;
            case "28,34":
                binding.l2834.setBackgroundResource(color);
                binding.l2834.setClickable(false);
                break;
            case "29,35":
                binding.l2935.setBackgroundResource(color);
                binding.l2935.setClickable(false);
                break;
            case "30,36":
                binding.l3036.setBackgroundResource(color);
                binding.l3036.setClickable(false);
                break;
            case "31,37":
                binding.l3137.setBackgroundResource(color);
                binding.l3137.setClickable(false);
                break;
            case "32,38":
                binding.l3238.setBackgroundResource(color);
                binding.l3238.setClickable(false);
                break;
            case "33,39":
                binding.l3339.setBackgroundResource(color);
                binding.l3339.setClickable(false);
                break;
            case "34,40":
                binding.l3440.setBackgroundResource(color);
                binding.l3440.setClickable(false);
                break;
            case "35,41":
                binding.l3541.setBackgroundResource(color);
                binding.l3541.setClickable(false);
                break;
            case "36,42":
                binding.l3642.setBackgroundResource(color);
                binding.l3642.setClickable(false);
                break;
            case "37,43":
                binding.l3743.setBackgroundResource(color);
                binding.l3743.setClickable(false);
                break;
            case "38,44":
                binding.l3844.setBackgroundResource(color);
                binding.l3844.setClickable(false);
                break;
            case "39,45":
                binding.l3945.setBackgroundResource(color);
                binding.l3945.setClickable(false);
                break;
            case "40,46":
                binding.l4046.setBackgroundResource(color);
                binding.l4046.setClickable(false);
                break;
            case "41,47":
                binding.l4147.setBackgroundResource(color);
                binding.l4147.setClickable(false);
                break;
        }
    }


    private void findRequiredViews() {
        m01 = netUtils.ctx.findViewById(R.id.l01);
        m12 = netUtils.ctx.findViewById(R.id.l12);
        m23 = netUtils.ctx.findViewById(R.id.l23);
        m34 = netUtils.ctx.findViewById(R.id.l34);
        m45 = netUtils.ctx.findViewById(R.id.l45);
        m67 = netUtils.ctx.findViewById(R.id.l67);
        m78 = netUtils.ctx.findViewById(R.id.l78);
        m89 = netUtils.ctx.findViewById(R.id.l89);
        m910 = netUtils.ctx.findViewById(R.id.l910);
        m1011 = netUtils.ctx.findViewById(R.id.l1011);
        m1213 = netUtils.ctx.findViewById(R.id.l1213);
        m1314 = netUtils.ctx.findViewById(R.id.l1314);
        m1415 = netUtils.ctx.findViewById(R.id.l1415);
        m1516 = netUtils.ctx.findViewById(R.id.l1516);
        m1617 = netUtils.ctx.findViewById(R.id.l1617);
        n06 = netUtils.ctx.findViewById(R.id.l06);
        n17 = netUtils.ctx.findViewById(R.id.l17);
        n28 = netUtils.ctx.findViewById(R.id.l28);
        n39 = netUtils.ctx.findViewById(R.id.l39);
        n410 = netUtils.ctx.findViewById(R.id.l410);
        n511 = netUtils.ctx.findViewById(R.id.l511);
        n612 = netUtils.ctx.findViewById(R.id.l612);
        n713 = netUtils.ctx.findViewById(R.id.l713);
        n814 = netUtils.ctx.findViewById(R.id.l814);
        n915 = netUtils.ctx.findViewById(R.id.l915);
        n1016 = netUtils.ctx.findViewById(R.id.l1016);
        n1117 = netUtils.ctx.findViewById(R.id.l1117);
        m1819 = netUtils.ctx.findViewById(R.id.l1819);
        m1920 = netUtils.ctx.findViewById(R.id.l1920);
        m2021 = netUtils.ctx.findViewById(R.id.l2021);
        m2122 = netUtils.ctx.findViewById(R.id.l2122);
        m2223 = netUtils.ctx.findViewById(R.id.l2223);
        m2425 = netUtils.ctx.findViewById(R.id.l2425);
        m2526 = netUtils.ctx.findViewById(R.id.l2526);
        m2627 = netUtils.ctx.findViewById(R.id.l2627);
        m2728 = netUtils.ctx.findViewById(R.id.l2728);
        m2829 = netUtils.ctx.findViewById(R.id.l2829);
        m3031 = netUtils.ctx.findViewById(R.id.l3031);
        m3132 = netUtils.ctx.findViewById(R.id.l3132);
        m3233 = netUtils.ctx.findViewById(R.id.l3233);
        m3334 = netUtils.ctx.findViewById(R.id.l3334);
        m3435 = netUtils.ctx.findViewById(R.id.l3435);
        m3637 = netUtils.ctx.findViewById(R.id.l3637);
        m3738 = netUtils.ctx.findViewById(R.id.l3738);
        m3839 = netUtils.ctx.findViewById(R.id.l3839);
        m3940 = netUtils.ctx.findViewById(R.id.l3940);
        m4041 = netUtils.ctx.findViewById(R.id.l4041);
        m4243 = netUtils.ctx.findViewById(R.id.l4243);
        m4344 = netUtils.ctx.findViewById(R.id.l4344);
        m4445 = netUtils.ctx.findViewById(R.id.l4445);
        m4546 = netUtils.ctx.findViewById(R.id.l4546);
        m4647 = netUtils.ctx.findViewById(R.id.l4647);
        n1218 = netUtils.ctx.findViewById(R.id.l1218);
        n1319 = netUtils.ctx.findViewById(R.id.l1319);
        n1420 = netUtils.ctx.findViewById(R.id.l1420);
        n1521 = netUtils.ctx.findViewById(R.id.l1521);
        n1622 = netUtils.ctx.findViewById(R.id.l1622);
        n1723 = netUtils.ctx.findViewById(R.id.l1723);
        n1824 = netUtils.ctx.findViewById(R.id.l1824);
        n1925 = netUtils.ctx.findViewById(R.id.l1925);
        n2026 = netUtils.ctx.findViewById(R.id.l2026);
        n2127 = netUtils.ctx.findViewById(R.id.l2127);
        n2228 = netUtils.ctx.findViewById(R.id.l2228);
        n2329 = netUtils.ctx.findViewById(R.id.l2329);
        n2430 = netUtils.ctx.findViewById(R.id.l2430);
        n2531 = netUtils.ctx.findViewById(R.id.l2531);
        n2632 = netUtils.ctx.findViewById(R.id.l2632);
        n2733 = netUtils.ctx.findViewById(R.id.l2733);
        n2834 = netUtils.ctx.findViewById(R.id.l2834);
        n2935 = netUtils.ctx.findViewById(R.id.l2935);
        n3036 = netUtils.ctx.findViewById(R.id.l3036);
        n3137 = netUtils.ctx.findViewById(R.id.l3137);
        n3238 = netUtils.ctx.findViewById(R.id.l3238);
        n3339 = netUtils.ctx.findViewById(R.id.l3339);
        n3440 = netUtils.ctx.findViewById(R.id.l3440);
        n3541 = netUtils.ctx.findViewById(R.id.l3541);
        n3642 = netUtils.ctx.findViewById(R.id.l3642);
        n3743 = netUtils.ctx.findViewById(R.id.l3743);
        n3844 = netUtils.ctx.findViewById(R.id.l3844);
        n3845 = netUtils.ctx.findViewById(R.id.l3945);
        n4046 = netUtils.ctx.findViewById(R.id.l4046);
        n4147 = netUtils.ctx.findViewById(R.id.l4147);
    }


}