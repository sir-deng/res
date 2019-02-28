package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;

public class j implements e {
    private static j nhq;
    private boolean hlc = false;

    public static j aQL() {
        if (nhq == null) {
            synchronized (j.class) {
                if (nhq == null) {
                    nhq = new j();
                }
            }
        }
        return nhq;
    }

    public final synchronized void fF(boolean z) {
        Object obj;
        if (z) {
            obj = 1;
        } else if (bi.bz(Long.valueOf(bi.c((Long) g.Dq().Db().get(a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(0)))).longValue()) > 86400) {
            int obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (!this.hlc) {
                x.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", Boolean.valueOf(z));
                release();
                this.hlc = true;
                as.CN().a(1311, (e) this);
                as.CN().a(new ay(), 0);
            }
        }
    }

    private void release() {
        this.hlc = false;
        as.CN().b(1311, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1311) {
            x.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            g.Dq().Db().a(a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(bi.Wx()));
            release();
        }
    }
}
