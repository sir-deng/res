package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

public final class ab extends k implements com.tencent.mm.network.k {
    public int errCode;
    public int errType;
    public long frh = -1;
    public com.tencent.mm.ad.b gLB;
    private e gLE;
    private final long hPR = 60000;
    private Runnable hPS;

    public static final class a {
        public String desc = "";
        public String hPT = "";
        public String hcs = "";
        public int type = 5;
    }

    public static final class b {
        public String desc;
        public LinkedList<a> hPU;
        public String title;

        public static LinkedList<a> f(Map<String, String> map, String str) {
            LinkedList<a> linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 1000) {
                    return linkedList;
                }
                String str2 = str + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                try {
                    i = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                    a aVar = new a();
                    if (i != 5) {
                        return linkedList;
                    }
                    aVar.hcs = bi.oM((String) map.get(str2 + ".iconurl"));
                    aVar.desc = bi.oM((String) map.get(str2 + ".desc"));
                    aVar.hPT = bi.oM((String) map.get(str2 + ".link"));
                    if (bi.oN(aVar.hcs) && bi.oN(aVar.desc) && bi.oN(aVar.hPT)) {
                        return linkedList;
                    }
                    linkedList.add(aVar);
                    i = i2 + 1;
                } catch (Exception e) {
                    x.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                    return linkedList;
                }
            }
        }
    }

    public ab(float f, float f2, long j) {
        ayn ayn = new ayn();
        ayn.vXx = f;
        ayn.vXy = f2;
        ayn.wjy = 1;
        ayn.wjv = 0;
        a(ayn, 1, -10000.0f, -10000.0f);
        this.frh = j;
    }

    public ab(bff bff) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = bff;
        aVar.hnU = new bfg();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.hnS = 424;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public ab(ayn ayn, float f, float f2) {
        a(ayn, 0, f, f2);
    }

    private void a(ayn ayn, int i, float f, float f2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bff();
        aVar.hnU = new bfg();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.hnS = 424;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bff bff = (bff) this.gLB.hnQ.hnY;
        bff.wRw = ayn;
        bff.sfa = i;
        bff.wRx = f;
        bff.wRy = f2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        if (((bff) ((com.tencent.mm.ad.b) qVar).hnQ.hnY).wRw != null) {
            return b.hoz;
        }
        x.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
        return b.hoA;
    }

    public final bfg Su() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (bfg) this.gLB.hnR.hnY;
    }

    protected final int Bo() {
        return 10;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        x.d("MicroMsg.NetSceneScanStreetView", "xml is %s", Su().vUQ);
        if (this.hPS != null) {
            this.hPS.run();
        }
    }

    public final int getType() {
        return 424;
    }

    public static String mC(String str) {
        Map y = bj.y(str, "streetview");
        if (y == null) {
            return null;
        }
        return (String) y.get(".streetview.link");
    }
}
