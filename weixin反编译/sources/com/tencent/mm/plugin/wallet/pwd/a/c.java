package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public int sME;
    public String sMF;
    public int sMG;
    public String sMH;
    public String sMI;

    public c() {
        Map hashMap = new HashMap();
        hashMap.put("deviceid", q.getDeviceID(ad.getContext()));
        D(hashMap);
    }

    public final int azx() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + i + ";errMsg:" + str);
        x.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", jSONObject.toString());
        if (i == 0) {
            String optString = jSONObject.optString("is_show_deduct", "0");
            if (!xv(optString)) {
                optString = "0";
            }
            this.sME = Integer.valueOf(optString).intValue();
            this.sMF = jSONObject.optString("deduct_show_url", "");
            optString = jSONObject.optString("deduct_cache_time", "");
            if (!xv(optString)) {
                optString = "84600";
            }
            this.sMG = Integer.valueOf(optString).intValue();
            this.sMH = jSONObject.optString("deduct_title", "");
            this.sMI = jSONObject.optString("realname_url", "");
            Object optString2 = jSONObject.optString("payway_select_wording", "");
            Object optString3 = jSONObject.optString("payway_change_wording", "");
            com.tencent.mm.sdk.e.c zVar = new z();
            zVar.field_is_show = this.sME;
            zVar.field_pref_key = "wallet_open_auto_pay";
            zVar.field_pref_title = this.sMH;
            zVar.field_pref_url = this.sMF;
            h bMb = o.bMb();
            String str2 = "wallet_open_auto_pay";
            if (!bi.oN(str2)) {
                bMb.gLA.fD("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str2 + "'");
            }
            x.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s", Integer.valueOf(this.sMG));
            o.bMb().b(zVar);
            JSONObject optJSONObject = jSONObject.optJSONObject("unreg_info");
            if (optJSONObject != null) {
                Object optString4 = optJSONObject.optString("unreg_title", "");
                Object optString5 = optJSONObject.optString("unreg_url", "");
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, optString4);
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, optString5);
            } else {
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, (Object) "");
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, (Object) "");
            }
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(new Date().getTime() / 1000));
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(this.sMG));
            g.Dr();
            g.Dq().Db().a(a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, this.sMI);
            if (!bi.oN(optString2)) {
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, optString2);
            }
            if (!bi.oN(optString3)) {
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, optString3);
            }
            g.Dr();
            g.Dq().Db().lO(true);
        }
    }

    public static boolean bEr() {
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        g.Dr();
        x.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", Long.valueOf(longValue), Integer.valueOf(r0), Long.valueOf(((long) ((Integer) g.Dq().Db().get(a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, Integer.valueOf(0))).intValue()) + longValue));
        if (longValue <= 0) {
            return true;
        }
        if (Long.valueOf(new Date().getTime() / 1000).longValue() > longValue + ((long) r0)) {
            return true;
        }
        return false;
    }

    private static boolean xv(String str) {
        if (bi.oN(str)) {
            return false;
        }
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            charAt = str.charAt(length);
            if (charAt < '0') {
                return false;
            }
        } while (charAt <= '9');
        return false;
    }

    public final int Hx() {
        return 1654;
    }

    public final int bLf() {
        return 100000;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/paymanage";
    }
}
