package com.example.faucet;

import com.example.faucet.model.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class DetailActivity extends ActionBarActivity {

    private final static String ARGS_USER = "user";

    public static Intent createIntent(Context context, User user) {
        Log.d("test", "createIntent");
        Intent intent = new Intent(context, DetailActivity.class);

        intent.putExtra(ARGS_USER, user);

        return intent;
    }

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        user = getIntent().getParcelableExtra(ARGS_USER);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
