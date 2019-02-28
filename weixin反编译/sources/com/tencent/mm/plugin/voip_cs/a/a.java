package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.mm.f.a.sp;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.bvh;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.IOException;

public final class a extends c<sp> {
    public a() {
        this.xmG = sp.class.getName().hashCode();
    }

    private static boolean a(sp spVar) {
        if ((spVar instanceof sp) && as.Hp()) {
            d bJD = b.bJD();
            Object obj = spVar.fLe.fLf;
            if (!(obj == null || obj.length == 0)) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                bvh bvh = new bvh();
                try {
                    bvh.aH(obj2);
                    x.i("MicroMsg.voipcs.VoipCSService", "notify status = " + bvh.xdb + ",notifySeq = " + bJD.sCU);
                    bvo bvo = new bvo();
                    bvo.xcP = bvh.xcP;
                    bvo.wim = bvh.wim;
                    bvo.xcZ = bvh.xcZ;
                    bvo.xdb = bvh.xdb;
                    bvo.xdc = bvh.xdc;
                    bvo.xdd = bvh.xdd;
                    bvo.xda = bvh.xda;
                    bJD.a(bvo);
                } catch (IOException e) {
                    x.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", e);
                }
            }
        }
        return false;
    }
}
