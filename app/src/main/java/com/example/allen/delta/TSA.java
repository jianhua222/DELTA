package com.example.allen.delta;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Allen on 9/24/2016.
 */

public interface TSA {
    @GET("hack/tsa")
    Call<TSA_Class> getFlight(
            @Query("airport") String Airport,
            @Query("apikey") String apiKey
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://demo30-test.apigee.net/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
