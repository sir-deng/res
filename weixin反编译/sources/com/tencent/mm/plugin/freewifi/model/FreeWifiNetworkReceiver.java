package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public b mKe;
    public a mKf;

    public interface a {
        void a(State state);
    }

    public interface b {
        void qp(int i);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            return;
        }
        String action = intent.getAction();
        x.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", action);
        if (bi.oN(action)) {
            x.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            x.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", Integer.valueOf(intent.getIntExtra("wifi_state", 0)));
            if (this.mKe != null) {
                this.mKe.qp(r0);
            }
        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                if (networkInfo != null && this.mKf != null) {
                    this.mKf.a(networkInfo.getState());
                }
            }
        }
    }
}
