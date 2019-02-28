package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import org.json.JSONObject;

public class d {
    private static d sRC = null;

    public static d bLG() {
        if (sRC == null) {
            sRC = new d();
        }
        return sRC;
    }

    public Bankcard W(JSONObject jSONObject) {
        String str;
        int i = 1;
        String str2 = "MicroMsg.BankcardParser";
        String str3 = "parseJson jsonBankcard %s";
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            str = "";
        } else {
            Object str4 = jSONObject;
        }
        objArr[0] = str4;
        x.i(str2, str3, objArr);
        Bankcard bankcard = new Bankcard();
        try {
            int i2;
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            x.d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            bankcard.sRm = jSONObject.optString("h_bind_serialno");
            if (2 == jSONObject.optInt("bankacc_type", 0)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.sRc;
            }
            if ("NORMAL".equals(jSONObject.optString("extra_bind_flag"))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bankcard.field_cardType |= Bankcard.sRd;
            }
            if ("QMF".equals(bankcard.field_bankcardType)) {
                bankcard.field_cardType |= Bankcard.sRi;
                JSONObject optJSONObject = jSONObject.optJSONObject("qmfCardInfo");
                if (optJSONObject != null) {
                    bankcard.sRx = optJSONObject.optLong("total_credit_line", 0);
                    bankcard.sRy = optJSONObject.optLong("use_credit_line", 0);
                    bankcard.sRz = optJSONObject.optLong("unuse_credit_line", 0);
                    bankcard.sRA = optJSONObject.optString("payer_username", "");
                    bankcard.sRB = optJSONObject.optInt("hide_credit_line", 0);
                }
            }
            bankcard.field_mobile = URLDecoder.decode(jSONObject.optString("mobile").replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            if (bi.oN(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (bi.oN(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.sRk = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!bi.oN(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == jSONObject.optInt("expired_flag", 0)) {
                bankcard.field_bankcardState = 1;
            } else if (jSONObject.optInt("bank_flag", 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = jSONObject.optString("bank_phone");
            bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_pre_arrive_time") * 1000;
            bankcard.field_fetchArriveTimeWording = jSONObject.optString("fetch_pre_arrive_time_wording");
            bankcard.field_bankcardTag = jSONObject.optInt("bank_card_tag", 1);
            if (bankcard.field_bankcardTag != 2) {
                i = 0;
            }
            if (i != 0) {
                bankcard.field_cardType |= Bankcard.sRb;
            }
            CharSequence optString = jSONObject.optString("support_micropay");
            if (TextUtils.isEmpty(optString)) {
                bankcard.field_support_micropay = true;
            }
            if ("1".equals(optString)) {
                bankcard.field_support_micropay = true;
            } else if ("0".equals(optString)) {
                bankcard.field_support_micropay = false;
            }
            bankcard.field_arrive_type = jSONObject.optString("arrive_type");
            bankcard.field_avail_save_wording = jSONObject.optString("avail_save_wording");
            x.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            i = jSONObject.optInt("fetch_charge_rate", 0);
            x.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            x.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = jSONObject.optInt("full_fetch_charge_fee", 0);
            x.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = jSONObject.optString("fetch_charge_info");
            bankcard.field_tips = jSONObject.optString("tips");
            bankcard.field_forbid_title = jSONObject.optString("forbid_title");
            bankcard.field_forbid_url = jSONObject.optString("forbid_url");
            bankcard.field_no_micro_word = jSONObject.optString("no_micro_word");
            bankcard.field_card_bottom_wording = jSONObject.optString("card_bottom_wording");
            bankcard.field_support_lqt_turn_in = jSONObject.optInt("support_lqt_turn_in", 0);
            bankcard.field_support_lqt_turn_out = jSONObject.optInt("support_lqt_turn_out", 0);
            bankcard.field_is_hightlight_pre_arrive_time_wording = jSONObject.optInt("is_hightlight_pre_arrive_time_wording", 0);
            d(bankcard);
            return bankcard;
        } catch (Throwable e) {
            x.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e, "", new Object[0]);
            return null;
        } catch (Throwable e2) {
            x.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e2.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            return null;
        } catch (Throwable e22) {
            x.i("MicroMsg.BankcardParser", "parseJson() Exception:" + e22.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardParser", e22, "", new Object[0]);
            return null;
        }
    }

    public static Bankcard a(lc lcVar) {
        boolean z = true;
        x.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", lcVar);
        Bankcard bankcard = new Bankcard();
        try {
            boolean z2;
            bankcard.field_bankName = lcVar.nHt;
            bankcard.field_bankcardTypeName = lcVar.vRx;
            bankcard.field_bankcardType = lcVar.pff;
            bankcard.field_bindSerial = lcVar.pfg;
            x.d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            if (2 == bi.getInt(lcVar.vRv, 2)) {
                bankcard.field_cardType |= Bankcard.sRc;
            }
            if ("NORMAL".equals(lcVar.wah)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.sRd;
            }
            if (!bi.oN(lcVar.fBa)) {
                bankcard.field_mobile = URLDecoder.decode(lcVar.fBa.replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            }
            bankcard.field_onceQuotaKind = bi.getDouble(lcVar.wad, 0.0d) / 100.0d;
            bankcard.field_onceQuotaVirtual = bi.getDouble(lcVar.wab, 0.0d) / 100.0d;
            bankcard.field_dayQuotaKind = bi.getDouble(lcVar.vZZ, 0.0d) / 100.0d;
            bankcard.field_dayQuotaVirtual = bi.getDouble(lcVar.vZX, 0.0d) / 100.0d;
            bankcard.field_bankcardTail = lcVar.vRw;
            bankcard.field_forbidWord = lcVar.pfh;
            bankcard.field_repay_url = lcVar.ufK;
            bankcard.field_wxcreditState = 2;
            if (!bi.oN(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == bi.getInt(lcVar.waa, 0)) {
                bankcard.field_bankcardState = 1;
            } else if (bi.getInt(lcVar.sSK, 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = lcVar.sSL;
            bankcard.field_fetchArriveTime = bi.getLong(lcVar.wam, 0) * 1000;
            bankcard.field_fetchArriveTimeWording = lcVar.way;
            bankcard.field_bankcardTag = bi.getInt(lcVar.wae, 1);
            if (bankcard.field_bankcardTag == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.sRb;
            }
            if (lcVar.waj != 1) {
                z = false;
            }
            bankcard.field_support_micropay = z;
            x.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + lcVar.waj);
            bankcard.field_arrive_type = lcVar.was;
            bankcard.field_avail_save_wording = lcVar.wau;
            int i = lcVar.waz;
            x.i("MicroMsg.BankcardParser", "fetch_charge_rate:" + i);
            bankcard.field_fetch_charge_rate = ((double) i) / 10000.0d;
            x.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            i = lcVar.waA;
            x.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i) / 100.0d;
            bankcard.field_fetch_charge_info = lcVar.waB;
            bankcard.field_tips = lcVar.kTd;
            bankcard.field_forbid_title = lcVar.vRo;
            bankcard.field_forbid_url = lcVar.vRp;
            bankcard.field_no_micro_word = lcVar.wat;
            bankcard.field_card_bottom_wording = lcVar.waH;
            bankcard.field_support_lqt_turn_in = lcVar.waK;
            bankcard.field_support_lqt_turn_out = lcVar.waL;
            bankcard.field_is_hightlight_pre_arrive_time_wording = lcVar.waJ;
            d(bankcard);
            return bankcard;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankcardParser", e, "parseFromBindQueryRecord() error:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static void d(Bankcard bankcard) {
        if (bankcard != null) {
            if (bankcard.bLB()) {
                bankcard.field_desc = bankcard.field_bankName;
            } else if (bankcard.bLD()) {
                bankcard.field_desc = ad.getContext().getString(i.uXG, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            } else if (bankcard.bLA()) {
                bankcard.field_desc = ad.getContext().getString(i.veB, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            } else {
                bankcard.field_desc = ad.getContext().getString(i.uXV, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
            }
        }
    }
}
