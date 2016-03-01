//package com.example.android.sunshine.app.old;
//
//import android.app.Activity;
//import android.app.DownloadManager;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Environment;
//import android.util.Log;
//import android.view.Menu;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.android.sunshine.app.R;
//import com.example.android.sunshine.app.service.DownloadService;
//import com.example.android.sunshine.app.util.TunesBotUtil;
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//
//public class MainActivity extends Activity {
//
//    EditText etResponse;
//    TextView tvIsConnected;
//    CheckBox ch1, ch2;
//    Button b1, b2;
//    boolean rock = false;
//    boolean jazz = false;
//
//    public static String FILENAME = "song_preferences";
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ch1 = (CheckBox) findViewById(R.id.checkBox1);
//        ch2 = (CheckBox) findViewById(R.id.checkBox2);
//
//        b1 = (Button) findViewById(R.id.button1);
//        b2 = (Button) findViewById(R.id.button2);
//
//        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        ch1.setChecked(sharedPref.getBoolean(getString(R.string.rock), false));
//        ch2.setChecked(sharedPref.getBoolean(getString(R.string.jazz), false));
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ch1.setChecked(false);
//                ch2.setChecked(false);
//                sharedPref.edit().clear().apply();
//                finish();
//            }
//        });
//
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putBoolean(getString(R.string.rock), rock);
//        editor.putBoolean(getString(R.string.jazz), jazz);
//        editor.apply();
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//
//    public void startMethod(View v) {
//
//        DownloadManager downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
//        TunesBotUtil.downloadTrack(downloadManager,"http://localhost:8080/adserver/getad");
//        return;
//
////        StringBuilder result = new StringBuilder();
////        result.append("Rock : ").append(ch1.isChecked());
////        result.append("\nJazz: ").append(ch2.isChecked());
////        Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
////        rock = ch1.isChecked();
////        jazz = ch2.isChecked();
////        FileOutputStream fos = null;
////        try {
////            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
////            fos.write(result.toString().getBytes());
////        } catch (IOException e) {
////            e.printStackTrace();
////        } finally {
////            try {
////                if (fos != null) {
////                    fos.close();
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////        Intent intent = new Intent(this, DownloadService.class);
////        intent.putExtra(DownloadService.POP, ch1.isChecked());
////        intent.putExtra(DownloadService.ELECTRONIC, ch2.isChecked());
////        startService(intent);
//    }
//
////    public void startMethod(View v) {
////        Intent intent = new Intent(this, DownloadIndentService.class);
//////        intent.putExtra("url", "url of the file to download");
//////        startService(intent);
////        Toast.makeText(MainActivity.this, "Entered startMethod", Toast.LENGTH_LONG).show();
////        Log.i("Message*********", "Testttttttttt");
////        if (true) {
////            Toast.makeText(getBaseContext(), "I am on wifi", Toast.LENGTH_LONG).show();
////            // call AsynTask to perform network operation on separate thread
////            new HttpAsyncTask().execute("http://localhost:8080/music/getMusicList");
////        } else {
////            Toast.makeText(getBaseContext(), "I am not on Wifi", Toast.LENGTH_LONG).show();
////        }
////    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.android.sunshine.app/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.android.sunshine.app/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
//
//    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... urls) {
////            Toast.makeText(getBaseContext(), "Fetching latest tracks first", Toast.LENGTH_LONG).show();
//            return GET(urls[0]);
//        }
//
//        // onPostExecute displays the results of the AsyncTask.
//        @Override
//        protected void onPostExecute(String result) {
//            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
//            Toast.makeText(getBaseContext(), "title : " + result, Toast.LENGTH_LONG).show();
//
//            Log.i("Message", "Result*****" + result);
////            try {
////
////                JSONObject json = new JSONObject(result); // convert String to JSONObject
////
////                for (Map.Entry<String, Object> e: json.get(get()).entrySet()) {
////                        MusicConf musicConf = (MusicConf) e.getValue();
////                        String title = musicConf.getTitle();
////                        String artist = musicConf.getArtist();
////                        String trackId = musicConf.getTrackid();
////                        Toast.makeText(getBaseContext(), "title : " + title, Toast.LENGTH_LONG).show();
////                        Toast.makeText(getBaseContext(), "artist : " + artist, Toast.LENGTH_LONG).show();
////                        Toast.makeText(getBaseContext(), "track : " + trackId, Toast.LENGTH_LONG).show();
////                        if (checkIfFileExists(title + "_" + artist + ".mp3")) {
////
////                        } else {
////                            //download this song
////                        }
////
////                }
////            }
////            catch (JSONException e) {
////                e.printStackTrace();
////            }
//        }
//    }
//
//    public boolean checkIfFileExists(String fileName) {
//        File extStore = Environment.getExternalStorageDirectory();
//        File myFile = new File(extStore.getAbsolutePath() + "/my_music/" + fileName);
//
//        if (myFile.exists()) {
//            return true;
//        } else
//            return false;
//    }
//
//
//    public static String GET(String url) {
//        InputStream inputStream = null;
//        String result = "";
//        try {
//
//            // create HttpClient
//            HttpClient httpclient = new DefaultHttpClient();
//
//            // make GET request to the given URL
//            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
//
//            // receive response as inputStream
//            inputStream = httpResponse.getEntity().getContent();
//
//            // convert inputstream to string
//            if (inputStream != null)
//                result = convertInputStreamToString(inputStream);
//            else
//                result = "Did not work!";
//
//        } catch (Exception e) {
//            Log.d("InputStream", e.getLocalizedMessage());
//        }
//
//        return result;
//    }
//
//    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String line = "";
//        String result = "";
//        while ((line = bufferedReader.readLine()) != null)
//            result += line;
//
//        inputStream.close();
//        return result;
//
//    }
//
//    public boolean isConnected() {
//
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo ni = cm.getActiveNetworkInfo();
//        if (ni != null && ni.getType() == ConnectivityManager.TYPE_WIFI) {
//            return true;
//        } else
//            return false;
//    }
//}