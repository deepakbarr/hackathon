package com.inmobi.hackathon.client;

import java.util.List;

import lombok.Data;

//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by deepak.barr on 06/07/15.
 */
@Data
public class TestBean {
  @Override
  public String toString() {
    return "TestBean{" +
      "f1='" + f1 + '\'' +
      ", f2=" + f2 +
      ", f3='" + f3 + '\'' +
      '}';
  }

  private String f1;
  private List<String> f2;
  private String f3;
//
//  @JsonProperty
//  public String getF1() {
//    return f1;
//  }
//  @JsonProperty
//  public void setF1(String f1) {
//    this.f1 = f1;
//  }
//  @JsonProperty
//  public String getF2() {
//    return f2;
//  }
//  @JsonProperty
//  public void setF2(String f2) {
//    this.f2 = f2;
//  }
//  @JsonProperty
//  public String getF3() {
//    return f3;
//  }
//  @JsonProperty
//  public void setF3(String f3) {
//    this.f3 = f3;
//  }
}
