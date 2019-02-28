package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.q.g;

public final class ad {
    public final f kfj;
    public boolean kfk = false;
    public boolean kfl = false;
    public boolean kfm = false;
    private final a<ViewGroup, f> kfn = new a<ViewGroup, f>() {
        final /* synthetic */ View cb(View view) {
            return (f) view.findViewById(g.iwT);
        }

        final boolean ca(View view) {
            return view.getId() == g.iwS;
        }
    };
    public final a<ViewGroup, r> kfo = new a<ViewGroup, r>() {
        final /* bridge */ /* synthetic */ View cb(View view) {
            return (r) view;
        }

        final boolean ca(View view) {
            return view instanceof r;
        }
    };

    private static abstract class a<Source extends View, Target extends View> {
        private Target oM;

        abstract boolean ca(View view);

        abstract Target cb(View view);

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final Target cc(Source source) {
            if (this.oM != null && z.ak(this.oM)) {
                return this.oM;
            }
            if (source == null || !z.ak(source)) {
                return null;
            }
            for (ViewParent parent = source.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (ca((View) parent)) {
                    Target cb = cb((View) parent);
                    this.oM = cb;
                    return cb;
                }
            }
            return null;
        }
    }

    public ad(f fVar) {
        this.kfj = fVar;
    }
}
