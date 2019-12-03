package com.example.gameonsocket;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

@SuppressLint("StaticFieldLeak")
public class DataFetcher extends AsyncTask<String, Void, String> {

    private static final String TAG = "fetcherLogs";
    private boolean myTurn;

    private myLineView m01, m12, m23, m34, m45, m67, m78, m89, m910, m1011, m1213, m1314, m1415, m1516, m1617, m1819, m1920, m2021, m2122, m2223, m2425, m2526, m2627, m2728, m2829, m3031, m3132, m3233, m3334, m3435, m3637, m3738, m3839, m3940, m4041, m4243, m4344, m4445, m4546, m4647;
    private myLineView m06, m17, m28, m39, m410, m511, m612, m713, m814, m915, m1016, m1117, m1218, m1319, m1420, m1521, m1622, m1723, m1824, m1925, m2026, m2127, m2228, m2329, m2430, m2531, m2632, m2733, m2834, m2935, m3036, m3137, m3238, m3339, m3440, m3541, m3642, m3743, m3844, m3945, m4046, m4147;


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
            netUtils.s = new Socket(InetAddress.getByName("192.168.43.200"), 2000);
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
                } else if (readLine.equals("your turn")) {
                    netUtils.waitingToSend = true;
                    while (netUtils.waitingToSend) {
                    }
                    sendUserAction(netUtils.userMove);
                } else if (!readLine.equals("") && !readLine.contains("turn")) {
                    if (readLine.contains("names:")) {
                        netUtils.gamerNames = new String[4];
                        netUtils.gamerNames = readLine.substring(6).split(",");
                        netUtils.ctx.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                netUtils.g1.setText(netUtils.gamerNames[0] + " : ");
                                netUtils.po1.setText(String.valueOf(netUtils.p1));
                                netUtils.g2.setText(netUtils.gamerNames[1] + " : ");
                                netUtils.po2.setText(String.valueOf(netUtils.p2));
                            }
                        });

                        //todo: needed to uncommented if 4 gamers want to play
//                        netUtils.g3.setText(netUtils.gamerNames[2]);
//                        netUtils.g4.setText(netUtils.gamerNames[3]);
                    } else {
                        int userNum = Integer.parseInt(readLine.substring(0, 1));
                        String[] moveAndPoint = readLine.substring(2).split(":");
                        switch (userNum) {
                            case 0:
                                netUtils.p1 =Integer.parseInt(moveAndPoint[1]);
                                setNewMoveToBoard(moveAndPoint[0], moveAndPoint[1], R.color.red, userNum);
                                break;
                            case 1:
                                netUtils.p2 =Integer.parseInt(moveAndPoint[1]);
                                setNewMoveToBoard(moveAndPoint[0], moveAndPoint[1], R.color.green, userNum);
                                break;
                            case 2:
                                netUtils.p3 =Integer.parseInt(moveAndPoint[1]);
                                setNewMoveToBoard(moveAndPoint[0], moveAndPoint[1], R.color.yellow, userNum);
                                break;
                            case 3:
                                netUtils.p4 =Integer.parseInt(moveAndPoint[1]);
                                setNewMoveToBoard(moveAndPoint[0], moveAndPoint[1], R.color.black, userNum);
                                break;
                        }
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setNewMoveToBoard(final String move, final String gPoint, final int color, final int userName) {
        netUtils.ctx.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (userName){
                    case 0:
                        netUtils.po1.setText(String.valueOf(netUtils.p1));
                        break;
                    case 1:
                        netUtils.po2.setText(String.valueOf(netUtils.p2));
                        break;
                    case 2:
                        netUtils.po3.setText(String.valueOf(netUtils.p3));
                        break;
                    case 3:
                        netUtils.po4.setText(String.valueOf(netUtils.p4));
                        break;
                }
                switch (move) {
                    case "0,1":
                        m01.setBackgroundResource(color);
                        m01.setClickable(false);
                        break;
                    case "1,2":
                        m12.setBackgroundResource(color);
                        m12.setClickable(false);
                        break;
                    case "2,3":
                        m23.setBackgroundResource(color);
                        m23.setClickable(false);
                        break;
                    case "3,4":
                        m34.setBackgroundResource(color);
                        m34.setClickable(false);
                        break;
                    case "4,5":
                        m45.setBackgroundResource(color);
                        m45.setClickable(false);
                        break;
                    case "6,7":
                        m67.setBackgroundResource(color);
                        m67.setClickable(false);
                        break;
                    case "7,8":
                        m78.setBackgroundResource(color);
                        m78.setClickable(false);
                        break;
                    case "8,9":
                        m89.setBackgroundResource(color);
                        m89.setClickable(false);
                        break;
                    case "0,6":
                        m06.setBackgroundResource(color);
                        m06.setClickable(false);
                        break;
                    case "1,7":
                        m17.setBackgroundResource(color);
                        m17.setClickable(false);
                        break;
                    case "2,8":
                        m28.setBackgroundResource(color);
                        m28.setClickable(false);
                        break;
                    case "3,9":
                        m39.setBackgroundResource(color);
                        m39.setClickable(false);
                        break;
                    case "9,10":
                        m910.setBackgroundResource(color);
                        m910.setClickable(false);
                        break;
                    case "4,10":
                        m410.setBackgroundResource(color);
                        m410.setClickable(false);
                        break;
                    case "5,11":
                        m511.setBackgroundResource(color);
                        m511.setClickable(false);
                        break;
                    case "6,12":
                        m612.setBackgroundResource(color);
                        m612.setClickable(false);
                        break;
                    case "7,13":
                        m713.setBackgroundResource(color);
                        m713.setClickable(false);
                        break;
                    case "8,14":
                        m814.setBackgroundResource(color);
                        m814.setClickable(false);
                        break;
                    case "9,15":
                        m915.setBackgroundResource(color);
                        m915.setClickable(false);
                        break;
                    case "10,11":
                        m1011.setBackgroundResource(color);
                        m1011.setClickable(false);
                        break;
                    case "13,14":
                        m1314.setBackgroundResource(color);
                        m1314.setClickable(false);
                        break;
                    case "12,13":
                        m1213.setBackgroundResource(color);
                        m1213.setClickable(false);
                        break;
                    case "14,15":
                        m1415.setBackgroundResource(color);
                        m1415.setClickable(false);
                        break;
                    case "15,16":
                        m1516.setBackgroundResource(color);
                        m1516.setClickable(false);
                        break;
                    case "16,17":
                        m1617.setBackgroundResource(color);
                        m1617.setClickable(false);
                        break;
                    case "10,16":
                        m1016.setBackgroundResource(color);
                        m1016.setClickable(false);
                        break;
                    case "11,17":
                        m1117.setBackgroundResource(color);
                        m1117.setClickable(false);
                        break;
                    case "18,19":
                        m1819.setBackgroundResource(color);
                        m1819.setClickable(false);
                        break;
                    case "19,20":
                        m1920.setBackgroundResource(color);
                        m1920.setClickable(false);
                        break;
                    case "20,21":
                        m2021.setBackgroundResource(color);
                        m2021.setClickable(false);
                        break;
                    case "21,22":
                        m2122.setBackgroundResource(color);
                        m2122.setClickable(false);
                        break;
                    case "22,23":
                        m2223.setBackgroundResource(color);
                        m2223.setClickable(false);
                        break;
                    case "24,25":
                        m2425.setBackgroundResource(color);
                        m2425.setClickable(false);
                        break;
                    case "25,26":
                        m2526.setBackgroundResource(color);
                        m2526.setClickable(false);
                        break;
                    case "26,27":
                        m2627.setBackgroundResource(color);
                        m2627.setClickable(false);
                        break;
                    case "27,28":
                        m2728.setBackgroundResource(color);
                        m2728.setClickable(false);
                        break;
                    case "28,29":
                        m2829.setBackgroundResource(color);
                        m2829.setClickable(false);
                        break;
                    case "30,31":
                        m3031.setBackgroundResource(color);
                        m3031.setClickable(false);
                        break;
                    case "31,32":
                        m3132.setBackgroundResource(color);
                        m3132.setClickable(false);
                        break;
                    case "32,33":
                        m3233.setBackgroundResource(color);
                        m3233.setClickable(false);
                        break;
                    case "33,34":
                        m3334.setBackgroundResource(color);
                        m3334.setClickable(false);
                        break;
                    case "34,35":
                        m3435.setBackgroundResource(color);
                        m3435.setClickable(false);
                        break;
                    case "36,37":
                        m3637.setBackgroundResource(color);
                        m3637.setClickable(false);
                        break;
                    case "37,38":
                        m3738.setBackgroundResource(color);
                        m3738.setClickable(false);
                        break;
                    case "38,39":
                        m3839.setBackgroundResource(color);
                        m3839.setClickable(false);
                        break;
                    case "39,40":
                        m3940.setBackgroundResource(color);
                        m3940.setClickable(false);
                        break;
                    case "40,41":
                        m4041.setBackgroundResource(color);
                        m4041.setClickable(false);
                        break;
                    case "42,43":
                        m4243.setBackgroundResource(color);
                        m4243.setClickable(false);
                        break;
                    case "43,44":
                        m4344.setBackgroundResource(color);
                        m4344.setClickable(false);
                        break;
                    case "44,45":
                        m4445.setBackgroundResource(color);
                        m4445.setClickable(false);
                        break;
                    case "45,46":
                        m4546.setBackgroundResource(color);
                        m4546.setClickable(false);
                        break;
                    case "46,47":
                        m4647.setBackgroundResource(color);
                        m4647.setClickable(false);
                        break;
                    case "12,18":
                        m1218.setBackgroundResource(color);
                        m1218.setClickable(false);
                        break;
                    case "13,19":
                        m1319.setBackgroundResource(color);
                        m1319.setClickable(false);
                        break;
                    case "14,20":
                        m1420.setBackgroundResource(color);
                        m1420.setClickable(false);
                        break;
                    case "15,21":
                        m1521.setBackgroundResource(color);
                        m1521.setClickable(false);
                        break;
                    case "16,22":
                        m1622.setBackgroundResource(color);
                        m1622.setClickable(false);
                        break;
                    case "17,23":
                        m1723.setBackgroundResource(color);
                        m1723.setClickable(false);
                        break;
                    case "18,24":
                        m1824.setBackgroundResource(color);
                        m1824.setClickable(false);
                        break;
                    case "19,25":
                        m1925.setBackgroundResource(color);
                        m1925.setClickable(false);
                        break;
                    case "20,26":
                        m2026.setBackgroundResource(color);
                        m2026.setClickable(false);
                        break;
                    case "21,27":
                        m2127.setBackgroundResource(color);
                        m2127.setClickable(false);
                        break;
                    case "22,28":
                        m2228.setBackgroundResource(color);
                        m2228.setClickable(false);
                        break;
                    case "23,29":
                        m2329.setBackgroundResource(color);
                        m2329.setClickable(false);
                        break;
                    case "24,30":
                        m2430.setBackgroundResource(color);
                        m2430.setClickable(false);
                        break;
                    case "25,31":
                        m2531.setBackgroundResource(color);
                        m2531.setClickable(false);
                        break;
                    case "26,32":
                        m2632.setBackgroundResource(color);
                        m2632.setClickable(false);
                        break;
                    case "27,33":
                        m2733.setBackgroundResource(color);
                        m2733.setClickable(false);
                        break;
                    case "28,34":
                        m2834.setBackgroundResource(color);
                        m2834.setClickable(false);
                        break;
                    case "29,35":
                        m2935.setBackgroundResource(color);
                        m2935.setClickable(false);
                        break;
                    case "30,36":
                        m3036.setBackgroundResource(color);
                        m3036.setClickable(false);
                        break;
                    case "31,37":
                        m3137.setBackgroundResource(color);
                        m3137.setClickable(false);
                        break;
                    case "32,38":
                        m3238.setBackgroundResource(color);
                        m3238.setClickable(false);
                        break;
                    case "33,39":
                        m3339.setBackgroundResource(color);
                        m3339.setClickable(false);
                        break;
                    case "34,40":
                        m3440.setBackgroundResource(color);
                        m3440.setClickable(false);
                        break;
                    case "35,41":
                        m3541.setBackgroundResource(color);
                        m3541.setClickable(false);
                        break;
                    case "36,42":
                        m3642.setBackgroundResource(color);
                        m3642.setClickable(false);
                        break;
                    case "37,43":
                        m3743.setBackgroundResource(color);
                        m3743.setClickable(false);
                        break;
                    case "38,44":
                        m3844.setBackgroundResource(color);
                        m3844.setClickable(false);
                        break;
                    case "39,45":
                        m3945.setBackgroundResource(color);
                        m3945.setClickable(false);
                        break;
                    case "40,46":
                        m4046.setBackgroundResource(color);
                        m4046.setClickable(false);
                        break;
                    case "41,47":
                        m4147.setBackgroundResource(color);
                        m4147.setClickable(false);
                        break;
                }
            }
        });

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
        m06 = netUtils.ctx.findViewById(R.id.l06);
        m17 = netUtils.ctx.findViewById(R.id.l17);
        m28 = netUtils.ctx.findViewById(R.id.l28);
        m39 = netUtils.ctx.findViewById(R.id.l39);
        m410 = netUtils.ctx.findViewById(R.id.l410);
        m511 = netUtils.ctx.findViewById(R.id.l511);
        m612 = netUtils.ctx.findViewById(R.id.l612);
        m713 = netUtils.ctx.findViewById(R.id.l713);
        m814 = netUtils.ctx.findViewById(R.id.l814);
        m915 = netUtils.ctx.findViewById(R.id.l915);
        m1016 = netUtils.ctx.findViewById(R.id.l1016);
        m1117 = netUtils.ctx.findViewById(R.id.l1117);
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
        m1218 = netUtils.ctx.findViewById(R.id.l1218);
        m1319 = netUtils.ctx.findViewById(R.id.l1319);
        m1420 = netUtils.ctx.findViewById(R.id.l1420);
        m1521 = netUtils.ctx.findViewById(R.id.l1521);
        m1622 = netUtils.ctx.findViewById(R.id.l1622);
        m1723 = netUtils.ctx.findViewById(R.id.l1723);
        m1824 = netUtils.ctx.findViewById(R.id.l1824);
        m1925 = netUtils.ctx.findViewById(R.id.l1925);
        m2026 = netUtils.ctx.findViewById(R.id.l2026);
        m2127 = netUtils.ctx.findViewById(R.id.l2127);
        m2228 = netUtils.ctx.findViewById(R.id.l2228);
        m2329 = netUtils.ctx.findViewById(R.id.l2329);
        m2430 = netUtils.ctx.findViewById(R.id.l2430);
        m2531 = netUtils.ctx.findViewById(R.id.l2531);
        m2632 = netUtils.ctx.findViewById(R.id.l2632);
        m2733 = netUtils.ctx.findViewById(R.id.l2733);
        m2834 = netUtils.ctx.findViewById(R.id.l2834);
        m2935 = netUtils.ctx.findViewById(R.id.l2935);
        m3036 = netUtils.ctx.findViewById(R.id.l3036);
        m3137 = netUtils.ctx.findViewById(R.id.l3137);
        m3238 = netUtils.ctx.findViewById(R.id.l3238);
        m3339 = netUtils.ctx.findViewById(R.id.l3339);
        m3440 = netUtils.ctx.findViewById(R.id.l3440);
        m3541 = netUtils.ctx.findViewById(R.id.l3541);
        m3642 = netUtils.ctx.findViewById(R.id.l3642);
        m3743 = netUtils.ctx.findViewById(R.id.l3743);
        m3844 = netUtils.ctx.findViewById(R.id.l3844);
        m3945 = netUtils.ctx.findViewById(R.id.l3945);
        m4046 = netUtils.ctx.findViewById(R.id.l4046);
        m4147 = netUtils.ctx.findViewById(R.id.l4147);
    }


}