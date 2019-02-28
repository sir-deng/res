package com.tencent.mm.plugin.webview.wepkg.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.webview.wepkg.downloader.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a {
    private static int ngX = -1;
    private static a tSc;

    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (!as.Hp() || as.Cz()) {
                x.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                return;
            }
            int netType = ao.getNetType(ad.getContext());
            if (netType != a.ngX) {
                a.ngX = netType;
                x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = " + netType);
                if (netType == 0) {
                    boolean zR = g.Ag().zR();
                    if (bi.bz(Long.valueOf(bi.c((Long) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(0)))).longValue()) > 1800) {
                        netType = 1;
                    } else {
                        netType = 0;
                    }
                    if (netType == 0) {
                        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", Long.valueOf(1800));
                    }
                    if (!zR && netType != 0) {
                        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(bi.Wx()));
                        b txVar = new tx();
                        txVar.fNy.fql = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(txVar);
                        return;
                    }
                    return;
                }
                d.bVR().bVS();
            }
        }
    }

    public static void aQB() {
        if (tSc == null) {
            tSc = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ad.getContext().registerReceiver(tSc, intentFilter);
        } catch (Exception e) {
        }
        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
    }

    public static void aQC() {
        if (tSc != null) {
            try {
                ad.getContext().unregisterReceiver(tSc);
            } catch (Exception e) {
            }
        }
        tSc = null;
        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
    }
}
