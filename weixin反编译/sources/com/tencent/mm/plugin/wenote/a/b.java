package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.f.a.lj;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<lj> {
    public b() {
        this.xmG = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        lj ljVar = (lj) bVar;
        if (ljVar.fDA.fCQ) {
            g.pWK.h(14789, Integer.valueOf(3));
        } else {
            g.pWK.h(14789, Integer.valueOf(2));
        }
        x.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        d jVar = new j();
        com.tencent.mm.plugin.wenote.model.c.bWA().tWL = jVar;
        vp vpVar = new vp();
        vpVar.scene = ljVar.fDA.scene;
        jVar.a(ljVar.fDA.fDB, Long.valueOf(ljVar.fDA.frh), ljVar.fDA.fCQ, ljVar.fDA.context, 0, 0, vpVar);
        return false;
    }
}
