package com.inmobi.hackathon.adserver.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by deepak.barr on 20/02/16.
 */
public class AdServerHealthCheck extends HealthCheck {
  @Override
  protected Result check() throws Exception {
    return Result.healthy();
  }
}
