package com.example.android.sunshine.app;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android.sunshine.app.service.DownloadService;
import com.example.android.sunshine.app.util.TunesBotUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity {

    CheckBox topTracksCheckBox, downloadCheckBox;
    Button okButton, downloadButton, resetButton;
    boolean rock = false;
    boolean jazz = false;

    public static String FILENAME = "song_preferences";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topTracksCheckBox = (CheckBox) findViewById(R.id.topTracksCheckBox);
        downloadCheckBox = (CheckBox) findViewById(R.id.downloadCheckBox);
        okButton = (Button) findViewById(R.id.okButton);
        downloadButton = (Button) findViewById(R.id.downloadButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void downloadMethod(View v) {
        if (!topTracksCheckBox.isChecked()) {
            Toast.makeText(getBaseContext(), "You must select atleast one preference ", Toast.LENGTH_LONG).show();
        } else {
            UserActions.download(getDownloadManager());
        }
    }

    public void resetMethod(View v) {
        topTracksCheckBox.setChecked(false);
    }

    public void okMethod(View v) {
        if (downloadCheckBox.isChecked()) {
            if (!topTracksCheckBox.isChecked()) {
                Toast.makeText(getBaseContext(), "You must select atleast one preference ", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra(DownloadService.ELECTRONIC, topTracksCheckBox.isChecked());
            startService(intent);
            Toast.makeText(getBaseContext(), topTracksCheckBox.getText() +" will be downloaded automatically !", Toast.LENGTH_LONG).show();
        }
    }


    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Toast.makeText(getBaseContext(), "Fetching latest tracks first", Toast.LENGTH_LONG).show();
            return GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            Toast.makeText(getBaseContext(), "title : " + result, Toast.LENGTH_LONG).show();

            Log.i("Message", "Result*****" + result);
        }
    }


    public static String GET(String url) {
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public boolean isConnected() {
        return TunesBotUtil.isConnected((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));
    }

    public DownloadManager getDownloadManager() {
        return (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
    }
}