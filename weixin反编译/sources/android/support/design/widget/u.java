package android.support.design.widget;

import android.view.animation.Interpolator;

final class u {
    final e ls;

    interface c {
        void a(u uVar);
    }

    static abstract class e {

        interface a {
            void onAnimationEnd();
        }

        interface b {
            void ay();
        }

        abstract void a(a aVar);

        abstract void a(b bVar);

        abstract int aA();

        abstract float aB();

        abstract void cancel();

        abstract void e(float f, float f2);

        abstract void g(int i, int i2);

        abstract float getAnimatedFraction();

        abstract long getDuration();

        abstract boolean isRunning();

        abstract void setDuration(int i);

        abstract void setInterpolator(Interpolator interpolator);

        abstract void start();

        e() {
        }
    }

    /* renamed from: android.support.design.widget.u$2 */
    class AnonymousClass2 implements a {
        final /* synthetic */ a lv;

        AnonymousClass2(a aVar) {
            this.lv = aVar;
        }

        public final void onAnimationEnd() {
            this.lv.au();
        }
    }

    interface a {
        void au();
    }

    static class b implements a {
        b() {
        }

        public void au() {
        }
    }

    interface d {
        u az();
    }

    u(e eVar) {
        this.ls = eVar;
    }

    public final void setInterpolator(Interpolator interpolator) {
        this.ls.setInterpolator(interpolator);
    }

    public final void a(final c cVar) {
        this.ls.a(new b() {
            public final void ay() {
                cVar.a(u.this);
            }
        });
    }

    public final void g(int i, int i2) {
        this.ls.g(i, i2);
    }

    public final void e(float f, float f2) {
        this.ls.e(f, f2);
    }

    public final void setDuration(int i) {
        this.ls.setDuration(i);
    }
}
