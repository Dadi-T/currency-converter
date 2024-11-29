package com.donkillha;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.json.JSONObject;

public class Helpers {
    private String api_uri = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/";
    private String currency;
    
    public Helpers(String currency) {
        this.currency = currency;
    }

    private HttpResponse<String> apiCall() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api_uri + this.currency + ".json")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public float getConversion(String currencyToConvertTo){
        HttpResponse<String> response= apiCall();
        JSONObject jo = new JSONObject(response.body());
        float conversionRate = jo.getJSONObject("eur").getFloat(currencyToConvertTo);
        return conversionRate;
    }

    public Object[] getCurrencies() {
        HttpResponse<String> response = apiCall();
        JSONObject jo = new JSONObject(response.body());
        List<Object> currencies = jo.getJSONObject(this.currency).names().toList();
        return currencies.toArray();
    }

    public static void print(String message) {
        System.out.println(message);
    }

}
