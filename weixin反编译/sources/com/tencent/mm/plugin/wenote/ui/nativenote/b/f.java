package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class f {
    public static final int ueu = R.i.dpm;
    public static final int uev = R.i.dpl;
    public static final int uew = R.i.dpj;
    public SparseArray<Integer> uex = new SparseArray();

    public f() {
        this.uex.put(1, Integer.valueOf(ueu));
        this.uex.put(2, Integer.valueOf(uev));
        this.uex.put(4, Integer.valueOf(uev));
        this.uex.put(3, Integer.valueOf(uev));
        this.uex.put(5, Integer.valueOf(uev));
        this.uex.put(6, Integer.valueOf(uev));
        this.uex.put(0, Integer.valueOf(uev));
        this.uex.put(-1, Integer.valueOf(uev));
        this.uex.put(-3, Integer.valueOf(uew));
        this.uex.put(-2, Integer.valueOf(uev));
        this.uex.put(-4, Integer.valueOf(uev));
    }

    public static a a(int i, View view, k kVar) {
        switch (i) {
            case -4:
                return new i(view, kVar);
            case -3:
                return new d(view, kVar);
            case -2:
                return new b(view, kVar);
            case -1:
                return new j(view, kVar);
            case 0:
                return new l(view, kVar);
            case 1:
                return new k(view, kVar);
            case 2:
                return new e(view, kVar);
            case 3:
                return new g(view, kVar);
            case 4:
                return new n(view, kVar);
            case 5:
                return new c(view, kVar);
            case 6:
                return new m(view, kVar);
            default:
                return null;
        }
    }
}
