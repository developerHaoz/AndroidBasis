package com.developerhaoz.androidbasis.asynctasktest;

import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Date;

/**
 * @author Haoz
 * @date 2018/1/19.
 */
public class MyAsyncTask extends AsyncTask<String, Integer, String> {

    private String mName = "AsyncTask";
    private static final String TAG = "MyAsyncTask";

    public MyAsyncTask(String name) {
        super();
        this.mName = name;
    }


    @Override
    protected String doInBackground(String... params) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mName;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d(TAG, result + "execute finish at " + dateFormat.format(new Date()));
    }
}
