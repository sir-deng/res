package com.tencent.mm.modelfriend;

import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aa extends k implements com.tencent.mm.network.k {
    private int fvG;
    private e gLE;
    public final List<String> hyp;
    public final List<String> hyq;
    private final String hyr = ((String) c.Db().get(6, null));
    private int hys = 0;
    private int hyt = 0;

    public aa(List<String> list, List<String> list2) {
        as.Hm();
        this.hyp = list;
        this.hyq = list2;
        this.fvG = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.gLE = eVar2;
        if ((this.hyp == null || this.hyp.size() == 0) && (this.hyq == null || this.hyq.size() == 0)) {
            x.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            return -1;
        }
        a aVar = new a();
        aVar.hnT = new bsa();
        aVar.hnU = new bsb();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.hnS = d.CTRL_INDEX;
        aVar.hnV = 0;
        aVar.hnW = 0;
        q Kf = aVar.Kf();
        bsa bsa = (bsa) Kf.hnQ.hnY;
        bsa.vSS = this.hyr;
        bsa.kyG = com.tencent.mm.y.q.FY();
        bsa.vQC = this.fvG;
        int i2 = 200;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.hyp != null && this.hys < this.hyp.size()) {
                if (this.hyp.get(this.hys) != null) {
                    ars ars = new ars();
                    ars.v = (String) this.hyp.get(this.hys);
                    linkedList.add(ars);
                }
                this.hys++;
                i2--;
            }
            if (this.hyq != null && this.hyt < this.hyq.size()) {
                if (this.hyq.get(this.hyt) != null) {
                    aps aps = new aps();
                    aps.v = (String) this.hyq.get(this.hyt);
                    linkedList2.add(aps);
                }
                this.hyt++;
                i2--;
            }
            if ((this.hyq == null || this.hyt >= this.hyq.size()) && (this.hyp == null || this.hys >= this.hyp.size())) {
                break;
            }
        }
        bsa.wCM = linkedList;
        bsa.wZQ = linkedList.size();
        bsa.wZS = linkedList2;
        bsa.wZR = linkedList2.size();
        String str = "MicroMsg.NetSceneUploadMContact";
        StringBuilder append = new StringBuilder("doscene in:[").append(this.hyq == null ? 0 : this.hyq.size()).append(",");
        if (this.hyp != null) {
            i = this.hyp.size();
        }
        x.v(str, append.append(i).append("] index:[").append(this.hyt).append(",").append(this.hys).append("] req:[").append(bsa.wZS.size()).append(",").append(bsa.wCM.size()).append("]").toString());
        return a(eVar, Kf, this);
    }

    public final boolean Kj() {
        return true;
    }

    protected final int a(q qVar) {
        bsa bsa = (bsa) ((b) qVar).hnQ.hnY;
        int size = bsa.wZS.size() + bsa.wCM.size();
        if (size == 0 || size > 200) {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            return b.hoA;
        } else if (bsa.vSS == null || bsa.vSS.length() <= 0) {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            return b.hoA;
        } else if (bsa.kyG != null && bsa.kyG.length() > 0) {
            return b.hoz;
        } else {
            x.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            return b.hoA;
        }
    }

    protected final int Bo() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bsa bsa = (bsa) ((b) qVar).hnQ.hnY;
            m.M(O(bsa.wZS));
            m.M(P(bsa.wCM));
            if ((this.hyq == null || this.hyt >= this.hyq.size()) && (this.hyp == null || this.hys >= this.hyp.size())) {
                this.gLE.a(i2, i3, str, this);
                return;
            } else if (a(this.hok, this.gLE) < 0) {
                this.gLE.a(i2, i3, str, this);
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    private static List<String> O(List<aps> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            return arrayList;
        }
        for (aps aps : list) {
            arrayList.add(aps.v);
        }
        return arrayList;
    }

    private static List<String> P(List<ars> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            return arrayList;
        }
        for (ars ars : list) {
            arrayList.add(g.s(com.tencent.mm.pluginsdk.a.II(ars.v).getBytes()));
        }
        return arrayList;
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }
}
