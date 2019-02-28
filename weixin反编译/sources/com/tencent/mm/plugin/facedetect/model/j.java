package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.f.a.hl;
import com.tencent.mm.f.a.hl.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<hl> {
    public j() {
        this.xmG = hl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        hl hlVar = (hl) bVar;
        if (hlVar == null) {
            x.e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            return false;
        }
        f fVar = f.mlS;
        boolean aHj = f.aHj();
        f fVar2 = f.mlS;
        boolean aHk = f.aHk();
        if (!aHj) {
            hlVar.fyD.fyF = 10001;
            hlVar.fyD.fyG = "No front camera";
        } else if (aHk) {
            hlVar.fyD.fyG = "ok";
        } else {
            hlVar.fyD.fyF = 10002;
            hlVar.fyD.fyG = "No necessary model found";
        }
        a aVar = hlVar.fyD;
        f fVar3 = f.mlS;
        aVar.fyH = f.aHn();
        aVar = hlVar.fyD;
        if (aHj && aHk) {
            z = true;
        }
        aVar.fyE = z;
        return true;
    }
}
