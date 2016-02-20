package com.inmobi.hackathon.adserver.dao;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import com.google.common.collect.Maps;
import com.inmobi.hackathon.adserver.config.AdConfig;

/**
 * Created by deepak.barr on 20/02/16.
 */
public class AdDAOImpl implements AdDAO {

  Map<Long, String> adMetrics = Maps.newHashMap();
  Map<Long, String> adMetadata = Maps.newHashMap();

  public AdDAOImpl(AdConfig conf) {
    adMetadata = loadIntoMap(conf.getAdMetadataFile(), ",");
    adMetrics = loadIntoMap(conf.getAdMetricsFile(), ".");
  }

  private Map<Long, String> loadIntoMap(String file, String separator) {

    BufferedReader br = null;
    String line = "";
    try {
      Map<Long, String> map = Maps.newConcurrentMap();
      br = new BufferedReader(new FileReader(file));
      while ((line = br.readLine()) != null) {
        String[] tokens = line.split(separator);
        map.put(Long.parseLong(tokens[0]), tokens[1]);
      }
      return map;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public String getAdLocation(long id) {
    return adMetadata.get(id);
  }

  public int totalAds() {
    return adMetadata.size();
  }

  public long getAdDownloads(long id) {
    return Long.parseLong(adMetrics.get(id));
  }

  public void setAdDownloads(long id, long downloads) {
    adMetrics.put(id, String.valueOf(downloads));
  }
}
