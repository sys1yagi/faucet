package com.example.faucet.tasks;

import android.content.Context;
import android.os.AsyncTask;

public class EmptyTask extends AsyncTask<Void, Void, Void> {

    Context context;

    public EmptyTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }
}
