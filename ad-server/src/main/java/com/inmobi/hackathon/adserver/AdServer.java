package com.inmobi.hackathon.adserver;


import com.inmobi.hackathon.adserver.health.AdServerHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by deepak.barr on 19/2/15.
 */

public class AdServer extends Application<AdServerConfiguration> {
  public static void main(String[] args) throws Exception {
    new AdServer().run(args);
  }

  @Override
  public void initialize(Bootstrap<AdServerConfiguration> bootstrap) {


  }

  @Override
  public void run(AdServerConfiguration conf, Environment env) throws Exception {
    AdService.get().init(conf.adConfig);
    AdResource resource = new AdResource();
    env.jersey().register(resource);
    AdServerHealthCheck ingestionForumHealthCheck = new AdServerHealthCheck();
    env.healthChecks().register("ad-server", ingestionForumHealthCheck);
  }
}