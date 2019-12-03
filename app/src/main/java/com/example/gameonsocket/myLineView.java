package com.example.gameonsocket;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class myLineView
        extends android.support.v7.widget.AppCompatTextView
        implements View.OnClickListener {
    public myLineView(Context context) {
        super(context);
        this.setBackgroundResource(R.color.gray);
        setOnClickListener(this);

    }

    public myLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundResource(R.color.gray);
        setOnClickListener(this);
    }

    public myLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundResource(R.color.gray);
        setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        v.setBackgroundResource(R.color.red);
        netUtils.userMove = v.getTag().toString();
        Log.d("bbma", "onClick: " + netUtils.userMove);
        netUtils.waitingToSend = false;
    }
}
