package com.zlnnt.myexample1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    private final String ACTION_BOOT = "com.zlnnt.myexample1.MY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(ACTION_BOOT.equals(intent.getAction())) {
            Toast.makeText(context, "OK!", Toast.LENGTH_SHORT).show();
        }

    }
}
