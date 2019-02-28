package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;

public final class s implements e {
    private static boolean bgH = false;
    private static int nhF = 20;
    private static LinkedList<l> nhG = new LinkedList();
    private static ah nhH;
    private int offset = 0;

    public static void update() {
        as.Hm();
        if (!(System.currentTimeMillis() - ((Long) c.Db().get(a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0))).longValue() > 86400000)) {
            x.i("MicroMsg.GameListUpdater", "No need to update");
        } else if (bgH) {
            x.e("MicroMsg.GameListUpdater", "Already running");
        } else {
            nhH = new ah("GameListUpdate");
            nhG.clear();
            e sVar = new s();
            as.CN().a(1215, sVar);
            as.CN().a(new bh(sVar.offset, nhF), 0);
            bgH = true;
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        if (i == 0 && i2 == 0) {
            nhH.F(new Runnable() {
                public final void run() {
                    String str;
                    s.this.offset = s.this.offset + s.nhF;
                    bfx bfx = (bfx) ((bh) kVar).lSH.hnR.hnY;
                    if (bfx == null) {
                        x.e("MicroMsg.NetSceneSearchGameList", "resp == null");
                        str = null;
                    } else {
                        str = bfx.woa;
                    }
                    k lVar = new l(str);
                    lVar.aQM();
                    s.nhG.add(lVar);
                    x.i("MicroMsg.GameListUpdater", "remainingCount: %d", Integer.valueOf(lVar.nhr.optInt("remainingCount")));
                    if (lVar.nhr.optInt("remainingCount") > 0) {
                        as.CN().a(new bh(s.this.offset, s.nhF), 0);
                        return;
                    }
                    s.this.aQS();
                    as.Hm();
                    c.Db().a(a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                    Object ath = s.nhG;
                    if (!bi.cC(ath)) {
                        as.Dt().F(new com.tencent.mm.plugin.game.model.l.AnonymousClass1(ath));
                    }
                }
            });
        } else {
            aQS();
        }
    }

    private void aQS() {
        bgH = false;
        nhH.oFY.quit();
        as.CN().b(1215, (e) this);
    }
}
