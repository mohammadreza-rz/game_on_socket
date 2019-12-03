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
        Log.d("bbma", "sendUserAction: helooo1 ");

        switch (job[0]) {
            case "initSocket":
                initSocket(job[1]);
                break;
            case "sendUserAction":
                Log.d("bbma", "sendUserAction: helooo 2");

                sendUserAction(job[1]);
                break;
        }
        return null;
    }

    private void sendUserAction(String action) {
        Log.d("bbma", "sendUserAction: helooo3 ");

        OutputStream os = null;
        try {
            os = netUtils.s.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter p = new PrintWriter(os);
        p.println(action);
        p.flush();
        Log.d("bbma", "sendUserAction: helooo ");
    }

    private void initSocket(String name) {
        try {
            netUtils.s = new Socket(InetAddress.getByName("192.168.43.30"), 2000);
            DataInputStream is = new DataInputStream(netUtils.s.getInputStream());
            Log.d("aabb", "run: reading line .  .  .");
            int nobat = Integer.parseInt(is.readLine());
            Log.d("aabb", "nobat shoma hast: " + nobat);

            while (true){
                String sss = is.readLine();
                Log.d("aabb", "initSocket: third 1" + sss);
                if (sss.equals("your name ?")) {
                    sendUserAction(name);
                    Log.d("aabb", "run: your name send!");
                } else {
                    netUtils.waitingToSend = true;
                    Log.d("aabb", "run: man should do action is : " + sss);
                    while (netUtils.waitingToSend){}
                    sendUserAction(netUtils.userMove);

                }
                Log.d("aabb", "run: reading line . . . . . . . . . . . .");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}