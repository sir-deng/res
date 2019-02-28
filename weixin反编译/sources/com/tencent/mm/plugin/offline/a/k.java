package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends i {
    public static String pcl = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    public String pcg = "";
    public String pch = "";
    public String pci = "";
    public String pcj = "";
    public String pck = "";
    public String pcm = "";
    public int pcn = 0;
    public String pco = "";
    public String pcp = "";
    public String pcq = "";
    public int pcr = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    public String token = "";

    public k(Bankcard bankcard, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", q.yM());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.vHl));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.pcr = i;
        String VF = ac.VF(ac.VF(e.getUsername()) + ac.VF(q.yM()));
        hashMap.put("user_id", VF);
        a cCe = a.cCe();
        b.cBW();
        String dE = cCe.dE(VF, b.cBY() ? 1 : 0);
        Object[] objArr = new Object[2];
        objArr[0] = dE;
        b.cBW();
        objArr[1] = Boolean.valueOf(b.cBY());
        x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", objArr);
        hashMap.put("crt_csr", dE);
        hashMap.put(Columns.TYPE, pcl);
        hashMap.put("version_number", pcl);
        D(hashMap);
    }

    public final int azx() {
        return 46;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pch = jSONObject.optString("crt_crt");
            this.pcg = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.pci = jSONObject.optString("valid_end");
            this.pcj = jSONObject.optString("encrypt_str");
            this.pck = jSONObject.optString("deviceid");
            if (a.cCe().importCert(this.pcg, this.pch)) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.pcm = jSONObject.optString("token_v2");
            this.pcn = jSONObject.optInt("algorithm_type");
            this.pco = jSONObject.optString("card_list");
            this.pcp = jSONObject.optString("key_list");
            this.pcq = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            Object optString3 = jSONObject.optString("code_ver");
            int optInt2 = jSONObject.optInt("cipher_type", 0);
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196617, this.pcg);
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196626, this.pci);
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196627, this.pcj);
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196628, this.pck);
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196630, "1");
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196632, (System.currentTimeMillis() / 1000));
            com.tencent.mm.plugin.offline.c.a.k(this.token, this.pcm, this.pco, this.pcp);
            com.tencent.mm.plugin.offline.c.a.uL(this.pcn);
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196647, this.pcq);
            com.tencent.mm.plugin.offline.c.a.HC(optString);
            com.tencent.mm.plugin.offline.k.bhD();
            optString = com.tencent.mm.plugin.offline.k.uF(196617);
            a.cCe();
            a.clearToken(optString);
            a.cCe();
            x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", Boolean.valueOf(a.u(this.pcg, optString2, optInt2 == 1)), this.pcg);
            if (a.u(this.pcg, optString2, optInt2 == 1)) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                a.cCe();
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(a.getLastError()).toString());
            }
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196649, String.valueOf(optInt));
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, q.yL());
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, optString3);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.offline.k.bhD();
            com.tencent.mm.plugin.offline.k.aA(196630, "0");
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, true);
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cCe().cCf();
    }

    public final int Hx() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
