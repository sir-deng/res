package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import java.util.HashMap;

public final class b implements ap {
    private n qaE = new a() {
        public final void eq(int i) {
            if (i == 4) {
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        if (b.this.sgY != null) {
                            b.this.sgY.ja(false);
                        }
                    }
                });
            }
        }
    };
    g sgY;
    private d sgZ = new d();
    public c sha = new c();
    private e shb;
    f shc;

    public static b bFl() {
        as.Hg();
        b bVar = (b) bq.ib("plugin.talkroom");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        as.Hg().a("plugin.talkroom", bVar2);
        return bVar2;
    }

    public static g bFm() {
        if (bFl().sgY == null) {
            bFl().sgY = new g();
        }
        return bFl().sgY;
    }

    public static e bFn() {
        if (bFl().shb == null) {
            bFl().shb = new e();
        }
        return bFl().shb;
    }

    public static String bFo() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FI()).append("talkroom/").toString();
    }

    public static f bFp() {
        if (bFl().shc == null) {
            bFl().shc = new f();
        }
        return bFl().shc;
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(56), this.sgZ);
        as.a(this.qaE);
        q.a.viX = bFn();
        q.a.viY = bFm();
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.ad.d.c.b(Integer.valueOf(56), this.sgZ);
        as.b(this.qaE);
        q.a.viX = null;
        q.a.viY = null;
        if (this.sgY != null) {
            this.sgY.aWG();
            this.sgY = null;
        }
    }
}
