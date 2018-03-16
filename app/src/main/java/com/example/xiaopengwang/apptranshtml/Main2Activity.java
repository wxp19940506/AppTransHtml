package com.example.xiaopengwang.apptranshtml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by XiaopengWang on 2018/3/16.
 * Email:xiaopeng.wang@qaii.ac.cn
 * QQ:839853185
 * WinXin;wxp19940505
 */

public class Main2Activity extends AppCompatActivity  implements AsForjs.CallBack {
    private WebView wv;
    private TextView tv;
    private Button bt;
    private AsForjs asForjs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        asForjs=new AsForjs(this);
        asForjs.setCallBack(this);
        bt=(Button)findViewById(R.id.bt) ;
        tv=(TextView)findViewById(R.id.tv);
        wv = (WebView) findViewById(R.id.wb);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(true);
        wv.setWebViewClient(new WebViewClient());
        wv.setWebChromeClient(new WebChromeClient());
        wv.loadUrl("file:///android_asset/denglu.html");
/*在安卓程序中暴露出一个接口
参数1：java类
参数2：java类别名

 */
        wv.addJavascriptInterface(asForjs, "Android");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("用户名："+asForjs.getname()+"密码："+asForjs.getPwd2());
            }
        });


    }

    @Override
    public void changeText(String name, String pwd) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
