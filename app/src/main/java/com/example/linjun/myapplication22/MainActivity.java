package com.example.linjun.myapplication22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  private  PrinterTextView printerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printerTextView= (PrinterTextView) findViewById(R.id.view);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPrint(v);
            }
        });

    }
     public void startPrint(View view){
         printerTextView.setPrintText("据新加坡《联合早报》网站2016年12月31日报道，中纪委网站近日推出年终系列视频专访。据中纪委国际合作局副局长蔡为介绍，2016年1至11月，“天网”行动共从70多个国家和地区追回外逃人员908人，其中党员和国家工作人员122人、“百名红通人员”19人，追回赃款23.12亿元人民币。",100,"|");
         printerTextView.startPrint();

     }
}
