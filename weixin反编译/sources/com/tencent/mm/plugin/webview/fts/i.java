package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.protocal.c.cbk;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONObject;

public final class i extends a implements k {
    private e gLE;
    private b hGV;
    private d hlp;
    private int scene;
    private int tqs;
    private cbl ttn;
    private cbk tto;

    public i(d dVar) {
        float f = 0.0f;
        boolean z = false;
        this.hlp = dVar;
        this.tqp = dVar.foW;
        this.tqq = dVar.hMN;
        this.wn = dVar.offset;
        this.itU = dVar.scene;
        this.tqo = dVar.fEg;
        this.tqs = dVar.tqs;
        this.hlp = dVar;
        this.tqr = dVar.tqK;
        if (bi.oN(dVar.foW)) {
            x.e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            return;
        }
        int i;
        float f2;
        x.i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", dVar.foW);
        this.scene = dVar.scene;
        b.a aVar = new b.a();
        aVar.hnS = 719;
        aVar.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        aVar.hnT = new cbk();
        aVar.hnU = new cbl();
        this.hGV = aVar.Kf();
        this.tto = (cbk) this.hGV.hnQ.hnY;
        this.tto.wnX = dVar.foW;
        this.tto.wQu = dVar.tqs;
        this.tto.vWt = (long) dVar.hMM;
        this.tto.wDT = g.Jk();
        this.tto.vUN = dVar.offset;
        this.tto.xfY = g.Af(0);
        this.tto.wRM = dVar.tqt;
        this.tto.sfa = dVar.scene;
        this.tto.vWw = dVar.lKv;
        this.tto.xhg = dVar.tqu;
        this.tto.xhm = dVar.tqv;
        this.tto.xho = dVar.tqx;
        this.tto.xhn = dVar.tqw;
        this.tto.xhp = dVar.tqy;
        this.tto.xhh = dVar.tqD;
        this.tto.tqC = dVar.tqC;
        this.tto.xhq = dVar.tqE;
        this.tto.lTZ = dVar.ael;
        this.tto.xgc = dVar.frp;
        if (dVar.tqH == null) {
            dVar.tqH = new cbg();
        }
        if (dVar.tqH.xhj == null) {
            dVar.tqH.xhj = new io();
        }
        if (this.tto.wDT != null) {
            io ioVar = dVar.tqH.xhj;
            c OV = c.OV();
            if (OV.hzD <= 0 || !OV.hzF || System.currentTimeMillis() - OV.hzD >= 600000) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            ioVar.vVs = i2 != 0 ? 0 : 1;
            f = this.tto.wDT.vXx;
            f2 = this.tto.wDT.vXy;
        } else {
            dVar.tqH.xhj.vVs = 1;
            f2 = 0.0f;
        }
        x.i("MicroMsg.FTS.NetSceneWebSearch", "websearch location: longitude[%f], latitude[%f], isUsingCached[%d]", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(dVar.tqH.xhj.vVs));
        if (!TextUtils.isEmpty(dVar.tqI)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(dVar.tqI));
                ayl ayl = new ayl();
                ayl.hxg = jSONObject.optString("city");
                ayl.hxn = jSONObject.optString("country");
                ayl.vXy = (float) jSONObject.optDouble("latitude");
                ayl.vXx = (float) jSONObject.optDouble("longitude");
                ayl.wMa = jSONObject.optString("poiId");
                ayl.wyY = jSONObject.optString("poiName");
                ayl.wMc = com.tencent.mm.bb.b.lV(jSONObject.optString("snsId"));
                if (!TextUtils.isEmpty(ayl.wMa)) {
                    this.tto.xhv = ayl;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.NetSceneWebSearch", e, "", new Object[0]);
            }
        }
        if (dVar.tqH != null) {
            try {
                this.tto.xhs = new com.tencent.mm.bp.b(dVar.tqH.toByteArray());
            } catch (Exception e2) {
            }
        }
        if (dVar.tqG != null) {
            try {
                this.tto.xhr = new com.tencent.mm.bp.b(dVar.tqG.toByteArray());
            } catch (Exception e3) {
            }
        }
        String str = "MicroMsg.FTS.NetSceneWebSearch";
        String str2 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(this.tto.wDT != null);
        objArr[1] = Integer.valueOf(dVar.tqt.size());
        objArr[2] = Integer.valueOf(dVar.scene);
        objArr[3] = Integer.valueOf(dVar.hMM);
        objArr[4] = Integer.valueOf(this.tqs);
        objArr[5] = Integer.valueOf(dVar.tqu);
        objArr[6] = Integer.valueOf(dVar.fEg);
        x.i(str, str2, objArr);
        if (this.tto.wDT != null) {
            o.a(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, this.tto.wDT.vXx, this.tto.wDT.vXy, this.tto.wDT.wjv);
        }
        i2 = dVar.scene;
        str = dVar.frp;
        str2 = dVar.tpV;
        String str3 = dVar.lKv;
        int i3 = dVar.offset;
        if (dVar.tqs == 1) {
            z = true;
        }
        f.a(i2, str, str2, str3, i3, z, dVar.hMN, dVar.foW, dVar.hMM, "");
    }

    public final int getType() {
        return 719;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        com.tencent.mm.bb.g.bl(this.scene, 2);
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        boolean z = i2 == 0 && i3 == 0;
        if (i2 == 0 && i3 == 0) {
            this.ttn = (cbl) this.hGV.hnR.hnY;
            if (this.ttn != null) {
                f.a(this.hlp.scene, this.hlp.frp, this.hlp.tpV, this.hlp.lKv, this.hlp.offset, this.hlp.tqs == 1, this.hlp.hMN, z, this.hlp.foW, this.hlp.hMM);
                x.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", this.ttn.vUV);
            }
            this.gLE.a(i2, i3, str, this);
            com.tencent.mm.bb.g.z(this.scene, i2, i3);
            return;
        }
        this.gLE.a(i2, i3, str, this);
        f.a(this.hlp.scene, this.hlp.frp, this.hlp.tpV, this.hlp.lKv, this.hlp.offset, this.hlp.tqs == 1, this.hlp.hMN, z, this.hlp.foW, this.hlp.hMM);
        com.tencent.mm.bb.g.z(this.scene, i2, i3);
    }

    public final String Ji() {
        return this.ttn != null ? this.ttn.vUV : "";
    }

    public final int Jj() {
        return this.ttn != null ? this.ttn.xgi : 0;
    }

    public final void ap(LinkedList<btb> linkedList) {
        this.tto.wRM = linkedList;
        bkx bkx = new bkx();
        bkx.wUI = linkedList.size();
        this.tto.xht = bkx;
    }
}
