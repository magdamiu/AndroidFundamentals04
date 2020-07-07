package com.magdamiu.androidfundamentals04.networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {
    @GET("/users")
    Call<List<User>> getAllUsers();
}
