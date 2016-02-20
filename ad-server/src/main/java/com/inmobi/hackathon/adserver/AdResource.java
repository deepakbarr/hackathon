package com.inmobi.hackathon.adserver;

import java.io.File;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by deepak.barr on 19/2/15.
 */

@Path("/adserver")
public class AdResource {

  public AdResource() {
  }

  //  http://localhost:8080/service/health

  @GET
  @Path("getAd")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response fetchAd() {
    String file = AdService.get().serveAd();
    return Response.ok(new File(file), MediaType.APPLICATION_OCTET_STREAM)
      .header("Content-Disposition", "attachment; filename=\"ad.mp3\"")
      .build();
  }

  @POST
  @Path("updateDownload")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void sendDow(String id) {
    AdService.get().incrementDownloads(Long.parseLong(id));
  }


//  @GET
//  @Path("test")
//  public String testAPI(@QueryParam("sleep") String sleep) {
//
//    try {
//
//      SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss.SSS");
//
//      final String logFile = "/var/log/request.log";
//
//      File file = new File(logFile);
//      if (!file.exists()) {
//        file.createNewFile();
//      }
//
//      FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
//      BufferedWriter bw = new BufferedWriter(fw);
//      bw.write("REQUEST :  received at " + formatter.format(new Date()) + "\n");
//      Thread.sleep(Integer.parseInt(sleep));
//      String response = "RESPONSE :  sent at " + formatter.format(new Date());
//      bw.write(response + "\n");
//      bw.close();
//
//      return response;
//    } catch (Exception e) {
//      e.printStackTrace();
//      return "ERROR";
//    }
//  }
//
//  @GET
//  @Path("getjson")
//  public TestBean getJson() {
//    TestBean tb = new TestBean();
//    tb.setF1("AAAA");
//    tb.setF2(Arrays.asList(new String[]{"1","2"}));
//    tb.setF3("CCCC");
//    return tb;
//  }
//
//  @GET
//  @Path("gone")
//  public TestBean getJsonException() {
//    throw new ClientErrorException("Its gone ", 410);
//  }
//
//  @POST
//  @Path("postjson")
//  @Produces(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
//  public TestBean postJson(TestBean tb) {
//    return tb;
//  }
}


