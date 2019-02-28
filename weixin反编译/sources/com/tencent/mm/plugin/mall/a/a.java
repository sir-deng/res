package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.aer;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private String oqq;
    public ArrayList<MallFunction> oqr;
    public ArrayList<MallNews> oqs;
    public ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> oqt;
    public SparseArray<String> oqu;
    public int oqv;

    public a(int i, String str) {
        this(i, str, null, null);
    }

    public a(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}));
    }

    private a(int i, String str, String str2, String str3) {
        List bMR;
        this.oqr = null;
        this.oqs = null;
        this.oqt = null;
        this.oqu = null;
        this.oqv = 0;
        this.oqv = i;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new aer();
        aVar.hnU = new aes();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.hnS = 495;
        aVar.hnV = GameJsApiGetOpenDeviceId.CTRL_BYTE;
        aVar.hnW = 1000000227;
        this.gLB = aVar.Kf();
        aer aer = (aer) this.gLB.hnQ.hnY;
        aer.wtJ = str;
        LinkedList linkedList = new LinkedList();
        if (bi.oN(str2)) {
            bMR = c.bMQ().bMR();
        } else {
            List list;
            MallNews mallNews = (MallNews) c.bMQ().sWU.get(str2);
            if (mallNews == null || bi.oN(mallNews.fsK)) {
                list = null;
            } else {
                bMR = new ArrayList();
                bMR.add(mallNews.fsK);
                list = bMR;
            }
            bMR = list;
        }
        if (bMR != null && bMR.size() > 0) {
            String str4;
            String str5 = "";
            Iterator it = bMR.iterator();
            while (true) {
                str4 = str5;
                if (!it.hasNext()) {
                    break;
                }
                str5 = (String) it.next();
                bet bet = new bet();
                bet.Vf(str5);
                linkedList.add(bet);
                str5 = str4 + "; + " + str5;
            }
            x.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : " + str4);
        }
        aer.wtL = linkedList;
        aer.wtK = linkedList.size();
        if (bi.oN(str3)) {
            aer.nqi = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            aer.nqi = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        this.oqq = str2;
        x.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + aer.nqi);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            aes aes = (aes) ((b) qVar).hnR.hnY;
            x.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.oqv + " " + aes.wtM);
            try {
                if (!bi.oN(aes.wtM)) {
                    JSONObject jSONObject = new JSONObject(aes.wtM);
                    String optString = jSONObject.optString("pay_func_list");
                    this.oqr = com.tencent.mm.plugin.wallet_core.model.mall.b.y(new JSONArray(optString));
                    o.bMh().b(this.oqv, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"));
                    d.aYD().oqy.clear();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 495;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
