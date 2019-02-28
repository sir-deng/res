package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;

class WiFiConnector$2 extends BroadcastReceiver {
    final /* synthetic */ a jBl;

    public WiFiConnector$2(a aVar) {
        this.jBl = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    NetworkInfo activeNetworkInfo = this.jBl.jBi.getActiveNetworkInfo();
                    WifiInfo connectionInfo = c.getConnectionInfo();
                    if (activeNetworkInfo != null && connectionInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.getDetailedState() == DetailedState.CONNECTED && connectionInfo.getNetworkId() == this.jBl.jBh.networkId) {
                        this.jBl.e(true, "");
                    }
                } else if ("android.net.wifi.supplicant.STATE_CHANGE".equals(action)) {
                    int intExtra;
                    try {
                        intExtra = intent.getIntExtra("supplicantError", -1);
                    } catch (Exception e) {
                        e.getMessage();
                        intExtra = -1;
                    }
                    if (intExtra == 1) {
                        this.jBl.e(false, "password error");
                    }
                }
            }
        }
    }
}
