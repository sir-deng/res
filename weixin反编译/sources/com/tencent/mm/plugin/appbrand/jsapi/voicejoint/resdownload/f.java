package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload;

import com.tencent.mm.f.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class f extends c<bc> {
    public f() {
        this.xmG = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final bc bcVar = (bc) bVar;
        if (!(bcVar == null || bcVar.fqf.fqg != 48 || bcVar.fqf.fqh == 100 || bcVar.fqf.fqh == 101)) {
            x.i("MicroMsg.VoiceResUpdateListener", "alvinluo VoiceResUpdateListener resType: %d, subType: %d, filePath: %s, fileVersion: %d", Integer.valueOf(bcVar.fqf.fqg), Integer.valueOf(bcVar.fqf.fqh), bcVar.fqf.filePath, Integer.valueOf(bcVar.fqf.fqi));
            c.vnr.e(bcVar.fqf.fqg, bcVar.fqf.fqh, bcVar.fqf.fqi, true);
            e.post(new Runnable() {
                public final void run() {
                    d dVar = d.jzN;
                    if (d.b(bcVar)) {
                        dVar = d.jzN;
                        bc bcVar = bcVar;
                        Iterator it = dVar.jzO.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).a(bcVar);
                        }
                        return;
                    }
                    d.jzN.bM(bcVar.fqf.fqg, bcVar.fqf.fqh);
                }
            }, "VoiceResUnZip");
        }
        return false;
    }
}
