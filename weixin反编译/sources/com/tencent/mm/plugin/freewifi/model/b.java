package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    a mJI;
    BroadcastReceiver mJJ;

    private static class a {
        String bssid;
        long mJL;
        String mJM;
        String ssid;
        int type;

        private a() {
            this.ssid = "";
            this.bssid = "";
            this.mJM = "";
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final a aMe() {
            a aVar = new a();
            aVar.mJL = this.mJL;
            aVar.type = this.type;
            aVar.ssid = this.ssid;
            aVar.bssid = this.bssid;
            aVar.mJM = this.mJM;
            return aVar;
        }

        public final String toString() {
            return String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.mJL), Integer.valueOf(this.type), this.ssid, this.bssid, this.mJM});
        }
    }

    private static class b {
        private static b mJN = new b();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.mJI = new a();
        this.mJJ = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo == null) {
                            x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                            return;
                        }
                        x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable()));
                        if (!networkInfo.isConnected()) {
                            x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                        } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                            x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                        } else if (context == null) {
                            x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                        } else if (networkInfo.getType() == 1) {
                            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                            if (wifiManager == null) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManager is null.");
                                return;
                            }
                            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                            if (connectionInfo == null) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiInfo is null.");
                                return;
                            }
                            String Bg = m.Bg(connectionInfo.getSSID());
                            String toLowerCase = m.Bh(connectionInfo.getBSSID()).toLowerCase();
                            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", m.Bg(m.Bh(networkInfo.getExtraInfo())), Bg, toLowerCase);
                            if (!m.Bh(m.Bg(m.Bh(networkInfo.getExtraInfo()))).equals(Bg)) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                            } else if (b.this.mJI.type == 1 && m.Bh(b.this.mJI.ssid).equals(Bg) && m.Bh(b.this.mJI.bssid).equals(toLowerCase)) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                            } else {
                                a aVar = new a();
                                aVar.mJL = System.currentTimeMillis();
                                aVar.type = 1;
                                aVar.ssid = Bg;
                                aVar.bssid = toLowerCase;
                                aVar.mJM = "";
                                b.b(b.this.mJI.aMe(), aVar);
                                b.this.mJI = aVar;
                            }
                        } else if (networkInfo.getType() != 0) {
                        } else {
                            if (b.this.mJI.type == 0 && m.Bh(b.this.mJI.mJM).equals(m.Bh(networkInfo.getExtraInfo()))) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                                return;
                            }
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager == null) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                                return;
                            }
                            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                            if (networkInfo2 == null) {
                                x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                                return;
                            }
                            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", networkInfo2.getState(), networkInfo2.getDetailedState());
                            if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                                x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                                return;
                            }
                            a aVar2 = new a();
                            aVar2.mJL = System.currentTimeMillis();
                            aVar2.type = 0;
                            aVar2.ssid = "";
                            aVar2.bssid = "";
                            aVar2.mJM = m.Bh(networkInfo.getExtraInfo());
                            b.a(b.this.mJI.aMe(), aVar2);
                            b.this.mJI = aVar2;
                        }
                    } catch (Exception e) {
                        com.tencent.mm.plugin.freewifi.k.a aLL = k.aLL();
                        aLL.fqu = "UnExpectedException";
                        aLL.result = -1;
                        aLL.lfa = m.e(e);
                        aLL.aLN().aLM();
                        x.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(e));
                    }
                }
            }
        };
    }

    public final void aLz() {
        try {
            ad.getContext().unregisterReceiver(this.mJJ);
        } catch (IllegalArgumentException e) {
        }
    }

    static void a(a aVar, a aVar2) {
        m.Bl("on mobile connected.");
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        com.tencent.mm.plugin.freewifi.f.b.qq(0);
    }

    static void b(a aVar, a aVar2) {
        m.Bl("on wifi connected.");
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.Bl("on wifi roaming.");
            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", str, str2, str3);
        }
        com.tencent.mm.plugin.freewifi.f.b.qq(1);
    }
}
