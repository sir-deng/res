package com.tencent.mm.plugin.photoedit;

import android.content.Intent;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.ls;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public final class a implements ap {
    c<ls> piT = new c<ls>() {
        {
            this.xmG = ls.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ls) bVar).fDZ.fql == 0) {
                ad.getContext().sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
            }
            return false;
        }
    };

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.piT.cfB();
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        this.piT.dead();
    }
}
