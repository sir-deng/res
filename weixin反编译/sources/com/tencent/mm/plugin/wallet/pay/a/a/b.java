package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b extends j {
    private Map<String, String> pcB;
    private String sKA;
    public int sKB;
    public String sKC;
    public int sKD;
    private Map<String, String> sKu;
    public boolean sKv;
    public Orders sKw;
    public Authen sKx;
    public String sKy;
    public String sKz;
    public String token;

    public b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private b(Authen authen, Orders orders, boolean z, byte b) {
        String str = null;
        this.sKv = false;
        this.sKw = null;
        this.token = null;
        this.sKy = null;
        this.sKz = null;
        this.sKA = null;
        this.sKB = 0;
        this.sKD = 0;
        this.sKx = authen;
        this.sKw = orders;
        if (authen == null) {
            throw new IllegalArgumentException("authen == null");
        }
        List list = orders.sUf;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fvD;
        }
        a(orders.fvC, str, authen.pHW.fDQ, authen.pHW.fDM, authen.pff, authen.pfg);
        if (authen.pHW == null) {
            throw new IllegalArgumentException("authen.payInfo == null");
        }
        x.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.pHW.fDM);
        this.pcB = new HashMap();
        this.sKu = new HashMap();
        boolean z2 = (z || bi.oN(this.sKx.sQC)) ? false : true;
        x.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", Boolean.valueOf(z2));
        a(authen.pHW, this.pcB, this.sKu, z2);
        if (z) {
            this.pcB.put("brief_reg", "1");
        } else {
            this.pcB.put("passwd", authen.sQC);
        }
        this.sUo = orders.sUo;
        this.pcB.put("default_favorcomposedid", authen.sQN);
        this.pcB.put("favorcomposedid", authen.sQO);
        this.pcB.put("arrive_type", authen.sQK);
        this.pcB.put("sms_flag", authen.sQP);
        this.pcB.put("ban_sms_bind_serial", authen.sQQ);
        this.pcB.put("ban_sms_bank_type", authen.sQR);
        this.pcB.put("busi_sms_flag", authen.sQS);
        this.pcB.put("buttontype", authen.pHW.vGr);
        x.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s", Integer.valueOf(authen.pHW.vGr), Integer.valueOf(this.sUo));
        switch (authen.fEo) {
            case 1:
                this.pcB.put("flag", "1");
                this.pcB.put("bank_type", authen.pff);
                this.pcB.put("true_name", authen.sQD);
                this.pcB.put("identify_card", authen.sQE);
                if (authen.sQF > 0) {
                    this.pcB.put("cre_type", authen.sQF);
                }
                this.pcB.put("mobile_no", authen.sOP);
                this.pcB.put("bank_card_id", authen.sQG);
                if (!bi.oN(authen.sQH)) {
                    this.pcB.put("cvv2", authen.sQH);
                }
                if (!bi.oN(authen.sQI)) {
                    this.pcB.put("valid_thru", authen.sQI);
                    break;
                }
                break;
            case 2:
                this.pcB.put("flag", "2");
                this.pcB.put("bank_type", authen.pff);
                this.pcB.put("h_bind_serial", authen.pfg);
                this.pcB.put("card_tail", authen.sQJ);
                if (!bi.oN(authen.sQD)) {
                    this.pcB.put("true_name", authen.sQD);
                }
                if (!bi.oN(authen.sQE)) {
                    this.pcB.put("identify_card", authen.sQE);
                }
                this.pcB.put("cre_type", authen.sQF);
                this.pcB.put("mobile_no", authen.sOP);
                this.pcB.put("bank_card_id", authen.sQG);
                if (!bi.oN(authen.sQH)) {
                    this.pcB.put("cvv2", authen.sQH);
                }
                if (!bi.oN(authen.sQI)) {
                    this.pcB.put("valid_thru", authen.sQI);
                    break;
                }
                break;
            case 3:
                if (authen.sQB == 1) {
                    this.pcB.put("reset_flag", "1");
                    if (!bi.oN(authen.sOP)) {
                        this.pcB.put("mobile_no", authen.sOP);
                    }
                    if (!bi.oN(authen.sQH)) {
                        this.pcB.put("cvv2", authen.sQH);
                    }
                    if (!bi.oN(authen.sQI)) {
                        this.pcB.put("valid_thru", authen.sQI);
                    }
                }
                this.pcB.put("flag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                this.pcB.put("bank_type", authen.pff);
                this.pcB.put("bind_serial", authen.pfg);
                break;
            case 4:
                this.pcB.put("flag", "4");
                this.pcB.put("bank_type", authen.pff);
                this.pcB.put("first_name", authen.sQL);
                this.pcB.put("last_name", authen.sQM);
                this.pcB.put("country", authen.country);
                this.pcB.put("area", authen.fXk);
                this.pcB.put("city", authen.fXl);
                this.pcB.put("address", authen.hzf);
                this.pcB.put("phone_number", authen.nHv);
                this.pcB.put("zip_code", authen.iot);
                this.pcB.put("email", authen.fXd);
                this.pcB.put("bank_card_id", authen.sQG);
                if (!bi.oN(authen.sQH)) {
                    this.pcB.put("cvv2", authen.sQH);
                }
                if (!bi.oN(authen.sQI)) {
                    this.pcB.put("valid_thru", authen.sQI);
                    break;
                }
                break;
            case 5:
                this.pcB.put("flag", "5");
                this.pcB.put("bank_type", authen.pff);
                this.pcB.put("first_name", authen.sQL);
                this.pcB.put("last_name", authen.sQM);
                this.pcB.put("country", authen.country);
                this.pcB.put("area", authen.fXk);
                this.pcB.put("city", authen.fXl);
                this.pcB.put("address", authen.hzf);
                this.pcB.put("phone_number", authen.nHv);
                this.pcB.put("zip_code", authen.iot);
                this.pcB.put("email", authen.fXd);
                this.pcB.put("bank_card_id", authen.sQG);
                if (!bi.oN(authen.sQH)) {
                    this.pcB.put("cvv2", authen.sQH);
                }
                if (!bi.oN(authen.sQI)) {
                    this.pcB.put("valid_thru", authen.sQI);
                }
                this.pcB.put("h_bind_serial", authen.pfg);
                this.pcB.put("card_tail", authen.sQJ);
                break;
            case 6:
                if (authen.sQB == 1) {
                    this.pcB.put("reset_flag", "1");
                    if (!bi.oN(authen.sQH)) {
                        this.pcB.put("cvv2", authen.sQH);
                    }
                    if (!bi.oN(authen.sQI)) {
                        this.pcB.put("valid_thru", authen.sQI);
                    }
                }
                this.pcB.put("phone_number", authen.sOP);
                this.pcB.put("flag", "6");
                this.pcB.put("bank_type", authen.pff);
                this.pcB.put("bind_serial", authen.pfg);
                break;
        }
        S(this.pcB);
        D(this.pcB);
        Map aKV = ((l) g.h(l.class)).aKV();
        if (aKV != null) {
            this.sKu.putAll(aKV);
        }
        if (o.cCj()) {
            this.sKu.put("uuid_for_bindcard", o.cCl());
            this.sKu.put("bindcard_scene", o.cCk());
        }
        aB(this.sKu);
    }

    protected void S(Map<String, String> map) {
    }

    public final boolean bhI() {
        super.bhI();
        this.pcB.put("is_repeat_send", "1");
        D(this.pcB);
        return true;
    }

    public int azx() {
        return 0;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        x.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i + " errMsg :" + str);
        x.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", this.sKy);
        this.sKv = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.sKy = jSONObject.optString("balance_mobile");
        this.sKz = jSONObject.optString("balance_help_url");
        this.sKA = jSONObject.optString("modify_mobile_url");
        String optString = jSONObject.optString("bind_serial");
        if (!bi.oN(optString)) {
            x.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:" + optString);
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            this.sLK = true;
            this.sKw = Orders.a(jSONObject, this.sKw);
        } else {
            this.sLK = false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("verify_cre_tail_info");
        if (optJSONObject != null) {
            this.sKB = optJSONObject.optInt("is_can_verify_tail", 0);
            this.sKC = optJSONObject.optString("verify_tail_wording");
        }
        this.sKD = jSONObject.optInt("no_reset_mobile", 0);
        x.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.sKx.pHW.fDQ);
        if (i == 0 && this.sKx.pHW.fDQ == 39) {
            x.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            com.tencent.mm.plugin.wallet_core.e.b.ae(jSONObject);
            return;
        }
        x.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:" + i);
    }

    public final String biB() {
        return this.token;
    }

    public String getUri() {
        if (this.sKx.pHW.fDQ == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.sKx.pHW.fDQ == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    public int Hx() {
        if (this.sKx.pHW.fDQ == 11) {
            return 1610;
        }
        if (this.sKx.pHW.fDQ == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean bKC() {
        return this.sKx.pHW.tcd == 1;
    }

    public final boolean bKD() {
        if (this.sKx.pHW.fDQ == 11 || this.sKx.pHW.fDQ == 21) {
            return true;
        }
        return false;
    }
}
