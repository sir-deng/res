package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends h {
    public String pci;
    public String pcj;
    public String pck;
    public String pcm;
    public int pcn;
    public String pco;
    public String pcp;
    public String pcq;
    private String pcs;
    private int pct;
    public String pcu;
    public int pcv;
    int pcw;
    public String token;

    public m(String str, int i) {
        this(str, i, i);
    }

    public m(String str, int i, int i2) {
        int i3;
        CharSequence genUserSig;
        this.token = "";
        this.pci = "";
        this.pcj = "";
        this.pck = "";
        this.pcm = "";
        this.pcn = 0;
        this.pco = "";
        this.pcp = "";
        this.pcq = "";
        this.pcv = 0;
        this.pcw = 0;
        x.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", Integer.valueOf(i), bi.chl().toString());
        Object biB = a.biB();
        k.bhD();
        String uF = k.uF(196628);
        if (TextUtils.isEmpty(uF)) {
            uF = q.yM();
        }
        if (TextUtils.isEmpty(biB)) {
            uF = uF + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + Constants.MAX_BUFFER_SIZE);
        } else {
            uF = uF + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + Constants.MAX_BUFFER_SIZE) + "&" + biB;
        }
        Map hashMap = new HashMap();
        hashMap.put("token_src", uF);
        String str2 = "";
        k.bhD();
        String uF2 = k.uF(196617);
        switch (i2) {
            case 0:
                i3 = 12;
                break;
            case 1:
                i3 = 13;
                break;
            case 2:
                i3 = 14;
                break;
            case 3:
                i3 = 15;
                break;
            case 4:
                i3 = 16;
                break;
            case 5:
                i3 = 17;
                break;
            case 6:
                i3 = 18;
                break;
            case 7:
                i3 = 19;
                break;
            case 8:
                i3 = 20;
                break;
            case 9:
                i3 = 24;
                break;
            case 10:
                i3 = 72;
                break;
            default:
                i3 = 12;
                break;
        }
        g.pWK.a(135, (long) i3, 1, true);
        com.tencent.mm.wallet_core.c.a.cCe();
        if (com.tencent.mm.wallet_core.c.a.isCertExist(uF2)) {
            com.tencent.mm.wallet_core.c.a.cCe();
            genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(uF2, uF);
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cCe();
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
            g.pWK.a(135, 6, 1, true);
            com.tencent.mm.kernel.g.Dr();
            uF = (String) com.tencent.mm.kernel.g.Dq().Db().get(w.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, (Object) "");
            if (uF == null || !uF.equals(q.yL())) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                g.pWK.a(135, 5, 1, true);
            } else {
                x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
            }
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: " + uF2);
            Object genUserSig2 = str2;
        }
        if (TextUtils.isEmpty(genUserSig2)) {
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            g.pWK.a(135, 4, 1, true);
        } else {
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig2);
        hashMap.put("cert_no", uF2);
        hashMap.put(Columns.TYPE, k.pcl);
        hashMap.put("version_number", k.pcl);
        if (a.biA() == 2) {
            hashMap.put("last_token", a.biC());
        } else {
            hashMap.put("last_token", a.biB());
        }
        hashMap.put("scene", String.valueOf(i));
        x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", Boolean.valueOf(k.pbH));
        if (k.pbH) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", "0");
        }
        D(hashMap);
    }

    public final int azx() {
        if (k.pbH) {
            return 52;
        }
        return 1725;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.pci = jSONObject.optString("valid_end");
            this.pcj = jSONObject.optString("encrypt_str");
            this.pck = jSONObject.optString("deviceid");
            this.pcm = jSONObject.optString("token_v2");
            this.pcn = jSONObject.optInt("algorithm_type");
            this.pco = jSONObject.optString("card_list");
            this.pcp = jSONObject.optString("key_list");
            this.pcq = jSONObject.optString("token_pin");
            this.pcs = jSONObject.optString("auth_codes");
            this.pct = jSONObject.optInt("update_interval");
            this.pcu = jSONObject.optString("code_ver");
            this.pcv = jSONObject.optInt("reget_token_num", 0);
            this.pcw = jSONObject.optInt("cipher_type", 0);
            if (this.pcv > 0) {
                k.pbI = this.pcv;
            } else {
                k.pbI = 10;
            }
            x.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", jSONObject.toString());
        }
    }

    public final boolean bhK() {
        boolean z = true;
        x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        k.bhD();
        k.aA(196626, this.pci);
        k.bhD();
        k.aA(196627, this.pcj);
        k.bhD();
        k.aA(196628, this.pck);
        k.bhD();
        k.aA(196632, (System.currentTimeMillis() / 1000));
        a.k(this.token, this.pcm, this.pco, this.pcp);
        a.uL(this.pcn);
        k.bhD();
        k.aA(196647, this.pcq);
        k.bhD();
        String uF = k.uF(196617);
        com.tencent.mm.wallet_core.c.a.cCe();
        com.tencent.mm.wallet_core.c.a.clearToken(uF);
        com.tencent.mm.wallet_core.c.a.cCe();
        String str = this.pcs;
        if (this.pcw != 1) {
            z = false;
        }
        z = com.tencent.mm.wallet_core.c.a.u(uF, str, z);
        if (z) {
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cCe();
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
        }
        k.bhD();
        k.aA(196649, this.pct);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, this.pcu);
        return z;
    }

    public final int Hx() {
        if (k.pbH) {
            return 571;
        }
        return 1725;
    }

    public final String getUri() {
        if (k.pbH) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
        }
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
    }
}
