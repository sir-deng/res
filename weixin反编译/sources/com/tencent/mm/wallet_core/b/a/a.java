package com.tencent.mm.wallet_core.b.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends l {
    private b gLB;
    private e gLE;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String azu();

    public abstract int azv();

    public final void D(Map<String, String> map) {
        int i = 0;
        if (this.gLB == null) {
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new aks();
            aVar.hnU = new akt();
            aVar.uri = azu();
            aVar.hnS = getType();
            aVar.hnV = 0;
            aVar.hnW = 0;
            this.gLB = aVar.Kf();
            this.gLB.hoh = true;
        }
        aks aks = (aks) this.gLB.hnQ.hnY;
        aks.wyF = azv();
        aks.wyG = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < toArray.length) {
                Object obj = toArray[i2];
                String str = (String) map.get(obj);
                if (!bi.oN(str)) {
                    if (i3 != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    boolean z = true;
                }
                i = i2 + 1;
            } else {
                x.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + aks.wyF + ", req = " + stringBuilder.toString());
                aks.wyH = new bes().bl(stringBuilder.toString().getBytes());
                return;
            }
        }
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + azv() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str + " " + getType());
        akt akt = (akt) ((b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            int i3 = akt.wyJ;
            String b = n.b(akt.wyI);
            if (i3 != 0 || bi.oN(b)) {
                str = akt.wyK;
                i2 = 2;
                i = 1000;
            } else {
                i3 = akt.frq;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    b = jSONObject.optString("retmsg");
                    if (bi.oN(b)) {
                        b = akt.errorMsg;
                    }
                    if ((i4 == 0 && i3 == 0) || azw()) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = DownloadResult.CODE_UNDEFINED;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = 1000;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", e, "", new Object[0]);
                    str = ad.getContext().getString(i.uXI);
                    i2 = 2;
                    i = 1000;
                }
            }
        } else {
            Map y = bj.y(str, "e");
            if (y != null) {
                x.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
                str = (String) y.get(".e.Content");
            } else {
                str = ad.getContext().getString(i.uXI);
            }
        }
        if (i != 0) {
            x.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + azv() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.gLE.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public boolean azw() {
        return false;
    }
}
