package com.tencent.mm.wallet_core.c;

import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public boolean fIo = true;
    private int zQv = 0;
    private a zQw = null;

    public interface a {
        void bNK();
    }

    private static void az(Map<String, String> map) {
        int i;
        int i2 = 1;
        g.Dr();
        g.Do();
        String string = o.getString(com.tencent.mm.kernel.a.Cn());
        String deviceID = q.getDeviceID(ad.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = n.cCi().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i3 = 0;
        int i4 = 0;
        do {
            bArr[i4] = bytes[i3];
            i4++;
            i3++;
            if (i3 >= bytes.length) {
                i3 = 0;
                continue;
            }
        } while (i4 < 16);
        String str = new String(bArr);
        String VF = ac.VF(string + deviceID);
        String VF2 = ac.VF(string + VF + new String(bArr));
        x.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        x.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", string, deviceID, VF2);
        a cCe = a.cCe();
        b.cBW();
        c fp = com.tencent.mm.y.c.c.IL().fp("100369");
        if (fp.isValid() && "1".equals(fp.civ().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", Integer.valueOf(i));
        if ((i > 0 ? 1 : 0) == 0) {
            i2 = 0;
        }
        String dE = cCe.dE(VF2, i2);
        try {
            map.put("sn_salt", p.encode(str));
            map.put("crt_csr", p.encode(dE));
            map.put("crt_device_id", VF);
            map.put("device_os", d.DEVICE_TYPE);
            map.put("device_name", d.vHh);
        } catch (Exception e) {
        }
    }

    public f(String str, int i, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.zQv = 1;
        az(hashMap);
        hashMap.put(Columns.TYPE, p.encode("1"));
        hashMap.put("true_name", p.encode(str2));
        hashMap.put("id_no", p.encode(str));
        hashMap.put("id_type", p.encode(String.valueOf(i)));
        D(hashMap);
        aB(hashMap2);
    }

    public f(String str, String str2, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.fIo = z;
        this.zQv = 2;
        az(hashMap);
        hashMap.put(Columns.TYPE, p.encode("2"));
        hashMap.put("crt_sms", p.encode(str));
        hashMap.put("reqkey", p.encode(str2));
        this.zQw = aVar;
        D(hashMap);
        aB(hashMap2);
    }

    public f(String str, String str2, String str3, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.zQv = 4;
        this.zQw = aVar;
        this.fIo = z;
        az(hashMap);
        hashMap.put(Columns.TYPE, p.encode("4"));
        hashMap.put("id_type", p.encode(str));
        hashMap.put("cre_tail", p.encode(str2));
        hashMap.put("reqkey", p.encode(str3));
        D(hashMap);
        aB(hashMap2);
    }

    public final int azx() {
        return 1580;
    }

    public final int Hx() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", Integer.valueOf(i), str);
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            com.tencent.mm.plugin.report.service.g.pWK.a(414, 0, 1, true);
            boolean importCert = a.cCe().importCert(optString2, optString);
            r.abf(optString2);
            if (importCert) {
                com.tencent.mm.plugin.report.service.g.pWK.a(414, 1, 1, true);
                x.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(414, 2, 1, true);
                x.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.zQv == 1) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13731, Integer.valueOf(3));
            } else if (this.zQv == 2) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13731, Integer.valueOf(7));
            }
            x.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", ac.VF(optString), optString2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
        }
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cCe().cCf();
        if (cVar.errCode != 0) {
            if (this.zQv == 1) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13731, Integer.valueOf(4));
            } else if (this.zQv == 2) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13731, Integer.valueOf(8));
            }
        }
        if (this.zQw == null) {
            return;
        }
        if (!this.fIo || cVar.errCode == 0) {
            this.zQw.bNK();
        }
    }

    public final boolean bhJ() {
        return this.fIo;
    }
}
