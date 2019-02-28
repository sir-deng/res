package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class j extends l {
    private static int zRy = 0;
    public RealnameGuideHelper pbX;
    private String pbY;
    private String pbZ;
    private String pca;
    private String pcb;
    private String pcc;
    protected int pfQ;
    public int sUo = 0;
    public int zRA = 0;
    public int zRB = 0;
    public String zRC = null;
    public JSONObject zRD = null;
    private boolean zRE = false;
    protected Map<String, String> zRw = new HashMap();
    public int zRx = 0;
    private boolean zRz = false;

    public final void a(String str, String str2, int i, int i2, String str3, String str4) {
        zRy++;
        this.zRw.put("req_key", str);
        this.zRw.put("transaction_id", str2);
        this.zRw.put("pay_scene", String.valueOf(i));
        this.zRw.put("bank_type", str3);
        this.zRw.put("channel", String.valueOf(i2));
        this.zRw.put("bind_serial", str4);
    }

    public final Map<String, String> cCI() {
        return this.zRw;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        JSONObject optJSONObject;
        int i2 = 0;
        if (!this.zRz) {
            this.zRB = i;
            this.zRC = str;
            this.zRD = jSONObject;
            this.zRz = true;
            if (jSONObject != null) {
                this.zRx = jSONObject.optInt("query_order_flag", 0);
            }
        }
        if (jSONObject != null && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.pbY = optJSONObject.optString("guide_flag");
            this.pbZ = optJSONObject.optString("guide_wording");
            this.pca = optJSONObject.optString("left_button_wording");
            this.pcb = optJSONObject.optString("right_button_wording");
            this.pcc = optJSONObject.optString("upload_credit_url");
            i2 = 1;
        }
        SetPwdInfo setPwdInfo = null;
        if (jSONObject != null && jSONObject.has("set_pwd_info")) {
            optJSONObject = jSONObject.optJSONObject("set_pwd_info");
            setPwdInfo = new SetPwdInfo();
            setPwdInfo.oja = optJSONObject.optString("guide_wording");
            setPwdInfo.ojb = optJSONObject.optString("left_button_wording");
            setPwdInfo.ojc = optJSONObject.optString("right_button_wording");
            setPwdInfo.sQA = optJSONObject.optInt("send_pwd_msg");
            i2 = 1;
        }
        if (i2 != 0 && ("1".equals(this.pbY) || "2".equals(this.pbY) || setPwdInfo != null)) {
            this.pbX = new RealnameGuideHelper();
            this.pbX.a(this.pbY, setPwdInfo, this.pbZ, this.pca, this.pcb, this.pcc, this.pfQ);
        }
        this.zRE = true;
        super.a(i, str, jSONObject);
    }

    public final boolean cCJ() {
        return this.zRx == 1;
    }

    public final void a(c cVar, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", Integer.valueOf(cVar.errCode), cVar.foE);
        if (!this.zRE && !this.zRz) {
            this.zRA = cVar.errType;
            this.zRB = cVar.errCode;
            this.zRC = cVar.foE;
            if (jSONObject != null) {
                this.zRx = jSONObject.optInt("query_order_flag", 0);
                this.zRD = jSONObject;
            }
            this.zRz = true;
        }
    }

    public boolean bKD() {
        return false;
    }

    public final boolean cCy() {
        return false;
    }
}
