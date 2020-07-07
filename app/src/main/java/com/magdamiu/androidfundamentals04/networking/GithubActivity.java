package com.magdamiu.androidfundamentals04.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.YuvImage;
import android.os.Bundle;
import android.widget.Toast;

import com.magdamiu.androidfundamentals04.R;

import java.util.List;

public class GithubActivity extends AppCompatActivity {

    private String token = "18e068d7b2171d4fc250b08fed13ce727a28188a";

    private UsersRepository usersRepository;
    private IssuesRepository issuesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        sendIssue();

        displayUsers();
    }

    private void displayUsers() {
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

    private void sendIssue() {
        Issue issue = new Issue();
        issue.setTitle("new issue july 7th");
        issue.setBody("let's learn retrofit");
        postIssue("magdamiu", "AndroidFundamentals04", token, issue);
    }

    private void postIssue(String user, String repo, String token, Issue issue) {
        issuesRepository = IssuesRepository.getInstance();

        issuesRepository.postIssue(new OnPostIssueCallback() {
            @Override
            public void onSuccess(Issue issueResult) {
                Toast.makeText(GithubActivity.this, issueResult.toString(), Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onError() {
                Toast.makeText(GithubActivity.this, "error posting an issue",
                        Toast.LENGTH_LONG).show();
            }
        }, user, repo, token, issue);
    }
}
