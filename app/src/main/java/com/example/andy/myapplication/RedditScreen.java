package com.example.andy.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by Andy on 16/11/2015.
 */
public class RedditScreen extends Activity {

    private WebView redditWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reddit_screen);
        ImageView redditView = (ImageView) findViewById(R.id.imageView3);
        Bitmap bIM = BitmapFactory.decodeResource(this.getResources(), R.drawable.reddit);
        redditView.setImageBitmap(bIM);


        redditWebView = (WebView) findViewById(R.id.reddit_webview);
        WebSettings settings = redditWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        redditWebView.loadUrl("https://m.reddit.com/r/rocketleague");

    }
}
