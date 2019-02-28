package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class m implements v {
    public final void nO(String str) {
        final r nv = o.Ub().nv(str);
        if (nv != null) {
            o.Ub();
            final String nx = s.nx(str);
            aqp aqp = nv.hXF;
            VideoTransPara Nb = d.Na().Nb();
            if (aqp != null) {
                x.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", Integer.valueOf(aqp.wEb), str, nx);
                if (aqp.wEb > 1) {
                    t.nC(str);
                    return;
                }
            }
            boolean a = l.a(nx, Nb, aqp, new d() {
                public final boolean aZH() {
                    x.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", nx);
                    nv.hmZ = s.nz(nx);
                    nv.fEo = 32;
                    o.Ub().b(nv);
                    return true;
                }
            });
            if (aqp != null) {
                x.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", str, Boolean.valueOf(a));
                aqp.wEe = !a;
                nv.hXF = aqp;
                nv.fEo = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                o.Ub().b(nv);
            }
            if (a) {
                if (aqp != null) {
                    aqp.wEb++;
                    nv.hXF = aqp;
                }
                nv.fEo = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                o.Ub().b(nv);
                c.sX(nv.hXw);
                if (l.b(nx, Nb, aqp, new d() {
                    public final boolean aZH() {
                        c.sY(nv.hXw);
                        x.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", nx);
                        nv.hmZ = s.nz(nx);
                        nv.fEo = 32;
                        o.Ub().b(nv);
                        return true;
                    }
                }) < 0) {
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                    g.pWK.a(440, 45, 1, false);
                    t.nC(str);
                } else if (aqp != null) {
                    aqp.wEe = true;
                    nv.hXF = aqp;
                    nv.fEo = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                    o.Ub().b(nv);
                }
            }
        }
    }
}
