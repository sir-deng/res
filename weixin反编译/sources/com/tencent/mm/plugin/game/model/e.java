package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static BroadcastReceiver ngV = null;
    private static boolean ngW = false;
    private static int ngX = -1;
    private static ag ngY = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    int netType = ao.getNetType(ad.getContext());
                    if (aVar != null && netType == 0) {
                        boolean cb = f.aAK().cb(aVar.fnS);
                        if (!cb) {
                            f.aAK().bY(aVar.fnS);
                            if (aVar.ngZ != null) {
                                e.b(aVar.ngZ);
                            }
                        }
                        x.i("MicroMsg.GameAutoDownloader", "resumeTask, ret = " + cb);
                        return;
                    }
                    return;
                case 2:
                    if (aVar != null) {
                        f.aAK().bY(aVar.fnS);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    private static class a {
        long fnS;
        t ngZ;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (!as.Hp() || as.Cz()) {
                x.e("MicroMsg.GameAutoDownloader", "acc has not ready");
                return;
            }
            int netType = ao.getNetType(ad.getContext());
            if (netType != e.ngX) {
                e.ngX = netType;
                x.i("MicroMsg.GameAutoDownloader", "onNetStateChange, netState = " + netType);
                LinkedList aRb = SubCoreGameCenter.aRK().aRb();
                if (!bi.cC(aRb)) {
                    e.N(aRb);
                    Iterator it;
                    t tVar;
                    if (netType == 0) {
                        it = aRb.iterator();
                        while (it.hasNext()) {
                            tVar = (t) it.next();
                            tVar.aQT();
                            e.a(tVar, false);
                        }
                        return;
                    }
                    it = aRb.iterator();
                    while (it.hasNext()) {
                        tVar = (t) it.next();
                        tVar.aQT();
                        e.e(tVar);
                    }
                }
            }
        }
    }

    static /* synthetic */ void N(LinkedList linkedList) {
        Object linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar.field_expireTime <= System.currentTimeMillis() / 1000) {
                x.i("MicroMsg.GameAutoDownloader", "expireTime expireTime = %d, currentTime = %d, appid = %s", Long.valueOf(tVar.field_expireTime), Long.valueOf(System.currentTimeMillis() / 1000), tVar.field_appId);
                FileDownloadTaskInfo yo = f.aAK().yo(tVar.field_appId);
                if (yo != null) {
                    x.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", Long.valueOf(yo.id), Integer.valueOf(yo.status));
                    if (yo.id > 0) {
                        Message message = new Message();
                        message.what = 2;
                        a aVar = new a();
                        aVar.fnS = yo.id;
                        aVar.ngZ = tVar;
                        message.obj = aVar;
                        ngY.sendMessageDelayed(message, 2000);
                    }
                    SubCoreGameCenter.aRK().a((c) tVar, new String[0]);
                    linkedList2.add(tVar);
                } else {
                    return;
                }
            }
        }
        if (!bi.cC(linkedList2)) {
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                linkedList.remove((t) it2.next());
            }
        }
    }

    static /* synthetic */ void e(t tVar) {
        FileDownloadTaskInfo yo = f.aAK().yo(tVar.field_appId);
        if (yo != null) {
            x.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask, downloadId = %d, status = %d", Long.valueOf(yo.id), Integer.valueOf(yo.status));
            if (yo.status == 1) {
                boolean ca = f.aAK().ca(yo.id);
                if (!ca) {
                    f.aAK().bY(yo.id);
                }
                x.i("MicroMsg.GameAutoDownloader", "pauseDownloadTask ret = " + ca);
            }
        }
    }

    public static void aQB() {
        if (ngV == null) {
            ngV = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ad.getContext().registerReceiver(ngV, intentFilter);
            ngW = true;
        } catch (Exception e) {
            x.e("MicroMsg.GameAutoDownloader", e.getMessage());
            ngW = false;
        }
    }

    public static void aQC() {
        if (ngV != null) {
            try {
                ad.getContext().unregisterReceiver(ngV);
            } catch (Exception e) {
                x.e("MicroMsg.GameAutoDownloader", e.getMessage());
            }
        }
        ngV = null;
        ngW = false;
    }

    public static void a(t tVar) {
        int i;
        tVar.aQT();
        if (tVar.nif == 0) {
            i = 0;
        } else {
            boolean i2 = true;
        }
        if (i2 == 0) {
            FileDownloadTaskInfo yo = f.aAK().yo(tVar.field_appId);
            x.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", Long.valueOf(yo.id), Integer.valueOf(yo.status));
            if (yo.id > 0) {
                f.aAK().bY(yo.id);
            }
            SubCoreGameCenter.aRK().a((c) tVar, new String[0]);
            return;
        }
        a(tVar, true);
    }

    private static void b(t tVar) {
        if (!as.Hp()) {
            x.e("MicroMsg.GameAutoDownloader", "MMCore is not ready");
        } else if (as.Cz()) {
            x.e("MicroMsg.GameAutoDownloader", "MMCore.isHold() = " + as.Cz());
        } else {
            boolean z;
            int i = tVar.nhP;
            as.Hm();
            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                x.e("MicroMsg.GameAutoDownloader", "sdCard is not available");
                z = false;
            } else if (com.tencent.mm.compatible.util.f.aD((long) i)) {
                z = true;
            } else {
                x.e("MicroMsg.GameAutoDownloader", "sdCard have not enough space, need size = " + i);
                z = false;
            }
            if (!z) {
                return;
            }
            if (bi.oN(tVar.nhN) || bi.oN(tVar.nhO) || bi.oN(tVar.field_appId)) {
                x.e("MicroMsg.GameAutoDownloader", "mAppDownloadURL = %s, mAppMD5 = %s, appId = %s", tVar.nhN, tVar.nhO, tVar.field_appId);
                return;
            }
            com.tencent.mm.pluginsdk.model.app.f aZ = g.aZ(tVar.field_appId, true);
            if (aZ == null) {
                x.e("MicroMsg.GameAutoDownloader", "appInfo = null");
                return;
            }
            x.i("MicroMsg.GameAutoDownloader", "startDownloadTask, appid = %s, url = %s, md5 = %s", tVar.field_appId, tVar.nhN, tVar.nhO);
            com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
            aVar.yr(tVar.nhN);
            aVar.setAppId(tVar.field_appId);
            aVar.cu(aZ.field_packageName);
            aVar.yt(g.a(ad.getContext(), aZ, null));
            aVar.yu(tVar.nhO);
            aVar.et(false);
            aVar.eu(false);
            aVar.oP(1);
            aVar.ev(true);
            long a = f.aAK().a(aVar.lyp);
            x.i("MicroMsg.GameAutoDownloader", "startDownloadTask id = " + a);
            if (a > 0) {
                n.a(tVar.nhN, tVar.nhO, 1999, tVar.field_appId, null, null);
            }
        }
    }

    private static void a(t tVar, boolean z) {
        if (bi.oN(tVar.field_appId)) {
            x.e("MicroMsg.GameAutoDownloader", "appid = " + tVar.field_appId);
            return;
        }
        x.i("MicroMsg.GameAutoDownloader", "addDownloadTask, appid = %s, initDownload = %s", tVar.field_appId, Boolean.valueOf(z));
        FileDownloadTaskInfo yo = f.aAK().yo(tVar.field_appId);
        if (yo == null) {
            return;
        }
        if (g.m(ad.getContext(), tVar.field_appId)) {
            SubCoreGameCenter.aRK().a((c) tVar, new String[0]);
            x.i("MicroMsg.GameAutoDownloader", "app is installed, appid = " + tVar.field_appId);
            return;
        }
        x.i("MicroMsg.GameAutoDownloader", "downloadId = %d, status = %d", Long.valueOf(yo.id), Integer.valueOf(yo.status));
        switch (yo.status) {
            case 0:
            case 4:
            case 5:
                if (ao.getNetType(ad.getContext()) == 0 && ngW) {
                    b(tVar);
                    return;
                }
                return;
            case 1:
                if (z && !yo.lyv) {
                    SubCoreGameCenter.aRK().a((c) tVar, new String[0]);
                    return;
                }
                return;
            case 2:
                if (!z || yo.lyv) {
                    Message message = new Message();
                    message.what = 1;
                    a aVar = new a();
                    aVar.fnS = yo.id;
                    aVar.ngZ = tVar;
                    message.obj = aVar;
                    ngY.sendMessageDelayed(message, 2000);
                    return;
                }
                SubCoreGameCenter.aRK().a((c) tVar, new String[0]);
                return;
            case 3:
                SubCoreGameCenter.aRK().a((c) tVar, new String[0]);
                return;
            default:
                return;
        }
    }
}
