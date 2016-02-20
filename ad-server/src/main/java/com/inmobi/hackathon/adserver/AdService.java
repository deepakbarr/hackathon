package com.inmobi.hackathon.adserver;

import java.util.Random;

import com.inmobi.hackathon.adserver.config.AdConfig;
import com.inmobi.hackathon.adserver.dao.AdDAO;
import com.inmobi.hackathon.adserver.dao.AdDAOImpl;

/**
 * Created by deepak.barr on 20/02/16.
 */
public enum AdService {
  INSTANCE;
  private AdDAO dao;
  boolean isInitialized;
  AdConfig conf;

  public static AdService get() {
    return INSTANCE;
  }

  public void init(AdConfig conf) {
    if (!isInitialized) {
      dao = new AdDAOImpl(conf);
      this.conf = conf;
    }
  }

  public String serveAd() {
    int totalAds = dao.totalAds();
    long id = new Random().nextInt(totalAds);
    String adloc = conf.getAdContentLocation() + "/" + dao.getAdLocation(id);
    return adloc;
  }

  public synchronized void incrementDownloads(long id) {
    long downloads = dao.getAdDownloads(id);
    dao.setAdDownloads(id, downloads + 1);
  }
}
