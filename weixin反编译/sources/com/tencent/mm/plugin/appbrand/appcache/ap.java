package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.protocal.c.ccs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ap {
    public static final String[] iIQ = new String[]{i.a(al.iHk, "AppBrandWxaPkgManifestRecord")};
    public final h iIR;
    public final b iIS;

    private static final class b extends i<al> {
        b(e eVar) {
            super(eVar, al.iHk, "AppBrandWxaPkgManifestRecord", al.fNF);
        }
    }

    public enum a {
        DESC,
        ASC
    }

    public ap(h hVar) {
        this.iIR = hVar;
        this.iIS = new b(hVar);
    }

    public final int[] qf(String str) {
        if (bi.oN(str)) {
            return null;
        }
        if (!com.tencent.mm.plugin.appbrand.appcache.d.a.jy(0)) {
            return null;
        }
        List<al> a = a(str, 0, a.DESC, "version");
        if (bi.cC(a)) {
            return null;
        }
        int[] iArr = new int[a.size()];
        int i = 0;
        for (al alVar : a) {
            int i2 = i + 1;
            iArr[i] = alVar.field_version;
            i = i2;
        }
        return iArr;
    }

    final List<al> a(String str, int i, a aVar, String... strArr) {
        if (bi.oN(str)) {
            return Collections.emptyList();
        }
        Cursor a = this.iIR.a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, "version " + aVar.name(), 2);
        if (a == null) {
            return Collections.emptyList();
        }
        if (a.moveToFirst()) {
            List<al> linkedList = new LinkedList();
            do {
                al alVar = new al();
                alVar.b(a);
                alVar.field_appId = str;
                alVar.field_debugType = i;
                linkedList.add(alVar);
            } while (a.moveToNext());
            a.close();
            return linkedList;
        }
        a.close();
        return Collections.emptyList();
    }

    public final al a(String str, int i, String... strArr) {
        al alVar = null;
        if (!bi.oN(str)) {
            String str2;
            String[] strArr2;
            if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
                str2 = "version desc";
            } else if (com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i)) {
                str2 = "createTime desc";
            } else {
                throw new RuntimeException("Illegal pkgType " + i);
            }
            h hVar = this.iIR;
            String str3 = "AppBrandWxaPkgManifestRecord";
            if (bi.G(strArr)) {
                strArr2 = null;
            } else {
                strArr2 = strArr;
            }
            Cursor query = hVar.query(str3, strArr2, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, str2);
            if (query != null) {
                if (query.moveToFirst()) {
                    alVar = new al();
                    alVar.b(query);
                    alVar.field_appId = str;
                    alVar.field_debugType = i;
                }
                query.close();
            }
        }
        return alVar;
    }

    final boolean a(cch cch, PInt pInt) {
        if (cch.version < 0 || bi.oN(cch.url) || bi.oN(cch.frM)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", Integer.valueOf(cch.version), cch.url, cch.frM);
            return false;
        }
        if (cch.wNv > 0) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", Integer.valueOf(cch.version), Integer.valueOf(this.iIR.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", "0", String.valueOf(cch.version)})));
            pInt.value = r0;
        }
        return a("@LibraryAppId", 0, cch.version, cch.frM, cch.url);
    }

    @SuppressLint({"DefaultLocale"})
    final List<al> s(String str, int i, int i2) {
        List<al> list = null;
        if (!bi.oN(str)) {
            Object format;
            if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(0)) {
                format = String.format("order by %s desc", new Object[]{"version"});
            } else {
                String format2 = String.format("order by %s desc", new Object[]{"createTime"});
            }
            String format3 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(2)});
            Cursor a = this.iIR.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format2, format3}), new String[]{str, "0"}, null, null, null, 2);
            if (a != null) {
                list = new ArrayList();
                if (a.moveToFirst()) {
                    do {
                        al alVar = new al();
                        alVar.field_appId = str;
                        alVar.field_debugType = 0;
                        alVar.b(a);
                        list.add(alVar);
                    } while (a.moveToNext());
                }
                a.close();
            }
        }
        return list;
    }

    public final boolean a(String str, int i, String str2, String str3, long j, long j2) {
        if (bi.oN(str)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            return false;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Long.valueOf(j2));
        if (i == 999) {
            str = "@LibraryAppId";
        }
        al a = a(str, 1, i, new String[0]);
        if (a == null) {
            al alVar = new al();
            alVar.field_appId = str;
            alVar.field_version = 1;
            alVar.field_debugType = i;
            alVar.field_downloadURL = str2;
            alVar.field_versionMd5 = str3;
            alVar.field_versionState = 0;
            alVar.field_startTime = j;
            alVar.field_endTime = j2;
            alVar.field_createTime = bi.Wx();
            b(alVar);
            return true;
        }
        int i2;
        int i3;
        if (bi.oN(str3) || bi.oN(a.field_versionMd5) || str3.equals(a.field_versionMd5)) {
            boolean i22 = false;
        } else {
            i22 = 1;
        }
        if (str2.equals(a.field_downloadURL)) {
            boolean i32 = false;
        } else {
            i32 = 1;
        }
        if (i22 != 0) {
            a.field_downloadURL = str2;
            com.tencent.mm.loader.stub.b.deleteFile(a.field_pkgPath);
            a.field_pkgPath = null;
            a.field_createTime = bi.Wx();
            a.field_versionMd5 = str3;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            t(str, i, 1);
            return true;
        } else if (i32 == 0) {
            return false;
        } else {
            a.field_downloadURL = str2;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            return false;
        }
    }

    public final boolean a(al alVar) {
        boolean z = !bi.oN(alVar.field_appId) && this.iIS.a((c) alVar, al.iIB);
        if (z) {
            t(alVar.field_appId, alVar.field_debugType, alVar.field_version);
        }
        return z;
    }

    public final String ah(String str, int i) {
        al a = a(str, i, "downloadURL");
        return a == null ? "" : a.field_downloadURL;
    }

    public final int ai(String str, int i) {
        if (bi.oN(str) || !com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
            return 0;
        }
        al a = a(str, i, "version");
        if (a != null) {
            return a.field_version;
        }
        return 0;
    }

    private boolean a(String str, int i, int i2, String str2, String str3) {
        if (!com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
            return false;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3);
        int ai = ai(str, i);
        if (i2 < ai) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", Integer.valueOf(i2), Integer.valueOf(ai));
            return false;
        } else if ("@LibraryAppId".equals(str) && i2 == af.VERSION) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", Integer.valueOf(af.VERSION));
            return false;
        } else {
            al a = a(str, i2, i, new String[0]);
            boolean z = false;
            if (a == null) {
                al alVar = new al();
                alVar.field_appId = str;
                alVar.field_version = i2;
                alVar.field_versionMd5 = str2;
                alVar.field_downloadURL = str3;
                alVar.field_debugType = i;
                x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, version %d, url %s, md5 %s", Boolean.valueOf(b(alVar)), Integer.valueOf(alVar.field_version), alVar.field_downloadURL, alVar.field_versionMd5);
                return b(alVar);
            }
            Object obj;
            String str4 = a.field_downloadURL;
            String str5 = a.field_versionMd5;
            if (!bi.oM(a.field_versionMd5).equals(str2)) {
                a.field_versionMd5 = str2;
                a.field_version = i2;
                a.field_downloadURL = str3;
                obj = 1;
            } else if (bi.oN(str3) || str3.equals(a.field_downloadURL)) {
                obj = null;
            } else {
                a.field_downloadURL = str3;
                int obj2 = 1;
            }
            if (obj2 != null) {
                z = c(a);
            }
            String str6 = "MicroMsg.AppBrandWxaPkgStorage";
            String str7 = "flushWxaPkgVersionInfo, update record %b, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s";
            Object[] objArr = new Object[7];
            boolean z2 = obj2 != null && z;
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Integer.valueOf(ai);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str4;
            objArr[4] = str3;
            objArr[5] = str5;
            objArr[6] = str2;
            x.i(str6, str7, objArr);
            if (obj2 == null || !z) {
                return false;
            }
            return true;
        }
    }

    public final boolean a(String str, ccs ccs, int i) {
        if (bi.oN(str)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", str, ccs);
            return false;
        }
        return a(str, i, ccs.vTR, ccs.xip, ccs.xiq);
    }

    public final boolean a(String str, d dVar) {
        if (bi.oN(str) || dVar == null) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", str, dVar);
            return false;
        }
        a(str, 0, dVar.fJh, dVar.iSU);
        return a(str, 0, dVar.fJh, dVar.iSS, null);
    }

    public final boolean g(String str, int i, String str2) {
        return a(str, 0, i, str2, null);
    }

    public final al a(String str, int i, int i2, String... strArr) {
        al alVar = null;
        String str2 = "";
        for (String str3 : al.iIB) {
            str2 = str2 + str3 + "=? and ";
        }
        Cursor a = this.iIR.a("AppBrandWxaPkgManifestRecord", bi.G(strArr) ? null : strArr, str2 + "1=1", new String[]{str, String.valueOf(i), String.valueOf(i2)}, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                alVar = new al();
                alVar.b(a);
                alVar.field_appId = str;
            }
            a.close();
        }
        return alVar;
    }

    private boolean b(al alVar) {
        x.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", alVar.field_appId, Integer.valueOf(alVar.field_debugType), Integer.valueOf(alVar.field_version));
        return this.iIS.b((c) alVar);
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean d(String str, int i, int i2, String str2) {
        if (bi.oN(str)) {
            return false;
        }
        if (com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i)) {
            i2 = 1;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pkgPath", str2);
        if (this.iIR.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str, String.valueOf(i), String.valueOf(i2)}) <= 0) {
            return false;
        }
        return true;
    }

    private boolean c(al alVar) {
        x.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", alVar.field_appId, Integer.valueOf(alVar.field_version), Integer.valueOf(alVar.field_debugType));
        return this.iIS.c(alVar, al.iIB);
    }

    public final void d(List<String> list, List<Integer> list2) {
        int i = 0;
        if (list.size() > 0 && list2.size() > 0 && list.size() == list2.size()) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", Integer.valueOf(list.size()));
            long dA = this.iIR.dA(Thread.currentThread().getId());
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    aj((String) list.get(i2), ((Integer) list2.get(i2)).intValue());
                    i = i2 + 1;
                } else {
                    this.iIR.fT(dA);
                    return;
                }
            }
        }
    }

    public final void aj(String str, int i) {
        if (!bi.oN(str)) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", str, Integer.valueOf(i));
            String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
            String[] strArr = new String[]{str, String.valueOf(i)};
            Cursor a = this.iIR.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
            if (a == null) {
                return;
            }
            if (a.moveToFirst()) {
                List<String> linkedList = new LinkedList();
                do {
                    linkedList.add(a.getString(0));
                } while (a.moveToNext());
                a.close();
                for (String deleteFile : linkedList) {
                    com.tencent.mm.loader.stub.b.deleteFile(deleteFile);
                }
                this.iIR.delete("AppBrandWxaPkgManifestRecord", format, strArr);
                t(str, i, -1);
                return;
            }
            a.close();
        }
    }

    public final void d(al alVar) {
        this.iIS.a(alVar);
    }

    public final boolean a(String str, int i, int i2, List<WxaAttributes.e> list) {
        if (bi.oN(str) || bi.cC(list)) {
            return false;
        }
        int i3;
        int i4;
        if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
            i3 = i2;
        } else {
            i3 = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (WxaAttributes.e eVar : list) {
            stringBuilder.append(',').append(eVar.name).append("::").append(eVar.frM);
        }
        stringBuilder.append('}');
        x.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", str, Integer.valueOf(i), Integer.valueOf(i3), stringBuilder.toString());
        String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str, "debugType", Integer.valueOf(i), "version", Integer.valueOf(i3)});
        Cursor a = this.iIR.a(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
        if (a == null) {
            i4 = 0;
        } else {
            if (a.moveToFirst()) {
                i4 = a.getInt(0);
            } else {
                i4 = 0;
            }
            a.close();
        }
        if (i4 != 0 && i4 == list.size()) {
            return false;
        }
        this.iIR.fD("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}));
        for (WxaAttributes.e eVar2 : list) {
            format = new q(str, eVar2.name).toString();
            if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i)) {
                a(format, i, i3, eVar2.frM, null);
            } else {
                a(format, i, null, eVar2.frM, 0, 0);
            }
        }
        return true;
    }

    private boolean t(String str, int i, int i2) {
        Locale locale = Locale.US;
        String str2 = "where %s like '%s$%%' and %s=%d and %s";
        Object[] objArr = new Object[5];
        objArr[0] = "appId";
        objArr[1] = str;
        objArr[2] = "debugType";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = i2 > 0 ? "version=" + i2 : "1=1";
        String format = String.format(locale, str2, objArr);
        format = String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format});
        x.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        return this.iIR.fD("AppBrandWxaPkgManifestRecord", format);
    }
}
