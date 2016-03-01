package com.example.android.sunshine.app.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android.sunshine.app.Constants;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by deepak.barr on 21/02/16.
 */
public class DownloadService extends IntentService {

    public static final String POP="POP",ELECTRONIC="ELECTRONIC",URL="URL";


    public DownloadService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("test","Service is running");

        try {
            URL url = new URL(intent.getStringExtra(URL));
            URLConnection connection = url.openConnection();
            connection.connect();
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream("/sdcard/"+ Constants.DOWNLOAD_DIR+"/");

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
}
