package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.page.n.AnonymousClass18;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class l extends SwipeBackLayout implements a, com.tencent.mm.ui.widget.l.a {
    private View Iv;
    public n isX;
    private boolean jII;
    public boolean mSwiping = false;

    public abstract View aeG();

    public abstract String aeH();

    public abstract p aeO();

    public abstract void b(String str, String str2, int[] iArr);

    public abstract void loadUrl(String str);

    public abstract boolean sk(String str);

    public l(Context context, n nVar) {
        super(context);
        this.isX = nVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        nM(false);
        nL(true);
        this.Iv = aeF();
        ((ViewGroup) this.Iv).addView(aeG(), new LayoutParams(-1, -1));
        addView(this.Iv);
        this.Iv = this.Iv;
        View view = this.Iv;
        boolean acd = this.isX.iuk.isT.iPE.acd();
        b dL = com.tencent.mm.ui.statusbar.a.dL(view);
        if (dL != null) {
            dL.nv(acd);
        }
        this.zFD = this;
    }

    public void cleanup() {
        com.tencent.mm.ui.widget.l.b(this);
    }

    public void aeJ() {
        boolean z = true;
        x.d("MicroMsg.AppBrandPage", "onPageForeground: %s", aeH());
        com.tencent.mm.ui.widget.l.b(this);
        this.zBF = false;
        n nVar = this.isX;
        if (nVar.iuk.YD() == null && nVar.jIM.size() <= 1) {
            if (nVar.iuk.YH()) {
                nVar.ajy().nM(true);
                nVar.ajy().nL(false);
            } else {
                z = false;
            }
        }
        this.mEnable = z;
        onSwipe(1.0f);
        this.jII = false;
        setVisibility(0);
        aeL();
    }

    public void aeK() {
        x.d("MicroMsg.AppBrandPage", "onPageBackground: %s", aeH());
        com.tencent.mm.ui.widget.l.a(this);
        this.jII = true;
    }

    public void aeI() {
        x.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", aeH());
    }

    public final void hide() {
        if (this.jII) {
            setVisibility(4);
        }
    }

    public View aeF() {
        return new b(getContext());
    }

    public final d ajv() {
        return this.isX.iuk.isT.qU(com.tencent.mm.plugin.appbrand.q.l.vh(aeH()));
    }

    public void aeL() {
        d ajv = ajv();
        p aeO = aeO();
        String str = ajv.iQa;
        String str2 = ajv.iPX;
        if (!aeO.jJz) {
            aeO.jJA = j.aM(str, aeO.jJA);
        }
        if (!aeO.jJB) {
            aeO.jJC = str2;
        }
        aeO.S(aeO.jJA, aeO.jJC);
    }

    public void aeM() {
        d ajv = ajv();
        aeO().sn(ajv.iPW);
        aeO().i(ajv.iPY);
        aeO().sm(ajv.iQa);
        aeO().i(ajv.iPY);
        aeO().so(ajv.iPX);
        aeO().jJr.ds(true);
        aeO().cE(ajv.iQf);
        aeO().bh(ajv.iQg, ajv.iPT);
        if (c.b(aeO(), b.jIn)) {
            p aeO = aeO();
            String str = ajv.iQb;
            String str2 = ajv.iQc;
            boolean z = ajv.iQd;
            if (aeO != null) {
                if (bi.oN(str) && bi.oN(str2) && !z) {
                    aeO.jJr.amT();
                } else {
                    b.a(aeO, z);
                }
            }
        }
    }

    private void a(String str, aa aaVar) {
        Map hashMap = new HashMap();
        hashMap.put("path", com.tencent.mm.plugin.appbrand.q.l.vh(aeH()));
        hashMap.put("query", com.tencent.mm.plugin.appbrand.q.l.vi(aeH()));
        if (aaVar != null) {
            hashMap.put("openType", aaVar.toString());
        }
        com.tencent.mm.plugin.appbrand.r.c.m(hashMap);
        aeO().a(str, new JSONObject(hashMap).toString(), null);
    }

    public final void a(aa aaVar) {
        a("onAppRoute", aaVar);
        x.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", aaVar.toString(), aeH());
    }

    public final void ajw() {
        a("onAppRouteDone", null);
        x.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", aeH());
    }

    protected static boolean c(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void onSwipe(float f) {
        if (this.jII) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.n(this.Iv, 0.0f);
            return;
        }
        com.tencent.mm.ui.tools.j.n(this.Iv, (((float) (this.Iv.getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public void onSettle(boolean z, int i) {
        long j = 120;
        View view;
        if (z) {
            view = this.Iv;
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(view, j, 0.0f, null);
            return;
        }
        view = this.Iv;
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(view, j, (float) ((this.Iv.getWidth() * -1) / 4), null);
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onSwipeBack() {
        if (getContext() instanceof MMActivity) {
            ((MMActivity) getContext()).aWY();
        }
        n nVar = this.isX;
        nVar.runOnUiThread(new AnonymousClass18(this));
        com.tencent.mm.plugin.appbrand.report.a.a(this.isX.mAppId, aeH(), 23, null, bi.Wx(), 1, 0);
        MMActivity mMActivity = this.isX.iuk.isO;
        if (mMActivity != null && mMActivity.isFinishing()) {
            mMActivity.onSwipeBack();
        }
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void aeN() {
    }
}
