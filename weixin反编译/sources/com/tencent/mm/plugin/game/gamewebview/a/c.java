package com.tencent.mm.plugin.game.gamewebview.a;

import android.content.Context;
import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.game.model.ao.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static void C(Context context, int i) {
        a g = a.g(12909, Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), null, Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(bi.getInt(null, 0)), Integer.valueOf(ap.getNetworkType(context)), null);
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.hnS = 427;
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.bp.a xgVar = new xg();
        xgVar.vUW = d.vHf;
        xgVar.vUX = d.vHe;
        xgVar.vUY = d.vHh;
        xgVar.vUZ = d.vHi;
        xgVar.vVa = w.cfV();
        xgVar.pWp = g.hSi;
        xgVar.vVb = g.njK;
        aVar.hnT = xgVar;
    }
}
