package android.support.design.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;

final class aa {
    static final d lR = new d() {
        public final u az() {
            return new u(VERSION.SDK_INT >= 12 ? new w() : new v());
        }
    };
    private static final a lS;

    private interface a {
        void u(View view);
    }

    private static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void u(View view) {
        }
    }

    private static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void u(View view) {
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            lS = new c();
        } else {
            lS = new b();
        }
    }

    static void u(View view) {
        lS.u(view);
    }

    static u az() {
        return lR.az();
    }
}
