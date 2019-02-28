package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum ak {
    ;

    public enum a {
        private static final /* synthetic */ a[] iIA = null;
        public static final a iIu = null;
        public static final a iIv = null;
        public static final a iIw = null;
        public static final a iIx = null;
        public static final a iIy = null;
        public static final a iIz = null;

        private a(String str, int i) {
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) iIA.clone();
        }

        static {
            iIu = new a("APP_READY", 0);
            iIv = new a("APP_MANIFEST_NULL", 1);
            iIw = new a("PKG_EXPIRED", 2);
            iIx = new a("APP_NOT_INSTALLED", 3);
            iIy = new a("APP_BROKEN", 4);
            iIz = new a("ENV_ERR", 5);
            iIA = new a[]{iIu, iIv, iIw, iIx, iIy, iIz};
        }

        public final int aav() {
            return super.ordinal();
        }
    }

    public static Pair<a, WxaPkgWrappingInfo> ct(boolean z) {
        return l(z, false);
    }

    public static Pair<a, WxaPkgWrappingInfo> l(boolean z, boolean z2) {
        if (z && !(z2 && af.iHE == a.DEVELOP)) {
            c cVar = (c) g.h(c.class);
            if (cVar != null) {
                ap Zf = cVar.Zf();
                if (Zf != null) {
                    Object obj;
                    int ai = Zf.ai("@LibraryAppId", 0);
                    if (!"@LibraryAppId".equals("@LibraryAppId") || (ai >= 0 && af.VERSION < ai)) {
                        obj = null;
                    } else {
                        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", Integer.valueOf(af.VERSION), r0, Integer.valueOf(0), Integer.valueOf(ai));
                        obj = af.aah();
                    }
                    if (obj != null) {
                        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", Integer.valueOf(ai), Integer.valueOf(af.VERSION));
                        return Pair.create(a.iIu, obj);
                    }
                }
            }
            return Pair.create(a.iIu, af.aah());
        }
        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", Boolean.valueOf(z), Boolean.valueOf(z2), af.iHE, r("@LibraryAppId", z ? 0 : 999, -1).first);
        return r("@LibraryAppId", z ? 0 : 999, -1);
    }

    public static Pair<a, WxaPkgWrappingInfo> r(String str, int i, int i2) {
        if (((c) g.h(c.class)).Zf() == null) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
            return Pair.create(a.iIz, null);
        }
        al a;
        String[] strArr = new String[]{"pkgPath", "versionMd5", "version", "createTime"};
        if (!com.tencent.mm.plugin.appbrand.appcache.d.a.jy(i) || i2 <= 0) {
            a = ((c) g.h(c.class)).Zf().a(str, i, strArr);
        } else {
            a = ((c) g.h(c.class)).Zf().a(str, i2, i, strArr);
        }
        if (a == null) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
            return Pair.create(a.iIv, null);
        }
        int i3;
        String str2 = a.field_pkgPath;
        String str3 = a.field_versionMd5;
        if (i2 < 0) {
            i3 = a.field_version;
        } else {
            i3 = i2;
        }
        long j = a.field_createTime;
        if (bi.oN(str2) || !e.bO(str2)) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", str2, str, Integer.valueOf(i), Integer.valueOf(i3));
            return Pair.create(a.iIy, null);
        }
        String bV = com.tencent.mm.a.g.bV(str2);
        if (bi.oN(str3) || str3.equals(bV)) {
            WxaPkgWrappingInfo qh = WxaPkgWrappingInfo.qh(str2);
            if (qh == null) {
                x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
                return Pair.create(a.iIy, null);
            }
            qh.iJb = i3;
            qh.iJc = j;
            qh.iGz = str2;
            qh.iJd = false;
            qh.iJa = i;
            qh.frM = bV;
            x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime), qh);
            return Pair.create(a.iIu, qh);
        }
        x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", bV, str3, str, Integer.valueOf(i), Integer.valueOf(i2));
        return Pair.create(a.iIy, null);
    }
}
