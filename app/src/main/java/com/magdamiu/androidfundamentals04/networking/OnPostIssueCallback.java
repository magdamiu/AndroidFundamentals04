package com.magdamiu.androidfundamentals04.networking;

public interface OnPostIssueCallback {
    void onSuccess(Issue issue);
    void onError();
}