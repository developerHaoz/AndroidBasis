package com.developerhaoz.androidbasis.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developerhaoz.androidbasis.R;

/**
 * @author Haoz
 * @date 2018/1/24.
 */
public class TestFragment extends Fragment {

    private static final String TAG = "TestFragment1111";
    private int id;

    public static TestFragment newInstance(){
        return new TestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: " + id);
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        id = getId();
        Log.d(TAG, "onAttach: " + id);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + id);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: " + id);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + id);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + id);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + id);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: " + id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + id);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: " + id);
    }
}
