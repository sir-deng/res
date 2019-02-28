package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private int itU;
    public byte[] lEK;
    private int lEV;

    public p(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private p(int i, byte[] bArr, byte b) {
        this.lEK = null;
        a aVar = new a();
        aVar.hnT = new afb();
        aVar.hnU = new afc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.hnS = 720;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.lEV = i;
        this.lEK = bArr;
        this.itU = 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        afc afc = (afc) ((b) qVar).hnR.hnY;
        if (afc.vOw != null) {
            this.lEK = n.a(afc.vOw);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 720;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        afb afb = (afb) this.gLB.hnQ.hnY;
        afb.wrt = this.lEV;
        if (this.lEK != null) {
            afb.vOw = n.N(this.lEK);
        } else {
            afb.vOw = new bes();
        }
        afb.sfa = this.itU;
        x.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", afb.vOw == null ? "Buf is NULL" : afb.vOw.toString());
        return a(eVar, this.gLB, this);
    }

    public final afc aCE() {
        return this.gLB == null ? null : (afc) this.gLB.hnR.hnY;
    }

    public static f a(afc afc) {
        x.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (afc == null) {
            return null;
        }
        f fVar = new f();
        if (!(afc == null || afc.wrN == null)) {
            fVar.lDm = afc.wrN.size();
            List arrayList = new ArrayList();
            Iterator it = afc.wrN.iterator();
            while (it.hasNext()) {
                sx sxVar = (sx) it.next();
                if (sxVar.vPI != null) {
                    arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(sxVar));
                }
            }
            fVar.lDn = arrayList;
        }
        return fVar;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 100;
    }
}
