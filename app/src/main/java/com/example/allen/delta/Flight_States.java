package com.example.allen.delta;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by allam on 9/24/2016.
 */

public interface Flight_States {

    @GET("hack/status")
    Call<Flight_States_Class> getFlight(
            @Query("flightNumber") String flightNumber,
            @Query("flightOriginDate") String flightDepartureDate,
            @Query("apikey") String apiKey
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://demo30-test.apigee.net/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
