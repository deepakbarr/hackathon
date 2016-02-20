package com.inmobi.hackathon.adserver;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by deepak.barr on 19/2/15.
 */
public class Output {

    @JsonProperty("output")
    private Map<String, String> keyValues = new HashMap<String, String>();

    public void put(String k, String v) {
        keyValues.put(k, v);
    }

    public String get(String k) {
        return keyValues.get(k);
    }

}
