package com.inmobi.hackathon.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.Object;
import java.util.Iterator;

public class JerseyClient {


    class Order {
        private String seller;
        private String orderId;
        private String status;
        private String lastUpdated;


        public Order() {
        }

        @Override
        public String toString() {
            return "Order{" +
                    "seller='" + seller + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", status='" + status + '\'' +
                    ", lastUpdated='" + lastUpdated + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://172.20.201.232:8080/service/orders");
            ClientResponse clientResponse = webResource.accept("application/json")
                    .get(ClientResponse.class);
            String jsonResponse = clientResponse.getEntity(String.class);

            System.out.println("jsonResponse = " + jsonResponse);

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(jsonResponse);
            JSONArray jsonArray = (JSONArray)obj;
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject order = (JSONObject) iterator.next();
                String seller = (String) order.get("seller");
                System.out.println(seller);
            }


//            ObjectMapper mapper = new ObjectMapper();
//            TypeFactory typeFactory=mapper.getTypeFactory();
//
//            List<Order> orders =
//                    mapper.readValue(jsonResponse, typeFactory.constructCollectionType(List.class, Order.class));

//            for(Order order:orders)
//                System.out.println(order);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}