package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.f.a.py;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;

public final class a implements b {
    public c qXn = new c<py>() {
        {
            this.xmG = py.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            py pyVar = (py) bVar;
            if (pyVar instanceof py) {
                if (pyVar.fIw.fql == 1) {
                    x.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", pyVar.fIw.fIx.nMq);
                    e eVar = new e(pyVar.fIw.fIx);
                    eVar.qWU = 1;
                    eVar.hMN = pyVar.fIw.fIx.nMq;
                    if (pyVar.fIw.fIx.kzz == 6) {
                        ae.bwa().a(pyVar.fIw.fIx, 5, eVar, an.xHz);
                    } else {
                        ae.bwa().a(pyVar.fIw.fIx, 1, eVar, an.xHz);
                    }
                } else if (pyVar.fIw.fql == 3) {
                    String r = am.r(ae.getAccSnsPath(), pyVar.fIw.mediaId);
                    String Ki = i.Ki(pyVar.fIw.mediaId);
                    pyVar.fIw.path = r + Ki;
                }
            }
            return false;
        }
    };

    public a() {
        com.tencent.mm.sdk.b.a.xmy.b(this.qXn);
        ae.bwa().a((b) this);
    }

    public final void Ky(String str) {
        x.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", str);
        com.tencent.mm.sdk.b.b pyVar = new py();
        pyVar.fIw.fql = 2;
        pyVar.fIw.mediaId = str;
        String r = am.r(ae.getAccSnsPath(), str);
        pyVar.fIw.path = r + i.Ki(str);
        com.tencent.mm.sdk.b.a.xmy.m(pyVar);
    }

    public final void aE(String str, boolean z) {
    }

    public final void buX() {
    }

    public final void aF(String str, boolean z) {
    }
}
