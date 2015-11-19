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
public class FacebookScreen extends Activity {
    private WebView facebookWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook_screen);
        ImageView facebookView = (ImageView) findViewById(R.id.imageView5);
        Bitmap bIM = BitmapFactory.decodeResource(this.getResources(), R.drawable.facebook);
        facebookView.setImageBitmap(bIM);



        facebookWebView = (WebView) findViewById(R.id.facebook_webview);
        WebSettings settings = facebookWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        facebookWebView.loadUrl("https://mobile.facebook.com/");

    }
}
