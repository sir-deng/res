package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.sdk.platformtools.bi;
import java.io.UnsupportedEncodingException;

public abstract class f extends a {
    public g mRy;
    public h mRz;

    public f(g gVar) {
        this.mRy = gVar;
    }

    public void a(h hVar) {
        hVar.mRM = e.an(this.mRy.fEe, false);
        hVar.bjW = -5;
    }

    public final boolean execute() {
        g gVar = this.mRy;
        if (!bi.oN(gVar.fEe)) {
            try {
                gVar.fEe = new String(gVar.fEe.getBytes("UTF8"), "UTF8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.mRz = new h(this.mRy);
        try {
            this.mRz.mRL = this;
            a(this.mRz);
            this.mRz.bjW = 0;
            if (this.mRy.handler == null) {
                this.mRy.mRK.b(this.mRz);
            } else {
                this.mRy.handler.post(new Runnable() {
                    public final void run() {
                        f.this.mRy.mRK.b(f.this.mRz);
                    }
                });
            }
            return true;
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                this.mRz.bjW = 1;
            } else {
                this.mRz.bjW = -1;
            }
            throw e2;
        } catch (Throwable th) {
            if (this.mRy.handler == null) {
                this.mRy.mRK.b(this.mRz);
            } else {
                this.mRy.handler.post(/* anonymous class already generated */);
            }
        }
    }
}
