package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static boolean jBa = false;
    private static WeakReference<a> jBb = null;
    private static b jBc = null;
    private static a jBd;
    private static Context mContext;

    public static void bZ(Context context) {
        if (!jBa && context != null) {
            mContext = context;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                c.bgP = wifiManager;
                jBa = true;
            }
        }
    }

    public static b aio() {
        WifiInfo connectionInfo = c.getConnectionInfo();
        String str = "";
        if (!(connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()))) {
            str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.tB(connectionInfo.getSSID());
        }
        if (jBc != null && jBc.jAT.compareTo(str) == 0) {
            return jBc;
        }
        if (connectionInfo == null) {
            return null;
        }
        aip();
        return jBc;
    }

    public static c aip() {
        c cVar = new c();
        jBc = null;
        if (jBa && c.isWifiEnabled()) {
            c.startScan();
            List<ScanResult> scanResults = c.getScanResults();
            cVar.jAZ = new ArrayList();
            cVar.jhM = "ok";
            if (scanResults != null) {
                String str;
                x.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", scanResults, Integer.valueOf(scanResults.size()));
                WifiInfo connectionInfo = c.getConnectionInfo();
                x.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", connectionInfo);
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                    str = null;
                } else {
                    str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.tB(connectionInfo.getSSID());
                }
                for (ScanResult scanResult : scanResults) {
                    if (scanResult != null) {
                        int a = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.a(scanResult);
                        if (a == 0 || a == 2) {
                            boolean z;
                            b bVar = new b();
                            bVar.jAT = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.tB(scanResult.SSID);
                            bVar.jAU = scanResult.BSSID;
                            int i = scanResult.level;
                            i = i <= -100 ? 0 : i >= -55 ? 99 : (int) ((((float) (i + 100)) * 99.0f) / 45.0f);
                            bVar.jAV = i;
                            if (a == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bVar.jAW = z;
                            if (str == null || bVar.jAT.compareTo(str) != 0) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i != 0) {
                                jBc = bVar;
                            }
                            cVar.jAZ.add(bVar);
                        }
                    }
                }
            } else {
                x.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (jBa) {
            cVar.jhM = "wifi is disable";
        } else {
            cVar.jhM = "sdk not init";
        }
        return cVar;
    }

    public static void C(String str, String str2, String str3) {
        int i;
        WifiConfiguration wifiConfiguration;
        WifiConfiguration wifiConfiguration2 = null;
        if (jBb != null) {
            a aVar = (a) jBb.get();
            if (!(aVar == null || aVar.aiq())) {
                aVar.tA("duplicated request");
            }
        }
        a aVar2 = new a(jBd, mContext);
        new StringBuilder("ssid:").append(str).append(" bssid:").append(str2).append(" psw:").append(str3);
        aVar2.jAT = str;
        aVar2.jAU = str2;
        if (TextUtils.isEmpty(str3)) {
            i = 0;
        } else {
            i = 2;
        }
        if (str == null || str.length() <= 0) {
            wifiConfiguration = null;
        } else {
            wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            wifiConfiguration.hiddenSSID = true;
            switch (i) {
                case 2:
                    if (str3.length() != 0) {
                        if (!str3.matches("[0-9A-Fa-f]{64}")) {
                            wifiConfiguration.preSharedKey = "\"" + str3 + '\"';
                            break;
                        } else {
                            wifiConfiguration.preSharedKey = str3;
                            break;
                        }
                    }
                    break;
                default:
                    wifiConfiguration.allowedKeyManagement.set(0);
                    break;
            }
            wifiConfiguration.status = 2;
        }
        List configuredNetworks = c.getConfiguredNetworks();
        if (configuredNetworks != null) {
            wifiConfiguration2 = b.a(str, i, configuredNetworks);
        }
        if (wifiConfiguration != null) {
            if (wifiConfiguration2 != null) {
                boolean z;
                if (b.aE(str, i)) {
                    c.saveConfiguration();
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    wifiConfiguration.networkId = b.b(wifiConfiguration);
                    if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.jBn) {
                        wifiConfiguration = wifiConfiguration2;
                    }
                }
            }
            if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.jBn) {
                wifiConfiguration.networkId = b.b(wifiConfiguration);
            }
            if (wifiConfiguration.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.jBn && aVar2.a(wifiConfiguration)) {
                aVar2.ld(1);
                aVar2.jBh = wifiConfiguration;
                if (!aVar2.jAP) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.setPriority(Integer.MAX_VALUE);
                    aVar2.jAQ = new WiFiConnector$2(aVar2);
                    aVar2.jBe.registerReceiver(aVar2.jAQ, intentFilter);
                    aVar2.jAP = true;
                }
                aVar2.mHandler.sendEmptyMessageDelayed(1, 13000);
                jBb = new WeakReference(aVar2);
            }
        }
        aVar2.e(false, "fail to connect wifi:invalid network id");
        jBb = new WeakReference(aVar2);
    }

    public static void a(a aVar) {
        jBd = aVar;
    }
}
