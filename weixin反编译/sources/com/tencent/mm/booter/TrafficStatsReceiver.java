package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bh.update();
        if (this.mLastTime >= 0) {
            long j = elapsedRealtime - this.mLastTime;
            long cgX = bh.cgX() + bh.cgW();
            long cgV = bh.cgV() + bh.cgU();
            long chb = bh.chb() + bh.cha();
            long chb2 = bh.chb() + bh.cha();
            x.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", Long.valueOf(j), Long.valueOf(cgX), Long.valueOf(cgV), Double.valueOf(((double) (cgX + cgV)) / ((double) (j / 1000))), Long.valueOf(chb), Long.valueOf(chb2), Double.valueOf(((double) (chb + chb2)) / ((double) (j / 1000))));
        }
        this.mLastTime = elapsedRealtime;
    }

    public static void aF(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
        x.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", Long.valueOf(300000));
    }

    public static void aG(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), SQLiteDatabase.CREATE_IF_NECESSARY));
    }
}
