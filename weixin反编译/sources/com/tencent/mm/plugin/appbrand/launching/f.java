package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.g;
import java.io.Closeable;
import java.io.File;
import org.json.JSONArray;

public final class f {
    public static WxaPkgWrappingInfo aF(String str, int i) {
        int[] qf = e.Zz().qf(str);
        if (qf != null && qf.length > i) {
            while (true) {
                int i2 = i + 1;
                Pair r = ak.r(str, 0, qf[i]);
                if (r.first == a.iIu && r.second != null) {
                    return (WxaPkgWrappingInfo) r.second;
                }
                if (i2 >= qf.length) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }

    static boolean bx(String str, String str2) {
        boolean z = true;
        if (bi.oN(str) || !com.tencent.mm.a.e.bO(str)) {
            return false;
        }
        ag agVar = new ag(new File(str));
        if (!agVar.aai()) {
            agVar.close();
            return false;
        } else if (bi.oN(str2)) {
            agVar.close();
            return false;
        } else {
            Closeable qa = agVar.qa(l.vh(str2));
            if (qa != null) {
                bi.d(qa);
            } else {
                String convertStreamToString = c.convertStreamToString(agVar.qa("app-config.json"));
                if (!bi.oN(convertStreamToString)) {
                    try {
                        JSONArray jSONArray = g.fA(convertStreamToString).getJSONArray("pages");
                        String pQ = com.tencent.mm.plugin.appbrand.appcache.a.pQ(str2);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (string.equals(str2) || string.equals(pQ)) {
                                return true;
                            }
                        }
                        z = false;
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", str, str2, e);
                    }
                }
                z = false;
            }
            agVar.close();
            return z;
        }
    }
}
