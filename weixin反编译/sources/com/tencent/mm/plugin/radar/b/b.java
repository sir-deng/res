package com.tencent.mm.plugin.radar.b;

import b.i;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private static final String TAG = TAG;
    public static final a pCf = new a();
    private final float fAo;
    private final float fBX;
    private final int fBY;
    private final int fBZ;
    private final String fCa;
    private final String fCb;
    final int fvo;
    com.tencent.mm.ad.b gLB;
    private e gLE;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public /* synthetic */ b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
    }

    public b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        b.c.b.e.i(str, "macAddr");
        b.c.b.e.i(str2, "cellId");
        this.fvo = i;
        this.fAo = f;
        this.fBX = f2;
        this.fBY = i2;
        this.fBZ = i3;
        this.fCa = str;
        this.fCb = str2;
        if (this.fvo == 0) {
            x.e(TAG, "opcode is wrong!");
        }
    }

    public final int blX() {
        com.tencent.mm.ad.b bVar = this.gLB;
        bbt bbt = (bbt) (bVar != null ? bVar.Kd() : null);
        return bbt != null ? bbt.lfj : 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d(TAG, "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.fvo == 1 && i2 == 0) {
            ArrayList arrayList = new ArrayList();
            com.tencent.mm.ad.b bVar = this.gLB;
            com.tencent.mm.bp.a Kd = bVar != null ? bVar.Kd() : null;
            if (!(Kd instanceof bbt)) {
                Kd = null;
            }
            bbt bbt = (bbt) Kd;
            if (bbt != null) {
                LinkedList<Object> linkedList = bbt.vNu;
                if (linkedList != null) {
                    for (Object obj : linkedList) {
                        h hVar = new h();
                        g gVar = g.pFl;
                        b.c.b.e.h(obj, "member");
                        hVar.setUsername(g.b(obj));
                        hVar.jo(obj.whs);
                        hVar.bC(true);
                        arrayList.add(hVar);
                    }
                }
            }
            n.JW().H(arrayList);
        }
        e eVar = this.gLE;
        if (eVar != null) {
            eVar.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        b.c.b.e.i(eVar, "dispatcher");
        b.c.b.e.i(eVar2, "callback");
        this.gLE = eVar2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.a(new bbs());
        aVar.b(new bbt());
        aVar.jr("/cgi-bin/micromsg-bin/mmradarsearch");
        aVar.hk(com.tencent.mm.plugin.appbrand.jsapi.x.CTRL_INDEX);
        aVar.hl(c.CTRL_INDEX);
        aVar.hm(1000000209);
        this.gLB = aVar.Kf();
        com.tencent.mm.ad.b bVar = this.gLB;
        if (bVar == null) {
            b.c.b.e.cKr();
        }
        com.tencent.mm.bp.a Kc = bVar.Kc();
        if (Kc == null) {
            throw new i("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
        }
        bbs bbs = (bbs) Kc;
        bbs.vKI = this.fvo;
        bbs.wjx = this.fCb;
        bbs.wjy = this.fBZ;
        bbs.vXy = this.fAo;
        bbs.vXx = this.fBX;
        bbs.wjw = this.fCa;
        bbs.wjv = this.fBY;
        return a(eVar, this.gLB, this);
    }
}
