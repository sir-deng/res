package com.tencent.tinker.c.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.a.a.i;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private i<Integer> ApA;
    private i<r> ApB;
    private i<n> ApC;
    private i<p> ApD;
    private i<f> ApE;
    private i<u> ApF;
    private i<c> ApG;
    private i<b> ApH;
    private i<e> ApI;
    private i<g> ApJ;
    private i<h> ApK;
    private i<com.tencent.tinker.a.a.a> ApL;
    private i<k> ApM;
    private i<d> ApN;
    private final com.tencent.tinker.a.a.i Apv;
    private final com.tencent.tinker.a.a.i Apw;
    private final com.tencent.tinker.c.a.b.a Apx;
    private final com.tencent.tinker.c.a.c.c Apy;
    private i<s> Apz;

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new com.tencent.tinker.a.a.i(inputStream), new com.tencent.tinker.c.a.b.a(inputStream2));
    }

    private a(com.tencent.tinker.a.a.i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.Apv = iVar;
        this.Apx = aVar;
        this.Apw = new com.tencent.tinker.a.a.i(aVar.Aqw);
        this.Apy = new com.tencent.tinker.c.a.c.c();
    }

    public final void b(OutputStream outputStream) {
        int i = 0;
        byte[] of = this.Apv.of(false);
        if (of == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.Apx == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (com.tencent.tinker.a.a.b.c.m(of, this.Apx.AqP) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(of), Arrays.toString(this.Apx.AqP)}));
            }
            t tVar = this.Apw.Aof;
            tVar.AoA.dzH = 0;
            tVar.AoA.size = 1;
            tVar.AoH.size = 1;
            tVar.AoB.dzH = this.Apx.Aqy;
            tVar.AoC.dzH = this.Apx.Aqz;
            tVar.AoI.dzH = this.Apx.AqF;
            tVar.AoD.dzH = this.Apx.AqA;
            tVar.AoE.dzH = this.Apx.AqB;
            tVar.AoF.dzH = this.Apx.AqC;
            tVar.AoG.dzH = this.Apx.AqD;
            tVar.AoH.dzH = this.Apx.AqE;
            tVar.AoN.dzH = this.Apx.AqK;
            tVar.AoP.dzH = this.Apx.AqM;
            tVar.AoK.dzH = this.Apx.AqH;
            tVar.AoJ.dzH = this.Apx.AqG;
            tVar.AoR.dzH = this.Apx.AqO;
            tVar.AoQ.dzH = this.Apx.AqN;
            tVar.AoO.dzH = this.Apx.AqL;
            tVar.AoM.dzH = this.Apx.AqJ;
            tVar.AoL.dzH = this.Apx.AqI;
            tVar.fileSize = this.Apx.Aqw;
            Arrays.sort(tVar.AoS);
            tVar.cHH();
            this.Apz = new com.tencent.tinker.c.a.a.a.n(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApA = new o(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApB = new l(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApC = new j(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApD = new com.tencent.tinker.c.a.a.a.k(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApE = new com.tencent.tinker.c.a.a.a.f(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApF = new com.tencent.tinker.c.a.a.a.p(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApG = new com.tencent.tinker.c.a.a.a.b(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApH = new com.tencent.tinker.c.a.a.a.c(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApI = new com.tencent.tinker.c.a.a.a.e(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApJ = new com.tencent.tinker.c.a.a.a.g(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApK = new com.tencent.tinker.c.a.a.a.h(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApL = new com.tencent.tinker.c.a.a.a.a(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApM = new m(this.Apx, this.Apv, this.Apw, this.Apy);
            this.ApN = new com.tencent.tinker.c.a.a.a.d(this.Apx, this.Apv, this.Apw, this.Apy);
            this.Apz.execute();
            this.ApA.execute();
            this.ApF.execute();
            this.ApB.execute();
            this.ApC.execute();
            this.ApD.execute();
            this.ApL.execute();
            this.ApH.execute();
            this.ApG.execute();
            this.ApN.execute();
            this.ApK.execute();
            this.ApJ.execute();
            this.ApI.execute();
            this.ApM.execute();
            this.ApE.execute();
            com.tencent.tinker.a.a.i.e Iv = this.Apw.Iv(tVar.AoA.dzH);
            Iv.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            Iv.writeInt(tVar.hZs);
            Iv.write(tVar.Aoo);
            Iv.writeInt(tVar.fileSize);
            Iv.writeInt(MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            Iv.writeInt(305419896);
            Iv.writeInt(tVar.AoT);
            Iv.writeInt(tVar.AoU);
            Iv.writeInt(tVar.AoH.dzH);
            Iv.writeInt(tVar.AoB.size);
            Iv.writeInt(tVar.AoB.exists() ? tVar.AoB.dzH : 0);
            Iv.writeInt(tVar.AoC.size);
            Iv.writeInt(tVar.AoC.exists() ? tVar.AoC.dzH : 0);
            Iv.writeInt(tVar.AoD.size);
            Iv.writeInt(tVar.AoD.exists() ? tVar.AoD.dzH : 0);
            Iv.writeInt(tVar.AoE.size);
            Iv.writeInt(tVar.AoE.exists() ? tVar.AoE.dzH : 0);
            Iv.writeInt(tVar.AoF.size);
            Iv.writeInt(tVar.AoF.exists() ? tVar.AoF.dzH : 0);
            Iv.writeInt(tVar.AoG.size);
            if (tVar.AoG.exists()) {
                i = tVar.AoG.dzH;
            }
            Iv.writeInt(i);
            Iv.writeInt(tVar.AoV);
            Iv.writeInt(tVar.AoW);
            tVar.b(this.Apw.Iv(tVar.AoH.dzH));
            this.Apw.cHi();
            outputStream.write(this.Apw.aif.array());
            outputStream.flush();
        }
    }
}
