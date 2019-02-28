package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.box;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class i extends h {
    public static Vector<String> zRv = new Vector();
    protected boolean zRu = false;

    public abstract int azx();

    public int bLf() {
        return azx();
    }

    public void F(boolean z, boolean z2) {
        b Kf;
        b bVar = this.gLB;
        if (bVar == null) {
            a aVar = new a();
            aVar.hnT = new box();
            aVar.hnU = new boy();
            String uri = getUri();
            int Hx = Hx();
            aVar.uri = uri;
            aVar.hnS = Hx;
            aVar.hnV = 185;
            aVar.hnW = 1000000185;
            Kf = aVar.Kf();
            Kf.hoh = !cCy();
        } else {
            Kf = bVar;
        }
        box box = (box) Kf.hnQ.hnY;
        if (z) {
            box.wyF = azx();
        }
        if (z2) {
            box.wyG = 1;
        }
        this.gLB = Kf;
    }

    public boolean cCy() {
        return true;
    }

    public int getType() {
        return 385;
    }

    public final String Nu(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bes bes) {
        ((box) bVar.hnQ.hnY).wyH = bes;
    }

    public final void b(b bVar, bes bes) {
        ((box) bVar.hnQ.hnY).wLK = bes;
    }

    static {
        for (Object add : d.vGt) {
            zRv.add(add);
        }
    }

    public final m d(b bVar) {
        boy boy = (boy) bVar.hnR.hnY;
        m mVar = new m();
        mVar.wyL = boy.wyL;
        mVar.wyK = boy.wyK;
        mVar.wyJ = boy.wyJ;
        mVar.wyI = boy.wyI;
        mVar.lUd = boy.wLM;
        mVar.zQJ = boy.wLL;
        return mVar;
    }

    private int e(b bVar) {
        String str;
        box box = (box) bVar.hnQ.hnY;
        if (box.wyH != null) {
            str = new String(box.wyH.wRm.oz);
        }
        if (box.wLK != null) {
            str = new String(box.wLK.wRm.oz);
        }
        s.cCs();
        if (!this.zRu) {
            return -1;
        }
        boy boy = (boy) bVar.hnR.hnY;
        if (boy == null) {
            boy = new boy();
        }
        boy.wyI = new bes().bl("".getBytes());
        boy.wyL = bLf();
        boy.wyJ = 0;
        try {
            JSONObject jSONObject = new JSONObject(null);
            boy.wLL = jSONObject.optInt("TenpayErrType");
            boy.wLM = jSONObject.optString("TenpayErrMsg");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
        a(1, 0, 0, "", bVar, null);
        return 1;
    }

    public final void cCH() {
        this.zRu = true;
    }

    public int a(e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        if (zRv.contains(this.gLB.uri)) {
            x.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", this.gLB.uri);
        } else {
            Object[] objArr = new Object[1];
            com.tencent.mm.wallet_core.c.a.cCe();
            objArr[0] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
            x.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.c.a.cCe();
            com.tencent.mm.wallet_core.c.a.init(ad.getContext());
            box box = (box) this.gLB.hnQ.hnY;
            String str = "";
            String str2 = "";
            if (box.wyH != null) {
                str = new String(box.wyH.wRm.oz);
            }
            if (box.wLK != null) {
                str2 = new String(box.wLK.wRm.oz);
            }
            String str3 = new String((str + "&&" + str2).getBytes());
            r.cCq();
            String cCp = r.cCp();
            com.tencent.mm.wallet_core.c.a.cCe();
            if (com.tencent.mm.wallet_core.c.a.isCertExist(cCp)) {
                g.pWK.a(414, 20, 1, true);
                com.tencent.mm.wallet_core.c.a.cCe();
                String genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(cCp, str3);
                g.pWK.a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                x.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", str3, genUserSig);
                box.sign = genUserSig;
                box.wYd = cCp;
            } else {
                objArr = new Object[2];
                objArr[0] = cCp;
                com.tencent.mm.wallet_core.c.a.cCe();
                objArr[1] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
                x.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            x.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), cCp);
        }
        if (this.zRu) {
            int e = e(this.gLB);
            if (e != -1) {
                return e;
            }
        }
        if (q.Gl()) {
            x.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            eVar2.a(1000, -100868, "Pay Method Err", this);
            return 1;
        }
        return a(eVar, this.gLB, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int Hx() {
        return 385;
    }
}
