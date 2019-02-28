package com.tencent.mm.modelsimple;

import com.tencent.mm.a.o;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.btt;
import com.tencent.mm.protocal.c.btu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class al extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    public long hpJ;

    public al(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public al(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public al(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        this.hpJ = 0;
        a aVar = new a();
        aVar.hnT = new btt();
        aVar.hnU = new btu();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.hnS = 384;
        aVar.hnV = au.CTRL_BYTE;
        aVar.hnW = 1000000182;
        this.gLB = aVar.Kf();
        btt btt = (btt) this.gLB.hnQ.hnY;
        btt.vKI = i;
        btt.wTb = i2;
        btt.xbu = bi.Wi(str);
        btt.vTs = bi.Wh(str);
        btt.wwh = new bet().Vf(str2);
        btt.xbv = new bet().Vf(str3);
        btt.vTw = new bet().Vf(str4);
        if (i == 5 || i == 2) {
            byte[] c;
            this.hpJ = new o(q.FX()).longValue();
            if (z) {
                c = g.Do().Cx().c(this.hpJ, str3);
            } else {
                c = g.Do().Cx().a(this.hpJ, bi.Wi(str), z2);
            }
            btt.vRI = new bes().bl(c);
        }
        btt.vTx = new bes().bl(bi.Wj(bi.oM((String) g.Dq().Db().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(btt.vKI);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(btt.vRI == null ? -1 : btt.vRI.wRk);
        objArr[4] = btt.vRI == null ? "null" : bi.Wz(bi.bx(btt.vRI.wRm.oz));
        x.i(str5, str6, objArr);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 384;
    }

    public final String Oc() {
        try {
            return ((btu) this.gLB.hnR.hnY).wgO;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        btt btt = (btt) this.gLB.hnQ.hnY;
        btu btu = (btu) this.gLB.hnR.hnY;
        if (btu.vPT != null && btu.vPT.wRk > 0) {
            boolean a = g.Do().Cx().a(this.hpJ, n.a(btu.vPT));
            x.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", Boolean.valueOf(a), Integer.valueOf(btu.vPT.wRk));
        }
        if (i2 == 0 && i3 == 0) {
            g.Dq().Db().set(77830, btu.wgO);
            g.Dq().Db().set(32, btt.xbu);
            g.Dq().Db().set(33, btt.vTs);
            g.Dq().Db().set(46, bi.bA(n.a(btu.vPZ)));
            String bA = bi.bA(n.a(btt.vTx));
            g.Dq().Db().set(47, bA);
            g.Dq().gRO.set(18, bA);
            g.Dq().Db().set(-1535680990, btu.vPY);
            int i4 = btu.vPZ == null ? 0 : btu.vPZ.wRk;
            int length = btu.vPY == null ? 0 : btu.vPY.length();
            int length2 = btu.wgO == null ? 0 : btu.wgO.length();
            x.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", Integer.valueOf(i4), Integer.valueOf(length), Integer.valueOf(length2));
        } else if (i2 == 4) {
            g.Dq().Db().set(32, "");
            g.Dq().Db().set(33, "");
        }
        this.gLE.a(i2, i3, str, this);
    }
}
