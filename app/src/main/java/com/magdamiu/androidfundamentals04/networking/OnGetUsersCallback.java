package com.magdamiu.androidfundamentals04.networking;

import java.util.List;

public interface OnGetUsersCallback {

    void onSuccess(List<User> users);

    void onError();
}