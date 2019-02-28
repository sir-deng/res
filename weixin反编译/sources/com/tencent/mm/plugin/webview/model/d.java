package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.ca;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.b;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.y.as;

public final class d implements c<Integer, Long> {
    public static final String[] gLy = new String[]{i.a(iHi, "JsLogBlockList")};
    private static final a iHi = ca.vQ();
    public final h hiZ;
    public final av<Integer, Long> typ = new av(this, as.Dt().oFY.getLooper(), 100, 20, 300000, 1000);
    private long tyq;

    public d(h hVar) {
        this.hiZ = hVar;
    }

    public final void bRm() {
        this.typ.lL(true);
    }

    public final boolean Tf() {
        if (this.hiZ.inTransaction()) {
            return false;
        }
        this.tyq = this.hiZ.dA(Thread.currentThread().getId());
        if (this.tyq > 0) {
            return true;
        }
        return false;
    }

    public final void a(av<Integer, Long> avVar, b<Integer, Long> bVar) {
        switch (bVar.xpW) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) bVar.vEp);
                contentValues.put("liftTime", (Long) bVar.values);
                this.hiZ.replace("JsLogBlockList", "logId", contentValues);
                return;
            case 2:
                this.hiZ.delete("JsLogBlockList", "logId=" + bVar.vEp, null);
                return;
            default:
                return;
        }
    }

    public final void Tg() {
        if (this.tyq > 0) {
            this.hiZ.fT(this.tyq);
        }
    }
}
