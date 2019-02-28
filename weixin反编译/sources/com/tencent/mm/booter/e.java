package com.tencent.mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    NetworkInfo gzP = null;
    WifiInfo gzQ = null;

    final boolean wL() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                x.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.gzP = null;
                this.gzQ = null;
                return false;
            }
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                x.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                x.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.gzP = null;
                this.gzQ = null;
                return false;
            }
            WifiInfo connectionInfo;
            int i = activeNetworkInfo.getType() == 1 ? 1 : 0;
            if (i != 0) {
                connectionInfo = ((WifiManager) aa.getContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && this.gzQ != null && this.gzQ.getBSSID().equals(connectionInfo.getBSSID()) && this.gzQ.getSSID().equals(connectionInfo.getSSID()) && this.gzQ.getNetworkId() == connectionInfo.getNetworkId()) {
                    x.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                    return false;
                }
                x.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s", connectionInfo);
                x.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s", this.gzQ);
            } else if (this.gzP != null && this.gzP.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.gzP.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.gzP.getSubtype() == activeNetworkInfo.getSubtype() && this.gzP.getType() == activeNetworkInfo.getType()) {
                x.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else if (this.gzP != null && this.gzP.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.gzP.getSubtype() == activeNetworkInfo.getSubtype() && this.gzP.getType() == activeNetworkInfo.getType()) {
                x.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else {
                connectionInfo = null;
            }
            if (i == 0) {
                x.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", activeNetworkInfo);
                if (this.gzP != null) {
                    x.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.gzP);
                }
            }
            this.gzP = activeNetworkInfo;
            this.gzQ = connectionInfo;
            return true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NetworkChangeMgr", e2, "", new Object[0]);
        }
    }
}
