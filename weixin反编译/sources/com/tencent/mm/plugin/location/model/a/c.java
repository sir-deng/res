package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bct;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE;
    private Runnable hPS;
    public String jgc;
    public int nXM;
    public bpq nXN = null;
    public List<bte> nXO = null;
    public bcu nXP;
    public int nXQ;
    private String nXR;

    public c(String str, int i, bte bte, int i2, bpq bpq) {
        a aVar = new a();
        aVar.hnT = new bct();
        aVar.hnU = new bcu();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.hnS = 492;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bct bct = (bct) this.gLB.hnQ.hnY;
        bct.wiv = str;
        bct.kzz = i;
        bct.wPz = bte;
        bct.nnd = i2;
        bct.wPA = bpq;
        this.nXR = str;
        this.nXQ = bct.kzz;
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + bte.vPp + " " + bte.xbj.vUG + " " + bte.xbj.vUF + " heading:" + bte.xbj.wMf);
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + bpq.vUG + " " + bpq.vUF + " " + bpq.nkW);
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
    }

    public final int getType() {
        return 492;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.nXP = (bcu) ((b) qVar).hnR.hnY;
        if (this.nXP != null) {
            this.jgc = this.nXP.vXU;
        }
        if (i2 == 0 && i3 == 0) {
            this.nXM = this.nXP.wBI;
            this.nXN = this.nXP.wPC;
            this.nXO = this.nXP.wPB;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.nXP.kyA)}));
            if (this.nXN != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.nXN.vUG), Double.valueOf(this.nXN.vUF), this.nXN.nkW}));
            }
            x.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            List linkedList = new LinkedList();
            Iterator it = this.nXP.wPB.iterator();
            while (it.hasNext()) {
                bte bte = (bte) it.next();
                if (bte == null) {
                    linkedList.add(bte);
                } else {
                    if (bte.xbj == null) {
                        linkedList.add(bte);
                    }
                    if (Math.abs(bte.xbj.vUF) > 180.0d || Math.abs(bte.xbj.vUG) > 90.0d) {
                        x.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", bte.vPp, Double.valueOf(bte.xbj.vUG), Double.valueOf(bte.xbj.vUF), Double.valueOf(bte.xbj.wMf));
                        linkedList.add(bte);
                    }
                }
            }
            this.nXP.kyA = this.nXP.wPB.size();
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
        if (this.hPS != null) {
            this.hPS.run();
        }
    }
}
