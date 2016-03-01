package com.example.android.sunshine.app.old;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadIndentService extends IntentService {

    public static final int UPDATE_PROGRESS = 8344;
    EditText etResponse;
    TextView tvIsConnected;

    public DownloadIndentService() {
        super("My service");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service is created", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service is started",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("Service test ", "From onHandleIntent");
        String urlToDownload = intent.getStringExtra("url");

        try {
            URL url = new URL(urlToDownload);
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream("/sdcard/mymusic/");

            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                Bundle resultData = new Bundle();
                resultData.putInt("progress" ,(int) (total * 100 / fileLength));

                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service is destroyed",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }


}
