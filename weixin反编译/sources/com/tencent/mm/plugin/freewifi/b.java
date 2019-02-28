package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    private WifiManager bni;
    private Context context;
    Condition fcU;
    private long hoU = 15000;
    Lock mHC;
    boolean mHD = false;
    boolean mHE = false;
    private BroadcastReceiver mHF;
    String ssid;

    public b(String str, Context context) {
        this.ssid = str;
        this.mHC = new ReentrantLock();
        this.fcU = this.mHC.newCondition();
        this.bni = (WifiManager) context.getSystemService("wifi");
        this.context = context;
    }

    public final int aLA() {
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.aMn())) {
            return 0;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        }
        this.mHF = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                NetworkInfo networkInfo;
                if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                    networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", b.this.ssid, m.Bi("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                    }
                    if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && b.this.ssid.equals(m.Bg(networkInfo.getExtraInfo()))) {
                        try {
                            b.this.mHC.lock();
                            b.this.mHD = true;
                            x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                            b.this.fcU.signalAll();
                        } finally {
                            b.this.mHC.unlock();
                        }
                    }
                } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", b.this.ssid, m.Bi("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
                    }
                    if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && b.this.ssid.equals(m.Bg(networkInfo.getExtraInfo()))) {
                        try {
                            b.this.mHC.lock();
                            b.this.mHE = true;
                            x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                            b.this.fcU.signalAll();
                        } finally {
                            b.this.mHC.unlock();
                        }
                    }
                }
            }
        };
        try {
            int aLB;
            this.mHC.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.context.registerReceiver(this.mHF, intentFilter);
            if (!this.bni.isWifiEnabled()) {
                aLB = new f(this.context).aLB();
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + aLB);
                if (aLB != 0) {
                    return aLB;
                }
            }
            aLB = d.Bp(this.ssid);
            if (aLB != 0) {
                aLz();
                aLz();
                this.mHC.unlock();
                return aLB;
            }
            boolean z = false;
            while (true) {
                if (!this.mHD || !this.mHE) {
                    long currentTimeMillis = System.currentTimeMillis();
                    z = this.fcU.await(this.hoU, TimeUnit.MILLISECONDS);
                    if (!z) {
                        break;
                    }
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    this.hoU -= currentTimeMillis;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.hoU);
                    this.hoU = this.hoU > 0 ? this.hoU : 3000;
                } else {
                    break;
                }
            }
            if (!z) {
                return -16;
            }
            aLz();
            this.mHC.unlock();
            return 0;
        } catch (InterruptedException e) {
            x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", e.getMessage());
            return -17;
        } finally {
            aLz();
            this.mHC.unlock();
            return -17;
        }
    }

    private void aLz() {
        try {
            this.context.unregisterReceiver(this.mHF);
        } catch (IllegalArgumentException e) {
        }
    }
}
