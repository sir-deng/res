package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class r {
    WeakReference<View> fq;
    final ArrayList<a> jI = new ArrayList();
    a jJ = null;
    Animation jK = null;
    private AnimationListener jL = new AnimationListener() {
        public final void onAnimationEnd(Animation animation) {
            if (r.this.jK == animation) {
                r.this.jK = null;
            }
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    };

    static class a {
        final int[] jN;
        final Animation mAnimation;

        /* synthetic */ a(int[] iArr, Animation animation, byte b) {
            this(iArr, animation);
        }

        private a(int[] iArr, Animation animation) {
            this.jN = iArr;
            this.mAnimation = animation;
        }
    }

    r() {
    }

    public final void a(int[] iArr, Animation animation) {
        a aVar = new a(iArr, animation, (byte) 0);
        animation.setAnimationListener(this.jL);
        this.jI.add(aVar);
    }

    final View ar() {
        return this.fq == null ? null : (View) this.fq.get();
    }
}
