package com.example.retrpofit;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    // API's endpoints
    @GET("/users")
            Call<List<POJO>> getUsersList();

// UserListResponse is POJO class to get the data from API, In above method we use List<UserListResponse> because the data in our API is starting from JSONArray and callback is used to get the response from api and it will set it in our POJO class

}