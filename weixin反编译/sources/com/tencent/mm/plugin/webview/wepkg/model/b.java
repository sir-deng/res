package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public class b {
    private static b tSX = null;

    static /* synthetic */ void a(b bVar, final String str) {
        if (!bi.oN(str)) {
            c anonymousClass2 = new c() {
                public final void r(Message message) {
                    final String string = message.getData().getString("used_wepkg_version");
                    d.Dt().F(new Runnable() {
                        public final void run() {
                            if (!bi.oN(string)) {
                                return;
                            }
                            if (g.QL(d.QU(str))) {
                                com.tencent.mm.plugin.webview.wepkg.a.d.bVN().Qv(str);
                                com.tencent.mm.plugin.webview.wepkg.a.b.bVM().Qv(str);
                                x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg success. pkgid:%s", str);
                                return;
                            }
                            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg fail. pkgid:%s", str);
                        }
                    });
                }
            };
            Bundle bundle = new Bundle(1);
            bundle.putInt("call_cmd_type", 1);
            bundle.putString("call_pkg_id", str);
            WepkgProcessPreloadService.a(anonymousClass2, bundle);
        }
    }

    public static synchronized b bVV() {
        b bVar;
        synchronized (b.class) {
            if (tSX == null) {
                synchronized (b.class) {
                    if (tSX == null) {
                        tSX = new b();
                    }
                }
            }
            bVar = tSX;
        }
        return bVar;
    }

    public final synchronized void bVW() {
        boolean z = true;
        synchronized (this) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("we_pkg_sp", 0);
            if (System.currentTimeMillis() - sharedPreferences.getLong("clean_wepkg_time", 0) <= 86400000) {
                z = false;
            }
            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg, allowClean:%b", Boolean.valueOf(z));
            if (z) {
                sharedPreferences.edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
                e.post(new Runnable() {
                    public final void run() {
                        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.pK = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
                        if (ad.cgj()) {
                            wepkgCrossProcessTask.YA();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                        List<WepkgVersion> list = wepkgCrossProcessTask.tTr;
                        if (bi.cC(list)) {
                            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
                            return;
                        }
                        x.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", Integer.valueOf(list.size()));
                        for (WepkgVersion wepkgVersion : list) {
                            if (wepkgVersion != null) {
                                b.a(b.this, wepkgVersion.tTK);
                            }
                        }
                    }
                }, "clean_wepkg");
            }
        }
    }
}
