package com.example.faucet.tasks;

import android.content.Context;
import android.os.AsyncTask;

public class LeakTask extends AsyncTask<Void, Void, Void> {

    Context context;

    public LeakTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }
}
