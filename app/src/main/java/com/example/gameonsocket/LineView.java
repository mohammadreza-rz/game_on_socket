package com.example.gameonsocket;

import android.content.Context;
import android.util.Log;
import android.view.View;


public class LineView extends android.support.v7.widget.AppCompatTextView implements View.OnClickListener {
    public LineView(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        v.setBackgroundResource(R.color.red);
        Log.d("bbma", "---------------------------  line " + v.getTag() + "clicked");
        netUtils.userMove = v.getTag().toString();
        netUtils.waitingToSend = false;
    }
}
