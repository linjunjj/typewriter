package com.example.linjun.myapplication22;

import android.content.Context;
import android.print.PageRange;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by linjun on 2017/1/2.
 */

public class PrinterTextView extends TextView {
    private static final String TAG = "PrinterTextView";
    private final String DEFAULT_INTERVAL_CHAR ="_";
    private final int DEFAULT_TIME_DELAY = 80;
    private Timer timer;
    private String mPrintStr;
    private int intervasltime = DEFAULT_TIME_DELAY;
    private String intervalChar = DEFAULT_INTERVAL_CHAR;
    private int printProgress = 0;


    public PrinterTextView(Context context) {
        super(context);
    }

    public PrinterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrinterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPrintText(String str) {
        setPrintText(str, DEFAULT_TIME_DELAY);


    }

    void setPrintText(String str, int time) {
        setPrintText(str, time, DEFAULT_INTERVAL_CHAR);
    }

    void setPrintText(String str, int time, String intervalChar) {
        if (strIsEmpty(str) || 0 == time || strIsEmpty(intervalChar)) {

            return;

        }
        this.mPrintStr = str;
        this.intervasltime = time;
        this.intervalChar = intervalChar;
    }

    private boolean strIsEmpty(String str) {
        if (null != str && !"".equals(str)) {
            return false;
        } else {
            return true;
        }
    }

    public void startPrint() {
        if (strIsEmpty(mPrintStr)) {
           if (!strIsEmpty(getText().toString())){
               this.mPrintStr=getText().toString();
           }else {return;}
        }
        setText("");
        stopPrint();
        printProgress=0;
        timer=new Timer();
        timer.schedule(new PrinterTimerTask(),intervasltime,intervasltime);
    }

    private void stopPrint() {
        if (null!=timer){
            timer.cancel();
            timer=null;
        }
    }
     class  PrinterTimerTask extends TimerTask{


         @Override
         public void run() {
             System.out.println(post(new Runnable() {
                 @Override
                 public void run() {
                  if (printProgress<mPrintStr.length()){
                      printProgress++;
                      setText(
                              mPrintStr.substring(0,printProgress)+((printProgress & 1)==1?intervalChar :"" ));
                  }else {
                      setText(mPrintStr);
                      stopPrint();
                  }
                 }
             }));
         }
     }
}
