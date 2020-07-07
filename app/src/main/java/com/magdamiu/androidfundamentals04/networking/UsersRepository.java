package com.magdamiu.androidfundamentals04.networking;


import com.magdamiu.androidfundamentals04.BuildConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersRepository {

    private static UsersRepository usersRepository;

    private GithubApi githubApi;

    private UsersRepository(GithubApi api) {
        this.githubApi = api;
    }

    public static UsersRepository getInstance() {
        if (usersRepository == null) {
            Retrofit retrofit = RetrofitClient.getRetrofitClient();
            usersRepository = new UsersRepository(retrofit.create(GithubApi.class));
        }

        return usersRepository;
    }

    public void getUsers(final OnGetUsersCallback callback) {
        githubApi.getAllUsers()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (response.isSuccessful()) {
                            List<User> users = response.body();
                            if (users != null) {
                                callback.onSuccess(users);
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        callback.onError();
                    }
                });
    }
}