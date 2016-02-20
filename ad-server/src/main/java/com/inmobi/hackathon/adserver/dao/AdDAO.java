package com.inmobi.hackathon.adserver.dao;

/**
 * Created by deepak.barr on 20/02/16.
 */
public interface AdDAO{
  String getAdLocation(long id);
  int totalAds();
  long getAdDownloads(long id);
  void setAdDownloads(long id, long downloads);
}
