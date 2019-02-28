package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.q.l;

public final class s extends l {
    private p jfF;
    private String mUrl;

    public s(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View aeG() {
        if (this.jfF == null) {
            this.jfF = this.isX.ajz();
        }
        return this.jfF.getContentView();
    }

    public final void loadUrl(String str) {
        if (this.mUrl == null) {
            this.mUrl = str;
            this.jfF.sl(str);
            aeM();
        }
    }

    public final boolean sk(String str) {
        return l.vh(this.mUrl).equals(l.vh(str));
    }

    protected final void aeI() {
        super.aeI();
        this.jfF.onDestroy();
    }

    public final void cleanup() {
        super.cleanup();
        this.jfF.cleanup();
    }

    public final void aeJ() {
        super.aeJ();
        this.jfF.agq();
    }

    public final void aeK() {
        super.aeK();
        this.jfF.afQ();
    }

    public final void b(String str, String str2, int[] iArr) {
        if (l.c(iArr, this.jfF.hashCode())) {
            this.jfF.j(str, str2, 0);
        }
    }

    public final p aeO() {
        return this.jfF;
    }

    public final String aeH() {
        return this.mUrl;
    }
}
