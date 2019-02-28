package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends i {
    public d() {
        o.bMg().gLA.fD("WalletBulletin", "delete from WalletBulletin");
        D(new HashMap());
    }

    public final int azx() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    public final int Hx() {
        return 1679;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            r.ab(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            x.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=" + optLong);
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    com.tencent.mm.plugin.wallet_core.model.i bLP = com.tencent.mm.plugin.wallet_core.model.i.bLP();
                    if (optJSONArray != null) {
                        x.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        bLP.sTl = optJSONArray;
                        g.Dr();
                        g.Dq().Db().a(a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, optJSONArray.toString());
                    }
                }
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_LBS_REPORT_DIALOG_TITLE_STRING_SYNC, optJSONObject.optString("title"));
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_LBS_REPORT_DIALOG_CONTENT_STRING_SYNC, optJSONObject.optString("content"));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("title");
                Object optString2 = optJSONObject.optString("balance_title");
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, optString);
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_RELEAY_NAME_BALANCE_CONTENT_STRING_SYNC, optString2);
            }
        }
    }
}
