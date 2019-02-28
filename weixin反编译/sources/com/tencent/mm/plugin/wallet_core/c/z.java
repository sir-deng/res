package com.tencent.mm.plugin.wallet_core.c;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class z extends i {
    public Orders sOZ;

    public z(String str) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        D(hashMap);
    }

    public z(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i));
        D(hashMap);
    }

    public final int azx() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2;
                this.sOZ = new Orders();
                Commodity commodity = new Commodity();
                commodity.pfR = jSONObject.getString("buy_uin");
                commodity.pfS = jSONObject.getString("buy_name");
                commodity.pfT = jSONObject.optString("sale_uin");
                commodity.pfU = jSONObject.optString("sale_name");
                commodity.fvD = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.loS = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.pfY = jSONObject.getString("trade_state");
                commodity.pfZ = jSONObject.getString("trade_state_name");
                commodity.pgd = jSONObject.getString("buy_bank_name");
                commodity.pgk = jSONObject.optString("discount", "");
                commodity.pgb = jSONObject.optInt("modify_timestamp");
                commodity.pgf = jSONObject.optString("fee_type");
                commodity.pgg = jSONObject.optString("appusername");
                commodity.pfI = jSONObject.optString("app_telephone");
                commodity.sUt = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.pgf = jSONObject.optString("fee_type", "");
                int i2 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    Promotions promotions = new Promotions();
                    promotions.type = Orders.sUr;
                    promotions.name = optJSONObject.optString("nickname");
                    promotions.pgg = optJSONObject.optString("username");
                    commodity.sUu = promotions.pgg;
                    promotions.pkG = optJSONObject.optString("logo_round_url");
                    promotions.url = optJSONObject.optString("subscribe_biz_url");
                    i2 = optJSONObject.optInt("recommend_level");
                    commodity.sTW = i2;
                    if (!bi.oN(promotions.name)) {
                        commodity.sUB.add(promotions);
                    }
                }
                int i3 = i2;
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (i2 = 0; i2 < length; i2++) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.sUs;
                    promotions2.pkG = jSONObject2.optString("icon");
                    promotions2.name = jSONObject2.optString("wording");
                    promotions2.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    promotions2.sTG = jSONObject2.optString("btn_text");
                    promotions2.sUJ = jSONObject2.optInt(Columns.TYPE);
                    promotions2.title = jSONObject2.optString("title");
                    promotions2.sOB = jSONObject2.optLong("activity_id");
                    promotions2.sUK = jSONObject2.optInt("activity_type", 0);
                    promotions2.sUL = jSONObject2.optInt("award_id");
                    promotions2.sTD = jSONObject2.optInt("send_record_id");
                    promotions2.sTE = jSONObject2.optInt("user_record_id");
                    promotions2.sUN = jSONObject2.optString("activity_tinyapp_username");
                    promotions2.sUO = jSONObject2.optString("activity_tinyapp_path");
                    promotions2.sTF = jSONObject2.optLong("activity_mch_id");
                    promotions2.sUP = jSONObject2.optInt("activity_tinyapp_version");
                    promotions2.sUQ = jSONObject2.optString("get_award_params");
                    promotions2.sUR = jSONObject2.optString("query_award_status_params");
                    Orders.a(promotions2, jSONObject2.optJSONObject("exposure_info"));
                    commodity.sUB.add(promotions2);
                }
                jSONArray = jSONObject.optJSONArray("discount_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    length = jSONArray.length();
                    commodity.sUw = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        jSONObject2 = jSONArray.optJSONObject(i2);
                        DiscountInfo discountInfo = new DiscountInfo();
                        discountInfo.sUI = jSONObject2.optDouble("payment_amount");
                        discountInfo.pPL = jSONObject2.optString("favor_desc");
                        commodity.sUw.add(discountInfo);
                    }
                }
                commodity.sUx = jSONObject.optString("rateinfo");
                commodity.sUy = jSONObject.optString("discount_rateinfo");
                commodity.sUz = jSONObject.optString("original_feeinfo");
                this.sOZ.sUf = new ArrayList();
                this.sOZ.sUf.add(commodity);
                this.sOZ.sTY = jSONObject.optString("trade_state_name");
                this.sOZ.sTW = i3;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
            }
        }
    }
}
