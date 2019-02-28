package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.px;
import com.tencent.mm.f.a.qg;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public class e implements ap {
    private c owA = new c<qg>() {
        {
            this.xmG = qg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qg qgVar = (qg) bVar;
            if (l.a(qgVar.fII.fIv, d.Na().Nc(), qgVar.fII.fIK, qgVar.fII.fIM)) {
                qgVar.fII.fIL.run();
                qgVar.fIJ.result = l.b(qgVar.fII.fIv, d.Na().Nc(), qgVar.fII.fIK, qgVar.fII.fIM);
            } else {
                qgVar.fIJ.result = 1;
            }
            return false;
        }
    };
    private m owy = new m();
    private c owz = new c<px>() {
        {
            this.xmG = px.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            px pxVar = (px) bVar;
            pxVar.fIu.result = d.mD(pxVar.fIt.fIv);
            return true;
        }
    };

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        a Ug = o.Ug();
        m mVar = this.owy;
        x.k("MicroMsg.VideoService", "addVideoMsgSendCallback %s", mVar);
        if (!(mVar == null || Ug.hYc == null || Ug.hYc.contains(mVar))) {
            Ug.hYc.add(mVar);
        }
        com.tencent.mm.sdk.b.a.xmy.a(this.owA);
        com.tencent.mm.sdk.b.a.xmy.b(this.owz);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        a Ug = o.Ug();
        m mVar = this.owy;
        if (!(mVar == null || Ug.hYc == null)) {
            Ug.hYc.remove(mVar);
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.owA);
        j.oAr.Ez();
        com.tencent.mm.sdk.b.a.xmy.c(this.owz);
    }
}
