package com.tencent.mm.plugin.sns.model;

import android.util.Base64;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.bkl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l extends k implements com.tencent.mm.network.k {
    public static List<Long> qZM = Collections.synchronizedList(new LinkedList());
    private b gLB;
    public e gLE;
    private String hVj;
    private long qWM;

    public static boolean ew(long j) {
        if (qZM.contains(Long.valueOf(j))) {
            return false;
        }
        qZM.add(Long.valueOf(j));
        return true;
    }

    private static boolean ex(long j) {
        qZM.remove(Long.valueOf(j));
        return true;
    }

    public l(long j, int i, String str) {
        boolean z;
        bes bes = null;
        this.qWM = j;
        a aVar = new a();
        aVar.hnT = new bkk();
        aVar.hnU = new bkl();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        this.hVj = stringBuilder.append(g.Dq().cachePath).append("ad_detail_session").toString();
        byte[] d = FileOp.d(this.hVj, 0, -1);
        this.gLB = aVar.Kf();
        ((bkk) this.gLB.hnQ.hnY).vWS = j;
        ((bkk) this.gLB.hnQ.hnY).wUf = n.N(d);
        ((bkk) this.gLB.hnQ.hnY).sfa = i;
        if (str != null && str.length() > 0) {
            bkk bkk = (bkk) this.gLB.hnQ.hnY;
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                if (decode != null) {
                    bes = new bes();
                    bes.bl(decode);
                }
            }
            bkk.wUg = bes;
        }
        String str2 = "MicroMsg.NetSceneSnsAdObjectDetial";
        StringBuilder append = new StringBuilder("req snsId ").append(j).append(" ").append(i.er(j)).append(" scene ").append(i).append(" buf is null? ");
        if (d == null) {
            z = true;
        } else {
            z = false;
        }
        x.d(str2, append.append(z).toString());
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", Long.valueOf(j), Integer.valueOf(i), str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 683;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        byte[] a;
        Object obj = 1;
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 4 && i3 == 1) {
                a = n.a(((bkl) this.gLB.hnR.hnY).wUf);
                if (a != null) {
                    FileOp.deleteFile(this.hVj);
                    FileOp.b(this.hVj, a, a.length);
                }
                obj = null;
            } else {
                obj = null;
            }
        }
        if (obj == null) {
            this.gLE.a(i2, i3, str, this);
            ex(this.qWM);
            return;
        }
        a = n.a(((bkl) this.gLB.hnR.hnY).wUf);
        FileOp.deleteFile(this.hVj);
        FileOp.b(this.hVj, a, a.length);
        bkj bkj = ((bkl) this.gLB.hnR.hnY).wUh;
        bes bes = ((bkl) this.gLB.hnR.hnY).wUi;
        if (bkj != null) {
            x.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + n.b(bkj.wUd.wUN));
            x.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + bkj.wUe);
        }
        if (bkj == null || bkj.wUd == null || bkj.wUd.wGC <= 0) {
            if (!(bkj == null || bkj.wUd == null)) {
                x.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + bkj.wUd.wUU.size() + " like: " + bkj.wUd.wUR.size());
            }
            a.a(bkj, bes);
            this.gLE.a(i2, i3, str, this);
            ex(this.qWM);
            return;
        }
        x.i("MicroMsg.NetSceneSnsAdObjectDetial", bkj.wUd.vWS + " will remove by get detail ");
        ex(this.qWM);
        ae.bwi().delete(bkj.wUd.vWS);
        ae.bwk().eN(bkj.wUd.vWS);
        this.gLE.a(i2, i3, str, this);
    }
}
