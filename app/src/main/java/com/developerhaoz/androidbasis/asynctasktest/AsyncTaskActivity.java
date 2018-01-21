package com.developerhaoz.androidbasis.asynctasktest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.developerhaoz.androidbasis.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AsyncTaskActivity extends AppCompatActivity {

    @BindView(R.id.AsyncTask_btn_test)
    Button mBtnTest;

    private static final String TAG = "AsyncTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate: " + Runtime.getRuntime().availableProcessors());
    }

    @OnClick(R.id.AsyncTask_btn_test)
    public void onViewClicked() {
        new MyAsyncTask("AsyncTask#1").executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "");
        new MyAsyncTask("AsyncTask#2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
        new MyAsyncTask("AsyncTask#3").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
        new MyAsyncTask("AsyncTask#4").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
        new MyAsyncTask("AsyncTask#5").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
    }
}
