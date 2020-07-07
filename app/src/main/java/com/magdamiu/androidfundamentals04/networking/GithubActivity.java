package com.magdamiu.androidfundamentals04.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.YuvImage;
import android.os.Bundle;
import android.widget.Toast;

import com.magdamiu.androidfundamentals04.R;

import java.util.List;

public class GithubActivity extends AppCompatActivity {

    private UsersRepository usersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        usersRepository = UsersRepository.getInstance();
        usersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                StringBuilder stringBuilder = new StringBuilder();
                for(User user: users) {
                    stringBuilder.append(user.toString() + " /n ");
                }
                Toast.makeText(GithubActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError() {
                  Toast.makeText(GithubActivity.this, "NOT OK", Toast.LENGTH_LONG).show();
            }
        });
    }
}
