package com.tencent.mm.pluginsdk.a;

import android.os.Bundle;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;

public final class a {
    public static com.tencent.mm.modelsimple.v.a a(v vVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        return a(vVar, bundle);
    }

    private static com.tencent.mm.modelsimple.v.a a(v vVar, Bundle bundle) {
        if (vVar == null) {
            return null;
        }
        if (((e) vVar.hoZ.Hv()).vHL.wZl == null) {
            return null;
        }
        bjx bjx = ((e) vVar.hoZ.Hv()).vHL.wZl.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            com.tencent.mm.modelsimple.v.a aVar = new com.tencent.mm.modelsimple.v.a();
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 19) {
                    aVar.fsK = bnq.wXD;
                } else if (bnq.pWg == 20) {
                    aVar.hPv = bnq.wXD;
                } else if (bnq.pWg == 21) {
                    aVar.fzT = bnq.wXD;
                }
            }
            aVar.hPw = bundle;
            aVar.type = 0;
            if (!bi.oN(aVar.fsK)) {
                aVar.username = ((d) vVar.hoZ.Kh()).vHI.wEj.kyG;
                return aVar;
            }
        }
        return null;
    }
}
