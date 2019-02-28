package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.c.c;
import com.tencent.mm.pluginsdk.i.a.c.e;
import com.tencent.mm.pluginsdk.i.a.d.j;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class d extends a<c> {
    public d(c cVar) {
        super(cVar);
    }

    public final String aam() {
        return "CheckResUpdate";
    }

    public final boolean bE(long j) {
        if (((c) aat()).fileSize <= 0 || ((c) aat()).fileSize == com.tencent.mm.pluginsdk.i.a.e.a.GW(getFilePath()) + j) {
            return super.bE(j);
        }
        return false;
    }

    public final boolean aas() {
        if (super.aas()) {
            j.o(((c) aat()).vmS, 12);
            return true;
        }
        j.o(((c) aat()).vmS, 27);
        return false;
    }

    protected final l a(j jVar) {
        c cVar = (c) aat();
        String Sw = i.Sw(cVar.vmK);
        String str = cVar.frM;
        if (cVar.ttd && bi.oM(g.bV(i.Sw(cVar.vmK))).equals(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            return new l(cVar, com.tencent.mm.pluginsdk.i.a.e.a.GW(Sw));
        } else if (!bi.by(((c) aat()).vns) && com.tencent.mm.pluginsdk.i.a.e.a.u(i.Sw(((c) aat()).vmK), ((c) aat()).vns) && bi.oM(g.bV(i.Sw(((c) aat()).vmK))).equals(((c) aat()).frM)) {
            return new l((k) aat(), com.tencent.mm.pluginsdk.i.a.e.a.GW(i.Sw(((c) aat()).vmK)));
        } else {
            l a = super.a(jVar);
            x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + a, cVar.vmK);
            if (a == null) {
                return new l("CheckResUpdate", bZW(), getURL(), getFilePath(), 0, "", new e());
            }
            if (a.status == 2) {
                if (bi.oN(((c) aat()).frM) || !((c) aat()).frM.equals(g.bV(getFilePath()))) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", cVar.vmK);
                    return new l("CheckResUpdate", bZW(), getURL(), getFilePath(), a.fNf, a.aBD, new c());
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", cVar.vmK);
            }
            return a;
        }
    }
}
