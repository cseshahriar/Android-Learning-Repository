package com.example.cricketworldcup2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    String url, url2;

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        Bundle data = getIntent().getExtras();

        if(data.containsKey("URL1")) {
            url2 = data.getString("URL1");
        }

        if(data.containsKey("URL2")) {
            url2 = data.getString("URL2");
        }

        webView.loadUrl(url);
        webView.loadUrl(url2);
    }
}
