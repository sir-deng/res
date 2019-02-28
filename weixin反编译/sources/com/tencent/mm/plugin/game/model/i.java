package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.bf;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public class i {
    private static i nhn;
    public bf nho;

    public static i aQI() {
        if (nhn == null) {
            synchronized (i.class) {
                if (nhn == null) {
                    nhn = new i();
                }
            }
        }
        return nhn;
    }

    public final void XQ() {
        c.Dt().F(new Runnable() {
            public final void run() {
                i.this.ay(SubCoreGameCenter.aRO().CC("pb_game_global_config"));
            }
        });
    }

    private synchronized void ay(byte[] bArr) {
        if (!bi.by(bArr)) {
            try {
                this.nho = new bf();
                this.nho.aH(bArr);
            } catch (IOException e) {
                this.nho = null;
                x.e("MicroMsg.GameConfigManager", "Parsing Failed: %s", e.getMessage());
            }
        }
        return;
    }

    public final af aQJ() {
        af afVar = null;
        if (this.nho != null) {
            afVar = this.nho.nnt;
            if (afVar != null) {
                x.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(afVar.nmk), afVar.nkN);
            }
        } else {
            XQ();
        }
        return afVar;
    }

    public final dw aQK() {
        if (this.nho != null) {
            return this.nho.nnv;
        }
        XQ();
        return null;
    }
}
