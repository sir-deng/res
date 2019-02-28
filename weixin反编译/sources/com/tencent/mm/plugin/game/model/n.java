package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class n implements o, ITMQQDownloaderOpenSDKListener {
    private static n nht = null;
    private static BroadcastReceiver nhu = null;
    private static Set<b> nhv = Collections.synchronizedSet(new HashSet());
    private static HashMap<String, c> nhw = new HashMap();
    private static Map<Long, Long> nhx = new HashMap();

    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String action = intent.getAction();
                x.i("MicroMsg.GameInstallationReceiver", action);
                if (bi.oN(action)) {
                    x.e("MicroMsg.GameInstallationReceiver", "action is null or nill, ignore");
                } else if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                    action = "";
                    try {
                        action = intent.getDataString();
                    } catch (Throwable e) {
                        x.e("MicroMsg.GameInstallationReceiver", "%s", bi.i(e));
                    }
                    x.i("MicroMsg.GameInstallationReceiver", "get added package name : %s", action);
                    if (bi.oN(action)) {
                        x.e("MicroMsg.GameInstallationReceiver", "get installed broadcast, while the package name is null or nil");
                        return;
                    }
                    if (action.startsWith("package:")) {
                        action = action.substring(8);
                    }
                    if (!as.Hp() || as.Cz()) {
                        x.e("MicroMsg.GameInstallationReceiver", "no user login");
                    } else if (as.Hm() != null) {
                        com.tencent.mm.plugin.downloader.e.a aVar;
                        com.tencent.mm.plugin.downloader.e.b Fl = com.tencent.mm.y.c.Fl();
                        if (bi.oN(action)) {
                            x.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                            aVar = null;
                        } else {
                            Cursor rawQuery = Fl.rawQuery("select * from FileDownloadInfo where packageName='" + action + "' order by downloadId desc limit 1", new String[0]);
                            if (rawQuery == null) {
                                aVar = null;
                            } else {
                                com.tencent.mm.plugin.downloader.e.a aVar2 = null;
                                if (rawQuery.moveToFirst()) {
                                    aVar2 = new com.tencent.mm.plugin.downloader.e.a();
                                    aVar2.b(rawQuery);
                                }
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                aVar = aVar2;
                            }
                        }
                        if (aVar == null) {
                            x.e("MicroMsg.GameInstallationReceiver", "No AppInfo found for package: %s", action);
                            return;
                        }
                        if (e.bO(aVar.field_filePath)) {
                            com.tencent.mm.loader.stub.b.deleteFile(aVar.field_filePath);
                            com.tencent.mm.plugin.downloader.model.e.ym(aVar.field_appId);
                        }
                        if (!bi.oN(aVar.field_appId)) {
                            ap.a(aVar.field_appId, aVar.field_scene, 5, aVar.field_downloadedSize - aVar.field_startSize, aVar.field_totalSize, aVar.field_downloadUrl, 0, aVar.field_downloaderType, aVar.field_channelId, (System.currentTimeMillis() - aVar.field_startTime) / 1000, aVar.field_startState, aVar.field_downloadId);
                        }
                        c cVar = (c) n.nhw.get(aVar.field_downloadUrl);
                        if (cVar == null) {
                            x.e("MicroMsg.GameInstallationReceiver", "No ReportInfo found for url: %s", aVar.field_downloadUrl);
                            return;
                        }
                        if (bi.oN(cVar.fra)) {
                            cVar.fra = n.a(cVar);
                        }
                        ap.a(cVar.appId, cVar.scene, 5, cVar.frM, aVar.field_downloadUrl, cVar.nhB, cVar.fra);
                    }
                }
            }
        }
    }

    private static class c {
        String appId = "";
        String frM = "";
        String fra = "";
        String nhB = "";
        int scene = 0;

        c(String str, int i, String str2, String str3, String str4) {
            this.frM = str;
            this.scene = i;
            this.appId = str2;
            this.nhB = str3;
            this.fra = str4;
        }
    }

    public interface b {
        void h(int i, String str, boolean z);
    }

    private n() {
    }

    public static n aQN() {
        if (nht == null) {
            nht = new n();
        }
        return nht;
    }

    public static void a(b bVar) {
        synchronized (nhv) {
            nhv.add(bVar);
        }
    }

    public static void b(b bVar) {
        synchronized (nhv) {
            nhv.remove(bVar);
            x.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", Integer.valueOf(nhv.size()), bVar);
        }
    }

    public static void aQB() {
        if (nht == null) {
            nht = new n();
        }
        if (nhu == null) {
            nhu = new a();
        }
        f.aAK();
        com.tencent.mm.plugin.downloader.model.c.a(nht);
        bj.aRF();
        bj.registerListener(nht);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        ad.getContext().registerReceiver(nhu, intentFilter);
    }

    public static void aQC() {
        f.aAK();
        com.tencent.mm.plugin.downloader.model.c.b(nht);
        bj.aRF();
        bj.unregisterListener(nht);
        ad.getContext().unregisterReceiver(nhu);
        nht = null;
        nhv.clear();
        nhw.clear();
    }

    private void u(long j, int i) {
        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
        if (cf != null) {
            int i2 = 0;
            switch (i) {
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                    i2 = 3;
                    break;
                case 4:
                    i2 = 2;
                    break;
                case 5:
                    i2 = 8;
                    break;
                case 6:
                    break;
                case 7:
                    i2 = 7;
                    break;
            }
            if (!bi.oN(cf.field_appId)) {
                ap.a(cf.field_appId, cf.field_scene, i2, cf.field_downloadedSize - cf.field_startSize, cf.field_totalSize, cf.field_downloadUrl, cf.field_errCode, cf.field_downloaderType, cf.field_channelId, (System.currentTimeMillis() - cf.field_startTime) / 1000, cf.field_startState, cf.field_downloadId);
            }
            c cVar = (c) nhw.get(cf.field_downloadUrl);
            if (cVar == null) {
                x.e("MicroMsg.GameDownloadEventBus", "No report info found, abort reporting: %s", cf.field_downloadUrl);
            } else {
                if (bi.oN(cVar.fra)) {
                    cVar.fra = a(cVar);
                }
                ap.a(cVar.appId, cVar.scene, i2, cVar.frM, cf.field_downloadUrl, cVar.nhB, cVar.fra);
            }
            g(i, cf.field_appId, !cf.field_autoDownload);
        }
    }

    private void g(final int i, final String str, final boolean z) {
        ah.y(new Runnable() {
            public final void run() {
                synchronized (n.nhv) {
                    for (b h : n.nhv) {
                        h.h(i, str, z);
                    }
                }
            }
        });
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        if (!bi.oN(str)) {
            nhw.put(str, new c(str2, i, str3, "", str4));
        }
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5) {
        if (!bi.oN(str)) {
            nhw.put(str, new c(str2, i, str3, str4, str5));
        }
    }

    public final void onTaskStarted(long j, String str) {
        nhx.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        u(j, 1);
    }

    public final void c(long j, String str, boolean z) {
        if (bi.oN(str) || !e.bO(str)) {
            f.aAK().bY(j);
            return;
        }
        if (nhx.containsKey(Long.valueOf(j))) {
            long longValue = ((Long) nhx.get(Long.valueOf(j))).longValue();
            nhx.remove(Long.valueOf(j));
            longValue = (System.currentTimeMillis() - longValue) / 1000;
            com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
            if (cf != null) {
                x.i("MicroMsg.GameDownloadEventBus", "appId = %s, downloadType = %d, costTime = %d", cf.field_appId, Integer.valueOf(cf.field_downloaderType), Long.valueOf(longValue));
                ap.a(ad.getContext(), cf.field_appId, longValue, cf.field_downloaderType);
            }
        }
        u(j, 3);
        if (z) {
            com.tencent.mm.plugin.downloader.e.a cf2 = com.tencent.mm.plugin.downloader.model.e.cf(j);
            if (cf2 != null) {
                String str2 = cf2.field_appId;
                SubCoreGameCenter.aRN();
                z.b(str2, 5, 0, null, null);
            }
        }
    }

    public final void c(long j, int i, boolean z) {
        nhx.remove(Long.valueOf(j));
        u(j, 5);
        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
        if (cf != null) {
            String str = null;
            if (i == d.lxL) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ChannelId", cf.field_channelId);
                    jSONObject.put("DownloadSize", cf.field_downloadedSize);
                    str = ap.CD(jSONObject.toString());
                    x.d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                } catch (Exception e) {
                    x.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e.getMessage());
                }
            }
            a(cf.field_appId, i, z, str);
        }
    }

    public final void onTaskRemoved(long j) {
        int i = 0;
        nhx.remove(Long.valueOf(j));
        u(j, 4);
        com.tencent.mm.plugin.downloader.e.a cf = com.tencent.mm.plugin.downloader.model.e.cf(j);
        if (cf != null) {
            Context context = ad.getContext();
            CharSequence charSequence = cf.field_appId;
            SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
            String string = sharedPreferences.getString("download_app_id_time_map", "");
            if (!bi.oN(string) && string.contains(charSequence)) {
                String str = new String();
                String[] split = string.split(",");
                while (i < split.length) {
                    String str2 = split[i];
                    if (!str2.contains(charSequence)) {
                        str = i == split.length + -1 ? str + str2 : str + str2 + ",";
                    }
                    i++;
                }
                sharedPreferences.edit().putString("download_app_id_time_map", str).apply();
            }
        }
    }

    public final void onTaskPaused(long j) {
        nhx.remove(Long.valueOf(j));
        u(j, 2);
    }

    public final void cl(long j) {
        u(j, 6);
    }

    public final void k(long j, String str) {
        u(j, 7);
    }

    public final void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i, int i2, String str) {
        int i3 = 2;
        x.i("MicroMsg.GameDownloadEventBus", "OnDownloadTaskStateChanged, status = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i2 == 0) {
            switch (i) {
                case 1:
                case 2:
                    i3 = 1;
                    break;
                case 3:
                    break;
                case 4:
                    i3 = 3;
                    break;
                case 5:
                    i3 = 5;
                    break;
                case 6:
                    i3 = 4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                g(i3, tMQQDownloaderOpenSDKParam.taskPackageName, true);
            }
        }
    }

    public final void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j, long j2) {
    }

    public final void OnQQDownloaderInvalid() {
    }

    public final void OnServiceFree() {
    }

    private static String a(c cVar) {
        com.tencent.mm.plugin.downloader.e.a yk = com.tencent.mm.plugin.downloader.model.e.yk(cVar.appId);
        if (yk == null) {
            return null;
        }
        if (yk.field_downloaderType == 1) {
            return "downloader_type_system";
        }
        return "downloader_type_tmassistant";
    }

    public static void a(String str, int i, boolean z, String str2) {
        if (i == 710 || i == 711) {
            i = d.lxN;
        }
        x.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", str, Integer.valueOf(i));
        if (z) {
            SubCoreGameCenter.aRN();
            z.b(str, 4, i, null, str2);
            return;
        }
        SubCoreGameCenter.aRN();
        z.b(str, 2, i, null, str2);
    }

    public static void cR(String str, String str2) {
        SubCoreGameCenter.aRN();
        z.b(str, 6, 0, null, str2);
    }
}
