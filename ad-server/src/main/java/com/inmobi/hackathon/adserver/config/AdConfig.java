package com.inmobi.hackathon.adserver.config;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by deepak.barr on 20/02/16.
 */
public class AdConfig {
  @Getter
  @Setter
  @JsonProperty
  @NotNull
  public String adContentLocation;
  @Getter
  @Setter
  @JsonProperty
  @NotNull
  public String adMetadataFile;
  @Getter
  @Setter
  @JsonProperty
  @NotNull
  public String adMetricsFile;
}
