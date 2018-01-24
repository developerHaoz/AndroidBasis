package com.developerhaoz.androidbasis;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * @author Haoz
 * @date 2018/1/23.
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication111";

    public MyApplication(){
        Log.d(TAG, "MyApplication: ");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "attachBaseContext: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
