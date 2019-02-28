package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ag {
    public static int a(Context context, au auVar) {
        if (auVar == null) {
            return 0;
        }
        if (auVar.kzz != 6) {
            return auVar.sfa;
        }
        if (auVar.vMz == null) {
            return 0;
        }
        if (a.ihO.m(context, auVar.vMx.nlV)) {
            return auVar.vMz.vOu;
        }
        return auVar.vMz.vOv;
    }

    public static void a(Context context, ay ayVar, au auVar) {
        if (!(auVar == null || auVar.vMx == null)) {
            boolean z;
            String str = auVar.vMx.nlV;
            if (bi.oN(str)) {
                z = false;
            } else {
                f aZ = g.aZ(str, true);
                if (aZ == null || bi.oN(aZ.field_appId)) {
                    z = false;
                } else {
                    z = (aZ.field_appInfoFlag & 32) > 0;
                    x.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", aZ.field_appId, Boolean.valueOf(z));
                }
            }
            if (z) {
                ayVar.rQB = false;
                String str2 = "";
                if (auVar.vMB == null || auVar.vMC == null) {
                    str = auVar == null ? "" : auVar.kzz == 6 ? auVar.vMA == null ? "" : a.ihO.m(context, auVar.vMx.nlV) ? auVar.vMA.vOI : auVar.vMA.vOJ : auVar.vMy;
                    try {
                        if (!bi.oN(str)) {
                            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                            if (identifier > 0) {
                                str = context.getString(identifier);
                            }
                        }
                    } catch (Exception e) {
                    }
                    str = str2;
                } else {
                    cz czVar;
                    if (a.ihO.m(context, auVar.vMx.nlV)) {
                        czVar = auVar.vMB;
                    } else {
                        czVar = auVar.vMC;
                    }
                    str2 = w.cfV();
                    if (str2.equals("zh_CN")) {
                        str = czVar.vOG;
                    } else if (str2.equals("zh_TW") || str2.equals("zh_HK")) {
                        str = czVar.vOH;
                    } else {
                        str = czVar.vOF;
                    }
                }
                switch (auVar.kzz) {
                    case 4:
                        ayVar.rQC = str;
                        ayVar.rQB = true;
                        break;
                    case 5:
                        if (auVar.sfa == 1) {
                            ayVar.rQC = str;
                            ayVar.rQB = true;
                            break;
                        }
                        break;
                    case 6:
                        ayVar.rQC = str;
                        ayVar.rQB = true;
                        break;
                    default:
                        ayVar.rQB = false;
                        break;
                }
                if (bi.oN(str)) {
                    x.e("MicroMsg.OpenActionContent", "text can not load ?");
                    ayVar.rQB = false;
                    return;
                }
                return;
            }
        }
        ayVar.rQB = false;
    }
}
