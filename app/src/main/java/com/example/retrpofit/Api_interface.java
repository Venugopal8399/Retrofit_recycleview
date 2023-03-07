package com.example.retrpofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_interface {
    private static Retrofit retrofit = null;
    public static Api getClient() {

        // change your base URL
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/users/") //Set the Root URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build(); //Finally building the adapter

        }
        //Creating object for our interface
        Api api = retrofit.create(Api.class);
        return api;
    }
}
