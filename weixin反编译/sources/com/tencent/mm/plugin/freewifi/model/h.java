package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h {
    boolean kBN;
    a mKg;
    BroadcastReceiver mKh;

    private static class b {
        private static h mKj = new h();
    }

    public interface a {
        void aS(List<ScanResult> list);
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.kBN = false;
        this.mKh = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                int i = 0;
                if (context == null || intent == null) {
                    x.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
                    return;
                }
                h.this.kBN = false;
                context.unregisterReceiver(h.this.mKh);
                if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
                    if (wifiManager == null) {
                        x.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                        return;
                    }
                    List scanResults;
                    try {
                        scanResults = wifiManager.getScanResults();
                    } catch (SecurityException e) {
                        scanResults = new ArrayList(0);
                        x.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e.getMessage());
                    }
                    h hVar = h.this;
                    if (scanResults != null && scanResults.size() > 20) {
                        Collections.sort(scanResults, new Comparator<ScanResult>() {
                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                ScanResult scanResult = (ScanResult) obj;
                                ScanResult scanResult2 = (ScanResult) obj2;
                                if (scanResult.level < scanResult2.level) {
                                    return 1;
                                }
                                return scanResult.level == scanResult2.level ? 0 : -1;
                            }
                        });
                        scanResults = scanResults.subList(0, 20);
                    }
                    String str = "MicroMsg.FreeWifi.WifiScanReceiver";
                    StringBuilder stringBuilder = new StringBuilder("wifiManager scanResults size = ");
                    if (scanResults != null) {
                        i = scanResults.size();
                    }
                    x.i(str, stringBuilder.append(i).toString());
                    if (h.this.mKg != null) {
                        h.this.mKg.aS(scanResults);
                    }
                }
            }
        };
    }

    public final boolean a(a aVar) {
        if (this.kBN) {
            return false;
        }
        this.kBN = true;
        this.mKg = aVar;
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            return false;
        }
        ad.getContext().registerReceiver(this.mKh, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        return true;
    }
}
