package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.q.b;

public final class o extends n {

    private static class a extends i {
        final com.tencent.mm.protocal.q.a vob = new com.tencent.mm.protocal.q.a();
        final b voc = new b();

        protected final d Hu() {
            return this.vob;
        }

        public final int getType() {
            return 722;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
        }

        public final e Hv() {
            return this.voc;
        }

        public final int Ke() {
            return 1;
        }
    }

    public static void arC() {
        g.Dp().gRu.a(new o(), 0);
    }

    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
    }

    protected final ns i(q qVar) {
        return ((a) qVar).voc.vIt;
    }

    public final int getType() {
        return 722;
    }

    protected final q cai() {
        q aVar = new a();
        com.tencent.mm.protocal.q.a aVar2 = aVar.vob;
        aVar2.eE(0);
        aVar2.vIq.wij.wih.wdt.addAll(this.vnX);
        return aVar;
    }
}
