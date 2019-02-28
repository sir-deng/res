package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.c.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.go;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static final String nhh = (com.tencent.mm.loader.stub.a.bnF + "Game/HvMenu/");

    interface a {
        void onComplete();
    }

    static /* synthetic */ void a(final akd akd, final String str) {
        if (akd == null) {
            return;
        }
        if (bi.cC(akd.wxT)) {
            x.i("MicroMsg.GameCommOpertionProcessor", "menu list is null. appid:%s", str);
            return;
        }
        List arrayList = new ArrayList();
        arrayList.addAll(akd.wxT);
        a(arrayList, new a() {
            public final void onComplete() {
                x.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", str);
                SubCoreGameCenter.aRO().a("pb_game_hv_menu_" + str, akd);
            }
        });
    }

    public static void a(go goVar) {
        x.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", Integer.valueOf(goVar.fxy.pK));
        Context context;
        JSONObject jSONObject;
        final String str;
        switch (goVar.fxy.pK) {
            case 1:
                context = goVar.fxy.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a cL = g.cL(context);
                    if (cL != null) {
                        try {
                            jSONObject.put("gameRegionName", g.a(cL));
                        } catch (JSONException e) {
                        }
                    }
                    goVar.fxz.result = jSONObject.toString();
                    return;
                }
                return;
            case 2:
                str = goVar.fxy.fxA;
                x.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", str);
                if (!bi.oN(str)) {
                    as.CN().a(1369, new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            if (i == 0 && i2 == 0) {
                                x.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", str);
                                as.CN().b(1369, (e) this);
                                final akd akd = (akd) ((bf) kVar).lSH.hnR.hnY;
                                ah.y(new Runnable() {
                                    public final void run() {
                                        h.a(akd, str);
                                    }
                                });
                                return;
                            }
                            x.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", str);
                        }
                    });
                    as.CN().a(new bf(str), 0);
                    return;
                }
                return;
            case 3:
                str = goVar.fxy.fxA;
                x.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", str);
                if (!bi.oN(str)) {
                    byte[] CC = SubCoreGameCenter.aRO().CC("pb_game_hv_menu_" + str);
                    if (!bi.by(CC)) {
                        try {
                            goVar.fxz.result = new String(CC, "ISO-8859-1");
                            x.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", str);
                            return;
                        } catch (UnsupportedEncodingException e2) {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 4:
                b(goVar);
                return;
            case 10001:
                context = goVar.fxy.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    Object cP = g.cP(context);
                    if (bi.oN(cP)) {
                        cP = g.aQF();
                    }
                    try {
                        jSONObject.put("regionCode", cP);
                    } catch (JSONException e3) {
                    }
                    goVar.fxz.result = jSONObject.toString();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void a(final List<arl> list, final a aVar) {
        if (!bi.cC(list)) {
            final arl arl = (arl) list.remove(0);
            if (arl == null || bi.oN(arl.phv)) {
                x.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
                return;
            }
            String str = nhh + g.s(arl.phv.getBytes());
            com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
            aVar2.hFl = true;
            aVar2.hFn = str;
            o.PG().a(arl.phv, aVar2.PQ(), new c() {
                public final void a(boolean z, Object... objArr) {
                    if (z) {
                        x.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", arl.phv);
                        h.a(list, aVar);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.onComplete();
        }
    }

    private static void b(go goVar) {
        String str = goVar.fxy.fxA;
        if (!bi.oN(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("game_page_report_id"));
                boolean z = jSONObject.getBoolean("game_page_report_instantly");
                str = jSONObject.optString("game_page_report_format_data");
                String optString = jSONObject.optString("game_page_report_tabs_format_data");
                x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", Integer.valueOf(parseInt), Boolean.valueOf(z), str, optString);
                if (bi.oN(str)) {
                    if (!bi.oN(optString)) {
                        try {
                            JSONArray jSONArray = new JSONArray(optString);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                optString = jSONArray.getString(i);
                                if (!bi.oN(optString)) {
                                    if (z) {
                                        ap.as(parseInt, optString);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pWK.k(parseInt, optString);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", e.getMessage());
                        }
                    }
                } else if (z) {
                    ap.as(parseInt, str);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.k(parseInt, str);
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", e2.getMessage());
            }
        }
    }
}
