package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass10;
import com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass11;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.bzh;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {

    private static class b {
        String rwO;
        List<String> tTJ;
        String version;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public interface a {
        void H(JSONObject jSONObject);
    }

    static /* synthetic */ boolean a(File file, Map map) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            File[] listFiles2 = file2.listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                List arrayList = new ArrayList();
                for (File file3 : listFiles2) {
                    b bVar = new b();
                    bVar.version = file3.getName();
                    String str = file3.getAbsolutePath() + File.separator + "package";
                    if (e.bO(str)) {
                        bVar.rwO = str;
                    }
                    File file4 = new File(file3.getAbsolutePath() + File.separator + "preload_files");
                    if (file4.isDirectory()) {
                        File[] listFiles3 = file4.listFiles();
                        if (listFiles3 == null || listFiles3.length == 0) {
                            arrayList.add(bVar);
                        } else {
                            List arrayList2 = new ArrayList();
                            for (File name : listFiles3) {
                                arrayList2.add(name.getName());
                            }
                            bVar.tTJ = arrayList2;
                            arrayList.add(bVar);
                        }
                    } else {
                        arrayList.add(bVar);
                    }
                }
                map.put(file2.getName(), arrayList);
            }
        }
        return true;
    }

    public static synchronized f QI(String str) {
        f fVar;
        synchronized (g.class) {
            String QV = d.QV(str);
            String QW = d.QW(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (bi.oN(QV) || bi.oN(QW)) {
                x.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", QV, QW);
                fVar = null;
            } else {
                fVar = com.tencent.mm.plugin.webview.wepkg.utils.b.tUt.QS(QV);
                if (fVar == null || fVar.tTq == null || !QW.equalsIgnoreCase(fVar.tTq.fNc)) {
                    WepkgVersion QO = h.QO(QV);
                    if (QO == null) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", QV, "", "");
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, QV, null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.BA(14));
                        fVar = null;
                    } else if (!QW.equalsIgnoreCase(QO.fNc)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", QV, QO.version, QW, QO.fNc);
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, QV, null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.BA(13));
                        fVar = null;
                    } else if (bi.oN(QO.version)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", QV);
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, QV, null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.BA(15));
                        fVar = null;
                    } else if (!QO.tUg || (!QO.tUh && QO.tUi)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", QO.tTK, QO.version, Boolean.valueOf(QO.tUg), Boolean.valueOf(QO.tUh), Boolean.valueOf(QO.tUi));
                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, QV, QO.version, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.BA(16));
                        fVar = null;
                    } else {
                        e eVar;
                        String str2 = QO.version;
                        String str3 = QO.iGz;
                        QW = QO.frM;
                        int i = QO.tUe;
                        if (bi.oN(QV) || bi.oN(str3) || bi.oN(QW)) {
                            x.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
                            eVar = null;
                        } else {
                            File file = new File(str3);
                            if (!file.exists()) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", str3);
                                QM(QV);
                                com.tencent.mm.plugin.webview.wepkg.utils.a.b("PkgModified", null, QV, str2, 1, 0, null);
                                eVar = null;
                            } else if (file.length() != ((long) i)) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", Integer.valueOf(i), Long.valueOf(file.length()));
                                file.delete();
                                QM(QV);
                                com.tencent.mm.plugin.webview.wepkg.utils.a.b("PkgModified", null, QV, str2, 2, 0, null);
                                eVar = null;
                            } else {
                                if (file.length() <= 5242880) {
                                    if (!QW.equalsIgnoreCase(com.tencent.mm.a.g.i(file))) {
                                        x.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", QW, com.tencent.mm.a.g.i(file));
                                        file.delete();
                                        QM(QV);
                                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("PkgModified", null, QV, str2, 3, 0, null);
                                        eVar = null;
                                    }
                                } else {
                                    x.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", Long.valueOf(file.length()), Long.valueOf(5242880));
                                }
                                e eVar2 = new e(file);
                                if (!eVar2.iHO || eVar2.tTn == null) {
                                    QJ(QV);
                                    eVar = null;
                                } else {
                                    eVar = eVar2;
                                }
                            }
                        }
                        if (eVar != null || bi.oN(QO.iGz)) {
                            Map aT = aT(QV, QO.tUi);
                            if (aT == null) {
                                com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, QV, QO.version, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.BA(18));
                                fVar = null;
                            } else {
                                fVar = new f(QO, eVar, aT);
                                com.tencent.mm.plugin.webview.wepkg.utils.b.tUt.tUv.put(QV, fVar);
                                x.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        } else {
                            com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", str, QV, QO.version, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.BA(17));
                            fVar = null;
                        }
                    }
                } else {
                    x.i("MicroMsg.Wepkg.WepkgManager", "memory has pkgid:%s record, version:%s", fVar.tTq.tTK, fVar.tTq.version);
                }
            }
        }
        return fVar;
    }

    public static void QJ(String str) {
        x.i("MicroMsg.Wepkg.WepkgManager", "clear all wepkg info, pkgid:%s", str);
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 2001;
        wepkgCrossProcessTask.tTq.tTK = str;
        if (ad.cgj()) {
            d.Dt().F(new com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass2(wepkgCrossProcessTask, null));
            return;
        }
        wepkgCrossProcessTask.jfW = new com.tencent.mm.plugin.webview.wepkg.model.h.AnonymousClass3(null, wepkgCrossProcessTask);
        wepkgCrossProcessTask.afy();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void QK(final String str) {
        c anonymousClass1 = new c() {
            public final void r(Message message) {
                final String string = message.getData().getString("used_wepkg_version");
                d.Dt().F(new Runnable() {
                    public final void run() {
                        int i = 0;
                        String QU = d.QU(str);
                        String str = "";
                        WepkgVersion QN = h.QN(str);
                        if (QN != null) {
                            str = QN.version;
                        }
                        x.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg, pkgid:%s, currVersion:%s, usedVersion:%s", str, str, string);
                        try {
                            if (bi.oN(string) && bi.oN(str)) {
                                g.QL(QU);
                                return;
                            }
                            File file = new File(QU);
                            if (file.exists() && !file.isFile()) {
                                File[] listFiles = file.listFiles();
                                if (listFiles == null || listFiles.length == 0) {
                                    file.delete();
                                    return;
                                }
                                int length = listFiles.length;
                                while (i < length) {
                                    File file2 = listFiles[i];
                                    if (file2.isFile()) {
                                        file2.delete();
                                    }
                                    if (!(!file2.isDirectory() || file2.getName().equalsIgnoreCase(string) || file2.getName().equalsIgnoreCase(str))) {
                                        x.i("MicroMsg.Wepkg.WepkgManager", "delete local path:%s", file2.getAbsolutePath());
                                        g.QL(file2.getAbsolutePath());
                                    }
                                    i++;
                                }
                            }
                        } catch (Exception e) {
                            x.i("MicroMsg.Wepkg.WepkgManager", "clearAllLocalWepkg err:" + e.getMessage());
                        }
                    }
                });
            }
        };
        Bundle bundle = new Bundle(1);
        bundle.putInt("call_cmd_type", 1);
        bundle.putString("call_pkg_id", str);
        WepkgProcessPreloadService.a(anonymousClass1, bundle);
    }

    private static Map<String, WepkgPreloadFile> aT(String str, boolean z) {
        if (bi.oN(str)) {
            return null;
        }
        Map<String, WepkgPreloadFile> hashMap = new HashMap();
        List<WepkgPreloadFile> QQ = h.QQ(str);
        if (bi.cC(QQ)) {
            return hashMap;
        }
        Object obj = null;
        for (WepkgPreloadFile wepkgPreloadFile : QQ) {
            if (wepkgPreloadFile != null) {
                if (bi.oN(wepkgPreloadFile.filePath)) {
                    x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", Boolean.valueOf(z));
                    if (z) {
                        fd(wepkgPreloadFile.tTK, wepkgPreloadFile.tTv);
                        obj = 1;
                    } else {
                        h.a(str, wepkgPreloadFile.tTv, "", null);
                    }
                } else {
                    File file = new File(wepkgPreloadFile.filePath);
                    if (!file.exists()) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", wepkgPreloadFile.filePath, Boolean.valueOf(z));
                        if (z) {
                            fd(wepkgPreloadFile.tTK, wepkgPreloadFile.tTv);
                            obj = 1;
                        } else {
                            h.a(str, wepkgPreloadFile.tTv, "", null);
                        }
                    } else if (file.length() != ((long) wepkgPreloadFile.size)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(file.length()), Boolean.valueOf(z));
                        if (z) {
                            fd(wepkgPreloadFile.tTK, wepkgPreloadFile.tTv);
                            file.delete();
                            obj = 1;
                        } else {
                            h.a(str, wepkgPreloadFile.tTv, "", null);
                        }
                    } else {
                        hashMap.put(wepkgPreloadFile.tTv, wepkgPreloadFile);
                    }
                }
            }
        }
        return obj != null ? null : hashMap;
    }

    public static boolean QL(String str) {
        try {
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName() + "_temp");
            if (file.renameTo(file2)) {
                e.g(file2);
                return true;
            }
        } catch (Exception e) {
            x.i("MicroMsg.Wepkg.WepkgManager", "safeDeleteDir err:" + e.getMessage());
        }
        return false;
    }

    public static void a(final a aVar) {
        final String str = com.tencent.mm.plugin.webview.wepkg.utils.b.OBJECT_ROOT_DIR_PATH;
        final File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            aVar.H(null);
        }
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 1001;
        wepkgCrossProcessTask.jfW = new Runnable() {
            public final void run() {
                if (wepkgCrossProcessTask.foB) {
                    d.Dt().F(new Runnable() {
                        public final void run() {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("rootDir", str);
                                Map hashMap = new HashMap();
                                g.a(file, hashMap);
                                JSONArray jSONArray = new JSONArray();
                                for (Entry entry : hashMap.entrySet()) {
                                    if (((List) entry.getValue()).size() != 0) {
                                        JSONArray jSONArray2;
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("pkgId", entry.getKey());
                                        WepkgVersion QN = h.QN((String) entry.getKey());
                                        if (QN != null) {
                                            jSONObject2.put("controlInfo", QN.bVX());
                                        }
                                        List<WepkgPreloadFile> QQ = h.QQ((String) entry.getKey());
                                        if (!bi.cC(QQ)) {
                                            jSONArray2 = new JSONArray();
                                            for (WepkgPreloadFile bVX : QQ) {
                                                jSONArray2.put(bVX.bVX());
                                            }
                                            jSONObject2.put("preloadFilesInfo", jSONArray2);
                                        }
                                        jSONArray2 = new JSONArray();
                                        for (b bVar : (List) entry.getValue()) {
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("version", bVar.version);
                                            if (!bi.oN(bVar.rwO)) {
                                                File file = new File(bVar.rwO);
                                                if (file.exists() && file.isFile()) {
                                                    jSONObject3.put("md5", com.tencent.mm.a.g.i(file));
                                                    jSONObject3.put("size", file.length());
                                                    bzh bzh = new e(file).tTn;
                                                    if (bzh != null) {
                                                        jSONObject3.put("charset", bzh.xgn);
                                                        jSONObject3.put("desc", bzh.nkL);
                                                        if (bzh.xgm != null) {
                                                            JSONArray jSONArray3 = new JSONArray();
                                                            Iterator it = bzh.xgm.iterator();
                                                            while (it.hasNext()) {
                                                                wh whVar = (wh) it.next();
                                                                JSONObject jSONObject4 = new JSONObject();
                                                                jSONObject4.put("rid", whVar.wnt);
                                                                jSONObject4.put("offset", whVar.wnu);
                                                                jSONObject4.put("size", whVar.kzt);
                                                                jSONObject4.put("mimeType", whVar.wnv);
                                                                jSONArray3.put(jSONObject4);
                                                            }
                                                            jSONObject3.put("resList", jSONArray3);
                                                        }
                                                    }
                                                }
                                            }
                                            List<String> list = bVar.tTJ;
                                            if (!bi.cC(list)) {
                                                JSONArray jSONArray4 = new JSONArray();
                                                for (String put : list) {
                                                    jSONArray4.put(put);
                                                }
                                                jSONObject3.put("preloadFiles", jSONArray4);
                                            }
                                            jSONArray2.put(jSONObject3);
                                        }
                                        jSONObject2.put("versionList", jSONArray2);
                                        jSONArray.put(jSONObject2);
                                    }
                                }
                                jSONObject.put("pkgList", jSONArray);
                                if (aVar != null) {
                                    aVar.H(jSONObject);
                                }
                            } catch (Exception e) {
                                if (aVar != null) {
                                    aVar.H(null);
                                }
                            }
                        }
                    });
                }
                wepkgCrossProcessTask.afz();
            }
        };
        wepkgCrossProcessTask.afy();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    private static void QM(String str) {
        if (!bi.oN(str)) {
            h.a(str, "", false, new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            });
        }
    }

    private static void fd(final String str, String str2) {
        if (!bi.oN(str) && !bi.oN(str2)) {
            final a anonymousClass5 = new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            };
            h.a(str, str2, "", new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    String str = str;
                    a aVar = anonymousClass5;
                    WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.pK = 3006;
                    wepkgCrossProcessTask.tTq.tTK = str;
                    wepkgCrossProcessTask.tTq.tUh = false;
                    if (ad.cgj()) {
                        d.Dt().F(new AnonymousClass10(wepkgCrossProcessTask, aVar));
                        return;
                    }
                    wepkgCrossProcessTask.jfW = new AnonymousClass11(aVar, wepkgCrossProcessTask);
                    wepkgCrossProcessTask.afy();
                    WepkgMainProcessService.a(wepkgCrossProcessTask);
                }
            });
        }
    }
}
