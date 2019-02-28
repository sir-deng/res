package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    public boolean fLC = false;
    public ArrayList<Bankcard> sFo = null;
    public boolean sHR = true;
    public String sHS;
    public String sHT;
    private String sHU;
    public String token;

    public c(String str, PayInfo payInfo) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        g.Dr();
        o oVar = new o(bi.a((Integer) g.Dq().Db().get(9, null), 0));
        this.sHU = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", oVar.toString());
        D(hashMap);
        aB(hashMap2);
    }

    public final int azx() {
        return 37;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.sFo = new ArrayList();
            try {
                this.fLC = "1".equals(jSONObject.optString("is_reg", "0"));
                this.token = jSONObject.optString("token", "");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Bankcard W = d.bLG().W(jSONObject2);
                    if (W != null) {
                        if ((2 == jSONObject2.optInt("bank_acc_type", 2) ? 1 : null) != null) {
                            W.field_cardType |= Bankcard.sRc;
                        }
                        W.field_bankcardTail = jSONObject2.optString("bank_tail");
                        W.sRk = "************" + W.field_bankcardTail;
                        W.field_trueName = jSONObject2.optString("true_name");
                        W.sRj = jSONObject2.optString("cre_id");
                        W.sQF = jSONObject2.optInt("cre_type", -1);
                        W.sRu = this.sHU;
                        W.sRv = 1 == jSONObject2.optInt("samecardexist", 0);
                        if (W.bLB()) {
                            W.field_desc = W.field_bankName;
                        } else if (W.bLD()) {
                            W.field_desc = ad.getContext().getString(a.i.uXG, new Object[]{W.field_bankName, W.field_bankcardTail});
                        } else if (W.bLA()) {
                            W.field_desc = ad.getContext().getString(a.i.veB, new Object[]{W.field_bankName, W.field_bankcardTail});
                        } else {
                            W.field_desc = ad.getContext().getString(a.i.uXV, new Object[]{W.field_bankName, W.field_bankcardTail});
                        }
                        JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                        if (optJSONObject != null) {
                            this.sHS = optJSONObject.optString("username");
                            this.sHT = optJSONObject.optString("app_recommend_desc");
                        }
                        this.sFo.add(W);
                    }
                }
                x.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.fLC + ",bankcard.size:" + this.sFo.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            }
        }
    }
}
