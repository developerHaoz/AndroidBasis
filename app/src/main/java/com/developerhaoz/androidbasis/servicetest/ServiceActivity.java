package com.developerhaoz.androidbasis.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.developerhaoz.androidbasis.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.service_btn_create)
    Button mBtnCreate;
    @BindView(R.id.service_btn_stop)
    Button mBtnStartcommand;
    @BindView(R.id.service_btn_bind)
    Button meBtnBind;
    @BindView(R.id.service_btn_unbind)
    Button mBtnUnbind;

    private MyService.DownloadBinder mDownloadBinder;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (MyService.DownloadBinder) service;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.service_btn_create, R.id.service_btn_stop, R.id.service_btn_bind, R.id.service_btn_unbind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.service_btn_create:
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.service_btn_stop:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.service_btn_bind:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);
                break;
            case R.id.service_btn_unbind:
                unbindService(mConnection);
                break;
            default:
                break;
        }
    }
}
