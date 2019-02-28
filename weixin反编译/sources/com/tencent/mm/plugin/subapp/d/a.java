package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.f.a.fj;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<fj> {
    public a() {
        this.xmG = fj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fj fjVar = (fj) bVar;
        if (fjVar == null) {
            return false;
        }
        if (bi.oN(fjVar.fvu.fileName)) {
            x.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo fileName is null");
            return false;
        }
        p oj = m.UK().oj(fjVar.fvu.fileName);
        if (oj == null) {
            x.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo voiceInfo is null");
            return false;
        }
        String str;
        int i;
        if (fjVar.fvu.fvv == 1 || fjVar.fvu.fvv == 2) {
            str = oj.clientId;
            i = fjVar.fvu.scene;
            x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
            g.pWK.h(14220, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
        } else if (fjVar.fvu.fvv == 3) {
            str = oj.clientId;
            i = fjVar.fvu.scene;
            x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextDoubleClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
            g.pWK.h(14220, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
        }
        return true;
    }
}
