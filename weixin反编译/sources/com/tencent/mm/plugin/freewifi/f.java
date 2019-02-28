package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    private WifiManager bni = ((WifiManager) ad.getContext().getSystemService("wifi"));
    private Context context;
    Condition fcU = this.mHC.newCondition();
    Lock mHC = new ReentrantLock();
    private BroadcastReceiver mHF;
    private int mHP = 10;

    public f(Context context) {
        this.context = context;
    }

    public final int aLB() {
        if (3 == this.bni.getWifiState()) {
            return 0;
        }
        this.mHF = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    x.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
                    if (intExtra == 3) {
                        try {
                            f.this.mHC.lock();
                            f.this.fcU.signalAll();
                        } finally {
                            f.this.aLz();
                            f.this.mHC.unlock();
                        }
                    }
                }
            }
        };
        try {
            this.mHC.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.mHF, intentFilter);
            this.bni.setWifiEnabled(true);
            if (this.fcU.await((long) this.mHP, TimeUnit.SECONDS)) {
                return 0;
            }
            aLz();
            this.mHC.unlock();
            return 1;
        } catch (InterruptedException e) {
            return 2;
        } finally {
            aLz();
            this.mHC.unlock();
            return 2;
        }
    }

    public final void aLz() {
        try {
            this.context.unregisterReceiver(this.mHF);
        } catch (IllegalArgumentException e) {
        }
    }
}
