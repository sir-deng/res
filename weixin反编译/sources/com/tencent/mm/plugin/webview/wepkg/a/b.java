package com.tencent.mm.plugin.webview.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.List;

public class b extends i<a> {
    public static final String[] gLy = new String[]{i.a(a.iHk, "WepkgPreloadFiles")};
    private static volatile b tSa = null;
    private final h hiZ;
    public final boolean jbr;

    public static b bVM() {
        if (!as.Hp()) {
            return new b(null);
        }
        if (tSa == null) {
            synchronized (b.class) {
                if (tSa == null || !tSa.jbr) {
                    as.Hm();
                    tSa = new b(c.Fc());
                }
            }
        }
        return tSa;
    }

    private b(h hVar) {
        super(hVar, a.iHk, "WepkgPreloadFiles", a.fNF);
        this.hiZ = hVar;
        this.jbr = hVar != null;
        if (!this.jbr) {
            x.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
    }

    public final a fb(String str, String str2) {
        if (!this.jbr || bi.oN(str) || bi.oN(str2)) {
            return null;
        }
        String ff = d.ff(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "key"}), ff);
        if (rawQuery.moveToFirst()) {
            a aVar = new a();
            aVar.b(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", aVar.field_pkgId, aVar.field_rid, aVar.field_version);
            return aVar;
        }
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", str, str2);
        rawQuery.close();
        return null;
    }

    public final List<WepkgPreloadFile> Qu(String str) {
        List<WepkgPreloadFile> list = null;
        if (this.jbr && !bi.oN(str)) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "pkgId"}), str);
            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", r1);
            if (rawQuery == null) {
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    a aVar = new a();
                    aVar.b(rawQuery);
                    wepkgPreloadFile.a(aVar);
                    list.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(list.size()));
            } else {
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            }
        }
        return list;
    }

    public final boolean Qv(String str) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c aVar = new a();
        aVar.field_pkgId = str;
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(super.a(aVar, "pkgId")));
        return super.a(aVar, "pkgId");
    }

    public final boolean g(String str, String str2, String str3, boolean z) {
        if (!this.jbr || bi.oN(str) || bi.oN(str2)) {
            return false;
        }
        com.tencent.mm.sdk.e.c fb = fb(str, str2);
        if (fb == null) {
            return false;
        }
        fb.field_completeDownload = z;
        fb.field_filePath = str3;
        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(super.c(fb, new String[0])));
        return super.c(fb, new String[0]);
    }
}
