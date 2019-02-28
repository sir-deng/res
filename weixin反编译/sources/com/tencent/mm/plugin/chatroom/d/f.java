package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ac.h;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.protocal.c.pv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements com.tencent.mm.network.k {
    public int fBJ = 0;
    public String fBK;
    public final List<String> fBL;
    public final List<String> fBN;
    public List<String> fBO;
    public List<String> fBP;
    private final b gLB;
    private e gLE;
    public final List<String> leY;

    public f(String str, List<String> list) {
        x.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        a aVar = new a();
        aVar.hnT = new pu();
        aVar.hnU = new pv();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.hnS = 119;
        aVar.hnV = 37;
        aVar.hnW = 1000000037;
        this.gLB = aVar.Kf();
        pu puVar = (pu) this.gLB.hnQ.hnY;
        puVar.wfy = n.oK(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            ari ari = new ari();
            ari.wfS = n.oK(str2);
            linkedList.add(ari);
        }
        puVar.vNu = linkedList;
        puVar.lfj = linkedList.size();
        this.fBL = new LinkedList();
        this.leY = new LinkedList();
        this.fBN = new LinkedList();
        this.fBO = new LinkedList();
        this.fBP = new LinkedList();
        this.fBK = "";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 119;
    }

    private static boolean a(pv pvVar) {
        boolean z = false;
        if (!n.a(pvVar.vNv).toLowerCase().endsWith("@chatroom") || pvVar.lfj == 0) {
            x.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + pvVar.vNv + "] listCnt:" + pvVar.lfj);
            return false;
        }
        ag xVar = new com.tencent.mm.storage.x();
        xVar.dc(n.a(pvVar.wfy));
        xVar.dd(n.a(pvVar.wfA));
        xVar.de(n.a(pvVar.wfB));
        xVar.setUsername(n.a(pvVar.vNv));
        as.Hm();
        ar Ff = c.Ff();
        if (!Ff.Xx(xVar.field_username)) {
            Ff.S(xVar);
        }
        h hVar = new h();
        hVar.username = xVar.field_username;
        hVar.hni = pvVar.wbY;
        hVar.hnh = pvVar.wbZ;
        hVar.fWZ = 3;
        hVar.bC(false);
        hVar.fEo = -1;
        com.tencent.mm.ac.n.JW().a(hVar);
        ArrayList arrayList = new ArrayList();
        while (true) {
            boolean z2 = z;
            if (z2 >= pvVar.vNu.size()) {
                break;
            }
            if (((arj) pvVar.vNu.get(z2)).wFR == 0) {
                ag agVar;
                com.tencent.mm.storage.x Xv = Ff.Xv(n.a(((arj) pvVar.vNu.get(z2)).wfS));
                if (((int) Xv.gKO) != 0) {
                    Xv.Am();
                    Ff.a(Xv.field_username, Xv);
                    agVar = Xv;
                } else {
                    agVar = m.a(Xv, (arj) pvVar.vNu.get(z2));
                    Ff.S(agVar);
                }
                arrayList.add(agVar.field_username);
            }
            z = z2 + 1;
        }
        if (!arrayList.contains(q.FY())) {
            arrayList.add(q.FY());
            x.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(q.FY()));
        }
        return m.a(xVar.field_username, arrayList, q.FY());
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        pv pvVar = (pv) this.gLB.hnR.hnY;
        this.fBK = n.a(pvVar.vNv);
        int i4 = this.gLB.hnR.vIb;
        this.fBJ = pvVar.lfj;
        ar(pvVar.vNu);
        if (!bi.oN(this.fBK) && i4 == 0) {
            a(pvVar);
        }
        this.gLE.a(i2, i3, str, this);
    }

    private void ar(List<arj> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                i = ((arj) list.get(i2)).wFR;
                if (i == 0) {
                    this.fBP.add(n.a(((arj) list.get(i2)).wfS));
                } else if (i == 3) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((arj) list.get(i2)).wfS);
                    this.leY.add(n.a(((arj) list.get(i2)).wfS));
                } else if (i == 1) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((arj) list.get(i2)).wfS);
                    this.fBN.add(n.a(((arj) list.get(i2)).wfS));
                } else if (i == 2) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((arj) list.get(i2)).wfS);
                    this.fBL.add(n.a(((arj) list.get(i2)).wfS));
                } else if (i == 4) {
                    x.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((arj) list.get(i2)).wfS);
                    this.fBO.add(n.a(((arj) list.get(i2)).wfS));
                } else if (!(i == 5 || i == 6)) {
                    x.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = " + i);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
