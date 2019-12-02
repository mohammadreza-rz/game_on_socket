package com.example.gameonsocket;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class DataFetcher extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... job) {
        switch (job[0]) {
            case "initSocket":
                initSocket();
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
    }

    private void initSocket() {
        try {
            netUtils.s = new Socket(InetAddress.getByName("172.16.35.80"), 2000);
            DataInputStream is = new DataInputStream(netUtils.s.getInputStream());
            Log.d("aabb", "run: reading line .  .  .");
            int nobat = Integer.parseInt(is.readLine());
            Log.d("aabb", "nobat shoma hast: " + nobat);

            while (true) {
                String sss = is.readLine();
                Log.d("aabb", "initSocket: third 1" + sss);
                if (sss.equals("your name ?")) {
                    OutputStream os = null;
                    try {
                        os = netUtils.s.getOutputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter p = new PrintWriter(os);
                    p.println("ali");
                    p.flush();
                    Log.d("aabb", "run: your name send!");
                } else {
                    Log.d("aabb", "run: man should do action is : " + sss);
                }
                Log.d("aabb", "run: reading line . . . . . . . . . . . .");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}