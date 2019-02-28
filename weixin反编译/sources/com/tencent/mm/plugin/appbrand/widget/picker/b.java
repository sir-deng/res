package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b {
    public a kiC;

    public abstract View agW();

    public final <T extends e> T y(Class<T> cls) {
        d dD = dD(true);
        this.kiC = dD;
        if (dD == null) {
            return null;
        }
        if (!cls.isInstance(dD.kja)) {
            try {
                e eVar = (e) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{dD.getContext()});
                if (dD.kja == null || eVar == null || eVar.getClass() != dD.kja.getClass()) {
                    if (dD.kja != null) {
                        dD.kja.aop();
                    }
                    dD.kja = eVar;
                    if (dD.kja != null) {
                        dD.kja.b(dD);
                    }
                    if (!(dD.kjb == null || dD.kja == null || dD.kja.getView() == null)) {
                        dD.kjb.removeAllViews();
                        dD.aot();
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 17;
                        dD.kjb.addView(dD.kja.getView(), layoutParams);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", cls.getSimpleName(), e);
                return null;
            }
        }
        return dD.kja;
    }

    public final a dD(boolean z) {
        if (this.kiC != null) {
            return this.kiC;
        }
        if (agW() == null) {
            return null;
        }
        View bS = l.bS(agW());
        if (bS == null) {
            return null;
        }
        a ce = a.ce(bS);
        if (ce != null || !z) {
            return ce;
        }
        ce = new a(agW().getContext());
        bS.g(ce, true);
        return ce;
    }
}
