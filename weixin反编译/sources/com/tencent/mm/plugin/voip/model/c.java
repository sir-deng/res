package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c extends k implements com.tencent.mm.network.k {
    private static final List<Object> hHm = new ArrayList();
    private static final Set<Long> spz = new HashSet();
    private long frh;
    private b gLB;
    private e gLE;
    private final List<au> hHn = new LinkedList();

    public c(String str, String str2, int i) {
        boolean z = true;
        x.d("MicroMsg.NetSceneSendMsg", "dktext :" + bi.chl());
        if (!bi.oN(str)) {
            au auVar = new au();
            auVar.eR(1);
            auVar.dU(str);
            auVar.aq(bb.hU(str));
            auVar.eS(1);
            auVar.setContent(str2);
            auVar.setType(i);
            as.Hm();
            this.frh = com.tencent.mm.y.c.Fh().Q(auVar);
            if (this.frh == -1) {
                z = false;
            }
            Assert.assertTrue(z);
            x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.frh);
        }
    }

    public c() {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :" + bi.chl());
        x.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    protected final int Bo() {
        return 10;
    }

    protected final int a(q qVar) {
        return this.hHn.size() > 0 ? b.hoz : b.hoA;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new bhf();
        aVar.hnU = new bhg();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.hnS = 522;
        aVar.hnV = bd.CTRL_BYTE;
        aVar.hnW = 1000000237;
        this.gLB = aVar.Kf();
        bhf bhf = (bhf) this.gLB.hnQ.hnY;
        as.Hm();
        List aZW = com.tencent.mm.y.c.Fh().aZW();
        if (aZW.size() == 0) {
            x.i("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.hHn.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aZW.size()) {
                break;
            }
            au auVar = (au) aZW.get(i2);
            if (auVar.field_isSend == 1) {
                arn arn = new arn();
                arn.vNN = new bet().Vf(auVar.field_talker);
                arn.pgR = (int) (auVar.field_createTime / 1000);
                arn.kzz = auVar.getType();
                arn.noL = auVar.field_content;
                arn.wGf = o.k(com.tencent.mm.y.q.FY(), auVar.field_createTime).hashCode();
                arn.vNR = com.tencent.mm.y.bd.HK();
                bhf.kyB.add(arn);
                bhf.kyA = bhf.kyB.size();
                this.hHn.add(auVar);
            }
            i = i2 + 1;
        }
        int a = a(eVar, this.gLB, this);
        if (a >= 0) {
            return a;
        }
        Qc();
        return a;
    }

    public final int getType() {
        return 522;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            int i4;
            List list = ((bhg) this.gLB.hnR.hnY).kyB;
            if (this.hHn.size() == list.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        x.i("MicroMsg.NetSceneSendMsg", "total " + i5 + " msgs sent successfully");
                        break;
                    }
                    aro aro = (aro) list.get(i5);
                    if (aro.vQL != 0) {
                        x.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + aro.vQL);
                        if(i5);
                        this.gLE.a(4, aro.vQL, str, this);
                        return;
                    }
                    long j = ((au) this.hHn.get(i5)).field_msgId;
                    x.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + aro.vNT + " sent successfully!");
                    as.Hm();
                    au dI = com.tencent.mm.y.c.Fh().dI(j);
                    dI.ap(aro.vNT);
                    dI.eR(2);
                    as.Hm();
                    com.tencent.mm.y.c.Fh().a(j, dI);
                    i4 = i5 + 1;
                }
            }
            i4 = a(this.hok, this.gLE);
            if (i4 == -2) {
                this.gLE.a(0, 0, str, this);
                return;
            } else if (i4 < 0) {
                this.gLE.a(3, -1, str, this);
                return;
            } else {
                return;
            }
        }
        Qc();
        this.gLE.a(i2, i3, str, this);
    }

    private void Qc() {
        for (int i = 0; i < this.hHn.size(); i++) {
            if(i);
        }
    }

    private void if(int i) {
        au auVar = (au) this.hHn.get(i);
        auVar.eR(5);
        as.Hm();
        com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
        Iterator it = hHm.iterator();
        while (it.hasNext()) {
            it.next();
            String str = auVar.field_talker;
            str = auVar.field_content;
        }
    }
}
