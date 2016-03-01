package com.example.android.sunshine.app;

import android.app.DownloadManager;

import com.example.android.sunshine.app.dto.MusicDTO;
import com.example.android.sunshine.app.util.TunesBotUtil;

import java.util.List;

/**
 * Created by deepak.barr on 29/02/16.
 */
public class UserActions {

    public static void download(DownloadManager downloadManager) {
        List<MusicDTO> trackList = TunesBotUtil.getListOfTracks();
        for (MusicDTO track : trackList) {
            TunesBotUtil.downloadTrack(downloadManager, track.getDownloadUrl());
        }
    }
}
