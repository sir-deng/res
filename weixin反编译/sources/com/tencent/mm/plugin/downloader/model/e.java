package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static a cf(long j) {
        b Fl = Fl();
        if (Fl == null) {
            return null;
        }
        return Fl.cm(j);
    }

    public static a yk(String str) {
        b Fl = Fl();
        if (Fl == null) {
            return null;
        }
        return Fl.yk(str);
    }

    public static long b(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b Fl = Fl();
        if (Fl == null) {
            return -1;
        }
        x.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + aVar.field_downloadId + ", ret=" + Fl.b((c) aVar));
        return aVar.field_downloadId;
    }

    public static long c(a aVar) {
        if (aVar == null) {
            return -1;
        }
        b Fl = Fl();
        if (Fl == null) {
            return -1;
        }
        boolean c = Fl.c(aVar, new String[0]);
        x.d("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(aVar.field_downloadId), Boolean.valueOf(c), Integer.valueOf(aVar.field_status));
        return aVar.field_downloadId;
    }

    public static boolean k(long j, int i) {
        b Fl = Fl();
        if (Fl == null) {
            return false;
        }
        return Fl.fD("FileDownloadInfo", "update FileDownloadInfo set status = " + i + " where downloadId = " + j);
    }

    public static boolean yl(String str) {
        b Fl = Fl();
        if (Fl == null) {
            return false;
        }
        if (bi.oN(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            return false;
        }
        return Fl.fD("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
    }

    public static boolean ym(String str) {
        b Fl = Fl();
        if (Fl == null) {
            return false;
        }
        if (bi.oN(str)) {
            x.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            return false;
        }
        return Fl.fD("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
    }

    public static a yn(String str) {
        a aVar = null;
        b Fl = Fl();
        if (Fl != null) {
            if (bi.oN(str)) {
                x.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            } else {
                Cursor rawQuery = Fl.rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        aVar = new a();
                        aVar.b(rawQuery);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
        }
        return aVar;
    }

    public static boolean cg(long j) {
        b Fl = Fl();
        if (Fl == null) {
            return false;
        }
        c aVar = new a();
        aVar.field_downloadId = j;
        return Fl.a(aVar, new String[0]);
    }

    public static b Fl() {
        if (g.Do().CF()) {
            g.Do();
            if (!com.tencent.mm.kernel.a.Cz()) {
                if (g.h(com.tencent.mm.plugin.downloader.b.a.class) != null) {
                    return ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fl();
                }
                x.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
                return null;
            }
        }
        x.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        return null;
    }
}
