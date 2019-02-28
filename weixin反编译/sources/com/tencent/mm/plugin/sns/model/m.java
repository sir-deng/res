package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bks;
import com.tencent.mm.protocal.c.bkt;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class m extends k implements com.tencent.mm.network.k {
    private static Vector<String> qZQ = new Vector();
    private String desc = "";
    final int fqY;
    private b gLB;
    public e gLE;
    private boolean kRY = false;
    private ArrayList<com.tencent.mm.plugin.sns.storage.m> kST = new ArrayList();
    private boolean qZN;
    private long qZO = 0;
    private long qZP = 0;
    public int qZR = 0;
    public int qZS = 0;

    public static synchronized boolean KH(String str) {
        boolean z;
        synchronized (m.class) {
            if (qZQ.contains(str)) {
                z = false;
            } else {
                qZQ.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean KI(String str) {
        synchronized (m.class) {
            qZQ.remove(str);
        }
        return true;
    }

    public m(String str) {
        a aVar = new a();
        aVar.hnT = new bks();
        aVar.hnU = new bkt();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.hnS = 601;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.qZO = 0;
        this.qZN = 0 == 0;
        this.fqY = 2;
        bks bks = (bks) this.gLB.hnQ.hnY;
        bks.wUA = "";
        bks.wUB = 0;
        bks.wUC = str;
        bks.wUD = 1;
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", i.er(0), str, Integer.valueOf(0));
    }

    private com.tencent.mm.plugin.sns.storage.m b(blf blf) {
        com.tencent.mm.plugin.sns.storage.m mVar = new com.tencent.mm.plugin.sns.storage.m();
        String str = new String(blf.wUN.wRm.toByteArray());
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", Long.valueOf(blf.vWS));
        if (!mVar.LP(str)) {
            return null;
        }
        blf.wUN.bl(new byte[0]);
        mVar.field_userName = blf.vPp;
        mVar.hN(blf.pgR);
        mVar.field_likeFlag = blf.wUO;
        mVar.eO(blf.vWS);
        mVar.eQ(blf.vWS);
        mVar.xB(this.fqY);
        try {
            mVar.aL(blf.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
        }
        bpb byF = mVar.byF();
        byF.kyG = blf.vPp;
        mVar.field_pravited = byF.wER;
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + blf.wGH);
        mVar.byX();
        mVar.c(byF);
        mVar.field_type = byF.wYj.wfg;
        mVar.field_subType = byF.wYj.wfi;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bkt bkt = (bkt) ((b) qVar).hnR.hnY;
        if (qVar.Hv().vIb == 207 || qVar.Hv().vIb == 0 || qVar.Hv().vIb == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            this.kRY = qVar.Hv().vIb == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
            this.qZR = bkt.wUE;
            this.desc = bkt.vPF;
            i.es(this.qZO);
            x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", Integer.valueOf(bkt.wGO), this.desc);
            Iterator it = bkt.vSf.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.m b = b((blf) it.next());
                if (b != null) {
                    this.kST.add(b);
                }
            }
            KI("@__classify_timeline");
            this.gLE.a(i2, i3, str, this);
            return;
        }
        KI("@__classify_timeline");
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 601;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
