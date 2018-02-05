package com.developerhaoz.androidbasis;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class TestActivity extends AppCompatActivity {

    private NetworkImageView mNivTest;
    private static final String URL = "http://ww4.sinaimg.cn/large/610dc034gw1euxdmjl7j7j20r2180wts.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mNivTest = (NetworkImageView) findViewById(R.id.test_niv_test);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        mNivTest.setDefaultImageResId(R.mipmap.ic_launcher);
        mNivTest.setErrorImageResId(R.mipmap.ic_launcher);
        mNivTest.setImageUrl(URL, imageLoader);
    }

}
