package com.trainingcode.sample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BaseUrl="https://api.github.com";
  //  public static final String BaseUrl1="http://68.169.54.42:8080/portal_bsp/androidIntegrationAPI/";
    public static Retrofit retrofit=null;
    public static  Retrofit getApiClient(){
    if(retrofit == null) {
        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).
                addConverterFactory(GsonConverterFactory.create())
                .build();
    }
   return retrofit;
}

}