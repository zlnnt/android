package com.zlnnt.myexample1;

import android.app.Service;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private final String TAG = this.getClass().getSimpleName();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        getContentResolver().registerContentObserver(Uri.parse("content://sms"),true, new MyOb(new Handler()));

    }

    public final class MyOb extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public MyOb(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
            while (cursor.moveToNext()){
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("body").append(cursor.getString(cursor.getColumnIndex("body")));
                Log.e(TAG, stringBuffer.toString());
            }
        }

    }
}
