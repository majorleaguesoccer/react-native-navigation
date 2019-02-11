package com.reactnativenavigation.params.parsers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.reactnativenavigation.BuildConfig;
import com.reactnativenavigation.react.ImageLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class TabIconParser extends Parser {

    private Bundle params;

    TabIconParser(Bundle params) {
        this.params = params;
    }

    public Drawable parse() {
        Drawable tabIcon = null;
        if (hasKey(params, "icon")) {
            String tabUrl = params.getString("icon");

            if(!BuildConfig.DEBUG && isRemoteImage(tabUrl)) {
                try {
                    tabIcon = drawableFromUrl(tabUrl);
                } catch(IOException err) {
                    Log.w("TabIcon", "Exception while fetching for image:" + err.getMessage());
                    tabIcon = null;
                }

            } else {
                tabIcon = ImageLoader.loadImage(tabUrl);
            }

        }
        return tabIcon;
    }

    private boolean isRemoteImage(String url) {
        return  url.contains("http");
    }

    private Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(null, x);
    }
}
