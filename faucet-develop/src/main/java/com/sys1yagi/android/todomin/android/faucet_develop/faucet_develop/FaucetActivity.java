package com.sys1yagi.android.todomin.android.faucet_develop.faucet_develop;

import com.sys1yagi.android.todomin.android.faucet_develop.faucet_develop.model.User;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class FaucetActivity extends ActionBarActivity {

    //Primitive types is not tracked.
    private String ignoredValue;

    private float aFloat;

    //tracking!
    private Context checkedValue;

    private User user;

    private static User user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ignoredValue = "aaaa";
        checkedValue = this;
        user = new User();
        user.setId(10);
        user.setName("Tom");
        user.setName(null);
        aFloat = 4.3f;
        user2 = user;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
