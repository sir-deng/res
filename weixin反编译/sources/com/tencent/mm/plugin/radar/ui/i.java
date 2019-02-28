package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import b.c.b.e;
import b.c.b.f;
import b.d;
import b.g;
import b.h;
import b.l;

public final class i {

    static final class b extends f implements b.c.a.a<T> {
        final /* synthetic */ int pGf;
        final /* synthetic */ View pGg;

        b(View view, int i) {
            this.pGg = view;
            this.pGf = i;
        }

        public final /* synthetic */ Object invoke() {
            View findViewById = this.pGg.findViewById(this.pGf);
            if (findViewById != null) {
                return findViewById;
            }
            throw new b.i("null cannot be cast to non-null type T");
        }
    }

    static final class a extends f implements b.c.a.a<T> {
        final /* synthetic */ Activity pGe;
        final /* synthetic */ int pGf;

        a(Activity activity, int i) {
            this.pGe = activity;
            this.pGf = i;
        }

        public final /* synthetic */ Object invoke() {
            View findViewById = this.pGe.findViewById(this.pGf);
            if (findViewById != null) {
                return findViewById;
            }
            throw new b.i("null cannot be cast to non-null type T");
        }
    }

    public static final <T extends View> b.b<T> C(View view, int i) {
        e.i(view, "$receiver");
        return a(new b(view, i));
    }

    static final <T> b.b<T> a(b.c.a.a<? extends T> aVar) {
        b.e eVar = b.e.NONE;
        e.i(eVar, "mode");
        e.i(aVar, "initializer");
        switch (d.pDt[eVar.ordinal()]) {
            case 1:
                return new h(aVar);
            case 2:
                return new g(aVar);
            case 3:
                return new l(aVar);
            default:
                throw new b.f();
        }
    }
}
