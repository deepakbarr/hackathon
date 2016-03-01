package com.example.android.sunshine.app.util;

import android.app.DownloadManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.example.android.sunshine.app.Constants;
import com.example.android.sunshine.app.dto.MusicDTO;

import java.io.File;
import java.util.List;

/**
 * Created by deepak.barr on 21/02/16.
 */
public class TunesBotUtil {

    public boolean checkIfFileExists(String fileName) {
        File extStore = Environment.getExternalStorageDirectory();
        File myFile = new File(extStore.getAbsolutePath() + "/" + Constants.DOWNLOAD_DIR + "/" + fileName);
        return myFile.exists() ? true : false;
    }

    public static boolean isConnected(ConnectivityManager cm) {
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return (ni != null && ni.getType() == ConnectivityManager.TYPE_WIFI) ?true:false;
    }

    public static List<MusicDTO> getListOfTracks() {
        return null;
    }

    public static void downloadTrack(DownloadManager dwnldManager, String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDescription("Some descrition");
        request.setTitle("Some title");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "test.mp3");

        dwnldManager.enqueue(request);
        Log.i("Download","Request submitted");
    }
}
