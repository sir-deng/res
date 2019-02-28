package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class c {

    static class b implements b {
        b() {
        }

        public void by(View view) {
            z.b(view, 0.0f);
            z.c(view, 0.0f);
        }

        public final void bz(View view) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            z.b(view, f);
            z.c(view, f2);
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i) {
        }
    }

    static class a implements b {
        a() {
        }

        private static void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public final void by(View view) {
            view.setVisibility(0);
        }

        public final void bz(View view) {
            view.setVisibility(4);
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                a(canvas, recyclerView, view, f, f2);
            }
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i) {
            if (i == 2) {
                a(canvas, recyclerView, view, f, f2);
            }
        }
    }

    static class c extends b {
        c() {
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(android.support.v7.d.a.b.Jr) == null) {
                Float valueOf = Float.valueOf(z.W(view));
                int childCount = recyclerView.getChildCount();
                float f3 = 0.0f;
                int i2 = 0;
                while (i2 < childCount) {
                    float W;
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt != view) {
                        W = z.W(childAt);
                        if (W > f3) {
                            i2++;
                            f3 = W;
                        }
                    }
                    W = f3;
                    i2++;
                    f3 = W;
                }
                z.g(view, 1.0f + f3);
                view.setTag(android.support.v7.d.a.b.Jr, valueOf);
            }
            super.a(canvas, recyclerView, view, f, f2, i, z);
        }

        public final void by(View view) {
            Object tag = view.getTag(android.support.v7.d.a.b.Jr);
            if (tag != null && (tag instanceof Float)) {
                z.g(view, ((Float) tag).floatValue());
            }
            view.setTag(android.support.v7.d.a.b.Jr, null);
            super.by(view);
        }
    }
}
