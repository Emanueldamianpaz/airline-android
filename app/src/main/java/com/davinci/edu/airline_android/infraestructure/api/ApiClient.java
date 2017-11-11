package com.davinci.edu.airline_android.infraestructure.api;

import android.os.StrictMode;

import com.davinci.edu.airline_android.infraestructure.models.Flight;
import com.davinci.edu.airline_android.infraestructure.models.User;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit;
    private ApiService service;
    private String responseRequest;
    private Gson jsonParser;

    public ApiClient() {
        jsonParser = new Gson();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/emanueldamianpaz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public boolean getUser(String username, String password) {

        Call<ResponseBody> result = service.getUsers();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        boolean authOk = false;
        try {
            responseRequest = result.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User[] users = jsonParser.fromJson(responseRequest, User[].class);

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authOk = true;
            }
        }

        return authOk;
    }


    public String getListFlightsAsync() {

        Call<ResponseBody> result = service.getFlightList();

        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseRequest = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseRequest = "";
                t.printStackTrace();
            }
        });

        return responseRequest;
    }

    public Flight[] getListFlights() {

        Call<ResponseBody> result = service.getFlightList();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            responseRequest = result.execute().body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Flight[] flightList = jsonParser.fromJson(responseRequest, Flight[].class);

        return flightList;
    }
}
