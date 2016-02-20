package com.inmobi.hackathon.adserver;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by deepak.barr on 19/2/15.
 */

public class Messages {

    @JsonProperty
    private String health;
    @JsonProperty
    private String hello;

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
