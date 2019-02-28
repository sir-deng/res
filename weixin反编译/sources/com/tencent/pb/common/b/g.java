package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class g {
    private NetworkInfo gzP = null;
    private WifiInfo gzQ = null;
    private int zVL = 1;

    public final synchronized boolean wL() {
        boolean z;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) d.syL.getSystemService("connectivity");
                if (connectivityManager == null) {
                    c.m("NetworkChangeMgr", "can't get ConnectivityManager");
                    this.zVL = 1;
                    this.gzQ = null;
                    this.gzP = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.zVL = 1;
                        this.gzQ = null;
                        this.gzP = null;
                        z = true;
                    } else {
                        int i;
                        c.d("NetworkChangeMgr", "NetworkChangeMgr ", activeNetworkInfo);
                        if (!activeNetworkInfo.isConnected()) {
                            i = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            wifiInfo = ((WifiManager) d.syL.getSystemService("wifi")).getConnectionInfo();
                            i = 2;
                        } else {
                            i = 3;
                        }
                        if (i == this.zVL) {
                            if (i == 1) {
                                z = false;
                            } else if (i == 2) {
                                if (wifiInfo != null && this.gzQ != null && this.gzQ.getBSSID().equals(wifiInfo.getBSSID()) && this.gzQ.getSSID().equals(wifiInfo.getSSID()) && this.gzQ.getNetworkId() == wifiInfo.getNetworkId()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (this.gzP != null && this.gzP.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.gzP.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.gzP.getSubtype() == activeNetworkInfo.getSubtype() && this.gzP.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.gzP != null && this.gzP.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.gzP.getSubtype() == activeNetworkInfo.getSubtype() && this.gzP.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.zVL = i;
                            this.gzQ = wifiInfo;
                            this.gzP = activeNetworkInfo;
                        }
                        z = true;
                        this.zVL = i;
                        this.gzQ = wifiInfo;
                        this.gzP = activeNetworkInfo;
                    }
                }
            } catch (Exception e) {
                c.m("NetworkChangeMgr", e);
                this.zVL = 1;
                this.gzQ = null;
                this.gzP = null;
                z = true;
            }
        }
        return z;
    }
}
