package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ads;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class c extends k implements com.tencent.mm.network.k {
    public static Vector<String> oVj = new Vector();
    public int fvo = 0;
    private final b gLB;
    private e gLE;
    public String iVa = "";
    public int nWw;
    public String oVk = "";
    public String oVl = "";
    public List<a> oVm;
    public boolean oVn;

    public static boolean ui(int i) {
        String valueOf = String.valueOf(i);
        if (oVj.contains(valueOf)) {
            return false;
        }
        oVj.add(valueOf);
        return true;
    }

    public static boolean uj(int i) {
        oVj.remove(String.valueOf(i));
        return true;
    }

    public static void clear() {
        oVj.clear();
    }

    public c(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, bes bes, String str3, int i5, boolean z) {
        this.oVk = str3;
        if (!(i == 0 || i == 1)) {
            x.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :" + i);
        }
        this.fvo = i;
        a aVar = new a();
        aVar.hnT = new ads();
        aVar.hnU = new adt();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.hnS = 603;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ads ads = (ads) this.gLB.hnQ.hnY;
        aot aot = new aot();
        aot.wjx = str2;
        aot.wjy = i4;
        aot.vXy = f2;
        aot.vXx = f;
        aot.wjw = str;
        aot.wjv = i3;
        ads.wfE = aot;
        ads.wnX = str3;
        ads.sfa = i2;
        ads.wsU = i5;
        if (bes == null) {
            ads.wsT = new bes().bl(new byte[0]);
        } else {
            ads.wsT = bes;
        }
        ads.vQC = i;
        ads.wsV = 1;
        this.oVn = z;
        x.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
        x.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", Boolean.valueOf(z), Integer.valueOf(ads.wsT.wRk));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 603;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        adt adt = (adt) ((b) qVar).hnR.hnY;
        this.iVa = adt.vWw;
        this.nWw = adt.wtd;
        x.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + adt.wta + "searchId " + this.iVa);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            x.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", Integer.valueOf(adt.vWu), Integer.valueOf(adt.wta), Integer.valueOf(adt.wsY), adt.wtc);
            this.oVl = bi.aD(adt.wtc, "");
            this.oVm = new ArrayList();
            Iterator it = adt.wtb.iterator();
            while (it.hasNext()) {
                this.oVm.add(new a(adt.vWw, (aos) it.next()));
            }
            if (adt.wta > 0) {
                aos aos = (aos) adt.wtb.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + aos.oUX);
                stringBuffer.append(" title " + aos.fpg);
                stringBuffer.append(" link " + aos.oVe);
                stringBuffer.append(" price " + aos.oUY);
                stringBuffer.append(" rate " + aos.oVd);
                stringBuffer.append(" type " + aos.kzz);
                stringBuffer.append(" desc : ");
                it = aos.oVc.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((bet) it.next()).wRo + "-");
                }
                x.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", stringBuffer.toString());
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final bes bfG() {
        bes bes = ((adt) this.gLB.hnR.hnY).wsT;
        return bes == null ? new bes().bl(new byte[0]) : bes;
    }

    public final int bfH() {
        return ((adt) this.gLB.hnR.hnY).vWu;
    }
}
