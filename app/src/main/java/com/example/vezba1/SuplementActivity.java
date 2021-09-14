package com.example.vezba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SuplementActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suplement);

        webView = findViewById(R.id.suplementWeb);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.pansport.rs/");

    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
            Toast.makeText(this, "Going back inside a WebView", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }

    }
}