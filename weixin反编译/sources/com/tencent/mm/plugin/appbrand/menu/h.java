package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.ui.base.n;
import java.util.HashMap;
import java.util.Map;

public final class h extends com.tencent.mm.plugin.appbrand.menu.a.a {

    public static final class a extends f {
        private static final int CTRL_INDEX = 75;
        public static final String NAME = "onShareAppMessage";
    }

    public h() {
        super(m.jGj - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        if (appBrandSysConfig == null || appBrandSysConfig.iRU.iJa != 0 || (appBrandSysConfig.aco() & 32) <= 0) {
            nVar.f(this.jGz, context.getString(j.iDI));
        }
    }

    public final void a(Context context, final p pVar, final String str, final l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(context, "pref_appbrand_" + appBrandSysConfig.uin, 4);
        if (appBrandSysConfig.iRU.iJa == 1 && !sharedPreferences.contains("has_share_dev_tips")) {
            sharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
            com.tencent.mm.ui.base.h.a(context, j.iBv, j.dGZ, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    h.a(pVar, lVar);
                }
            });
        } else if (appBrandSysConfig.iRU.iJa != 2 || sharedPreferences.contains("has_share_beta_tips")) {
            a(pVar, lVar);
        } else {
            sharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
            com.tencent.mm.ui.base.h.a(context, j.iBu, j.dGZ, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    h.a(pVar, lVar);
                }
            });
        }
    }

    static void a(p pVar, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        a aVar = new a();
        Map hashMap = new HashMap();
        hashMap.put("title", appBrandSysConfig.fsi);
        hashMap.put("desc", "");
        hashMap.put("path", pVar.afe());
        String str = "webViewUrl";
        com.tencent.mm.plugin.appbrand.jsapi.n.a ajG = pVar.ajG();
        hashMap.put(str, ajG != null ? ajG.jAa.getUrl() : null);
        hashMap.put("imgUrl", appBrandSysConfig.iRs);
        hashMap.put("mode", lVar.iWz.hD("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(lVar.iWz.hD("enable_share_dynamic")));
        lVar.iWz.u("user_clicked_share_btn", true);
        aVar.a(pVar).v(hashMap).afI();
    }
}
