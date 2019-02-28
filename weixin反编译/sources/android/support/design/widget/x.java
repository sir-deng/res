package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class x {
    private static final a lG;

    private interface a {
        void b(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void b(ViewGroup viewGroup, View view, Rect rect) {
            y.b(viewGroup, view, rect);
        }
    }

    private static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void b(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            lG = new c();
        } else {
            lG = new b();
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        lG.b(viewGroup, view, rect);
    }
}
