package com.example.miniproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.miniproject.R;

public class HalamanBuku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView = findViewById(R.id.urlbuku);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ejournal.undiksha.ac.id/index.php/semnasmipa/article/view/10479/6690");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

    }
}