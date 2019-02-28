package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.mm.f.a.kz;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.g;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class q extends j {
    private static volatile q iSn;

    public static q acp() {
        if (iSn == null) {
            synchronized (q.class) {
                if (iSn == null) {
                    iSn = new q();
                }
            }
        }
        return iSn;
    }

    public static void release() {
        synchronized (q.class) {
            iSn = null;
        }
    }

    private q() {
    }

    public final void b(String str, int i, Object obj) {
        super.b(str, i, obj);
        ((g) e.u(g.class)).b(str, i, obj);
    }

    public final void c(a aVar) {
        super.a(aVar, c.Dt().oFY.getLooper());
    }

    public static boolean i(String str, int i, boolean z) {
        boolean z2 = false;
        p Zs = e.Zs();
        if (bi.oN(str)) {
            return false;
        }
        WxaAttributes f = Zs.f(str, "appOpt");
        if (f == null) {
            return false;
        }
        int i2 = f.field_appOpt;
        i2 = !z ? i2 & (i ^ -1) : i2 | i;
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("appOpt", Integer.valueOf(i2));
        if (Zs.hiZ.update("WxaAttributesTable", contentValues, String.format("%s=?", new Object[]{"username"}), new String[]{str}) > 0) {
            z2 = true;
        }
        if (z2) {
            b kzVar = new kz();
            kzVar.fDc.foe = str;
            kzVar.fDc.fDd = i2;
            com.tencent.mm.sdk.b.a.xmy.m(kzVar);
        }
        return z2;
    }

    public static t ri(String str) {
        if (bi.oN(str) || !com.tencent.mm.kernel.g.Do().CF()) {
            return null;
        }
        WxaAttributes f = e.Zs().f(str, "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "registerSource", "bindWxaInfo");
        if (f == null) {
            return null;
        }
        t tVar = new t();
        tVar.username = str;
        tVar.appId = f.field_appId;
        tVar.fqG = f.field_nickname;
        tVar.signature = f.field_signature;
        tVar.iSZ = f.field_brandIconURL;
        tVar.iSL = f.acr().iSL;
        tVar.iSR = f.acs() == null ? -1 : f.acs().iSR;
        tVar.iSy = f.act();
        try {
            tVar.hre = bi.oN(f.field_registerSource) ? "" : new JSONObject(f.field_registerSource).optString("RegisterBody", "");
        } catch (Exception e) {
        }
        return tVar;
    }

    public static k a(String str, String str2, int i, long j) {
        int i2;
        WxaAttributes f = e.Zs().f(str2, "appId", "nickname", "brandIconURL", "appInfo");
        String valueOf = String.valueOf(str);
        String str3 = f == null ? "" : f.field_appId;
        String str4 = f == null ? "" : f.field_nickname;
        String str5 = f == null ? "" : f.field_brandIconURL;
        if (f == null) {
            i2 = 0;
        } else {
            i2 = f.acq().hqv;
        }
        return new k(valueOf, str2, str3, str4, str5, i2, i, e.Zs().rh(str2), e.Zy().ao(str2, i), j);
    }

    public static AppBrandSysConfig rj(String str) {
        boolean z = false;
        WxaAttributes g = e.Zs().g(str, new String[0]);
        if (g == null) {
            return null;
        }
        AppBrandSysConfig appBrandSysConfig;
        if (g != null) {
            appBrandSysConfig = new AppBrandSysConfig();
            appBrandSysConfig.foe = g.field_username;
            appBrandSysConfig.fsi = g.field_nickname;
            appBrandSysConfig.iRs = g.field_brandIconURL;
            appBrandSysConfig.appId = g.field_appId;
            appBrandSysConfig.iRt = g.acq().iSG;
            appBrandSysConfig.iRA = g.acr().iSK.iRA;
            appBrandSysConfig.iRB = g.acr().iSK.iRB;
            appBrandSysConfig.iRE = g.acr().iSK.iRE;
            appBrandSysConfig.iRF = g.acr().iSK.iRF;
            appBrandSysConfig.iRG = g.acr().iSK.iRG;
            appBrandSysConfig.iRH = g.acr().iSK.iRH;
            appBrandSysConfig.iRD = g.acr().iSK.iRD;
            appBrandSysConfig.iRC = g.acr().iSK.iRC;
            appBrandSysConfig.iRI = (long) g.acr().iSK.iSO;
            appBrandSysConfig.iRJ = g.acr().iSK.iSP;
            appBrandSysConfig.iRM = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.e(new ArrayList(), g.acq().iSC);
            appBrandSysConfig.iRN = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.e(new ArrayList(), g.acq().iSD);
            appBrandSysConfig.iRP = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.e(new ArrayList(), g.acq().iSF);
            appBrandSysConfig.iRO = (ArrayList) com.tencent.mm.plugin.appbrand.q.e.e(new ArrayList(), g.acq().iSE);
            appBrandSysConfig.iRW = new dd();
            appBrandSysConfig.iRW.vOU = g.acq().iMP;
            appBrandSysConfig.iRW.vPb = g.acq().iSA;
            appBrandSysConfig.iRQ = g.acr().iSK.iRQ;
            appBrandSysConfig.iRR = g.acr().iSK.iRR;
            appBrandSysConfig.iRS = g.acr().iSK.iRS;
            appBrandSysConfig.iRT = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("ClientBenchmarkLevel", -1);
        } else {
            appBrandSysConfig = null;
        }
        if (appBrandSysConfig != null) {
            String str2 = appBrandSysConfig.appId;
            boolean parseBoolean = (bi.oN(str2) || e.Zw() == null) ? false : Boolean.parseBoolean(e.Zw().get(str2 + "_AppDebugEnabled", "false"));
            appBrandSysConfig.iRu = parseBoolean;
            com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100216");
            if (fp.isValid() && "1".equals(fp.civ().get("isOpenJSCore"))) {
                z = true;
            }
            appBrandSysConfig.iRK = z;
            appBrandSysConfig.iRv = "1".equals(e.Zw().get(appBrandSysConfig.appId + "_PerformancePanelEnabled", "0"));
        }
        return appBrandSysConfig;
    }

    public static long rh(String str) {
        return e.Zs().rh(str);
    }

    public static String[] rk(String str) {
        if (bi.oN(str) || e.Zs().f(str, "roundedSquareIconURL", "bigHeadURL") == null) {
            return null;
        }
        return new String[]{e.Zs().f(str, "roundedSquareIconURL", "bigHeadURL").field_roundedSquareIconURL, e.Zs().f(str, "roundedSquareIconURL", "bigHeadURL").field_bigHeadURL};
    }

    public static String rl(String str) {
        if (bi.oN(str)) {
            return null;
        }
        WxaAttributes f = e.Zs().f(str, "appId");
        if (f != null) {
            return f.field_appId;
        }
        return null;
    }

    public static String rm(String str) {
        if (bi.oN(str)) {
            return null;
        }
        WxaAttributes g = e.Zs().g(str, "nickname");
        if (g != null) {
            return g.field_nickname;
        }
        return null;
    }

    public static String rn(String str) {
        if (bi.oN(str)) {
            return null;
        }
        WxaAttributes g = e.Zs().g(str, "username");
        if (g != null) {
            return g.field_username;
        }
        return null;
    }

    public static void ro(String str) {
        if (!bi.oN(str)) {
            p Zs = e.Zs();
            if (!bi.oN(str)) {
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("syncVersion", "");
                contentValues.put("syncTimeSecond", Long.valueOf(0));
                Zs.hiZ.update("WxaAttributesTable", contentValues, String.format(Locale.US, "%s=?", new Object[]{"username"}), new String[]{str});
            }
        }
    }

    public static void rp(String str) {
        if (!bi.oN(str)) {
            com.tencent.mm.sdk.e.c wxaAttributes = new WxaAttributes();
            wxaAttributes.field_username = str;
            e.Zs().a(wxaAttributes, "username");
        }
    }
}
