package com.inmobi.hackathon.adserver;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inmobi.hackathon.adserver.config.AdConfig;
import io.dropwizard.Configuration;
import lombok.Getter;

/**
 * Created by deepak.barr on 19/2/15.
 */
public class AdServerConfiguration  extends Configuration {
  @Valid
  @NotNull
  @JsonProperty
  @Getter
  AdConfig adConfig;
}
