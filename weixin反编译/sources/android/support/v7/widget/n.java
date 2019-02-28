package android.support.v7.widget;

import android.content.Context;
import android.view.View;

final class n implements q {
    n() {
    }

    public final void a(o oVar, Context context, int i, float f, float f2, float f3) {
        oVar.setBackgroundDrawable(new ae(i, f));
        View view = (View) oVar;
        view.setClipToOutline(true);
        view.setElevation(f2);
        ae aeVar = (ae) oVar.getBackground();
        boolean eD = oVar.eD();
        boolean eE = oVar.eE();
        if (!(f3 == aeVar.Wo && aeVar.Wp == eD && aeVar.Wq == eE)) {
            aeVar.Wo = f3;
            aeVar.Wp = eD;
            aeVar.Wq = eE;
            aeVar.f(null);
            aeVar.invalidateSelf();
        }
        if (oVar.eD()) {
            float f4 = ((ae) oVar.getBackground()).Wo;
            float c = c(oVar);
            int ceil = (int) Math.ceil((double) af.b(f4, c, oVar.eE()));
            int ceil2 = (int) Math.ceil((double) af.a(f4, c, oVar.eE()));
            oVar.d(ceil, ceil2, ceil, ceil2);
            return;
        }
        oVar.d(0, 0, 0, 0);
    }

    public final void eF() {
    }

    public final float a(o oVar) {
        return c(oVar) * 2.0f;
    }

    public final float b(o oVar) {
        return c(oVar) * 2.0f;
    }

    private static float c(o oVar) {
        return ((ae) oVar.getBackground()).Wl;
    }
}
