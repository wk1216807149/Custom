package com.wuli.custom;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=getApplicationContext();
        nitificationTest();
    }
    public void nitificationTest(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher_background);
        Notification notification=builder.build();
        NotificationManager notificationManager=(NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(200,notification);

    }
}
