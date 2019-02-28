package com.tencent.mm.plugin.webview.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.List;

public class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.iHk, "WepkgVersion")};
    private static volatile d tSb = null;
    private final h hiZ;
    public final boolean jbr;

    public static d bVN() {
        if (!as.Hp()) {
            return new d(null);
        }
        if (tSb == null) {
            synchronized (d.class) {
                if (tSb == null || !tSb.jbr) {
                    as.Hm();
                    tSb = new d(c.Fc());
                }
            }
        }
        return tSb;
    }

    private d(h hVar) {
        super(hVar, c.iHk, "WepkgVersion", c.fNF);
        this.hiZ = hVar;
        this.jbr = hVar != null;
        if (!this.jbr) {
            x.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
    }

    public final c Qw(String str) {
        if (!this.jbr || bi.oN(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgVersion", "pkgId"}), str);
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", cVar.field_pkgId, cVar.field_version);
            return cVar;
        }
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", str);
        rawQuery.close();
        return null;
    }

    public final c Qx(String str) {
        if (!this.jbr || bi.oN(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgVersion", "pkgId", "disable"}), str);
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", cVar.field_pkgId, cVar.field_version, Boolean.valueOf(cVar.field_disableWvCache), Long.valueOf(cVar.field_clearPkgTime), Long.valueOf(cVar.field_checkIntervalTime), cVar.field_domain, Boolean.valueOf(cVar.field_bigPackageReady), Boolean.valueOf(cVar.field_preloadFilesReady), Boolean.valueOf(cVar.field_preloadFilesAtomic), Boolean.valueOf(cVar.field_disable));
            cVar.field_accessTime = com.tencent.mm.plugin.webview.wepkg.utils.d.amp();
            super.c(cVar, new String[0]);
            return cVar;
        }
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", str);
        rawQuery.close();
        return null;
    }

    public final List<WepkgVersion> bVO() {
        List<WepkgVersion> list = null;
        if (this.jbr) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s < ? - %s", new Object[]{"WepkgVersion", "accessTime", "clearPkgTime"}), String.valueOf(com.tencent.mm.plugin.webview.wepkg.utils.d.amp()));
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", r1);
            if (rawQuery == null) {
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    c cVar = new c();
                    cVar.b(rawQuery);
                    wepkgVersion.a(cVar);
                    list.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", Integer.valueOf(list.size()));
            } else {
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
            }
        }
        return list;
    }

    public final boolean Qv(String str) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c cVar = new c();
        cVar.field_pkgId = str;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(super.a(cVar, new String[0])));
        return super.a(cVar, new String[0]);
    }

    public final boolean Qy(String str) {
        if (!this.jbr) {
            return false;
        }
        com.tencent.mm.sdk.e.c Qw = Qw(str);
        if (Qw == null) {
            return false;
        }
        Qw.field_nextCheckTime = com.tencent.mm.plugin.webview.wepkg.utils.d.amp() + Qw.field_checkIntervalTime;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", str, Boolean.valueOf(super.c(Qw, new String[0])));
        return super.c(Qw, new String[0]);
    }

    public final boolean a(String str, boolean z, long j, long j2) {
        if (!this.jbr) {
            return false;
        }
        com.tencent.mm.sdk.e.c Qw = Qw(str);
        if (Qw == null) {
            return false;
        }
        Qw.field_disableWvCache = z;
        Qw.field_clearPkgTime = j;
        Qw.field_nextCheckTime = (Qw.field_nextCheckTime - Qw.field_checkIntervalTime) + j2;
        Qw.field_checkIntervalTime = j2;
        Qw.field_disable = false;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(super.c(Qw, new String[0])));
        return super.c(Qw, new String[0]);
    }

    public final boolean q(String str, String str2, boolean z) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Qw = Qw(str);
        if (Qw == null) {
            return false;
        }
        Qw.field_bigPackageReady = z;
        Qw.field_pkgPath = str2;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", str, str2, Boolean.valueOf(z), Boolean.valueOf(super.c(Qw, new String[0])));
        return super.c(Qw, new String[0]);
    }

    public final boolean aS(String str, boolean z) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Qw = Qw(str);
        if (Qw == null) {
            return false;
        }
        Qw.field_preloadFilesReady = z;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", str, Boolean.valueOf(z), Boolean.valueOf(super.c(Qw, new String[0])));
        return super.c(Qw, new String[0]);
    }

    public final boolean Qz(String str) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        boolean fD = fD("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str}));
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", Boolean.valueOf(fD));
        return true;
    }

    public final boolean QA(String str) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Qw = Qw(str);
        if (Qw == null) {
            return true;
        }
        Qw.field_disable = true;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", str, Boolean.valueOf(super.c(Qw, new String[0])));
        return super.c(Qw, new String[0]);
    }

    public final boolean QB(String str) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Qw = Qw(str);
        if (Qw == null) {
            return false;
        }
        Qw.field_createTime = 0;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", str, Boolean.valueOf(super.c(Qw, new String[0])));
        return super.c(Qw, new String[0]);
    }
}
