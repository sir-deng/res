package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;

@SuppressLint({"ViewConstructor"})
public final class b extends l {
    private c jdb;
    private String mURL;

    public final /* bridge */ /* synthetic */ p aeO() {
        return this.jdb;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View aeF() {
        return new FrameLayout(getContext());
    }

    protected final View aeG() {
        c cVar = new c(getContext(), this.isX.iuk);
        this.jdb = cVar;
        return cVar.jdd;
    }

    public final void loadUrl(String str) {
        this.mURL = str;
        this.jdb.sl(str);
        aeL();
    }

    public final boolean sk(String str) {
        return true;
    }

    public final void b(String str, String str2, int[] iArr) {
        this.jdb.j(str, str2, 0);
    }

    public final String aeH() {
        return this.mURL;
    }

    public final void cleanup() {
        super.cleanup();
        this.jdb.cleanup();
    }

    protected final void aeI() {
        super.aeI();
        this.jdb.onDestroy();
    }

    public final void aeJ() {
        super.aeJ();
        this.jdb.agq();
    }

    public final void aeK() {
        super.aeK();
        cB(false);
        this.jdb.afQ();
    }

    private void cB(boolean z) {
        if (VERSION.SDK_INT >= 21 && (getContext() instanceof Activity)) {
            Window window = ((Activity) getContext()).getWindow();
            if (window == null) {
                return;
            }
            if (z) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                return;
            }
            window.clearFlags(Integer.MIN_VALUE);
        }
    }

    protected final void aeL() {
        if (this.isX.iuk.isT.iPI.iPN) {
            this.jdb.cD(false);
            cB(true);
            return;
        }
        this.jdb.cD(true);
    }

    protected final void aeM() {
        aeL();
    }

    public final void aeN() {
        if (this.jdb != null) {
            c cVar = this.jdb;
            if (cVar.jde != null) {
                com.tencent.mm.plugin.appbrand.game.b bVar = cVar.jde.jaJ;
            }
        }
    }
}
