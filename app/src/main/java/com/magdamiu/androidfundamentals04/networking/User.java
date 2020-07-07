package com.magdamiu.androidfundamentals04.networking;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String username;

    private int id;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
