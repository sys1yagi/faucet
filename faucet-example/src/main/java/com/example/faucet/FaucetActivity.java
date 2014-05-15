package com.example.faucet;

import com.example.faucet.model.User;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class FaucetActivity extends Activity {

    //Primitive types is not tracked.
    private String ignoredValue;

    private float aFloat;

    //tracking!
    private Context checkedValue;

    private User user;


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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
