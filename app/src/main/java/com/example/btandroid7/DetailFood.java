package com.example.btandroid7;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class DetailFood extends Activity {
    WebView web_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_web_view);
        web_view = (WebView) findViewById(R.id.webView1);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("urlKey");
        web_view.loadUrl(url);
    }

}
