package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.g;
import java.util.List;
import org.json.JSONObject;

public class aa extends x<WxaPkgWrappingInfo> implements j {
    public static volatile boolean jDO = false;
    private final j jDP;

    public /* synthetic */ Object call() {
        return ads();
    }

    aa(String str, int i, String str2, int i2, d dVar) {
        Object obj;
        List list;
        String str3;
        int i3;
        Object obj2 = 1;
        List list2 = null;
        if (a.jy(i)) {
            obj = (dVar.iSV || (jDO && !bi.cC(dVar.iSU))) ? 1 : null;
            list = dVar.iSU;
            str3 = dVar.iSW;
            i3 = dVar.iST;
        } else {
            JSONObject fA;
            String str4;
            try {
                fA = g.fA(((i) e.u(i.class)).aG(str, i));
            } catch (Exception e) {
                fA = null;
            }
            if (fA == null) {
                str4 = null;
                obj2 = null;
            } else {
                list2 = WxaAttributes.e.ry(fA.optString("module_list"));
                if (bi.cC(list2)) {
                    obj2 = null;
                }
                str4 = obj2 != null ? fA.optString("entrance_module") : "";
            }
            list = list2;
            str3 = str4;
            i3 = 0;
            obj = obj2;
        }
        if (obj == null || bi.cC(list) || !j.ZT()) {
            this.jDP = new m(str, i, dVar.fJh, i2, dVar) {
                public final void aiu() {
                    aa.this.aiu();
                }

                public final void aiw() {
                    aa.this.aiw();
                }

                public final void lg(int i) {
                    aa.this.lg(i);
                }
            };
        } else {
            this.jDP = new n(str, i, str2, i2, dVar.fJh, i3, str3, list) {
            };
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
    }

    public void aiu() {
    }

    public void aiw() {
    }

    public void lg(int i) {
    }

    public final WxaPkgWrappingInfo ads() {
        return (WxaPkgWrappingInfo) this.jDP.call();
    }
}
