package com.example.andy.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Andy on 16/11/2015.
 */
public class RedditScreen extends Activity {

    private WebView redditWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reddit_screen);

        redditWebView = (WebView) findViewById(R.id.reddit_webview);
        WebSettings settings = redditWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        redditWebView.loadUrl("https://m.reddit.com/r/rocketleague");

    }
}
