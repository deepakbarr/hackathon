//package com.example.android.sunshine.app;
//
//import android.app.IntentService;
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//import android.widget.Toast;
//
//
//public class DownloadService extends Service {
//
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Toast.makeText(this,"Service is created",Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Toast.makeText(this,"Service is started",Toast.LENGTH_LONG).show();
//        String message = intent.getStringExtra("message");
//        Toast.makeText(this,"Message : " + message,Toast.LENGTH_LONG).show();
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        Toast.makeText(this,"Service is stopped",Toast.LENGTH_LONG).show();
//        super.onDestroy();
//    }
//}
