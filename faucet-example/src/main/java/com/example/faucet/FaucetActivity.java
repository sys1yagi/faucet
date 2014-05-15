package com.example.faucet;

import com.example.faucet.model.User;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FaucetActivity extends Activity implements View.OnClickListener {

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
        findViewById(R.id.boot_button).setOnClickListener(this);
    }

    private void showDetailActivity(User user) {
        Intent intent = DetailActivity.createIntent(this, user);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boot_button:
                showDetailActivity(user);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
