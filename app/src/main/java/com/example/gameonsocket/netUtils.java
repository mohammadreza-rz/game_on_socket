package com.example.gameonsocket;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.Socket;

public class netUtils {
    public static Socket s;
    public static boolean waitingToSend;
    public static String userMove;
    public static String[] gamerNames;
    public static int userColor;
    public static MainActivity ctx;
    public static TextView g1, g2, g3, g4, po1, po2, po3, po4;
    public static int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
    public static ImageView ll1;
}



