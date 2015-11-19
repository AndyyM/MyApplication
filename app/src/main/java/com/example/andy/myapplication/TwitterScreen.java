package com.example.andy.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by Andy on 19/11/2015.
 */
public class TwitterScreen extends Activity {

    private WebView twitterWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_screen);

        ImageView twitterView = (ImageView) findViewById(R.id.imageView4);
        Bitmap bIM = BitmapFactory.decodeResource(this.getResources(), R.drawable.twitter);
        twitterView.setImageBitmap(bIM);



        twitterWebView = (WebView) findViewById(R.id.twitter_webview);
        WebSettings settings = twitterWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        twitterWebView.loadUrl("https://mobile.twitter.com/");

    }
}
