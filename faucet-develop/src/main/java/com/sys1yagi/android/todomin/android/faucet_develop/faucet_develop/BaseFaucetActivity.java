package com.sys1yagi.android.todomin.android.faucet_develop.faucet_develop;

import com.sys1yagi.android.todomin.android.faucet_develop.faucet_develop.model.User;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class BaseFaucetActivity extends ActionBarActivity {

    private User baseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseUser = new User();
    }
}
