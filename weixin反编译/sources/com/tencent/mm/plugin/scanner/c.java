package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.io.File;
import java.util.HashMap;

public final class c implements ap {
    private static HashMap<Integer, d> gyG;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> kNl = new HashMap();
    public String gRT;
    private a kNn;
    public b pYc = new b();
    private j pYd = new j();
    private n pYe = new n();
    private m pYf = new m();
    private com.tencent.mm.plugin.scanner.history.a.b pYg;
    private com.tencent.mm.plugin.scanner.a.b pYh = new com.tencent.mm.plugin.scanner.a.b();

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.scanner.history.a.b.gLy;
            }
        });
    }

    public static c bpi() {
        as.Hg();
        c cVar = (c) bq.ib("plugin.scanner");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        as.Hg().a("plugin.scanner", cVar2);
        return cVar2;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.pYd);
        com.tencent.mm.sdk.b.a.xmy.c(this.pYe.pZh);
        com.tencent.mm.sdk.b.a.xmy.c(this.pYe.pZi);
        com.tencent.mm.sdk.b.a.xmy.c(this.pYf);
        com.tencent.mm.plugin.scanner.a.b bVar = this.pYh;
        com.tencent.mm.sdk.b.a.xmy.c(bVar.pYE);
        com.tencent.mm.sdk.b.a.xmy.c(bVar.pYF);
        bVar.bpk();
        b bVar2 = this.pYc;
        bVar2.hEv.clear();
        bVar2.pAD.clear();
        bVar2.pAE.clear();
        if (this.kNn != null) {
            this.kNn.iY(hashCode());
            this.kNn = null;
        }
        this.gRT = "";
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        this.kNn = g.a(hashCode(), stringBuilder.append(com.tencent.mm.y.c.FI()).append("CommonOneMicroMsg.db").toString(), kNl, false);
        com.tencent.mm.plugin.scanner.a.b bVar = this.pYh;
        com.tencent.mm.sdk.b.a.xmy.b(bVar.pYE);
        com.tencent.mm.sdk.b.a.xmy.b(bVar.pYF);
        com.tencent.mm.sdk.b.a.xmy.b(this.pYd);
        com.tencent.mm.sdk.b.a.xmy.b(this.pYe.pZh);
        com.tencent.mm.sdk.b.a.xmy.b(this.pYe.pZi);
        com.tencent.mm.sdk.b.a.xmy.a(this.pYf);
        as.Dt().F(new Runnable() {
            public final void run() {
                if (!as.Hp()) {
                    return;
                }
                if (bi.oN(c.this.gRT)) {
                    x.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                } else {
                    bi.g(c.this.gRT + "image/scan/img", "scanbook", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void bt(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onSdcardMount ");
        as.Hm();
        x.d("MicroMsg.scanner.SubCoreScanner", stringBuilder.append(com.tencent.mm.y.c.FJ()).toString());
        c bpi = bpi();
        as.Hm();
        String FJ = com.tencent.mm.y.c.FJ();
        x.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : " + FJ);
        bpi.gRT = FJ;
        File file = new File(FJ);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(FJ + "image/scan/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(FJ + "image/scan/music");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String FJ() {
        return bpi().gRT;
    }

    public final String dZ(String str, String str2) {
        if (!as.Hp() || bi.oN(str)) {
            return "";
        }
        return String.format("%s/scanbook%s_%s", new Object[]{this.gRT + "image/scan/img", str2, com.tencent.mm.a.g.s(str.getBytes())});
    }

    public static com.tencent.mm.plugin.scanner.history.a.b bpj() {
        com.tencent.mm.kernel.g.Do().CA();
        if (bpi().pYg == null) {
            c bpi = bpi();
            as.Hm();
            bpi.pYg = new com.tencent.mm.plugin.scanner.history.a.b(com.tencent.mm.y.c.Fc());
        }
        return bpi().pYg;
    }
}
