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
        myViewSetTag(this);
    }

    public myLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundResource(R.color.gray);
        setOnClickListener(this);
        myViewSetTag(this);
    }

    public myLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundResource(R.color.gray);
        setOnClickListener(this);
        myViewSetTag(this);
    }


    @Override
    public void onClick(View v) {
        v.setBackgroundResource(R.color.red);
        netUtils.userMove = v.getTag().toString();
        Log.d("bbma", "onClick: " + netUtils.userMove);
        netUtils.waitingToSend = false;
    }

    private void myViewSetTag(myLineView myLineView) {
        switch (myLineView.getId()) {
            case R.id.l01:
                myLineView.setTag("0,1");
                break;
            case R.id.l12:
                myLineView.setTag("1,2");
                break;
            case R.id.l23:
                myLineView.setTag("2,3");
                break;
            case R.id.l34:
                myLineView.setTag("3,4");
                break;
            case R.id.l45:
                myLineView.setTag("4,5");
                break;
            case R.id.l67:
                myLineView.setTag("6,7");
                break;
            case R.id.l78:
                myLineView.setTag("7,8");
                break;
            case R.id.l89:
                myLineView.setTag("8,9");
                break;
            case R.id.l06:
                myLineView.setTag("0,6");
                break;
            case R.id.l17:
                myLineView.setTag("1,7");
                break;
            case R.id.l28:
                myLineView.setTag("2,8");
                break;
            case R.id.l39:
                myLineView.setTag("3,9");
                break;
            case R.id.l910:
                myLineView.setTag("9,10");
                break;
            case R.id.l410:
                myLineView.setTag("4,10");
                break;
            case R.id.l511:
                myLineView.setTag("5,11");
                break;
            case R.id.l612:
                myLineView.setTag("6,12");
                break;
            case R.id.l713:
                myLineView.setTag("7,13");
                break;
            case R.id.l814:
                myLineView.setTag("8,14");
                break;
            case R.id.l915:
                myLineView.setTag("9,15");
                break;
            case R.id.l1011:
                myLineView.setTag("10,11");
                break;
            case R.id.l1314:
                myLineView.setTag("13,14");
                break;
            case R.id.l1213:
                myLineView.setTag("12,13");
                break;
            case R.id.l1415:
                myLineView.setTag("14,15");
                break;
            case R.id.l1516:
                myLineView.setTag("15,16");
                break;
            case R.id.l1617:
                myLineView.setTag("16,17");
                break;
            case R.id.l1016:
                myLineView.setTag("10,16");
                break;
            case R.id.l1117:
                myLineView.setTag("11,17");
                break;
            case R.id.l1819:
                myLineView.setTag("18,19");
                break;
            case R.id.l1920:
                myLineView.setTag("19,20");
                break;
            case R.id.l2021:
                myLineView.setTag("20,21");
                break;
            case R.id.l2122:
                myLineView.setTag("21,22");
                break;
            case R.id.l2223:
                myLineView.setTag("22,23");
                break;
            case R.id.l2425:
                myLineView.setTag("24,25");
                break;
            case R.id.l2526:
                myLineView.setTag("25,26");
                break;
            case R.id.l2627:
                myLineView.setTag("26,27");
                break;
            case R.id.l2728:
                myLineView.setTag("27,28");
                break;
            case R.id.l2829:
                myLineView.setTag("28,29");
                break;
            case R.id.l3031:
                myLineView.setTag("30,31");
                break;
            case R.id.l3132:
                myLineView.setTag("31,32");
                break;
            case R.id.l3233:
                myLineView.setTag("32,33");
                break;
            case R.id.l3334:
                myLineView.setTag("33,34");
                break;
            case R.id.l3435:
                myLineView.setTag("34,35");
                break;
            case R.id.l3637:
                myLineView.setTag("36,37");
                break;
            case R.id.l3738:
                myLineView.setTag("37,38");
                break;
            case R.id.l3839:
                myLineView.setTag("38,39");
                break;
            case R.id.l3940:
                myLineView.setTag("39,40");
                break;
            case R.id.l4041:
                myLineView.setTag("40,41");
                break;
            case R.id.l4243:
                myLineView.setTag("42,43");
                break;
            case R.id.l4344:
                myLineView.setTag("43,44");
                break;
            case R.id.l4445:
                myLineView.setTag("44,45");
                break;
            case R.id.l4546:
                myLineView.setTag("45,46");
                break;
            case R.id.l4647:
                myLineView.setTag("46,47");
                break;
            case R.id.l1218:
                myLineView.setTag("12,18");
                break;
            case R.id.l1319:
                myLineView.setTag("13,19");
                break;
            case R.id.l1420:
                myLineView.setTag("14,20");
                break;
            case R.id.l1521:
                myLineView.setTag("15,21");
                break;
            case R.id.l1622:
                myLineView.setTag("16,22");
                break;
            case R.id.l1723:
                myLineView.setTag("17,23");
                break;
            case R.id.l1824:
                myLineView.setTag("18,24");
                break;
            case R.id.l1925:
                myLineView.setTag("19,25");
                break;
            case R.id.l2026:
                myLineView.setTag("20,26");
                break;
            case R.id.l2127:
                myLineView.setTag("21,27");
                break;
            case R.id.l2228:
                myLineView.setTag("22,28");
                break;
            case R.id.l2329:
                myLineView.setTag("23,29");
                break;
            case R.id.l2430:
                myLineView.setTag("24,30");
                break;
            case R.id.l2531:
                myLineView.setTag("25,31");
                break;
            case R.id.l2632:
                myLineView.setTag("26,32");
                break;
            case R.id.l2733:
                myLineView.setTag("27,33");
                break;
            case R.id.l2834:
                myLineView.setTag("28,34");
                break;
            case R.id.l2935:
                myLineView.setTag("29,35");
                break;
            case R.id.l3036:
                myLineView.setTag("30,36");
                break;
            case R.id.l3137:
                myLineView.setTag("31,37");
                break;
            case R.id.l3238:
                myLineView.setTag("32,38");
                break;
            case R.id.l3339:
                myLineView.setTag("33,39");
                break;
            case R.id.l3440:
                myLineView.setTag("34,40");
                break;
            case R.id.l3541:
                myLineView.setTag("35,41");
                break;
            case R.id.l3642:
                myLineView.setTag("36,42");
                break;
            case R.id.l3743:
                myLineView.setTag("37,43");
                break;
            case R.id.l3844:
                myLineView.setTag("38,44");
                break;
            case R.id.l3945:
                myLineView.setTag("39,45");
                break;
            case R.id.l4046:
                myLineView.setTag("40,46");
                break;
            case R.id.l4147:
                myLineView.setTag("41,47");
                break;

        }
    }

}






























