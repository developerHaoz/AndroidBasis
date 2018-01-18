package com.developerhaoz.androidbasis.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";

    Service1AIDL.Stub mBinder = new Service1AIDL.Stub() {
        @Override
        public void AIDL_Service() throws RemoteException {
            Log.d(TAG, "客户端通过 AIDL 与远程后台成功通信");
        }
    };

    class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d(TAG, "startDownload: ");
        }

        public int getProgress(){
            Log.d(TAG, "getProgress: ");
            return 0;
        }
    }
    
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
