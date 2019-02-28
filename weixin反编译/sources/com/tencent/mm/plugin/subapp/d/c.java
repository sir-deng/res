package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.f.a.fk;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import org.xwalk.core.Log;

public final class c extends com.tencent.mm.sdk.b.c<fk> {
    public c() {
        this.xmG = fk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fk fkVar = (fk) bVar;
        if (fkVar == null) {
            return false;
        }
        if (bi.oN(fkVar.fvw.fileName)) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo fileName is null");
            return false;
        }
        p oj = m.UK().oj(fkVar.fvw.fileName);
        if (oj == null) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo voiceInfo is null");
            return false;
        }
        b.b(oj.clientId, fkVar.fvw.fvx, fkVar.fvw.fvy, fkVar.fvw.fvz, fkVar.fvw.result);
        return true;
    }
}
