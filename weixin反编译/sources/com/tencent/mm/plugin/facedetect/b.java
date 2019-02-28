package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import java.io.File;

public final class b implements a<Void, Void> {
    private static j mks = new j();
    private static n mkt = new n();
    private static i mku = new i();
    private static l mkv = new l();
    private com.tencent.mm.vending.g.b iiC = null;

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.TaskInitFace", "hy: TaskInitFace init");
        this.iiC = g.cAI();
        safeAddListener(mks);
        safeAddListener(mkt);
        safeAddListener(mku);
        e.post(new Runnable() {
            public final void run() {
                String aHx = o.aHx();
                String aHy = o.aHy();
                x.i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b", aHx, Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.e.a.bO(aHx)), aHy, Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.e.a.bO(aHy)));
                if (!com.tencent.mm.pluginsdk.i.a.e.a.bO(aHx)) {
                    x.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
                    o.m(ad.getContext(), "face_detect" + File.separator + "ufdmtcc.bin", aHx);
                }
                if (!r3) {
                    x.i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
                    o.m(ad.getContext(), "face_detect" + File.separator + "ufat.bin", aHy);
                }
            }
        }, "FaceDetectCopyModelFile");
        return null;
    }

    private static void safeAddListener(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.xmy.d(cVar)) {
            x.w("MicroMsg.TaskInitFace", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.xmy.b(cVar);
        }
    }
}
