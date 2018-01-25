package com.developerhaoz.androidbasis.fragmenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.developerhaoz.androidbasis.R;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_fl_container, TestFragment.newInstance())
                .commit();
    }
}
