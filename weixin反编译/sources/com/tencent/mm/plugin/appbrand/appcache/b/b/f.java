package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdm;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public class f extends a<Boolean, cdm> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.f$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iJD = new int[a.aaD().length];

        static {
            try {
                iJD[a.iJE - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public enum a {
        ;

        public static int[] aaD() {
            return (int[]) iJH.clone();
        }

        static {
            iJE = 1;
            iJF = 2;
            iJG = 3;
            iJH = new int[]{iJE, iJF, iJG};
        }
    }

    final /* bridge */ /* synthetic */ cdg aY(Object obj) {
        return ((cdm) obj).xiG;
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z = false;
        cdm cdm = (cdm) obj;
        int i = cdm.vTR;
        String str3 = cdm.xiU;
        int i2;
        if (bi.oN(str3)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call appId(%s) version(%d) key nil", str2, Integer.valueOf(i));
            i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) cdm.xiG.xiE, 124);
            return Boolean.valueOf(false);
        } else if (ak.r(str2, 0, i).first == com.tencent.mm.plugin.appbrand.appcache.ak.a.iIu) {
            x.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, normal pkg ok appId(%s), version(%d)", str2, Integer.valueOf(i));
            i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) cdm.xiG.xiE, 125);
            return Boolean.valueOf(false);
        } else {
            w o = ((com.tencent.mm.plugin.appbrand.appcache.x) e.u(com.tencent.mm.plugin.appbrand.appcache.x.class)).o(str2, 1, i);
            if (o == null) {
                x.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, null encrypt pkg info with %s, %d", str2, Integer.valueOf(i));
                i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) cdm.xiG.xiE, 126);
                i2 = 1;
            } else if (a(o, cdm.xiU, cdm.wgP, cdm.xiG.xiE, a.iJF)) {
                boolean z2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                z zVar = (z) e.u(z.class);
                String str4 = cdm.wgP;
                int i3 = cdm.xiG.xiE;
                if (bi.oN(str2) || bi.oN(str3)) {
                    x.e("MicroMsg.AppBrand.Predownload.PushWxaPkgDecryptKeyStorage", "setDecryptKey, invalid appId[%s], decryptKey[%s]", str2, str3);
                } else {
                    c yVar = new y();
                    yVar.field_appId = str2;
                    yVar.field_appVersion = i;
                    boolean b = zVar.b(yVar, new String[0]);
                    yVar.field_decryptKey = str3;
                    yVar.field_reportId = i3;
                    yVar.field_pkgMd5 = str4;
                    z = b ? zVar.c(yVar, new String[0]) : zVar.b(yVar);
                }
                i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) cdm.xiG.xiE, z ? 135 : 136);
            }
            return Boolean.TRUE;
        }
    }

    final String aaC() {
        return "CmdIssueDecryptKey";
    }

    private static boolean a(w wVar, String str, String str2, int i, int i2) {
        int i3;
        int i4 = 0;
        switch (AnonymousClass1.iJD[i2 - 1]) {
            case 1:
                i3 = 131;
                break;
            default:
                i3 = 127;
                break;
        }
        int i5 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
        String ag = ai.ag(wVar.field_appId, wVar.field_version);
        x.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", wVar.field_appId, Integer.valueOf(wVar.field_version), Integer.valueOf(MMProtocalJni.aesDecryptFile(wVar.field_pkgPath, ag, str.getBytes())));
        int i6;
        if (MMProtocalJni.aesDecryptFile(wVar.field_pkgPath, ag, str.getBytes()) != 0) {
            switch (AnonymousClass1.iJD[i2 - 1]) {
                case 1:
                    i3 = d.CTRL_INDEX;
                    break;
                default:
                    i3 = 129;
                    break;
            }
            i6 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
            return false;
        }
        if (g.bV(ag).equals(str2)) {
            e.Zz().g(wVar.field_appId, wVar.field_version, str2);
            boolean d = e.Zz().d(wVar.field_appId, 0, wVar.field_version, ag);
            switch (AnonymousClass1.iJD[i2 - 1]) {
                case 1:
                    if (!d) {
                        i3 = JsApiScanCode.CTRL_INDEX;
                        break;
                    }
                    i3 = 147;
                    break;
                default:
                    if (!d) {
                        i3 = com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
                        break;
                    }
                    i3 = 143;
                    break;
            }
            i5 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
            b.deleteFile(wVar.field_pkgPath);
            i3 = ((com.tencent.mm.plugin.appbrand.appcache.x) e.u(com.tencent.mm.plugin.appbrand.appcache.x.class)).a((c) wVar, new String[0]) ? v.CTRL_INDEX : com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
            i5 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
            if (i2 != a.iJF) {
                z zVar = (z) e.u(z.class);
                String str3 = wVar.field_appId;
                int i7 = wVar.field_version;
                if (!bi.oN(str3)) {
                    c yVar = new y();
                    yVar.field_appId = str3;
                    yVar.field_appVersion = i7;
                    i4 = zVar.a(yVar, new String[0]);
                }
                i3 = i4 != 0 ? j.CTRL_INDEX : 142;
                i4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
            }
            switch (AnonymousClass1.iJD[i2 - 1]) {
                case 1:
                    i3 = 132;
                    break;
                default:
                    i3 = FileUtils.S_IWUSR;
                    break;
            }
            i4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
            return true;
        }
        x.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", g.bV(ag), str2);
        switch (AnonymousClass1.iJD[i2 - 1]) {
            case 1:
                i3 = com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
                break;
            default:
                i3 = 130;
                break;
        }
        i6 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) i, (long) i3);
        return false;
    }

    public static boolean a(w wVar, int i) {
        return a(wVar, i, null);
    }

    public static boolean a(w wVar, int i, PLong pLong) {
        z zVar = (z) e.u(z.class);
        String str = wVar.field_appId;
        int i2 = wVar.field_version;
        c yVar = new y();
        yVar.field_appId = str;
        yVar.field_appVersion = i2;
        y yVar2 = zVar.b(yVar, new String[0]) ? yVar : null;
        if (yVar2 == null) {
            x.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", wVar.toShortString());
            return false;
        }
        if (pLong != null) {
            pLong.value = (long) yVar2.field_reportId;
        }
        return a(wVar, yVar2.field_decryptKey, yVar2.field_pkgMd5, yVar2.field_reportId, i);
    }
}
