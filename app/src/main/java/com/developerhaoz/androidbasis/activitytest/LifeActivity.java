package com.developerhaoz.androidbasis.activitytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.developerhaoz.androidbasis.R;

public class LifeActivity extends AppCompatActivity {
    
    private Button mBtnTest;
    private EditText mEtTest;
    private static final String TAG = "LifeActivity111";
    private static final String KEY_EDIT = "key_edit";

    public static void startActivity(Context context){
        Intent intent = new Intent(context, LifeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        mEtTest = (EditText) findViewById(R.id.life_et_test);
        Log.d(TAG, "onCreate: ");
        findViewById(R.id.life_btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnotherActivity.startActivity(getApplicationContext());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        Log.d(TAG, "onStart: " + this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        String editContent = mEtTest.getText().toString();
        if(!"".equals(editContent)){
            outState.putString(KEY_EDIT, editContent);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        if(savedInstanceState != null){
            mEtTest.setText(savedInstanceState.getString(KEY_EDIT));
        }
    }
}
