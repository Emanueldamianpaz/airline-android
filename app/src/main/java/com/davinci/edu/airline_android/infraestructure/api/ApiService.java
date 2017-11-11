package com.davinci.edu.airline_android.infraestructure.api;


import com.davinci.edu.airline_android.infraestructure.models.Flight;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("demo/flightList")
    Call<ResponseBody> getFlightList();

    @GET("demo/users")
    Call<ResponseBody> getUsers();

    @GET("demo/flightList/{id}")
    Call<Flight> getFlight(@Path("id") String id);

}
