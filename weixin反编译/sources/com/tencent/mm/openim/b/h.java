package com.tencent.mm.openim.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.avg;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.y.s;
import java.io.IOException;
import java.util.Iterator;

public final class h extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public h() {
        a aVar = new a();
        aVar.hnT = new avq();
        aVar.hnU = new avr();
        aVar.uri = "/cgi-bin/micromsg-bin/openimsync";
        this.gLB = aVar.Kf();
        ((avq) this.gLB.hnQ.hnY).cLs = 2097152;
        x.i("MicroMsg.NetsceneOpenIMSync", "opim sync init:%d", Integer.valueOf(hashCode()));
    }

    protected final int Bo() {
        return 20;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final boolean Kj() {
        return true;
    }

    public final int getType() {
        return 810;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Dr();
        byte[] Wj = bi.Wj(bi.oM((String) g.Dq().Db().get(8195, null)));
        bes bes = new bes();
        bes.bl(Wj);
        ((avq) this.gLB.hnQ.hnY).wKe = bes;
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()));
        if (i2 == 0 && i3 == 0) {
            avq avq = (avq) this.gLB.hnQ.hnY;
            avr avr = (avr) this.gLB.hnR.hnY;
            if (avr.wKf != null && avr.wKf.kyB.size() > 0) {
                x.i("MicroMsg.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", Integer.valueOf(avr.wKf.kyB.size()));
                Iterator it = avr.wKf.kyB.iterator();
                while (it.hasNext()) {
                    ot otVar = (ot) it.next();
                    if (otVar.wet == 400) {
                        avg avg = new avg();
                        try {
                            avg.aH(otVar.weu.wRm.oz);
                            x.i("MicroMsg.NetsceneOpenIMSync", "processModContact %s", avg.idC);
                            ag a = i.a(avg);
                            x.i("MicroMsg.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", a.field_username, a.field_nickname, a.field_conRemark, Integer.valueOf(a.getSource()), Integer.valueOf(a.fXa), a.field_openImAppid, a.fXE, Integer.valueOf(a.fXD), Integer.valueOf(a.field_type), a.field_descWordingId);
                            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().R(a);
                            if (a.AS()) {
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XK(a.field_username);
                            }
                            ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).aA(avg.kPE, avg.wKa);
                            i.b(avg);
                            g.Dr();
                            bf FF = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fg().FF(a.field_username);
                            if (!(FF == null || bi.oN(FF.field_encryptUsername))) {
                                ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).az(a.field_username, FF.field_conRemark);
                                g.Dr();
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fg().FG(a.field_username);
                                a.da(FF.field_conRemark);
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().R(a);
                            }
                        } catch (IOException e) {
                            x.e("MicroMsg.NetsceneOpenIMSync", "processModContact error:%s", e);
                        }
                    } else if (otVar.wet == com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX) {
                        qp qpVar = new qp();
                        try {
                            qpVar.aH(otVar.weu.wRm.oz);
                            x.i("MicroMsg.NetsceneOpenIMSync", "processDelContact user:%s", qpVar.idC);
                            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XE(qpVar.idC);
                            s.gK(qpVar.idC);
                        } catch (IOException e2) {
                            x.e("MicroMsg.NetsceneOpenIMSync", "processDelContact error:%s", e2);
                        }
                    }
                }
            }
            byte[] toByteArray = avr.wKe.wRm.toByteArray();
            g.Dr();
            byte[] g = ad.g(bi.Wj(bi.oM((String) g.Dq().Db().get(8195, null))), toByteArray);
            if (g != null && g.length > 0) {
                g.Dr();
                g.Dq().Db().set(8195, bi.bA(g));
            }
            if ((avq.cLs & avr.wKg) == 0) {
                x.i("MicroMsg.NetsceneOpenIMSync", "onGYNetEnd end");
                this.gLE.a(0, 0, "", this);
                return;
            }
            a(this.hok, this.gLE);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
